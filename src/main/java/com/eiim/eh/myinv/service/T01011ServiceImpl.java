package com.eiim.eh.myinv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.eiim.eh.myinv.entity.T01011;
import com.eiim.eh.myinv.pojo.T01011Pojo;
import com.eiim.eh.myinv.repository.T01011Repository;
import com.eiim.eh.myinv.util.T01011RowMapper;
/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-20T04:20:00
 */
@Service
public class T01011ServiceImpl implements T01011Service {

    @Autowired
    T01011Repository t01011Repository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<T01011Pojo> findAll() {
        //return t01011Repository.findAll();
        String sql = "SELECT r.*, m.t_payment_method_name, t.t_payment_type_name "
                   + "FROM t01011 r "
                   + "LEFT JOIN t01008 m ON r.t_payment_method_id = m.t_payment_method_id "
                   + "LEFT JOIN t01009 t ON r.t_payment_type_id = t.t_payment_type_id";
     return jdbcTemplate.query( sql, new T01011RowMapper());
    }

    @Override
    public T01011Pojo findById(int receivePaymentCode) {
        //return t01011Repository.findByReceivePaymentId(receivePaymentCode);
    	String sql = "SELECT r.*, m.t_payment_method_name, t.t_payment_type_name "
                + "FROM t01011 r "
                + "LEFT JOIN t01008 m ON r.t_payment_method_id = m.t_payment_method_id "
                + "LEFT JOIN t01009 t ON r.t_payment_type_id = t.t_payment_type_id "
                + "WHERE r.t_receive_payment_id = ?";
        return (T01011Pojo) jdbcTemplate.queryForObject(sql, new Object[]{receivePaymentCode}, new T01011RowMapper());
    }

    @Override
    public T01011 insert(T01011 t01011) {
        return t01011Repository.save(t01011);
    }

    @Override
    public T01011 update(T01011 t01011) {
        return t01011Repository.save(t01011);
    }
}
