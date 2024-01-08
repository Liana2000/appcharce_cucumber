package appcharge_cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    WebDriver driver = null;

    @Given("^I have open the browser$")
    public void i_have_open_the_browser() throws Throwable {
        driver = new ChromeDriver();
    }

    @When("^I open appcharge dashboard-sandbox$")
    public void i_open_appcharge_dashboard_sandbox() throws Throwable {
        driver.get("https://dashboard-sandbox.appcharge.com/");
    }

    @Then("^Login page should open$")
    public void login_page_should_open() throws Throwable {
        if (driver.findElement(By.id("loginModal")).isEnabled()) {
            System.out.println("Login test Pass");
        } else {
            System.out.println("Login test Fail");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
    }
}