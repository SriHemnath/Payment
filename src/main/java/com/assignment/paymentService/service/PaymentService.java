package com.assignment.paymentService.service;

import com.assignment.paymentService.entity.TransactionDetailsEntity;

public interface PaymentService {
    int savePaymentDetails(TransactionDetailsEntity paymentDetails);
    TransactionDetailsEntity getTransactionDetails(int transactionID);
}
