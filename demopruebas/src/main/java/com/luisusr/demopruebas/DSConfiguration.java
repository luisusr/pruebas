/**
 * 
 */
package com.luisusr.demopruebas;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 * @author luisusr
 *
 */
@Configuration
public class DSConfiguration {
	
	@Bean
	public DataSource dsDataSource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	    ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
	    ds.setUsername("POW_REP");
	    ds.setPassword("POW_REP");
	    ds.setTestOnBorrow(true);
	    ds.setTestOnReturn(true);
	    ds.setTestWhileIdle(true);
        ds.setTimeBetweenEvictionRunsMillis(1800000);
        ds.setNumTestsPerEvictionRun(3);
        ds.setMinEvictableIdleTimeMillis(1800000);
        return ds;
	  }
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dsDataSource());
		//localSessionFactoryBean.setEntityInterceptor(new AuditInterceptor());
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "none");
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		localSessionFactoryBean.setHibernateProperties(hibernateProperties);
		String[] packagesToScan = { "com.luisusr.demopruebas.model" };
		localSessionFactoryBean.setPackagesToScan(packagesToScan);
		return localSessionFactoryBean;
	}
	
//	@Bean
//	public HibernateTransactionManager transactionManager() {
//		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
//		hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
//		return hibernateTransactionManager;
//	}
	
	@Bean
	public HibernateTemplate getHibernateTemplate()
	    {
	       return new HibernateTemplate(sessionFactory().getObject());
	    }

}
