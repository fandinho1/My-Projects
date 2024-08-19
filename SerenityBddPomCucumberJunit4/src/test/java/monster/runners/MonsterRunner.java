package monster.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/monster.feature",
glue = "monster.stepdefinitions",
snippets = SnippetType.CAMELCASE
)
public class MonsterRunner {

}
