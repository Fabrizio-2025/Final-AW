package com.aw.api.api.domain.service;

import com.aw.api.api.domain.model.entity.Payment;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PaymentService {
    List<Payment> getAll();

    Payment getById(Long PaymentId);

    Payment create(Payment savePayment);

    ResponseEntity<?> delete(Long id);

    Payment update(Long id, Payment updatedPayment);
}
