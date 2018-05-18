package com.summersoft.ctt.yycx.test;

import com.summersoft.ctt.yycx.page.Setting;
import com.summersoft.ctt.yycx.po.LoginPo;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.summersoft.ctt.yycx.util.CookieUtil;
import com.summersoft.ctt.yycx.util.LogType;
import com.summersoft.ctt.yycx.util.Logger;
import com.summersoft.ctt.yycx.util.MyWebdriver;
import com.summersoft.ctt.yycx.util.RandomValue;

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

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;

public class SystemSetting {
	//起步价
	public static String price="7";
	//设置城市
	public static String cityName=MyWebdriver.city;
	//派单半径
	public static String radius="12";
	//出租车免费等待时长
	public static String  waitTime="3";
	public static WebDriver driver;
	public static MyWebdriver d;

	public static void vehicle() throws Exception {
		String levelName = RandomValue.getChineseName();
		Thread.sleep(3000);
		d.findElementClick("xpath", "//*[@id=\"btnAddCarLevel\"]/span");
		Thread.sleep(3000);
		// 车型名称
		d.findElementSendKeys("name", "levelName", levelName);
		// 车型图片管理
		d.findElementClick("xpath", "//*[@id=\"addCarTypeForm\"]/div[2]/div[2]/div[1]/div[2]/label");
		d.setTimeOut();
		d.findElementClick("css", ".btn-determine");
		Logger.Output(LogType.LogTypeName.INFO, "车型新增：" + d.findElement("class", "toast-message").getText());
		Thread.sleep(3000);
		// 车型编辑
		d.findElementClick("xpath", "//*[@id=\"carLevel_table\"]/tbody/tr[1]/td[6]/div/a[3]/img");
		Thread.sleep(3000);
		d.findElementClear("xpath", "//*[@id=\"addCarTypeForm\"]/div[1]/div/input");
		d.findElementSendKeys("xpath", "//*[@id=\"addCarTypeForm\"]/div[1]/div/input", "舒适型");
		d.setTimeOut();
		d.findElementClick("css", ".btn-determine");
		Logger.Output(LogType.LogTypeName.INFO, "车型编辑：" + d.findElement("class", "toast-message").getText());
		// 车型删除
		driver.navigate().refresh();
		Thread.sleep(3000);
		d.findElementClick("xpath", "//*[@id=\"carLevel_table\"]/tbody/tr[1]/td[6]/div/a[4]/img");
		Logger.Output(LogType.LogTypeName.INFO, "车型删除：" + d.findElement("class", "toast-message").getText());

	}

	public static void tabsearch() throws InterruptedException {
		List<WebElement> list = driver.findElements(By.cssSelector("#pageHead>li"));
		for (int i = 0; i < list.size(); i++) {
			String tabvalue = list.get(i).getText();
			list.get(i).click();
			Thread.sleep(2000);
			String firstvalue = driver
					.findElement(By.xpath("//*[@id=\"carModelsLevelTableDiv\"]/table/tbody/tr[2]/td[1]")).getText();
			if (firstvalue != "") {
				Logger.Output(LogType.LogTypeName.INFO, tabvalue + "下有检测到具体的车型规则");
			} else {
				Logger.Output(LogType.LogTypeName.ERROR, tabvalue + "下没有检测到具体的车型规则");
			}
			Thread.sleep(2000);
		}

	}

	/**
	 * 业务范围设置(业务的新增和城市新增) carType车辆类型
	 *
	 * @throws InterruptedException
	 */
	@Test
	@Parameters({ "carType", "province", "city" })
	public static void scopeOfBusiness(String carType, String province, String city) throws InterruptedException {

		Thread.sleep(3000);
		d.findElementClick("link", "系统设置中心");
		Thread.sleep(3000);
		d.findElementClick("link", "业务范围管理");
		Logger.Output(LogType.LogTypeName.INFO, "进入业务范围的新增");
		Thread.sleep(5000);
		d.findElementClick("link", "新增业务");
		d.setTimeOut();
		Select type = new Select(d.findElement("id", "business"));
		type.selectByVisibleText(carType);
		Thread.sleep(3000);
		d.findElementClick("css", ".btn-determine");
		String message = d.findElement("class", "toast-message").getText();
		Logger.Output(LogType.LogTypeName.INFO, message);
		if (message.contains("该组织机构的这项业务已经存在")) {
			d.setTimeOut();
			d.findElementClick("class", "close");
			Thread.sleep(3000);
		}
		Thread.sleep(2000);
		// 新增城市
		d.findElementClick("xpath", "//*[@id=\"business_table\"]/tbody/tr[1]/td[3]/a");
		Thread.sleep(2000);
		Select provinceSelect = new Select(d.findElement("name", "province"));
		provinceSelect.selectByVisibleText(province);
		Thread.sleep(2000);
		Select citySelect = new Select(d.findElement("name", "city"));
		citySelect.selectByVisibleText(city);
		Thread.sleep(2000);
		d.findElementClick("css", ".btn-determine");
		Logger.Output(LogType.LogTypeName.INFO, d.findElement("class", "toast-message").getText());
		String rr = d.findElement("class", "toast-message").getText();
		String mm = "快车业务下的" + city + "城市已经开通了";
		if (rr.equals(mm)) {
			d.setTimeOut();
			d.findElementClick("class", "close");
			Thread.sleep(3000);

		}

		d.findElementClick("link", "系统设置中心");
	}


	/**
	 * 系统设置中心专车、快车、出租车计费设置tab切换
	 *
	 * @throws InterruptedException
	 */
	@Test
	public void chuzucheSystemSet() throws InterruptedException {
		Thread.sleep(3000);
		d.findElementClick("link", "系统设置中心");
		Thread.sleep(3000);

		Thread.sleep(3000);
		d.findElementClick("link", "出租车计费设置");
		Setting se =PageFactory.initElements(driver,Setting.class);
		Thread.sleep(3000);
		se.selectCity(cityName);
		se.inputFixedRadius(radius);
		Logger.Output(LogType.LogTypeName.INFO, "进入出租车计费设置");

		//即时用车
		d.findElementClick("link","即时用车");
		Logger.Output(LogType.LogTypeName.INFO, "进入即时用车设置");
		Thread.sleep(3000);
		//即使用车下第一个编辑按钮
		se.clickUpdateBtn();
		Thread.sleep(3000);
		se.inputFreeWaitTime(waitTime);
		se.clickSubmitBtn();
		Thread.sleep(3000);
		if(se.getLabelFirstValue().equals(waitTime))
		{
			Logger.Output(LogType.LogTypeName.INFO, "设置编辑成功");
		}
		else
		{
			Logger.Output(LogType.LogTypeName.ERROR, "设置编辑失败");
		}
		//预约用车
		d.findElementClick("link","预约用车");
		Logger.Output(LogType.LogTypeName.INFO, "进入预约用车设置");
		Thread.sleep(3000);
		//即使用车下第一个编辑按钮
		se.clickUpdateBtn();
		Thread.sleep(3000);
		se.inputFreeWaitTime(waitTime);
		se.clickSubmitBtn();
		Thread.sleep(3000);
		if(se.getLabelFirstValue().equals(waitTime))
		{
			Logger.Output(LogType.LogTypeName.INFO, "设置编辑成功");
		}
		else
		{
			Logger.Output(LogType.LogTypeName.ERROR, "设置编辑失败");
		}

	}
	@Test
	public void kuaicheSystemSet() throws InterruptedException {
		Thread.sleep(3000);
		d.findElementClick("link", "系统设置中心");

		Thread.sleep(3000);
		d.findElementClick("link", "快车计费设置");
		Setting se =PageFactory.initElements(driver,Setting.class);
		Thread.sleep(3000);
		se.selectCity(cityName);
		Thread.sleep(3000);
		se.inputFixedRadius(radius);
		Logger.Output(LogType.LogTypeName.INFO, "进入快车计费设置");

		//即时用车
		d.findElementClick("link","即时用车");
		Logger.Output(LogType.LogTypeName.INFO, "进入即时用车设置");
		Thread.sleep(3000);
		//即使用车下第一个编辑按钮
		se.clickUpdateBtn();
		Thread.sleep(3000);
		se.inputStartFare(price);
		se.clickSubmitBtn();
		Thread.sleep(3000);

		if(se.getLabelFirstValue().equals(price))
		{
			Logger.Output(LogType.LogTypeName.INFO, "设置编辑成功");
		}
		else
		{
			Logger.Output(LogType.LogTypeName.ERROR, "设置编辑失败");
		}
		//预约用车
		d.findElementClick("link","预约用车");
		Logger.Output(LogType.LogTypeName.INFO, "进入预约用车设置");
		Thread.sleep(3000);
		//即使用车下第一个编辑按钮
		se.clickUpdateBtn();
		Thread.sleep(3000);
		se.inputStartFare(price);
		se.clickSubmitBtn();
		Thread.sleep(3000);
		if(se.getLabelFirstValue().equals(price))
		{
			Logger.Output(LogType.LogTypeName.INFO, "设置编辑成功");
		}
		else
		{
			Logger.Output(LogType.LogTypeName.ERROR, "设置编辑失败");
		}

	}
	@Test
	public void zhuancheSystemSet() throws InterruptedException {

		Thread.sleep(3000);
		d.findElementClick("link", "系统设置中心");
		Thread.sleep(3000);

		Thread.sleep(3000);
		d.findElementClick("link", "专车计费设置");
		Setting se =PageFactory.initElements(driver,Setting.class);
		Thread.sleep(3000);
		se.selectCity(cityName);
		se.inputFixedRadius(radius);
		Logger.Output(LogType.LogTypeName.INFO, "进入专车计费设置");

		//即时用车
		d.findElementClick("link","即时用车");
		Logger.Output(LogType.LogTypeName.INFO, "进入即时用车设置");
		Thread.sleep(3000);
		//即使用车下第一个编辑按钮
		se.clickUpdateBtn();
		Thread.sleep(3000);
		se.inputStartFare(price);
		se.clickSubmitBtn();
		Thread.sleep(3000);

		if(se.getLabelFirstValue().equals(price))
		{
			Logger.Output(LogType.LogTypeName.INFO, "设置编辑成功");
		}
		else
		{
			Logger.Output(LogType.LogTypeName.ERROR, "设置编辑失败");
		}
		//预约用车
		d.findElementClick("link","预约用车");
		Logger.Output(LogType.LogTypeName.INFO, "进入预约用车设置");
		Thread.sleep(3000);
		//即使用车下第一个编辑按钮
		se.clickUpdateBtn();
		Thread.sleep(3000);
		se.inputStartFare(price);
		se.clickSubmitBtn();
		Thread.sleep(3000);
		if(se.getLabelFirstValue().equals(price))
		{
			Logger.Output(LogType.LogTypeName.INFO, "设置编辑成功");
		}
		else
		{
			Logger.Output(LogType.LogTypeName.ERROR, "设置编辑失败");
		}
		//日租
		d.findElementClick("link","日租");
		Logger.Output(LogType.LogTypeName.INFO, "进入日租设置");
		Thread.sleep(3000);
		//即使用车下第一个编辑按钮
		se.clickUpdateBtn();
		Thread.sleep(3000);
		se.inputStartFare(price);
		se.clickSubmitBtn();
		Thread.sleep(3000);

		if(se.getLabelFirstValue().equals(price))
		{
			Logger.Output(LogType.LogTypeName.INFO, "设置编辑成功");
		}
		else
		{
			Logger.Output(LogType.LogTypeName.ERROR, "设置编辑失败");
		}
		//半日租
		d.findElementClick("link","半日租");
		Logger.Output(LogType.LogTypeName.INFO, "进入半日租设置");
		Thread.sleep(3000);
		//即使用车下第一个编辑按钮
		se.clickUpdateBtn();
		Thread.sleep(3000);
		se.inputStartFare(price);
		se.clickSubmitBtn();
		Thread.sleep(3000);

		if(se.getLabelFirstValue().equals(price))
		{
			Logger.Output(LogType.LogTypeName.INFO, "设置编辑成功");
		}
		else
		{
			Logger.Output(LogType.LogTypeName.ERROR, "设置编辑失败");
		}
		//接机（因为有的项目不需要暂时先屏蔽）
//		d.findElementClick("link","送机");
//		Logger.Output(LogType.LogTypeName.INFO, "进入送机设置");
//		Thread.sleep(3000);
//		//即使用车下第一个编辑按钮
//	    se.clickUpdateBtn();
//		Thread.sleep(3000);
//		se.inputStartFare(price);
//		se.clickSubmitBtn();
//		Thread.sleep(3000);
//		if(se.getLabelFirstValue().equals(price))
//		{
//			Logger.Output(LogType.LogTypeName.INFO, "设置编辑成功");
//		}
//		else
//		{
//			Logger.Output(LogType.LogTypeName.ERROR, "设置编辑失败");
//		}

	}


	@Test
	/**
	 * 车型管理的新增、编辑、删除等操作
	 *
	 * @throws InterruptedException
	 */
	public void vehicleModelManage() throws Exception {
		// 车型新增
		Thread.sleep(3000);
		d.findElementClick("link", "车型管理");
		Thread.sleep(3000);
//		 List<WebElement> list = driver.findElements(By.cssSelector("#pageHead>li"));
//		 int length=list.size();
//		 for(int i=0;i<list.size();i++)
//		 {
//		 System.out.println(i);
//		 String tabvalue=list.get(i).getText();
//		 Logger.Output(LogType.LogTypeName.INFO, tabvalue + "下的车型管理增删改");
//		 Thread.sleep(3000);
//		 driver.findElement(By.cssSelector("#pageHead > li:nth-child(" + (i + 1) +
//		 ")")).click();
//		 vehicle();
//		 }
		Logger.Output(LogType.LogTypeName.INFO,"车型管理增删改");
		driver.findElement(By.cssSelector("#pageHead > li:nth-child(1)")).click();
		vehicle();
		driver.findElement(By.cssSelector("#pageHead > li:nth-child(2)")).click();
		vehicle();
		driver.findElement(By.cssSelector("#pageHead > li:nth-child(3)")).click();
		vehicle();
		driver.findElement(By.cssSelector("#pageHead > li:nth-child(4)")).click();
		vehicle();
	}


	@Test
	/**
	 * 敏感词管理
	 */
	public void sensitiveWord() throws InterruptedException {

		Thread.sleep(3000);

		d.findElementClick("link", "系统设置中心");

		Thread.sleep(3000);
		d.findElementClick("link", "敏感词管理");
		Thread.sleep(3000);
		d.findElementClick("xpath", "//*[@id=\"page-wrapper\"]/div/div[2]/ul");

		int navLength = driver.findElements(By.cssSelector("#page-wrapper > div > div:nth-child(3) > ul >li")).size();
		System.out.println(navLength+"");
		driver.findElement(By.cssSelector("#page-wrapper > div > div:nth-child(3) > ul > li:nth-child("+navLength+") > div.tag-editor-tag"))
				.sendKeys("222");
		Thread.sleep(3000);
		d.findElementClick("id", "updateSensitiveWords");
		Thread.sleep(3000);
		d.findElementClick("xpath", "/html/body/div[2]/div/table/tbody/tr[3]/td/div[2]/button[2]");
		Logger.Output(LogType.LogTypeName.INFO, d.findElement("class", "toast-message").getText());

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
