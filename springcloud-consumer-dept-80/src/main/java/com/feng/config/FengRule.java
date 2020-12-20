package com.feng.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FengRule
{
    //@Bean
    public IRule myRule()
    {
        return new RandomRule();
    }
}
