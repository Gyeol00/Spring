package org.example.config;


import org.example.sub1.Greeting;
import org.example.sub1.Hello;
import org.example.sub1.Welcome;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// 컴포넌트 동작 시키기
//basePackages는 org.example
@ComponentScan(basePackages = {"org.example"})
public class AppConfig {

    @Bean /* 컨테이너에 생성되는 객체, 현재 총 빈 3개, 추상화 */
    public Hello hello() {
        return new Hello();
    }

    @Bean
    public Welcome welcome() {
        return new Welcome();
    }

    @Bean(name = "ggg")
    public Greeting greeting() {
        return new Greeting();
    }

}
