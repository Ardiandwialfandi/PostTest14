package com.juaracoding.postest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PostTest14 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ARDI\\.cache\\selenium\\chromedriver\\win32\\110.0.5481.77\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String url = "https://formy-project.herokuapp.com/form";
        driver.get(url);
        System.out.println("Get URL : "+url);
        driver.manage().window().maximize();
        System.out.println("maximize windows... Success!");

        String title = driver.getTitle();
        System.out.print("Test Result : ");
        if(title.equals("Formy")){
            System.out.println("Pass!");
        }else{
            System.out.println("Failed!");
        }

        driver.findElement(By.id("first-name")).sendKeys("Juara-Coding");
        System.out.println("First Name... Success!");
        driver.findElement(By.id("last-name")).sendKeys("Mantap");
        System.out.println("Last Name... Success!");
        driver.findElement(By.xpath("//*[@id=\"job-title\"]")).sendKeys("Software Quality Assurance");
        System.out.println("Job Title... Success!");
        driver.findElement(By.xpath("//*[@id=\"radio-button-3\"]")).click();
        System.out.println("Highest level Success");
        driver.findElement(By.id("checkbox-1")).click();
        System.out.println("Option Sex... Success!");

        js.executeScript("window.scroll(0,400)");

        WebElement years = driver.findElement(By.id("select-menu"));
        Select year = new Select(years);
        int dropDownValueYear = driver.findElements(By.tagName("option")).size();
        Random indexRandom = new Random();
        int indexYear = indexRandom.nextInt(dropDownValueYear);
        year.selectByIndex(indexYear);
        System.out.println("Select Years... Success!");

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        String dateNow = dateFormat.format(date);
        driver.findElement(By.id("datepicker")).sendKeys(dateNow);
        System.out.println("Input Date... Success!");
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("/html/body/div/form/div/div[8]/a")).click();
        System.out.println("Submit... Success!");


        String sucesss = driver.findElement(By.xpath("/html/body/div/div")).getText();
        System.out.println(sucesss);

        System.out.println("===Delay 3 Second===");
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }


        driver.quit();
        System.out.println("Quit");
    }
}
