package com.summersoft.ctt.yycx.test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import com.summersoft.ctt.yycx.po.LoginPo;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
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

/**
 * 财务结算中心
 * 1.提现审核
 * @author ctt
 *
 */
public class FinancialCenter extends  LoginPo{
	public static WebDriver driver;
	public static MyWebdriver d;


	/**
	 * 对账单详情查看比对余额
	 * @throws InterruptedException
	 */
	@Test
	public void statementOfAccount() throws InterruptedException
	{
		Thread.sleep(3000);
		d.findElementClick("link", "财务结算中心");
		Thread.sleep(3000);
		d.findElementClick("link","对账单");
		Thread.sleep(3000);
		d.findElementClick("xpath","//*[@id=\"platform\"]/div[5]/a");
		Thread.sleep(3000);
		d.findElementClick("xpath","//*[@id=\"platform\"]/div[7]/a");
		Thread.sleep(3000);

		if(driver.getPageSource().contains(MyWebdriver.tableMessage))
		{
			Logger.Output(LogType.LogTypeName.WARNING,"对账单暂无记录");
			d.findElementClick("link", "财务结算中心");
		}
		else {


			String balance=d.findElement("xpath","//*[@id=\"platform_table\"]/tbody/tr[1]/td[7]").getText();
			Thread.sleep(3000);
			d.findElementClick("xpath","//*[@id=\"platform_table\"]/tbody/tr[1]/td[8]/a");
			Thread.sleep(3000);
			String detailBalance=d.findElement("xpath","//*[@id=\"detail_table\"]/tbody/tr[1]/td[8]").getText();
			Thread.sleep(3000);
			if(balance.equals(detailBalance))
			{
				Logger.Output(LogType.LogTypeName.INFO,"对账单详情余额显示正确");

			}
			else
			{
				Logger.Output(LogType.LogTypeName.ERROR,"对账单详情余额显示有误");
			}

		}

		//营业额详情查看
		Thread.sleep(3000);
		d.findElementClick("link", "财务结算中心");
		Thread.sleep(3000);
		d.findElementClick("link","营业额");
		Thread.sleep(3000);
		if(driver.getPageSource().contains(MyWebdriver.tableMessage))
		{
			Logger.Output(LogType.LogTypeName.WARNING,"营业额暂无相关记录");
			d.findElementClick("link", "财务结算中心");

		}
		else
		{
			String area=d.findElement("xpath","//*[@id=\"turnover_table\"]/tbody/tr[1]/td[3]").getText();
			Thread.sleep(3000);
			d.findElementClick("xpath","//*[@id=\"turnover_table\"]/tbody/tr[1]/td[8]/a");
			Thread.sleep(3000);
			boolean detail= d.findElement("xpath","//*[@id=\"page-wrapper\"]/div/div[2]").getText().contains(area);
			if(detail)
			{
				Logger.Output(LogType.LogTypeName.INFO,"营业额详情查看成功");

			}
			else
			{
				Logger.Output(LogType.LogTypeName.ERROR,"营业额详情查看失败");
			}
		}

	}



	/**
	 * 发票管理
	 * @param
	 */
	@Test
	@Parameters({"mobile"})
	public void invoiceManage(String mobile) throws InterruptedException {
		Thread.sleep(3000);
		d.findElementClick("link", "财务结算中心");
		Thread.sleep(3000);
		d.findElementClick("link","发票管理");
		Thread.sleep(3000);
		d.findElementSendKeys("id","waitForBilling_mobile",mobile);
		d.setTimeOut();
		d.findElementClick("xpath","//*[@id=\"waitForBillingTab\"]/form/div[3]/a");
		Thread.sleep(3000);
		if(driver.getPageSource().contains(MyWebdriver.tableMessage))
		{
			Logger.Output(LogType.LogTypeName.WARNING,"暂无待开票记录");
			d.findElementClick("link", "财务结算中心");
		}
		else
		{
			d.findElementClick("xpath","//*[@id=\"waitForBilling_table\"]/tbody/tr/td[6]/a[1]");
			Thread.sleep(3000);
			boolean flag=d.findElement("xpath","//*[@id=\"page-wrapper\"]/div/div[2]/div[1]/div[1]/div/div/div[1]").getText().contains(mobile);
			if(flag)
			{
				Logger.Output(LogType.LogTypeName.INFO,"发票详情查看成功");
				//开票操作
				driver.navigate().back();
				Thread.sleep(3000);
				d.findElementClick("xpath","//*[@id=\"waitForBillingTab\"]/form/div[3]/a");
				Thread.sleep(3000);
				d.findElementClick("xpath","//*[@id=\"billingBtn\"]");
				Thread.sleep(3000);
				d.findElementSendKeys("id","invoiceNo",MyWebdriver.RANDOM);
				d.findElementClick("css",".btn-determine");
				Logger.Output(LogType.LogTypeName.INFO,d.findElement("class", "toast-message").getText());
				//待寄出及详情
				Thread.sleep(3000);
				d.findElementClick("xpath","//*[@id=\"page-wrapper\"]/div/div[2]/div/ul/li[2]/a");

				d.findElementSendKeys("id","waitForSend_plateNum",mobile);
				d.findElementClick("xpath","//*[@id=\"waitForSendTab\"]/form/div[4]/a");
				Thread.sleep(3000);
				d.findElementClick("xpath","//*[@id=\"waitForSend_table\"]/tbody/tr/td[10]/a[1]");
				boolean daiji=d.findElement("xpath","//*[@id=\"page-wrapper\"]/div/div[2]/div[1]/div[1]/div/div/div[1]").getText().contains(mobile);
				if(daiji)
				{
					Logger.Output(LogType.LogTypeName.INFO,"待寄出详情查看成功");
					//寄出操作
					driver.navigate().back();
					Thread.sleep(3000);
					d.findElementClick("xpath","//*[@id=\"page-wrapper\"]/div/div[2]/div/ul/li[2]/a");
					Thread.sleep(3000);
					d.findElementClear("id","waitForSend_plateNum");
					d.findElementSendKeys("id","waitForSend_plateNum",mobile);
					d.findElementClick("xpath","//*[@id=\"waitForSendTab\"]/form/div[4]/a");
					Thread.sleep(3000);
					d.findElementClick("xpath","//*[@id=\"sendBtn\"]");
					Thread.sleep(3000);
					Select express=new Select(d.findElement("name","logisticsCompany"));
					express.selectByVisibleText("申通");
					d.findElementSendKeys("id","logisticsOrderNo",MyWebdriver.RANDOM);
					d.findElementClick("css",".btn-determine");
					Logger.Output(LogType.LogTypeName.INFO,d.findElement("class", "toast-message").getText());
					Thread.sleep(3000);
					//已寄出详情
					d.findElementClick("xpath","//*[@id=\"page-wrapper\"]/div/div[2]/div/ul/li[3]/a");
					d.findElementSendKeys("id","send_mobile",mobile);
					d.findElementClick("xpath","//*[@id=\"sendTab\"]/form/div[6]/a");
					Thread.sleep(3000);
					d.findElementClick("xpath","//*[@id=\"send_table\"]/tbody/tr[1]/td[8]/a[1]");
					Thread.sleep(3000);
					boolean jichu=d.findElement("xpath","//*[@id=\"page-wrapper\"]/div/div[2]/div[1]/div[1]/div/div/div[1]").getText().contains(mobile);
					if(jichu)
					{
						Logger.Output(LogType.LogTypeName.INFO,"已寄出详情查看成功");
						//作废操作
						driver.navigate().back();
						Thread.sleep(3000);
						d.findElementClick("xpath","//*[@id=\"page-wrapper\"]/div/div[2]/div/ul/li[3]/a");
						d.findElementSendKeys("id","send_mobile",mobile);
						d.findElementClick("xpath","//*[@id=\"sendTab\"]/form/div[6]/a");
						Thread.sleep(3000);
						d.findElementClick("xpath","//*[@id=\"invalidBth\"]");
						Thread.sleep(3000);
						d.findElementSendKeys("name","remark","申请作废");
						d.findElementClick("css",".btn-determine");
						Logger.Output(LogType.LogTypeName.INFO,d.findElement("class", "toast-message").getText());
						//已作废查询
						Thread.sleep(3000);
						d.findElementClick("xpath","//*[@id=\"page-wrapper\"]/div/div[2]/div/ul/li[5]/a");
						d.setTimeOut();
						d.findElementSendKeys("id","invalid_mobile",mobile);
						Thread.sleep(3000);
						d.findElementClick("xpath","//*[@id=\"invalidTab\"]/form/div[6]/a");
						Thread.sleep(3000);
						d.findElementClick("xpath","//*[@id=\"invalid_table\"]/tbody/tr[1]/td[10]/a");
						Thread.sleep(3000);
						boolean zuofei=d.findElement("xpath","//*[@id=\"page-wrapper\"]/div/div[2]/div[1]/div[1]/div/div/div[1]").getText().contains(mobile);
						if(zuofei)
						{
							Thread.sleep(3000);
							Logger.Output(LogType.LogTypeName.INFO,"作废详情查看成功");


						}
						else
						{
							Logger.Output(LogType.LogTypeName.ERROR,"作废详情查看失败");

						}
					}
					else
					{
						Logger.Output(LogType.LogTypeName.ERROR,"已寄出详情查看失败");
					}

				}
				else
				{
					Logger.Output(LogType.LogTypeName.ERROR,"待寄出详情查看失败");
				}

			}
			else
			{
				Logger.Output(LogType.LogTypeName.ERROR,"发票详情查看失败");

			}

		}

	}


	/**
	 * 提现审核通过
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void audit() throws InterruptedException, IOException {
		Thread.sleep(3000);
		d.findElementClick("link", "财务结算中心");
		Thread.sleep(3000);
		d.findElementClick("link","提现审核");
		Thread.sleep(3000);
		Select  status=new Select(d.findElement("name","driver_cash_status"));
		status.selectByValue("1");
		d.findElementClick("xpath","//*[@id=\"order_pool_select\"]");
		Thread.sleep(3000);

		if(driver.getPageSource().contains(MyWebdriver.tableMessage))
		{
			Logger.Output(LogType.LogTypeName.WARNING,"暂无待开票的提现记录");

		}
		else
		{
			Thread.sleep(3000);
			d.findElementClick("xpath","//*[@id=\"getDetail\"]");

			Select audit=new Select(d.findElement("name","status"));
			audit.selectByValue("2");
			d.findElementSendKeys("name","serialNum",MyWebdriver.RANDOM);
			d.setTimeOut();
			d.findElementClick("xpath","//*[@id=\"driverCashForm\"]/div[13]/div/button/span");
			Logger.Output(LogType.LogTypeName.INFO,"提现审核通过"+d.findElement("class", "toast-message").getText());
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
