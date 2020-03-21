package com.eiim.eh.myinv.util;

import org.springframework.jdbc.core.RowMapper;

import com.eiim.eh.myinv.pojo.T01010Pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class T01010RowMapper implements RowMapper<T01010Pojo> {

    @Override
    public T01010Pojo mapRow(ResultSet rs, int rowNum) throws SQLException {

        T01010Pojo pojo = new T01010Pojo();
        pojo.setMakePaymentId(rs.getInt("t_make_payment_id"));
        pojo.setMakePaymentname(rs.getString("t_name"));
        pojo.setPaymentMethodId(rs.getInt("t_payment_method_id"));
        pojo.setPaymentMethodName(rs.getString("t_payment_method_name"));
        pojo.setAmount(rs.getDouble("t_amount"));
        pojo.setPaymentDate(rs.getTimestamp("t_payment_date"));
        pojo.setIsActive(rs.getInt("t_is_active"));
        pojo.setEntryDate(rs.getTimestamp("t_entry_date"));
        pojo.setUpdateDate(rs.getTimestamp("t_update_date"));

        return pojo;
    }
}
