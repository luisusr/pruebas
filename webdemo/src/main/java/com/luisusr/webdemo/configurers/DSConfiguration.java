package com.luisusr.webdemo.configurers;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author luisusr
 *
 */
@Configuration
@EnableTransactionManagement
public class DSConfiguration {
	private static final Log log = LogFactory.getLog(DSConfiguration.class);
	@Bean
	public DataSource dataSource() {
		log.info("Instanciacion del bean: dataSource JNDI");
		JndiDataSourceLookup jndiObjectFactoryBean = new JndiDataSourceLookup();
		jndiObjectFactoryBean.setResourceRef(true);
		return jndiObjectFactoryBean.getDataSource("jdbc/pruebaWeb");
	}
	
	
//	@Bean
//	public DataSource dsDataSource(){
//		log.info("configucion del DS Config");
//		BasicDataSource ds = new BasicDataSource();
//		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//	    ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
//	    ds.setUsername("POW_REP");
//	    ds.setPassword("POW_REP");
//	    ds.setTestOnBorrow(true);
//	    ds.setTestOnReturn(true);
//	    ds.setTestWhileIdle(true);
//        ds.setTimeBetweenEvictionRunsMillis(1800000);
//        ds.setNumTestsPerEvictionRun(3);
//        ds.setMinEvictableIdleTimeMillis(1800000);
//        return ds;
//	  }
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());
		//localSessionFactoryBean.setEntityInterceptor(new AuditInterceptor());
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "none");
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		hibernateProperties.setProperty("hibernate.show_sql", "false");
		localSessionFactoryBean.setHibernateProperties(hibernateProperties);
		String[] packagesToScan = { "com.luisusr.webdemo.model" };
		localSessionFactoryBean.setPackagesToScan(packagesToScan);
		return localSessionFactoryBean;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
		return hibernateTransactionManager;
	}
	
	@Bean
	public HibernateTemplate hibernateTemplate()
	    {
	       return new HibernateTemplate(sessionFactory().getObject());
	    }

}
