package cafe;

public class PasswordException extends RuntimeException{

	public PasswordException(){
		super("Incorrect Password");
	}
}
