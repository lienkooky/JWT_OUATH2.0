package com.jwt.jwtouath.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.jwtouath.dto.ApiResponse;
import com.jwt.jwtouath.service.AdminService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "관리자용 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	private final AdminService adminService;
	
	@Operation(summary = "회원 목록 조회")
	@GetMapping("/members")
	public ApiResponse getallMembers() {
		return ApiResponse.success(adminService.getMembers());
	}
	
	@Operation(summary = "관리자 목록 조회")
	@GetMapping("/admins")
	public ApiResponse getAllAdmins() {
		return ApiResponse.success(adminService.getAdmins());
	}

}
