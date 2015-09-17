package eventmaker.logic.identity;

public class UserAuthorizationException extends Throwable{
    public UserAuthorizationException() {
        super("User didn't authorized");
    }
}
