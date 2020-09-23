package com.qf.dao;

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public List<User> findAll();

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(String id);

    public User findById(@Param("id") Integer id);

    //模糊查询1
    public List<User> findByName1(String name);
    //模糊查询2
    public List<User> findByName2(Map<String, String> hashMap);
    //模糊查询3
    public List<User> findByName3(String name);

    //获取总记录数
    public Integer getTotalCount();

    //获取分页数据
    public List<User> findByPageData(Map<String, Integer> hashMap);
}
