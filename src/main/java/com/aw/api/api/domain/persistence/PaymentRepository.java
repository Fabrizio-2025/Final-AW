package com.aw.api.api.domain.persistence;

import com.aw.api.api.domain.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    List<Payment> findAll();
    Optional<Payment> findById(Long paymentId);
    boolean existsById(Long paymentId);
}
