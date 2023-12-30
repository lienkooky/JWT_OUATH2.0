package com.jwt.jwtouath.dto.sign_in.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SignInRequest {

	@Schema(description = "회원 아이디", example = "jwtId5")
	private String account;
	
	@Schema(description = "회원 비밀번호", example = "1234")
	private String password;
	
}
