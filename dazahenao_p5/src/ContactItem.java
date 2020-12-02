import java.util.regex.Pattern;

public class ContactItem {
    String firstName;
    String secondName;
    String phoneNumber;
    String emailAddress;


    public ContactItem(String firstName, String secondName, String phoneNumber, String emailAddress){
        if (firstName.isBlank() && secondName.isBlank() && phoneNumber.isBlank() && emailAddress.isBlank()) {
             throw new IllegalArgumentException("Invalid entry, all fields are empty");
         }

        if (firstName.isBlank() && secondName.isBlank()) {
            throw new IllegalArgumentException("Invalid name, please try again");
        } else this.firstName = firstName;

        if (firstName.isBlank() && secondName.isBlank()) {
            throw new IllegalArgumentException("Invalid name, please try again");
        } else this.secondName = secondName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^(\\d{3}[- .]?){2}\\d{4}$");
        if (firstName.isBlank() && secondName.isBlank() && phoneNumber.isBlank() && emailAddress.isBlank()) {
            throw new IllegalArgumentException("Invalid entry, all fields are empty");
        } else {
            if (!pattern.matcher(phoneNumber).matches()) {
                throw new IllegalArgumentException("Invalid phone number, please try again");
            } else {
                this.phoneNumber = phoneNumber;
            }
        }
    }


    //credit: https://howtodoinjava.com/java/regex/java-regex-validate-email-address/
    public void setEmailAddress(String emailAddress) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern2 = Pattern.compile(regex);
        if (firstName.isBlank() && secondName.isBlank() && phoneNumber.isBlank() && emailAddress.isBlank()) {
            throw new IllegalArgumentException("Invalid entry, all fields are empty");
        } else {
            if (!pattern2.matcher(emailAddress).matches()) {
                throw new IllegalArgumentException("Invalid email address, please try again");
            } else {
                this.emailAddress = emailAddress;
            }
        }
    }

    public void update(String firstName, String secondName, String phoneNumber, String emailAdress) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAdress;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

@Override
public String toString(){return String.format("%s %s %s %s",firstName,secondName,phoneNumber,emailAddress);}
}