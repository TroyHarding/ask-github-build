package StepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class MyStepdefs {

    @Given("I open ASK page using url as {string}")
    public void iOpenASKPageUsingUrlAs(String url) {
        getDriver().get(url);
    }

    @When("I enter email as {string} and password as {string} and click Sign In")
    public void iEnterEmailAsAndPasswordAsAndClickSignIn(String str1, String str2) {
       WebElement email= getDriver().findElement(By.xpath("//input[@id='mat-input-0']"));
       email.sendKeys(str1);
       WebElement password = getDriver().findElement(By.xpath("//input[@id='mat-input-1']"));
       password.sendKeys(str2);
       WebElement signIn = getDriver().findElement(By.xpath("//button[@type='submit']"));
       signIn.click();
    }

    @And("I click on Users Management from Navigation menu")
    public void iClickOnUsersManagementFromNavigationMenu() {
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Users Management')]")));
        WebElement userManage = getDriver().findElement(By.xpath("//h5[contains(text(),'Users Management')]"));
        userManage.click();
        Boolean user1 = getDriver().findElement(By.cssSelector("mat-card")).isDisplayed();
        assertThat(user1).isTrue();
    }

    @And("I click on Grades from Navigation menu")
    public void iClickOnGradesFromNavigationMenu() {
        WebDriverWait wait1 = new WebDriverWait(getDriver(),10);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'My Grades')]")));
        WebElement grades = getDriver().findElement(By.xpath("//h5[contains(text(),'My Grades')]"));
        grades.click();
        Boolean grades1 = getDriver().findElement(By.cssSelector("mat-card")).isDisplayed();
        assertThat(grades1).isTrue();
    }
}