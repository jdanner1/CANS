package com.danner.controller;

import com.danner.entity.User;
import com.danner.entity.Vocalization;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {

    @Test
    void getUsers() {
        UserManager userManager = new UserManager();
        List<User> users = null;
        users = userManager.getUsers();
        assertEquals("[User{statusCode='A', firstName='John', lastName='Danner', userName='jdanner1', password='password', email='jdanner@madisoncollege.edu', createDate=2018-12-14, modifyDate=null, userID=1}, User{statusCode='A', firstName='Booker', lastName='Danner', userName='bdanner1', password='password', email='bdanner@madisoncollege.edu', createDate=2018-12-14, modifyDate=null, userID=2}]", users.toString());
    }

    @Test
    void getVocalizations() {
        UserManager userManager = new UserManager();
        List<Vocalization> vocals = null;
        vocals = userManager.getVocalizations();
        assertEquals("[Vocalization{vocalizationID=1, user=User{statusCode='A', firstName='John', lastName='Danner', userName='jdanner1', password='password', email='jdanner@madisoncollege.edu', createDate=2018-12-14, modifyDate=null, userID=1}, createDate=2018-12-14T00:00, text='This is the default vocalization created by Test User Generator', language='en-US_AllisonVoice', isEmailed=true}]", vocals.toString());
    }

}