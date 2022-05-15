package ru.kpfu.itis.handlers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.view.RedirectView;
import ru.kpfu.itis.dto.ErrorDto;

@ControllerAdvice(annotations = Controller.class)
@Log
public class DefaultExceptionHandler {

  @ExceptionHandler({Throwable.class})
  public ModelAndView handleMyException(Throwable ex, HttpServletRequest request,
      HttpServletResponse response) {
    ModelAndView modelAndView = new ModelAndView();
    request.setAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.name());
    request.setAttribute("message", "Internal error, please, contact system administrator");
    response.setStatus(HttpStatus.NOT_FOUND.value());
    request.setAttribute("date", new SimpleDateFormat("dd.MM.yy HH:mm").format(new Date()));
    modelAndView.setViewName("error");
    log.log(Level.SEVERE, ex.getMessage());
    return modelAndView;
  }
}
