$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/SearchGoogle.feature");
formatter.feature({
  "name": "Search in Google",
  "description": "  I want to search a word in google",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "name": "successfull search in google",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tag"
    },
    {
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "name": "Lucho is on google home page",
  "keyword": "Given "
});
formatter.match({
  "location": "SearchGoogleStepDefinition.lucho_is_on_google_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he does the search",
  "keyword": "When "
});
formatter.match({
  "location": "SearchGoogleStepDefinition.he_does_the_search()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he validates successful result",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchGoogleStepDefinition.he_validates_successful_result()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "status": "passed"
});
});