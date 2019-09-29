package com.hy.tt.spring.mybatis;


import com.hy.tt.spring.mybatis.dao.TDao;
import com.hy.tt.spring.mybatis.service.TService;
import org.apache.ibatis.logging.log4j.Log4jImpl;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @auther thy
 * @date 2019/9/29
 *
 * mybatis 的一级缓存和二级缓存
 * 一级缓存 ,sqlSession
 * 二级缓存 , sqlSessionFactory
 */
public class DriverConfig {

    public static void main(String[] args) {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://40.73.24.255:3306/cluster_system");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("aPCqY)fsi1YE124d");

        TransactionFactory transactionFactory  = new JdbcTransactionFactory();

        Environment environment =
                new Environment("development", transactionFactory, driverManagerDataSource);
        Configuration configuration = new Configuration(environment);
        configuration.setLogImpl(Log4jImpl.class);
        configuration.addMapper(TDao.class);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        TDao mapper = sqlSession.getMapper(TDao.class);

        TService tService = new TService();
        tService.settDao(mapper);

        tService.query();
        sqlSession.close();

       sqlSession = sqlSessionFactory.openSession();
        TDao mapper1 = sqlSession.getMapper(TDao.class);
        tService.settDao(mapper1);
        tService.query();
    }
}
