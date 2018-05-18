package com.summersoft.ctt.yycx.test;

import com.summersoft.ctt.yycx.po.LoginPo;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;
import com.summersoft.ctt.yycx.util.CookieUtil;
import com.summersoft.ctt.yycx.util.LogType;
import com.summersoft.ctt.yycx.util.Logger;
import com.summersoft.ctt.yycx.util.MyWebdriver;
import com.summersoft.ctt.yycx.util.RandomValue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;

/**
 * 信息发布中心
 * 1.实现文章管理的新增、查询、编辑、可查看详情
 * 2.实现反馈管理的查询、可处理、可查看详情
 *
 * @author ctt
 */
public class InformationPublicCenter {
	public static WebDriver driver;
	public static MyWebdriver d;
	public static String title = RandomValue.getChineseName();
	public static String summary = "司机端如何记录上班时长";
	public static String content = "司机端点击出车，表示上班，上班后首页记录出车时间，出车时间为上班时长";

	/**
	 * 反馈管理查询
	 *
	 * @param phone
	 * @throws InterruptedException
	 */
	@Test
	@Parameters({"phone"})
	public void feedbackSearch(String phone) throws InterruptedException {
		Thread.sleep(3000);
		d.findElementClick("link", "信息发布中心");
		Thread.sleep(3000);
		d.findElementClick("link", "反馈管理");
		Thread.sleep(3000);
		d.findElementSendKeys("id", "mobile", phone);
		Thread.sleep(3000);
		d.findElementClick("xpath", "//*[@id=\"page-wrapper\"]/div/div[2]/div[1]/form/div[5]/a");

		d.sleep();
		Thread.sleep(5000);
		if (driver.getPageSource().contains(MyWebdriver.tableMessage)) {
			Logger.Output(LogType.LogTypeName.WARNING, "未能查询到与" + phone + "相关的信息");

		} else {
			String resultPhone = d.tableCell("//*[@id=\"feedback_table\"]", 1, 4);
			Logger.Output(LogType.LogTypeName.INFO, resultPhone);
			if (resultPhone.equals(phone)) {
				Logger.Output(LogType.LogTypeName.INFO, "反馈信息查询成功");
			} else {
				Logger.Output(LogType.LogTypeName.ERROR, "反馈信息查询失败");
			}

		}

	}


	/**
	 * 反馈信息的查看及处理操作
	 *
	 * @throws InterruptedException
	 */
	@Test
	public void feedbackDeal() throws InterruptedException {
		Thread.sleep(3000);
		d.findElementClick("link", "反馈管理");
		Thread.sleep(3000);
		Select status = new Select(d.findElement("id", "search_status"));
		status.selectByValue("1");
		Thread.sleep(3000);
		d.findElementClick("css", ".btn.btn-info.waves-effect.waves-light");

		d.sleep();
//		WebElement table = d.findElement("id", "feedback_table");
//		List<WebElement> rows = table.findElements(By.tagName("tr"));
//		int rowsSize = rows.size();

		if (driver.getPageSource().contains(MyWebdriver.tableMessage)) {
			Logger.Output(LogType.LogTypeName.INFO, "司机投诉暂无未处理信息的订单");
		} else {
			d.findElementClick("xpath", "//*[@id=\"feedback_table\"]/tbody/tr[1]/td[7]/a");
			Thread.sleep(3000);
			Select type = new Select(d.findElement("name", "status"));
			type.selectByValue("2");
			d.findElementSendKeys("id", "replyContent", "已处理完毕");
			d.findElementClick("css", ".btn-determine");
			Logger.Output(LogType.LogTypeName.INFO, "反馈信息" + d.findElement("class", "toast-message").getText());
			d.sleep();


		}


	}

	/**
	 * 文章新增
	 *
	 * @throws InterruptedException
	 */
	@Test

	public void articleAdd() throws InterruptedException {


		Thread.sleep(3000);
		d.findElementClick("link", "文章管理");
		Thread.sleep(3000);
		d.findElementClick("xpath", "//*[@id=\"articleSearchFrom\"]/div[6]/a");
		Thread.sleep(3000);
		d.findElementSendKeys("id", "articleTitle", title);
		Thread.sleep(3000);
		d.findElementSendKeys("id", "articleSimpleContent", summary);
		// 进入iframe

		WebElement iframe = d.findElement("id", "ueditor_0");
		driver.switchTo().frame(iframe);

		Thread.sleep(3000);
		d.findElementSendKeys("xpath", "/html/body", content);
		// 跳出iframe
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		d.findElementClick("xpath", "//*[@id=\"editForm\"]/div[9]/div/div[1]/a");
		Thread.sleep(3000);
		d.findElementClick("link", "文章管理");
		Thread.sleep(3000);
		// 查看列表中的文章名称第一条是否是刚才新增的文章
		String text = d.tableCell("//*[@id=\"article_table\"]", 1, 3);

		if (text.equals(title)) {
			Logger.Output(LogType.LogTypeName.INFO, text + "文章新增成功");
			// 新增后进行查看详情页的操作，检测查看是否正常
			d.findElementClick("xpath", "//*[@id=\"article_table\"]/tbody/tr[1]/td[9]/a[1]");
			d.sleep();
			String searchContent = d.findElement("xpath", "/html/body").getText();
			if (searchContent.equals(content)) {
				Logger.Output(LogType.LogTypeName.INFO, "文章内容页查看成功");
			} else {
				Logger.Output(LogType.LogTypeName.ERROR, "文章内容页查看失败");
			}
			driver.navigate().back();
		} else {
			Logger.Output(LogType.LogTypeName.ERROR, text + "文章新增失败");
		}


	}


	/**
	 * 文章管理查询
	 *
	 * @throws InterruptedException
	 */
	@Test

	public void articleSearch() throws InterruptedException {

		Thread.sleep(3000);
		d.findElementClick("link", "文章管理");
		Thread.sleep(3000);
		d.findElementSendKeys("id", "articleTitle", title);
		d.findElementClick("xpath", "//*[@id=\"articleSearchFrom\"]/div[4]/a");
		Thread.sleep(3000);
		boolean result = d.findElement("id", "article_table").isDisplayed();
		if (result) {
			String resultTitle = d.tableCell("//*[@id=\"article_table\"]", 1, 3);
			if (resultTitle.equals(title)) {
				Logger.Output(LogType.LogTypeName.INFO, "文章查询成功");
			} else {
				Logger.Output(LogType.LogTypeName.INFO, "未能查询到与" + title + "相关的信息");
			}
		} else {
			Logger.Output(LogType.LogTypeName.ERROR, "文章查询失败");

		}

	}

	@Test

	public void articleUpdate() throws InterruptedException {

		Thread.sleep(3000);
		d.findElementClick("link", "文章管理");
		Thread.sleep(3000);
		d.findElementClick("xpath", "//*[@id=\"editBtn\"]");
		Thread.sleep(3000);
		d.findElementSendKeys("id", "articleTitle", "Update");
		Thread.sleep(3000);
		d.findElementClick("xpath", "//*[@id=\"editForm\"]/div[9]/div/div[1]/a");
		Thread.sleep(3000);
		d.findElementClick("link", "文章管理");
		Thread.sleep(3000);
		// 查看列表中的文章名称第一条是否是刚才新增的文章
		String text = d.tableCell("//*[@id=\"article_table\"]", 1, 3);

		if (text.equals(title + "Update")) {
			Logger.Output(LogType.LogTypeName.INFO, text + "文章编辑成功");

		} else {
			Logger.Output(LogType.LogTypeName.ERROR, text + "文章编辑失败");
		}

	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		Thread.sleep(3000);
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
