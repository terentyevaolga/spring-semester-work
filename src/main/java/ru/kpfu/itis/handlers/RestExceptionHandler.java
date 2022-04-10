package ru.kpfu.itis.handlers;

import java.util.Date;
import java.util.logging.Level;

import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.dto.ErrorDto;

@Log
@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {

  @ExceptionHandler(Throwable.class)
  public ResponseEntity<ErrorDto> handleException(Throwable e) {
    log.log(Level.SEVERE, e.getMessage());
    ErrorDto response = ErrorDto.builder()
        .message("Упс.., что то пошло не так")
        .date(new Date())
        .build();
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
