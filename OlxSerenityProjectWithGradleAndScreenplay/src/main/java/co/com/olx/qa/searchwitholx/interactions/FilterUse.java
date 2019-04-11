package co.com.olx.qa.searchwitholx.interactions;

import co.com.olx.qa.searchwitholx.models.SearchWithFilter;
import co.com.olx.qa.searchwitholx.tasks.FilterCategory;
import co.com.olx.qa.searchwitholx.tasks.FilterCity;
import co.com.olx.qa.searchwitholx.tasks.FilterDepartment;
import co.com.olx.qa.searchwitholx.tasks.FilterPrice;
import co.com.olx.qa.searchwitholx.tasks.FilterSubCategory;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FilterUse implements Interaction{

	private SearchWithFilter searchWithFilter;
	
	public FilterUse(SearchWithFilter searchWithFilter) {
		this.searchWithFilter=searchWithFilter;
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub
		
		actor.attemptsTo(FilterDepartment.applyToSearchResults(searchWithFilter));
		actor.attemptsTo(FilterCity.applyToSearchResults(searchWithFilter));
		actor.attemptsTo(FilterCategory.applyToSearchResults(searchWithFilter));
		actor.attemptsTo(FilterSubCategory.applyToSearchResults(searchWithFilter));
		actor.attemptsTo(FilterPrice.applyToSearchResults(searchWithFilter));
		
	}
	
	public static FilterUse applyToSearchResults(SearchWithFilter searchWithFilters) {
		return instrumented(FilterUse.class, searchWithFilters);
	}

}
