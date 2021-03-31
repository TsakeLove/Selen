import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.util.HashMap;
import java.util.Map;


public class TestWithSelenium {

    private static final String email = "bicago7317@heroulo.com";
    private static final String email2 = "DataTes58765956";
    private static final String wrongEmail = "asasq3@221.1";
    private static final String password = "Aa123456";
    private static final String trueLink = "hromadske.ua";
    private static final String err = "Мы заметили несколько необычных попыток входа в вашу учетную запись. С целью обеспечения ее безопасности просим вас ввести свой номер телефона или имя пользователя, чтобы подтвердить, что это действительно вы.";
    private static final String wrongData = "Введенные адрес электронной почты и пароль не совпадают с сохраненными в нашей базе данных. Проверьте правильность введенных данных и повторите попытку.";

    private static final long timeOutInSeconds = 20;

    private WebDriverWait waiter;
    private WebDriver driver;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriverlinux");
        driver = createWebDriver();
        waiter = createWebDriverWait(driver);
        System.out.println("Test start");
    }

    @Test
    public void testAuthName() {

        WebDriver driver =  new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait waiter = createWebDriverWait(driver);

        LoginPage loginPage = new LoginPage(driver, waiter);
        loginPage.loginValidUser(email, password, email2);


        loginPage.loginCheck();

        String name = driver.findElement(By.cssSelector("#react-root > div > div > div.css-1dbjc4n.r-18u37iz.r-13qz1uu.r-417010 > main > div > div > div > div > div > div.css-1dbjc4n.r-aqfbo4.r-14lw9ot.r-j7yic.r-rull8r.r-qklmqi.r-gtdqiz.r-1gn8etr.r-1g40b8q > div.css-1dbjc4n.r-1loqt21.r-136ojw6 > div > div > div > div > div.css-1dbjc4n.r-16y2uox.r-1wbh5a2.r-1pi2tsx.r-1777fci > div > h2 > div > div > div > span.css-901oao.css-16my406.css-bfa6kz.r-18jsvk2.r-poiln3.r-1vr29t4.r-bcqeeo.r-3s2u2q.r-qvutc0 > span > span")).getText();
        Assert.assertEquals(name, "Data Test");
        driver.quit();
    }
//
    @After
    public void close() {
        driver.quit();
        System.out.println("Test end");
    }

    private WebDriver createWebDriver() {
        return new ChromeDriver(createChromeOptions());
    }

    private WebDriverWait createWebDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, timeOutInSeconds);
    }

    private ChromeOptions createChromeOptions() {

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        return options;
    }
}
