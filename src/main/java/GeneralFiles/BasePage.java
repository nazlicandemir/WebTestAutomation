package GeneralFiles;
import org.openqa.selenium.JavascriptExecutor;


import BaseFiles.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class BasePage {
    WebDriver driver=null;

    public BasePage(){
        driver= DriverManager.getDriver();
    }

    public WebElement waitUntillClickable(By locator){
        try {
            Wait<WebDriver> wait = new FluentWait<>(driver)

                    .withTimeout(Duration.ofSeconds(30)).withTimeout(Duration.ofSeconds(30))

                    .pollingEvery(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(5))

                    .ignoring(NoSuchElementException.class).ignoring(NoSuchElementException.class);

            return  wait.until(ExpectedConditions.elementToBeClickable(locator));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public void  clickElement(By locator){
        try {
            waitUntillClickable(locator).click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void scrollDown(By locator){
        try {
            WebElement element=driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void typeText(By locator, String text) {
        try {
            waitUntillClickable(locator).sendKeys(text);
        } catch (Exception e) {
            throw new RuntimeException("Yazı yazma işlemi başarısız: " + e.getMessage());
        }
    }


    public String getText(By locator) {
        try {
            return waitUntillClickable(locator).getText();
        } catch (Exception e) {
            throw new RuntimeException("Metin alınamadı: " + e.getMessage());
        }
    }

    public void clickWithJS(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            throw new RuntimeException("JavaScript ile tıklama başarısız: " + e.getMessage());
        }
    }


    public boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false; // Element yoksa görünmüyor demektir
        }
    }


    public void scrollAndClickWithJS(By locator) {
        try {
            WebElement element = driver.findElement(locator);

            // Önce ekranı biraz aşağıya kaydır
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250);");

            // Sonra elementi ekranın ortasına getir
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

            // Küçük bir bekleme (render tamamlanması için)
            Thread.sleep(500);

            // Son olarak JS ile tıkla
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            throw new RuntimeException("Scroll ve JS ile tıklama başarısız: " + e.getMessage());
        }
    }














}
 