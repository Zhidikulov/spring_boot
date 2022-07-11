package web.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import web.model.Role;
import web.model.User;

import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.Properties;
//
//@Configuration
//@EnableTransactionManagement
//@PropertySource("classpath:application.properties")
//@ComponentScan(value="web")
//@RequiredArgsConstructor
//public class HibernateConfig {
//
//
//    private final Environment env;
//
////    @Bean
////    public LocalSessionFactoryBean sessionFactory() {
////        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
////        sessionFactory.setDataSource(dataSource());
////        sessionFactory.setHibernateProperties(hibernateProperties());
////        sessionFactory.setAnnotatedClasses(User.class, Role.class);
////
////        return sessionFactory;
////    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean em
//                = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource());
//        em.setPackagesToScan("web");
////        em.setPersistenceUnitName("");
//
//
//        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        em.setJpaProperties(hibernateProperties());
//
//        return em;
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
//        dataSource.setUrl(env.getProperty("spring.datasource.url"));
//        dataSource.setUsername(env.getProperty("spring.datasource.username"));
//        dataSource.setPassword(env.getProperty("spring.datasource.password"));
//
//        return dataSource;
//    }
//
////    @Bean
////    public PlatformTransactionManager hibernateTransactionManager() {
////        HibernateTransactionManager transactionManager
////                = new HibernateTransactionManager();
////        transactionManager.setSessionFactory(sessionFactory().getObject());
////        return transactionManager;
////    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//
//        return transactionManager;
//    }
//
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
//        return new PersistenceExceptionTranslationPostProcessor();
//    }
//
//
//    private final Properties hibernateProperties() {
//        Properties hibernateProperties = new Properties();
//        hibernateProperties.setProperty(
//                "spring.jpa.show-sql", env.getProperty("spring.jpa.show-sql"));
//        hibernateProperties.setProperty("spring.jpa.hibernate.ddl-auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
//
//        return hibernateProperties;
//    }
//}