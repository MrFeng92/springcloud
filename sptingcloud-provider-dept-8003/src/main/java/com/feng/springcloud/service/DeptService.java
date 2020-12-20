package com.feng.springcloud.service;

import com.feng.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService
{
    boolean addDept(Dept dept);

    Dept queryById(Long id);

    List<Dept> queryAll();
}
