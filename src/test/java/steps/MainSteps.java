package steps;

import BaseFiles.JsonWebTypeReader;
import GeneralFiles.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

public class MainSteps {

    @And("^\"([^\"]*)\" tiklanir")
    public void clickElement(String jsonParameterName) {
        By locator = JsonWebTypeReader.getLocator(jsonParameterName);
        BasePage basePage = new BasePage();
        basePage.clickElement(locator);
    }

    @And("^\"([^\"]*)\" alanına \"([^\"]*)\" yazılır$")
    public void sendKeysToElement(String jsonParameterName, String text) {
        By locator = JsonWebTypeReader.getLocator(jsonParameterName);
        BasePage basePage = new BasePage();
        basePage.typeText(locator, text);
    }

    @And("^\"([^\"]*)\" alani icin ekrani asagi kaydir$")
    public void scrollDown(String jsonParameterName) {
        By locator = JsonWebTypeReader.getLocator(jsonParameterName);
        BasePage basePage = new BasePage();
        basePage.scrollDown(locator);
    }

    @Then("^\"([^\"]*)\" yazısı \"([^\"]*)\" içermelidir$")
    public void textShouldContain(String jsonParameterName, String expectedText) {
        By locator = JsonWebTypeReader.getLocator(jsonParameterName);
        BasePage basePage = new BasePage();
        String actualText = basePage.getText(locator);
        if (!actualText.contains(expectedText)) {
            throw new AssertionError("Beklenen metin: \"" + expectedText + "\", Ancak bulunan: \"" + actualText + "\"");
        }
    }


    @And("^\"([^\"]*)\" JS ile tiklanir$")
    public void jsClick(String jsonParameterName) {
        By locator = JsonWebTypeReader.getLocator(jsonParameterName);
        BasePage basePage = new BasePage();
        basePage.clickWithJS(locator);
    }


    @Then("^\"([^\"]*)\" elementi artık görünmemelidir$")
    public void elementShouldNotBeVisible(String jsonParameterName) {
        By locator = JsonWebTypeReader.getLocator(jsonParameterName);
        BasePage basePage = new BasePage();
        boolean isDisplayed = basePage.isElementDisplayed(locator);
        if (isDisplayed) {
            throw new AssertionError("Beklenmeyen şekilde hala görünüyor: " + jsonParameterName);
        }
    }

    @And("^\"([^\"]*)\" scroll edilip JS ile tiklanir$")
    public void scrollAndJSClick(String jsonParameterName) {
        By locator = JsonWebTypeReader.getLocator(jsonParameterName);
        BasePage basePage = new BasePage();
        basePage.scrollAndClickWithJS(locator);
    }









}
