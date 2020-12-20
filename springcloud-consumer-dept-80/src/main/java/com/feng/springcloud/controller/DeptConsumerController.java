package com.feng.springcloud.controller;

import com.feng.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController //@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
public class DeptConsumerController
{
    //消费者，不应该有service

    @Autowired
    private RestTemplate restTemplate;//提供多种便捷访问远程http服务的方法，简单的restful服务模板
    //方法参数:(String url, @Nullable Object request, Class<T> responseType)

    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    //Ribbon,这里的地址应该是一个变量，通过服务名来访问
    private static final String REST_URL_PREFIX = "http://springcloud-provider-dept";

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable Long id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept)
    {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> queryAll()
    {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }
}
