package com.danner.persistence;

import com.danner.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    UserDao dao;

    @BeforeEach
    void setUp() {
        dao = new UserDao();

    }

    @Test
    void addUser() {
        User user = new User("A", "John", "Danner", "jdanner1", "password", "jdanner1@madisoncollege.edu", "password2", 2123971);
        int userID = dao.addUser(user);
        assertNotEquals(0, userID);
        User addedUser = dao.getUserByID(userID);
        assertEquals("John", addedUser.getFirstName());
    }

    @Test
    void getUserByID() {
        User retrievedUser = dao.getUserByID(1);
        assertNotNull(retrievedUser);
        assertEquals("John", retrievedUser.getFirstName());
    }

    @Test
    void updateUser() {
        String newFirstName = "Lily";
        User user = dao.getUserByID(1);
        user.setFirstName(newFirstName);
        User retrievedUser = dao.getUserByID(1);
        assertEquals(newFirstName, retrievedUser.getFirstName());
    }

    @Test
    void deleteUser() {
        dao.deleteUser(dao.getUserByID(1));
        assertNull(dao.getUserByID(1));
    }

}