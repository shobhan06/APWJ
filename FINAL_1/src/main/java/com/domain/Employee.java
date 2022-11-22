package com.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {

    @ManyToOne
    private leaveApplication leaveApplication;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "firstName")
    private String firstname;


    @Column(name = "lastName")
    private String lastname;


    @Column(name = "gender")
    private String gender;


    @Column(name = "email")
    private String email;


    @Column(name = "joiningDate")
    private Date joiningDate;

    @Column(name = "l_app_id")
    public  int l_app_id;

    public int getL_app_id() {
        return l_app_id;
    }

    public void setL_app_id(int l_app_id) {
        this.l_app_id = l_app_id;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }
}
