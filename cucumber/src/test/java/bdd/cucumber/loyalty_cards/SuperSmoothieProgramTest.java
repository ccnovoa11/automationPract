package bdd.cucumber.loyalty_cards;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/loyalty_card", glue = "bdd.cucumber")
public class SuperSmoothieProgramTest {
}
