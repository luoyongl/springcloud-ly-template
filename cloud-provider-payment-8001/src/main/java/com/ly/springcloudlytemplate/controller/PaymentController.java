package com.ly.springcloudlytemplate.controller;


import com.ly.springcloudlytemplate.entities.CommonResult;
import com.ly.springcloudlytemplate.entities.Payment;
import com.ly.springcloudlytemplate.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ：luoYong
 * @date ：Created in 2020/8/13 22:04
 * @description：PaymentController
 */

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    /**
     * create
     * @param payment
     * @return
     */
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        return paymentService.create(payment);
    }

    /**
     * getPaymentById
     * @param id id
     * @return
     */
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {


        return paymentService.getPaymentById(id);
    }

}
