package Tests;


import Pages.CreatingTheGame;
import Pages.Functionality;
import Pages.PlayingTheGame;
import net.bytebuddy.description.ByteCodeElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


@Test
public class CompatibilityOnFireFox {




        WebDriver driver;

        private CreatingTheGame CreatGame;
        private PlayingTheGame playGame;
        private SanityTest Sanity;
        private Functionality func;



        @BeforeTest

        public void beforeEachTest() {
            driver = new FirefoxDriver();
            driver.get("https://shemsvcollege.github.io/Trivia/");
            driver.manage().window().maximize();

            CreatGame = new CreatingTheGame(driver);
            playGame = new PlayingTheGame(driver);
            func = new Functionality (driver);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            CreatGame.startTheTrivia();

        }

	@AfterTest
	public void afterEachTest() throws InterruptedException {
        System.out.println("------------END------------");
        Thread.sleep(5000);
        driver.quit();
    }


        @Test
        public void CompatibilityOnFireFox () throws InterruptedException {

            CreatGame.filUpQuestionsAndAnswers("How many years did Moshe Rabbenu live?", "110", "150", "130", "120");
            CreatGame.filUpQuestionsAndAnswers("How many years did Abraham Avino live?", "150", "180", "170", "175");
            CreatGame.filUpQuestionsAndAnswers("How many years did Yaakov Avino live?", "110", "190", "148", "147");
            playGame.startTheTriviaGame();
            playGame.answerQuestions(4,3,2);

        }

    }




