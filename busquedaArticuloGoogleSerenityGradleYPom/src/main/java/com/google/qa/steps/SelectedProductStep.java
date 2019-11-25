package com.google.qa.steps;

import com.google.qa.pages.SelectedProductPage;
import net.thucydides.core.annotations.Step;

public class SelectedProductStep {

    SelectedProductPage selectedProductPage;

    @Step
    public void isThe(String titlePage) {
        selectedProductPage.thePageIsCorrect(titlePage);
    }

}
