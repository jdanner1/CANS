package com.danner.persistence;

import com.danner.entity.Post;
import com.danner.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PostDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    PostDao dao;
    UserDao userDao;

    @BeforeEach
    void setUp() {
        dao = new PostDao();
        userDao = new UserDao();
        TestUserGenerator testUser = new TestUserGenerator();
        testUser.initializeUser();
    }

   @Test
    void addPost() {
        User user = userDao.getUserByID(1);
        String statusCode = "A";
        String title = "Triple Axle Dump Trailer";
        String description = "With all steel construction, pull out loading ramps, triple 5,000 lb axles and a 15,000 lb capacity hydraulic dump box, 'The Elephant' work trailer will help you get the job done.";
        String categoryCode = "trb";
        String areaCode = "mad";
        String subAreaCode = null;
        String replyEmail = "jdanner1@madisoncollege.edu";
        String privacyCode = "P";
        int outsideContactOk = 0;
        String locationCity = "Madison";
        String locationState = "WI";
        String locationPostal = "53711";
        String locationCrossStreet1 = "John Nolen Dr.";
        String locationCrossStreet2 = "E. Wilson St.";
        String locationLatitude = "43.053619";
        String locationLongitude = "-89.377808";
        String image = null;
        int imagePosition = 0;
        int price = 8899;
        String contactName = "John Danner";
        String contactPhone = null;
        String contactPhoneExtension = null;
        int contactTextOk = 1;
        int seeMyOther = 1;

        Post post = new Post(user, statusCode, title, description, categoryCode, areaCode, subAreaCode, replyEmail, privacyCode, outsideContactOk,
                locationCity, locationState, locationPostal, locationCrossStreet1, locationCrossStreet2, locationLatitude, locationLongitude, image,
                imagePosition, price, contactName, contactPhone, contactPhoneExtension, contactTextOk, seeMyOther);

        int postID = dao.addPost(post);
        assertNotEquals(0, postID);
        Post addedPost = dao.getPostByID(postID);
        assertEquals(8899, addedPost.getPrice());
    }



    @Test
    void getPostByID() {
        Post retrievedPost = dao.getPostByID(1);
        assertNotNull(retrievedPost);
        assertEquals("Snowmobile Trailer", retrievedPost.getTitle());
    }

    @Test
    void updatePost() {
        String newTitle = "Aluminum Snowmobile Trailer";
        Post post = dao.getPostByID(1);
        post.setTitle(newTitle);
        dao.updatePost(post);
        Post retrievedPost = dao.getPostByID(1);
        assertEquals(newTitle, retrievedPost.getTitle());
    }

    @Test
    void deletePost() {
        dao.deletePost(dao.getPostByID(1));
        assertNull(dao.getPostByID(1));
    }

}

