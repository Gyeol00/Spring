package kr.co.ch07.repository;

import kr.co.ch07.entity.Child;
import kr.co.ch07.entity.Parent;
import kr.co.ch07.entity.User1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class User1RepositoryTest {

    @Autowired
    private User1Repository user1Repository;

    @Test
    void findUser1ByUid() {

        // given
        String uid = "A103";

        // when
        User1 user1 = user1Repository.findUser1ByUid("A103");

        // then
        System.out.println(user1);
    }

    @Test
    void findUser1ByName() {

        List<User1> user1List = user1Repository.findUser1ByName("홍길동");
        System.out.println(user1List);

    }

    @Test
    void findUser1ByNameNot() {

        List<User1> user1List = user1Repository.findUser1ByNameNot("홍길동");
        System.out.println(user1List);

    }


    @Test
    void findUser1ByUidAndName() {

        User1 user1 = user1Repository.findUser1ByUidAndName("a103", "홍길동");
        System.out.println(user1);
    }

    @Test
    void findUser1ByUidOrName() {

        User1 user1 = user1Repository.findUser1ByUidOrName("a103", "가나다");
        System.out.println(user1);

    }

    @Test
    void findUser1ByAgeGreaterThan() {

        List<User1> user1List = user1Repository.findUser1ByAgeGreaterThan(10);
        System.out.println(user1List);

    }

    @Test
    void findUser1ByAgeGreaterThanEqual() {

        List<User1> user1List = user1Repository.findUser1ByAgeGreaterThanEqual(32);
        System.out.println(user1List);

    }

    @Test
    void findUser1ByAgeLessThan() {

        List<User1> user1List = user1Repository.findUser1ByAgeLessThan(40);
        System.out.println(user1List);

    }

    @Test
    void findUser1ByAgeLessThanEqual() {

        List<User1> user1List = user1Repository.findUser1ByAgeLessThanEqual(32);
        System.out.println(user1List);

    }

    @Test
    void findUser1ByAgeBetween() {

        List<User1> user1List = user1Repository.findUser1ByAgeBetween(32, 40);
        System.out.println(user1List);
    }

    @Test
    void findUser1ByNameLike() {

        List<User1> user1List = user1Repository.findUser1ByNameLike("장%");
        System.out.println(user1List);

    }

    @Test
    void findUser1ByNameContains() {

        List<User1> user1List = user1Repository.findUser1ByNameContains("장");
        System.out.println(user1List);

    }

    @Test
    void findUser1ByNameStartingWith() {

        List<User1> user1List = user1Repository.findUser1ByNameStartingWith("강");
        System.out.println(user1List);

    }

    @Test
    void findUser1ByNameEndsWith() {

        List<User1> user1List = user1Repository.findUser1ByNameEndsWith("찬");
        System.out.println(user1List);

    }

    @Test
    void findUser1ByOrderByName() {

        List<User1> user1List = user1Repository.findUser1ByOrderByName();
        System.out.println(user1List);
    }

    @Test
    void findUser1ByNameOrderByUid() {

        List<User1> user1List = user1Repository.findUser1ByNameOrderByUid("강감찬");
        System.out.println(user1List);
    }

    @Test
    void findUser1ByOrderByAgeAsc() {

        List<User1> user1List = user1Repository.findUser1ByOrderByAgeAsc();
        System.out.println(user1List);

    }

    @Test
    void findUser1ByOrderByAgeDesc() {
        List<User1> user1List = user1Repository.findUser1ByOrderByAgeDesc();
        System.out.println(user1List);
    }

    @Test
    void findUser1ByAgeGreaterThanOrderByAgeDesc() {

        List<User1> user1List = user1Repository.findUser1ByAgeGreaterThanOrderByAgeDesc(32);
        System.out.println(user1List);

    }

    @Test
    void countUser1ByName() {

        int user1 = user1Repository.countUser1ByName("홍길동");
        System.out.println(user1);

    }



    @Test
    void selectUser1UnderAge30() {

        List<User1> user1List = user1Repository.selectUser1UnderAge30();
        System.out.println(user1List);

    }

    @Test
    void selectUser1ByName() {

        List<User1> user1List = user1Repository.selectUser1ByName("강감찬");
        System.out.println(user1List);

    }

    @Test
    void selectUser1ByNameParam() {

        List<User1> user1List = user1Repository.selectUser1ByNameParam("강감찬");
        System.out.println(user1List);

    }

    @Test
    void selectUser1ByUid() {

        String uid = "A103";

        List<Object[]> list = user1Repository.selectUser1ByUid(uid);

        for(Object[] objects : list) {
            String Uid = (String) objects[0];
            String Name = (String) objects[1];
            int Age = (Integer) objects[2];

            System.out.println(objects);
        }

    }

    @Test
    void selectAllParentWithChild() {

        // given
        String pid = "p101";

        // when
        List<Object[]> list = user1Repository.selectAllParentWithChild(pid);

        //then
        for(Object[] arr : list) {

            Parent parent = (Parent) arr[0];
            Child child = (Child) arr[1];

            System.out.println(parent);
            System.out.println(child);

        }
    }
}