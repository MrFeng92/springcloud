package com.feng.springcloud.pojo;

import java.io.Serializable;

public class Dept implements Serializable
{
    private Long dept_id;//主键
    private String dept_name;
    private String db_source;//对应哪个数据库

    public Dept()
    {
    }

    public Dept(String dept_name)
    {
        this.dept_name = dept_name;
    }

    public Long getDept_id()
    {
        return dept_id;
    }

    public void setDept_id(Long dept_id)
    {
        this.dept_id = dept_id;
    }

    public String getDept_name()
    {
        return dept_name;
    }

    public void setDept_name(String dept_name)
    {
        this.dept_name = dept_name;
    }

    public String getDb_source()
    {
        return db_source;
    }

    public void setDb_source(String db_source)
    {
        this.db_source = db_source;
    }

    @Override
    public String toString()
    {
        return "Dept{" + "dept_id=" + dept_id + ", dept_name='" + dept_name + '\'' + ", db_source='" + db_source + '\'' + '}';
    }
}
