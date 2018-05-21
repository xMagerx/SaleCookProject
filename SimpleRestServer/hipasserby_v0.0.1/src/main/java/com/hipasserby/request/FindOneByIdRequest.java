package com.hipasserby.request;

import javax.validation.constraints.NotNull;

public class FindOneByIdRequest {

    @NotNull
    private int id;

    public FindOneByIdRequest() {
    }

    public FindOneByIdRequest(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FindOneByIdRequest{" +
                "id=" + id +
                '}';
    }
}
