package com.jwt.jwtouath.dto.member.response;

import java.time.LocalDateTime;
import java.util.UUID;

import com.jwt.jwtouath.common.MemberType;
import com.jwt.jwtouath.entity.Member;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MemberInfoResponse {
	
	@Schema(description = "회원 고유키", example = "c0a80121-7aeb-4b4b-8b0a-6b1c032f0e4a")
	private UUID id;
	
	@Schema(description = "회원 아이디", example = "jwtId1")
	private String account;
	
	@Schema(description = "회원 이름", example = "제이더블유티")
	private String name;
	
	@Schema(description = "회원 나이", example = "30")
	private Integer age;
	
	@Schema(description = "회원 타입", example = "USER")
	private MemberType type;
	
	@Schema(description = "회원 생성일", example = "2023-12-30T11:14:00")
	private LocalDateTime createdAt;
	
	/*
	public MemberInfoResponse(UUID id, String account, String name, Integer age, MemberType type, LocalDateTime createdAt) {
		this.id = id;
		this.account = account;
		this.name = name;
		this.age = age;
		this.type = type;
		this.createdAt = createdAt;
	}
	*/
	
	public static MemberInfoResponse from(Member member) {
		return new MemberInfoResponse(
				member.getId(),
				member.getAccount(),
				member.getName(),
				member.getAge(),
				member.getType(),
				member.getCreatedAt()
				);
	}
	

}
