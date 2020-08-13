package com.ly.springcloudlytemplate.dao;

import com.ly.springcloudlytemplate.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：luoYong
 * @date ：Created in 2020/8/13 21:46
 * @description：PaymentDao
 */

@Mapper
public interface PaymentDao {
    /**
     * create
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     * getPaymentById
     * @param id
     * @return
     */
    public Payment getPaymentById(@Param("id") Long id);
}
