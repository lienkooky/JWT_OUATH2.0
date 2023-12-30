package com.jwt.jwtouath;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jwt.jwtouath.common.MemberType;
import com.jwt.jwtouath.dto.sign_in.request.SignInRequest;
import com.jwt.jwtouath.dto.sign_in.response.SignInResponse;
import com.jwt.jwtouath.dto.sign_up.request.SignUpRequest;
import com.jwt.jwtouath.dto.sign_up.response.SignUpResponse;
import com.jwt.jwtouath.entity.Member;
import com.jwt.jwtouath.repository.MemberRepository;
import com.jwt.jwtouath.service.SignService;

@SpringBootTest
public class SignServiceTest {

	private final SignService signService;
	private final MemberRepository memberRepository;
	
	@Autowired
	SignServiceTest(SignService signService, MemberRepository memberRepository) {
		this.signService = signService;
		this.memberRepository = memberRepository;
	}
	
	@BeforeEach
	@AfterEach
	void claer() {
		memberRepository.deleteAll();
	}
	
	@Test
	void 회원가입() {
		// given
		SignUpRequest request = new SignUpRequest("jwtId5", "1234", "제이더블유티", 30);
		// when
		SignUpResponse response = signService.registMember(request);
		// then
		assertThat(response.getAccount()).isEqualTo("jwtId5");
		assertThat(response.getName()).isEqualTo("제이더블유티");
		assertThat(response.getAge()).isEqualTo(30);
	}
	
	@Test
	void 아이디는_중복될_수_없다() {
		// given
		memberRepository.save(Member.builder()
				.account("jwtId5")
				.password("1234")
				.build());
		SignUpRequest requset = new SignUpRequest("jwtId5", "1234", null, null);
		// when
		// then
		Assertions.assertThatThrownBy(() -> signService.registMember(requset))
		.isInstanceOf(IllegalArgumentException.class)
		.hasMessage("이미 사용중인 아이디입니다.");
	}
	
	@Test
	void 로그인() {
		// given
		memberRepository.save(Member.builder()
				.account("jwtId5")
				.password("1234")
				.name("제이더블유티")
				.type(MemberType.USER)
				.build());
		// when
		SignInResponse response = signService.signIn(new SignInRequest("jwtId5", "1234"));
		// then
		assertThat(response.getName()).isEqualTo("제이더블유티");
		assertThat(response.getType()).isEqualTo(MemberType.USER);
	}
	
	@Test
	void 로그인실패() {
		// given
		memberRepository.save(Member.builder()
				.account("jwtId5")
				.password("1234")
				.build());
		// when
		// then
		Assertions.assertThatThrownBy(() -> signService.signIn(new SignInRequest("jwtId5", "12345")))
		.isInstanceOf(IllegalArgumentException.class)
		.hasMessage("아이디 또는 비밀번호가 일치하지 않습니다.");
	}
	
}
