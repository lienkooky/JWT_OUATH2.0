package com.jwt.jwtouath.service;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.jwtouath.dto.member.requset.MemberUpdateRequest;
import com.jwt.jwtouath.dto.member.response.MemberDeleteResponse;
import com.jwt.jwtouath.dto.member.response.MemberInfoResponse;
import com.jwt.jwtouath.dto.member.response.MemberUpdateResponse;
import com.jwt.jwtouath.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

	private final MemberRepository memberRepository;
	
	@Transactional(readOnly = true)
	public MemberInfoResponse getMemberInfo(UUID id) {
		return memberRepository.findById(id)
				.map(MemberInfoResponse::from)
				.orElseThrow(() -> new NoSuchElementException("존재하지 않는 회원입니다."));
	}
	
	@Transactional
	public MemberDeleteResponse deleteMember(UUID id) {
		if(!memberRepository.existsById(id)) return new MemberDeleteResponse(false);
		
		memberRepository.deleteById(id);
		return new MemberDeleteResponse(true);
	}
	
	@Transactional
	public MemberUpdateResponse updateMember(UUID id, MemberUpdateRequest request) {
		return memberRepository.findById(id)
				.filter(member -> member.getPassword().equals(request.getPassword()))
				.map(member -> {
					member.update(request);
					return MemberUpdateResponse.of(true, member);
				})
				.orElseThrow(() -> new NoSuchElementException("아이디 또는 비밀번호가 일치하지 않습니다."));
	}
}
