package com.test.Analytics_Jobs;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Jenkinid {
	

	 private RemoteWebDriver driver;
	   
		
	 @BeforeTest
	    public void setup() throws MalformedURLException {
	        DesiredCapabilities dc = DesiredCapabilities.chrome();
	        URL url = new URL("http://172.20.23.7:5555/wd/hub");
	        driver = new RemoteWebDriver(url, dc);
	        
	    }
	 @Parameters("URL")
	    @Test(priority = 1)
	  public void login(@Optional("defaultURL") String URL) throws InterruptedException
	   // public void login() throws InterruptedException
	    {

	    	driver.get(URL);
	    	//driver.get("http://dev2mani.humanbrain.in/annotation/portal");
	        driver.manage().window().maximize();
	    }
	    @Test(priority=2)
	    public void analytics() throws InterruptedException
	        {
	        Actions actions = new Actions(driver);
	        actions.sendKeys("d").perform(); // Simulate pressing lowercase 'd'
	        Thread.sleep(2000);
	        WebDriverWait wait = new WebDriverWait(driver, 20);
	        
	        WebElement viewerElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Analytics']")));
	        if (viewerElement.isEnabled() && viewerElement.isDisplayed()) {
	            viewerElement.click();
	            System.out.println("analytics icon is clicked");
	        } else {
	            System.out.println("analytics icon is not clickable");
	        }
	        
	        String parentWindow = driver.getWindowHandle();
	        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
	        if (loginButton != null) {
	            loginButton.click();
	            System.out.println("Login button clicked successfully.");
	        } else {
	            System.out.println("Login button is not clicked.");
	        }
	    
		  wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		  Set<String> allWindows = driver.getWindowHandles();
	        for (String window : allWindows) {
	            if (!window.equals(parentWindow)) {
	                driver.switchTo().window(window);
	                break;
	            }
	        }
	        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
	        if (emailInput != null && emailInput.isDisplayed()) {
	            emailInput.sendKeys("gayathri@htic.iitm.ac.in");
	            System.out.println("Email was entered successfully.");
	        } else {
	           System.out.println("Email was not entered.");
	        }
	      
	        WebElement nextButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
	        if (nextButton1 != null) {
	            nextButton1.click();
	            System.out.println("Next button 1 is clicked.");
	        } else {
	            System.out.println("Next button 1 is not clicked.");
	        }
	        
	        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Enter your password']")));
	        passwordInput.sendKeys("Gayu@0918");
	        if (passwordInput.getAttribute("value").equals("Gayu@0918")) {
	            System.out.println("Password was entered successfully.");
	        } else {
	            System.out.println("Password was not entered.");
	        }
	        
	        
	        WebElement nextButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
	        if (nextButton2 != null) {
	            nextButton2.click();
	            System.out.println("Next button 2 is clicked.");
	        } else {
	            System.out.println("Next button 2 is not clicked.");
	        }
	       
	
	        driver.switchTo().window(parentWindow);
	        System.out.println("Login successfully");
	      
	        System.out.println("************************Login validation done***********************");
	        }
	    @Test(priority=2)
	    public void jobs() throws InterruptedException {
	        WebDriverWait wait = new WebDriverWait(driver, 30);

	        WebElement viewerElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Competitions']")));
	        if (viewerElement.isEnabled() && viewerElement.isDisplayed()) {
	            viewerElement.click();
	            System.out.println("Competitions option is clicked");
	        } else {
	            System.out.println("Competitions option is not clickable");
	        }
	        Thread.sleep(2000);
	        
	        WebElement competition = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h6[text()='Celldetection_Automation']")));
	        if (competition.isEnabled() && competition.isDisplayed()) {
	        	competition.click();
	            System.out.println("Automation Competitions is clicked");
	        } else {
	            System.out.println("Automation Competitions is not clickable");
	        }
	        Thread.sleep(2000);
	        
	        WebElement jobs = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()='Jobs'])[2]")));
	        if (jobs.isEnabled() && jobs.isDisplayed()) {
	        	jobs.click();
	            System.out.println("Jobs is clicked");
	        } else {
	            System.out.println("Jobs is not clickable");
	        }
	        Thread.sleep(2000);
	        
	        WebElement failedjob = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[text()='1'])[1]")));
	        if (failedjob.isEnabled() && failedjob.isDisplayed()) {
	        	failedjob.click();
	            System.out.println("Failed jobs is clicked");
	        } else {
	            System.out.println("Failed jobs is not clickable");
	        }
	        Thread.sleep(2000);
	        String originalWindowHandle = driver.getWindowHandle();

	     
	     WebElement jenkinid = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='315']")));
	     jenkinid.click();

	     // Switching to the new tab
	     for (String windowHandle : driver.getWindowHandles()) {
	         driver.switchTo().window(windowHandle);
	     }

	     
	     WebElement usernameField = driver.findElement(By.id("j_username"));
	     usernameField.sendKeys("admin");
	     Thread.sleep(1000);

	     WebElement passwordField = driver.findElement(By.name("j_password"));
	     passwordField.sendKeys("Health#123");
	     Thread.sleep(1000);
	     
	     driver.findElement(By.xpath("//input[@name='Submit']")).click();
	     Thread.sleep(3000);
	     
	     String jenkinurl = driver.getCurrentUrl();
	     System.out.println("URL of the jenkins: " + jenkinurl);

	     String expectedUrl = "http://apollo2.humanbrain.in:9011/blue/organizations/jenkins/CD_dev_worker/detail/CD_dev_worker/315/pipeline/";

	  // Assert that the actual URL matches the expected URL
	    Assert.assertEquals(jenkinurl, expectedUrl, "Actual URL does not match the expected URL");

	     
	     
	        
	     }
	    
	    @AfterTest
	    public void close() {
	        driver.quit();
	    }


}
