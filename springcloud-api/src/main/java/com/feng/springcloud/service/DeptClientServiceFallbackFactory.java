package com.feng.springcloud.service;

import com.feng.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

//服务降级
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory
{
    public DeptClientService create(Throwable throwable)
    {
        return new DeptClientService()
        {
            public Dept queryById(Long id)
            {
                Dept dept = new Dept();
                dept.setDept_id(id);
                dept.setDept_name("id => \" + id + \"没有对应的信息，客户提供了降级的信息，这个服务现在已经被关闭");
                dept.setDb_source("没有数据");

                return dept;
            }

            public List<Dept> queryAll()
            {
                return null;
            }

            public boolean addDept(Dept dept)
            {
                return false;
            }
        };
    }
}
