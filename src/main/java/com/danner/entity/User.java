package com.danner.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLInsert;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * @author jdanner
 * The type User.
 */
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

    private String password;
    private String email;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "modify_date")
    private LocalDate modifyDate;

    @SQLInsert(sql = "SET NOCOUNT ON;")
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "userID")
    private int userID;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Vocalization> vocalizations = new ArrayList<>();

    /**
     * Instantiates a new User.
     */
    public User() {

    }

    /**
     * Instantiates a new User.
     *
     * @param statusCode the status code
     * @param firstName  the first name
     * @param lastName   the last name
     * @param userName   the user name
     * @param password   the password
     * @param email      the email
     */
    public User(String statusCode, String firstName, String lastName, String userName, String password, String email) {
        this.statusCode = statusCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        createDate = LocalDate.now();
    }

    /**
     * Add vocalization.
     *
     * @param vocalization the vocalization
     */
    public void addVocalization(Vocalization vocalization)  {
        vocalizations.add(vocalization);
        vocalization.setUser(this);

    }

    /**
     * Remove vocalization.
     *
     * @param vocalization the vocalization
     */
    public void removeVocalization(Vocalization vocalization)  {
        vocalizations.remove(vocalization);
        vocalization.setUser(null);
    }

    /**
     * Gets status code.
     *
     * @return the status code
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * Sets status code.
     *
     * @param statusCode the status code
     */
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Gets create date.
     *
     * @return the create date
     */
    public LocalDate getCreateDate() {
        return createDate;
    }

    /**
     * Gets modify date.
     *
     * @return the modify date
     */
    public LocalDate getModifyDate() {
        return modifyDate;
    }

    /**
     * Sets modify date.
     *
     * @param modifyDate the modify date
     */
    public void setModifyDate(LocalDate modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * Gets vocalizations.
     *
     * @return the vocalizations
     */
    public List<Vocalization> getVocalizations() {
        return vocalizations;
    }

    /**
     * Sets vocalizations.
     *
     * @param vocalizations the vocalizations
     */
    public void setVocalizations(List<Vocalization> vocalizations) {
        this.vocalizations = vocalizations;
    }

    @Override
    public String toString() {
        return "User{" +
                "statusCode='" + statusCode + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userID=" + userID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userID != user.userID) return false;
        if (statusCode != null ? !statusCode.equals(user.statusCode) : user.statusCode != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (createDate != null ? !createDate.equals(user.createDate) : user.createDate != null) return false;
        return modifyDate != null ? modifyDate.equals(user.modifyDate) : user.modifyDate == null;
    }

    @Override
    public int hashCode() {
        int result = statusCode != null ? statusCode.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + userID;
        return result;
    }
}
