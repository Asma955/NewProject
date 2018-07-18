package com.waddimakka.asma.newproject.model;

public class user
{
    private String UserName;
    private String Email;
    private String PassWord;
    private String PhoneNumber;

    public user(String userName, String email, String passWord, String phoneNumber) {

        UserName = userName;
        Email = email;
        PassWord = passWord;
        PhoneNumber = phoneNumber;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
