import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationsClass {

    //FUNCTION TO VALIDATE THE NAME
    //Alphabets should be between A to Z or a to Z And the name should not contain any digit of special character.
    public boolean isValidName(String name)
    {
        Pattern p = Pattern.compile("[a-zA-Z]+\\.?");
        if (name == null) {
            return false;
        }
        Matcher m = p.matcher(name);
        return m.matches();
    }

    //FUNCTION TO VALIDATE THE EMAIL
    public boolean isValidEmail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    //FUNCTION TO VALIDATE THE CONTACT NUMBER
    public boolean isValidContactNumber(String s)
    {
        Pattern p = Pattern.compile("^\\d{10}$");
        Matcher m = p.matcher(s);
        return m.matches();
    }
}
