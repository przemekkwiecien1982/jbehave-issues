package defects.steps;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.*;
import org.junit.Assert;

import static utils.Wait.waitMillis;

/**
 * Created by Przemek Kwiecien on 2014-08-18.
 */
public class DummySteps {
    Logger log;
    public DummySteps(Logger log){
        this.log = log;
    }

    @Given("Given dummy lasts 5s")
    public void givenDummyLasts5s(){
        log.info("Given dummy lasts 5s started");
        waitMillis(5000);
        log.info("Given dummy lasts 5s finished");
    }

    @When("When dummy lasts 5s")
    public void whenDummyLasts5s(){
        log.info("When dummy lasts 5s started");
        waitMillis(5000);
        log.info("When dummy lasts 5s finished");
    }

    @Then("Then dummy")
    public void thenDummy(){
        Assert.assertTrue(true);
    }
}
