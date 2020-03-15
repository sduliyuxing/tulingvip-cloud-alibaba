package com.ribbonconfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Configuration;

/**
 * Created by smlz on 2019/11/20.
 */
@Configuration
public class PayCenterRibbonConfig {

    public IRule roundRobinRule() {
        return new RoundRobinRule();
    }
}
