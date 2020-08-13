package com.ly.springcloudlytemplate.service.impl;

import com.ly.springcloudlytemplate.dao.PaymentDao;
import com.ly.springcloudlytemplate.entities.CommonResult;
import com.ly.springcloudlytemplate.entities.Payment;
import com.ly.springcloudlytemplate.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author ：luoYong
 * @date ：Created in 2020/8/13 21:55
 * @description：PaymentService
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public CommonResult create(Payment payment) {
        return paymentDao.create(payment) > 0 ? CommonResult.ok() : CommonResult.fail();
    }

    @Override
    public CommonResult getPaymentById(Long id) {
        Payment payment = paymentDao.getPaymentById(id);
        return payment != null ? CommonResult.ok(payment) : CommonResult.fail();
    }


}
