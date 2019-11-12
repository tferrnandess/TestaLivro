package stepsDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import junit.framework.Assert;

public class StepsTestaLivros {
	private static String isbn = null;
	private static String author = null;
	WebDriver driver = null; 
	private static JavascriptExecutor jse = null;
	
	   @Given("^I stay in website$") 
	   public void SubBookPage() { 
		  System.setProperty("webdriver.gecko.driver", "src/main/java/support/geckodriver.exe");
	      driver = new FirefoxDriver(); 
	      driver.get("https://www.submarino.com.br/"); 
	      driver.manage().window().maximize();
	      jse = (JavascriptExecutor)driver;
	      //Navigate menu
	      driver.findElement(By.partialLinkText("lojas")).click();
	      //Choose Book item
	      driver.findElement(By.partialLinkText("Livros")).click();
	      jse.executeScript("scrollBy(0, 400);");
	      //Choose a first book encountered on list
	     driver.findElement(By.xpath("//a[@href='https://www.submarino.com.br/produto/134168861?chave=prf_hi_bn_0_4_prod1']")).click();
	     jse.executeScript("scrollBy(0, 2000);");
	            
          
	   } 
		
	   @When("^I search a book and author$") 
	   public void SearchBookAuthor() { 
		//Find isbn on page and store as a string
		      WebElement isbnElement = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[6]/div[2]/section/div[2]/section/table/tbody/tr[12]/td[2]/span"));
		      isbn = isbnElement.getText();
	   //Find author name on page and store as a string       
	          WebElement authorElement = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[6]/div[2]/section/div[2]/section/table/tbody/tr[13]/td[2]/span"));
	          author = authorElement.getText();
		 
	   } 
		
	   @Then("^I save the information$") 
	   public void SaveInformation() {
		   
		   System.out.println("ISBN  : "+ isbn);
	       System.out.println("\n\n\n\n");
	       System.out.println("Author  : "+ author);
	       System.out.println("\n\n\n\n");
	          
	          
}
	   
	   @And("^I compare the author with result with another website$") 
	   public void CompareInformation() {
		   //Open website Lojas Americanas
		   driver.navigate().to("https://www.americanas.com.br");
		   //Send isbn number stored on Submarino website
		   driver.findElement(By.id("h_search-input")).sendKeys(isbn);
		   driver.findElement(By.id("h_search-btn")).click();
		   driver.findElement(By.partialLinkText("do mil")).click();
		   //See more information about book, scrolling the page
		  jse.executeScript("scrollBy(0, 1000);");
		  //Find informations about author on page, sending xpath file
		  WebElement amer_authorElement = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[5]/div[2]/section/div/div[3]/table/tbody/tr[13]/td[2]/span"));
		  //Store author name found as string to assert
		  String amer_author = amer_authorElement.getText();
		  //Assert author name found at Lojas Submarino and Lojas Americanas
		  Assert.assertEquals(author,amer_author);
		  
		  //Redirect page to website Amazon
		  driver.navigate().to("https://www.amazon.com.br");
		//Send isbn number stored on Submarino website
		  driver.findElement(By.id("twotabsearchtextbox")).sendKeys(isbn);
		   driver.findElement(By.className("nav-input")).click();
		   driver.findElement(By.partialLinkText("Do Mil")).click();
		   //Capture author name on page, sending xpath file
		   WebElement amazon_authorElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[6]/div[5]/div[1]/div[2]/span/a"));
		   //Store author name found as string to assert
		   String amazon_author = amazon_authorElement.getText();
		 //Assert author name found at Lojas Submarino and Amazon
		   Assert.assertEquals(author,amazon_author);
}

}
