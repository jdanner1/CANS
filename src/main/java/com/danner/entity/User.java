package com.danner.entity;

public class User {

    private int userID;
    private String status_code;
    private String first_name;
    private String last_name;
    private String user_name;
    private String password;
    private String email;
    private String cl_password;
    private int cl_accountID;

    public User() {

    }

    public User(int userID, String status_code, String first_name, String last_name, String user_name, String password, String email, String cl_password, int cl_accountID) {

    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCl_password() {
        return cl_password;
    }

    public void setCl_password(String cl_password) {
        this.cl_password = cl_password;
    }

    public int getCl_accountID() {
        return cl_accountID;
    }

    public void setCl_accountID(int cl_accountID) {
        this.cl_accountID = cl_accountID;
    }


}
