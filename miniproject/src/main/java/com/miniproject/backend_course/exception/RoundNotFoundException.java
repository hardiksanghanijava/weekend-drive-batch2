package com.miniproject.backend_course.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RoundNotFoundException extends RuntimeException {
	public RoundNotFoundException(String message) {
		super(message);

	}
}
