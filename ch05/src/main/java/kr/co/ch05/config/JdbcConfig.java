package kr.co.ch05.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

// 데이터베이스 설정
@Configuration
public class JdbcConfig {

    @Bean
    public DataSource getDataSource() {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/studydb");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");

        dataSource.setMaxTotal(13); // 최대 커넥션 갯수
        dataSource.setMaxIdle(13); // 최대 유효 연결 커넥션 갯수

        return dataSource;

    }

    // sql을 실행해주는 객체
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
