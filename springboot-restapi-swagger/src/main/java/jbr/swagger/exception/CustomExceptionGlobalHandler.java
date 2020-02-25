package jbr.swagger.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionGlobalHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    CustomExceptionInfo exceptionInfo = new CustomExceptionInfo(new Date(),
        "From CustomExceptionGlobalHandler METHOD ARGUMENT NOT VALID EXCEPTION", ex.getMessage());

    return new ResponseEntity<Object>(exceptionInfo, HttpStatus.BAD_REQUEST);
  }

  @Override
  protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    CustomExceptionInfo exceptionInfo = new CustomExceptionInfo(new Date(),
        "From CustomExceptionGlobalHandler METHOD NOT SUPPORTED EXCEPTION", ex.getMessage());

    return new ResponseEntity<Object>(exceptionInfo, HttpStatus.METHOD_NOT_ALLOWED);
  }

  @ExceptionHandler(ProductNameNotFoundException.class)
  public final ResponseEntity<Object> handleProductNameNotFoundException(ProductNameNotFoundException ex,
      WebRequest req) {
    CustomExceptionInfo exceptionInfo = new CustomExceptionInfo(new Date(), ex.getMessage(), req.getDescription(false));

    return new ResponseEntity<Object>(exceptionInfo, HttpStatus.NOT_FOUND);
  }
}
