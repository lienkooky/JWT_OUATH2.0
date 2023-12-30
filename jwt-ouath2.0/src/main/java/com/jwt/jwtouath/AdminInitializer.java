package com.jwt.jwtouath;

import java.time.LocalDateTime;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.jwt.jwtouath.common.MemberType;
import com.jwt.jwtouath.entity.Member;
import com.jwt.jwtouath.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AdminInitializer implements ApplicationRunner {

	private final MemberRepository memberRepository;
	
	@Override
	public void run(ApplicationArguments args) {
		memberRepository.save(Member.builder()
				.account("admin")
				.password("admin")
				.name("관리자")
				.type(MemberType.ADMIN)
				.createdAt(LocalDateTime.now())
				.build());
	}
	
}
