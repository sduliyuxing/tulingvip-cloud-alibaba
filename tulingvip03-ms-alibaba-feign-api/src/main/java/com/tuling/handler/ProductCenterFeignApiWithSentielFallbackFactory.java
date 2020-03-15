package com.tuling.handler;

import com.tuling.entity.ProductInfo;
import com.tuling.feignapi.sentinel.ProductCenterFeignApiWithSentinel;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by smlz on 2019/11/28.
 */
@Component
@Slf4j
public class ProductCenterFeignApiWithSentielFallbackFactory implements FallbackFactory<ProductCenterFeignApiWithSentinel> {
    @Override
    public ProductCenterFeignApiWithSentinel create(Throwable throwable) {
        return new ProductCenterFeignApiWithSentinel(){

            @Override
            public ProductInfo selectProductInfoById(String productNo) {
                log.error("原因:{}",throwable);
                ProductInfo productInfo = new ProductInfo();
                productInfo.setProductName("默认商品");
                return productInfo;
            }
        };
    }
}
