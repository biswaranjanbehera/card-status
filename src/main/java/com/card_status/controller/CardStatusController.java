package com.card_status.controller;

import com.card_status.common.Constant;
import com.card_status.response.Response;
import com.card_status.service.CardStatusService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CardStatusController {

    CardStatusService cardStatusService;

    @GetMapping("/get_card_status")
    public ResponseEntity<Response> upload(@RequestParam String cardId) {
        cardStatusService.importDataFromCsvPickupCard(Constant.PICKUP_PATH);
        cardStatusService.importDataFromCsvDelivered(Constant.DELIVERED_PATH);
        cardStatusService.importDataFromCsvDeliveredException(Constant.DELIVER_EXCEPTION_PATH);
        cardStatusService.importDataFromCsvReturned(Constant.RETURNED_PATH);

        Response response = cardStatusService.output(cardId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}