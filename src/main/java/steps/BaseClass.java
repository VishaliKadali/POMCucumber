
package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public RemoteWebDriver driver;

	/*
	 * @Given("Launch the chrome browser") public void launchBrowser() {
	 * WebDriverManager.chromedriver().setup(); ChromeOptions options = new
	 * ChromeOptions(); options.addArguments("--remote-allow-origins=*"); driver =
	 * new ChromeDriver(options); }
	 * 
	 * @And("Load the URL and maximize") public void loadURL() {
	 * driver.get("http:leaftaps.com/opentaps");
	 * driver.manage().window().maximize(); }
	 * 
	 * @When("Enter username as {string}") public void enterUsername(String
	 * username) {
	 * driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username); }
	 * 
	 * @And("Enter password as {string}") public void enterPassword(String password)
	 * { driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	 * }
	 * 
	 * @And("Click on Login") public void clickLogin() {
	 * driver.findElement(By.className("decorativeSubmit")).click(); }
	 */
}
