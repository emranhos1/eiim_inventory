package com.eiim.eh.myinv.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-20T04:20:00
 */
public class T01006Pojo {

    private int shipmentId;
    private String product;
    private int productQty;
    private String amount;
    private String dueAmount;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date deliveryDate;
    private int isActive;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date entryDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date updateDate;

    private String distributorFirstName;
    private String distributorLastName;
    private String distributorBusinessName;
    private String distributorPhoneNo;
    private String distributorId;

    private String transportId;
    private String transportName;
    private String transportContactNo;

    public int getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(String dueAmount) {
        this.dueAmount = dueAmount;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
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

    public String getDistributorBusinessName() {
        return distributorBusinessName;
    }

    public void setDistributorBusinessName(String distributorBusinessName) {
        this.distributorBusinessName = distributorBusinessName;
    }

    public String getDistributorPhoneNo() {
        return distributorPhoneNo;
    }

    public void setDistributorPhoneNo(String distributorPhoneNo) {
        this.distributorPhoneNo = distributorPhoneNo;
    }

    public String getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(String distributorId) {
        this.distributorId = distributorId;
    }

    public String getTransportId() {
        return transportId;
    }

    public void setTransportId(String transportId) {
        this.transportId = transportId;
    }

    public String getTransportName() {
        return transportName;
    }

    public void setTransportName(String transportName) {
        this.transportName = transportName;
    }

    public String getTransportContactNo() {
        return transportContactNo;
    }

    public void setTransportContactNo(String transportContactNo) {
        this.transportContactNo = transportContactNo;
    }
}