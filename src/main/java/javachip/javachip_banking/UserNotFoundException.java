package javachip.javachip_banking;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Integer id) {
        super("Could not find user " + id);
    }
}
