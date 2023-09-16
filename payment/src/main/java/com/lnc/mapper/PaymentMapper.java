package com.lnc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lnc.pojo.PaymentPojo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author LNC
 * @version 1.0
 * @description
 * @date 2023/9/16 10:08
 */
@Mapper
public interface PaymentMapper extends BaseMapper<PaymentPojo> {
}
