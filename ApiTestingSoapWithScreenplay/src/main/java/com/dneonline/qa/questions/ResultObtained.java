package com.dneonline.qa.questions;

import io.restassured.path.xml.XmlPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResultObtained implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        XmlPath xmlPath= new XmlPath(SerenityRest.lastResponse().asString());//Converting string into xml path to assert
        return xmlPath.getString("GetConversionRateResult");
       // return xmlPath.getString("AddResult");
    }

    public static ResultObtained ofOperation() {
        return new ResultObtained();
    }
}
