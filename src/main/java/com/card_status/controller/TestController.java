package com.card_status.controller;

import com.card_status.response.Response;
import com.card_status.testing.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    public TestService testService;

    @GetMapping("/upload")
    public String upload() {
        String pickupPath = "E:/Project/Card_status/Getting-the-card-status/Getting-the-card-status/csv_file/Pickup_Sample_card.csv";
        String deliveredPath = "E:/Project/Card_status/Getting-the-card-status/Getting-the-card-status/csv_file/Delivered_Sample_card.csv";
        String deliverExceptionPath = "E:/Project/Card_status/Getting-the-card-status/Getting-the-card-status/csv_file/Delivery_exception_Sample_card.csv";
        String returnedPath = "E:/Project/Card_status/Getting-the-card-status/Getting-the-card-status/csv_file/Returned_Sample_card.csv";

        testService.importDataFromCsvPickupCard(pickupPath);
        testService.importDataFromCsvDelivered(deliveredPath);
        testService.importDataFromCsvDeliveredException(deliverExceptionPath);
        testService.importDataFromCsvReturned(returnedPath);

        String cardId = "";
        Response response = testService.output(cardId);
        return "upload";
    }
}