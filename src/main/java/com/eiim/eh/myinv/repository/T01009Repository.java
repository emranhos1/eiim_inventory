package com.eiim.eh.myinv.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eiim.eh.myinv.entity.T01009;
/**
 * @author  : Md. Emran Hossain<emranhos1@gmail.com>
 * @version : 1.0.00
 * @since   : 1.0.00
 * @create  : 2020-03-20T04:20:00
 */
@Repository
public interface T01009Repository extends JpaRepository<T01009, Integer>{

    T01009 findByPaymentTypeId(int paymentCode);
}
