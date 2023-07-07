package com.aw.api.api.service;

import com.aw.api.api.domain.model.entity.*;
import com.aw.api.api.domain.persistence.PaymentRepository;
import com.aw.api.api.domain.service.PaymentService;
import com.aw.api.shared.exception.ResourceNotFoundException;
import com.aw.api.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PaymentServiceImpl implements PaymentService {
    private static final String entity = "Payment";
    private final PaymentRepository paymentRepository;
    private final Validator validator;

    public PaymentServiceImpl(PaymentRepository paymentRepository, Validator validator){
        this.paymentRepository = paymentRepository;
        this.validator = validator;
    }

    @Override
    public List<Payment> getAll(){
        return paymentRepository.findAll();
    }

    @Override
    public Payment getById(Long paymentId) {
        return paymentRepository.findById(paymentId).orElseThrow(() -> new ResourceNotFoundException(entity, paymentId));
    }

    @Override
    public Payment create(Payment payment) {
        Set<ConstraintViolation<Payment>> violations = validator.validate(payment);
        if(!violations.isEmpty())
            throw new ResourceValidationException(entity, violations);
        return paymentRepository.save(payment);
    }

    public Payment update(Long paymentId, Payment updatedpayment) {
        Set<ConstraintViolation<Payment>> violations = validator.validate(updatedpayment);
        if(!violations.isEmpty())
            throw new ResourceValidationException(entity, violations);
        if(!paymentRepository.existsById(paymentId))
            throw new ResourceValidationException("payment does not exist.");

        Payment existingpayment = paymentRepository.findById(paymentId).get();



        return paymentRepository.save(existingpayment
                .withMonth(updatedpayment.getMonth())
                .withYear(updatedpayment.getYear())
                .withAmount(updatedpayment.getAmount())
                .withStatus(updatedpayment.getStatus())

        );
    }

    @Override
    public ResponseEntity<?> delete(Long paymentId) {
        return paymentRepository.findById(paymentId).map(payment -> {
            paymentRepository.delete(payment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(entity, paymentId));
    }
}
