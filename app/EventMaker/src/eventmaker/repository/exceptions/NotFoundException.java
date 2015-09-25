package eventmaker.repository.exceptions;

public class NotFoundException extends Throwable {
    public NotFoundException(Object identifier) {
        super(identifier + " not found");
    }    
}
