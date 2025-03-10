package org.example;

import org.example.config.AppConfig;
import org.example.sub1.Greeting;
import org.example.sub1.Hello;
import org.example.sub1.Welcome;
import org.example.sub2.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 날짜 : 2025/03/10
 * 이름 : 한결
 * 내용 : ch02. Spring Ioc/DI 실습하기
 * 
 * @Configuration
 *  - 애플리케이션을 구성하는 빈(객체)을 스프링 컨테이너에 등록하기 위한 설정 클래스 어노테이션
 *  
 * @Bean
 *  - 컨테이너에 등록하기 위한 빈 설정 어노테이션
 *  - 사용자 정의 클랙스 등록 어노테이션
 *  
 * @ComponentScan
 *  - basePackage로 시작하는 패키지내의 빈을 스캔해서 컨테이너에 등록시키는 어노테이션
 *  - 스캔 대상 컴포넌트는 @Component(@Service, @Repository) 어노테이션 선언해야 됨
 * 
 * @Autowired
 *  - 컨테이너에 등록되어 있는 빈을 주입하는 어노테이션
 *  - 이름 또는 클래스 타입으로 매칭된 빈을 주입
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /// ////////////////////////////////////////////////////////
        // 기존 객체 생성 방식
        Hello hello = new Hello();
        Welcome welcome = new Welcome();
        Greeting greeting = new Greeting();

        hello.show();
        welcome.show();
        greeting.show();


        /// ////////////////////////////////////////////////////////
        // 스프링 컨테이너 객체 생성
        // 어노테이션 기반 어플리케이션?
        // 컨텍스트 안에 객체를 가져다 씀
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Hello helloBean = context.getBean(Hello.class);
        helloBean.show();

        Welcome welcomeBean = (Welcome) context.getBean("welcome");
        welcomeBean.show();

        // greeting으로 부를 경우 에러남
        Greeting greetingBean = (Greeting) context.getBean("ggg");
        greetingBean.show();

        //@Autowired라는 어노테이션도 있음
        //Greeting greetingBean = (Greeting) context.getBean("greeting");
        //greetingBean.show();


        /// ////////////////////////////////////////////////////////
        // Ioc/DI 기법을 이용한 객체 실습
        Computer computer = (Computer) context.getBean("com");
        computer.show();








    }
}
