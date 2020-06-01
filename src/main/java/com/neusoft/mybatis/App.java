package com.neusoft.mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.neusoft.po.User;

/**
 * Hello world!
 *
 */
public class App {
    	    public static void main(String[] args)throws Exception {
    	         // 1. 根据SqlMapConfig.xml，读取资源
    	         InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
    	         // 2. 创建SqlSessionFactory，根据全局配置文件SqlMapConfig.xml创建工厂
    	         SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    	         // 3. 创建SqlSession
    	         SqlSession sqlSession = sqlSessionFactory.openSession();
    	         // 4. 使用SqlSession，执行数据库操作
    	         User user = sqlSession.selectOne("test.findUserById", 1);
    	         System.out.println(user);
    	         // 5. 释放资源
    	         sqlSession.close(); 	
//        System.out.println( "Hello World!" );
    }
}
