package kr.co.ch03.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 설정 클래스
// 어노테이션 선언을 위한 클래스
@Configuration
@ComponentScan(basePackages = {"kr.co.ch03"})
// AOP 기능을 사용하기 위한 어노테이션 활성화
@EnableAspectJAutoProxy
public class AppConfig {
}
