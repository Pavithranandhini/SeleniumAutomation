package com.automation.Hooks;


import com.automation.helper.LoggerHelper;
import com.automation.testBase.TestBase;
import com.automation.enums.Browsers;
import cucumber.api.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.logging.Logger;


public class ServiceHooks {

    TestBase testBase;

    Logger log = LoggerHelper.getLogger(ServiceHooks.class);

    @BeforeMethod
    public void initializeTest() {
        testBase = new TestBase();
        testBase.selectBrowser(Browsers.CHROME.name());
    }

    @AfterMethod
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                log.info(scenario.getName() + " is Failed");
                final byte[] screenshot = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException e) {
                e.printStackTrace();
            }
        } else {
            try {
                log.info(scenario.getName() + " is pass");
                scenario.embed(((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES), "image/png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        TestBase.driver.quit();
    }
}
