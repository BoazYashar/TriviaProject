package Pages;



import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertEquals;

public class PlayingTheGame {

	WebDriver driver ;


	//Locators

	//Start key locator
	@FindBy (xpath="//*[@id=\"secondepage\"]/center/button[1]") WebElement startPlayKey  ;

	//locators of question1 and his answeres
	@FindBy (name="question") WebElement Q1  ;
	@FindBy (xpath="//*[@id=\"2\"]/input[1]") WebElement ChoseAnswer1  ;
	@FindBy (xpath="//*[@id=\"0\"]/input[4]") WebElement ChoseAnswer2  ;
	@FindBy (xpath="//*[@id=\"1\"]/input[4]") WebElement ChoseAnswer3  ;
	@FindBy (xpath="//*[@id=\"2\"]/input[4]") WebElement ChoseAnswer4  ;

	@FindBy (xpath="//button[@id='btnnext']")
	public WebElement NextChose  ;

	//input [@name ='answertest0'][2]
	
	
	//Ctor 
	public PlayingTheGame (WebDriver driver) { 
		this.driver=driver;
		PageFactory.initElements(driver, this);


	}
	public void startTheTriviaGame() {

		startPlayKey.click();		
	}

	public void answerQuestions(int answer1, int answer2, int answer3) throws InterruptedException {

		if (answer1 ==1) {
			ChoseAnswer1.click();}
		else if (answer1 == 2) {
				ChoseAnswer2.click();
			} else if (answer1 == 3) {
				ChoseAnswer3.click();
			} else {
				ChoseAnswer4.click();
			}

			Thread.sleep(2000);

			NextChose.click();
			Thread.sleep(2000);

			if (answer2 == 1) {
				ChoseAnswer1.click();}
		else if (answer2 == 2) {
					ChoseAnswer2.click();
				} else if (answer2 == 3) {
					ChoseAnswer3.click();
				} else {
					ChoseAnswer4.click();
				}
				Thread.sleep(2000);

				NextChose.click();
				Thread.sleep(2000);


				if (answer3 == 1) {
					ChoseAnswer1.click();}
		else if (answer3 == 2) {
						ChoseAnswer2.click();
					} else if (answer3 == 3) {
						ChoseAnswer3.click();
					} else {
						ChoseAnswer4.click();
					}
					NextChose.click();

				}


	public void NextChoseButton() {

		NextChose.click();
	}
	public void answer1() {

		ChoseAnswer4.click();}

	public void answer2() {

		ChoseAnswer3.click();}


	public void answer3() {

		ChoseAnswer2.click();}





}


