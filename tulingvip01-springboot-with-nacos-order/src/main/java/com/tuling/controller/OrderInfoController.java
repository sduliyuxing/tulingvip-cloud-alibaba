package com.tuling.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.tuling.entity.OrderInfo;
import com.tuling.entity.ProductInfo;
import com.tuling.mapper.OrderInfoMapper;
import com.tuling.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by smlz on 2019/11/17.
 */
@RestController
public class OrderInfoController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    public static final String uri = "http://localhost:8081/selectProductInfoById/";

    @RequestMapping("/selectOrderInfoById/{orderNo}")
    public Object selectOrderInfoById(@PathVariable("orderNo") String orderNo) {

        OrderInfo orderInfo = orderInfoMapper.selectOrderInfoById(orderNo);
        if(null == orderInfo) {
            return "根据orderNo:"+orderNo+"查询没有该订单";
        }
        ResponseEntity<ProductInfo> responseEntity= restTemplate.getForEntity(uri+orderInfo.getProductNo(), ProductInfo.class);

        ProductInfo productInfo = responseEntity.getBody();

        if(productInfo == null) {
            return "没有对应的商品";
        }

        OrderVo orderVo = new OrderVo();
        orderVo.setOrderNo(orderInfo.getOrderNo());
        orderVo.setUserName(orderInfo.getUserName());
        orderVo.setProductName(productInfo.getProductName());
        orderVo.setProductNum(orderInfo.getProductCount());

        return orderVo;
    }

}
