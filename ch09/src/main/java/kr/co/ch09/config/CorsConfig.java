package kr.co.ch09.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer { // addCorsMappings 메서드를 재정의

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        /*
            CORS 설정
             - Cross-Origin-Resource-Sharing
             - 웹 애플리케이션에서 다른 도메인의 리소스에 접근하는 HTTP 정책
             - HTTP 통신은 기본적으로 보안상의 이유로 다른 도메인의 리소스 접근을 차단
             - API로 서비스하기위해 CORS 정책을 허용
        */

        registry.addMapping("/**") // allowedOrigins에서 오는 모든 요청에 허용, 모든 엔드포인트에 대해 CORS를 활성화
                .allowedOrigins("http://127.0.0.1:5500") // 외부 도메인. 허용할 도메인. (html 도메인), 해당 도메인 origin의 요청 허용
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // OPTIONS = 본 get 요청 하기전에 사전 요청으로 OPTIONS 요청을 함. (서버가 살았는지 죽었는지 확인), 허용할 HTTP 메서드를 지정
                .allowedHeaders("*") // 모든 헤더 정보, 모든 헤더를 허용. 필요에 따라 변경할 수 있음.
                .allowCredentials(true) // 자격 증명 허용 여부를 설정
                .maxAge(3600); // pre-flight 요청의 유효 기간을 설정

    }
}
