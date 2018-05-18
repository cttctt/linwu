package com.summersoft.ctt.yycx.po;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import com.summersoft.ctt.yycx.page.CouponMarketing;
import com.summersoft.ctt.yycx.page.Invite;
import com.summersoft.ctt.yycx.page.OneOffPayment;
import com.summersoft.ctt.yycx.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class CouponMarketingPo extends LoginPo {
    public static WebDriver driver;
    public static MyWebdriver d;

    @BeforeClass
    @Parameters({"browser"})
    public void beforeClass(String browser) throws IOException {
        driver=MyWebdriver.before(browser,driver);
        d = new MyWebdriver(driver);
        d.openPage(MyWebdriver.baseURL);

    }

    @Test
    /**
     * App直接注册
     */
    public  void  register() throws InterruptedException

    {
        Thread.sleep(3000);
        d.findElementClick("link", "营销控制中心");
        Thread.sleep(3000);
        d.findElementClick("link", "优惠券营销");
        Thread.sleep(3000);
        d.findElementClick("link", "APP直接注册");
        Thread.sleep(3000);
        Invite pinvite = PageFactory.initElements(driver, Invite.class);
        //点击App直接注册的编辑按钮
        d.findElementClick("xpath","//*[@id=\"registerGiftUnitDiv\"]/div[1]/div[2]/p[3]/a[2]");
        Thread.sleep(3000);
        String remainNum = (int) (Math.random() * 100) + "";
        pinvite.inputRemainNum(remainNum);
        Thread.sleep(3000);

        List<WebElement> list = driver.findElements(By.className("coupon-contrainer-unit"));
        //判断是否有优惠券如果存在则直接提交，不存在再进行提交
        if(list.size()>0)
        {
            pinvite.clickSubmitBtn();

        }
        else
        {
            pinvite.clickAddIcon();
            Thread.sleep(3000);
            //选择第一张优惠券
            pinvite.selectCoupon();
            pinvite.next();
            Thread.sleep(5000);
            pinvite.selectCity("全国");
            Thread.sleep(3000);
            pinvite.inputCount("1");
            pinvite.selectDate("7");
            pinvite.clickSubmitBtn();

        }
        Thread.sleep(3000);
        //查看页面
        d.findElementClick("xpath", "//*[@id=\"registerGiftUnitDiv\"]/div[1]/div[2]/p[3]/a[3]");
        Thread.sleep(3000);
        //点击查看发送规则
        d.findElementClick("xpath", "//*[@id=\"leftContainer\"]/div[2]/div[1]/span/a");
        Thread.sleep(3000);
        if (pinvite.getRemainNum().equals(remainNum)) {
            Logger.Output(LogType.LogTypeName.INFO, "App直接注册辑成功");
        } else {
            Logger.Output(LogType.LogTypeName.INFO, "App直接注册编辑失败");
        }

    }
    @Test
    /**
     * 优惠券营销下的乘客邀请
     */
    public void passengerInvite() throws Exception {
        Thread.sleep(3000);
        d.findElementClick("link", "营销控制中心");
        Thread.sleep(3000);
        d.findElementClick("link", "优惠券营销");
        Thread.sleep(3000);
        d.findElementClick("link", "乘客邀请");
        String excelPath = MyWebdriver.ProjectURL + "/excel/CouponMarketingCase.xlsx";
        // 读取用例sheet页
        ExcelUtil.setExcelFile(excelPath, "passengerInvite");
        Invite pinvite = PageFactory.initElements(driver, Invite.class);
        Thread.sleep(3000);
        //点击乘客邀请下的编辑按钮
        pinvite.clickUpdate();
        Thread.sleep(3000);
        String remainNum = (int) (Math.random() * 100) + "";
        pinvite.inputRemainNum(remainNum);
        pinvite.clickAddIcon();
        Thread.sleep(3000);
        //选择第一张优惠券
        pinvite.selectCoupon();
        Thread.sleep(3000);
        pinvite.next();
//        Thread.sleep(3000);
//        pinvite.selectCity("全国");
        Thread.sleep(3000);
        pinvite.inputCount("1");
        pinvite.selectDate("7");
        pinvite.clickSubmitBtn();
        Thread.sleep(3000);
        //查看页面
        d.findElementClick("xpath", "//*[@id=\"containerDiv\"]/div/div[2]/p[3]/a[3]");
        Thread.sleep(3000);
        //点击查看发送规则
        d.findElementClick("xpath", "//*[@id=\"leftContainer\"]/div[2]/div[1]/span/a");
        Thread.sleep(3000);
        if (pinvite.getRemainNum().equals(remainNum)) {
            Logger.Output(LogType.LogTypeName.INFO, "乘客邀请编辑成功");
        } else {
            Logger.Output(LogType.LogTypeName.INFO, "乘客邀请编辑失败");
        }

    }

    @Test
    /**
     * 优惠券营销下的司机邀请
     */
    public void driverInvite() throws Exception {
        Thread.sleep(3000);
        d.findElementClick("link", "营销控制中心");
        Thread.sleep(3000);
        d.findElementClick("link", "优惠券营销");
        Thread.sleep(3000);
        d.findElementClick("link", "司机邀请");
        Thread.sleep(3000);
        String excelPath = MyWebdriver.ProjectURL + "/excel/CouponMarketingCase.xlsx";
        // 读取用例sheet页
        ExcelUtil.setExcelFile(excelPath, "passengerInvite");
        Invite dinvite = PageFactory.initElements(driver, Invite.class);
        /**
         * 司机邀请tab底下的司机邀请乘客
         */
        d.findElementClick("xpath", "//*[@id=\"driverInviteTab\"]/li[1]/a");
        Thread.sleep(3000);
        //点击乘客邀请下的编辑按钮
        dinvite.clickDriverInvitePassengerUpdateBtn();
        Thread.sleep(3000);
        String remainNum = (int) (Math.random() * 100) + "";
        dinvite.inputDriverCashback("20");
        dinvite.inputRemainNum(remainNum);
        dinvite.clickAddIcon();
        Thread.sleep(3000);
        List<WebElement> list = driver.findElements(By.className("coupon-contrainer-unit"));
        if (list.size() > 0) {
            dinvite.selectCoupon();
            Thread.sleep(3000);
            dinvite.next();
//            Thread.sleep(3000);
//            dinvite.selectCity("全国");
            Thread.sleep(3000);
            dinvite.inputCount("1");
            dinvite.selectDate("7");
            dinvite.clickSubmitBtn();
            Thread.sleep(3000);
            d.findElementClick("xpath", "//*[@id=\"driverInviteGiftContainer\"]/div/div[2]/p[3]/a[3]");
            Thread.sleep(3000);
            d.findElementClick("xpath", "//*[@id=\"leftContainer\"]/div[2]/div[1]/span/a");
            Thread.sleep(3000);
            dinvite.getRemainNum();
            if (dinvite.getRemainNum().contains(remainNum)) {
                Logger.Output(LogType.LogTypeName.INFO, "司机邀请乘客成功");
            } else {
                Logger.Output(LogType.LogTypeName.ERROR, "司机邀请乘客失败");
            }
            Thread.sleep(3000);
            d.findElementClick("link", "营销控制中心");
            Thread.sleep(3000);
            d.findElementClick("link", "优惠券营销");
            Thread.sleep(3000);

        } else {
            Logger.Output(LogType.LogTypeName.INFO, "暂无优惠券");

        }
        /**
         * 司机邀请tab底下的司机邀请司机
         */
        d.findElementClick("link", "司机邀请");
        Thread.sleep(3000);
        d.findElementClick("xpath", "//*[@id=\"driverInviteTab\"]/li[2]/a");
        Thread.sleep(3000);
        dinvite.clickDriverInviteDriverUpdateBtn();
        String cash = (int) (Math.random() * 100) + "";
        dinvite.inputDriverCashback(cash);
        dinvite.clickDriverInviteDriverUpdateBtn();
        Logger.Output(LogType.LogTypeName.INFO, "司机邀请司机");
        d.getMessage();

    }

    @Test(invocationCount = 1)
    /**
     * 二维码、微信链接的优惠券添加，invocation表示要执行的次数
     * @throws Exception
     */
    public void addCoupon() throws Exception {
        Thread.sleep(3000);
        d.findElementClick("link", "营销控制中心");
        Thread.sleep(3000);
        d.findElementClick("link", "优惠券营销");
        Thread.sleep(3000);

        // 点击我二维码微信链接
        d.findElementClick("link", "二维码/微信链接");
        Thread.sleep(5000);
        String excelPath = MyWebdriver.ProjectURL + "/excel/CouponMarketingCase.xlsx";
        String giftName = RandomValue.getChineseName();

        // 读取用例sheet页
        ExcelUtil.setExcelFile(excelPath, "coupon");
        CouponMarketing coupon = PageFactory.initElements(driver, CouponMarketing.class);
        // 点击新增二维码、微信优惠券礼包按钮
        coupon.clickAddCouponButton();
        // 输入礼包名称
        coupon.inputName(giftName);
        // 选择活动时间
        coupon.selectDate(ExcelUtil.getCellAsDate(3, 4), ExcelUtil.getCellAsDate(4, 4));
        // 输入库存量
        coupon.inputRemainNumber(ExcelUtil.getCellAsNumber(5, 4));
        // 选择领取对象
        coupon.selectUserType(Integer.parseInt(ExcelUtil.getCellAsNumber(6, 4)));
        // 选择限领次数
        coupon.selectLimitCount(Integer.parseInt(ExcelUtil.getCellAsNumber(7, 4)));
        // 点击添加优惠券
        coupon.addCoupon();
        Thread.sleep(3000);
        // 选择一张优惠券
        coupon.selectCoupon();
        // 点击下一步按钮
        coupon.next();
        Thread.sleep(3000);
        // 选择使用城市
        coupon.selectCity(ExcelUtil.getCellAsString(11, 4));
        Thread.sleep(3000);
        // 选择有效期
        coupon.selectDate(ExcelUtil.getCellAsNumber(15, 4));
        // 选择上传底图4
        coupon.selectBackgroundImg(ExcelUtil.getCellAsString(12, 4));
        // 选择上传领取按钮图
        coupon.selectBtnImg(ExcelUtil.getCellAsString(13, 4));
        // 输入规则说明
        coupon.inputRule(ExcelUtil.getCellAsString(14, 4));
        // 提交按钮
        coupon.clickSubmitBtn();
        Thread.sleep(3000);
        coupon.inputName(giftName);
        coupon.clickSearchBtn();
        Thread.sleep(3000);
        boolean flag = coupon.getGiftName().contains(giftName);
        if (flag) {
            Logger.Output(LogType.LogTypeName.INFO, "二维码礼包新增成功");
        } else {
            Logger.Output(LogType.LogTypeName.ERROR, "二维码礼包新增失败");
        }

    }

    @Test
    /**
     * 优惠券营销下的一次性发放新增
     */
    public void addOneOffPayment() throws Exception {
        d.findElementClick("link", "一次性发放");
        Thread.sleep(3000);
        String excelPath = MyWebdriver.ProjectURL + "/excel/CouponMarketingCase.xlsx";
        // 读取用例sheet页
        ExcelUtil.setExcelFile(excelPath, "oneoff");
        OneOffPayment oneoff = PageFactory.initElements(driver, OneOffPayment.class);
        String activityName = RandomValue.getChineseName();
        Thread.sleep(3000);
        oneoff.selectCoupon();
        oneoff.next();
        Thread.sleep(3000);
        oneoff.inputActivityName(activityName);
        oneoff.selectSendCity(ExcelUtil.getCellAsString(4, 4));
        oneoff.selectUserCity(ExcelUtil.getCellAsString(5, 4));
        oneoff.inputCount(ExcelUtil.getCellAsNumber(6, 4));
        oneoff.selectDate(ExcelUtil.getCellAsNumber(7, 4));
        oneoff.clickSubmitBtn();
        Thread.sleep(5000);
        oneoff.clickSendHistoryBtn();
        Thread.sleep(3000);
        String actualName = oneoff.getFirstActivityName();
        String expectedName = activityName;
        boolean flag = actualName.equals(expectedName);
        if (flag) {
            Logger.Output(LogType.LogTypeName.INFO, "一次性发送礼包新增成功");
        } else {
            Logger.Output(LogType.LogTypeName.ERROR, "一次性发送礼包新增失败");
        }
        //返回到上一级
        driver.navigate().back();
    }
    @Test
    /**
     * 兑换码/口令新增
     */
    public void  commandAdd() throws Exception {
        Thread.sleep(3000);
        // 点击兑换码口令链接
        d.findElementClick("link", "兑换码/口令");
        Thread.sleep(3000);
        String excelPath = MyWebdriver.ProjectURL + "/excel/CouponMarketingCase.xlsx";
        String giftName = RandomValue.getChineseName();

        // 读取用例sheet页
        ExcelUtil.setExcelFile(excelPath, "coupon");
        CouponMarketing coupon = PageFactory.initElements(driver, CouponMarketing.class);
        // 点击新增按钮
        coupon.clickAddCouponButton();
        // 输入礼包名称
        coupon.inputName(giftName);
        // 选择活动时间
        coupon.selectDate(ExcelUtil.getCellAsDate(3, 4), ExcelUtil.getCellAsDate(4, 4));
        // 输入库存量
        coupon.inputRemainNumber(ExcelUtil.getCellAsNumber(5, 4));
        // 选择限领次数
        coupon.selectLimitCount(Integer.parseInt(ExcelUtil.getCellAsNumber(7, 4)));
        // 点击添加优惠券
        coupon.addCoupon();
        Thread.sleep(3000);
        // 选择一张优惠券
        coupon.selectCoupon();
        // 点击下一步按钮
        coupon.next();
        Thread.sleep(3000);
        // 选择使用城市
        coupon.selectCity(ExcelUtil.getCellAsString(11, 4));
        Thread.sleep(3000);
        // 选择有效期
        coupon.selectDate(ExcelUtil.getCellAsNumber(15, 4));
        // 提交按钮
        coupon.clickSubmitBtn();
        Thread.sleep(3000);
        coupon.inputName(giftName);
        Thread.sleep(3000);
        coupon.clickSearchBtn();
        Thread.sleep(3000);
        boolean flag = coupon.getGiftName().contains(giftName);
        if (flag) {
            Logger.Output(LogType.LogTypeName.INFO, "兑换码/口令新增成功");
        } else {
            Logger.Output(LogType.LogTypeName.ERROR, "兑换码/口令新增失败");
        }

    }



    @AfterClass
    public void afterClass() {


//        driver.quit();
    }

}
