package com.hipasserby.request.editUsersInformation;

public class EducationInformationAboutUserRequest {

    private String school;

    private String university;

    public EducationInformationAboutUserRequest() {
    }

    public EducationInformationAboutUserRequest(String school, String university) {
        this.school = school;
        this.university = university;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "EducationInformationAboutUserRequest{" +
                "school='" + school + '\'' +
                ", university='" + university + '\'' +
                '}';
    }
}
