package com.card_status.testing;
import com.card_status.common.UploadingHelp;
import com.card_status.entity.DeliveredCard;
import com.card_status.entity.DeliveredException;
import com.card_status.entity.PickUpCard;
import com.card_status.entity.Returned;
import com.card_status.repositories.DeliveredCardRepositories;
import com.card_status.repositories.DeliveredExceptionRepositories;
import com.card_status.repositories.PickupRepositories;
import com.card_status.repositories.ReturnedRepositories;
import com.card_status.response.Response;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TestService {
    @Autowired
    PickupRepositories pickupRepositories;
    @Autowired
    DeliveredCardRepositories deliveredCardRepositories;
    @Autowired
    DeliveredExceptionRepositories deliveredExceptionRepositories;
    @Autowired
    ReturnedRepositories returnedRepositories;
    @PersistenceContext
    private EntityManager entityManager;

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

    }


}
