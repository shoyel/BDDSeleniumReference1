package com.shiftedtech.qa.framework.utils;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by ShiftTeacher on 1/21/2018.
 */
public class DriverFactory {
    private static DriverFactory instance = null;

    private DriverFactory() {
        //Do-nothing..Do not allow to initialize this class from outside
    }

    public static DriverFactory getInstance()
    {
        if(instance == null){
            instance = new DriverFactory();
        }
        return instance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() // thread local driver object for webdriver
    {
        @Override
        protected WebDriver initialValue()
        {
            ChromeDriverManager.getInstance().setup();
            return new ChromeDriver();
            /*
                DesiredCapabilities caps = DesiredCapabilities.chrome();
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "58.0");
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "7");
                caps.setCapability("resolution", "1920x1080");
                try {
                    return new RemoteWebDriver(new URL(REMOTE_URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            */
            //return null;
        }
    };

    public WebDriver getDriver() // call this method to get the driver object and launch the browser
    {
        return driver.get();
    }
    public void removeDriver() // Quits the driver and closes the browser
    {
        driver.get().quit();
        driver.remove();
    }
}
