package com.assignment.paymentService.mapper;

import com.assignment.paymentService.dto.PaymentDTO;
import com.assignment.paymentService.entity.TransactionDetailsEntity;

public class CustomMapper {

    public static TransactionDetailsEntity convertDTOToEntity(PaymentDTO paymentDTO) {

        TransactionDetailsEntity transactionEntity = new TransactionDetailsEntity();
        transactionEntity.setBookingId(paymentDTO.getBookingId());
        transactionEntity.setPaymentMode(paymentDTO.getPaymentMode());
        transactionEntity.setUpiId(paymentDTO.getUpiId());
        transactionEntity.setCardNumber(paymentDTO.getCardNumber());
        return transactionEntity;
    }

    public static PaymentDTO convertEntityToDTO(TransactionDetailsEntity transactionEntity) {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setId(transactionEntity.getTransactionId());
        paymentDTO.setPaymentMode(transactionEntity.getPaymentMode());
        paymentDTO.setBookingId(transactionEntity.getBookingId());
        paymentDTO.setUpiId(transactionEntity.getUpiId());
        paymentDTO.setCardNumber(transactionEntity.getCardNumber());
        return paymentDTO;
    }
}
