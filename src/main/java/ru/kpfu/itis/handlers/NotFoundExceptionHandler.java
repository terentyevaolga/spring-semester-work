package ru.kpfu.itis.handlers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@Log
@ControllerAdvice
public class NotFoundExceptionHandler {

  @ExceptionHandler({NoHandlerFoundException.class})
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ModelAndView handleMyException(Throwable ex, HttpServletRequest request,
      HttpServletResponse response) {
    ModelAndView modelAndView = new ModelAndView();
    request.setAttribute("status", HttpStatus.NOT_FOUND.name());
    request.setAttribute("message",
        "Nothing was found for your request: '" + request.getServletPath()
    );
    response.setStatus(HttpStatus.NOT_FOUND.value());
    request.setAttribute("date", new SimpleDateFormat("dd.MM.yy HH:mm").format(new Date()));
    modelAndView.setViewName("error");
    log.log(Level.SEVERE, ex.getMessage());
    return modelAndView;
  }
}
