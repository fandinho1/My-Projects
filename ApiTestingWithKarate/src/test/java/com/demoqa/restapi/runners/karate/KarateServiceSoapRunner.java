package com.demoqa.restapi.runners.karate;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

@RunWith(Karate.class)
@KarateOptions(
        features = {"src/test/resources/features/karate/karate_service_soap.feature"}
)
public class KarateServiceSoapRunner {

}
