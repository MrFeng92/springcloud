package com.feng.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // @Configuration 相当于spring applicationContext.xml
public class ConfigBean
{

    //配置负载均衡restTemplate

    /**
     * IRule
     * RoundRobinRule 轮询
     * RandomRule 随机
     * AvailabilityFilteringRule: 会先过滤掉，跳闸，访问故障的服务，对剩下的轮询
     * RetryRule: 会先按照轮询获取服务，如果获取服务失败，则会在指定的时间内进行重试
     * @return
     */
    @Bean
    @LoadBalanced //Ribbon注解
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
