package com.summersoft.ctt.yycx.test;

import java.io.IOException;
import java.util.List;

import java.util.concurrent.TimeUnit;

import com.summersoft.ctt.yycx.po.LoginPo;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.summersoft.ctt.yycx.util.CookieUtil;
import com.summersoft.ctt.yycx.util.LogType;
import com.summersoft.ctt.yycx.util.Logger;
import com.summersoft.ctt.yycx.util.MyWebdriver;
import com.summersoft.ctt.yycx.util.LogType.LogTypeName;

public class PassengerServiceCenter {
	public static WebDriver driver;
	public static MyWebdriver d;
	@Test(invocationCount=2)
/**
 * invocationCount=2,invocationTimeOut=10000分别表示执行次数，不能超过10秒,执行两次分别操作封号及解封两个动作
 * @param mobile
 * @param searchStartDate
 * @param remark
 * @throws InterruptedException
 * @throws IOException
 */
	@Parameters({"mobile","searchStarDate","remark"})
	public void passengerInfomation(String mobile,String searchStartDate,String remark) throws InterruptedException, IOException
	{

		Thread.sleep(3000);
		d.findElementClick("link", "乘客服务中心");
		d.findElementClick("link", "乘客信息管理");
		d.setTimeOut();
		d.findElementClear("id", "start");
		d.findElementSendKeys("id", "start", searchStartDate);
		d.findElementSendKeys("id","passenger_mobile",mobile);
		Thread.sleep(3000);
		d.findElementClick("link", "搜索");
		Thread.sleep(2000);
		if(driver.getPageSource().contains(MyWebdriver.tableMessage))
		{
			Logger.Output(LogType.LogTypeName.INFO,"暂未搜索到与之对应的乘客信息");

		}
		else
		{
			Thread.sleep(3000);
			d.findElementClick("xpath","//*[@id=\"passenger_table\"]/tbody/tr/td[10]/a[1]");
			String passengerPhone= d.findElement("xpath", "//*[@id=\"page-wrapper\"]/div/div[2]/div[1]/div/div[1]/div/div/p").getText();
			if(mobile.equals(passengerPhone))
			{
				Logger.Output(LogType.LogTypeName.INFO,"乘客信息查询及详情查看成功");
			}
			else
			{
				Logger.Output(LogType.LogTypeName.ERROR,"乘客信息查询失败");

			}

		}



		//修改乘客余额
		Thread.sleep(3000);
		d.findElementClick("link", "乘客信息管理");
		d.findElementClear("id", "start");
		d.findElementSendKeys("id", "start", searchStartDate);
		d.findElementSendKeys("id","passenger_mobile",mobile);
		Thread.sleep(3000);
		d.findElementClick("link", "搜索");
		Thread.sleep(3000);
		if(driver.getPageSource().contains(MyWebdriver.tableMessage))
		{
			Logger.Output(LogType.LogTypeName.INFO,"暂未搜索到与之对应的乘客信息");
			d.findElementClick("link", "乘客服务中心");


		}
		else
		{
			Thread.sleep(3000);
			d.findElementClick("xpath","//*[@id=\"passenger_table\"]/tbody/tr/td[10]/a[2]");
			d.findElementSendKeys("id","balance",String.valueOf((int)(Math.random()*900)));
			d.findElementSendKeys("id","remark", remark);
			d.findElementClick("css",".btn-determine");
			Thread.sleep(2000);
			Logger.Output(LogType.LogTypeName.INFO,"余额修改"+d.findElement("class", "toast-message").getText());
			//封号操作
			Thread.sleep(3000);
			d.findElementClick("link", "乘客信息管理");
			d.findElementClear("id", "start");
			d.findElementSendKeys("id", "start", searchStartDate);
			d.findElementSendKeys("id","passenger_mobile",mobile);
			Thread.sleep(2000);
			d.findElementClick("link", "搜索");
			Thread.sleep(3000);
			String type=d.findElement("xpath","//*[@id=\"changeStatus\"]").getText();
			if(type.equals("封号"))
			{
				d.findElementClick("xpath","//*[@id=\"changeStatus\"]");
				Thread.sleep(2000);
				Select fenghao=new Select(d.findElement("id","dialogStatus"));
				fenghao.selectByVisibleText("长期封号");
				d.findElementSendKeys("id","dialogAbortRemark","长期封号的封号测试");
				d.setTimeOut();
				d.findElementClick("css",".btn-determine");
				Thread.sleep(3000);
				String status=d.findElement("xpath","//*[@id=\"changeStatus\"]").getText();
				if(status.equals("解封"))
				{
					Logger.Output(LogTypeName.INFO,"长期封号操作成功");
				}
				else
				{
					Logger.Output(LogTypeName.ERROR,"长期封号操作失败");

				}

			}
			else
			{
				//执行解封操作
				d.findElementClick("xpath","//*[@id=\"changeStatus\"]");
				d.setTimeOut();
				d.findElementClick("css",".btn-determine");
				Thread.sleep(3000);
				String status=d.findElement("xpath","//*[@id=\"changeStatus\"]").getText();
				if(status.equals("封号"))
				{
					Logger.Output(LogTypeName.INFO,"解封操作成功");

				}
				else
				{
					Logger.Output(LogTypeName.ERROR,"解封操作失败");

				}


			}


		}

		driver.navigate().refresh();

	}



	@Test
	@Parameters({ "title","linkUrl"})
	public  void passengerMessage(String title,String linkUrl) throws InterruptedException, IOException {
		Thread.sleep(3000);
		d.findElementClick("link", "乘客消息管理");
		Thread.sleep(3000);
		String titleStr=title+String.valueOf((int)(Math.random()*900));
		d.findElementClick("link","新增");
		Thread.sleep(2000);

		d.findElementSendKeys("id","title",titleStr);
		d.findElementSendKeys("id","linkUrl",linkUrl);
		// 上传活动图片
		WebElement activityImg =d.findElement("id","pic");
		String filePath = "C:\\Users\\Administrator\\Pictures\\约约banner\\底部广告.png";
		activityImg.sendKeys(filePath);
		Thread.sleep(3000);
		d.findElementClick("link", "保存");
		Thread.sleep(3000);
		String tableTitle=d.tableCell("//*[@id=\"passenger_message_table\"]", 1, 3);
		if(tableTitle.equals(titleStr))
		{
			Logger.Output(LogType.LogTypeName.INFO,titleStr+ "乘客消息新增成功");

		}
		else
		{
			Logger.Output(LogType.LogTypeName.ERROR,titleStr+ "乘客消息新增失败");
		}
		Thread.sleep(3000);
		d.findElementClick("xpath", "//*[@id=\"passenger_message_table\"]/tbody/tr[1]/td[6]/a");
		Thread.sleep(3000);
		d.findElementSendKeys("id","title","Update");
		d.findElementClick("link", "保存");
		Thread.sleep(3000);
		String tableTitleUpdate=d.tableCell("//*[@id=\"passenger_message_table\"]", 1, 3);
		String titleUpdate=titleStr+"Update";
		if(tableTitleUpdate.equals(titleUpdate))
		{
			Logger.Output(LogType.LogTypeName.INFO,titleUpdate + "乘客消息编辑成功");

		}
		else
		{
			Logger.Output(LogType.LogTypeName.ERROR,titleUpdate + "乘客消息编辑失败");

		}

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
