package com.jwt.jwtouath.dto.member.response;

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
public class MemberUpdateResponse {
	
	@Schema(description = "회원 정보 수정 성공여부", example = "true")
	private boolean result;
	
	@Schema(description = "회원 이름", example = "제이더블유티")
	private String name;
	
	@Schema(description = "회원 나이", example = "30")
	private Integer age;
	
	public static MemberUpdateResponse of(boolean result, Member member) {
		return new MemberUpdateResponse(result, member.getName(), member.getAge());
	}

}
