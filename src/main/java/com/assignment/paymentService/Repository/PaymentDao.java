package com.assignment.paymentService.Repository;

import com.assignment.paymentService.entity.TransactionDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDao extends JpaRepository<TransactionDetailsEntity,Integer> {
}
