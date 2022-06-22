package StepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import cucumber.api.java.en.Given;

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

    @Then("I wait for element with xpath {string} to be present")
    public void iWaitForElementWithXpathToBePresent(String xpath) {
        WebDriverWait wait2 = new WebDriverWait(getDriver(), 10,500);
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

    }

    @When("I click element with xpath {string}")
    public void iClickElementWithXpath(String xpath) {
        getDriver().findElement(By.xpath(xpath)).click();
    }


    @When("I type First name as {string} into element with xpath {string}")
    public void iTypeFirstNameAsIntoElementWithXpath(String firstName, String xpath) {
        WebElement firstNm = getDriver().findElement(By.xpath(xpath));
        firstNm.sendKeys(firstName);
    }

    @And("I type Last Name as {string} into element with xpath {string}")
    public void iTypeLastNameAsIntoElementWithXpath(String lastName, String xpath) {
        getDriver().findElement(By.xpath(xpath)).sendKeys(lastName);
    }

    @And("I type Email as {string} into element with xpath {string}")
    public void iTypeEmailAsIntoElementWithXpath(String email, String xpath) {
        getDriver().findElement(By.xpath(xpath)).sendKeys(email);
    }

    @And("I type Group Code as {string} into element with xpath {string}")
    public void iTypeGroupCodeAsIntoElementWithXpath(String groupCode, String xpath) {
        getDriver().findElement(By.xpath(xpath)).sendKeys(groupCode);
    }

    @And("I type Password as {string} into element with xpath {string}")
    public void iTypePasswordAsIntoElementWithXpath(String password, String xpath) {
        getDriver().findElement(By.xpath(xpath)).sendKeys(password);
    }

    @And("I type Confirm Password as {string} into element with xpath {string}")
    public void iTypeConfirmPasswordAsIntoElementWithXpath(String confirmPassword, String xpath) {
        getDriver().findElement(By.xpath(xpath)).sendKeys(confirmPassword);
    }

    @Then("I should see page title as {string}")
    public void iShouldSeePageTitleAs(String title) {
        Assertions.assertThat(getDriver().getTitle()).isEqualTo(title);
    }


    @And("I should see confirmation as {string} at xpath {string}")
    public void iShouldSeeConfirmationAsAtXpath(String message, String xpath) {
        String actualText = getDriver().findElement(By.xpath(xpath)).getText();
        assertThat(actualText).containsIgnoringCase(message);
    }

    @Then("element with xpath {string} should have text {string}")
    public void elementWithXpathShouldHaveText(String xpath, String text) {
        String actualText = getDriver().findElement(By.xpath(xpath)).getText();
        assertThat(actualText).isEqualTo(text);

    }
}