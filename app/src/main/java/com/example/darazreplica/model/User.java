package com.example.darazreplica.model;

public class User {
    private String fullname;
    private String email;
    private String password;
    private String smsCode;
    private String phone;

    public User(String fullname, String email, String password, String smsCode, String phone) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.smsCode = smsCode;
        this.phone = phone;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getFullName() {
        return fullname;
    }

    public void setFullName(String fullName) {
        this.fullname = fullName;
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

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
