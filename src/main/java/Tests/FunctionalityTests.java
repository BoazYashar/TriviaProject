package Tests;


import Pages.CreatingTheGame;
import Pages.Functionality;
import Pages.PlayingTheGame;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test
public class FunctionalityTests {

	WebDriver driver;

	private CreatingTheGame CreatGame;
	private PlayingTheGame playGame;
	private Functionality func;

	//Locators

	//Mark answer 2 as a right answer
	WebElement MarkAnswer2  = driver.findElement(By.xpath("//*[@id=\"answers\"]/div[2]/div[1]/input"));



	@BeforeTest
	public void beforeEachTest() {
		driver = new ChromeDriver();
		driver.get("https://shemsvcollege.github.io/Trivia/");
		driver.manage().window().maximize();
		CreatGame = new CreatingTheGame(driver);
		playGame = new PlayingTheGame(driver);
		func = new Functionality(driver);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		CreatGame.startTheTrivia();

	}

	@AfterTest
	public void afterEachTest() throws InterruptedException {
		System.out.println("------------END------------");
		Thread.sleep(5000);

		driver.quit();

	}

//Bounder Values in question filled (min)
 	@Test//(priority = 0) //Insert 1 character on question field.
	public void bounderValuesMin() throws InterruptedException {

		driver = new ChromeDriver();
		System.out.println("---------Start test 1--------");
		System.out.println("The Test ID IS:" + Thread.currentThread().getId());

		CreatGame.filUpQuestionsAndAnswers("a", "110", "120", "130", "150");
	}

	//Bounder Values in question filled (max)
	@Test//(priority = 1)//Insert 50 characters on first question (max).
	public void bounderValuesMax() throws InterruptedException {
		System.out.println("---------Start test 2--------");
		System.out.println("The Test ID IS:" + Thread.currentThread().getId());

		CreatGame.filUpQuestionsAndAnswers("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "150", "170", "175", "180");//(max)50 chars

	}

	@Test//(priority = 2)
	public void autoAddingQuestionMark() throws InterruptedException {
		System.out.println("---------Start test 3--------");
		System.out.println("The Test ID IS:" + Thread.currentThread().getId());


		CreatGame.filUpQuestionsAndAnswers("How many years did Moshe Rabbenu live", "110", "120", "148", "147");
		CreatGame.filUpQuestionsAndAnswers("How many years did Abraham Avino live", "150", "180", "170", "175");
		CreatGame.filUpQuestionsAndAnswers("How many years did Yaakov Avino live", "110", "190", "148", "147");
		playGame.startTheTriviaGame();
		assertEquals(true, driver.getPageSource().contains("Avino live?"));
	}

	@Test//(priority = 3)
	public void errorHandlingHeb() throws InterruptedException {

		System.out.println("---------Start test 4--------");
		System.out.println("The Test ID IS:" + Thread.currentThread().getId());


		CreatGame.filUpQuestionsAndAnswers("рст", "р", "с", "т", "у");
	}

	@Test//(priority = 4)
	public void errorHandling51CharsInQuestion() throws InterruptedException {
		System.out.println("---------Start test 5--------");
		System.out.println("The Test ID IS:" + Thread.currentThread().getId());

		CreatGame.filUpQuestionsAndAnswers("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa?", "150", "170", "175", "180");//(max)50 chars
	}

	@Test//(priority = 5)
	public void errorHandling31CharsInAnswer() throws InterruptedException {
		System.out.println("---------Start test 6--------");
		System.out.println("The Test ID IS:" + Thread.currentThread().getId());

		CreatGame.filUpQuestionsAndAnswers("aaa?", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "170", "175", "180");//(max)50 chars
		driver.switchTo().alert().accept();
		assertEquals(true, driver.getPageSource().contains("Please enter 4 possible answers "));//if found it its mean that he dont continue to next page


	}

	@Test//(priority = 6)
	public void errorHandling51Chars() throws InterruptedException {
		System.out.println("---------Start test 7--------");
		System.out.println("The Test ID IS:" + Thread.currentThread().getId());

		CreatGame.filUpQuestionsAndAnswers("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa?", "150", "170", "175", "180");//(max)50 chars
	}


	//Quit key
	@Test //(priority = 7)
	public void quitTheTriviaGame() throws InterruptedException {
		System.out.println("---------Start test 8--------");
		System.out.println("The Test ID IS:" + Thread.currentThread().getId());


		CreatGame.filUpQuestionsAndAnswers("How many years did Moshe Rabbenu live?", "110", "150", "130", "120");
		CreatGame.filUpQuestionsAndAnswers("How many years did Abraham Avino live?", "150", "180", "170", "175");
		CreatGame.filUpQuestionsAndAnswers("How many years did Yaakov Avino live?", "110", "190", "148", "147");
		playGame.startTheTriviaGame();
		playGame.answerQuestions(4, 3, 2);

		func.quitTheTriviaGame();
	}


	@Test// (priority = 8)
	public void backToThePreviousPageOne() throws InterruptedException {
		driver = new ChromeDriver();
		System.out.println("---------Start test 9--------");
		System.out.println("The Test ID IS:" + Thread.currentThread().getId());

		func.backToPriviousPageOne();
		assertTrue(true, String.valueOf(driver.getPageSource().contains("QA Test ")));//


	}

	@Test// (priority = 9)
	public void backToThePreviousPageTwo() throws InterruptedException {

		System.out.println("---------Start test 10--------");
		System.out.println("The Test ID IS:" + Thread.currentThread().getId());

		CreatGame.filUpQuestionsAndAnswers("How many years did Moshe Rabbenu live?", "110", "150", "130", "120");
		func.backToPriviousPageOne();
		assertTrue(true, String.valueOf(driver.getPageSource().contains("Please type here your question")));//

	}
	@Test// (priority = 9)
	public void backToThePreviousPageTree() throws InterruptedException {

		System.out.println("---------Start test 11--------");
		System.out.println("The Test ID IS:" + Thread.currentThread().getId());

		CreatGame.filUpQuestionsAndAnswers("How many years did Moshe Rabbenu live?", "110", "150", "130", "120");
		CreatGame.filUpQuestionsAndAnswers("How many years did Abraham Avino live?", "150", "180", "170", "175");
//		CreatGame.filUpQuestionsAndAnswers("How many years did Yaakov Avino live?", "110", "190", "148", "147");
		Thread.sleep(2000);
		func.backToPriviousPageOne();


		assertTrue(false, String.valueOf(driver.getPageSource().contains("question number: 3")));//

	}

	//One wrong Answer
	@Test //(priority = 7)
	public void oneWrongAnswer() throws InterruptedException {
		System.out.println("---------Start test 12--------");
		System.out.println("The Test ID IS:" + Thread.currentThread().getId());

		CreatGame.filUpQuestionsAndAnswers("How many years did Moshe Rabbenu live?", "110", "150", "130", "120");
		CreatGame.filUpQuestionsAndAnswers("How many years did Abraham Avino live?", "150", "180", "170", "175");
		CreatGame.filUpQuestionsAndAnswers("How many years did Yaakov Avino live?", "110", "190", "148", "147");
		playGame.startTheTriviaGame();
		playGame.answerQuestions(4, 3, 1);//oneWrongAnswer
		assertTrue(false, String.valueOf(driver.getPageSource().contains("Sucsses")));//


	}

	//Press on next without defining an answer| answer 1
	@Test //(priority = 7)
	public void nextQuestionWithoutAnswering() throws Exception {
		System.out.println("---------Start test 13--------");
		System.out.println("The Test ID IS:" + Thread.currentThread().getId());

		CreatGame.filUpQuestionsAndAnswers("How many years did Moshe Rabbenu live?", "110", "150", "130", "120");
		CreatGame.filUpQuestionsAndAnswers("How many years did Abraham Avino live?", "150", "180", "170", "175");
		CreatGame.filUpQuestionsAndAnswers("How many years did Yaakov Avino live?", "110", "190", "148", "147");
		playGame.startTheTriviaGame();
		playGame.NextChoseButton();

		func.alertExists();
		playGame.answer1();
		playGame.NextChoseButton();
	}

		//Press on next without defining an answer| answer 2
		@Test //(priority = 7)
		public void nextQuestionWithoutAnswering2 () throws Exception {
			System.out.println("---------Start test 14--------");
			System.out.println("The Test ID IS:" + Thread.currentThread().getId());

			CreatGame.filUpQuestionsAndAnswers("How many years did Moshe Rabbenu live?", "110", "150", "130", "120");
			CreatGame.filUpQuestionsAndAnswers("How many years did Abraham Avino live?", "150", "180", "170", "175");
			CreatGame.filUpQuestionsAndAnswers("How many years did Yaakov Avino live?", "110", "190", "148", "147");
			playGame.startTheTriviaGame();

			playGame.answer1();
			playGame.NextChoseButton();

			playGame.NextChoseButton();
			func.alertExists();
			playGame.answer2();
		}
//

	//Press on next without defining an answer| answer 3
	@Test //(priority = 7)
	public void nextQuestionWithoutAnswering3 () throws Exception {
		System.out.println("---------Start test 15--------");
		System.out.println("The Test ID IS:" + Thread.currentThread().getId());

		CreatGame.filUpQuestionsAndAnswers("How many years did Moshe Rabbenu live?", "110", "150", "130", "120");
		CreatGame.filUpQuestionsAndAnswers("How many years did Abraham Avino live?", "150", "180", "170", "175");
		CreatGame.filUpQuestionsAndAnswers("How many years did Yaakov Avino live?", "110", "190", "148", "147");
		playGame.startTheTriviaGame();

		playGame.answer1();
		playGame.NextChoseButton();
		playGame.answer2();

		playGame.NextChoseButton();
		playGame.NextChoseButton();

		func.alertExists();
		playGame.answer3();
		playGame.NextChoseButton();

	}


	//Change selection of radio button.
	@Test //(priority = 7)
	public void changeSelection() throws Exception {
		System.out.println("---------Start test 16--------");
		System.out.println("The Test ID IS:" + Thread.currentThread().getId());

		CreatGame.filUpQuestionsAndAnswers("How many years did Moshe Rabbenu live?", "110", "150", "130", "120");
		func.backToPriviousPageOne();
		func.changeTheMarkAnswer();
//		assertTrue(MarkAnswer2.isSelected(), "Oh No, MarkAnswer2 is not Selected");
	}

		}








