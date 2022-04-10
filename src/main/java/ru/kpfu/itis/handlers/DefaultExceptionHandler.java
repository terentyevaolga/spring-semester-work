package ru.kpfu.itis.handlers;

import java.util.logging.Level;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.view.RedirectView;

@ControllerAdvice(annotations = Controller.class)
@Log
public class DefaultExceptionHandler {

  @ExceptionHandler({Throwable.class, NoHandlerFoundException.class})
  public RedirectView handleMyException(Throwable ex) {
    log.log(Level.SEVERE, ex.getMessage());
    String redirect = "error";
    return new RedirectView(redirect);
  }
}
