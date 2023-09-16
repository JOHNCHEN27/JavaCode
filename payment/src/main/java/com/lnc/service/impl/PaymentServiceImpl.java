package com.lnc.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lnc.mapper.PaymentMapper;
import com.lnc.pojo.PaymentPojo;
import com.lnc.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * @author LNC
 * @version 1.0
 * @description
 * @date 2023/9/16 10:00
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper,PaymentPojo>implements PaymentService {
}
