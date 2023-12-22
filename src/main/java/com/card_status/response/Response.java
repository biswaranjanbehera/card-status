package com.card_status.response;

import java.sql.Timestamp;

public class Response {
    private String card_id;
    private Timestamp pickup_card_timestamp;
    private DeliveryExceptionResponse deliveryExceptionResponse;
    private Timestamp returned_timestamp;
    private Timestamp delivered_card_timestamp;
    private String current_status;

    public Timestamp getPickup_card_timestamp() {
        return pickup_card_timestamp;
    }

    public void setPickup_card_timestamp(Timestamp pickup_card_timestamp) {
        this.pickup_card_timestamp = pickup_card_timestamp;
    }

    public DeliveryExceptionResponse getDeliveryExceptionResponse() {
        return deliveryExceptionResponse;
    }

    public void setDeliveryExceptionResponse(DeliveryExceptionResponse deliveryExceptionResponse) {
        this.deliveryExceptionResponse = deliveryExceptionResponse;
    }

    public Timestamp getReturned_timestamp() {
        return returned_timestamp;
    }

    public void setReturned_timestamp(Timestamp returned_timestamp) {
        this.returned_timestamp = returned_timestamp;
    }

    public Timestamp getDelivered_card_timestamp() {
        return delivered_card_timestamp;
    }

    public void setDelivered_card_timestamp(Timestamp delivered_card_timestamp) {
        this.delivered_card_timestamp = delivered_card_timestamp;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getCurrent_status() {
        return current_status;
    }

    public void setCurrent_status(String current_status) {
        this.current_status = current_status;
    }
}
