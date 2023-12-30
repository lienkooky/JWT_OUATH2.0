package com.jwt.jwtouath.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.jwtouath.dto.sign_in.request.SignInRequest;
import com.jwt.jwtouath.dto.sign_in.response.SignInResponse;
import com.jwt.jwtouath.dto.sign_up.request.SignUpRequest;
import com.jwt.jwtouath.dto.sign_up.response.SignUpResponse;
import com.jwt.jwtouath.entity.Member;
import com.jwt.jwtouath.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SignService {

	private final MemberRepository memberRepository;
	
	@Transactional
	public SignUpResponse registMember(SignUpRequest request) {
		Member member = memberRepository.save(Member.from(request));
		
		try {
			memberRepository.flush();
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("이미 사용중인 아이디 입니다.");
		}
		return SignUpResponse.from(member);
	}
	
	@Transactional(readOnly = true)
	public SignInResponse signIn(SignInRequest request) {
		Member member = memberRepository.findByAccount(request.getAccount())
				.filter(account -> account.getPassword().equals(request.getPassword()))
				.orElseThrow(() -> new IllegalAccessError("아이디 또는 비밀번호가 일치하지 않습니다."));
		
		return new SignInResponse(member.getName(), member.getType());
	}
}
