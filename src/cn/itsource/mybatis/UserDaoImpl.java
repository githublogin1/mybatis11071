package cn.itsource.mybatis;

import cn.itsource.util.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements  IUserDao {
    @Override
    public User getOne(Long id) throws IOException {
        //读取配置文件
        //SqlSessionFactory 类似于 EntityManagerFactory
        Reader reader = Resources.getResourceAsReader("MyBatis-Config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().
                build(reader);

        //sqlSessionFactory通过 sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //sqlSession完成操作
        User user = (User)sqlSession.selectOne("cn.itsource.mybatis.UserMapper.getOne", id);

        return user;
    }

    @Override
    public List<User> getAll() throws IOException {
        //可用使用工具类
        SqlSession sqlSession = MyBatisUtils.INSTANCE.getSqlSession();
        List<User> users = sqlSession.selectList("cn.itsource.mybatis.UserMapper.getAll");
        return users;
}

    //新增
    @Override
    public void save(User user) throws IOException {
        SqlSession sqlSession = MyBatisUtils.INSTANCE.getSqlSession();
        sqlSession.insert("cn.itsource.mybatis.UserMapper.save",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void update(User user) throws IOException {
        SqlSession sqlSession = MyBatisUtils.INSTANCE.getSqlSession();
        sqlSession.update("cn.itsource.mybatis.UserMapper.update",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void delete(Long id) throws IOException {
        SqlSession sqlSession = MyBatisUtils.INSTANCE.getSqlSession();
        sqlSession.delete("cn.itsource.mybatis.UserMapper.delete",id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public User getOne1(UserQuery userQuery) throws IOException {
        SqlSession sqlSession = MyBatisUtils.INSTANCE.getSqlSession();
        User user = (User)sqlSession.selectOne("cn.itsource.mybatis.UserMapper.getOne1",
                userQuery);
        sqlSession.close();
        return user;
    }

    @Override
    public void batchDelete(List list) throws IOException {
        SqlSession sqlSession = MyBatisUtils.INSTANCE.getSqlSession();
        sqlSession.delete("cn.itsource.mybatis.UserMapper.batchDelete",list);
        sqlSession.commit();
        sqlSession.close();
    }

    //批量新增
    @Override
    public void batchInsert(Map mp) throws IOException {
        SqlSession sqlSession = MyBatisUtils.INSTANCE.getSqlSession();
        sqlSession.insert("cn.itsource.mybatis.UserMapper.batchInsert",mp);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void batchUpdate(Map map) throws IOException {
        SqlSession sqlSession = MyBatisUtils.INSTANCE.getSqlSession();
        sqlSession.update("cn.itsource.mybatis.UserMapper.batchUpdate",map);
        sqlSession.commit();
        sqlSession.close();
    }

    //高级查询
    @Override
    public List<User> queryByCondition(UserQuery userQuery) throws IOException {
        SqlSession sqlSession = MyBatisUtils.INSTANCE.getSqlSession();
        List<User> userList = sqlSession.selectList("cn.itsource.mybatis.UserMapper.queryByCondition",
                userQuery);
        sqlSession.close();

        return userList;

    }
}
