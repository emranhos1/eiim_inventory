package com.eiim.eh.myinv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.eiim.eh.myinv.entity.T01010;
import com.eiim.eh.myinv.pojo.T01010Pojo;
import com.eiim.eh.myinv.repository.T01010Repository;
import com.eiim.eh.myinv.util.T01010RowMapper;
/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-20T04:20:00
 */
@Service
public class T01010ServiceImpl implements T01010Service {

    @Autowired
    T01010Repository t01010Repository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<T01010Pojo> findAll() {
        //return t01010Repository.findAll();
        String sql = "SELECT t.*, m.t_payment_method_name "
                   + "FROM t01010 t "
                   + "LEFT JOIN t01008 m "
                   + "ON t.t_payment_method_id = m.t_payment_method_id";
        return jdbcTemplate.query( sql, new T01010RowMapper());
    }

    @Override
    public T01010Pojo findById(int makePaymentCode) {
        //return t01010Repository.findByMakePaymentId(makePaymentCode);
    	String sql = "SELECT t.*, m.t_payment_method_name "
                + "FROM t01010 t "
                + "LEFT JOIN t01008 m "
                + "ON t.t_payment_method_id = m.t_payment_method_id "
                + "WHERE t.t_make_payment_id = ?";
        return (T01010Pojo) jdbcTemplate.queryForObject(sql, new Object[]{makePaymentCode}, new T01010RowMapper());
    }

    @Override
    public T01010 insert(T01010 t01010) {
        return t01010Repository.save(t01010);
    }

    @Override
    public T01010 update(T01010 t01010) {
        return t01010Repository.save(t01010);
    }
}
