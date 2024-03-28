package com.humanedu.pjt03.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /* '/resources/**' 로 호출되는 자원은 '/static/' 폴더 아래에서 찾는다 */// 어떤 방식으로 호출했을 때, 어떤 디렉토리(폴더)로 매핑해줄지?
        registry.addResourceHandler("/resources/**") //호출되는 url path pattern
                .addResourceLocations("classpath:/static/") // 실제 resources 이 있는 위치
                .setCachePeriod(1)
                ;
    }
}
