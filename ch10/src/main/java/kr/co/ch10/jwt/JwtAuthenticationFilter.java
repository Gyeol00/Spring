package kr.co.ch10.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
// 토큰 검사
public class JwtAuthenticationFilter extends OncePerRequestFilter { // 하나의 리퀘스트에 대해서 동작하는. 한번의 요청마다 동작, 필터는 컨트롤러 앞에서 동작함, 필터의 리퀘스트에 대해서 토큰을 추출 -> 토큰 검사 후 컨트롤러로 넘김

    private final JwtProvider jwtProvider; // JwtAuthenticationFilter 생성자 jwtProvider 매개변수로 받음
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String tokenPrefix = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 토큰 추출
        String header = request.getHeader(AUTHORIZATION_HEADER);
        log.info(header);

        if(header == null || !header.startsWith(tokenPrefix)){ // Bearer = 메신저. jwt 토큰 문자열 앞에 Bearer 특정 키워드를 붙일건데, Bearer로 시작하는 게 토큰

            // 다음 필터로 넘어가기 (컨트롤러(DispatcherServlet)로 들어가기)
            filterChain.doFilter(request, response);
            return;
        }

        // 토큰
        String token = header.substring(tokenPrefix.length());
        log.info(token);

        // 토큰 검사
        try {
            jwtProvider.validateToken(token);

            // 토큰 검사 성공 - 토큰 안에 있는 username, role을 가지고 정상이면 인증 처리 해줘야 함 -> username, role 엔티티를 만들어서 시큐리티의 컨텍스트 홀더에 엔티티를 저장해줘야 함.
            // 토큰 검사 성공하면 시큐리티 인증처리
            Authentication authentication = jwtProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (Exception e) {
            // 토큰 검사 실패
            log.error("error validating token", e);

            // 빠꾸 시키기
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            return;
        }

        filterChain.doFilter(request, response);

    }
}
