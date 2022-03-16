package com.assignment.paymentService.service;

import com.assignment.paymentService.Repository.PaymentDao;
import com.assignment.paymentService.entity.TransactionDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;

    @Override
    public int savePaymentDetails(TransactionDetailsEntity paymentDetails) {
        return paymentDao.save(paymentDetails).getTransactionId();
    }

    @Override
    public TransactionDetailsEntity getTransactionDetails(int transactionID) {
        return paymentDao.findById(transactionID).get();
    }

}
