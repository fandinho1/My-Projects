package co.com.olx.qa.searchwitholx.models;
/**
 * @author LUCHO
 */
public class SearchGeneral {
	private String product;
	
	/**
	 * This constructor initializes the product attribute that is received from the feature datatable
	 * @param product - the title product
	 */
	public SearchGeneral(String product) {
		this.product=product;
	}

	/**
	 * This method return the product attribute
	 * @return the product attribute
	 */
	public String getProduct() {
		return product;
	}

	/**
	 * This method set the product attribute with the param received
	 * @param product - new title product to set
	 */
	public void setProduct(String product) {
		this.product = product;
	}
	
}
