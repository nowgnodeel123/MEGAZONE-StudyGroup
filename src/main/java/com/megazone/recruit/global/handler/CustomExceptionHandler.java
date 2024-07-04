package com.megazone.recruit.global.handler;

import com.megazone.recruit.global.handler.exception.CustomApiException;
import com.megazone.recruit.global.handler.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<?> customException(CustomException e) {
    return new ResponseEntity<>(Script.back(e.getMessage()), e.getStatus());
  }

  @ExceptionHandler(CustomApiException.class)
  public ResponseEntity<?> customApiException(CustomApiException e) {
    return new ResponseEntity<>(new ResponseDto<>(-1, e.getMessage(), null), e.getStatus());
  }
}