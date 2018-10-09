package com.danner.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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

    @Column(name = "cl_password")
    private String clPassword;

    @Column(name = "cl_accountID")
    private int clAccountID;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "modify_date")
    private LocalDate modifyDate;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "userID")
    private int userID;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Post> posts = new HashSet<>();

    public User() {

    }

    public User(String statusCode, String firstName, String lastName, String userName, String password, String email, String clPassword, int clAccountID) {
        this.statusCode = statusCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.clPassword = clPassword;
        this.clAccountID = clAccountID;
        createDate = LocalDate.now();
    }

    public void addPost(Post post)  {
        posts.add(post);
        post.setUser(this);

    }

    public void removePost(Post post)  {
        posts.remove(post);
        post.setUser(null);
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getClPassword() {
        return clPassword;
    }

    public void setClPassword(String clPassword) {
        this.clPassword = clPassword;
    }

    public int getClAccountID() {
        return clAccountID;
    }

    public void setClAccountID(int clAccountID) {
        this.clAccountID = clAccountID;
    }

    public int getUserID() {
        return userID;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalDate getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDate modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
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
                ", clPassword='" + clPassword + '\'' +
                ", clAccountID=" + clAccountID +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", userID=" + userID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (clAccountID != user.clAccountID) return false;
        if (userID != user.userID) return false;
        if (statusCode != null ? !statusCode.equals(user.statusCode) : user.statusCode != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (!userName.equals(user.userName)) return false;
        if (!password.equals(user.password)) return false;
        if (!email.equals(user.email)) return false;
        if (!clPassword.equals(user.clPassword)) return false;
        if (createDate != null ? !createDate.equals(user.createDate) : user.createDate != null) return false;
        return modifyDate != null ? modifyDate.equals(user.modifyDate) : user.modifyDate == null;
    }

    @Override
    public int hashCode() {
        int result = statusCode != null ? statusCode.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + userName.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + clPassword.hashCode();
        result = 31 * result + clAccountID;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + userID;
        return result;
    }
}
