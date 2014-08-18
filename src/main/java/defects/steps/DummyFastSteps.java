package defects.steps;
import org.apache.log4j.Logger;
import org.jbehave.core.annotations.*;
import org.junit.Assert;

import static utils.Wait.waitMillis;

/**
 * Created by Przemek Kwiecien on 2014-08-18.
 */
public class DummyFastSteps {
    Logger log;
    public DummyFastSteps(Logger log){
        this.log = log;
    }

    @Given("Given dummy fast")
    public void givenDummy(){
        log.info("Given dummy fast");
        waitMillis(1000);
        log.info("Given dummy fast");
    }

    @When("When dummy fast")
    public void whenDummy(){
        log.info("When dummy fast");
        waitMillis(1000);
        log.info("When dummy fast");
    }

    @Then("Then dummy fast")
    public void thenDummy(){
        Assert.assertTrue(true);
    }
}
