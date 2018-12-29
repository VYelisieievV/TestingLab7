package eliseev.framework.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Firefox {
    private static WebDriver driver;
    private static Firefox firefox = new Firefox();
    Firefox(){}

    public static void initialize() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.23.0-win64\\geckodriver.exe");
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }

    public static WebDriver getDriver(){
        return driver;
    }
    public static void setDriver(WebDriver dr){
        driver=dr;
    }
    public static void shutDown() {driver.quit();}
}






