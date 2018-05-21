package com.hipasserby.request;

public class ActivationUserRequest {

    private String email;

    private String randomTokenOfActivation;

    public ActivationUserRequest() {
    }

    public ActivationUserRequest(String email, String randomTokenOfActivation) {
        this.email = email;
        this.randomTokenOfActivation = randomTokenOfActivation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRandomTokenOfActivation() {
        return randomTokenOfActivation;
    }

    public void setRandomTokenOfActivation(String randomTokenOfActivation) {
        this.randomTokenOfActivation = randomTokenOfActivation;
    }

    @Override
    public String toString() {
        return "ActivationUserRequest{" +
                "email='" + email + '\'' +
                ", randomTokenOfActivation='" + randomTokenOfActivation + '\'' +
                '}';
    }
}
