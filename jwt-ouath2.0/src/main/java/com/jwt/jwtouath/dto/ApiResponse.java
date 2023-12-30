package com.jwt.jwtouath.dto;

import com.jwt.jwtouath.common.Apistatus;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApiResponse {
	
	private final Apistatus status;
	
	private final String message;
	
	private final Object data;
	
	public static ApiResponse success(Object data) {
		return new ApiResponse(Apistatus.SUCCESS, null, data);
	}
	
	public static ApiResponse error(String message) {
		return new ApiResponse(Apistatus.ERROR, message, null);
	}
}
