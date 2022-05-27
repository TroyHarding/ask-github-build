package StepDefs;

import static support.TestContext.getDriver;

public class MyStepdefs {
    @cucumber.api.java.en.Given("I login to ASK Page as Teacher")
    public void iLoginToASKPageAsTeacher() {
        getDriver().get("http://ask-m.portnov.com/#/login");
    }
}
