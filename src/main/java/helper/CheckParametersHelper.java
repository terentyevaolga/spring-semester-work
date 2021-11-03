package helper;

public class CheckParametersHelper {
    public static boolean checkName(String name){
        return name.length() > 1 && name.matches("^[\\p{L} .'-]+$");
    }

    public static boolean checkEmail(String email){
        return email.matches("^[a-z0-9-@.]{3,40}$");
    }

    public static boolean checkPassword(String password){
        return password.matches("(?=.*\\d+.*)(?=.*[A-Z]+.*)\\w{4,8}");
    }
}
