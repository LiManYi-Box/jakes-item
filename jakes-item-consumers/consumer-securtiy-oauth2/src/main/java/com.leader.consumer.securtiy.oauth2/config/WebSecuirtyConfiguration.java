package com.leader.consumer.securtiy.oauth2.config;

import com.leader.consumer.securtiy.oauth2.config.service.UserDetailsServiceimpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@Configuration
@EnableWebSecurity
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true, securedEnabled = true)
public class WebSecuirtyConfiguration extends WebSecurityConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(WebSecuirtyConfiguration.class);


    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceimpl();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers("/oauth/check_token")
                .antMatchers("/user/login")
        ;
    }

    /**
     * 用于支持 password 模式
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] arr = {"admin","user","khjl"};
        http
                .exceptionHandling()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/user/info").hasAnyAuthority(arr)
                .antMatchers("/user/logout").hasAnyAuthority(arr)
                /*.antMatchers("/login").permitAll()
                .antMatchers("/**")
                .fullyAuthenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .csrf()
                .disable()*/
        ;
    }


}
