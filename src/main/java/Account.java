import java.util.ArrayList;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account implements AccountManagement {
    private static ArrayList<String> usernames=new ArrayList<>();
    private String username;
    private String password;
    private UUID accountID;

    public Account(String courseType){
        this.accountID=UUID.randomUUID();
        this.username="";
    }

    public Account(){
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
        usernames.add(newUsername);
        this.username = newUsername;
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
    public boolean similarityUsernames(String username){
        if(usernames.contains(username))
            return false;
        return true;
    }
    public UUID getUUID(){
        return this.accountID;
    }
}
