package at.nacs.thymeleafsecurity3.configuration;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
        .antMatchers("/admin").hasRole("ADMIN")
        .antMatchers("/").permitAll()
        .anyRequest().fullyAuthenticated()
        .and()
        .formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
        .and()
        .logout().permitAll();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    PasswordEncoder encoder = passwordEncoder();

    auth
        .inMemoryAuthentication()
        .withUser("user").password(encoder.encode("user")).roles("USER")
        .and()
        .withUser("admin").password(encoder.encode("admin")).roles("ADMIN");
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
