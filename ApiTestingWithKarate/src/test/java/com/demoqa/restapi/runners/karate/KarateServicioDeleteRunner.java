package com.demoqa.restapi.runners.karate;

import org.junit.runner.RunWith;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.junit4.Karate;

@RunWith(Karate.class)
@KarateOptions(
		features = {"src/test/resources/features/karate/KarateServicioDelete.feature"}
		)

public class KarateServicioDeleteRunner {

}
