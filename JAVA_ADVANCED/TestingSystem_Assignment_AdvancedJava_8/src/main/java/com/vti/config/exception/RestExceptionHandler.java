package com.vti.config.exception;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vti.config.internationalization.MessageProperty;

@Order(Ordered.HIGHEST_PRECEDENCE)
//@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@SuppressWarnings("unused")
	@Autowired
	private MessageProperty messageProperty;

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<?> handleAll(Exception exception) {

		ApiErrorResponse error = new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
				"Đã có lỗi từ server, Nếu cần hãy liên lạc Admin. abc@vti.com.vn", exception.getMessage());

		return new ResponseEntity<>(error, error.getStatus());
	}

	// not found entity (getByID not found)
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException exception) {
		ApiErrorResponse error = new ApiErrorResponse(HttpStatus.NOT_FOUND,
				"Không tìm thấy tài nguyên bạn yêu cầu, hãy check lại các parameters", exception.getMessage());

		return new ResponseEntity<>(error, error.getStatus());
	}
	
	// not found entity (getByID not found)
		@ExceptionHandler(ConstraintViolationException.class)
		public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException exception) {
			ApiErrorResponse error = new ApiErrorResponse(HttpStatus.BAD_REQUEST,
					"Lỗi khi gửi yêu cầu. Kiểm tra lại giá trị nhập vào!", exception.getMessage());

			return new ResponseEntity<>(error, error.getStatus());
		}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status,
			WebRequest request) {

		ApiErrorResponse error = new ApiErrorResponse(HttpStatus.BAD_REQUEST,
				"Lỗi khi gửi yêu cầu. Kiểm tra lại giá trị nhập vào!", exception.getMessage());

		return new ResponseEntity<>(error, error.getStatus());
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(
			MissingServletRequestParameterException exception, HttpHeaders headers, HttpStatus status,
			WebRequest request) {

		ApiErrorResponse error = new ApiErrorResponse(HttpStatus.BAD_REQUEST,
				"Lỗi không mapping parameters, hãy kiểm tra lại", exception.getMessage());

		return new ResponseEntity<>(error, error.getStatus());
	}

	@Override
	protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ApiErrorResponse error = new ApiErrorResponse(HttpStatus.BAD_REQUEST,
				"Lỗi không mapping parameters, hãy kiểm tra lại", exception.getMessage());

		return new ResponseEntity<>(error, error.getStatus());
	}
}