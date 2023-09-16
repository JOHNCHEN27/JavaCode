package com.lnc.controller;

import com.lnc.dto.PaymentDto;
import com.lnc.pojo.PaymentPojo;
import com.lnc.pojo.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LNC
 * @version 1.0
 * @description 支付控制器
 * @date 2023/9/16 9:57
 */
@RestController
@Slf4j
@Api(value = "支付功能接口",tags = "支付功能")
public class PaymentController {

    /**
     此接口可用于用户前台直接发起支付，使用form表单跳转或拼接成url跳转。
     * @param payment
     */
    @ApiOperation(value = "页面跳转支付",notes = "")
    @PostMapping("/submit.php")
    public void PageJumpPayment(@RequestBody PaymentPojo payment){

    }

    /**
     * 此接口可用于服务器后端发起支付请求，会返回支付二维码链接或支付跳转url。
     * @param paymentDto
     * @return
     */
    @ApiOperation(value = "Api接口支付",notes = "")
    @PostMapping("/mapi.php")
    public ResponseResult ApiPayment(@RequestBody PaymentDto paymentDto){


    }





}
