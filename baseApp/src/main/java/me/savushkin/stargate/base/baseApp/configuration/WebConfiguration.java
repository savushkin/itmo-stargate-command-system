package me.savushkin.stargate.base.baseApp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/{path:\\w+}")
                .setViewName("forward:/");
//        registry.addViewController("/{path:?!(oauth)$}/*")
//                .setViewName("forward:/");
    }
}
