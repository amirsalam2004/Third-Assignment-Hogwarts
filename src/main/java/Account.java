import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account implements AccountManagement {
    private String username;
    // TODO: Passwords should hashed
    private String password;
    private UUID accountID;

    public Account(String courseType){
        this.accountID=UUID.randomUUID();
    }
    public Account(){
    }

    @Override
    public boolean validatePassword(String enteredPassword) {
        String validPassword;
        String regex = "\\b([a-zA-Z]+\\d+\\w*|\\d+[a-zA-Z]+\\w*)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(enteredPassword);
        if(matcher.find()){
            validPassword= matcher.group();
            if(validPassword.equals(enteredPassword))
                return true;
            else
                return false;
        }
        return false;
    }

    @Override
    public void changeUsername(String newUsername) {
        this.username=newUsername;
    }

    @Override
    public void changePassword(String newPassword) {
        this.password=newPassword;
    }
    public String getPassword(){
        return this.password;
    }
    public String getUsername() {
        return this.username;
    }

    public UUID getUUID(){
        return this.accountID;
    }
}
