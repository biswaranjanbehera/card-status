package com.card_status.response;

import java.util.List;

public class DeliveryExceptionResponse {
    private int count;
    private List<Comments> comment ;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Comments> getComment() {
        return comment;
    }

    public void setComment(List<Comments> comment) {
        this.comment = comment;
    }
}
