package DriverWeb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverExe {
	private static WebDriver driver;

	public static WebDriver ativarNavegador() {
	    if (driver == null) {
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }
	    return driver;
	}
	

}
