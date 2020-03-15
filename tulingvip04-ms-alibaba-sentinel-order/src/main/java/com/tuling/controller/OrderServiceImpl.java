package com.tuling.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by smlz on 2019/11/24.
 */
@Service
@Slf4j
public class OrderServiceImpl {

    @SentinelResource("common")
    public String common() {
        log.info("common.....");
        return "common";
    }
}
