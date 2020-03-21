package com.eiim.eh.myinv.util;

import org.springframework.jdbc.core.RowMapper;

import com.eiim.eh.myinv.pojo.T01001Pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class T01001RowMapper implements RowMapper<T01001Pojo> {

    @Override
    public T01001Pojo mapRow(ResultSet rs, int rowNum) throws SQLException {

        T01001Pojo pojo = new T01001Pojo();
        pojo.setUserId(rs.getInt("t_user_id"));
        pojo.setFirstName(rs.getString("t_first_name"));
        pojo.setLastName(rs.getString("t_last_name"));
        pojo.setEmail(rs.getString("t_email"));
        pojo.setPhoneNo(rs.getString("t_phone_no"));
        pojo.setAddress(rs.getString("t_address"));
        pojo.setRoleId(rs.getInt("t_role_id"));
        pojo.setRoleName(rs.getString("t_role_name"));
        pojo.setIsActive(rs.getInt("t_is_active"));
        pojo.setEntryDate(rs.getTimestamp("t_entry_date"));
        pojo.setUpdateDate(rs.getTimestamp("t_update_date"));

        return pojo;
    }
}
