package ru.kpfu.itis.helper;

public class CheckParametersHelper {
    public static boolean checkName(String name){
        return name.length() > 1 && name.matches("^[\\p{L} .'-]+$");
    }

    public static boolean checkEmail(String email){
        return email.matches("^[a-z0-9-@.]{3,40}$");
    }

    public static boolean checkPassword(String password){
        return password.matches("(?=.*\\d+.*)(?=.*[A-Z]+.*)\\w{4,12}");
    }

    public static boolean checkPhone (String phone) {
        return phone.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
    }

    public static boolean checkComment (String comment) {
        return comment.length() > 10;
    }

}
