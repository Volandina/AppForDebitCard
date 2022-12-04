package ru.netology.web;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppForDebitCardTest {

    private WebDriver driver;


    @BeforeAll
    public static void BeforeAll(){
        System.setProperty("webdriver.chrome.driver","driver/win/chromedriver.exe");
        //WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
     public void BeforeEach() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

    }
     @AfterEach
        public void afterEach(){
            driver.quit();
            driver = null;
        }

@Test
   public void test (){
    driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("[type= \"text\"]")).sendKeys("Кравцов Кирилл");
    driver.findElement(By.cssSelector("[type= \"tel\"]")).sendKeys("+79562222959");
    driver.findElement(By.className("checkbox__box")).click();
    driver.findElement(By.className("button__text")).click();
    String text = driver.findElement(By.className("paragraph")).getText();
    assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.",text.trim());
}



}

