package ru.kpfu.itis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import ru.kpfu.itis.helper.FileHelper;

import java.nio.file.Paths;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(value = "ru.kpfu.itis")
public class ApplicationConfig extends WebMvcConfigurationSupport {

  @Value("${file.sharing}")
  private String fileSharing;

  @Value("${file.directory}")
  private String fileLocation;

  @Override
  protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler(fileSharing + "/**")
        .addResourceLocations("file://" + Paths.get(fileLocation) + "/");
  }


  @Bean
  public FileHelper fileHelper() {
    return new FileHelper(fileSharing, Paths.get(fileLocation));
  }
}
