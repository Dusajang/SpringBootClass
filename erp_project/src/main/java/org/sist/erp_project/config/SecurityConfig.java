/*
package org.sist.erp_project.config;

import org.springframework.context.annotation.Bean; import
org.springframework.context.annotation.Configuration; import
org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder; import
org.springframework.security.web.SecurityFilterChain;

@Configuration public class SecurityConfig {


	@Bean SecurityFilterChain securityFilterChain(HttpSecurity http) throws
	Exception { http .csrf(csrf -> csrf.disable()) // CSRF 비활성화 (Deprecated 방지)
		.authorizeHttpRequests(auth -> auth .requestMatchers("/", "/static/**",
				"/css/**", "/js/**", "/images/**").permitAll() // 정적 리소스 허용
				.anyRequest().authenticated() // 나머지 요청은 인증 필요 ) .formLogin(form -> form //
				기본 로그인 페이지 설정 .loginPage("/login") .defaultSuccessUrl("/dashboard", true) //
				로그인 성공 시 리다이렉트 경로 .failureUrl("/login?error=true") // 로그인 실패 시 리다이렉트 경로
				.permitAll() ) .logout(logout -> logout .logoutUrl("/logout") // 로그아웃 경로
						.logoutSuccessUrl("/login?logout") // 로그아웃 성공 후 리다이렉트
						.invalidateHttpSession(true) // 세션 무효화 .deleteCookies("JSESSIONID") // 쿠키 삭제
						); return http.build(); }

	@Bean PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder();
	// 비밀번호 암호화 }


	}
*/