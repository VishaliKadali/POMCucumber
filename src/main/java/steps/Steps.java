package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps {

//	ChromeDriver driver;
	public RemoteWebDriver driver;
	
	@Given("Launch the chrome browser")
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
	}

	@And("Load the URL and maximize")
	public void loadURL() {
		driver.get("http:leaftaps.com/opentaps");
		driver.manage().window().maximize();
	}

	@When("Enter the Username as {string}")
	public void enterUsername(String username) {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
	}

	@And("Enter the Password as {string}")
	public void enterPassword(String password) {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	}

	@And("Click Login")
	public void clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@And("Click on CRMSFA")
	public void clickCRMSFA() {
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
	}

	@Then("Verify HomePage is displayed")
	public void verifyHomePage() {

		String title = driver.getTitle();
		if (title.contains("Leaftaps - TestLeaf Automation Platform")) {
			System.out.println("Homepage is displayed");
		}
	}

	@But("Verify Error message is displayed")
	public void verifyErrorMessage() {
		String errorMessage = driver.findElement(By.xpath("//div[@id='errorDiv']")).getText();
		if (errorMessage.equalsIgnoreCase("The Following Errors Occurred:")) {
			System.out.println("User not logged in");
		}
	}
	
	@And("Click on CreateLead link")
	public void createLeadLink() {
		//driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]")).click();
		
		
		/*
		 * driver.findElement(By.id("createLeadForm_lastName")).sendKeys("R");
		 * driver.findElement(By.name("submitButton")).click();
		 */
	}
	
	@And("Enter CompanyName as {string}")
	public void enterCompanyName(String companyname) {
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys(companyname);
	}
	
	@And("Enter the Firstname as {string}")
	public void enterFirstName(String firstname) {
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys(firstname);
	}
	
	@And("Enter the Lastname as {string}")
	public void enterLastName(String lastname ) {
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys(lastname);
	}
	
	@And("Click on Create Leads button")
	public void clickCreateLeadsButton() {
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
	
	}
	@Then("View Lead page should be displayed")
	public void viewLeadPage() {
		String title=driver.getTitle();
		if(title.contains("View Lead | opentaps CRM")) {
			System.out.println("ViewLead Page is displayed");
		}
	}

	/*
	 * @Then("Enter CompanyName as {string}") public void
	 * enter_company_name_as(String companyname) {
	 * 
	 * }
	 * 
	 * @Then("Enter the Firstname as {string}") public void
	 * enter_the_firstname_as(String firstname) {
	 * 
	 * }
	 * 
	 * @Then("Enter the Lastname as {string}") public void
	 * enter_the_lastname_as(String lastname) {
	 * 
	 * }
	 */

}
