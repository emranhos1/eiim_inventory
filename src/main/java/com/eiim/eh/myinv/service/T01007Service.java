package com.eiim.eh.myinv.service;

import java.util.List;

import com.eiim.eh.myinv.entity.T01007;
import com.eiim.eh.myinv.pojo.T01007Pojo;
/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-20T04:20:00
 */
public interface T01007Service {

	List<T01007Pojo> findAll();
	T01007Pojo findById(int shipmentCode);
	T01007 findByShipmentId(int shipmentCode);
	T01007 insert(T01007 T01007);
	T01007 update(T01007 T01007);
}
