package common.exception;

public class UniqueConstraintException extends Exception {
	
	private static final long serialVersionUID = 3854401436456606754L;

	public UniqueConstraintException(String message) {
        super(message);     
	}

}
