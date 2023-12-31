package com.jwt.jwtouath.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import com.jwt.jwtouath.common.MemberType;
import com.jwt.jwtouath.dto.member.requset.MemberUpdateRequest;
import com.jwt.jwtouath.dto.sign_up.request.SignUpRequest;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity(name = "MEMBER")
public class Member {
	
	@Column(nullable = false, unique = true)
	private String account;
	
	@Column(nullable = false)
	private String password;
	
	private String name;
	
	private Integer age;
	
	@Enumerated(EnumType.STRING)
	private MemberType type;
	
	private LocalDateTime createdAt;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID id;
	
	public static Member from(SignUpRequest request) {
		return Member.builder()
				.account(request.getAccount())
				.password(request.getPassword())
				.name(request.getName())
				.age(request.getAge())
				.type(MemberType.USER)
				.createdAt(LocalDateTime.now())
				.build();
	}
	
	public void update(MemberUpdateRequest newMember) {
		this.password = newMember.getNewPassword() == null || newMember.getNewPassword().isBlank() ? this.password : newMember.getPassword();
		this.name = newMember.getName();
		this.age = newMember.getAge();
	}

}
