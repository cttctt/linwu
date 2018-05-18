package com.summersoft.ctt.yycx.test;
import com.summersoft.ctt.yycx.util.MyWebdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestJs {

    /**
     * 解决在某些环境下，使用click方法无效的情况
     */
    public WebDriver driver;
    private String url="http://www.sogou.com";

    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", MyWebdriver.ProjectURL+"/browser/chromedriver.exe");
        driver= new ChromeDriver();
        driver.get(url);

    }


    @AfterMethod
    public void tearDown(){
//        driver.close();
    }

    private boolean IsImageVisible(WebDriver driver,WebElement image){
        Boolean imageLoaded1 = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", image);
        if (!imageLoaded1)
        {
            return false;
        }
        return true;
    }
    @Test
    public void testHandlerFrame(){
        WebElement searchinputbox=driver.findElement(By.id("query"));
        WebElement searchButton=driver.findElement(By.id("stb"));
        searchinputbox.sendKeys("使用JavaScript语句进行");
        JavaScriptClick(searchButton);

        WebElement image = driver.findElement(By.cssSelector("#data_list > div:nth-child(1) > div.col-xs-3.text-left.imgBox > img:nth-child(2)"));
        boolean isVisible = this.IsImageVisible(driver, image);


    }
    public void JavaScriptClick(WebElement element){
        try {

            if (element.isEnabled() && element.isDisplayed()) {

                ((JavascriptExecutor)driver).executeScript("arguments[0].click();",element );


            }else {
                System.out.println("页面上的元素无法进行点击操作");
            }



        } catch (Exception e) {
// TODO: handle exception
            e.printStackTrace();
        }


    }
}
