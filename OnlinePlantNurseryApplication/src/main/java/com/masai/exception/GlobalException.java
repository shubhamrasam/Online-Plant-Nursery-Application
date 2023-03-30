package com.masai.exception;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;

import javax.security.auth.login.LoginException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> myLoginExceptionHandler(LoginException ee, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ee.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(AdminException.class)
	public ResponseEntity<MyErrorDetails> myAdminExceptionHandler(AdminException ee, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ee.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrorDetails> myCustomerExceptionHandler(CustomerException ee, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ee.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(OrderException.class)
	public ResponseEntity<MyErrorDetails> myOrderExceptionHandler(OrderException ee, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ee.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(PlanterException.class)
	public ResponseEntity<MyErrorDetails> myPlanterExceptionHandler(PlanterException ee, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ee.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(PlantException.class)
	public ResponseEntity<MyErrorDetails> myPlantExceptionHandler(PlantException ee, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ee.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(SeedException.class)
	public ResponseEntity<MyErrorDetails> mySeedExceptionHandler(SeedException ee, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ee.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<MyErrorDetails> myIllegalArgumentExceptionHandler(IllegalArgumentException ee,
			WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ee.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> myNoExceptionHandler(NoHandlerFoundException ee, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ee.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> myMethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ee) {

		MyErrorDetails err = new MyErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage("Validation Error");
		err.setDetails(ee.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<MyErrorDetails> handleAccessDeniedException(AccessDeniedException ex, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(ex.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

}
