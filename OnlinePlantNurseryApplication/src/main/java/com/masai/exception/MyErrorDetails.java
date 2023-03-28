package com.masai.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MyErrorDetails {

	private String message;
	private LocalDateTime timeStamp;
	private String details;
	
}
