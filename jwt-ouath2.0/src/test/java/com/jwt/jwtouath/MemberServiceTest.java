package com.jwt.jwtouath;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jwt.jwtouath.common.MemberType;
import com.jwt.jwtouath.dto.member.requset.MemberUpdateRequest;
import com.jwt.jwtouath.dto.member.response.MemberInfoResponse;
import com.jwt.jwtouath.dto.member.response.MemberUpdateResponse;
import com.jwt.jwtouath.entity.Member;
import com.jwt.jwtouath.repository.MemberRepository;
import com.jwt.jwtouath.service.MemberService;

@SpringBootTest
public class MemberServiceTest {

	private final MemberService memberService;
	private final MemberRepository memberRepository;
	
	@Autowired
	MemberServiceTest(MemberService memberService, MemberRepository memberRepository) {
		this.memberService = memberService;
		this.memberRepository = memberRepository;
	}
	
	@BeforeEach
	@AfterEach
	void clear() {
		memberRepository.deleteAll();
	}
	
	@Test
	void 회원조회() {
		// given
		Member savedMember = memberRepository.save(Member.builder()
				.account("jwtId5")
				.password("1234")
				.name("제이더블유티")
				.type(MemberType.USER)
				.build());
		// when
		MemberInfoResponse response = memberService.getMemberInfo(savedMember.getId());
		// then
		assertThat(response.getId()).isEqualTo(savedMember.getId());
		assertThat(response.getAccount()).isEqualTo("jwtId5");
		assertThat(response.getName()).isEqualTo("제이더블유티");
		assertThat(response.getType()).isEqualTo(MemberType.USER);
	}
	
	@Test
	void 존재하지_않는_회원은_예외가_발생한다() {
		// given
		// when
		// then
		assertThatThrownBy(() -> memberService.getMemberInfo(UUID.randomUUID()))
		.isInstanceOf(NoSuchElementException.class)
		.hasMessage("존재하지 않는 회원입니다.");
	}
	
	@Test
	void 회원정보수정() {
		// given
		Member savedMember = memberRepository.save(Member.builder()
				.account("jwtId5")
				.password("1234")
				.build());
		// when
		MemberUpdateRequest request = new MemberUpdateRequest("1234", "5678", "제이더블유티", 27);
		MemberUpdateResponse response = memberService.updateMember(savedMember.getId(), request);
		
		// then
		assertThat(response.isResult()).isEqualTo(true);
		assertThat(response.getName()).isEqualTo("제이더블유티");
		assertThat(response.getAge()).isEqualTo(27);
		
		Member member = memberRepository.findAll().get(0);
		assertThat(member.getPassword()).isEqualTo("5678");
	}
}
