package co.com.olx.qa.searchwitholx.models;
/**
 * @author LUCHO
 */
public class SearchWithFilter {
	private String department;
	private String city;
	private String category;
	private String subCategory;
	private String minPrice;
	private String maxPrice;
	/**
	 * This constructor initializes the filter attributes that are received from the feature datatable
	 * @param department - the title from department filter
	 * @param city - the title from city filter
	 * @param category - the title from category filter
	 * @param subCategory - the title from subCategory filter
	 * @param minPrice - the title from minPrice filter
	 * @param maxPrice - the title from maxPrice filter
	 */
	public SearchWithFilter(String department, String city, String category, String subCategory, String minPrice,
			String maxPrice) {
		this.department = department;
		this.city = city;
		this.category = category;
		this.subCategory = subCategory;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
	}
	
	/**
	 * This method return the department attribute
	 * @return the department attribute
	 */
	public String getDepartment() {
		return department;
	}
	
	/**
	 * This method set the department attribute with the param received
	 * @param department - new title filter department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	
	/**
	 * This method return the city attribute
	 * @return  the city attribute
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * This method set the city attribute with the param received
	 * @param city - new title filter city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * This method return the city attribute
	 * @return the category attribute
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * This method set the category attribute with the param received
	 * @param category - new title filter category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * This method return the subCategory attribute
	 * @return the subCategory attribute
	 */
	public String getSubCategory() {
		return subCategory;
	}
	
	/**
	 * This method set the subCategory attribute with the param received
	 * @param subCategory - new title filter subCategory to set
	 */
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	
	/**
	 * This method return the minPrice attribute
	 * @return the minPrice attribute
	 */
	public String getMinPrice() {
		return minPrice;
	}
	
	/**
	 * This method set the minPrice attribute with the param received
	 * @param minPrice - new filter minPrice to set
	 */
	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}
	
	/**
	 * This method return the maxPrice attribute
	 * @return the maxPrice attribute
	 */
	public String getMaxPrice() {
		return maxPrice;
	}
	
	/**
	 * This method set the maxPrice attribute with the param received
	 * @param maxPrice - new filter maxPrice to set
	 */
	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}	

}
