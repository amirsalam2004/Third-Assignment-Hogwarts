public interface AccountManagement {
    public boolean validatePassword(String enteredPassword);
    public void setUsername(String newUsername);
    public void changePassword(String newPassword);
}
