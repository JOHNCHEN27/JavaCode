package com.lnc.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author LNC
 * @version 1.0
 * @description 通用返回结果类
 * @date 2023/9/16 10:31
 */
@ApiModel("通用返回结果类")
@Data
public class ResponseResult<T> {
    //返回状态码
    private Integer code;
    //返回信息
    private String msg;
    //返回数据 类型为泛型
    private T data;

    //返回订单号
    @ApiModelProperty(value = "订单号")
    private Long trade_np;

    //支付跳转url 如果返回该字段，则直接跳转到该url支付
    @ApiModelProperty(value = "跳转链接支付")
    private String payurl;

    //二维码连接 如果返回该字段，则根据该url生成二维码
    @ApiModelProperty(value = "二维码链接支付")
    private String qrcode;

    //小程序跳转url 如果返回该字段，则使用js跳转该url，可发起微信小程序支付
    @ApiModelProperty(value = "小程序跳转链接支付")
    private String urlscheme;


    //Api接口成功时返回 支付跳转链接url
    public ResponseResult successApiPayUrl(String msg,String order){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(1);
        responseResult.setMsg(msg);
        //成功返回支付跳转链接
        responseResult.setPayurl(order);
        return responseResult;
    }
    //Api接口成功时返回 二维码链接
    public ResponseResult successApiQrCode(String msg,String order){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(1);
        responseResult.setMsg(msg);
        //成功返回二维码链接
        responseResult.setQrcode(order);
        return responseResult;
    }

    //Api接口成功时返回 小程序跳转链接
    public ResponseResult successApiUrlScheme(String msg,String order){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(1);
        responseResult.setUrlscheme(msg);
        //成功返回小程序跳转链接
        responseResult.setPayurl(order);
        return responseResult;
    }

}
