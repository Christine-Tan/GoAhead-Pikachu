package gap.client.datacontroller;

public class AuthorityException extends Exception {
	public AuthorityException() {
		super("Access Denied");
	}

	public AuthorityException(String message) {
		super(message);
	}
}
