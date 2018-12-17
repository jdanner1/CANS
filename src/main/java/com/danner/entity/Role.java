package com.danner.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * @author jdanner
 * The type Role.
 */
@Entity(name = "Role")
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "roleID")
    private int roleID;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "user_name")
    private String userName;

    @ManyToOne
    @JoinColumn(name = "userID",
                foreignKey = @ForeignKey(name = "role_user_userID"))
    private User user;

    /**
     * Instantiates a new Role.
     *
     * @param roleName the role name
     * @param userName the user name
     * @param user     the user
     */
    public Role(String roleName, String userName, User user) {
        this.roleName = roleName;
        this.userName = userName;
        this.user = user;
    }

    /**
     * Instantiates a new Role.
     */
    public Role() {
    }

    /**
     * Gets role name.
     *
     * @return the role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets role name.
     *
     * @param roleName the role name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets role id.
     *
     * @return the role id
     */
    public int getRoleID() {
        return roleID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (roleID != role.roleID) return false;
        if (!roleName.equals(role.roleName)) return false;
        if (!userName.equals(role.userName)) return false;
        return user != null ? user.equals(role.user) : role.user == null;
    }

    @Override
    public int hashCode() {
        int result = roleID;
        result = 31 * result + roleName.hashCode();
        result = 31 * result + userName.hashCode();
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleID=" + roleID +
                ", roleName='" + roleName + '\'' +
                ", userName='" + userName + '\'' +
                ", user=" + user +
                '}';
    }
}
