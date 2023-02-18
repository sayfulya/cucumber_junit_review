package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {


    /*
     * This method will accept int (in secs)
     * and execute Thread.sleep method for given duration */

    public static void sleep(int second){
        second *=1000;
        try{
            Thread.sleep((second));
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }



    public static void switchWindowAndVerify(String expectedURL, String expectedTitle){

        Set<String> windowHandles = Driver.getDriver().getWindowHandles();

        for (String windowHandle : windowHandles) {
            Driver.getDriver().switchTo().window(windowHandle);

            if (Driver.getDriver().getCurrentUrl().contains(expectedURL)) {
                break;

            }
        }

        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));


    }

    public static void verifyTitle(String expectedTitle){
        String actualTitle =  Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    public static void verifyTitleContains( String expectedTitle){
        String actualTitle =  Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    public static void waitForInvisibilityOf(WebElement target){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(target));

    }

public static List<String> dropdownOptions_asString(WebElement dropdownElement){

    Select months = new Select(dropdownElement);
    List<WebElement> monthsElements = months.getOptions();
    List<String> actualMonthsAsString = new ArrayList<>();
    for (WebElement monthsElement : monthsElements) {
        actualMonthsAsString.add(monthsElement.getText());
    }
    return actualMonthsAsString;
}

}


