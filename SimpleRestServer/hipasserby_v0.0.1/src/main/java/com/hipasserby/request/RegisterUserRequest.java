package com.hipasserby.request;

import com.hipasserby.entity.enums.Flag;
import com.hipasserby.entity.enums.Role;
import com.hipasserby.entity.enums.Sex;

import java.util.Random;

public class RegisterUserRequest {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String repeatPassword;

    private Role role = Role.ROLE_USER;

    private Sex sex;

    private String photo = "/images/0.gif";

    private Flag flag = Flag.USER_UNACTIVATED;

    private String randomTokenOfActivation = generateString();

    public RegisterUserRequest() {
    }

    public RegisterUserRequest(String firstName, String lastName,
                               String email, String password, String repeatPassword,Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.sex = sex;
    }

    public RegisterUserRequest(String firstName, String lastName, String email, String password, String repeatPassword, Role role, Sex sex, String photo, Flag flag, String randomTokenOfActivation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.role = role;
        this.sex = sex;
        this.photo = photo;
        this.flag = flag;
        this.randomTokenOfActivation = randomTokenOfActivation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Flag getFlag() {
        return flag;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }

    public String getRandomTokenOfActivation() {
        return randomTokenOfActivation;
    }

    public void setRandomTokenOfActivation(String randomTokenOfActivation) {
        this.randomTokenOfActivation = randomTokenOfActivation;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "RegisterUserRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", repeatPassword='" + repeatPassword + '\'' +
                ", role=" + role +
                ", sex=" + sex +
                ", photo='" + photo + '\'' +
                ", flag=" + flag +
                ", randomTokenOfActivation='" + randomTokenOfActivation + '\'' +
                '}';
    }

    public String generateString()
    {
        String characters = "qwertyuiopasdfghjklzxcvbnm1234567890QWERTYUIOASDFGHJKLZXCVBNM";
        Random rnd = new Random();
        char[] text = new char[15];
        for (int i = 0; i < text.length; i++)
        {
            text[i] = characters.charAt(rnd.nextInt(characters.length()));
        }
        return new String(text);
    }
}
