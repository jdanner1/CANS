package com.danner.persistence;

import com.danner.entity.Role;
import com.danner.entity.User;
import com.danner.entity.Vocalization;
import com.danner.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class RoleDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao genericDao;
    private GenericDao genericDao2;

    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(Role.class);
        genericDao2 = new GenericDao(User.class);
        TestUserGenerator testUser = new TestUserGenerator();
        testUser.initializeUser();
    }

    @Test
    void addRole() {
        User user = (User)genericDao2.getEntityByID(1);
        String roleName = "userRole01";
        String userName = "jdanner1";
        int userID = 1;

        Role role = new Role(roleName, userName, user);

        int roleID = genericDao.addEntity(role);
        assertNotEquals(0, roleID);
        Role addedRole = (Role)genericDao.getEntityByID(roleID);
        assertEquals(role, addedRole);
        logger.info("Role Info: " + addedRole.toString());
    }



    @Test
    void getRoleByID() {
        Role retrievedRole = (Role)genericDao.getEntityByID(1);
        assertNotNull(retrievedRole);
        assertEquals(genericDao.getEntityByID(1), retrievedRole);
        logger.info("Role Info: " + retrievedRole.toString());
    }

    @Test
    void updateRole() {
        String newRole = "admin";
        Role role = (Role)genericDao.getEntityByID(1);
        role.setRoleName(newRole);
        genericDao.updateEntity(role);
        Role retrievedRole = (Role)genericDao.getEntityByID(1);
        assertEquals(role, retrievedRole);
        logger.info("Role Info: " + retrievedRole.toString());
    }



    @Test
    void deleteRole() {
        genericDao.deleteEntity(genericDao.getEntityByID(1));
        assertNull(genericDao.getEntityByID(1));
    }

}