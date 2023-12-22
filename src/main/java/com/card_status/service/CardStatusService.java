package com.card_status.service;
import com.card_status.common.UploadingHelp;
import com.card_status.entity.*;
import com.card_status.repositories.*;
import com.card_status.response.Comments;
import com.card_status.response.DeliveryExceptionResponse;
import com.card_status.response.Response;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CardStatusService {
    PickupRepositories pickupRepositories;
    DeliveredCardRepositories deliveredCardRepositories;
    DeliveredExceptionRepositories deliveredExceptionRepositories;
    ReturnedRepositories returnedRepositories;
    CurrentStatusRepositories currentStatusRepositories;
    @Transactional
    public void importDataFromCsvPickupCard(String csvFilePath) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            List<String[]> lines = reader.readAll();
            int c =  0;
            for (String[] data : lines) {
                if(c==0){
                    c++;
                    continue;
                }
                PickUpCard pickUpCard = UploadingHelp.createPickUpCard(data);
                pickupRepositories.save(pickUpCard);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void importDataFromCsvDelivered(String csvFilePath) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            List<String[]> lines = reader.readAll();
            int c =  0;
            for (String[] data : lines) {
                if(c==0){
                    c++;
                    continue;
                }
                DeliveredCard deliveredCard = UploadingHelp.createDeliveredCard(data);
                deliveredCardRepositories.save(deliveredCard);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void importDataFromCsvDeliveredException(String csvFilePath) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            List<String[]> lines = reader.readAll();
            int c =  0;
            for (String[] data : lines) {
                if(c==0){
                    c++;
                    continue;
                }
                DeliveredException deliveredException = UploadingHelp.createDeliveredException(data);
                deliveredExceptionRepositories.save(deliveredException);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void importDataFromCsvReturned(String csvFilePath) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            List<String[]> lines = reader.readAll();
            int c =  0;
            for (String[] data : lines) {
                if(c==0){
                    c++;
                    continue;
                }
                Returned returned = UploadingHelp.createReturned(data);
                returnedRepositories.save(returned);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    public Response output(String cardId){
        Response response = new Response();
        String current_status = "";
        Timestamp last_updated_time = null;
        Optional<PickUpCard> optionalPickUpCard = pickupRepositories.findByCard_id(cardId);
        if (optionalPickUpCard.isPresent()) {
            PickUpCard pickUpCard = optionalPickUpCard.get();
            Timestamp pickup_card_timestamp = pickUpCard.getTimestamp();
            response.setPickup_card_timestamp(pickup_card_timestamp);
            current_status = "pickup card";
            last_updated_time = pickup_card_timestamp;
        } else {
            System.out.println("Card with ID in pickup card " + cardId + " not found.");
        }

        //---------------
        Optional<DeliveredException> deliveryException = deliveredExceptionRepositories.findByCard_id(cardId);
        if(deliveryException.isPresent()){
            DeliveryExceptionResponse deliveryExceptionResponse = new DeliveryExceptionResponse();
            int count = deliveredExceptionRepositories.countByCardId(cardId);
            deliveryExceptionResponse.setCount(count);

            List<DeliveredException> allExceptionsForCardId = deliveredExceptionRepositories.findAllByCard_id(cardId);
            List<Comments> commentsList = new ArrayList<>();
            Timestamp latestTimestamp = null;
            for (DeliveredException exception : allExceptionsForCardId) {
                Comments comments = new Comments();
                comments.setTimestamp(exception.getTimestamp());
                comments.setComment(exception.getComment());
                commentsList.add(comments);
                latestTimestamp = exception.getTimestamp();
            }
            deliveryExceptionResponse.setComment(commentsList);
            response.setDeliveryExceptionResponse(deliveryExceptionResponse);
            current_status = "deliverd exception occures";
            last_updated_time = latestTimestamp;
        } else {
            System.out.println("Card with ID in delivered exception " + cardId + " not found.");
        }
        //----------------------------------
        Optional<Returned> opionalReturned = returnedRepositories.findByCard_id(cardId);
        if(opionalReturned.isPresent()){
            Returned returned = opionalReturned.get();
            Timestamp returnedTimestamp = returned.getTimestamp();
            response.setReturned_timestamp(returnedTimestamp);
            current_status = "returened status";
            last_updated_time = returnedTimestamp;
        }else {
            System.out.println("Card with ID in returned " + cardId + " not found.");
        }
        //-----------------------------
        Optional<DeliveredCard> optionalDeliveredCard = deliveredCardRepositories.findByCard_id(cardId);
        if(optionalDeliveredCard.isPresent()){
            DeliveredCard deliveredCard = optionalDeliveredCard.get();
            Timestamp deliveredCardTimstamp = deliveredCard.getTimestamp();
            response.setDelivered_card_timestamp(deliveredCardTimstamp);
            current_status = "delivered status";
            last_updated_time = deliveredCardTimstamp;
        }else {
            System.out.println("Card with ID in deliverd card " + cardId + " not found.");
        }

        //---------------------------current status
        response.setCurrent_status(current_status);
        saveInDbCurrentStatus(cardId,current_status,last_updated_time);
        response.setCard_id(cardId);
        return response;
    }

    public void saveInDbCurrentStatus(String cardId,String current_status,Timestamp lastUpdateBy){
        CurrentStatus currentStatus = new CurrentStatus();
        currentStatus.setCard_id(cardId);
        currentStatus.setStatus(current_status);
        currentStatus.setLast_update(lastUpdateBy);

        currentStatusRepositories.save(currentStatus);
    }


}
