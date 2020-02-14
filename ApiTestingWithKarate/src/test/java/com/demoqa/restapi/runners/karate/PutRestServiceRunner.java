package com.demoqa.restapi.runners.karate;

import org.junit.runner.RunWith;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.junit4.Karate;

@RunWith(Karate.class)
@KarateOptions( features="src/test/resources/features/karate/put_rest_service.feature")
public class PutRestServiceRunner {

}
