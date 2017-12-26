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
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final static String ROLE_ADMIN = "ADMINISTRATOR";
    private final static String ROLE_USER = "USER";
    private final static String ROLE_COMMANDER = "COMMANDER";

    private final UserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfig(@Qualifier("userService") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()

                .antMatchers("/api/command").hasRole(ROLE_COMMANDER)
                .antMatchers("/api/command/**").hasRole(ROLE_COMMANDER)
                .antMatchers("/api/user").hasRole(ROLE_COMMANDER)
                .antMatchers("/api/user/**").hasRole(ROLE_COMMANDER)

                .antMatchers("/api/command").hasRole(ROLE_ADMIN)
                .antMatchers("/api/command/**").hasRole(ROLE_ADMIN)
                .antMatchers("/api/user").hasRole(ROLE_ADMIN)
                .antMatchers("/api/user/**").hasRole(ROLE_ADMIN)

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
