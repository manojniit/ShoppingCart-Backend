package com.software.employee.configure;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.software.employee.modal.Category;
import com.software.employee.modal.Supplier;

@Configuration
@ComponentScan("com.software.employee")
@EnableTransactionManagement
public class ApplicationContextConfig {
 
    // @Bean configurations go her...
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("org.h2.driver");
	    dataSource.setUrl("jdbc:h2:tcp://localhost/E:/Hibernate");
	    dataSource.setUsername("sa");
	    dataSource.setPassword("sa");
	 
	    return dataSource;
	}
	    private Properties getHibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.show_sql", "true");
	        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	        properties.put("hibernate.hdm2ddl.auto", "update");
	        return properties;
	    }
	
	    @Autowired
	    @Bean(name = "sessionFactory")
	    public SessionFactory getSessionFactory(DataSource dataSource)
	    {
	     
	        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	        sessionBuilder.addProperties(getHibernateProperties());
	        sessionBuilder.addAnnotatedClasses(Category.class);
	        sessionBuilder.addAnnotatedClasses(Supplier.class);
	     
	        return sessionBuilder.buildSessionFactory();
	    }
	    @Autowired
	    @Bean(name = "transactionManager")
	    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	    {
	 HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
	     
	        return transactionManager;
	    }
	

	}