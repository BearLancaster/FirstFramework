package com.test.main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;



public class TestMain {


    public static void main(String[] args) {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Windows");
        caps.setCapability("platformVersion", "10");
        caps.setCapability("deviceName", "WindowsPC");
        caps.setCapability("app", "D:\\BaiduNetdisk\\BaiduNetdisk.exe");

        try {
            AppiumDriver<WebElement> driver = new AppiumDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), caps);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    }
