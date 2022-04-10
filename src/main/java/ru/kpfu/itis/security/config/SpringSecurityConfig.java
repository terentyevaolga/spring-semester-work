package ru.kpfu.itis.security.config;

import javax.sql.DataSource;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ru.kpfu.itis.filters.CheckParReviewFilter;
import ru.kpfu.itis.filters.CheckParametersFilter;
import ru.kpfu.itis.filters.XssFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@AllArgsConstructor
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

  private final UserDetailsService userDetailsService;
  private final DataSource dataSource;
  private final PasswordEncoder passwordEncoder;
  // filters
  private final XssFilter xssFilter;
  private final CheckParReviewFilter reviewFilter;
  private final CheckParametersFilter parametersFilter;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .addFilterBefore(xssFilter, UsernamePasswordAuthenticationFilter.class)
        .addFilterBefore(reviewFilter, UsernamePasswordAuthenticationFilter.class)
        .addFilterBefore(parametersFilter, UsernamePasswordAuthenticationFilter.class)
        .authorizeRequests()
        .and()
        .formLogin()
        .loginPage("/signin").permitAll()
        .usernameParameter("name")
        .defaultSuccessUrl("/main")
        .failureUrl("/signIn?error")
        .and()
        .logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
        .logoutSuccessUrl("/signin")
        .clearAuthentication(true)
        .invalidateHttpSession(true)
        .deleteCookies("JSESSIONID")
        .and()
        .rememberMe()
        .rememberMeParameter("remember-me").tokenRepository(persistentTokenRepository());
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) {
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
    daoAuthenticationProvider.setUserDetailsService(userDetailsService);
    auth.authenticationProvider(daoAuthenticationProvider);
  }

  @Bean
  public PersistentTokenRepository persistentTokenRepository() {
    JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
    jdbcTokenRepository.setDataSource(dataSource);
    return jdbcTokenRepository;
  }
}
