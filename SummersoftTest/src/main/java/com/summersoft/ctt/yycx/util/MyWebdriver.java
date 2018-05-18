package com.summersoft.ctt.yycx.util;


import com.summersoft.ctt.yycx.po.LoginPo;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class MyWebdriver {
    //使用浏览器
    public static WebDriver driver = null;
    public static MyWebdriver d;
    public static String ProjectURL = System.getProperty("user.dir") + "\\src\\main\\resources";
    public static String RANDOM = String.valueOf(new Date().getTime());
    //开通项目的类型（约约：区域类型开通三个出租车|专车|快车，易行通：出租车,其他：专车和快车）
    public static String ProjectType = "易行通";
    public static String bussinessType="专车";
    //开通区域代理城市
    public static String city = "厦门市";
    // 约约测试服后台地址
    public static String baseURL = "http://5000.gr165c6f.summersoft.ali-sh.goodrain.net:10080/admin/index.html";
    //轩轩测试服后台地址
    //  public static String baseURL="http://59.110.8.172:8380/admin/index.html";
    //国金测试服后台地址
    //public static String baseURL="https://admin.jishiyongche.com";
    //华威易行通后台地址
    //public static String baseURL="http://139.159.234.143:8380/admin/index.html";
    //美天后台测试地址
    //public static String baseURL="http://120.55.41.65:8380/admin/index.html";
    //万合测试后台地址
    // public  static String baseURL="http://113.134.215.20:3014/admin/index.html";
    //交投测试后台地址
    //  public static String baseURL="https://jtcx.jtgogo.cn/admin/index.html";
    public static String  tableMessage="没有找到记录";
    public String value = "";
    public boolean flag = true;
    public WebDriverWait wait;
    public WebElement element;
    public MyWebdriver() {

    }

    public MyWebdriver(WebDriver driver) {

        MyWebdriver.driver = driver;
    }


    public static void setWebDriver(WebDriver driver) {

        MyWebdriver.driver = driver;
    }

    public static WebDriver getWebDriver() {

        return driver;
    }

    /**
     * 获取右上角的动态弹框信息
     */
    public void getMessage()
    {
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("toast-message")));
        Logger.Output(LogType.LogTypeName.INFO, driver.findElement(By.className("toast-message")).getText());
    }
    public void wait(By by)
    {
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    /**
     * 获取外部文件的值
     *
     * @param key（config.properties里的键值）
     * @return
     * @throws IOException
     */
    public static String config(String key) throws IOException {
        Properties p = new Properties();
        String url = MyWebdriver.ProjectURL + "/config/config.properties";
        InputStream ips = new FileInputStream(url);
        p.load(ips);
        String value = p.getProperty(key);
        ips.close();
        return value;
    }

    /**
     * 查找元素
     *
     * @param by      传入一个类型
     * @param byValue 传入一个类型值
     * @return 返回一个WebElement对象
     */
    public WebElement findElement(String by, String byValue) {

        try {
            switch (by) {
                case "id":
                    element = driver.findElement(By.id(byValue));
                    break;
                case "name":
                    element = driver.findElement(By.name(byValue));
                    break;
                case "class":
                    element = driver.findElement(By.className(byValue));
                    break;
                case "tag":
                    element = driver.findElement(By.tagName(byValue));
                case "link":
                    element = driver.findElement(By.linkText(byValue));
                    break;
                case "partiallinktext":
                    element = driver.findElement(By.partialLinkText(byValue));
                case "css":
                    element = driver.findElement(By.cssSelector(byValue));
                    break;
                case "xpath":
                    element = driver.findElement(By.xpath(byValue));
                    break;
                default:
                    throw new RuntimeException("输入的定位类型未在程序中定义，类型为：" + byValue);
            }
        } catch (Exception e) {
            Logger.Output(LogType.LogTypeName.WARNING, "没有找到元素：" + byValue);

        }
        return element;
    }

    /**
     * 查找元素并点击
     *
     * @param by      传入一个类型
     * @param byValue 传入一个类型值
     */
    public void findElementClick(String by, String byValue) {
        try {
            findElement(by, byValue).click();
        } catch (Exception e) {
            Logger.Output(LogType.LogTypeName.WARNING, "没有找到该元素或者该元素不能被点击");

        }
    }


    /**
     * 查找元素并清除
     *
     * @param by      传入一个类型
     * @param byValue 传入一个类型值
     */
    public void findElementClear(String by, String byValue) {
        try {
            findElement(by, byValue).clear();
        } catch (Exception e) {
            Logger.Output(LogType.LogTypeName.WARNING, "没有找到该元素或者该元素没有输入值");

        }
    }

    /**
     * 查找元素并输入值
     *
     * @param by      传入一个类型
     * @param byValue 传入一个类型值
     * @param key     填写要输入的值
     */
    public void findElementSendKeys(String by, String byValue, String key) {
        try {
            findElement(by, byValue).sendKeys(key);
        } catch (Exception e) {
            Logger.Output(LogType.LogTypeName.WARNING, "没有找到该元素或者该元素无法输入");

        }
    }

    /**
     * 执行js方法
     *
     * @param js
     */
    public boolean excuteJS(String js) {
        if (flag) {
            try {
                ((JavascriptExecutor) driver).executeScript(js);
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        } else {
            System.out.println("flag is false, function is not excuted");
            return false;
        }
    }

    /**
     * 根据id定位元素并输入内容
     *
     * @param id
     * @param value
     */
    public boolean inputById(String id, String value) {
        if (flag) {
            try {
                driver.findElement(By.id(id)).sendKeys(value);
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        } else {
            System.out.println("flag is false, function is not excuted");
            return false;
        }
    }

    /**
     * 根据xpath定位元素并输入内容
     *
     * @param xpath
     * @param value
     */
    public boolean inputByXpath(String xpath, String value) {
        if (flag) {
            try {
                driver.findElement(By.xpath(xpath)).sendKeys(value);
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        } else {
            System.out.println("flag is false, function is not excuted");
            return false;
        }
    }

    /**
     * 根据css定位元素并输入内容
     *
     * @param css
     * @param value
     */
    public boolean inputByCss(String css, String value) {
        if (flag) {
            try {
                driver.findElement(By.cssSelector(css)).sendKeys(value);
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        } else {
            System.out.println("flag is false, function is not excuted");
            return false;
        }
    }

    public boolean clickBindCard(String cardNo) {
        flag = false;
        String value = "";
        int i = 0;
        if (!driver.findElement(By.id("r_x")).isDisplayed()) {
            for (i = 0; i < 5; i++) {
                value = driver.findElement(By.id("t_b_" + i)).getText();
                if (value.contains(cardNo)) {
                    flag = true;
                    System.out.println("t_b_" + i);
                    driver.findElement(By.id("sel_img_" + i)).click();
                }
            }
        } else {
            while (driver.findElement(By.id("r_x")).isDisplayed()) {
                System.out.println("i>>" + i);
                if (i > 0 && i % 5 == 0) {
                    driver.findElement(By.id("r_x")).click();
                }
                value = driver.findElement(By.id("t_b_" + i)).getText();
                System.out.println(value + ">>" + value.contains(cardNo));
                if (value.contains(cardNo)) {
                    flag = true;
                    System.out.println("t_b_" + i);
                    driver.findElement(By.id("sel_img_" + i)).click();
                    break;
                }
                i++;
            }
        }
        return flag;
    }

    /**
     * 根据id定位元素并点击
     *
     * @param id
     */
    public boolean clickById(String id) {
        if (flag) {
            try {
                if (id.startsWith("sel_img_") && !id.contains("sel_img_ct")) {
                    int i = Integer.parseInt(id.substring(8, id.length()));
                    int j = 4;
                    while (i > 3) {
                        driver.findElement(By.id("sel_img_" + j)).click();
                        i -= 4;
                        j += 4;
                    }
                }
                driver.findElement(By.id(id)).click();
                System.out.println("click element by id>>" + id);
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        } else {
            System.out.println("flag is false, function is not excuted");
            return false;
        }
    }

    /**
     * 根据xpath定位元素并点击
     *
     * @param xpath
     */
    public boolean clickByXpath(String xpath) {
        if (flag) {
            try {
                driver.findElement(By.xpath(xpath)).click();
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        } else {
            System.out.println("flag is false, function is not excuted");
            return false;
        }
    }

    /**
     * 根据css定位元素并点击
     *
     * @param css
     */
    public boolean clickByCss(String css) {
        if (flag) {
            try {
                driver.findElement(By.cssSelector(css)).click();
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        } else {
            System.out.println("flag is false, function is not excuted");
            return false;
        }
    }

    /**
     * 根据id定位元素并连续点击
     *
     * @param id
     */
    public boolean clickById(String id, int count) {
        if (flag) {
            try {
                if (id.startsWith("sel_img_") && !id.contains("sel_img_ct")) {
                    int i = Integer.parseInt(id.substring(8, id.length()));
                    int j = 4;
                    while (i > 3) {
                        driver.findElement(By.id("sel_img_" + j)).click();
                        i -= 4;
                        j += 4;
                    }
                }
                for (int i = 0; i < count; i++) {
                    driver.findElement(By.id(id)).click();
                }
                System.out.println("click element by id>>" + id);
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        } else {
            System.out.println("flag is false, function is not excuted");
            return false;
        }
    }

    /**
     * 根据xpath定位元素并连续点击
     *
     * @param xpath
     */
    public boolean clickByXpath(String xpath, int count) {
        if (flag) {
            try {
                for (int i = 0; i < count; i++) {
                    driver.findElement(By.xpath(xpath)).click();
                }
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        } else {
            System.out.println("flag is false, function is not excuted");
            return false;
        }
    }

    /**
     * 根据css定位元素并连续点击
     *
     * @param css
     */
    public boolean clickByCss(String css, int count) {
        if (flag) {
            try {
                for (int i = 0; i < count; i++) {
                    driver.findElement(By.cssSelector(css)).click();
                }
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        } else {
            System.out.println("flag is false, function is not excuted");
            return false;
        }
    }

    /**
     * 根据xpath定位元素获取值
     *
     * @param xpath
     * @return
     */
    public String getValueByXpath(String xpath) {
        if (flag) {
            value = driver.findElement(By.xpath(xpath)).getText();
            System.out.println();
            return value;
        } else {
            System.out.println("flag is false, function is not excuted");
            return null;
        }
    }

    /**
     * 根据id定位元素获取值
     *
     * @param id
     * @return
     */
    public String getValueById(String id) {
        if (flag) {
            value = driver.findElement(By.id(id)).getText();
            System.out.println(value);
            return value;
        } else {
            System.out.println("flag is false, function is not excuted");
            return null;
        }
    }

    /**
     * 根据css定位元素获取值
     *
     * @param css
     * @return
     */
    public String getValueByCss(String css) {
        if (flag) {
            value = driver.findElement(By.cssSelector(css)).getText();
            System.out.println(value);
            return value;
        } else {
            System.out.println("flag is false, function is not excuted");
            return null;
        }
    }

    /**
     * 根据id定位元素并清空值
     *
     * @param id
     */
    public boolean clearInputValueById(String id) {
        if (flag) {
            try {
                driver.findElement(By.id(id)).clear();
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        } else {
            System.out.println("flag is false, function is not excuted");
            return false;
        }
    }

    /**
     * 根据xpath定位元素并清空值
     *
     * @param xpath
     */
    public boolean clearInputValueByXpath(String xpath) {
        if (flag) {
            try {
                driver.findElement(By.xpath(xpath)).clear();
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        } else {
            System.out.println("flag is false, function is not excuted");
            return false;
        }
    }

    /**
     * 根据css定位元素并清空值
     *
     * @param css
     */
    public boolean clearInputValueByCss(String css) {
        if (flag) {
            try {
                driver.findElement(By.cssSelector(css)).clear();
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        } else {
            System.out.println("flag is false, function is not excuted");
            return false;
        }
    }

    /**
     * 获取网页的title值
     *
     * @return
     */
    public String getTitle() {
        if (flag) {
            return driver.getTitle();
        } else {
            System.out.println("flag is false, function is not excuted");
            return null;
        }
    }

    /**
     * 切换到frame框
     *
     * @param frameName
     */
    public boolean switchToFrame(String frameName) {
        if (flag) {
            try {
                driver.switchTo().frame(frameName);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                return false;
            }
        } else {
            System.out.println("flag is false, function is not excuted");
            return false;
        }
    }

    /**
     * 根据id定位元素并获取元素的显示状态
     *
     * @param id
     * @return boolean
     */
    public boolean getDisplayStatById(String id) {
        if (flag) {
            return driver.findElement(By.id(id)).isDisplayed();
        } else {
            System.out.println("flag is false, function is not excuted");
            return false;
        }
    }

    /**
     * 根据xpath定位元素并获取元素的显示状态
     *
     * @param xpath
     * @return
     */
    public boolean getDisplayStatByXpath(String xpath) {
        if (flag) {
            return driver.findElement(By.xpath(xpath)).isDisplayed();
        } else {
            System.out.println("flag is false, function is not excuted");
            return false;
        }
    }

    /**
     * 根据css定位元素并获取元素的显示状态
     *
     * @param css
     * @return
     */
    public boolean getDisplayStatByCss(String css) {
        if (flag) {
            return driver.findElement(By.cssSelector(css)).isDisplayed();
        } else {
            System.out.println("flag is false, function is not excuted");
            return false;
        }
    }

    /**
     * 根据id定位元素并获取元素的可写状态
     *
     * @param id
     * @return
     */
    public boolean getEnableStatById(String id) {
        if (flag) {
            return driver.findElement(By.id(id)).isEnabled();
        } else {
            System.out.println("flag is false, function is not excuted");
            return false;
        }
    }

    /**
     * 根据xpath定位元素并获取元素的可写状态
     *
     * @param xpath
     * @return
     */
    public boolean getEnableStatByXpath(String xpath) {
        if (flag) {
            return driver.findElement(By.xpath(xpath)).isEnabled();
        } else {
            System.out.println("flag is false, function is not excuted");
            return false;
        }
    }

    /**
     * 根据css定位元素并获取元素的可写状态
     *
     * @param css
     * @return
     */
    public boolean getEnableStatByCss(String css) {
        if (flag) {
            return driver.findElement(By.cssSelector(css)).isEnabled();
        } else {
            System.out.println("flag is false, function is not excuted");
            return false;
        }

    }

    /**
     * 根据id定位元素并获取元素的选中状态
     *
     * @param id
     * @return
     */
    public boolean getSelectStatById(String id) {
        if (flag) {
            return driver.findElement(By.id(id)).isSelected();
        } else {
            System.out.println("flag is false, function is not excuted");
            return false;
        }
    }

    /**
     * 根据xpath定位元素并获取元素的选中状态
     *
     * @param xpath
     * @return
     */
    public boolean getSelectStatByXpath(String xpath) {
        if (flag) {
            return driver.findElement(By.xpath(xpath)).isSelected();
        } else {
            System.out.println("flag is false, function is not excuted");
            return false;
        }
    }

    /**
     * 根据css定位元素并获取元素的选中状态
     *
     * @param css
     * @return
     */
    public boolean getSelectStatByCss(String css) {
        if (flag) {
            return driver.findElement(By.cssSelector(css)).isSelected();
        } else {
            System.out.println("flag is false, function is not excuted");
            return false;
        }
    }

    /**
     * 获取当前焦点所在页面元素的属性值(name,value,id,src等等)
     *
     * @param attribute
     * @return
     */
    public String getFocusAttributeValue(String attribute) {
        try {
            Thread.sleep(333);
        } catch (Exception e) {
            e.printStackTrace();
        }
        value = driver.switchTo().activeElement().getAttribute(attribute);
        System.out.println("The focus Element's " + attribute
                + "attribute value is>>" + value);
        return value;
    }

    /**
     * 判断元素是否存在
     *
     * @param locator
     * @return
     */
    public boolean ElementExist(String by, String locator) {
        try {
            this.findElement(by, locator);
            return true;
        } catch (NoSuchElementException ex) {
            // TODO: handle exception
            return false;
        }

    }

    /**
     * 打开网页链接
     *
     * @param pageUrl
     */
    public boolean openPage(String pageUrl) {
        try {
            driver.get(pageUrl);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * 进入测试，打开浏览器，输入网址，打开网页
     *
     * @param remoteUrl 远程服务器地址
     * @param pageUrl   测试页面地址
     */
    public boolean startTest(String remoteUrl, String pageUrl) {
        try {
            try {
                driver = new RemoteWebDriver(new URL(remoteUrl),
                        DesiredCapabilities.firefox());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver.get(pageUrl);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * 进入测试，打开浏览器，输入网址，打开网页
     *
     * @param explore   调用的浏览器，需要启动不同的server，如：firefox，需要运行selenium-server-standalone-
     *                  2.33.0.jar。IE，则需运行IEDriverServer.exe
     * @param remoteUrl 远程服务器地址
     * @param pageUrl   测试页面地址
     */
    public boolean startTest(String explore, String remoteUrl, String pageUrl) {
        try {
            try {
                if ("f".equals(explore)) {
                    System.out.println("firefox");
                    driver = new RemoteWebDriver(new URL(remoteUrl),
                            DesiredCapabilities.firefox());
                } else if ("ie".equals(explore)) {
                    System.out.println("internet explorer");
                    DesiredCapabilities cap = DesiredCapabilities
                            .internetExplorer();
                    driver = new RemoteWebDriver(new URL(remoteUrl), cap);
                } else {
                    System.out.println("firefox");
                    driver = new RemoteWebDriver(new URL(remoteUrl),
                            DesiredCapabilities.firefox());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            driver.get(pageUrl);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * 设置定位页面元素的超时时间
     *
     * @param second
     * @return
     */
    public boolean setTimeOut(int second) {
        try {
            driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * 设置定位页面元素的超时时间固定时长5s
     *
     * @param
     */
    public boolean setTimeOut() {
        try {
            driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * 结束测试，关闭浏览器
     */
    public boolean endTest() {
        try {
            driver.quit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * 休息间隔，单位毫秒
     *
     * @param i
     * @return
     */
    public boolean sleep(int i) {
        try {
            Thread.sleep(i);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * 根据id等待对应的页面元素出现
     *
     * @param id
     * @return
     */
    public boolean waitForElementById(String id) {
        try {
            driver.findElement(By.id(id));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * 根据css等待对应的页面元素出现
     *
     * @param css
     * @return
     */
    public boolean waitForElementByCss(String css) {
        try {
            driver.findElement(By.cssSelector(css));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * 根据xpath等待对应的页面元素出现
     *
     * @param xpath
     * @return
     */
    public boolean waitForElementByXpath(String xpath) {
        try {
            driver.findElement(By.xpath(xpath));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * 滑動
     */

    public void testActions(By locator) {
        WebElement element = driver.findElement(locator);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();

    }


    /**
     * 操作 下拉框 select
     * 1.需要一个Select的类
     * 2.selectByValue的参数为option中的value属性
     * 3.selectByIndex的参数为option的顺序
     * 4.selectByVisibleText的参数为option的text值
     */
    public void testSelect(String locator, int index) {
        WebElement element = this.findElement("xpath", locator);

        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public void testSelect(String locator, String value) {
        WebElement element = this.findElement("xpath", locator);
        Select select = new Select(element);
        select.selectByValue(value);
        //select.selectByVisibleText(text);
    }

    /**
     * 操作单选按钮radiobox
     * 1.click代表点击选中这个单选框
     * 2.isSelected代表检查这个单选框有没有被选中
     */
    public void testRaidoBox(String locator) {
        WebElement radio = this.findElement("xpath", locator);
        radio.click();
        radio.isSelected();
    }


    /**
     * 操作 复选框checkbox
     * 1.click代表点击选中这个多选框
     * 2.isSelected代表检查这个多选框有没有被选中
     */
    public void testCheckBox(String locator) {
        WebElement checkbox = this.findElement("xpath", locator);
        checkbox.click();
        checkbox.isSelected();
    }

    /**
     * 操作 按钮button
     * 1.click代表点击这个按钮
     * 2.sEnabled代表检查这个按钮是不是可用的
     */
    public void testButton(String locator) {
        WebElement submit = this.findElement("xpath", locator);
        submit.click();
        submit.isEnabled();
    }

    public void testUpload(String locator, String path) {
        WebElement load = this.findElement("xpath", locator);
        load.sendKeys(path);
    }
    /**
     *   智能等待
     */
    public   void intelligentWait(int timeOut, final String by, final String byValue) {
        try {
            (new WebDriverWait(driver, timeOut))
                    .until(new ExpectedCondition<Boolean>() {
                        public Boolean apply(WebDriver driver) {
                            WebElement element =findElement(by, byValue);
                            return element.isDisplayed();
                        }
                    });
        } catch (TimeoutException e) {

            Assert.fail("超时！！" + timeOut + "秒之后还没有找到元素[" + by + "]");
        }
    }

    /**
     *
     *
     */
    public String tableCell(String tablexpath, int row, int column) {
        String text = null;
        WebElement locator;
        try {
            String table = "" + tablexpath + "/tbody/tr[" + row + "]/td[" + column + "]";
            locator = this.findElement("xpath", table);
            text = locator.getText();
        } catch (NoSuchElementException e) {

            System.out.println("无法进入订单详情，列表中暂无相关信息");
            e.printStackTrace();
        }

        return text;

    }

    /**
     * 获取表格的所有元素信息
     *
     * @param by
     */
    public void LocateTableTest(By by) {
        WebElement table = driver.findElement(by);
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        System.out.println(rows.size());
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                System.out.print(col.getText() + "\t");
            }
            System.out.println("");
        }
    }
    //查看图片是否显示
    public static   boolean IsImageVisible(WebDriver driver,WebElement image){
        Boolean imageLoaded1 = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", image);
        if (!imageLoaded1)
        {
            return false;
        }
        return true;
    }


    @Parameters({"browser"})
    public static  WebDriver before(String browser,WebDriver driver) throws IOException {
        String browser_Name=browser;
        if(browser_Name.equalsIgnoreCase("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver",MyWebdriver.ProjectURL+"/browser/chromedriver.exe");
            driver= new ChromeDriver();
        }
        if(browser_Name.equalsIgnoreCase("ie"))
        {
            System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Internet Explorer\\IEDriverServer.exe");
            //设置IE浏览器默认存储位置
            driver = new InternetExplorerDriver();

        }
        if(browser_Name.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver",MyWebdriver.ProjectURL+"/browser/geckodriver.exe");
            driver =new FirefoxDriver();

        }
        driver.manage().window().maximize();
        if (CookieUtil.getCk() != null) {
            driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
            try {
                driver.get(MyWebdriver.baseURL);
            } catch (Exception ignored) {
            }
            driver.manage().deleteAllCookies();
            Cookie ck1 = new Cookie("JSESSIONID", LoginPo.session);
            driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
            driver.manage().addCookie(ck1);
        }

        return  driver;
    }

    public static  void sleep()
    {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    /**
     * 等待元素加载，10s超时
     * @param driver
     * @param by
     */
    public static void waitForLoad(final WebDriver driver, final By by){
        new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                WebElement element = driver.findElement(by);
                if (element != null){
                    return true;
                }
                return false;
            }
        });
    }
}

