import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleSteps {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/harman-gurman/Downloads/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            Utility.takeScreenshot(driver, scenario);
        }
        driver.quit();
    }

    @When("I am on the landing page")
    public void iAmOnTheLandingPage() {
        driver.get("https://www.google.com/");
    }

    @Then("The title is {string}")
    public void theTitleIs(String title) {
        Assert.assertEquals(title, driver.getTitle());
    }

    @Then("The URL is {string}")
    public void theURLIs(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @And("I change the language to french")
    public void clickOnTheFrancaisLink() {
        driver.findElement(By.linkText("Français")).click();
    }

    @Then("The language of page should be {string}")
    public void theLangAttributeIs(String lang) {
        Assert.assertEquals(lang, driver.findElement(By.tagName("html")).getAttribute("lang"));
    }

    @And("I click on the gmail link")
    public void iClickOnTheGmailLink() {
        driver.findElement(By.linkText("Gmail")).click();
    }

    @Then("The gmail page should open")
    public void theGmailPageShouldOpen() {
        String gmailTitle = driver.getTitle();
        Assert.assertEquals("Gmail - Email from Google", gmailTitle);
    }

    @And("I click on the google apps link")
    public void iClickOnTheGoogleAppsLink() {
        driver.findElement(By.id("gbwa")).click();
    }

    @And("when I click on the google account link from the drop down")
    public void whenTheDropDownOpensClickOnTheGoogleAccountLink() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.switchTo().frame(0);
        driver.findElement(By.className("j1ei8c")).click();
    }

    @Then("The title of the page should be {string}")
    public void theTitleOfThePageShouldBe(String pageTitile) {
        Assert.assertEquals(pageTitile, driver.getTitle());
    }

    @And("Type Canada in the search")
    public void typeCanadaInTheSearch() {
        driver.findElement(By.name("q")).sendKeys("canada");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("gNO89b")));

    }

    @Then("I can see a list of suggestions")
    public void iCanSeeAListOfSuggestions() {

        List<WebElement> suggestionsList = driver.findElements(By.className("erkvQe"));
        Assert.assertTrue("Google search returned no suggestions", suggestionsList.size() > 0);
    }
}
