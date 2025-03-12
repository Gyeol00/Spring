package kr.co.ch05.dao;

import kr.co.ch05.dto.User1DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// user1.xml에 설정해둔 주소 Mapper를 찾는 어노테이션
@Mapper
public interface User1Mapper {

    // Mapper 파일의 메서드가 실행됨
    public void insertUser1(User1DTO user1DTO);
    public User1DTO selectUser1(String uid);
    public List<User1DTO> selectAllUser1();
    public void updateUser1(User1DTO user1DTO);
    public void deleteUser1(String uid);

}
