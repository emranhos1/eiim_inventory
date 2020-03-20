package com.eiim.eh.myinv.service;

import java.util.List;

import com.eiim.eh.myinv.entity.T01006;
import com.eiim.eh.myinv.pojo.T01006Pojo;
/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-20T04:20:00
 */
public interface T01006Service {

	List<T01006Pojo> findAll();
	T01006Pojo findById(int shipmentCode);
	T01006 findByShipmentId(int shipmentCode);
	T01006 insert(T01006 t01006);
	T01006 update(T01006 t01006);
}
