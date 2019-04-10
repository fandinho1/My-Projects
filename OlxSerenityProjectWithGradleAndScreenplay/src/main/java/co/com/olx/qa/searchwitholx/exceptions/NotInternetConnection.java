package co.com.olx.qa.searchwitholx.exceptions;
/**
 * @author LUCHO
 */
public class NotInternetConnection extends AssertionError{
	
public static final String NOT_CONNECTION= "There are not internet connection. Check your connection before continuing";
	
	public NotInternetConnection(String message, Throwable cause) {
		super(message, cause);
	}


}
