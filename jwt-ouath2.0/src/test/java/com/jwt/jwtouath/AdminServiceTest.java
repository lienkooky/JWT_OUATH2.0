package com.jwt.jwtouath;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jwt.jwtouath.common.MemberType;
import com.jwt.jwtouath.dto.member.response.MemberInfoResponse;
import com.jwt.jwtouath.entity.Member;
import com.jwt.jwtouath.repository.MemberRepository;
import com.jwt.jwtouath.service.AdminService;

@SpringBootTest
public class AdminServiceTest {
	
	private final AdminService adminService;
	private final MemberRepository memberRepository;
	
	@Autowired
	AdminServiceTest(AdminService adminService, MemberRepository memberRepository) {
		this.adminService = adminService;
		this.memberRepository = memberRepository;
	}
	
	@BeforeEach
	@AfterEach
	void clear() {
		memberRepository.deleteAll();
	}
	
	@Test
	void 관리자는_모든_회원정보를_조회할_수_있다() {
		//given
		memberRepository.save(Member.builder()
				.account("jwtId5")
				.password("1234")
				.name("제이더블유티")
				.type(MemberType.USER)
				.build());
		memberRepository.save(Member.builder()
				.account("jwtId5")
				.password("1234")
				.name("제이더블유티1")
				.type(MemberType.USER)
				.build());
		memberRepository.save(Member.builder()
				.account("jwtId5")
				.password("1234")
				.name("제이더블유티2")
				.type(MemberType.USER)
				.build());
		//when
		List<MemberInfoResponse> members = adminService.getMembers();
		//then
		assertThat(members).hasSize(3);
		assertThat(members.get(0).getAccount()).isEqualTo("jwtId5");
		assertThat(members.get(0).getName()).isEqualTo("제이더블유티");
		assertThat(members.get(0).getType()).isEqualTo(MemberType.USER);
		assertThat(members.get(1).getAccount()).isEqualTo("jwtId5");
		assertThat(members.get(1).getName()).isEqualTo("제이더블유티1");
		assertThat(members.get(1).getType()).isEqualTo(MemberType.USER);
		assertThat(members.get(2).getAccount()).isEqualTo("jwtId5");
		assertThat(members.get(2).getName()).isEqualTo("제이더블유티2");
		assertThat(members.get(2).getType()).isEqualTo(MemberType.USER);
	}
	
	@Test
	void 관리자는_모든_관리자정보를_조회할_수_있다() {
		//given
		memberRepository.save(Member.builder()
				.account("jwtId5")
				.password("1234")
				.name("제이더블유티")
				.type(MemberType.USER)
				.build());
		memberRepository.save(Member.builder()
				.account("jwtId5")
				.password("1234")
				.name("제이더블유티1")
				.type(MemberType.USER)
				.build());
		memberRepository.save(Member.builder()
				.account("jwtId5")
				.password("1234")
				.name("제이더블유티2")
				.type(MemberType.USER)
				.build());
		//when
		List<MemberInfoResponse> members = adminService.getAdmins();
		//then
		assertThat(members).hasSize(3);
		assertThat(members.get(0).getAccount()).isEqualTo("jwtId5");
		assertThat(members.get(0).getName()).isEqualTo("제이더블유티");
		assertThat(members.get(0).getType()).isEqualTo(MemberType.USER);
		assertThat(members.get(1).getAccount()).isEqualTo("jwtId5");
		assertThat(members.get(1).getName()).isEqualTo("제이더블유티1");
		assertThat(members.get(1).getType()).isEqualTo(MemberType.USER);
		assertThat(members.get(2).getAccount()).isEqualTo("jwtId5");
		assertThat(members.get(2).getName()).isEqualTo("제이더블유티2");
		assertThat(members.get(2).getType()).isEqualTo(MemberType.USER);
	}

}
