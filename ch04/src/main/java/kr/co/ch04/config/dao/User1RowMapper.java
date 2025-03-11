package kr.co.ch04.config.dao;

import kr.co.ch04.config.dto.User1DTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User1RowMapper implements RowMapper<User1DTO> {

    // ResultSet = 셀렉트 결과 객체, DB에서 조회된 결과
    @Override
    public User1DTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        User1DTO dto = new User1DTO();

        dto.setUid(rs.getString(1));
        dto.setName(rs.getString(2));
        dto.setHp(rs.getString(3));
        dto.setAge(rs.getInt(4));

        return dto;

    }
}
