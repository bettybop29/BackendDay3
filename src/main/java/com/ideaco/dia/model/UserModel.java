package com.ideaco.dia.model;

import javax.persistence.*;

@Entity
@Table(name = "tab_user")
public class UserModel {
    //Tabel database tab user
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //kolom database tab_user
    @Column(name = "user_id")
    private int userId; //nama variabel java
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "user_phone")
    private String userPhone;
    @Column(name = "user_address")
    private String userAddress;
    @Column(name = "user_resume")
    private String userResume;
    //getter satter
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserResume() {
        return userResume;
    }

    public void setUserResume(String userResume) {
        this.userResume = userResume;
    }
}
