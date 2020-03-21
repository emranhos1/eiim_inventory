package com.eiim.eh.myinv.util;

import org.springframework.jdbc.core.RowMapper;

import com.eiim.eh.myinv.pojo.T01006Pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class T01006RowMapper implements RowMapper<T01006Pojo> {

    @Override
    public T01006Pojo mapRow(ResultSet rs, int rowNum) throws SQLException {

        T01006Pojo pojo = new T01006Pojo();
        pojo.setShipmentId(rs.getInt("t_shipment_id"));
        pojo.setProduct(rs.getString("t_product"));
        pojo.setProductQty(rs.getInt("t_product_qty"));
        pojo.setAmount(rs.getDouble("t_amount"));
        pojo.setDueAmount(rs.getDouble("t_due_amount"));
        pojo.setDeliveryDate(rs.getTimestamp("t_delivery_date"));
        pojo.setIsActive(rs.getInt("t_is_active"));
        pojo.setEntryDate(rs.getTimestamp("t_entry_date"));
        pojo.setUpdateDate(rs.getTimestamp("t_update_date"));

        pojo.setDistributorFirstName(rs.getString("t_distributor_first_name"));
        pojo.setDistributorLastName(rs.getString("t_distributor_last_name"));
        pojo.setDistributorBusinessName(rs.getString("t_business_name"));
        pojo.setDistributorPhoneNo(rs.getString("t_distributor_phone_no"));
        pojo.setDistributorId(rs.getString("t_distributor_id"));

        pojo.setTransportId(rs.getString("t_transport_id"));
        pojo.setTransportName(rs.getString("t_transport_name"));
        pojo.setTransportContactNo(rs.getString("t_transport_contact_no"));

        return pojo;
    }
}
