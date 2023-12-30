package com.jwt.jwtouath.dto.sign_up.response;

import java.util.UUID;

import com.jwt.jwtouath.entity.Member;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SignUpResponse {

	@Schema(description = "회원 고유키", example = "c0a80121-7aeb-4b4b-8b0a-6b1c032f0e4a")
	private UUID id;
	
	@Schema(description = "회원 아이디", example = "jwtId5")
	private String account;
	
	@Schema(description = "회원 이름", example = "제이더블유티")
	private String name;
	
	@Schema(description = "회원 나이", example = "30")
	private Integer age;
	
	public static SignUpResponse from(Member member) {
		return new SignUpResponse(
				member.getId(),
				member.getAccount(),
				member.getName(),
				member.getAge()
		);
				
	}
	
}
