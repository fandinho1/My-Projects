$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/SearchYandexWithSikulix.feature");
formatter.feature({
  "name": "Search in Yandex",
  "description": "  I want to search a word in yandex",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@SmokeTest"
    }
  ]
});
formatter.scenario({
  "name": "successfull search in yandex",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@SmokeTest"
    },
    {
      "name": "@tag1"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Lucho is on yandex home page",
  "keyword": "Given "
});
formatter.match({
  "location": "SearchYandexWithSikulixStepDefinition.luchoIsOnYandexHomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he does the search",
  "keyword": "When "
});
formatter.match({
  "location": "SearchYandexWithSikulixStepDefinition.heDoesTheSearch()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he validates successful result",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchYandexWithSikulixStepDefinition.heValidatesSuccessfulResult()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "status": "passed"
});
});