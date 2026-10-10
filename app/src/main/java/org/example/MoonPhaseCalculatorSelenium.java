package org.example;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MoonPhaseCalculatorSelenium implements MoonPhaseCalculator {

    @Override
    public MoonPhase getMoonPhase(LocalDate date) {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://aa.usno.navy.mil/data/RS_OneDay");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY");
        String formattedDate = date.format(formatter);
        WebElement dateElement = webDriver.findElement(By.cssSelector("input#date"));
        dateElement.sendKeys(formattedDate);

        WebElement submit = webDriver.findElement(By.cssSelector("#submit"));
        submit.click();

        // wait for the next page
        // this is right? 
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement waitElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4 + p + p")));
        WebElement resultElement = webDriver.findElement(By.cssSelector("h4 + p + p"));

        String webElementText = waitElement.getText();

        MoonPhase[] moonPhases = MoonPhase.values();

        for (MoonPhase moonPhase : moonPhases) {
            if (webElementText.contains(moonPhase.getName())) {
                webDriver.quit();
                return moonPhase;
            }
        }
        webDriver.quit();
        return null;
    }
}
