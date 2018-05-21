package com.hipasserby.request.editUsersInformation;

public class EditUserPhotoRequest {

    private String photo;

    public EditUserPhotoRequest() {
    }

    public EditUserPhotoRequest(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "EditUserPhotoRequest{" +
                "photo='" + photo + '\'' +
                '}';
    }
}
