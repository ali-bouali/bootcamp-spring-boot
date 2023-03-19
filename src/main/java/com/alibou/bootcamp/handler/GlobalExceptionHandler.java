package com.alibou.bootcamp.handler;

import com.alibou.bootcamp.exception.ObjectValidationException;
import com.alibou.bootcamp.exception.OperationNonPermittedException;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(ObjectValidationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionResponse handle(ObjectValidationException exp) {
    return ExceptionResponse
        .builder()
        .errorMsg("Object not valid")
        .errorSource(exp.getViolationSource())
        .validationErrors(exp.getViolations())
        .build();
  }
  @ExceptionHandler(EntityNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ExceptionResponse handle(EntityNotFoundException exp) {
    return ExceptionResponse
        .builder()
        .errorMsg(exp.getMessage())
        .build();
  }
  @ExceptionHandler(OperationNonPermittedException.class)
  @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
  public ExceptionResponse handle(OperationNonPermittedException exp) {
    return ExceptionResponse
        .builder()
        .errorMsg(exp.getMessage())
        .build();
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ExceptionResponse handle(Exception exp) {
    // log
    log.error("Error occurred: ", exp);
    return ExceptionResponse
        .builder()
        .errorMsg("Oups, an error has occurred. Please contat tbe admin")
        .build();
  }

}
