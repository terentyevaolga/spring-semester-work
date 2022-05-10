package ru.kpfu.itis.forms;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignInForm {
    private String name;
    private String password;
}
