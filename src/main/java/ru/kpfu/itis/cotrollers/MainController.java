package ru.kpfu.itis.cotrollers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.dto.UserDto;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.security.details.UserDetailsImpl;

@Controller
public class MainController {

    @RequestMapping(method = RequestMethod.GET, value = "/main")
    public ModelAndView saveUser(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        ModelAndView modelAndView = new ModelAndView();
        UserDto userDto = user.toUserDto();
        modelAndView.addObject("user", userDto);
        modelAndView.setViewName("main");
        return modelAndView;
    }
}
