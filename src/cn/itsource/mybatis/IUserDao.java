package cn.itsource.mybatis;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IUserDao {
    //根据ID查询内容
    User getOne(Long id) throws IOException;

    //查询所有内容
    List<User> getAll() throws IOException;

    //新增
    void save(User user) throws IOException;

    //修改
    void update (User user) throws IOException;

    //删除
    void delete(Long id) throws  IOException;

    //根据条件查询
    User getOne1(UserQuery userQuery) throws  IOException;

    //batchDelete批量删除
    void batchDelete(List list) throws IOException;

    //batchInsert批量新增
    void batchInsert(Map mp) throws  IOException;

    //批量修改
   void  batchUpdate(Map map) throws IOException;

   //高级查询
    List<User> queryByCondition(UserQuery userQuery) throws  IOException;

}
