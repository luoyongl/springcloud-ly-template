package com.ly.springcloudlytemplate.service;

import com.ly.springcloudlytemplate.entities.CommonResult;
import com.ly.springcloudlytemplate.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：luoYong
 * @date ：Created in 2020/8/13 21:55
 * @description：PaymentService
 */
public interface PaymentService {
    /**
     * create
     * @param payment
     * @return
     */
    public CommonResult create(Payment payment);

    /**
     * getPaymentById
     * @param id
     * @return
     */
    public CommonResult getPaymentById(@Param("id") Long id);
}
