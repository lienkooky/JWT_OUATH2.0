package com.jwt.jwtouath.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.jwtouath.swagger.SwaggerConfig;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "관리자용 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	private final SwaggerConfig adminService;
	

}
