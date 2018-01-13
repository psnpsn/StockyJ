/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.utils;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


/**
 *
 * @author psnpsn
 */
@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = { 
      @ComponentScan("com.psnpsn.stocky.dao"),
      @ComponentScan("com.psnpsn.stocky.service") 
    })
public class AppConfig {
    
    @Autowired
   private Environment env;

   @Bean
   public DataSource getDataSource() {
      PGSimpleDataSource dataSource = new PGSimpleDataSource();
      dataSource.setServerName( "localhost" );  
      dataSource.setDatabaseName( "stocky" );
      dataSource.setUser(env.getProperty("db.username"));
      dataSource.setPassword(env.getProperty("db.password"));
      return dataSource;
   }

   @Bean
   public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
      
      Properties props=new Properties();
      props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
      props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));

      em.setDataSource(getDataSource());
      em.setJpaProperties(props);
      em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
      em.setJpaDialect(new HibernateJpaDialect());
      em.setPackagesToScan("com.psnpsn.stocky.model");
      
      return em;
   }

   @Bean
   public JpaTransactionManager getTransactionManager() {
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(getEntityManagerFactory().getObject());
      return transactionManager;
      
   }
    
}
