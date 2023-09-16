package com.lnc.dto;

import com.lnc.pojo.PaymentPojo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;

/**
 * @author LNC
 * @version 1.0
 * @description
 * @date 2023/9/16 10:35
 */
@ApiModel(value = "用来接受接口支付的参数")
@Data
public class PaymentDto extends PaymentPojo {
    //用户ip地址
    @ApiModelProperty(value = "用户id地址")
    private String clientip;
    //设备类型
    @ApiModelProperty(value = "设备类型")
    private String device;
}
