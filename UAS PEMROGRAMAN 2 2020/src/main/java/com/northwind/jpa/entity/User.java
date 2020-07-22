/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.northwind.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author fnauf
 */
@Entity
@Table(name = "users")
public class User {
    
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Integer userID  ;
    
    @Column(name = "name")
    @Size(max = 40)
    private String name;
    
    @Column(name = "title")
    @Size(max = 30)
    private String title;
    
    @Column(name = "birthdate")
    private Integer birthDate;
    
    @Column(name = "hiredate")
    private Integer hireDate;
    
    @Column(name = "position")
    @Size(max = 30)
    private String position;
    
    @Column(name = "email")
    @Size(max =30)
    private String email;
    
    @Column(name = "password")
    @Size(max = 60)
    private String password;

    public User() {
    }

    public User(Integer userID, String name, String title, Integer birthDate, Integer hireDate, String position, String email, String password) {
        this.userID = userID;
        this.name = name;
        this.title = title;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.position = position;
        this.email = email;
        this.password = password;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Integer birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getHireDate() {
        return hireDate;
    }

    public void setHireDate(Integer hireDate) {
        this.hireDate = hireDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
}
