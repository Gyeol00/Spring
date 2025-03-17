package kr.co.ch07.repository;

import kr.co.ch07.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// DAO 이다.
@Repository
public interface User1Repository extends JpaRepository<User1, String> { // 첫번째 엔티티와 두번째 PK(@ID) 자료형(DATA TYPE)을 선언

    // 쿼리 메서드 실습
    // 메서드 이름 규칙임
    public User1 findUser1ByUid(String uid);

    // select * from user1 where = uid
    public List<User1> findUser1ByName(String username);

    // select * from user1 where name != name
    public List<User1> findUser1ByNameNot(String username);

    // select * from user1 where uid = "uid" and name = "name"
    public User1 findUser1ByUidAndName(String uid, String name);
    public User1 findUser1ByUidOrName(String uid, String name);

    // select * from user1 where age > age
    public List<User1> findUser1ByAgeGreaterThan(int age);

    // select * from user1 where age >= age
    public List<User1> findUser1ByAgeGreaterThanEqual(int age);

    // select * from user1 where age < age
    public List<User1> findUser1ByAgeLessThan(int age);

    // select * from user1 where age <= age
    public List<User1> findUser1ByAgeLessThanEqual(int age);
    public List<User1> findUser1ByAgeBetween(int low, int high);

    public List<User1> findUser1ByNameLike(String name);

    // _, % 사용할 필요없이 포함된 문자열을 찾음
    public List<User1> findUser1ByNameContains(String name);

    // 특정 문자열로 시작하는 것 조회
    public List<User1> findUser1ByNameStartingWith(String name);
    public List<User1> findUser1ByNameEndsWith(String name);

    public List<User1> findUser1ByOrderByName();
    public List<User1> findUser1ByNameOrderByUid(String name);
    public List<User1> findUser1ByOrderByAgeAsc();
    public List<User1> findUser1ByOrderByAgeDesc();

    // select * from user1 where age > age order by age desc
    public List<User1> findUser1ByAgeGreaterThanOrderByAgeDesc(int age);

    public int countUser1ByName(String name);


    // JPQL
    // SQL을 작성할 수 있도록 지원해주는 문법
    // 여기부턴 메서드명 맘대로
    @Query("select u1 from User1 as u1 where u1.age < 30")
    public List<User1> selectUser1UnderAge30();

    @Query("select u1 from User1 as u1 where u1.name = ?1")
    public List<User1> selectUser1ByName(String name);

    @Query("select u1 from User1 as u1 where u1.name = :name")
    public List<User1> selectUser1ByNameParam(@Param("name") String name);

    @Query("select u1.uid, u1.name, u1.age from User1 as u1 where u1.uid = :uid")
    public List<Object[]> selectUser1ByUid(@Param("uid") String uid);

    @Query("select p, c from Parent as p " +
            "join Child as c on p.pid = c.Parent " +
            "where p.pid = :pid")
    public List<Object[]> selectAllParentWithChild(@Param("pid") String pid);



}
