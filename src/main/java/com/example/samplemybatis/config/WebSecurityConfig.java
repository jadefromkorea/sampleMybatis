package com.example.samplemybatis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
// @EnableWebSecurity는 모든 요청 URL이 스프링 시큐리티의 제어를 받도록 만드는 애너테이션
// @EnableWebSecurity 애너테이션을 사용하면 내부적으로 SpringSecurityFilterChain이 동작하여 URL 필터가 적용된다.
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        // 인증(Authenticate)은 로그인을 의미한다.
//        // 권한(Authorize)은 인증된 사용자가 어떤 것을 할 수 있는지를 의미한다.
//        http.authorizeHttpRequests().requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
//                .and().formLogin().loginPage("/user/login")
//                // 로그아웃 URL을 /user/logout으로 설정하고 로그아웃이 성공하면 루트(/) 페이지로 이동하도록 했다. 그리고 로그아웃시 생성된 사용자 세션도 삭제하도록 처리했다.
//                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/user/logout")).invalidateHttpSession(true);
////                .logoutSuccessUrl("/");

        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/user/login")
                        .permitAll()
                )
                .logout((logout) -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout")).invalidateHttpSession(true));


         /* 스프링 CSRF 토큰이 자동으로 생성된다. 즉, 스프링 시큐리티는 이렇게 발행한 CSRF 토큰의 값이 정확한지 검증하는 과정을 거친다.
         (만약 CSRF 값이 없거나 해커가 임의의 CSRF 값을 강제로 만들어 전송하는 악의적인 URL 요청은 스프링 시큐리티에 의해 블록킹 될 것이다.)
         그런데 H2 콘솔은 이와 같은 CSRF 토큰을 발행하는 기능이 없기 때문에 위와 같은 403 오류가 발생하는 것이다.
         스프링 시큐리티가 CSRF 처리시 H2 콘솔은 예외로 처리할 수 있도록 다음과 같이 설정 파일을 수정
         /h2-console/로 시작하는 URL은 CSRF 검증을 하지 않는다는 설정  */
//                .and().csrf().ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**"))

         /* H2 콘솔의 화면이 frame 구조로 작성되었기 때문에 스프링 시큐리티는 사이트의 콘텐츠가 다른 사이트에 포함되지 않도록 하기 위해 X-Frame-Options 헤더값을 사용하여 이를 방지한다. (clickjacking 공격을 막기위해 사용함)
         이 문제를 해결하기 위해 다음과 같이 설정 파일을 수정
         URL 요청시 X-Frame-Options 헤더값을 sameorigin으로 설정하여 오류가 발생하지 않도록 했다.
         X-Frame-Options 헤더의 값으로 sameorigin을 설정하면 frame에 포함된 페이지가 페이지를 제공하는 사이트와 동일한 경우에는 계속 사용할 수 있다. */
//                .and().headers().addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
//        ;

//        http
//                .authorizeHttpRequests((requests) -> requests
////                        .requestMatchers("/", "/home").permitAll()
////                        .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
//                        .requestMatchers(new AntPathRequestMatcher("/*")).permitAll()
////                        .requestMatchers(new AntPathRequestMatcher("/test")).permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin((form) -> form
//                        .loginPage("/login")
////                                .defaultSuccessUrl("/") // 로그인 페이지의 URL은 /user/login이고 로그인 성공시에 이동하는 디폴트 페이지는 루트 URL(/)임을 의미
//                        .permitAll()
//                )
//                .logout((logout) -> logout.permitAll());

        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }

    @Bean
    PasswordEncoder passwordEncoder() {
        // 암호화를 위해 시큐리티의 BCryptPasswordEncoder 클래스를 사용하여 암호화하여 비밀번호를 저장
        // BCryptPasswordEncoder는 BCrypt 해싱 함수(BCrypt hashing function)를 사용해서 비밀번호를 암호화한다.
        // 하지만 이렇게 BCryptPasswordEncoder 객체를 직접 new로 생성하는 방식보다는 PasswordEncoder 빈(bean)으로 등록해서 사용하는 것이 좋다.
        // 왜냐하면 암호화 방식을 변경하면 BCryptPasswordEncoder를 사용한 모든 프로그램을 일일이 찾아서 수정해야 하기 때문이다.
        //
        // PasswordEncoder는 BCryptPasswordEncoder의 인터페이스이다.
        return new BCryptPasswordEncoder();
    }


    // AuthenticationManager는 스프링 시큐리티의 인증을 담당한다.
    // AuthenticationManager 빈 생성시 스프링의 내부 동작으로 인해
    // serSecurityService와 PasswordEncoder가 자동으로 설정된다.
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
