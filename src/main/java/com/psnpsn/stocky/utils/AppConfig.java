/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.utils;

import com.psnpsn.stocky.model.CategoriePrd;
import com.psnpsn.stocky.model.Fournisseur;
import com.psnpsn.stocky.model.Magasin;
import com.psnpsn.stocky.model.Produit;
import com.psnpsn.stocky.model.User;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.postgresql.ds.PGSimpleDataSource;


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
      //dataSource.setUrl(env.getProperty("db.url"));
      dataSource.setUser(env.getProperty("db.username"));
      dataSource.setPassword(env.getProperty("db.password"));
      return dataSource;
   }

   @Bean
   public LocalSessionFactoryBean getSessionFactory() {
      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
      factoryBean.setDataSource(getDataSource());
      
      Properties props=new Properties();
      props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
      props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));

      factoryBean.setHibernateProperties(props);
      factoryBean.setAnnotatedClasses(Fournisseur.class,User.class,CategoriePrd.class,Magasin.class,Produit.class);
      return factoryBean;
   }

   @Bean
   public HibernateTransactionManager getTransactionManager() {
      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
      transactionManager.setSessionFactory(getSessionFactory().getObject());
      return transactionManager;
      
   }
    
}
