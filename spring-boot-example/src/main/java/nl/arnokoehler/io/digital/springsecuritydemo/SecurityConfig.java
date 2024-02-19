package nl.arnokoehler.io.digital.springsecuritydemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

  /**
   * In Spring Security 5.8, the antMatchers, mvcMatchers, and regexMatchers methods were
   * deprecated in favor of new requestMatchers methods.
   * ---------------------------------------------------------
   * These new methods have more secure defaults since they choose the most appropriate RequestMatcher implementation
   * for your application. In summary, the new methods choose the MvcRequestMatcher implementation if
   * your application has Spring MVC in the classpath, falling back to the AntPathRequestMatcher implementation
   * if Spring MVC is not present (aligning the behavior with the Kotlin equivalent methods).
   */
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests((authz) -> authz
            .requestMatchers("/jokes/{id}").hasRole("USER")
            .requestMatchers("/jokes").hasRole("USER")
            .requestMatchers("/random/joke").permitAll()
            .anyRequest().permitAll()
        );
    return http.build();
  }


}
