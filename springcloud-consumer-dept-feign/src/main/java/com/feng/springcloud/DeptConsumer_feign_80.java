package com.feng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

//Ribbon 和 Eureka 整合以后，客户端可以直接调用，不用关心IP地址和端口号
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.feng.springcloud"})//扫描包，确认API中DeptClientService被扫描到
@ComponentScan("com.feng.springcloud")
//在微服务启动的时候就能去加载我们自定义的Ribbon类
// @RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = FengRule.class)
public class DeptConsumer_feign_80
{
    public static void main(String[] args)
    {
        SpringApplication.run(DeptConsumer_feign_80.class,args);
    }
}
