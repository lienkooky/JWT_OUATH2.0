package com.jwt.jwtouath.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.jwtouath.dto.ApiResponse;
import com.jwt.jwtouath.dto.sign_in.request.SignInRequest;
import com.jwt.jwtouath.dto.sign_up.request.SignUpRequest;
import com.jwt.jwtouath.service.SignService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "회원 가입 및 로그인")
@RequiredArgsConstructor
@RestController
@RequestMapping
public class SignController {
	
	private final SignService signService;
	
	@Operation(summary = "회원 가입")
	@PostMapping("/sign-up")
	public ApiResponse signUp(@RequestBody SignUpRequest request) {
		return ApiResponse.success(signService.registMember(request));
	}
	
	@Operation(summary="로그인")
	@PostMapping("/sign-in")
	public ApiResponse signIn(@RequestBody SignInRequest request) {
		return ApiResponse.success(signService.signIn(request));
	}

}
