package Pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.yaml.snakeyaml.error.Mark;

public class CreatingTheGame {

	 WebDriver driver ;

	
	//Locators
	
	//Start key locator
	@FindBy (id="startB") WebElement startKey  ;
	
	
	//locators of question1 and his answeres
	@FindBy (xpath="//*[@id=\"myform1\"]/div/div/div/input") WebElement Q1  ;
	@FindBy (xpath="//button[@id='nextquest']") WebElement NextToAnswers1  ;
	@FindBy (xpath="//*[@id=\"answers\"]/div[1]/div[2]/input") WebElement answer1  ;
	@FindBy (xpath="//*[@id=\"answers\"]/div[2]/div[2]/input") WebElement answer2  ;
	@FindBy (xpath="//*[@id=\"answers\"]/div[3]/div[2]/input") WebElement answer3  ;
	@FindBy (xpath="//*[@id=\"answers\"]/div[4]/div[2]/input") WebElement answer4  ;
	
	//locator of the button of the correct answer
	@FindBy (xpath="//*[@id=\"answers\"]/div[1]/div[1]/input") WebElement MarkAnswer1  ;
	@FindBy (xpath="//*[@id=\"answers\"]/div[2]/div[1]/input") WebElement MarkAnswer2  ;
	@FindBy (xpath="//*[@id=\"answers\"]/div[3]/div[1]/input") WebElement MarkAnswer3  ;
	@FindBy (xpath="//*[@id=\"answers\"]/div[4]/div[1]/input") WebElement MarkAnswer4  ;
	
	//Ctor 
	public CreatingTheGame (WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	
		
	}
	
	
	public boolean startTheTrivia () {
		try {
			startKey.click();
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;}
		}

//A function that fills the questions and answers in trivia
	public void filUpQuestionsAndAnswers (String qustionText , String answer1Text ,String answer2Text ,String answer3Text ,String answer4Text ) throws InterruptedException {

		

			Q1.sendKeys(qustionText);
			
			NextToAnswers1.click();

			answer1.sendKeys(answer1Text);
			answer2.sendKeys(answer2Text);
			answer3.sendKeys(answer3Text);
			answer4.sendKeys(answer4Text);
			
			MarkAnswer4.click();

			NextToAnswers1.click();
		}

	

	
	}
	

