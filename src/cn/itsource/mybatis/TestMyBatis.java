package cn.itsource.mybatis;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMyBatis {

    @Test
    public void testMybatis() throws Exception{

        IUserDao userDao = new UserDaoImpl();
        System.out.println(userDao.getOne(1L));
    }

    @Test
    public void testGetOne1() throws Exception{

        IUserDao userDao = new UserDaoImpl();
        UserQuery userQuery = new UserQuery();
        //userQuery.setId(2L);
        userQuery.setName("丁丁同学");
        System.out.println(userDao.getOne1(userQuery));
    }

    //查询所有的内容
    @Test
    public void testGetAll() throws Exception{
        IUserDao userDao = new UserDaoImpl();
        System.out.println(userDao.getAll());
    }

    @Test
    public void testSave() throws Exception{

        IUserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setName("小刚刚和大科宇一起");
        userDao.save(user);
        //返回id 装到user对象里面
        System.out.println(user);

    }

    @Test
    public void testUpdate() throws Exception{

        IUserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setId(3L);
        user.setName("张富民");
        userDao.update(user);
    }

    @Test
    public void testDelete() throws Exception{

        IUserDao userDao = new UserDaoImpl();
          userDao.delete(3L);
    }

    //测试批量删除
    @Test
    public void testBatchDelete() throws Exception{

        IUserDao userDao = new UserDaoImpl();
        List list = new ArrayList();
        list.add(5L);
        list.add(6L);
        list.add(7L);
        userDao.batchDelete(list);
    }
    //批量新增
    @Test
    public void testBatchInsert() throws Exception{

        IUserDao userDao = new UserDaoImpl();
        Map mp = new HashMap();
        List namesList = new ArrayList();
        namesList.add("段理");
        namesList.add("桐桐");
        namesList.add("鹏鹏");
        mp.put("namesList",namesList);

        userDao.batchInsert(mp);
    }



    //批量修改
    @Test
    public void testBatchUpdate() throws Exception{

        IUserDao userDao = new UserDaoImpl();
        Map mp = new HashMap();
        List idsList = new ArrayList();
        idsList.add(11L);
        idsList.add(12L);
        idsList.add(13L);
        mp.put("ids",idsList);
        mp.put("name","dlttpp组合成3p");

        userDao.batchUpdate(mp);
    }

    //模板
    @Test
    public void testqueryByCondition() throws Exception{

        IUserDao userDao = new UserDaoImpl();

        UserQuery userQuery = new UserQuery();
           userQuery.setName("dlttpp组合成3p");
        userQuery.setId(13L);
        System.out.println(userDao.queryByCondition(userQuery));
    }


    @Test
    public void test11() throws Exception{
        Person p = new Person();
        Person p1 = new Person(2L,"yyy");
        Person p2 = new Person(1L);
        p.setId(1L);
        p.setName("xxx");

        System.out.println(p);
        System.out.println(p1);
        System.out.println(p2);

    }




}
