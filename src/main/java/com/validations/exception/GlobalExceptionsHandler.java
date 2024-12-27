package com.validations.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *  @RestControllerAdvice for exception handling in Restful API. 
 *  The @RestControllerAdvice annotation in Spring Boot is used to handle exceptions across the entire application in a global, not duplicated manner.
 *  It is typically used in conjunction with the @ExceptionHandler annotation to define methods that handle exceptions thrown by controllers.
 *  
 *  1.@RestControllerAdvice is a specialization of the @ControllerAdvice annotation that includes the @ResponseBody to ensure responses are written directly to the HTTP response body.
 *  2.It allows for the global handling of exceptions across multiple controllers.
 *  3. Helps in building a cleaner error-handling mechanism by centralizing response handling.
 */
@RestControllerAdvice
public class GlobalExceptionsHandler {
	
	/**
	 * 1. Create a @RestControllerAdvice annotated class.
     * 2. Define methods within this class using @ExceptionHandler.
	 * @param exceptions
	 * @return
	 */

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleInvalidArguments(MethodArgumentNotValidException exceptions){
		Map<String,String> errorMap=new HashMap();
		exceptions.getBindingResult().getFieldErrors().forEach(error->{
			errorMap.put(error.getField(),error.getDefaultMessage());
		});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
	}
	
	/**
	 * this is single method argumentexceptions
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource not found: " + ex.getMessage());
    }
	@ExceptionHandler(UserNotFoundExceptions.class)
    public ResponseEntity<String> handleResourceNotFoundException(UserNotFoundExceptions ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
