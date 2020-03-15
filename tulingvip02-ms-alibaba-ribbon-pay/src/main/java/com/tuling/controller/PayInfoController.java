package com.tuling.controller;

import com.tuling.mapper.PayInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by smlz on 2019/11/17.
 */
@RestController
public class PayInfoController {


    @Autowired
    private PayInfoMapper payInfoMapper;

    @RequestMapping("/selectPayInfoByOrderNo/{orderNo}")
    public Object selectPayInfoByOrderNo(@PathVariable("orderNo") String orderNo) {
        return payInfoMapper.selectPayInfoByOrderNo(orderNo);
    }
}
