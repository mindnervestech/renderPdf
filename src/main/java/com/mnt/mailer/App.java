package com.mnt.mailer;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	WebDriver driver = new FirefoxDriver();
    	driver.get("http://li664-78.members.linode.com:8081/template/madmin/app/#/login");
    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.name("j_username"))).sendKeys("admin");
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.name("j_password"))).sendKeys("admin");
    	wait.until(ExpectedConditions.elementToBeClickable(By.className("fa-chevron-circle-right"))).click();
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.className("legendColorBox")));
    	wait.until(ExpectedConditions.elementToBeClickable(By.id("menu-toggle"))).click();
    	((JavascriptExecutor)driver).executeScript("arguments[0].style.visibility='hidden'", driver.findElement(By.id("topbar")));
    	((JavascriptExecutor)driver).executeScript("arguments[0].style.visibility='hidden'", driver.findElement(By.id("sidebar")));
    	
    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	try {
			FileUtils.copyFile(scrFile, new File("E:\\dev\\screenshot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	System.out.println( "Hello World!" );
    }
}
