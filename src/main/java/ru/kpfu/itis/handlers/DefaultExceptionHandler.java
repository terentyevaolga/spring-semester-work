package ru.kpfu.itis.handlers;

import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import ru.kpfu.itis.dto.ErrorDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

@ControllerAdvice(annotations = Controller.class)
@Log
public class DefaultExceptionHandler {


  @ExceptionHandler({Throwable.class})
  public String handleMyException(Throwable ex, HttpServletRequest request, Model model, HttpServletResponse response) {
    ErrorDto errorDto = new ErrorDto();
    if (ex instanceof NoHandlerFoundException) {
      errorDto.setStatus(HttpStatus.NOT_FOUND.name());
      errorDto.setMessage("Nothing was found for your request: '" + request.getServletPath());
      response.setStatus(HttpStatus.NOT_FOUND.value());
    } else {
      errorDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());
      errorDto.setMessage("Internal error, please, contact system administrator");
      response.setStatus(HttpStatus.NOT_FOUND.value());
    }
    errorDto.setDate(new SimpleDateFormat("dd.MM.yy HH:mm").format(new Date()));
    model.addAttribute("errorInfo", errorDto);
    log.log(Level.SEVERE, ex.getMessage());
    return "error";
  }
}
