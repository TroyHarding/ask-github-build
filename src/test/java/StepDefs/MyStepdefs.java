package StepDefs;
import static support.TestContext.getDriver;

public class MyStepdefs {
    @cucumber.api.java.en.Given("I login to ASK as a teacher")
    public void iLoginToASKAsATeacher() {
        getDriver().get("http://ask-m.portnov.com/#/login");
    }
}
