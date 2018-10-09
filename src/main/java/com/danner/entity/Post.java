package com.danner.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

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

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "modify_date")
    private LocalDate modifyDate;

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
        createDate = LocalDate.now();
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


    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalDate getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDate modifyDate) {
        this.modifyDate = modifyDate;
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
                ", imagePosition=" + imagePosition +
                ", price=" + price +
                ", contactName='" + contactName + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactPhoneExtension='" + contactPhoneExtension + '\'' +
                ", contactTextOk=" + contactTextOk +
                ", seeMyOther=" + seeMyOther +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (postID != post.postID) return false;
        if (outsideContactOk != post.outsideContactOk) return false;
        if (imagePosition != post.imagePosition) return false;
        if (price != post.price) return false;
        if (contactTextOk != post.contactTextOk) return false;
        if (seeMyOther != post.seeMyOther) return false;
        if (!user.equals(post.user)) return false;
        if (statusCode != null ? !statusCode.equals(post.statusCode) : post.statusCode != null) return false;
        if (!title.equals(post.title)) return false;
        if (!description.equals(post.description)) return false;
        if (!categoryCode.equals(post.categoryCode)) return false;
        if (!areaCode.equals(post.areaCode)) return false;
        if (subareaCode != null ? !subareaCode.equals(post.subareaCode) : post.subareaCode != null) return false;
        if (!replyEmail.equals(post.replyEmail)) return false;
        if (!privacyCode.equals(post.privacyCode)) return false;
        if (!locationCity.equals(post.locationCity)) return false;
        if (!locationState.equals(post.locationState)) return false;
        if (!locationPostal.equals(post.locationPostal)) return false;
        if (!locationCrossStreet1.equals(post.locationCrossStreet1)) return false;
        if (!locationCrossStreet2.equals(post.locationCrossStreet2)) return false;
        if (!locationLatitude.equals(post.locationLatitude)) return false;
        if (!locationLongitude.equals(post.locationLongitude)) return false;
        if (image != null ? !image.equals(post.image) : post.image != null) return false;
        if (contactName != null ? !contactName.equals(post.contactName) : post.contactName != null) return false;
        if (contactPhone != null ? !contactPhone.equals(post.contactPhone) : post.contactPhone != null) return false;
        if (contactPhoneExtension != null ? !contactPhoneExtension.equals(post.contactPhoneExtension) : post.contactPhoneExtension != null)
            return false;
        if (createDate != null ? !createDate.equals(post.createDate) : post.createDate != null) return false;
        return modifyDate != null ? modifyDate.equals(post.modifyDate) : post.modifyDate == null;
    }

    @Override
    public int hashCode() {
        int result = postID;
        result = 31 * result + user.hashCode();
        result = 31 * result + (statusCode != null ? statusCode.hashCode() : 0);
        result = 31 * result + title.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + categoryCode.hashCode();
        result = 31 * result + areaCode.hashCode();
        result = 31 * result + (subareaCode != null ? subareaCode.hashCode() : 0);
        result = 31 * result + replyEmail.hashCode();
        result = 31 * result + privacyCode.hashCode();
        result = 31 * result + outsideContactOk;
        result = 31 * result + locationCity.hashCode();
        result = 31 * result + locationState.hashCode();
        result = 31 * result + locationPostal.hashCode();
        result = 31 * result + locationCrossStreet1.hashCode();
        result = 31 * result + locationCrossStreet2.hashCode();
        result = 31 * result + locationLatitude.hashCode();
        result = 31 * result + locationLongitude.hashCode();
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + imagePosition;
        result = 31 * result + price;
        result = 31 * result + (contactName != null ? contactName.hashCode() : 0);
        result = 31 * result + (contactPhone != null ? contactPhone.hashCode() : 0);
        result = 31 * result + (contactPhoneExtension != null ? contactPhoneExtension.hashCode() : 0);
        result = 31 * result + contactTextOk;
        result = 31 * result + seeMyOther;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        return result;
    }
}
