package applaudo.pmo;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Base {

    private WebDriver driver;

    public Base(WebDriver driver){
        this.driver = driver;
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public void visit(String url){
        driver.navigate().to(url);
    }

    public void goBack(){
        driver.navigate().back();
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }

    public void maxiBrowser(){
        driver.manage().window().maximize();
    }

    public void closeBrowser(){
        driver.quit();
    }

    public void closeTab(){
        driver.close();
    }

    public int countOpenTab(){
        return driver.getWindowHandles().size();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void switchTo(String idWindow){
        driver.switchTo().window(idWindow);
    }

    public Set<String> getIdWindows(){
        return driver.getWindowHandles();
    }

    public void waitisVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public Alert switchToAlert(){
        return driver.switchTo().alert();
    }

    public void scrollToItem(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void numberOfWindowsToBe(int windowCount){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.numberOfWindowsToBe(windowCount));
    }

    public void waitalertIsPresent(int seconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public Alert waitalerVerify(int seconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.alertIsPresent());
    }

}
