package com.summersoft.ctt.yycx.test;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.summersoft.ctt.yycx.po.LoginPo;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;


import com.summersoft.ctt.yycx.util.CookieUtil;
import com.summersoft.ctt.yycx.util.LogType;
import com.summersoft.ctt.yycx.util.Logger;
import com.summersoft.ctt.yycx.util.MyWebdriver;


public class TestAll {
	public static WebDriver driver;
	public static MyWebdriver d;

	public static void screenshot() throws IOException {
		// 定义一个前缀文件夹
		String prefix = "D:\\soft";
		// 截图
		File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// 文件命名
		File file = new File(prefix + File.separator + System.currentTimeMillis() + ".png");
		File tempDir = new File(prefix);
		// 判断根目录文件夹是否存在
		if (!tempDir.exists() || !tempDir.isDirectory()) {
			tempDir.mkdir();
		} else {
			int i = 1;
			while (file.exists()) {
				// 命名重复就后缀加_1
				file = new File(prefix + File.separator + System.currentTimeMillis() + "_" + i + ".png");
			}
		}
		// 输出
		FileUtils.copyFile(screenShotFile, file);

	}

	public void export(String menu) throws InterruptedException {

		Thread.sleep(3000);
		d.findElementClick("link", "导出");
		Thread.sleep(3000);
		if (d.findElement("css", ".btn-determine").isDisplayed()) {
			Thread.sleep(3000);
			d.findElementClick("css", ".btn-determine");
			Logger.Output(LogType.LogTypeName.INFO, menu + "导出正常");
		} else {
			Logger.Output(LogType.LogTypeName.ERROR, menu + "导出失败");
		}
	}

	@Test
	/**
	 * 点击所有的菜单栏目录
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public static void clickMenu() throws InterruptedException, IOException {

		int navLength = driver.findElements(By.cssSelector("#side-menu > li")).size();
		Logger.Output(LogType.LogTypeName.INFO, navLength + "");
		try {
			for (int i = 2; i <= navLength; i++) {

				WebElement item = driver.findElement(By.cssSelector("#side-menu > li:nth-child(" + (i) + ") a"));
				Logger.Output(LogType.LogTypeName.INFO, item.getText());
				item.click();
				Thread.sleep(3000);
				int subNavLength = driver
						.findElements(By.cssSelector("#side-menu > li:nth-child(" + (i) + ") ul li")).size();
				Logger.Output(LogType.LogTypeName.INFO, subNavLength + "");
				for (int j = 0; j < subNavLength; j++) {

					WebElement item2 = driver.findElement(By.cssSelector(
							"#side-menu > li:nth-child(" + (i) + ") ul li:nth-child(" + (j + 1) + ") a"));
					Logger.Output(LogType.LogTypeName.INFO, item2.getText());
					item2.click();
					Thread.sleep(3000);

				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			screenshot();
			e.printStackTrace();
		}

	}

	@Test
	/**
	 * 执行菜单中所有导出
	 */
	public void exportAll() throws InterruptedException {
		Thread.sleep(3000);
		d.findElementClick("link", "营运管理中心");
		Thread.sleep(3000);
		d.findElementClick("link", "司机管理");
		export("司机管理");
		d.findElementClick("link", "车辆管理");
		export("车辆管理");
		d.findElementClick("link", "司机考核");
		export("司机考核");
		Thread.sleep(3000);
		d.findElementClick("link", "乘客服务中心");
		Thread.sleep(3000);
		d.findElementClick("link", "乘客信息管理");
		export("乘客信息管理");


		Thread.sleep(3000);
		d.findElementClick("link", "订单处理中心");
		Thread.sleep(3000);
		d.findElementClick("link", "专车订单");
		export("专车订单");
		Thread.sleep(3000);
		d.findElementClick("link", "出租车订单");
		export("出租车订单");
		Thread.sleep(3000);
		d.findElementClick("link", "乘客投诉管理");
		export("乘客投诉管理");
		Thread.sleep(3000);
		d.findElementClick("link", "司机投诉管理");
		export("司机投诉管理");


		Thread.sleep(3000);
		d.findElementClick("link", "财务结算中心");
		Thread.sleep(3000);
		d.findElementClick("link", "对账单");
		export("对账单");
		Thread.sleep(3000);
		d.findElementClick("link", "营业额");
		export("营业额");
		Thread.sleep(3000);


	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		Thread.sleep(2000);
		Logger.Output(LogType.LogTypeName.INFO, "===============================================");
	}

	@BeforeClass
	@Parameters({"browser"})
	public void beforeClass(String browser) throws IOException {
		driver = MyWebdriver.before(browser, driver);
		d = new MyWebdriver(driver);
		d.openPage(MyWebdriver.baseURL);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
