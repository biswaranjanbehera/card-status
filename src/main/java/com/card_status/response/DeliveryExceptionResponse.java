package com.card_status.response;

public class DeliveryExceptionResponse {
    private int count;
    private Comments comment ;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Comments getComment() {
        return comment;
    }

    public void setComment(Comments comment) {
        this.comment = comment;
    }
}
