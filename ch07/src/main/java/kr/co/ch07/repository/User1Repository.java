package kr.co.ch07.repository;

import kr.co.ch07.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// DAO 이다.
@Repository
public interface User1Repository extends JpaRepository<User1, String> { // 첫번째 엔티티와 두번째 PK(@ID) 자료형(DATA TYPE)을 선언
}
