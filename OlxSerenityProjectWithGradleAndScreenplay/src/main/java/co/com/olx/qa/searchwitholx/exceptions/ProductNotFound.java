package co.com.olx.qa.searchwitholx.exceptions;
/**
 * @author LUCHO
 */
public class ProductNotFound extends AssertionError{
	
	public static final String PRODUCT_NOT_FOUND= "The product could not be found in the results list";
	public static final String PRODUCT_NOT_MATCH= "The product chosen does not match the search";
	
	public ProductNotFound(String message, Throwable cause) {
		super(message, cause);
	}
	
}
