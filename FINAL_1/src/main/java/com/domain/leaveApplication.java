package com.domain;

import javax.persistence.*;

@Entity
@Table(name = "leaveapplication")
public class leaveApplication {

    @Id
    @Column(name = "id")
    @GeneratedValue()
    private int id;


    @Column(name = "fromDate")
    private String fromDate;


    @Column(name = "toDate")
    private String toDate;


    @Column(name = "totalDate")
    private int totalDate;

    @Column(name = "reason")
    private String reason;



    //@JoinColumn(name = "l_type_id")
    @ManyToOne
    private leaveType leaveT;

    public leaveType getLeaveT() {
        return leaveT;
    }

    public void setLeaveT(leaveType leaveT) {
        this.leaveT = leaveT;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public int getTotalDate() {
        return totalDate;
    }

    public void setTotalDate(int totalDate) {
        this.totalDate = totalDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
