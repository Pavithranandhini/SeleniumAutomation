package com.automation.pageObjects;

import org.openqa.selenium.By;

public class Locators {
    public static By docsTabLink = By.xpath("//a[@class='css-hobwqm' and text()='Docs']");
    public static By MainConceptsDropDown = By.xpath("//button[@class='css-1j8jxus' and descendant::div[contains(text(),'Main Concepts')]]");
    public static By ItemList = By.xpath("//ul[@class='css-ts0qly']");
    public static By AdvancedGuidesDropDown = By.xpath("//button[@class='css-1j8jxus' and descendant::div[contains(text(),'Advanced Guides')]]");
    public static By tutorialTabLink = By.xpath("//a[@class='css-hobwqm' and text()='Tutorial']");
    public static By tutorialContentLink = By.linkText("Setup for the Tutorial");
}
