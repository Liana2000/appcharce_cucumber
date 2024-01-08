package appcharge_cucumber;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;
import java.util.Random;

public class CreateOffer {

    WebDriver driver = null;

    @Given("^I have open the browser home page$")
    public void i_have_open_the_browser() throws Throwable {
        driver = new ChromeDriver();
    }

    @When("^I open appcharge dashboard-sandbox appcharge_cucumber.login page$")
    public void i_open_appcharge_dashboard_sandbox_login_page() throws Throwable {
        driver.get("https://dashboard-sandbox.appcharge.com/");
    }

    @When("I set valid credentials")
    public void i_set_valid_credentials() {
        driver.findElement(By.name("userName")).sendKeys("", "liana.gaspariann@gmail.com");
        driver.findElement(By.name("password")).sendKeys("", "Lika~1234~Lika~1234");
    }

    @When("I click to appcharge_cucumber.login button")
    public void i_click_to_login_button() {
        WebElement button = driver.findElement(By.xpath("//span[text()='Login']/ancestor::button"));
        button.click();
    }

    @Then("Must navigate to home page with user")
    public void must_navigate_to_home_page_with_user() {
        if ((Objects.equals(driver.getCurrentUrl(), "https://dashboard-sandbox.appcharge.com/office/statistics?range=2"))) {
            System.out.println("Successful appcharge_cucumber.login");
        } else {
            System.out.println("Fail appcharge_cucumber.login");
        }
    }

    @When("I click to pricing")
    public void iClickToPricing() {
        driver.get("https://dashboard-sandbox.appcharge.com/office/pricing");
    }

    @When("I click to create new button in office pricing page")
    public void iClickToCreateNewButtonInOfficePricingPage() {
        WebElement createNewButton = driver.findElement(By.cssSelector("button.MuiButton-containedPrimary"));
        createNewButton.click();
    }

    @When("I set value to usd price")
    public void iSetValueToUsdPrice() {
        WebElement priceElement = driver.findElement(By.cssSelector("input[type='number']"));
        priceElement.sendKeys("", String.valueOf(new Random().nextDouble()));
    }

    @When("I click to save button")
    public void iClickToSaveButton() {
        WebElement saveButton = driver.findElement(By.cssSelector("button.MuiButton-containedPrimary"));
        saveButton.click();
    }

    @Then("Must open page with pricing lists")
    public void mustOpenPageWithPricingLists() {
        if (driver.getCurrentUrl().equals("https://dashboard-sandbox.appcharge.com/office/pricing/")) {
            System.out.println("Price is added");
        } else {
            System.out.println("Price is not added");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
    }

    @After
    public void tearDown() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (driver != null) {
            driver.quit();
        }
    }
}
