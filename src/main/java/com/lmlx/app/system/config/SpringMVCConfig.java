package com.lmlx.app.system.config;

/**
 * @author jiahao jin
 * @create 2020-05-12 14:26
 */

import com.lmlx.app.system.CheckLoginOutInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@SpringBootConfiguration
public class SpringMVCConfig extends WebMvcConfigurerAdapter {

    @Bean
    public CheckLoginOutInterceptor checkLoginOutInterceptor() {
        return new CheckLoginOutInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(checkLoginOutInterceptor()).addPathPatterns("/**");
    }
}