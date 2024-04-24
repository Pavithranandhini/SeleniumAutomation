package com.automation.StepDefinition;

import com.automation.pageObjects.Locators;
import com.automation.testBase.TestBase;
import commonUtils.CommonUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReactJsSite extends TestBase {

    private WebDriver driver;
    public JavascriptExecutor jsExecutor;

    @Given("^I am on the React JS site$")
    public void navigateToReactJSSite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       // jsExecutor = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://legacy.reactjs.org/");
    }
    @When("^I click on Docs Tab$")
    public void iClickOnDocsTab() {
      driver.findElement(Locators.docsTabLink).click();
    }

    @When("^I expand the Main Concepts Tab$")
    public void iExpandTheMainConcepts() {

        WebElement mainConcepts = driver.findElement(Locators.MainConceptsDropDown);
        mainConcepts.click();

    }
    public void getAndSaveSubElements(String fileName) {
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.ItemList));

// Locate the <ul> element
        WebElement ulElement = driver.findElement(Locators.ItemList);

// Highlight all elements within the <ul> element
        List<WebElement> listItems = ulElement.findElements(By.tagName("li"));
        for (WebElement listItem : listItems) {
            // Highlight the element (You can replace this with your own highlighting mechanism)
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = 'yellow'", listItem);


            CommonUtils.saveTextToFile(listItems, fileName);
        }
        // Close the WebDriver instance

    }
    @Then("^I highlight and save all the main concepts tab 12 sub-elements/link references in a file$")
    public void getMainConceptsSubElements(){
        getAndSaveSubElements("main_concepts.txt");
    }

    @When("^I expand the Advanced Guides Tab$")
    public void iExpandTheAdvancedGuides() {
        WebElement advancedGuides = driver.findElement(Locators.AdvancedGuidesDropDown);
        advancedGuides.click();

    }
    @Then("^I highlight and save all the advanced guides tab 12 sub-elements/link references in a file$")
    public void getAdvancedGuidesSubElements(){
        getAndSaveSubElements("advanced_guides.txt");
        driver.quit();
    }




}