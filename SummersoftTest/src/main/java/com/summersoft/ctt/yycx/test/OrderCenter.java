package com.summersoft.ctt.yycx.test;

import com.summersoft.ctt.yycx.po.LoginPo;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import com.summersoft.ctt.yycx.util.CookieUtil;
import com.summersoft.ctt.yycx.util.LogType;
import com.summersoft.ctt.yycx.util.Logger;
import com.summersoft.ctt.yycx.util.MyWebdriver;

import java.io.IOException;
import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

public class OrderCenter {
	public static WebDriver driver;
	public static int len;
	public static MyWebdriver d;

	/**
	 * 专车订单和出租车订单的详情查看
	 * @throws InterruptedException
	 */
	@Test
	public void orderSearch() throws InterruptedException {
		Thread.sleep(3000);
		d.findElementClick("link", "订单处理中心");
		d.findElementClick("link", "专车订单");
		searchDetail();
		if(driver.getPageSource().contains(MyWebdriver.tableMessage))
		{
			Logger.Output(LogType.LogTypeName.WARNING, "专车订单列表暂无订单取消的记录");

		} else {
			// 取列表中第二行第一列的订单号
			String specialId = d.tableCell("//*[@id=\"order_table\"]", 1, 1);
			String[] specialNumId = specialId.split("\n");
			d.findElementClick("xpath", "//*[@id=\"order_table\"]/tbody/tr[1]/td[9]/a");
			Thread.sleep(3000);
			String specialDetailId = d.findElement("xpath", "//*[@id=\"orderInfo\"]/ul/li[1]/div[2]/div[2]/div[2]/span")
					.getText();
			if (specialNumId[1].equals(specialDetailId)) {
				Logger.Output(LogType.LogTypeName.INFO, "专车订单信息详情查看成功，订单号为："+specialDetailId);
			} else {
				Logger.Output(LogType.LogTypeName.ERROR, "专车订单信息详情查看失败，订单号为："+specialDetailId);
			}

		}
	}


	@Test
	/**
	 * 乘客投诉管理详情查看及处理操作
	 * @throws InterruptedException
	 */
	public static void passengerComplaint() throws InterruptedException {
		Thread.sleep(3000);
		d.findElementClick("link", "订单处理中心");
		d.setTimeOut();
		Thread.sleep(3000);
		d.findElementClick("link", "乘客投诉管理");
		Thread.sleep(3000);
		Select status=new Select(d.findElement("name","status"));
		status.selectByVisibleText("待处理");
		d.findElementClick("xpath","//*[@id=\"complainForm\"]/div[10]/a");
		Thread.sleep(3000);
		if(driver.getPageSource().contains(MyWebdriver.tableMessage))
		{
			Logger.Output(LogType.LogTypeName.INFO, "乘客投诉暂无未处理信息的订单");
		}
		else {
			Thread.sleep(3000);
			String orderNo=d.findElement("xpath","//*[@id=\"complain_table\"]/tbody/tr/td[1]").getText();
			d.findElementClick("xpath","//*[@id=\"complain_table\"]/tbody/tr[1]/td[9]/a[1]");
			Thread.sleep(3000);
			Logger.Output(LogType.LogTypeName.INFO, d.findElement("class","bootstrap-dialog-title").getText()+"详情查看成功");
			d.findElementClick("css",".btn-gray");
			Thread.sleep(3000);
			d.findElementClick("xpath","//*[@id=\"complain_table\"]/tbody/tr[1]/td[9]/a[2]");
			Thread.sleep(3000);
			Select deal=new Select(d.findElement("id","status"));
			deal.selectByValue("3");
			Thread.sleep(3000);
			d.findElementSendKeys("id","result","乘客投诉已处理");
			d.findElementClick("css",".btn-determine");
			driver.navigate().refresh();
			Thread.sleep(3000);
			d.findElementSendKeys("name","orderNo",orderNo);
			d.findElementClick("xpath","//*[@id=\"complainForm\"]/div[10]/a");
			Thread.sleep(3000);
			boolean flag=d.findElement("xpath","//*[@id=\"complain_table\"]/tbody/tr/td[6]").getText().contains("已处理");
			if(flag)
			{
				Logger.Output(LogType.LogTypeName.INFO,"乘客投诉处理成功");
			}
			else
			{
				Logger.Output(LogType.LogTypeName.ERROR,"乘客投诉处理失败");

			}

		}


	}

	@Test
	/**
	 * 司机投诉管理详情查看及处理操作
	 * @throws InterruptedException
	 */
	public static void driverComplaint() throws InterruptedException {
		Thread.sleep(3000);
		d.findElementClick("link", "司机投诉管理");
		Thread.sleep(3000);
		Select status=new Select(d.findElement("name","status"));
		status.selectByVisibleText("待处理");
		d.findElementClick("xpath","//*[@id=\"complainForm\"]/div[10]/a");
		Thread.sleep(3000);
		if(driver.getPageSource().contains(MyWebdriver.tableMessage))
		{
			Logger.Output(LogType.LogTypeName.INFO, "司机投诉暂无未处理信息的订单");
		}
		else
		{
			String orderNo=d.findElement("xpath","//*[@id=\"complain_table\"]/tbody/tr/td[1]").getText();
			d.findElementClick("xpath","//*[@id=\"complain_table\"]/tbody/tr[1]/td[9]/a[1]");
			Thread.sleep(3000);
			Logger.Output(LogType.LogTypeName.INFO, d.findElement("class","bootstrap-dialog-title").getText()+"详情查看成功");
			d.findElementClick("css",".btn-gray");
			Thread.sleep(3000);
			d.findElementClick("xpath","//*[@id=\"complain_table\"]/tbody/tr[1]/td[9]/a[2]");
			Thread.sleep(3000);
			Select deal=new Select(d.findElement("id","status"));
			deal.selectByValue("3");
			Thread.sleep(3000);
			d.findElementSendKeys("id","result","司机投诉已处理");
			d.findElementClick("css",".btn-determine");
			driver.navigate().refresh();
			d.findElementSendKeys("name","orderNo",orderNo);
			d.findElementClick("xpath","//*[@id=\"complainForm\"]/div[10]/a");
			Thread.sleep(3000);
			boolean flag=d.findElement("xpath","//*[@id=\"complain_table\"]/tbody/tr/td[6]").getText().contains("已处理");
			if(flag)
			{
				Logger.Output(LogType.LogTypeName.INFO,"司机投诉处理成功");
			}
			else
			{
				Logger.Output(LogType.LogTypeName.ERROR,"司机投诉处理失败");

			}

		}


	}


	@Test
	/**
	 * 报警信息管理处理、订单详情查看、订单信息查询
	 */
	public void warningMessage() throws InterruptedException {
		Thread.sleep(2000);
		d.findElementClick("link", "报警信息管理");
		Select status= new Select(d.findElement("id", "search_status"));
		status.selectByValue("1");
		Thread.sleep(3000);
		d.findElement("css", "#page-wrapper > div > div:nth-child(2) > div:nth-child(1) > form > div:nth-child(4)>a").click();
		Thread.sleep(3000);
		if(driver.getPageSource().contains(MyWebdriver.tableMessage))
		{
			Logger.Output(LogType.LogTypeName.INFO, "报警信息暂无未处理信息的订单");
		}
		else
		{
			d.findElementClick("xpath","//*[@id=\"alarm_table\"]/tbody/tr[1]/td[9]/a[1]");
			Thread.sleep(3000);
			Select detailStatus= new Select(d.findElement("name", "status"));
			detailStatus.selectByValue("2");
			Thread.sleep(3000);
			d.findElementSendKeys("id", "remark", "报警信息已处理完毕");
			d.setTimeOut();
			d.findElementClick("css",".btn-determine");
			Logger.Output(LogType.LogTypeName.INFO,"报警信息处理"+d.findElement("class", "toast-message").getText());

		}
	}


	/**
	 * 专车订单和出租车订单的导出
	 * @throws InterruptedException
	 */
	@Test
	public void export() throws InterruptedException
	{

		Thread.sleep(3000);
		d.findElementClick("link", "订单处理中心");
		Thread.sleep(3000);
		d.findElementClick("link", "专车订单");

		Thread.sleep(3000);
		d.findElementClick("link","导出");
		Thread.sleep(3000);
		if(d.findElement("css",".btn-determine").isDisplayed())
		{
			Thread.sleep(3000);
			d.findElementClick("css",".btn-determine");
			Logger.Output(LogType.LogTypeName.INFO, "专车订单导出正常");
		}
		else {
			Logger.Output(LogType.LogTypeName.ERROR, "专车订单导出未能正常执行");
		}

		Thread.sleep(3000);
		d.findElementClick("link", "出租车订单");

		Thread.sleep(3000);
		d.findElementClick("link","导出");
		Thread.sleep(3000);
		if(d.findElement("css",".btn-determine").isDisplayed())
		{
			Thread.sleep(3000);
			d.findElementClick("css",".btn-determine");
			Logger.Output(LogType.LogTypeName.INFO, "出租车订单导出正常");


		}
		else {
			Logger.Output(LogType.LogTypeName.ERROR, "出租车订单导出未能正常执行");
		}
	}


	public static void searchDetail() throws InterruptedException {
		Thread.sleep(3000);
		d.findElementClear("id", "d5221");
		d.findElementSendKeys("id", "d5221", "2017-01-17");
		Select s=new Select(d.findElement("id","mainStatus"));
		s.selectByValue("5");
		Thread.sleep(2000);
		d.findElementClick("link", "搜索");
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
		driver=MyWebdriver.before(browser,driver);
		d = new MyWebdriver(driver);
		d.openPage(MyWebdriver.baseURL);

	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

}
