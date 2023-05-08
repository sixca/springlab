package com.kbstar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

//스프링 시큐리티는 웹 애플리케이션의 인증(Authentication)과 권한 부여(Authorization)를 담당
//스프링의 보안 설정 클래스임

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder encodePWD() {    //비밀번호를 안전하게 암호화하는 데 사용. 이렇게 빈으로 담아두고, 비밀번호 암호화 시 해당 빈을 사용하면 됨.
        return new BCryptPasswordEncoder();
    }   //PW암호화 :: Spring Security 프레임워크에서 제공하는 비밀번호 암호화 방식 중 하나임. (내장기능)
    @Override
    protected void configure(HttpSecurity http) throws Exception {   // HTTP 요청에 대한 보안 구성을 정의
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin(CorsConfiguration.ALL);
        configuration.addAllowedMethod(CorsConfiguration.ALL);
        configuration.addAllowedHeader(CorsConfiguration.ALL);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        http.httpBasic()
                .and().authorizeRequests()
                .anyRequest().permitAll()
                .and().cors().configurationSource(source)
                .and().csrf().disable();
    }
}
