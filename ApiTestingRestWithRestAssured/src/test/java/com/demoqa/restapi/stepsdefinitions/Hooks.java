package com.demoqa.restapi.stepsdefinitions;

import cucumber.api.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Hooks {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }
}
