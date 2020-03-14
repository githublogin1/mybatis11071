package cn.itsource.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

//MyBatis工具类
//工具类写法：如果方法比较少 使用静态方法(好调用)
// 如果方法比较多，一般可用使用单例模式
//很多写法：单例模式  (懒汉 饿汉模式 枚举模式 线程安全 不安全)
public enum MyBatisUtils {
    //拿到SqlSession
    INSTANCE;
    //定义变量
    public static  SqlSessionFactory sqlSessionFactory=null;
    static{
        Reader reader = null;
        try {
            //得到reader对象
            reader = Resources.getResourceAsReader("MyBatis-Config.xml");
            //得到SqlSessionFactory对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().
                    build(reader);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("解析配置文件时候出错误了");
        }

    }

  //得到一个sqlSession
    public SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

    //以后可用写其他的方法


}
