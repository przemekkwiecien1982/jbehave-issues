package defects.steps;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.*;
import static utils.Wait.waitMillis;
/**
 * Created by Przemek Kwiecien on 2014-08-18.
 */
public class LoginSteps {
    Logger log;

    public LoginSteps(Logger log){
        this.log = log;
    }

    @BeforeStories
    public void beforeStories(){
        log.info("BeforeStories from LoginSteps performed");
    }

    @BeforeStory
    public void beforeStory(){
        log.info("BeforeStory from LoginSteps performed");
    }

    @AfterStory
    public void afterStory(){
        log.info("AfterStory from LoginSteps performed");
    }

    @AfterStories
    public void afterStories(){
        log.info("AfterStories from LoginSteps performed");
    }

    @Then("Login Step")
    public void loginStep(){
        log.info("Login Step from LoginSteps started");
        waitMillis(5000);
        log.info("Login Step from LoginSteps finished");
    }
}
