package co.com.olx.qa.searchwitholx.utils;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class FilterUseToSearchResult extends PageObject {

	/**
	 * This method return a Target with a name and a specified location passed by param
	 * @param department - location to set Target
	 * @return the Target department
	 */
	public static Target selectDepartment(String department) {
		return Target.the("The department").locatedBy("//a[@data-location='" + department + ".olx.com.co']");
	}

	/**
	 * This method return a Target with a name and a specified location passed by param
	 * @param city - location to set Target
	 * @return the Target city
	 */
	public static Target selectCity(String city) {
		return Target.the("The city").locatedBy("//a[@data-location='" + city + ".olx.com.co']");

	}

	/**
	 * This method return a Target with a name and a specified location passed by param
	 * @param category - location to set Target
	 * @return the Target category
	 */
	public static Target selectCategory(String category) {
		return Target.the("The category").locatedBy("//a[@href='#'][contains(text(),'" + category + "')]");

	}

	/**
	 * This method return a Target with a name and a specified location passed by param
	 * @param subCategory - location to set Target
	 * @return the Target subCategory
	 */
	public static Target selectSubCategory(String subCategory) {
		return Target.the("The subcategory").locatedBy("//a[@href='#']/h2[contains(text(),'" + subCategory + "')]");
	}

}
