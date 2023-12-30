package com.jwt.jwtouath.dto.member.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberDeleteResponse {

	@Schema(description = "회원 삭제 성공 여부", example = "true")
	private boolean result;
	
}
