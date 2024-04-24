package com.automation.StepDefinition;

import com.automation.pageObjects.Locators;
import com.automation.testBase.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TutorialTab extends TestBase {

    @Given("^I am on the JS site$")
    public void navigateToSite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://legacy.reactjs.org/");
    }
    @When("^Navigate to Tutorial Tab$")
    public void iClickOnTutorialTab() {
        driver.findElement(Locators.tutorialTabLink).click();
    }
    @Then("^I scroll to the respected content$")
    public void scrollToTheContent(){
        Duration timeOut = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement setupLink = driver.findElement(Locators.tutorialContentLink);

// Wait for the setup link element to become visible
        wait.until(ExpectedConditions.visibilityOf(setupLink));

// Scroll the page until the setup link element is in view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", setupLink);
    }
}
