$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/GoogleSearchWithData.feature");
formatter.feature({
  "name": "Search in google with data from feature",
  "description": "  LUCHO wants to do  a search in google with data",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Title of your scenario outline",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag2"
    }
  ]
});
formatter.step({
  "name": "He is in the site google",
  "keyword": "Given "
});
formatter.step({
  "name": "He search the word \"\u003cword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "He verify that the word \"\u003cword\u003e\" is in the results",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "word"
      ]
    },
    {
      "cells": [
        "switch"
      ]
    },
    {
      "cells": [
        "sophos solutions"
      ]
    },
    {
      "cells": [
        "jdfghkjdfghkjsdh"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Title of your scenario outline",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag"
    },
    {
      "name": "@tag2"
    }
  ]
});
formatter.step({
  "name": "He is in the site google",
  "keyword": "Given "
});
formatter.match({
  "location": "GoogleSearchWithDataStepDefinition.heIsInTheSiteGoogle()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "He search the word \"switch\"",
  "keyword": "When "
});
formatter.match({
  "location": "GoogleSearchWithDataStepDefinition.heSearchTheWord(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "He verify that the word \"switch\" is in the results",
  "keyword": "Then "
});
formatter.match({
  "location": "GoogleSearchWithDataStepDefinition.heVerifyThatTheWordIsInTheResults(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Title of your scenario outline",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag"
    },
    {
      "name": "@tag2"
    }
  ]
});
formatter.step({
  "name": "He is in the site google",
  "keyword": "Given "
});
formatter.match({
  "location": "GoogleSearchWithDataStepDefinition.heIsInTheSiteGoogle()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "He search the word \"sophos solutions\"",
  "keyword": "When "
});
formatter.match({
  "location": "GoogleSearchWithDataStepDefinition.heSearchTheWord(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "He verify that the word \"sophos solutions\" is in the results",
  "keyword": "Then "
});
formatter.match({
  "location": "GoogleSearchWithDataStepDefinition.heVerifyThatTheWordIsInTheResults(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Title of your scenario outline",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag"
    },
    {
      "name": "@tag2"
    }
  ]
});
formatter.step({
  "name": "He is in the site google",
  "keyword": "Given "
});
formatter.match({
  "location": "GoogleSearchWithDataStepDefinition.heIsInTheSiteGoogle()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "He search the word \"jdfghkjdfghkjsdh\"",
  "keyword": "When "
});
formatter.match({
  "location": "GoogleSearchWithDataStepDefinition.heSearchTheWord(String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.TimeoutException: Expected condition failed: waiting for element to be clickable: By.name: btnK (tried for 5 second(s) with 500 milliseconds interval)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027LAPTOP-L2D6D9IH\u0027, ip: \u0027172.23.85.81\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_201\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, acceptSslCerts: false, applicationCacheEnabled: false, browserConnectionEnabled: false, browserName: chrome, chrome: {chromedriverVersion: 73.0.3683.68 (47787ec04b6e3..., userDataDir: C:\\Users\\SEMILL~1\\AppData\\L...}, cssSelectorsEnabled: true, databaseEnabled: false, goog:chromeOptions: {debuggerAddress: localhost:64805}, handlesAlerts: true, hasTouchScreen: false, javascriptEnabled: true, locationContextEnabled: true, mobileEmulationEnabled: false, nativeEvents: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), rotatable: false, setWindowRect: true, strictFileInteractability: false, takesHeapSnapshot: true, takesScreenshot: true, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unexpectedAlertBehaviour: ignore, unhandledPromptBehavior: ignore, version: 73.0.3683.86, webStorageEnabled: true}\nSession ID: bc6a7cf44a3f34b9ddca682845ed9663\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:95)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:272)\r\n\tat utilidadesdesarrollo.BasePage.waitClickable(BasePage.java:30)\r\n\tat utilidadesdesarrollo.BasePage.click(BasePage.java:36)\r\n\tat co.com.google.pom.SearchGoogleWithDataPom.darClicEnBuscar(SearchGoogleWithDataPom.java:23)\r\n\tat co.com.google.qa.searchwithdata.stepsdefinitions.GoogleSearchWithDataStepDefinition.heSearchTheWord(GoogleSearchWithDataStepDefinition.java:36)\r\n\tat ✽.He search the word \"jdfghkjdfghkjsdh\"(file:src/test/resources/features/GoogleSearchWithData.feature:26)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "He verify that the word \"jdfghkjdfghkjsdh\" is in the results",
  "keyword": "Then "
});
formatter.match({
  "location": "GoogleSearchWithDataStepDefinition.heVerifyThatTheWordIsInTheResults(String)"
});
formatter.result({
  "status": "skipped"
});
});