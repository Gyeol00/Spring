package kr.co.ch04.config.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import java.rmi.registry.Registry;

@Configuration
@ComponentScan(basePackages = {"kr.co.ch04"})
@EnableWebMvc
// MVC 사용을 위한 인터페이스 구현
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // ViewResolver 설정(Jsp 경로 위치 설정)
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // ResourceHandler 설정(정적 리소스 경로 설정)
        registry.addResourceHandler("/**").addResourceLocations("/resources/");
    }
}
