package StepDefs;

import cucumber.api.java.en.Given;

import static support.TestContext.getDriver;

public class MyStepdefs {
    @Given("I login to ASK Page as Teacher")
    public void iLoginToASKPageAsTeacher() {
        getDriver().get("http://ask-m.portnov.com/#/login");
    }
}
