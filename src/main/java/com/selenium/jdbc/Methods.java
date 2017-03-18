package com.selenium.jdbc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by THOODI on 3/18/2017.
 */
public class Methods {
    WebDriver driver = null;

    public String login() throws Exception

    {
        ReadPropertyFile file = new ReadPropertyFile();
        try {
            driver = new FirefoxDriver();
            driver.get(file.getUrl());

            driver.findElement(By.xpath(".//*[@id='account']/a")).click();
            driver.findElement(By.id("log")).sendKeys(file.getUsername());
            driver.findElement(By.id("pwd")).sendKeys(file.getPassword());
            driver.findElement(By.id("login")).click();

/*            driver.findElement(By.id("Email")).sendKeys(file.getUsername());
            driver.findElement(By.id("next")).click();
            Thread.sleep(1000);
            String errMsg1 = driver.findElement(By.id("errormsg_0_Email"))
                    .getText();
            driver.findElement(By.id("Passwd")).sendKeys(file.getPassword());
            driver.findElement(By.id("signIn")).click();*/

            Thread.sleep(5000);
            String url = driver.getCurrentUrl();
            if (url.contains("http://store.demoqa.com/products-page/your-account")) {
                System.out.println("Entered Username on UI: " + file.getUsername());
            } else {
                String errMsg2 = driver.findElement(By.className("error-msg"))
                        .getText();
                System.out.println("Unable to Login with:" + file.getUsername()
                        + errMsg2);
                driver.close();
            }
            driver.findElement (By.xpath(".//*[@id='account_logout']/a")).click();
            driver.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return file.getUsername();
    }

}
