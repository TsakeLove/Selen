package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

    private WebDriver driver;
    private WebDriverWait waiter;

   // private By byIdEmail = By.id("email");
   // private By byIdPassword = By.id("pass");
   // private By byNameLogin = By.name("login");
   // private By byIdError = By.id("error_box");

    private By byNameForm = By.name("session[username_or_email]");
    private By byIdMain = By.id("react-root");
    private By byNameEmail = By.name("session[username_or_email]");
    private By byNamePass = By.name("session[password]");
    private By byXpathLogButton = By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[3]/div");

  //  private By byTagDiv = By.tagName("div");

    private By byCssButton = By.cssSelector("[href=\"/login\"]");

  //  private By byCssSelectorAcceptCookies = By.cssSelector("._42ft._4jy0._9o-t._4jy3._4jy1.selected._51sy");


    private By byCssAbout = By.cssSelector("#react-root > div > div > div.css-1dbjc4n.r-18u37iz.r-13qz1uu.r-417010 > header > div > div > div > div:nth-child(1) > div.css-1dbjc4n.r-1awozwy.r-15zivkp.r-1bymd8e.r-13qz1uu > nav > a:nth-child(7)");

    public LoginPage(WebDriver driver, WebDriverWait waiter){
        this.driver = driver;
        this.waiter = waiter;
        driver.get("https://twitter.com");
        toLogin();
    }


    public HomePage loginValidUser(String email, String password, String email2) {

        waiter.until(ExpectedConditions.visibilityOfElementLocated(byNameForm));
        WebElement main = driver.findElement(byIdMain);
        main.findElement(byNameEmail).sendKeys(email);
        main.findElement(byNamePass).sendKeys(password);
        driver.findElement(byXpathLogButton).click();
        Sus(email2, password);
        return new HomePage(driver, waiter);

    }
    public HomePage loginForCheck(String email, String password) {
        waiter.until(ExpectedConditions.visibilityOfElementLocated(byNameForm));
        WebElement main = driver.findElement(byIdMain);
        main.findElement(byNameEmail).sendKeys(email);
        main.findElement(byNamePass).sendKeys(password);
        driver.findElement(byXpathLogButton).click();
        return new HomePage(driver, waiter);
    }

    public void loginCheck ()
    {
        waiter.until(ExpectedConditions.visibilityOfElementLocated(byCssAbout));
        driver.findElement(byCssAbout).click();
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#react-root > div > div > div.css-1dbjc4n.r-18u37iz.r-13qz1uu.r-417010 > main > div > div > div > div > div > div.css-1dbjc4n.r-aqfbo4.r-14lw9ot.r-j7yic.r-rull8r.r-qklmqi.r-gtdqiz.r-1gn8etr.r-1g40b8q > div.css-1dbjc4n.r-1loqt21.r-136ojw6 > div > div > div > div > div.css-1dbjc4n.r-16y2uox.r-1wbh5a2.r-1pi2tsx.r-1777fci > div > h2 > div > div > div > span.css-901oao.css-16my406.css-bfa6kz.r-18jsvk2.r-poiln3.r-1vr29t4.r-bcqeeo.r-3s2u2q.r-qvutc0 > span > span")));
    }

    private void Sus (String email2, String password) {
        waiter.until(ExpectedConditions.visibilityOfElementLocated(byNameForm));
        driver.findElement(byNameEmail).sendKeys(email2);
        driver.findElement(byNamePass).sendKeys(password);
        driver.findElement(byXpathLogButton).click();
    }


    private void toLogin(){
        waiter.until(ExpectedConditions.visibilityOfElementLocated(byCssButton));
        driver.findElement(byCssButton).click();
    }

}