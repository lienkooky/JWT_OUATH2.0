package com.jwt.jwtouath.dto.sign_in.response;

import com.jwt.jwtouath.common.MemberType;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SignInResponse {

	@Schema(description = "회원 이름", example = "제이더블유티")
	private String name;
	
	@Schema(description = "회원 유형", example = "USER")
	private MemberType type;
}
