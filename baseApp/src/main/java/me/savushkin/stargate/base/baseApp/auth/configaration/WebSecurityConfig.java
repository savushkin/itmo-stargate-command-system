package me.savushkin.stargate.base.baseApp.auth.configaration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    public final static String ROLE_ADMIN = "ADMINISTRATOR";
    public final static String ROLE_USER = "USER";
    public final static String ROLE_COMMANDER = "COMMANDER";
    public final static String ROLE_SG = "ROLE_SG";

    private final UserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfig(@Qualifier("userService") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()

                .antMatchers("/api/command").hasAnyRole(ROLE_ADMIN, ROLE_COMMANDER)
                .antMatchers("/api/command/**").hasAnyRole(ROLE_ADMIN, ROLE_COMMANDER)
                .antMatchers("/api/user").hasAnyRole(ROLE_ADMIN, ROLE_COMMANDER)
                .antMatchers("/api/user/**").hasAnyRole(ROLE_ADMIN, ROLE_COMMANDER)
                .antMatchers("/api/zone").hasAnyRole(ROLE_ADMIN, ROLE_COMMANDER)
                .antMatchers("/api/zone/**").hasAnyRole(ROLE_ADMIN, ROLE_COMMANDER)
                .antMatchers("/api/mission").hasAnyRole(ROLE_ADMIN, ROLE_COMMANDER)
                .antMatchers("/api/mission/**").hasAnyRole(ROLE_ADMIN, ROLE_COMMANDER)

                .antMatchers("/api/**").hasRole(ROLE_USER)
                .antMatchers("/auth/login").permitAll()
                    .and()
                .csrf().disable();
    }

    @Autowired
    void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
