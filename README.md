# Spring

### 1️⃣ Spring 개요 및 개발환경 구축 실습

#### IntelliJ 기본 설정
1. New UI 설정
File > Settings > Appearance > Compact mode / Show main menu

2. 대소문자 구분 비활성화
File > Settings > Editor > Code Completion > Match case 해제

3. 메서드 접힘 비활성화
File > Settings > Editor > Code Folding > One-line methods 해제

4. 마우스 휠 줌 활성화
File > Settings > Editor > Mouse Control > Change font size with... 체크

---

### 2️⃣ Spring IoC / DI 실습

Spring의 IoC (제어의 역전) 및 DI (의존성 주입) 개념 실습

| 어노테이션            | 설명                                                  |
| ---------------- | --------------------------------------------------- |
| `@Configuration` | 빈 설정용 클래스 지정                                        |
| `@Bean`          | 수동 등록: 컨테이너에 객체(빈) 등록                               |
| `@ComponentScan` | 자동 스캔: `@Component`, `@Service`, `@Repository` 등 탐지 |
| `@Autowired`     | 의존성 자동 주입 (필드, 생성자, 세터)                             |
| `@Component`     | 일반 컴포넌트 등록                                          |
| `@Service`       | 서비스 계층 의미 부여                                        |
| `@Repository`    | DAO/저장소 계층 의미 부여                                    |

1. 수동 Bean 등록 (@Bean)
* Hello, Welcome, Greeting 클래스 수동 등록 후 사용

2. 자동 Bean 등록 (@ComponentScan)
* Computer 클래스가 Cpu, Ram, Hdd를 자동으로 주입받음
* 다양한 방식의 DI 사용 (필드 주입, 생성자 주입, 세터 주입)

### 3️⃣ Spring AOP 실습

### 주요 개념
**JoinPoint (조인포인트)**
→ AOP가 적용될 수 있는 모든 메서드 지점 (예: 서비스 메서드 실행 지점)

**PointCut (포인트컷)**
→ 어떤 메서드에 AOP를 적용할지 지정하는 조건 (ex. 메서드명, 패키지 등)

**Advice (어드바이스)**
→ 실제 실행되는 부가기능 코드 (ex. 로그 출력, 트랜잭션 처리 등)

**Aspect (애스펙트)**
→ PointCut과 Advice를 하나로 묶은 AOP 단위 모듈

**Weaving (위빙)**
→ 핵심 기능 실행 지점에 부가기능을 결합하는 과정 (실행 시점에 삽입됨)

### 어드바이스 종류
* @Before : 핵심 기능 실행 전 부가기능 수행
* @After : 핵심 기능 실행 후 항상 수행
* @AfterReturning : 핵심 기능이 정상적으로 끝난 뒤 수행
* @AfterThrowing : 핵심 기능에서 예외 발생 시 수행
* @Around : 핵심 기능을 전후로 감싸서 실행 제어 (가장 강력)

### 4️⃣ Spring MVC 실습

Spring MVC 구조를 이해하고, DispatcherServlet 기반의 CRUD 기능 구현 실습을 통해 웹 애플리케이션의 흐름을 실습합니다.

* Spring MVC 기반 CRUD 웹 애플리케이션 설계 및 구현
* Java Config 기반 설정 사용 (XML 설정 없이 구성)

### 주요 기능
* Spring MVC 설정 (AppConfig, WebAppInitializer)
* JDBC + DBCP2 + MySQL 연동 (JdbcTemplate)
* 사용자 CRUD (User1Controller, User1Service, User1DAO)
* View 구성: list.jsp, register.jsp, modify.jsp

### 5️⃣ Spring AOP 실습

### 주요 기능
* 사용자 목록 조회
* 사용자 등록
* 사용자 수정
* 사용자 삭제

### Config
* AppConfig: Spring MVC 설정, 뷰 리졸버 & 정적 리소스 등록
* JdbcConfig: DataSource 및 JdbcTemplate 설정
* MybatisConfig: MyBatis SQLSession 설정
* MyWebAppInitializer: WebApplicationInitializer로 DispatcherServlet 등록

### Controller & Service
* User1Controller: 사용자 관련 요청 처리 (GET/POST)
* User1Service: 비즈니스 로직 처리
* User1Mapper: MyBatis Mapper 인터페이스
* mapper/User1Mapper.xml: SQL 정의

### 5️⃣ Spring Boot + MyBatis

* application.properties에서 DB 및 서버 포트 설정
* MyBatis 매퍼 XML 파일 사용

### 주요기능
* /sub1/* : 정적 페이지 매핑 (hello, welcome, greeting)
* /sub2/thymeleaf : Thymeleaf를 이용한 데이터 바인딩 및 화면 출력
* User CRUD 기능 (MyBatis 매퍼와 서비스 레이어 포함)
