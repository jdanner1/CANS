package com.danner.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "Post")
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "postID")
    private int postID;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    @Column(name = "status_code")
    private String statusCode;

    private String title;

    private String description;

    @Column(name = "category_code")
    private String categoryCode;

    @Column(name = "area_code")
    private String areaCode;

    @Column(name = "subarea_code")
    private String subareaCode;

    @Column(name = "replyemail")
    private String replyEmail;

    @Column(name = "privacy_code")
    private String privacyCode;

    @Column(name = "outsidecontactok")
    private int outsideContactOk;

    @Column(name = "location_city")
    private String locationCity;

    @Column(name = "location_state")
    private String locationState;

    @Column(name = "location_postal")
    private String locationPostal;

    @Column(name = "location_crossstreet1")
    private String locationCrossStreet1;

    @Column(name = "location_crossstreet2")
    private String locationCrossStreet2;

    @Column(name = "location_latitude")
    private String locationLatitude;

    @Column(name = "location_longitude")
    private String locationLongitude;

    private String image;

    @Column(name = "image_position")
    private int imagePosition;

    private int price;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "contact_phone_extension")
    private String contactPhoneExtension;

    @Column(name = "contacttextok")
    private int contactTextOk;

    @Column(name = "seemyother")
    private int seeMyOther;

    public Post() {

    }

    public Post(User user, String statusCode, String title, String description, String categoryCode, String areaCode, String subareaCode, String replyEmail,
                String privacyCode, int outsideContactOk, String locationCity, String locationState, String locationPostal, String locationCrossStreet1, String locationCrossStreet2,
                String locationLatitude, String locationLongitude, String image, int imagePosition, int price, String contactName, String contactPhone, String contactPhoneExtension,
                int contactTextOk, int seeMyOther) {

        this.user = user;
        this.statusCode = statusCode;
        this.title = title;
        this.description = description;
        this.categoryCode = categoryCode;
        this.areaCode = areaCode;
        this.subareaCode = subareaCode;
        this.replyEmail = replyEmail;
        this.privacyCode = privacyCode;
        this.outsideContactOk = outsideContactOk;
        this.locationCity = locationCity;
        this.locationState = locationState;
        this.locationPostal = locationPostal;
        this.locationCrossStreet1 = locationCrossStreet1;
        this.locationCrossStreet2 = locationCrossStreet2;
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
        this.image = image;
        this.imagePosition = imagePosition;
        this.price = price;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.contactPhoneExtension = contactPhoneExtension;
        this.contactTextOk = contactTextOk;
        this.seeMyOther = seeMyOther;
    }

    public int getPostID() {
        return postID;
    } //removed setPostID since the db does this, assume ok

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getSubareaCode() {
        return subareaCode;
    }

    public void setSubareaCode(String subareaCode) {
        this.subareaCode = subareaCode;
    }

    public String getReplyEmail() {
        return replyEmail;
    }

    public void setReplyEmail(String replyEmail) {
        this.replyEmail = replyEmail;
    }

    public String getPrivacyCode() {
        return privacyCode;
    }

    public void setPrivacyCode(String privacyCode) {
        this.privacyCode = privacyCode;
    }

    public int getOutsideContactOk() {
        return outsideContactOk;
    }

    public void setOutsideContactOk(int outsideContactOk) {
        this.outsideContactOk = outsideContactOk;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationState() {
        return locationState;
    }

    public void setLocationState(String locationState) {
        this.locationState = locationState;
    }

    public String getLocationPostal() {
        return locationPostal;
    }

    public void setLocationPostal(String locationPostal) {
        this.locationPostal = locationPostal;
    }

    public String getLocationCrossStreet1() {
        return locationCrossStreet1;
    }

    public void setLocationCrossStreet1(String locationCrossStreet1) {
        this.locationCrossStreet1 = locationCrossStreet1;
    }

    public String getLocationCrossStreet2() {
        return locationCrossStreet2;
    }

    public void setLocationCrossStreet2(String locationCrossStreet2) {
        this.locationCrossStreet2 = locationCrossStreet2;
    }

    public String getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(String locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public String getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(String locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getImagePostion() {
        return imagePosition;
    }

    public void setImagePostion(int imagePostion) {
        this.imagePosition = imagePostion;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactPhoneExtension() {
        return contactPhoneExtension;
    }

    public void setContactPhoneExtension(String contactPhoneExtension) {
        this.contactPhoneExtension = contactPhoneExtension;
    }

    public int getContactTextOk() {
        return contactTextOk;
    }

    public void setContactTextOk(int contactTextOk) {
        this.contactTextOk = contactTextOk;
    }

    public int getSeeMyOther() {
        return seeMyOther;
    }

    public void setSeeMyOther(int seeMyOther) {
        this.seeMyOther = seeMyOther;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postID=" + postID +
                ", user=" + user +
                ", statusCode='" + statusCode + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", subareaCode='" + subareaCode + '\'' +
                ", replyEmail='" + replyEmail + '\'' +
                ", privacyCode='" + privacyCode + '\'' +
                ", outsideContactOk=" + outsideContactOk +
                ", locationCity='" + locationCity + '\'' +
                ", locationState='" + locationState + '\'' +
                ", locationPostal='" + locationPostal + '\'' +
                ", locationCrossStreet1='" + locationCrossStreet1 + '\'' +
                ", locationCrossStreet2='" + locationCrossStreet2 + '\'' +
                ", locationLatitude='" + locationLatitude + '\'' +
                ", locationLongitude='" + locationLongitude + '\'' +
                ", image='" + image + '\'' +
                ", imagePostion=" + imagePosition +
                ", price=" + price +
                ", contactName='" + contactName + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactPhoneExtension='" + contactPhoneExtension + '\'' +
                ", contactTextOk=" + contactTextOk +
                ", seeMyOther=" + seeMyOther +
                '}';
    }
}
