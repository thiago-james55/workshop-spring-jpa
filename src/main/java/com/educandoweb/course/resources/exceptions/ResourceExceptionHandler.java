package com.educandoweb.course.resources.exceptions;

import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

     @ExceptionHandler(ResourceNotFoundException.class)
     public ResponseEntity<StardardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {

          String error = "Resource not found!";
          HttpStatus status = HttpStatus.NOT_FOUND;
          StardardError stdError = new StardardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
          return ResponseEntity.status(status).body(stdError);
     }
     @ExceptionHandler(DatabaseException.class)
     public ResponseEntity<StardardError> database(DatabaseException e, HttpServletRequest request) {

          String error = "Database Error!";
          HttpStatus status = HttpStatus.BAD_REQUEST;
          StardardError stdError = new StardardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
          return ResponseEntity.status(status).body(stdError);
     }
}
