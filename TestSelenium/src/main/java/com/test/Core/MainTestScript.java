package com.test.Core;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class MainTestScript {


    public static void main(String arg[])
    {
        System.setProperty("webdriver.chrome.driver", "D:\\WorkSpace\\TestSelenium\\File\\chromedriver_win32\\chromedriver.exe");
        WebDriver Driver = new ChromeDriver();
        String baseUrl = "http://old.gmhgroup.com.au/gsystem/system";
        Driver.get(baseUrl);
        WebElement usename=Driver.findElement(By.name("username"));
        usename.sendKeys("zhuang");
        WebElement password=Driver.findElement(By.name("password"));
        password.sendKeys("123456");
        Driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[3]/div/button[1]")).click();
        System.out.println("11111111111111111111111111111111111111111111111111");





    }

}
