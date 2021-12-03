package com.example.bankapplication.SecurityConfig;

import com.example.bankapplication.Service.CustomerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;


    @Bean
    public UserDetailsService userDetailService(){
        return new CustomerDetailService();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/customer",
                        "/js/**",
                        "/css/**",
                        "/img/**"
                        ).authenticated()
                .antMatchers("/").hasAnyAuthority("CUSTOMER", "STAFF", "ADMIN")
                .antMatchers("/new").hasAnyAuthority("STAFF", "ADMIN")
                .antMatchers("/edit/**", "/delete/**").hasAnyAuthority("ADMIN")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .usernameParameter("kra")
                .defaultSuccessUrl("/customer_home")
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/").permitAll();
    }
}
