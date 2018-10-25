package com.yash.demo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages={"com.yash.demo"})
public class SpringConfiguration {

	
	@Autowired
    private Environment env;
    
	@Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // See: application.properties
        System.out.println("driver : "+env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        System.out.println("## getDataSource: " + dataSource);
        return dataSource;
    }
    
	@Autowired
    @Bean(name="dataSource")
    public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
		final DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(dataSource);
        return dataSourceInitializer;
    }
    
    
    @Autowired
    @Bean(name="sessionFactory")
    public LocalSessionFactoryBean getSessionFactory() {            // creating session factory
    	
    	System.out.println("Inside getSessionFactory()::dataSource::>>>>>"+getDataSource());
       
    	LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setPackagesToScan(new String[]{"com.yash"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        
        System.out.println("End getSessionFactory()::<<<<<<<<<<");
        return sessionFactory;
    }
    
    private Properties hibernateProperties() {                  // configure hibernate properties
        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getRequiredProperty("spring.jpa.properties.hibernate.dialect"));
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.format_sql", true);
        properties.put("hibernate.hbm2ddl.auto", "update");
        return properties;
    }
    
  
    @Autowired
    @Bean(name = "transactionManager") 
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
    	System.out.println("Inside getTransactionManager()::sessionFactory::<<<<<<<<<<"+sessionFactory);
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
        System.out.println("End getTransactionManager()::transactionManager::<<<<<<<<<<"+transactionManager);
        return transactionManager;
    }

}
