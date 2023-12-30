package com.jwt.jwtouath.dto.sign_up.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SignUpRequest {
	
	@Schema(description = "회원 아이디", example = "jwtId1")
	private String account;
	
	@Schema(description = "회원 비밀번호", example = "1234")
	private String password;
	
	@Schema(description = "회원 이름", example = "제이더블유티")
	private String name;
	
	@Schema(description = "회원 나이", example = "30")
	private Integer age;

}
