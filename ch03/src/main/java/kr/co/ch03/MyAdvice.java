package kr.co.ch03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAdvice {

    // Pointcut이 무엇인지 수업자료 그림에 나와있음
    @Pointcut("execution(void kr.co.ch03.MyService.insert())")
    // 내용이 없는 메서드
    public void insertPointCut() {}

    // * = select로 시작하는 모든 메서드가 포인트컷이 된다
    // 매개변수 .. = 매개변수의 갯수 제한 없다는 표시
    @Pointcut("execution(void kr.co.ch03.MyService.select*(..))")
    public void selectPointCut() {}

    @Before("insertPointCut() || selectPointCut()")
    public void beforeAdvice() {
        System.out.println("부가기능 - beforeAdvice()");
    }

    @After("insertPointCut() || selectPointCut()")
    public void afterAdvice() {
        System.out.println("부가기능 - afterAdvice()");
    }

    @AfterReturning("insertPointCut()")
    public void afterReturnAdvice() {
        System.out.println("부가기능 - afterReturnAdvice()");
    }

    // 비포 애프터 동시 실행
    // pjp = 핵심 관심..?
    @Around("insertPointCut()")
    public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("부가기능 - aroundAdvice(1)");
        pjp.proceed(); // 핵심 기능 실행
        System.out.println("부가기능 - aroundAdvice(2)");
    }

    // 예외가 발생될 때 실행됨
    @AfterThrowing("selectPointCut()")
    public void afterThrowAdvice() {
        System.out.println("부가기능 - afterThrowAdvice()");
    }

}
