package com.eiim.eh.myinv.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-20T03:33:00
 */
@Entity
@Table(name = "T01004")
public class T01004 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_distributor_id")
    private int distributorId;
    @Column(name = "t_distributor_first_name")
    private String distributorFirstName;
    @Column(name = "t_distributor_last_name")
    private String distributorLastName;
    @Column(name = "t_business_name")
    private String businessName;
    @Column(name = "t_distributor_email")
    private String distributorEmail;
    @Column(name = "t_distributor_phone_no")
    private String distributorPhoneNo;
    @Column(name = "t_distributor_address")
    private String distributorAddress;
    @Column(name = "t_is_active")
    private int isActive;
    @Column(name = "t_entry_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date entryDate;
    @Column(name = "t_update_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date updateDate;

    public int getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(int distributorId) {
        this.distributorId = distributorId;
    }

    public String getDistributorFirstName() {
        return distributorFirstName;
    }

    public void setDistributorFirstName(String distributorFirstName) {
        this.distributorFirstName = distributorFirstName;
    }

    public String getDistributorLastName() {
        return distributorLastName;
    }

    public void setDistributorLastName(String distributorLastName) {
        this.distributorLastName = distributorLastName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getDistributorEmail() {
        return distributorEmail;
    }

    public void setDistributorEmail(String distributorEmail) {
        this.distributorEmail = distributorEmail;
    }

    public String getDistributorPhoneNo() {
        return distributorPhoneNo;
    }

    public void setDistributorPhoneNo(String distributorPhoneNo) {
        this.distributorPhoneNo = distributorPhoneNo;
    }

    public String getDistributorAddress() {
        return distributorAddress;
    }

    public void setDistributorAddress(String distributorAddress) {
        this.distributorAddress = distributorAddress;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
