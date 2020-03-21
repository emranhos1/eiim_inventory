package com.eiim.eh.myinv.util;

import org.springframework.jdbc.core.RowMapper;

import com.eiim.eh.myinv.pojo.T01007Pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class T01007RowMapper implements RowMapper<T01007Pojo> {

    @Override
    public T01007Pojo mapRow(ResultSet rs, int rowNum) throws SQLException {

        T01007Pojo pojo = new T01007Pojo();
        pojo.setOrderId(rs.getInt("t_order_id"));
        pojo.setProduct(rs.getString("t_product"));
        pojo.setProductQty(rs.getInt("t_product_qty"));
        pojo.setAmount(rs.getDouble("t_amount"));
        pojo.setDueAmount(rs.getDouble("t_due_amount"));
        pojo.setDeliveryDate(rs.getTimestamp("t_delivery_date"));
        pojo.setIsActive(rs.getInt("t_is_active"));
        pojo.setEntryDate(rs.getTimestamp("t_entry_date"));
        pojo.setUpdateDate(rs.getTimestamp("t_update_date"));

        pojo.setVendorFirstName(rs.getString("t_vendor_first_name"));
        pojo.setVendorLastName(rs.getString("t_vendor_last_name"));
        pojo.setVendorBusinessName(rs.getString("t_vendor_business_name"));
        pojo.setVendorPhoneNo(rs.getString("t_vendor_phone_no"));
        pojo.setVendorId(rs.getString("t_vendor_id"));

        pojo.setTransportId(rs.getString("t_transport_id"));
        pojo.setTransportName(rs.getString("t_transport_name"));
        pojo.setTransportContactNo(rs.getString("t_transport_contact_no"));

        return pojo;
    }
}
