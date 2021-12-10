package com.dbs.springbootjdbctemplate.advice;
import javax.validation.ConstraintViolationException;



import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.dbs.springbootjdbctemplate.apierror.ApiError;
import com.dbs.springbootjdbctemplate.exception.EntityNotFoundException;
@ControllerAdvice
public class EmployeeControllerAdvice extends ResponseEntityExceptionHandler {
@ExceptionHandler(EntityNotFoundException.class)
protected ResponseEntity<Object>handleNotFoundEntity(EntityNotFoundException e){
ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
apiError.setMessage(e.getMessage());
return buildResponseEntity(apiError);
}
private ResponseEntity<Object> buildResponseEntity(ApiError apiError){
return new ResponseEntity<>(apiError,apiError.getStatus());
}
@Override
protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
HttpHeaders headers, HttpStatus status, WebRequest request) {
// TODO Auto-generated method stub
ApiError apiError= new ApiError(HttpStatus.BAD_REQUEST);
System.out.println(apiError.toString());
apiError.setMessage("validation erroror");
apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());
apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
return buildResponseEntity(apiError);



}
protected ResponseEntity<Object>handleConstraintViolation(javax.validation.ConstraintViolationException ex){
ApiError apiError= new ApiError(HttpStatus.BAD_REQUEST);
System.out.println(apiError.toString());
apiError.setMessage("validation erroror");
apiError.addValidationErrors(ex.getConstraintViolations());
return buildResponseEntity(apiError);



}
}