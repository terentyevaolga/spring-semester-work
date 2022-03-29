package ru.kpfu.itis.config;

import java.util.Objects;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DatabaseConfig {

  @Autowired
  private final Environment environment;

  public DatabaseConfig(Environment environment) {
    this.environment = environment;
  }

  @Bean
  public HikariConfig hikariConfig() {
    HikariConfig hikariConfig = new HikariConfig();
    hikariConfig.setJdbcUrl(environment.getProperty("db.url"));
    hikariConfig.setMaximumPoolSize(Integer.parseInt(Objects.requireNonNull(
        environment.getProperty("db.pool-size"))));
    hikariConfig.setUsername(environment.getProperty("db.user"));
    hikariConfig.setPassword(environment.getProperty("db.password"));
    hikariConfig.setDriverClassName(environment.getProperty("db.driver"));
    return hikariConfig;
  }

  @Bean
  public DataSource dataSource() {
    return new HikariDataSource(hikariConfig());
  }

  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory);
    return transactionManager;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
    hibernateJpaVendorAdapter.setDatabase(Database.POSTGRESQL);
    LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean =
        new LocalContainerEntityManagerFactoryBean();
    containerEntityManagerFactoryBean.setDataSource(dataSource());
    containerEntityManagerFactoryBean.setPackagesToScan("ru.itis.tyshenko.entity");
    containerEntityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
    containerEntityManagerFactoryBean.setJpaProperties(additionalProperties());
    return containerEntityManagerFactoryBean;
  }

  private Properties additionalProperties() {
    Properties properties = new Properties();
    properties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
    properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
    properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
    properties.setProperty("hibernate.connection.CharSet",
        environment.getProperty("hibernate.connection.CharSet"));
    properties.setProperty("hibernate.connection.characterEncoding",
        environment.getProperty("hibernate.connection.characterEncoding"));
    properties.setProperty("hibernate.connection.useUnicode",
        environment.getProperty("hibernate.connection.useUnicode"));
    return properties;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
