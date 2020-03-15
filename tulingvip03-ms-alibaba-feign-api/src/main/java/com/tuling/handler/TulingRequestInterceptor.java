package com.tuling.handler;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.util.UUID;

/**
 * Created by smlz on 2019/11/22.
 */
public class TulingRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        template.header("token", UUID.randomUUID().toString());
    }
}
