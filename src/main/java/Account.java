import java.util.ArrayList;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account implements AccountManagement {
    private static ArrayList<String> usernames;
    private String username;
    private String password;
    private UUID accountID;

    public Account(String courseType){

        this.accountID=UUID.randomUUID();
        this.usernames=new ArrayList<>();
        this.username="";
    }
    public Account(){
        this.usernames=new ArrayList<>();
        this.username="";
    }

    @Override
    public boolean validatePassword(String enteredPassword) {
        String validPassword;
        String regex = "\\b([a-zA-Z]+\\d+\\w*|\\d+[a-zA-Z]+\\w*)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(enteredPassword);
        if(enteredPassword.length()>7) {
            if (matcher.find()) {
                validPassword = matcher.group();
                if (validPassword.equals(enteredPassword))
                    return true;
                else
                    return false;
            }
        }
        return false;
    }

    @Override
    public void setUsername(String newUsername) {
        if(!usernames.contains(username)) {
            this.username = newUsername;
            usernames.add(newUsername);
        }
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
    public void deleteUsername(String username){usernames.remove(username);}

    public UUID getUUID(){
        return this.accountID;
    }
}
