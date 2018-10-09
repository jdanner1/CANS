package com.danner.persistence;

import com.danner.entity.Post;
import com.danner.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    UserDao dao;
    PostDao postDao;

    @BeforeEach
    void setUp() {
        dao = new UserDao();
        postDao = new PostDao();
        TestUserGenerator testUser = new TestUserGenerator();
        testUser.initializeUser();
    }

    @Test
    void addUser() {
        User user = new User("A", "Luther", "Danner", "ldanner2", "password", "ldanner2@madisoncollege.edu", "password2", 2123970);
        int userID = dao.addUser(user);
        assertNotEquals(0, userID);
        User addedUser = dao.getUserByID(userID);
        assertEquals("Luther", addedUser.getFirstName());
    }

    @Test
    void addUserWithPost() {
        User user = new User("A", "Luther", "Danner", "ldanner2", "password", "ldanner2@madisoncollege.edu", "password2", 2123970);

        String statusCode = "A";
        String title = "Dual Axle Dump Trailer";
        String description = "With all steel construction, pull out loading ramps, dual 5,000 lb axles and a 10,000 lb capacity hydraulic dump box, 'The Mule' work trailer will help you get the job done.";
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
        int price = 6899;
        String contactName = "Luther Danner";
        String contactPhone = null;
        String contactPhoneExtension = null;
        int contactTextOk = 1;
        int seeMyOther = 1;

        Post post = new Post(user, statusCode, title, description, categoryCode, areaCode, subAreaCode, replyEmail, privacyCode, outsideContactOk,
                locationCity, locationState, locationPostal, locationCrossStreet1, locationCrossStreet2, locationLatitude, locationLongitude, image,
                imagePosition, price, contactName, contactPhone, contactPhoneExtension, contactTextOk, seeMyOther);

        user.addPost(post);

        int userID = dao.addUser(user);
        assertNotEquals(0, userID);
        User addedUser = dao.getUserByID(userID);
        assertEquals(user, addedUser);
        assertEquals(1, addedUser.getPosts().size());
        int postId = post.getPostID();
        Post addedPost = postDao.getPostByID(postId);
        assertEquals(post, addedPost);
        logger.info("User Info: " + user.toString());
        logger.info("Post Info: " + post.toString());
    }

    @Test
    void getUserByID() {
        User retrievedUser = dao.getUserByID(1);
        assertNotNull(retrievedUser);
        assertEquals(dao.getUserByID(1), retrievedUser);
        logger.info("User Info: " + retrievedUser.toString());
    }

    @Test
    void updateUser() {
        String newFirstName = "Lily";
        User user = dao.getUserByID(1);
        user.setFirstName(newFirstName);
        dao.updateUser(user);
        User retrievedUser = dao.getUserByID(1);
        assertEquals(user, retrievedUser);
        logger.info("User Info: " + retrievedUser.toString());
    }

    @Test
    void deleteUser() {
        dao.deleteUser(dao.getUserByID(1));
        assertNull(dao.getUserByID(1));
    }
}

