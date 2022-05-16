package ru.kpfu.itis.config;

import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import ru.kpfu.itis.helper.FileHelper;

import javax.persistence.EntityManagerFactory;
import javax.servlet.MultipartConfigElement;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(value = "ru.kpfu.itis")
@EnableJpaRepositories(value = "ru.kpfu.itis.repositories")
@EnableTransactionManagement
@EnableWebMvc
public class ApplicationConfig extends WebMvcConfigurationSupport {

  @Value("${file.sharing}")
  private String fileSharing;

  @Value("${file.directory}")
  private String fileLocation;

  @Bean
  public FileHelper fileHelper() {
    return new FileHelper(fileSharing, Paths.get(fileLocation));
  }

  @Bean
  public ViewResolver viewResolver() {
    FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
    viewResolver.setCache(true);
    viewResolver.setPrefix("");
    viewResolver.setSuffix(".ftl");
    viewResolver.setContentType("text/html; charset=UTF-8");

    return viewResolver;
  }

  @Bean
  public FreeMarkerConfigurer freemarkerConfig() {
    FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
    configurer.setTemplateLoaderPath("/WEB-INF/ftl/");
    configurer.setDefaultEncoding("UTF-8");
    return configurer;
  }

  @Bean
  public TransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    JpaTransactionManager manager = new JpaTransactionManager();
    manager.setEntityManagerFactory(entityManagerFactory);
    return manager;
  }

  @Bean
  public JpaVendorAdapter jpaVendorAdapter() {
    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    adapter.setDatabase(Database.POSTGRESQL);
    return adapter;
  }

  @Bean
  public CommonsMultipartResolver multipartResolver() {
    var commonsMultipartResolver = new CommonsMultipartResolver();
    commonsMultipartResolver.setMaxUploadSize(10000000);
    return commonsMultipartResolver;
  }
}
