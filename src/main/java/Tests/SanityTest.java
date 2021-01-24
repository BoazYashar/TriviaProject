package Tests;


import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import Pages.CreatingTheGame;
import Pages.PlayingTheGame;

@Test
public class SanityTest   {

	WebDriver driver;

	private CreatingTheGame CreatGame; 
	private PlayingTheGame playGame;




	@BeforeTest

	public void beforeEachTest() {
		driver = new ChromeDriver();
		driver.get("https://shemsvcollege.github.io/Trivia/");
		driver.manage().window().maximize();
		CreatGame = new CreatingTheGame(driver);
		playGame = new PlayingTheGame(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


	}

	@AfterTest
	public void afterEachTest() throws InterruptedException {
		System.out.println("------------END------------");
				Thread.sleep(2000);

		//		driver.quit();

	}
	
	@Test(priority = 0)
	public void starting () {
		CreatGame.startTheTrivia();
	}

// 
	@Test (priority=1)
	public void filUpQuestionsAndAnswers () throws InterruptedException {
		CreatGame.filUpQuestionsAndAnswers("How many years did Moshe Rabbenu live?", "110", "150", "130", "120");
		CreatGame.filUpQuestionsAndAnswers("How many years did Abraham Avino live?", "150", "180", "170", "175");
		CreatGame.filUpQuestionsAndAnswers("How many years did Yaakov Avino live?", "110", "190", "148", "147");

	}

	@Test (priority = 2)
	public void startTheTriviaGame () {

		playGame.startTheTriviaGame();


	}

	@Test (priority = 3)
	public void answerQuestions () throws InterruptedException {

		playGame.answerQuestions(4,3,2);


	}

	

}
