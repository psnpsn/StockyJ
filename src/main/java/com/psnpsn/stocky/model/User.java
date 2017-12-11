/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author psnpsn
 */
@Entity
@Table(name="USERS")
public class User {
    
    
    private int id;
    
    private String login;
    
    private char[] pwd;
    
    private int admin;

    public User (){
        
    }
    
    public User(String login, char[] pwd, int admin) {
        this.login = login;
        this.pwd = pwd;
        this.admin = admin;
    }

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="LOGIN")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name="PASSWORD")
    public char[] getPwd() {
        return pwd;
    }

    public void setPwd(char[] pwd) {
        this.pwd = pwd;
    }

    @Column(name="ADMIN")
    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    
    
    
    
}
