package com.summersoft.ctt.yycx.test;

import com.summersoft.ctt.yycx.po.LoginPo;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.summersoft.ctt.yycx.util.CookieUtil;
import com.summersoft.ctt.yycx.util.LogType;
import com.summersoft.ctt.yycx.util.Logger;
import com.summersoft.ctt.yycx.util.MyWebdriver;
import com.summersoft.ctt.yycx.util.RandomValue;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

/**
 * 营销控制中心
 * 1.优惠券模板管理新增、查询
 * 2.优惠券营销tab切换
 * 3.乘客充值管理检测是否有6个策略，及乘客充值策略编辑
 * @author ctt
 *
 */

public class MarketingCenter {
	public static WebDriver driver;
	public static MyWebdriver d;
	public static String title=RandomValue.getChineseName();
	public  static String name=RandomValue.getChineseName();
	public static String putInDateOn="2017-01-01";
	public static String putInDateOff="2019-01-01";


	@Test
	@Parameters({"city"})
	public  void activity(String city) throws InterruptedException

	{
		Thread.sleep(3000);
		d.findElementClick("link", "营销控制中心");
		Thread.sleep(3000);
		d.findElementClick("link","APP活动管理");
		activityAdd(city,"出租车弹屏");
		Thread.sleep(3000);
		//出租车顶部通知
		topAdd(city);
		Thread.sleep(3000);
		d.findElementClick("link","左侧边栏底部");
		activityAdd(city,"左侧边栏底部");
		Thread.sleep(3000);
		d.findElementClick("link","评价标签下面");
		activityAdd(city,"评价标签下面");
		Thread.sleep(3000);
		d.findElementClick("link","启动页");
		activityAdd(city,"启动页");
		Thread.sleep(3000);
	}
	/**
	 * 顶部通知栏
	 */
	@Parameters({"city"})
	public void topAdd(String city) throws InterruptedException {
		d.findElementClick("link","出租车顶部通知");
		Thread.sleep(3000);
		//点击新增按钮
		d.findElementClick("id","addBtn");
		d.findElementSendKeys("name","title",title);
		Select citySel=new Select(d.findElement("id","citySelect"));
		citySel.selectByVisibleText(city);
		d.findElementSendKeys("id","putInDateOn",putInDateOn);
		d.findElementSendKeys("id","putInDateOff",putInDateOff);
		d.findElementClick("xpath","//*[@id=\"submitBtn\"]");
		Thread.sleep(3000);
		d.findElementClear("name","title");
		d.findElementSendKeys("name","title",title);
		d.findElementClick("xpath","//*[@id=\"searchForm\"]/div[5]/a");
		Thread.sleep(3000);
		String titleName=d.findElement("xpath","//*[@id=\"DataTables_Table_1\"]/tbody/tr/td[1]").getText();
		if(titleName.equals(title))
		{
			Logger.Output(LogType.LogTypeName.INFO, "出租车顶部通知新增成功");
			d.findElementClick("xpath","//*[@id=\"DataTables_Table_1\"]/tbody/tr/td[8]/a[2]/img");
			d.findElementSendKeys("name","title","Update");
			d.findElementClick("xpath","//*[@id=\"submitBtn\"]");
			Thread.sleep(3000);
			String updateTitle=title+"Update";
			Thread.sleep(3000);
			d.findElementClear("name","title");
			Thread.sleep(3000);
			d.findElementSendKeys("name","title",updateTitle);
			d.findElementClick("xpath","//*[@id=\"searchForm\"]/div[5]/a");
			Thread.sleep(3000);
			boolean update=d.findElement("xpath","//*[@id=\"DataTables_Table_1\"]/tbody/tr/td[1]").getText().contains(updateTitle);
			if(update)
			{
				Logger.Output(LogType.LogTypeName.INFO, "出租车顶部通知编辑成功");
			}
			else
			{
				Logger.Output(LogType.LogTypeName.ERROR, "出租车顶部通知编辑失败");

			}

		}
		else
		{
			Logger.Output(LogType.LogTypeName.ERROR, "出租车顶部通知新增失败");
		}
	}

	/**
	 * App活动新增查询操作
	 * @throws InterruptedException
	 */
	@Parameters({"city"})
	public void activityAdd (String city,String menu) throws InterruptedException
	{
		Thread.sleep(3000);
		d.findElementClick("link", "新增");
		d.findElementSendKeys("name","title",title);
		Select citySel=new Select(d.findElement("id","citySelect"));
		citySel.selectByVisibleText(city);
		d.findElementSendKeys("id","putInDateOn",putInDateOn);
		d.findElementSendKeys("id","putInDateOff",putInDateOff);
		WebElement imgFile = d.findElement("id", "imgFile");
		String FilePath = "D:\\picture\\activity1.png";
		imgFile.sendKeys(FilePath);
		d.findElementClick("xpath","//*[@id=\"submitBtn\"]");
		Thread.sleep(3000);
		d.findElementClear("name","title");
		d.findElementSendKeys("name","title",title);
		d.findElementClick("xpath","//*[@id=\"searchForm\"]/div[5]/a");
		Thread.sleep(3000);
		boolean titleStr=d.findElement("xpath","//*[@id=\"data_list\"]/div[1]/div[2]/p[1]").getText().contains(title);
		//查看所新增活动的图片是否有显示
		WebElement image = driver.findElement(By.cssSelector("#data_list > div:nth-child(1) > div.col-xs-3.text-left.imgBox > img:nth-child(2)"));
		boolean isVisible =MyWebdriver.IsImageVisible(driver,image);
		if(titleStr&&isVisible)
		{
			Logger.Output(LogType.LogTypeName.INFO, menu+"新增成功");
			d.setTimeOut();
			d.findElementClick("xpath","//*[@id=\"data_list\"]/div/div[4]/a/img");
			d.findElementSendKeys("name","title","Update");
			Thread.sleep(3000);
			d.findElementClick("id","submitBtn");
			Thread.sleep(3000);
			String updateTitle=title+"Update";
			Thread.sleep(3000);
			d.findElementClear("name","title");
			Thread.sleep(3000);
			d.findElementSendKeys("name","title",updateTitle);
			d.findElementClick("xpath","//*[@id=\"searchForm\"]/div[5]/a");
			Thread.sleep(3000);
			boolean update=d.findElement("xpath","//*[@id=\"data_list\"]/div[1]/div[2]/p[1]").getText().contains(updateTitle);
			if(update)
			{
				Logger.Output(LogType.LogTypeName.INFO, menu+"编辑成功");
			}
			else
			{
				Logger.Output(LogType.LogTypeName.ERROR, menu+"编辑失败");

			}

		}
		else
		{
			Logger.Output(LogType.LogTypeName.ERROR, menu+"新增失败");
		}

	}

	@Test
	/**
	 * 优惠券模板管理新增、查询
	 */
	@Parameters({"useCarType", "couponType", "money", "astrict" })
	public void couponTemplateAdd(String useCarType, String couponType, String money, String astrict)
			throws InterruptedException {
		d.findElementClick("link","优惠券模板管理");
		Thread.sleep(3000);
		d.findElementClick("link", "新增");
		Thread.sleep(2000);
		d.findElementSendKeys("name", "name", name);
		Thread.sleep(2000);
		Select carType = new Select(d.findElement("name", "useCarType"));
		carType.selectByValue(useCarType);
		d.setTimeOut();
		Select type = new Select(d.findElement("name", "type"));
		type.selectByValue(couponType);
		d.findElementSendKeys("name", "money", money);
		d.findElementSendKeys("name", "astrict", astrict);
		Thread.sleep(3000);
		d.findElementClick("id", "saveBtn");
		Thread.sleep(3000);
		d.findElementClick("link", "优惠券模板管理");
		Thread.sleep(2000);
		d.findElementSendKeys("id", "name",name);
		d.findElementClick("link", "搜索");
		Thread.sleep(3000);
		String getCouponName = d.tableCell("//*[@id=\"coupon_table\"]", 1, 1);
		if (getCouponName.equals(name)) {
			Logger.Output(LogType.LogTypeName.INFO, "优惠券模板新增成功");
			Thread.sleep(3000);

		} else {
			Logger.Output(LogType.LogTypeName.ERROR, "优惠券模板新增失败");

		}
	}

	@Test(invocationCount=1)
	/**
	 * 优惠券营销的tab切换，判断每个tab页下是否有默认的礼包容器
	 * invocationCount=3,invocationTimeOut=10000分别表示执行次数，不能超过10秒
	 * @throws InterruptedException
	 */
	public void couponTab() throws InterruptedException {
		Thread.sleep(2000);
		Logger.Output(LogType.LogTypeName.INFO, "进入优惠券营销的tab切换");
		d.findElementClick("link", "优惠券营销");
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.cssSelector("#pageHead>li"));
		for (int i = 0; i < list.size(); i++) {
			String tabvalue = list.get(i).getText();
			list.get(i).click();

			boolean verifyResult = driver.findElement(By.cssSelector(".clearfix")).isDisplayed();
			if (verifyResult) {
				Logger.Output(LogType.LogTypeName.INFO, tabvalue + "下有礼包容器");
			} else {
				Logger.Output(LogType.LogTypeName.ERROR, tabvalue + "下没有检测到礼包容器");
			}

		}

	}

	@Test
	@Parameters({"freeMoney"})
	/**
	 * 乘客充值编辑及检测该页面是否有默认的6个优惠策略
	 */
	public void passengerRecharge(String freeMoney) throws InterruptedException {
		Thread.sleep(2000);
		Logger.Output(LogType.LogTypeName.INFO, "准备执行乘客充值编辑及检测该页面是否有默认的6个优惠策略");
		d.findElementClick("link", "乘客充值管理");
		Thread.sleep(2000);
		// 判断乘客充值管理下是否6个充值策略都显示
		List<WebElement> list = driver.findElements(By.cssSelector("#containerDiv>div"));
		if (list.size() == 6) {
			Logger.Output(LogType.LogTypeName.INFO, "乘客充值管理下的6个充值策略都能显示");
		} else {
			Logger.Output(LogType.LogTypeName.ERROR, "乘客充值管理下的6个充值策略并未检测到");
		}
		d.setTimeOut();
		d.findElementClick("xpath","//*[@id=\"showDivBtnrecharge11111\"]/a/span");
		d.findElementClear("id","editGiftValuerecharge11111");
		d.findElementSendKeys("id","editGiftValuerecharge11111", freeMoney);
		d.findElementClick("xpath","//*[@id=\"editDivBtnrecharge11111\"]/a/span");
		Thread.sleep(3000);
		String show=d.findElement("id","showGiftValuerecharge11111").getText();
		String edit="赠送"+freeMoney+"元";
		if(edit.equals(show))
		{
			Logger.Output(LogType.LogTypeName.INFO, "乘客充值编辑成功");
		}
		else
		{
			Logger.Output(LogType.LogTypeName.ERROR, "乘客充值编辑失败");
		}
	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		Thread.sleep(2000);
		Logger.Output(LogType.LogTypeName.INFO, "===============================================");
	}
	@AfterMethod
	public void afterMethod() {
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
