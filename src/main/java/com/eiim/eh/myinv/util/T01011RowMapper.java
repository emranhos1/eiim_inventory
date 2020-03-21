package com.eiim.eh.myinv.util;

import org.springframework.jdbc.core.RowMapper;

import com.eiim.eh.myinv.pojo.T01011Pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class T01011RowMapper implements RowMapper<T01011Pojo> {

    @Override
    public T01011Pojo mapRow(ResultSet rs, int rowNum) throws SQLException {

        T01011Pojo pojo = new T01011Pojo();
        pojo.setReceivePaymentId(rs.getInt("t_receive_payment_id"));
        pojo.setReceivePaymentname(rs.getString("t_name"));
        pojo.setPaymentMethodId(rs.getInt("t_payment_method_id"));
        pojo.setPaymentMethodName(rs.getString("t_payment_method_name"));
        pojo.setPaymentTypeId(rs.getInt("t_payment_type_id"));
        pojo.setPaymentTypeName(rs.getString("t_payment_type_name"));
        pojo.setAmount(rs.getDouble("t_amount"));
        pojo.setPaymentDate(rs.getTimestamp("t_payment_date"));
        pojo.setIsActive(rs.getInt("t_is_active"));
        pojo.setEntryDate(rs.getTimestamp("t_entry_date"));
        pojo.setUpdateDate(rs.getTimestamp("t_update_date"));

        return pojo;
    }
}
