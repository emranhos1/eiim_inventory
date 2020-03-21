package com.eiim.eh.myinv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.eiim.eh.myinv.entity.T01007;
import com.eiim.eh.myinv.pojo.T01007Pojo;
import com.eiim.eh.myinv.repository.T01007Repository;
import com.eiim.eh.myinv.util.T01007RowMapper;
/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-20T04:20:00
 */
@Service
public class T01007ServiceImpl implements T01007Service {

    @Autowired
    T01007Repository t01007Repository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<T01007Pojo> findAll() {
        //return T01007Repository.findAll();
        String sql = "SELECT s.*, v.t_vendor_business_name, v.t_vendor_first_name, v.t_vendor_last_name, "
                   + "v.t_vendor_phone_no, v.t_vendor_id, t.t_transport_id, t.t_transport_name "
                   + "FROM T01007 s "
                   + "LEFT JOIN T01002 v ON s.t_vendor_id = v.t_vendor_id "
                   + "LEFT JOIN T01005 t ON s.t_transport_id = t.t_transport_id";
        return jdbcTemplate.query( sql, new T01007RowMapper());
    }

    @Override
    public T01007Pojo findById(int shipmentCode) {
        //return T01007Repository.findByShipmentId(shipmentCode);
        String sql = "SELECT s.*, v.t_vendor_business_name, v.t_vendor_first_name, v.t_vendor_last_name, "
                + "v.t_vendor_phone_no, v.t_vendor_id, t.t_transport_id, t.t_transport_name "
                + "FROM T01007 s "
                + "LEFT JOIN T01002 v ON s.t_vendor_id = v.t_vendor_id "
                + "LEFT JOIN T01005 t ON s.t_transport_id = t.t_transport_id "
                + "WHERE s.t_order_id = ?";
        return (T01007Pojo) jdbcTemplate.queryForObject(sql, new Object[]{shipmentCode}, new T01007RowMapper());
    }

    @Override
    public T01007 insert(T01007 T01007) {
        return t01007Repository.save(T01007);
    }

    @Override
    public T01007 findByShipmentId(int shipmentCode) {
        return t01007Repository.findByOrderId(shipmentCode);
    }

    @Override
    public T01007 update(T01007 T01007) {
        return t01007Repository.save(T01007);
    }
}
