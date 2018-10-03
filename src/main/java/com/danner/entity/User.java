package com.danner.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity(name = "User")
@Table(name = "user")
public class User {

    @Column(name = "status_code")
    private String statusCode;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "cl_password")
    private String clPassword;

    @Column(name = "cl_accountID")
    private int clAccountID;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int userID;

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
        return statusCode;
    }

    public void setStatus_code(String status_code) {
        this.statusCode = status_code;
    }

    public String getFirst_name() {
        return firstName;
    }

    public void setFirst_name(String first_name) {
        this.firstName = first_name;
    }

    public String getLast_name() {
        return lastName;
    }

    public void setLast_name(String last_name) {
        this.lastName = last_name;
    }

    public String getUser_name() {
        return userName;
    }

    public void setUser_name(String user_name) {
        this.userName = user_name;
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
        return clPassword;
    }

    public void setCl_password(String cl_password) {
        this.clPassword = cl_password;
    }

    public int getCl_accountID() {
        return clAccountID;
    }

    public void setCl_accountID(int cl_accountID) {
        this.clAccountID = cl_accountID;
    }


}
