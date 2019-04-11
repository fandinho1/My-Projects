package co.com.olx.qa.searchwitholx.stepsdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.Is.is;

import org.openqa.selenium.WebDriver;
import co.com.olx.qa.searchwitholx.userinterfaces.OlxHomePage;
import co.com.olx.qa.searchwitholx.exceptions.NotInternetConnection;
import co.com.olx.qa.searchwitholx.questions.TheInternet;
import co.com.olx.qa.searchwitholx.questions.TheSearchResult;
import co.com.olx.qa.searchwitholx.tasks.GeneralProductSearch;
import co.com.olx.qa.searchwitholx.tasks.RandomProductSearch;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import java.util.List;

import co.com.olx.qa.searchwitholx.models.SearchGeneral;
import co.com.olx.qa.searchwitholx.models.SearchWithFilter;
import co.com.olx.qa.searchwitholx.exceptions.ProductNotFound;
import co.com.olx.qa.searchwitholx.interactions.FilterUse;
import co.com.olx.qa.searchwitholx.questions.TheProduct;
import co.com.olx.qa.searchwitholx.questions.TheRandomProduct;
import co.com.olx.qa.searchwitholx.tasks.FilterCategory;
import co.com.olx.qa.searchwitholx.tasks.FilterDepartment;
import co.com.olx.qa.searchwitholx.tasks.SpecificProductSearch;

public class SearchProductWithOlxStepDefinition {
	private OlxHomePage olxHomePage;
	private static final int CURRENT_USER = 0;

	@Managed
	private WebDriver hisBrowser;
	private Actor lucho = Actor.named("Lucho");

	@Before
	public void actorCanBrowseOlxPage() {
		lucho.can(BrowseTheWeb.with(hisBrowser));
		lucho.should(seeThat(TheInternet.isConnected(), is(true)).orComplainWith(NotInternetConnection.class,
				NotInternetConnection.NOT_CONNECTION));
	}

	@Given("^Lucho is in the site olx$")
	public void luchoIsInTheSiteOlx() {
		lucho.wasAbleTo(Open.browserOn().the(olxHomePage));
	}

	@When("^he search a product in the bar search$")
	public void heSearchTheProductInTheBarSearch(List<SearchGeneral> searchGeneral) {
		lucho.attemptsTo(GeneralProductSearch.byGeneralSearch(searchGeneral.get(CURRENT_USER)));
	}

	@Then("^he verify that there are results$")
	public void heVerifyThatThereAreResults() {
		lucho.should(seeThat(TheSearchResult.areDisplayed(), is(true)));
	}

	@Given("^Lucho applies filters to search results$")
	public void luchoAppliesFiltersToSearchResults(List<SearchWithFilter> searchWithFilters) {
		lucho.attemptsTo(FilterUse.applyToSearchResults(searchWithFilters.get(CURRENT_USER)));
	}

	@When("^he search the specific product \"([^\"]*)\"$")
	public void heSearchTheSpecificProduct(String product) {
		lucho.attemptsTo(SpecificProductSearch.inSearchResults(product));
	}

	@Then("^he verify that the product \"([^\"]*)\" is loaded$")
	public void heVerifyThatTheProductIsLoaded(String product) {
		lucho.should(seeThat(TheProduct.searched(), is(product)).orComplainWith(ProductNotFound.class,
				ProductNotFound.PRODUCT_NOT_MATCH));
	}
	
	@Given("^Lucho applies department and category filters to search results$")
	public void luchoAppliesDepartmentAndCategoryFiltersToSearchResults(List<SearchWithFilter> searchWithFilters) {
		lucho.attemptsTo(FilterDepartment.applyToSearchResults(searchWithFilters.get(CURRENT_USER)));
		lucho.attemptsTo(FilterCategory.applyToSearchResults(searchWithFilters.get(CURRENT_USER)));
	}

	@When("^he search a random product$")
	public void heSearchARandomProduct() {
		lucho.attemptsTo(RandomProductSearch.inSearchResults());
	}

	@Then("^he verify that the product is loaded$")
	public void heVerifyThatTheProductIsLoaded() {
		lucho.should(seeThat(TheRandomProduct.isSelectedSuccessfully(), is(true)).orComplainWith(ProductNotFound.class,
				ProductNotFound.PRODUCT_NOT_FOUND));
	}
}
