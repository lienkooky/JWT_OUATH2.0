package com.jwt.jwtouath.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.jwtouath.common.MemberType;
import com.jwt.jwtouath.dto.member.response.MemberInfoResponse;
import com.jwt.jwtouath.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminService {

	private final MemberRepository memberRepository;
	
	@Transactional(readOnly = true)
	public List<MemberInfoResponse> getMembers() {
		return memberRepository.findAllByType(MemberType.USER).stream()
				.map(MemberInfoResponse::from)
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<MemberInfoResponse> getAdmins() {
		return memberRepository.findAllByType(MemberType.ADMIN).stream()
				.map(MemberInfoResponse::from)
				.collect(Collectors.toList());
	}
}
