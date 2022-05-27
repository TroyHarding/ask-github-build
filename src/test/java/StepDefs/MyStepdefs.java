package StepDefs;

import cucumber.api.java.en.Given;
import org.openqa.selenium.By;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class MyStepdefs {
    @cucumber.api.java.en.Given("I login to ASK Page as Teacher")
    public void iLoginToASKPageAsTeacher() throws InterruptedException {
        getDriver().get("http://ask-m.portnov.com/#/login");
        getDriver().findElement(By.xpath("//input[@id='mat-input-0']")).click();
        getDriver().findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("larry211@bergservices.cf");
        getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).click();
        getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("user1234");
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//h5[contains(text(),\"User's Management\")]")).click();
        Thread.sleep(1000);
        Boolean user1 = getDriver().findElement(By.cssSelector("mat-card")).isDisplayed();
        assertThat(user1).isTrue();
        }

    @Given("I login to ASK Page as Student")
    public void iLoginToASKPageAsStudent() throws InterruptedException {
        getDriver().get("http://ask-m.portnov.com/#/login");
        getDriver().findElement(By.xpath("//input[@id='mat-input-0']")).click();
        getDriver().findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("jasonjason0@omdiaco.com");
        getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).click();
        getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("user1234");
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//h5[contains(text(),'My Grades')]")).click();
        Thread.sleep(1000);
        Boolean grades1 = getDriver().findElement(By.cssSelector("mat-card")).isDisplayed();
        assertThat(grades1).isTrue();
    }
}
