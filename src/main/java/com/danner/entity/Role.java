package com.danner.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.mapping.ToOne;

import javax.persistence.*;
import java.time.LocalDate;

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

    public Role(String roleName, String userName, User user) {
        this.roleName = roleName;
        this.userName = userName;
        this.user = user;
    }

    public Role() {
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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
