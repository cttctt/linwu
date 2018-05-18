package com.summersoft.ctt.yycx.po;

import com.summersoft.ctt.yycx.test.FinancialCenter;
import com.summersoft.ctt.yycx.util.*;
import com.summersoft.ctt.yycx.page.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPo {
	public static WebDriver driver;
	public static String session;
	@Test(invocationCount=1)
	/**
	 * 二维码、微信链接的优惠券添加，invocation表示要执行的次数
	 * @throws Exception
	 */
	@Parameters({"browser"})
	public void userLogin(String browser) throws Exception {
		String  browser_Name=browser;
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
		driver.get(MyWebdriver.baseURL);
		String excelPath = MyWebdriver.ProjectURL+"/excel/LoginCase.xlsx";
		// 读取用例sheet页
		ExcelUtil.setExcelFile(excelPath,"login");
		Login login=PageFactory.initElements(driver, Login.class);
		login.inputUserName(ExcelUtil.getCellAsString(1, 4));
		login.inputUserPassword(ExcelUtil.getCellAsString(2, 4));
		login.inputVeriCode(ExcelUtil.getCellAsString(3, 4));

		login.clickLoginBtn();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String userName=login.getUser();
		boolean isLogin=userName.contains(ExcelUtil.getCellAsString(5, 4));
		if(isLogin)
		{
			Logger.Output(LogType.LogTypeName.INFO, "登录成功");
		} else {
			Logger.Output(LogType.LogTypeName.ERROR, "登录失败");
		}

		for (Cookie ck : driver.manage().getCookies()) {
			CookieUtil.setCk(ck);
			session=ck.getValue();
			System.out.println(session);
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}



	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
