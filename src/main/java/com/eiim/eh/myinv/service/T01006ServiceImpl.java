package com.eiim.eh.myinv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.eiim.eh.myinv.entity.T01006;
import com.eiim.eh.myinv.pojo.T01006Pojo;
import com.eiim.eh.myinv.repository.T01006Repository;
import com.eiim.eh.myinv.util.T01006RowMapper;
/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-20T04:20:00
 */
@Service
public class T01006ServiceImpl implements T01006Service {

    @Autowired
    T01006Repository t01006Repository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<T01006Pojo> findAll() {
        //return t01006Repository.findAll();
        String sql = "SELECT s.*, d.t_business_name, d.t_distributor_first_name, d.t_distributor_last_name, "
                   + "d.t_distributor_phone_no, d.t_distributor_id, t.t_transport_id, t.t_transport_name "
                   + "FROM T01006 s "
                   + "LEFT JOIN T01004 d ON s.t_distributor_id = d.t_distributor_id "
                   + "LEFT JOIN T01005 t ON s.t_transport_id = t.t_transport_id";
     return jdbcTemplate.query( sql, new T01006RowMapper());
    }

    @Override
    public T01006Pojo findById(int shipmentCode) {
        //return t01006Repository.findByShipmentId(shipmentCode);
        String sql = "SELECT s.*, d.t_business_name, d.t_distributor_first_name, d.t_distributor_last_name, "
                + "d.t_distributor_phone_no, d.t_distributor_id, t.t_transport_id, t.t_transport_name "
                + "FROM T01006 s "
                + "LEFT JOIN T01004 d ON s.t_distributor_id = d.t_distributor_id "
                + "LEFT JOIN T01005 t ON s.t_transport_id = t.t_transport_id "
                + "WHERE s.t_shipment_id = ?";
        return (T01006Pojo) jdbcTemplate.queryForObject(sql, new Object[]{shipmentCode}, new T01006RowMapper());
    }

    @Override
    public T01006 insert(T01006 t01006) {
        return t01006Repository.save(t01006);
    }

    @Override
    public T01006 findByShipmentId(int shipmentCode) {
        return t01006Repository.findByShipmentId(shipmentCode);
    }

    @Override
    public T01006 update(T01006 t01006) {
        return t01006Repository.save(t01006);
    }
}
