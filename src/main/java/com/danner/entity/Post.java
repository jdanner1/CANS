package com.danner.entity;

public class Post {

    private int postID;
    private int userID;
    private String status_code;
    private String title;
    private String description;
    private String category_code;
    private String area_code;
    private String subarea_code;
    private String replyemail;
    private String privacy_code;
    private int outsidecontactok;
    private String location_city;
    private String location_state;
    private String location_postal;
    private String location_crossstreet1;
    private String location_crossstreet2;
    private String location_latitude;
    private String location_longitude;
    private String image;
    private int image_postion;
    private int price;
    private String contact_name;
    private String contact_phone;
    private String contact_phone_extension;
    private int contacttextok;
    private int seemyother;

    public Post() {

    }

    public Post(int postID, int userID, String status_code, String title, String description, String category_code, String area_code, String subarea_code, String replyemail, String privacy_code,
                int outsidecontactok, String location_city, String location_state, String location_postal, String location_crossstreet1, String location_crossstreet2, String location_latitude,
                String location_longitude, String image, int image_postion, int price, String contact_name, String contact_phone, String contact_phone_extension, int contacttextok, int seemyother) {

    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
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

    public String getCategory_code() {
        return category_code;
    }

    public void setCategory_code(String category_code) {
        this.category_code = category_code;
    }

    public String getArea_code() {
        return area_code;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }

    public String getSubarea_code() {
        return subarea_code;
    }

    public void setSubarea_code(String subarea_code) {
        this.subarea_code = subarea_code;
    }

    public String getReplyemail() {
        return replyemail;
    }

    public void setReplyemail(String replyemail) {
        this.replyemail = replyemail;
    }

    public String getPrivacy_code() {
        return privacy_code;
    }

    public void setPrivacy_code(String privacy_code) {
        this.privacy_code = privacy_code;
    }

    public int getOutsidecontactok() {
        return outsidecontactok;
    }

    public void setOutsidecontactok(int outsidecontactok) {
        this.outsidecontactok = outsidecontactok;
    }

    public String getLocation_city() {
        return location_city;
    }

    public void setLocation_city(String location_city) {
        this.location_city = location_city;
    }

    public String getLocation_state() {
        return location_state;
    }

    public void setLocation_state(String location_state) {
        this.location_state = location_state;
    }

    public String getLocation_postal() {
        return location_postal;
    }

    public void setLocation_postal(String location_postal) {
        this.location_postal = location_postal;
    }

    public String getLocation_crossstreet1() {
        return location_crossstreet1;
    }

    public void setLocation_crossstreet1(String location_crossstreet1) {
        this.location_crossstreet1 = location_crossstreet1;
    }

    public String getLocation_crossstreet2() {
        return location_crossstreet2;
    }

    public void setLocation_crossstreet2(String location_crossstreet2) {
        this.location_crossstreet2 = location_crossstreet2;
    }

    public String getLocation_latitude() {
        return location_latitude;
    }

    public void setLocation_latitude(String location_latitude) {
        this.location_latitude = location_latitude;
    }

    public String getLocation_longitude() {
        return location_longitude;
    }

    public void setLocation_longitude(String location_longitude) {
        this.location_longitude = location_longitude;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getImage_postion() {
        return image_postion;
    }

    public void setImage_postion(int image_postion) {
        this.image_postion = image_postion;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }

    public String getContact_phone_extension() {
        return contact_phone_extension;
    }

    public void setContact_phone_extension(String contact_phone_extension) {
        this.contact_phone_extension = contact_phone_extension;
    }

    public int getContacttextok() {
        return contacttextok;
    }

    public void setContacttextok(int contacttextok) {
        this.contacttextok = contacttextok;
    }

    public int getSeemyother() {
        return seemyother;
    }

    public void setSeemyother(int seemyother) {
        this.seemyother = seemyother;
    }

}
