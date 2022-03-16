package com.assignment.paymentService.controller;

import com.assignment.paymentService.dto.PaymentDTO;
import com.assignment.paymentService.entity.TransactionDetailsEntity;
import com.assignment.paymentService.mapper.CustomMapper;
import com.assignment.paymentService.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * rest controller - handles incoming request to the application
 */

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private PaymentService paymentService;

    /**
     * validates and saves transaction details in DB
     *
     * @return transaction ID
     */
    @PostMapping(value = "/transaction", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> processTransaction(@RequestBody PaymentDTO paymentDTO) {
        TransactionDetailsEntity transaction = CustomMapper.convertDTOToEntity(paymentDTO);
        int transactionID = paymentService.savePaymentDetails(transaction);
        return new ResponseEntity<>(transactionID, HttpStatus.CREATED);
    }

    /**
     * Fetches transaction details
     *
     * @return payment details json
     */
    @GetMapping(value = "/transaction/{transactionId}")
    public ResponseEntity<PaymentDTO> getTransactionDetails(@PathVariable(name = "transactionId") int transactionId) {
        TransactionDetailsEntity transaction = paymentService.getTransactionDetails(transactionId);
        PaymentDTO paymentDetails = CustomMapper.convertEntityToDTO(transaction);
        return new ResponseEntity<>(paymentDetails, HttpStatus.OK);
    }

}
