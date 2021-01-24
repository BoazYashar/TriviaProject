package Pages;



import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import static org.testng.AssertJUnit.assertEquals;

public class Functionality {

	WebDriver driver ;


	//Locators

	//Quit key locator
	@FindBy (xpath="//*[@id=\"markpage\"]/center/button[2]") WebElement QuitKey  ;
	//Mark answer 2 as a right answer
	@FindBy (xpath="//*[@id=\"answers\"]/div[2]/div[1]/input") WebElement MarkAnswer2  ;


//facebook locator
	@FindBy (id="fackBook2") WebElement FaceBook  ;


	//Back page locator
	@FindBy (xpath="//*[@id=\"backquest\"]") WebElement BackPage ;




	//Ctor 
	public Functionality (WebDriver driver) { 
		this.driver=driver;
		PageFactory.initElements(driver, this);


	}
	public void quitTheTriviaGame() {

		QuitKey.click();		
	}


public void backToPriviousPageOne() {

	BackPage.click();

}




public void shareInFaceBook() throws InterruptedException {

	FaceBook.click();

		}

	public void alertExists() {
//		SoftAssert SoftAssertion = new SoftAssert();
		Alert alert = driver.switchTo().alert();
		//Text displayed on Alert using getText() method of Alert class
		String AlertText = alert.getText();
//accept() method of Alert Class is used for ok button
		alert.accept();
		//Verify Alert displayed correct message to user
		assertEquals("You have to mark an answer!!", AlertText);

	}

	public void changeTheMarkAnswer() throws InterruptedException {

		MarkAnswer2.click();

	}



}





