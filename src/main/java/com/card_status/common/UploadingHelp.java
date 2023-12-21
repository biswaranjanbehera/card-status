package com.card_status.common;

import com.card_status.entity.DeliveredCard;
import com.card_status.entity.DeliveredException;
import com.card_status.entity.PickUpCard;
import com.card_status.entity.Returned;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UploadingHelp {


    public static PickUpCard createPickUpCard(String[] data) {
        PickUpCard pickUpCard = new PickUpCard();
        pickUpCard.setId(Integer.parseInt(data[0].trim()));
        pickUpCard.setCard_id(data[1].trim());
        pickUpCard.setUser_mobile(data[2].trim());
        pickUpCard.setTimestamp(parseTimestamp(data[3].trim(),"dd-MM-yyyy HH:mm"));
        return pickUpCard;
    }
    public static DeliveredCard createDeliveredCard(String[] data) {
        DeliveredCard deliveredCard = new DeliveredCard();
        deliveredCard.setId(data[0].trim());
        deliveredCard.setCard_id(data[1].trim());
        deliveredCard.setUser_contact(data[2].trim());
        deliveredCard.setTimestamp(parseTimestamp(data[3].trim(),"yyyy-MM-dd'T'HH:mm:ssX"));
        deliveredCard.setComment(data[4].trim());
        return deliveredCard;
    }
    public static DeliveredException createDeliveredException(String[] data) {
        DeliveredException deliveredException = new DeliveredException();
        deliveredException.setId(data[0].trim());
        deliveredException.setCard_id(data[1].trim());
        deliveredException.setUser_contact(data[2].trim());
        deliveredException.setTimestamp(parseTimestamp(data[3].trim(),"dd-MM-yyyy HH:mm"));
        deliveredException.setComment(data[4].trim());
        return deliveredException;
    }

    public static Returned createReturned(String[] data) {
        Returned returned = new Returned();
        returned.setId(data[0].trim());
        returned.setCard_id(data[1].trim());
        returned.setUser_contact(data[2].trim());
        returned.setTimestamp(parseTimestamp(data[3].trim(),"dd-MM-yyyy HH:mm"));
        return returned;
    }
    public static Timestamp parseTimestamp(String timestampString,String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            Date parsedDate = dateFormat.parse(timestampString);
            return new Timestamp(parsedDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // Handle parsing error accordingly
        }
    }

}
