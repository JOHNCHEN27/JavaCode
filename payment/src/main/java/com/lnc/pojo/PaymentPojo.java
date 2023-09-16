package com.lnc.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author LNC
 * @version 1.0
 * @description 支付订单实体类
 * @date 2023/9/16 10:00
 */
@Data
@ApiModel(value = "支付订单实体类")
@TableName("payment")
public class PaymentPojo {

    // 记录ID
    private int id;
    // 商户ID
    @TableField("merchant_id")
    private int merchantId;
    // 支付方式
    @TableField("payment_type")
    private String paymentType;
    // 商户订单号
    @TableField("order_number")
    private String orderNumber;
    // 异步通知地址
    @TableField("notify_url")
    private String notifyUrl;
    // 页面跳转通知地址
    @TableField("return_url")
    private String returnUrl;
    // 商品名称
    @TableField("product_name")
    private String productName;
    // 商品金额（单位：元，最大2位小数）
    @TableField("amount")
    private BigDecimal amount;
    // 业务扩展参数
    @TableField("extension_param")
    private String extensionParam;
    // 签名字符串
    private String sign;
    // 签名类型（默认为MD5）
    @TableField("sign_type")
    private String signType;
    // 记录创建时间
    @TableField("created_at")
    private LocalDate createdAt;
}
