package com.ly.springcloudlytemplate.controller;

import com.ly.springcloudlytemplate.entities.CommonResult;
import com.ly.springcloudlytemplate.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author ：luoYong
 * @date ：Created in 2020/8/14 0:11
 * @description：OrderController
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    /**
     * /consumer/payment/create
     * @param payment
     * @return
     */
    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL +"/payment/create",payment, CommonResult.class);
    }

    /**
     * /consumer/payment/get/{id
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }


}
