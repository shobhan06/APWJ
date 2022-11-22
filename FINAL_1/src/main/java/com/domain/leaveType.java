package com.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "leavetype")
public class leaveType {
    @Id
    @Column(name = "l_id")
    @GeneratedValue()
    private int l_id;


    @Column(name = "category")
    private String category;


    @Column(name = "totalDays")
    private int totalDays;

    public int getl_id() {
        return l_id;
    }

    public void setl_id(int id) {
        this.l_id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }
}
