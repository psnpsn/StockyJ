/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.model;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author psnpsn
 */
@Entity
@Table(name="User_Profile")
public class UserProfile {
    
    private int id;
    private char role;
    private String nom;
    private String prenom;
    private String email;
    private LocalDateTime lastLogin;
    private LocalDateTime createdOn;
    private String imgurl;
    private User user;

    public UserProfile() {
    }

    public UserProfile(char role, String nom, String prenom, String email, LocalDateTime last, LocalDateTime date, String imgurl) {
        this.role = role;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.lastLogin = last;
        this.createdOn = date;
        this.imgurl = imgurl;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="USER_ROLE")
    public char getRole() {
        return role;
    }

    public void setRole(char role) {
        this.role = role;
    }

    @Column(name="NOM")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Column(name="PRENOM")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Column(name="EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="LAST_DATE")
    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime last) {
        this.lastLogin = last;
    }

    @Column(name="CREATION_DATE")
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime date) {
        this.createdOn = date;
    }

    @Transient
    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    public User getUser() {
        return user;
    }

    public void setUser(User usr) {
        this.user = usr;
    }
    
    
    
}
