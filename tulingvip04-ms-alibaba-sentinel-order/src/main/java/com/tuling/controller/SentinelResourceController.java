package com.tuling.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试SentinelResource的注解(可以优化)
 * Created by smlz on 2019/11/27.
 */
@RestController
@Slf4j
public class SentinelResourceController {


    @SentinelResource(value = "testSentinelResource",
            blockHandler = "blockHandlerMethod",fallback ="fallBackHandlerMethod")
    @RequestMapping("/testSentinelApi")
    public String testSentinelResource(@RequestParam(value = "testParem",required = false) String testParam) {

        if(testParam == null) {
            throw new IllegalArgumentException("param can not be null");
        }

        return "you param is:"+testParam;
    }

    /**
     * 该方法用来处理限流的方法
     * @param testParam
     * @param ex
     * @return
     */
    public String blockHandlerMethod(String testParam,BlockException ex) {
        log.info("被限流量了..."+ex.getMessage());
        return "invoke block......";
    }

    /**
     * 用来处理容错降级的方法
     * @param testParam
     * @param ex
     * @return
     */
    public String fallBackHandlerMethod(String testParam,Throwable ex) {
        log.info("被降级拉......"+ex.getMessage());
        return "invoke fallback......";
    }


}
