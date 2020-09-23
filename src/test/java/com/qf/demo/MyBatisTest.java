package com.qf.demo;


import com.qf.dao.UserDao;
import com.qf.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class MyBatisTest {


    @Test
    public void testFindAll()throws Exception{

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        List<User> users = userDao.findAll();

        System.out.println(users);

        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testAddUser()throws Exception{

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = new User();
        user.setName("张三");
        user.setPassword("123456");

        userDao.addUser(user);

        System.out.println(user);

        sqlSession.commit();//提交

        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testDeleteUser()throws Exception{

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------

        UserDao userDao = sqlSession.getMapper(UserDao.class);

       userDao.deleteUser("4");

        sqlSession.commit();//提交

        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testUpdateUser()throws Exception{

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = new User();
        user.setId(2);
        user.setName("Jerry");
        user.setPassword("5365463");

        userDao.updateUser(user);

        System.out.println(user);

        sqlSession.commit();//提交

        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testFindById()throws Exception{

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = userDao.findById(2);

        System.out.println(user);


        sqlSession.commit();//提交

        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testFindByName1()throws Exception{

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        /*List<User> list = userDao.findByName1("张");*/
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("name", "%张%");
        List<User> list = userDao.findByName2(map);
       /* List<User> list = userDao.findByName3("张");*/

        System.out.println(list);


        sqlSession.commit();//提交

        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testGetTotalCount()throws Exception{

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        Integer totalCount = userDao.getTotalCount();

        System.out.println(totalCount);


        sqlSession.commit();//提交

        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testFindByPageData()throws Exception{

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("first", 3);
        map.put("pageNum", 3);

        List<User> list = userDao.findByPageData(map);
        System.out.println(list);

        sqlSession.commit();//提交

        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();
    }


}
