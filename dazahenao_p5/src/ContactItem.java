import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ContactItem {
    String firstName;
    String secondName;
    String phoneNumber;
    String emailAddress;

    public ContactItem(String firstName, String secondName, String phoneNumber, String emailAddress){
        if (firstName.isBlank() || secondName.isBlank()) {
            throw new IllegalArgumentException("Invalid name, please try again");
        }
        Pattern pattern = Pattern.compile("^(\\d{3}[- .]?){2}\\d{4}$");
        if(!pattern.matcher(phoneNumber).matches()){
            throw new IllegalArgumentException("Invalid phone number, please try again");
        }

        //credit: https://howtodoinjava.com/java/regex/java-regex-validate-email-address/
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern2 = Pattern.compile(regex);
        if(!pattern.matcher(emailAddress).matches()){
            throw new IllegalArgumentException("Invalid email address, please try again");
        }

        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
}

