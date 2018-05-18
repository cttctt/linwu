package com.summersoft.ctt.yycx.test;

import com.summersoft.ctt.yycx.page.PlatformInformation;
import com.summersoft.ctt.yycx.po.LoginPo;
import com.summersoft.ctt.yycx.util.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.summersoft.ctt.yycx.util.LogType.LogTypeName;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

import org.testng.annotations.Parameters;

public class OperationManage {
    public static WebDriver driver;
    public static MyWebdriver d;
    public static String responsibleName = RandomValue.getChineseName();
    public static String responsibleMobile = RandomValue.getTel();
    public static String ownerName = RandomValue.getChineseName();
    public static String ownerNameMobile = RandomValue.getTel();
    public static String plateNum = RandomValue.getCarNo();
    public static String name = RandomValue.getChineseName();

    @Test
    public void addPlatformInfo() throws Exception {
        Thread.sleep(3000);
        d.findElementClick("link", "平台信息管理");
        Thread.sleep(3000);
        String excelPath = MyWebdriver.ProjectURL + "/excel/PlatformInformationCase.xlsx";
        // 读取用例sheet页
        ExcelUtil.setExcelFile(excelPath, "platform");
        PlatformInformation platform = PageFactory.initElements(driver, PlatformInformation.class);
        Thread.sleep(3000);
        platform.clickEditBtn(0);
        Thread.sleep(3000);
        String randomValue = RandomValue.getChineseName();
        //输入公司标识，随机生成一个值
        platform.inputCompanyId(randomValue);
        // 输入公司名称
        platform.inputCompanyName(ExcelUtil.getCellAsString(2, 4));
        // 输入联系电话
        platform.inputPhone(ExcelUtil.getCellAsString(3, 4));
        // 输入统一信用代码
        platform.inputIdentity(ExcelUtil.getCellAsString(4, 4));
        // 选择省
        platform.selectProvince(ExcelUtil.getCellAsString(5, 4));
        //选择市
        platform.selectCity(ExcelUtil.getCellAsString(6, 4));
        //输入通讯地址
        platform.inputContactAddress(ExcelUtil.getCellAsString(7, 4));
        // 输入经营范围
        platform.inputScope(ExcelUtil.getCellAsString(8, 4));
        // 输入营业户经济类型
        platform.inputType(ExcelUtil.getCellAsString(9, 4));
        // 输入注册资金
        platform.inputTotal(ExcelUtil.getCellAsString(10, 4));
        // 输入法人代表
        platform.inputLegalName(ExcelUtil.getCellAsString(11, 4));
        // 输入法人电话
        platform.inputLegalPhone(ExcelUtil.getCellAsString(12, 4));
        // 输入法人身份证
        platform.inputLegalId(ExcelUtil.getCellAsString(13, 4));
        // 上传法人身份证件扫描
        platform.uploadFile(ExcelUtil.getCellAsString(14, 4));
        // 输入平台联系人姓名
        platform.inputContact(ExcelUtil.getCellAsString(15, 4));
        // 输入平台联系人电话
        platform.inputContactWay(ExcelUtil.getCellAsString(16, 4));
        // 点击保存
        platform.clickSaveBtn(0);
        Thread.sleep(3000);
        d.findElementClick("link", "平台信息管理");
        Thread.sleep(3000);
        if (platform.getCompanyId().equals(randomValue)) {
            Logger.Output(LogType.LogTypeName.INFO, "基本信息保存成功");
        } else {
            Logger.Output(LogType.LogTypeName.ERROR, "基本信息保存失败");
        }
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        Thread.sleep(3000);
        d.findElementClick("link", "投资人信息");
        Thread.sleep(3000);
        platform.clickEditBtn(1);
        Thread.sleep(3000);
        platform.inputInvestorName(randomValue);
        platform.selectInvildType();
        platform.inputInvildCode(ExcelUtil.getCellAsString(18, 4));
        platform.inputMoney(ExcelUtil.getCellAsString(19, 4));
        platform.clickSaveBtn(1);
        Thread.sleep(3000);
        d.findElementClick("link", "投资人信息");
        Thread.sleep(3000);
        if (platform.getInvestorName().equals(randomValue)) {
            Logger.Output(LogType.LogTypeName.INFO, "投资人信息保存成功");
        } else {
            Logger.Output(LogType.LogTypeName.ERROR, "投资人信息保存失败");
        }
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        Thread.sleep(3000);
        d.findElementClick("link", "支付信息");
        Thread.sleep(3000);
        platform.clickEditBtn(2);
        Thread.sleep(3000);
        platform.inputPayName(randomValue);
        platform.inputPayId(ExcelUtil.getCellAsString(20, 4));
        platform.inputPayType(ExcelUtil.getCellAsString(21, 4));
        platform.inputPayScope(ExcelUtil.getCellAsString(22, 4));
        platform.inputPrepareBank(ExcelUtil.getCellAsString(23, 4));
        platform.inputcountDate(ExcelUtil.getCellAsString(24, 4));
        platform.clickSaveBtn(2);
        Thread.sleep(3000);
        d.findElementClick("link", "支付信息");
        Thread.sleep(3000);
        if (platform.getPayName().equals(randomValue)) {
            Logger.Output(LogType.LogTypeName.INFO, "支付信息保存成功");
        } else {
            Logger.Output(LogType.LogTypeName.ERROR, "支付信息保存失败");
        }
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        Thread.sleep(3000);
        d.findElementClick("link", "服务机构信息");
        Thread.sleep(3000);
        platform.clickEditBtn(3);
        Thread.sleep(3000);
        platform.inputServiceName(randomValue);
        platform.inputServiceId(ExcelUtil.getCellAsString(25, 4));
        Thread.sleep(3000);
        platform.inputDetailAddress(ExcelUtil.getCellAsString(28, 4));
        platform.inputResponsibleName(ExcelUtil.getCellAsString(29, 4));
        platform.inputResponsiblePhone(ExcelUtil.getCellAsString(30, 4));
        platform.inputManagerName(ExcelUtil.getCellAsString(31, 4));
        platform.inputManagerPhone(ExcelUtil.getCellAsString(32, 4));
        platform.inputMailAddress(ExcelUtil.getCellAsString(33, 4));
        platform.clickSaveBtn(3);
        Thread.sleep(3000);
        d.findElementClick("link", "服务机构信息");
        Thread.sleep(3000);
        if (platform.getServiceName().equals(randomValue)) {
            Logger.Output(LogType.LogTypeName.INFO, "服务机构信息保存成功");
        } else {
            Logger.Output(LogType.LogTypeName.ERROR, "服务机构信息保存失败");
        }
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        Thread.sleep(3000);
        d.findElementClick("link", "经营许可信息");
        Thread.sleep(3000);
        platform.clickEditBtn(4);
        Thread.sleep(3000);
        platform.inputCertificate(randomValue);
        platform.inputOperationArea(ExcelUtil.getCellAsString(35,4));
        platform.inputOwnerName(ExcelUtil.getCellAsString(36,4));
        platform.inputOrganization(ExcelUtil.getCellAsString(37,4));
        platform.clickSaveBtn(4);
        Thread.sleep(3000);
        d.findElementClick("link", "经营许可信息");
        Thread.sleep(3000);
        if (platform.getCertificate().equals(randomValue)) {
            Logger.Output(LogType.LogTypeName.INFO, "经营许可信息保存成功");
        } else {
            Logger.Output(LogType.LogTypeName.ERROR, "经营许可信息保存失败");
        }

    }


    @Test
    @Parameters({"agent", "responsibleIdCard", "carType", "city"})
    public void regionalManager(String agent, String responsibleIdCard, String carType, String city)
            throws InterruptedException {
        Thread.sleep(3000);
        d.findElementClick("link", "营运管理中心");
        Thread.sleep(3000);
        d.findElementClick("link", "区域代理管理");
        Thread.sleep(3000);
        d.findElementClick("id", "agent-add");
        d.setTimeOut();
        d.findElementSendKeys("id", "add-name", agent);
        d.findElementSendKeys("name", "responsibleName", responsibleName);
        d.findElementSendKeys("name", "responsibleMobile", responsibleMobile);
        d.findElementSendKeys("name", "responsibleIdCard", responsibleIdCard);
        d.findElementClick("css", ".btn-determine");
        Logger.Output(LogType.LogTypeName.INFO, d.findElement("class", "toast-message").getText());
        String errorMessage = "保存失败，错误信息：账户名：" + agent + "已经被注册了";
        String message = d.findElement("class", "toast-message").getText();
        if (errorMessage.equals(message)) {
            d.setTimeOut();
            d.findElementClick("class", "close");
            Thread.sleep(3000);
            d.findElementClick("link", "营运管理中心");
        } else {
            Thread.sleep(2000);
            String agentStr = d.findElement("xpath", "//*[@id=\"regional_agent_table\"]/tbody/tr[1]/td[2]").getText();
            if (agentStr.equals(agent)) {
                Logger.Output(LogType.LogTypeName.INFO, "区域代理新增成功");
                Thread.sleep(2000);
                d.findElementClick("xpath", "//*[@id=\"regional_agent_table\"]/tbody/tr[1]/td[9]/a[2]");
                if (d.findElement("id", "responsible_mobile").getText().contains(responsibleMobile)) {
                    Logger.Output(LogType.LogTypeName.INFO, "区域代理详情页面查看成功");
                    Thread.sleep(3000);
                    d.findElementClick("xpath", "//*[@id=\"page-wrapper\"]/div/div[2]/div[2]/div/h3/a/strong");
                    Thread.sleep(3000);
                    Select region = new Select(d.findElement("id", "businessUuid"));
                    region.selectByVisibleText(carType);
                    Thread.sleep(3000);
                    d.findElementClick("css", ".btn-determine");
                    Thread.sleep(3000);
                    boolean flag = d.findElement("xpath", "//*[@id=\"page-wrapper\"]/div/div[2]/div[2]/div/h5[1]")
                            .getText().contains(carType);
                    if (flag) {
                        Logger.Output(LogType.LogTypeName.INFO, "区域代理下业务新增成功");
                        d.findElementClick("xpath", "//*[@id=\"add-resource-btn\"]");
                        Thread.sleep(3000);
                        Select citySel = new Select(d.findElement("id", "edit-resources"));
                        citySel.selectByVisibleText(city);
                        Thread.sleep(3000);
                        d.findElementClick("css", ".btn-determine");
                        Thread.sleep(2000);
                        boolean cityFlag = d
                                .findElement("xpath",
                                        "//*[@id=\"page-wrapper\"]/div/div[2]/div[2]/div/span/span[1]/span/ul")
                                .getText().contains(city);
                        if (cityFlag) {
                            Logger.Output(LogType.LogTypeName.INFO, "区域代理下业务下的城市新增成功");

                        } else {
                            Logger.Output(LogType.LogTypeName.ERROR, "区域代理下业务下的城市新增失败");

                        }

                    } else {
                        Logger.Output(LogType.LogTypeName.ERROR, "区域代理下业务新增失败");

                    }

                } else {

                    Logger.Output(LogType.LogTypeName.ERROR, "区域代理详情页面查看失败");
                }

            } else {
                Logger.Output(LogType.LogTypeName.ERROR, "区域代理新增失败");
            }

        }

    }

    @Test
    @Parameters({"shortName", "phone", "agent", "city", "carType"})
    /**
     * 企业管理新增及详情查询操作
     *
     * @param fullName
     * @param shortName
     * @param responsibleName
     * @param responsibleMobile
     * @param phone
     * @param
     * @throws InterruptedException
     */
    public static void businessManager(String shortName, String phone, String agent, String city, String carType)
            throws InterruptedException {
        Thread.sleep(3000);
        d.findElementClick("link", "企业管理");
        Thread.sleep(3000);
        d.findElementClick("id", "company_add");
        Thread.sleep(3000);
        // 全称和简称设置为相同
        d.findElementSendKeys("name", "fullName", shortName);
        d.setTimeOut();
        d.findElementSendKeys("name", "shortName", shortName);
        d.setTimeOut();
        d.findElementSendKeys("name", "responsibleName", responsibleName);
        d.setTimeOut();
        d.findElementSendKeys("name", "responsibleMobile", responsibleMobile);
        d.setTimeOut();
        d.findElementSendKeys("name", "phone", phone);
        d.setTimeOut();
        Select type = new Select(d.findElement("name", "regionalAgentUuid"));
        type.selectByVisibleText(agent);
        d.setTimeOut();
        d.findElementClick("css", ".btn-determine");
        Logger.Output(LogType.LogTypeName.INFO, d.findElement("class", "toast-message").getText());
        String errorMessage = "保存失败，错误信息：公司简称：" + shortName + "已经被注册了";
        String message = d.findElement("class", "toast-message").getText();
        if (errorMessage.equals(message)) {
            d.setTimeOut();
            d.findElementClick("class", "close");
            Thread.sleep(3000);
            d.findElementClick("link", "营运管理中心");
        } else {
            Thread.sleep(2000);
            d.findElementClick("css", ".details-btn");
            Thread.sleep(2000);
            String fullStr = d.findElement("id", "company_full_name").getText();
            if (fullStr.equals(shortName)) {
                Logger.Output(LogType.LogTypeName.INFO, "企业新增成功，查询详情也正常");
                // 新增企业下的营业业务
                Thread.sleep(2000);
                d.findElementClick("xpath", "//*[@id=\"page-wrapper\"]/div/div[2]/div[2]/div/h3/a/strong");
                Select region = new Select(d.findElement("id", "businessUuid"));
                region.selectByVisibleText(carType);
                Thread.sleep(2000);
                d.findElementClick("css", ".btn-determine");
                Thread.sleep(2000);

                boolean carFlag = d.findElement("xpath", "//*[@id=\"page-wrapper\"]/div/div[2]/div[2]/div/h5[1]")
                        .getText().contains(carType);
                if (carFlag) {
                    Logger.Output(LogType.LogTypeName.INFO, "企业下的营业业务新增成功");
                    // 编辑企业营业业务下的城市
                    d.findElementClick("xpath", "//*[@id=\"add-resource-btn\"]");
                    Thread.sleep(2000);
                    Select citySel = new Select(d.findElement("id", "edit-resources"));
                    citySel.selectByVisibleText(city);
                    Thread.sleep(2000);
                    d.findElementClick("css", ".btn-determine");
                    Thread.sleep(2000);
                    boolean cityFlag = d
                            .findElement("xpath",
                                    "//*[@id=\"page-wrapper\"]/div/div[2]/div[2]/div/span/span[1]/span/ul")
                            .getText().contains(city);
                    if (cityFlag) {
                        Logger.Output(LogType.LogTypeName.INFO, "企业下的城市新增成功");

                    } else {
                        Logger.Output(LogType.LogTypeName.ERROR, "企业下的城市新增失败");

                    }

                } else {
                    Logger.Output(LogType.LogTypeName.ERROR, "企业下的营业业务新增失败");
                }

            } else {
                Logger.Output(LogType.LogTypeName.ERROR, "企业新增失败");

            }
        }

    }

    @Parameters({"agent", "shortName"})
    // 车辆新增方法
    public static void vehicle(String agent, String shortName) throws InterruptedException, IOException {
        Thread.sleep(2000);
        d.findElementSendKeys("id", "plateNum", plateNum);
        d.findElementSendKeys("name", "model", "德国");
        d.findElementSendKeys("name", "brand", "奔驰");
        d.findElementSendKeys("name", "carColor", "白色");
        Select plateColor = new Select(d.findElement("name", "plateColor"));
        plateColor.selectByVisibleText("黑色");
        Thread.sleep(2000);
        d.findElementSendKeys("name", "seats", "4");

        // 上传车辆照片
        WebElement carImageFile = d.findElement("id", "carImageFile");
        String carFilePath = "D:\\picture\\car\\cheliang.jpg";
        carImageFile.sendKeys(carFilePath);

        // 上传车牌照片
        WebElement plateImageFile = d.findElement("id", "plateImageFile");
        String plateFilePath = "D:\\picture\\car\\chepai.jpg";
        plateImageFile.sendKeys(plateFilePath);
        d.findElementClick("xpath", "//*[@id=\"carForm\"]/div/div/div[1]/div[3]/input");
        Thread.sleep(3000);

        // 新增所属信息
        d.findElementClick("xpath", "//*[@id=\"page-wrapper\"]/div/div[2]/div[3]/a");
        d.setTimeOut();
        d.findElementSendKeys("name", "ownerName", ownerName);
        d.findElementSendKeys("name", "ownerNameMobile", ownerNameMobile);
        Select agentUuid = new Select(d.findElement("name", "agentUuid"));
        agentUuid.selectByVisibleText(agent);
        Thread.sleep(2000);
        Select companyUuid = new Select(d.findElement("name", "companyUuid"));
        companyUuid.selectByVisibleText(shortName);
        d.findElementClick("xpath", "//*[@id=\"carForm\"]/div/div/div[3]/div[3]/input");

    }

    @Test
    @Parameters({"agent", "shortName"})
    /**
     *
     * @param plateNum
     *            车牌号
     * @param model
     *            车辆型号
     * @param brand
     *            品牌
     * @param carColor
     *            车辆颜色
     * @param seats
     *            载客人数
     * @param ownerName
     *            所属人
     * @param ownerNameMobile
     *            所属人电话
     * @param regionalAgent
     *            所属代理
     * @param agent
     *            所属公司
     * @throws InterruptedException
     */
    public static void vehicleManager(String agent, String shortName) throws InterruptedException, IOException {
        Thread.sleep(2000);
        d.findElementClick("link", "车辆管理");
        Thread.sleep(2000);

        // 判断该项目所特定的车类型：例如轩轩是专车，华威是出租车，约约是所有车型，根据不同车型需要执行不同添加操作
        String businessType = MyWebdriver.bussinessType;
        if (businessType.equals("出租车")) {
            d.findElementClick("link", "出租车");
            Thread.sleep(2000);
            d.findElementClick("xpath", "//*[@id=\"taxi\"]/form/div[5]/a");

            Select carType = new Select(d.findElement("name", "carLevelUuid"));
            carType.selectByVisibleText("出租车");
            vehicle(agent, shortName);
            d.setTimeOut();
            d.findElementClick("link", "营运管理中心");
            Thread.sleep(2000);
            d.findElementClick("link", "车辆管理");
            Thread.sleep(2000);
            d.findElementClick("link", businessType);
            Thread.sleep(3000);
            d.findElementSendKeys("name", "mix", plateNum);
            Thread.sleep(2000);
            d.findElementClick("xpath", "//*[@id=\"taxi\"]/form/div[4]/a");
            Thread.sleep(2000);
            boolean searchFlag = d.findElement("xpath", "//*[@id=\"taxi_table\"]/tbody/tr[1]/td[1]").getText()
                    .contains(plateNum);
            if (searchFlag) {

                Logger.Output(LogType.LogTypeName.INFO, "车辆新增成功,车牌号：" + plateNum);
                Thread.sleep(3000);
                // 车辆详情查看
                d.findElementClick("xpath", "//*[@id=\"taxi_table\"]/tbody/tr[1]/td[6]/a[1]");
                Thread.sleep(2000);
                boolean flag = d.findElement("xpath", "//*[@id=\"page-wrapper\"]/div/div[2]/div[1]/div/h4").getText()
                        .contains(plateNum);
                if (flag) {
                    Logger.Output(LogType.LogTypeName.INFO, "车辆详情查看成功");
                    Thread.sleep(2000);

                } else {
                    Logger.Output(LogType.LogTypeName.ERROR, "车辆详情查看失败");

                }
                // 车辆修改
                Thread.sleep(2000);
                d.findElementClick("link", "营运管理中心");
                Thread.sleep(2000);
                d.findElementClick("link", "车辆管理");
                Thread.sleep(2000);
                // 选择适合的类型
                d.findElementClick("link", businessType);
                Thread.sleep(3000);
                d.findElementSendKeys("name", "mix", plateNum);
                d.findElementClick("xpath", "//*[@id=\"taxi\"]/form/div[4]/a");
                Thread.sleep(2000);
                d.findElementClick("xpath", "//*[@id=\"taxi_table\"]/tbody/tr[1]/td[6]/a[2]");
                d.findElementSendKeys("name", "model", "Update");
                d.findElementClick("xpath", "//*[@id=\"carForm\"]/div/div/div[1]/div[3]/input");
                Logger.Output(LogType.LogTypeName.INFO, d.findElement("class", "toast-message").getText());

            } else {
                Logger.Output(LogType.LogTypeName.ERROR, plateNum + "车辆新增失败");

            }

        }
        if (businessType.equals("专车")) {
            d.findElementClick("link", "专车");
            Thread.sleep(3000);
            d.findElementClick("link", "新增");
            Thread.sleep(3000);
            Select carType = new Select(d.findElement("name", "carLevelUuid"));
            carType.selectByVisibleText("舒适型");
            vehicle(agent, shortName);
            d.setTimeOut();
            d.findElementClick("link", "营运管理中心");
            Thread.sleep(2000);
            d.findElementClick("link", "车辆管理");
            Thread.sleep(2000);
            d.findElementClick("link", businessType);
            Thread.sleep(3000);
            d.findElementSendKeys("xpath", "//*[@id=\"spec\"]/form/div[4]/div/input", plateNum);
            Thread.sleep(2000);
            d.findElementClick("xpath", "//*[@id=\"spec\"]/form/div[5]/a");
            Thread.sleep(2000);
            boolean searchFlag = d.findElement("xpath", "//*[@id=\"spec_table\"]/tbody/tr[1]/td[1]").getText()
                    .contains(plateNum);
            if (searchFlag) {

                Logger.Output(LogType.LogTypeName.INFO, "车辆新增成功,车牌号：" + plateNum);
                Thread.sleep(3000);
                // 车辆详情查看
                d.findElementClick("xpath", "//*[@id=\"spec_table\"]/tbody/tr[1]/td[9]/a[1]");
                Thread.sleep(2000);
                boolean flag = d.findElement("xpath", "//*[@id=\"page-wrapper\"]/div/div[2]/div[1]/div/h4").getText()
                        .contains(plateNum);
                if (flag) {
                    Logger.Output(LogType.LogTypeName.INFO, "车辆详情查看成功");
                    Thread.sleep(2000);

                } else {
                    Logger.Output(LogType.LogTypeName.ERROR, "车辆详情查看失败");

                }
                // 车辆修改
                Thread.sleep(2000);
                d.findElementClick("link", "营运管理中心");
                Thread.sleep(2000);
                d.findElementClick("link", "车辆管理");
                Thread.sleep(2000);
                // 选择适合的类型
                d.findElementClick("link", businessType);
                Thread.sleep(3000);
                d.findElementSendKeys("xpath", "//*[@id=\"spec\"]/form/div[4]/div/input", plateNum);
                Thread.sleep(2000);
                d.findElementClick("xpath", "//*[@id=\"spec\"]/form/div[5]/a");
                Thread.sleep(2000);
                d.findElementClick("xpath", "//*[@id=\"spec_table\"]/tbody/tr[1]/td[9]/a[2]");

                d.findElementSendKeys("name", "model", "Update");
                Thread.sleep(2000);
                d.findElementClick("xpath", "//*[@id=\"carForm\"]/div/div/div[1]/div[3]/input");
                Logger.Output(LogType.LogTypeName.INFO, d.findElement("class", "toast-message").getText());

            } else {
                Logger.Output(LogType.LogTypeName.ERROR, plateNum + "车辆新增失败");

            }

        }
        if (businessType.equals("快车")) {
            d.findElementClick("link", "快车");
            Thread.sleep(2000);
            d.findElementClick("link", "新增");
            Thread.sleep(3000);
            Select carType = new Select(d.findElement("name", "carLevelUuid"));
            carType.selectByVisibleText("快车");
            vehicle(agent, shortName);
            Thread.sleep(3000);
            d.findElementClick("link", "营运管理中心");
            Thread.sleep(2000);
            d.findElementClick("link", "车辆管理");
            Thread.sleep(2000);
            d.findElementClick("link", businessType);
            Thread.sleep(3000);
            d.findElementSendKeys("xpath", "//*[@id=\"express\"]/form/div[3]/div/input", plateNum);

            Thread.sleep(2000);
            d.findElementClick("xpath", "//*[@id=\"express\"]/form/div[4]/a");
            Thread.sleep(2000);
            boolean searchFlag = d.findElement("xpath", "//*[@id=\"express_table\"]/tbody/tr[1]/td[1]").getText()
                    .contains(plateNum);
            if (searchFlag) {

                Logger.Output(LogType.LogTypeName.INFO, "车辆新增成功,车牌号：" + plateNum);
                Thread.sleep(3000);
                // 车辆详情查看
                d.findElementClick("xpath", "//*[@id=\"express_table\"]/tbody/tr[1]/td[8]/a[1]");
                Thread.sleep(2000);
                boolean flag = d.findElement("xpath", "//*[@id=\"page-wrapper\"]/div/div[2]/div[1]/div/h4").getText()
                        .contains(plateNum);
                if (flag) {
                    Logger.Output(LogType.LogTypeName.INFO, "车辆详情查看成功");
                    Thread.sleep(2000);

                } else {
                    Logger.Output(LogType.LogTypeName.ERROR, "车辆详情查看失败");

                }
                // 车辆修改
                Thread.sleep(2000);
                d.findElementClick("link", "营运管理中心");
                Thread.sleep(2000);
                d.findElementClick("link", "车辆管理");
                Thread.sleep(2000);
                // 选择适合的类型
                d.findElementClick("link", businessType);
                Thread.sleep(3000);
                d.findElementSendKeys("xpath", "//*[@id=\"express\"]/form/div[3]/div/input", plateNum);
                Thread.sleep(2000);
                d.findElementClick("xpath", "//*[@id=\"express\"]/form/div[4]/a");
                Thread.sleep(2000);
                d.findElementClick("xpath", "//*[@id=\"express_table\"]/tbody/tr[1]/td[8]/a[2]");
                d.findElementSendKeys("name", "model", "Update");
                Thread.sleep(2000);
                d.findElementClick("xpath", "//*[@id=\"carForm\"]/div/div/div[1]/div[3]/input");
                Logger.Output(LogType.LogTypeName.INFO, d.findElement("class", "toast-message").getText());

            } else {
                Logger.Output(LogType.LogTypeName.ERROR, plateNum + "车辆新增失败");

            }

        }

    }

    @Test
    @Parameters({"agent", "shortName", "city"})
    public void driverManage(String agent, String shortName, String city) throws IOException, InterruptedException {
        String businessType =MyWebdriver.bussinessType;
        if (businessType.contains("出租车")) {
            Thread.sleep(2000);
            d.findElementClick("link", "司机管理");
            Thread.sleep(2000);
            d.findElementClick("link", "新增");
            // 上传头像
            WebElement fileUpload = driver.findElement(By.id("faceFile"));
            String filePath = "D:\\picture\\driver\\tt.png";
            fileUpload.sendKeys(filePath);
            d.findElementSendKeys("name", "name", ownerName);
            Select sexSel = new Select(d.findElement("id", "sex"));
            sexSel.selectByVisibleText("女");
            d.findElementSendKeys("id", "idCard", "350521199002076026");
            d.findElementSendKeys("name", "mobile", ownerNameMobile);

            // 上传正面身份证
            WebElement idCardBackImg = driver.findElement(By.id("idCardBackImgFile"));
            filePath = "D:\\picture\\driver\\tt.png";
            idCardBackImg.sendKeys(filePath);

            // 上传反面身份证
            WebElement idCardFaceImg = driver.findElement(By.id("idCardFaceImgFile"));
            filePath = "D:\\picture\\driver\\tt.png";
            idCardFaceImg.sendKeys(filePath);

            // 上传手持身份证
            WebElement driverIdCardImg = driver.findElement(By.id("driverIdCardImgFile"));
            filePath = "D:\\picture\\driver\\tt.png";
            driverIdCardImg.sendKeys(filePath);

            Select agentSel = new Select(d.findElement("id", "agentUuid"));
            agentSel.selectByVisibleText(agent);

            Select companySel = new Select(d.findElement("id", "companyUuid"));
            companySel.selectByVisibleText(shortName);

            Select citySel = new Select(d.findElement("id", "cityUuid"));
            citySel.selectByVisibleText(city);

            Actions action = new Actions(driver);
            // 鼠标的滑动
            WebElement xia = driver.findElement(By.name("driverNo"));
            action.moveToElement(xia).build().perform();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"driverForm\"]/div/div/div[1]/div[3]/input")).click();
            Thread.sleep(3000);
            // 退出后再重新进行车辆信息录入
            driver.navigate().refresh();
            Thread.sleep(2000);
            d.findElementClick("link", "营运管理中心");
            Thread.sleep(3000);
            d.findElementClick("link", "司机管理");
            d.findElementSendKeys("name", "conditions", ownerNameMobile);
            d.findElementClick("xpath", "//*[@id=\"taxiDriver\"]/form/div[6]/a");
            Thread.sleep(3000);
            d.findElementClick("xpath", "//*[@id=\"taxiDriver_table\"]/tbody/tr/td[12]/a[2]");
            Thread.sleep(3000);
            d.findElementClick("xpath", "//*[@id=\"page-wrapper\"]/div/div[2]/div[8]/a");
            d.findElementSendKeys("name", "plateNum", plateNum);
            Thread.sleep(3000);
            d.findElementClick("xpath", "//*[@id=\"driverForm\"]/div/div/div[8]/div[3]/div[3]/label[1]");
            Thread.sleep(3000);
            d.findElementClick("xpath", "//*[@id=\"driverForm\"]/div/div/div[8]/div[3]/input[2]");
            Thread.sleep(3000);
            Logger.Output(LogType.LogTypeName.INFO, "司机的车辆信息录入" + d.findElement("class", "toast-message").getText());

            // 新增车辆信息
            Thread.sleep(1000);
            d.setTimeOut();
            d.findElementClick("link", "营运管理中心");
            Thread.sleep(3000);
            d.findElementClick("link", "司机管理");
            d.findElementSendKeys("name", "conditions", ownerNameMobile);
            d.findElementClick("xpath", "//*[@id=\"taxiDriver\"]/form/div[6]/a");
            Thread.sleep(3000);
            boolean flag = d.findElement("xpath", "//*[@id=\"taxiDriver_table\"]/tbody/tr[1]/td[2]").getText()
                    .contains(ownerNameMobile);
            if (flag) {
                Logger.Output(LogType.LogTypeName.INFO, "司机新增成功,司机名称：" + ownerName + "，手机号：" + ownerNameMobile);
                // 司机信息修改
                Thread.sleep(3000);
                d.findElementClick("xpath", "//*[@id=\"taxiDriver_table\"]/tbody/tr/td[12]/a[2]");
                Thread.sleep(3000);
                d.findElementClear("name", "name");
                d.findElementSendKeys("name", "name", name);
                d.findElementClick("xpath", "//*[@id=\"driverForm\"]/div/div/div[1]/div[3]/input");
                d.setTimeOut();
                Logger.Output(LogType.LogTypeName.INFO,
                        d.findElement("class", "toast-message").getText() + "原司机名称：" + ownerName + "，修改为：" + name);
                Thread.sleep(3000);
                d.setTimeOut();
                d.findElementClick("link", "营运管理中心");
                Thread.sleep(3000);
                d.findElementClick("link", "司机管理");
                d.findElementSendKeys("name", "conditions", ownerNameMobile);
                d.findElementClick("xpath", "//*[@id=\"taxiDriver\"]/form/div[6]/a");
                Thread.sleep(3000);
                // 司机信息查看
                d.findElementClick("xpath", "//*[@id=\"taxiDriver_table\"]/tbody/tr[1]/td[12]/a[1]");
                Thread.sleep(3000);

                boolean detail = d
                        .findElement("xpath", "//*[@id=\"page-wrapper\"]/div/div[2]/div[1]/div[1]/div[1]/div/div/h4")
                        .getText().contains(name);
                if (detail) {
                    Logger.Output(LogType.LogTypeName.INFO, "司机信息查看成功");
                    // 封号操作
                    d.findElementClick("link", "营运管理中心");
                    Thread.sleep(3000);
                    d.findElementClick("link", "司机管理");
                    d.findElementSendKeys("name", "conditions", ownerNameMobile);
                    d.findElementClick("xpath", "//*[@id=\"taxiDriver\"]/form/div[6]/a");
                    Thread.sleep(3000);
                    String type = d.findElement("xpath", "//*[@id=\"changeStatus\"]").getText();
                    if (type.equals("封号")) {
                        d.findElementClick("xpath", "//*[@id=\"changeStatus\"]");
                        Thread.sleep(3000);
                        d.findElementSendKeys("name", "abortTime", "2019-02-09 20:00:00");
                        Thread.sleep(3000);
                        d.findElementSendKeys("name", "abortRemark", "短期封号的封号测试备注");
                        d.setTimeOut();
                        d.findElementClick("css", ".btn-determine");
                        Thread.sleep(3000);
                        String status = d.findElement("xpath", "//*[@id=\"changeStatus\"]").getText();
                        if (status.equals("解封")) {
                            Logger.Output(LogTypeName.INFO, "短期封号操作成功");
                        } else {
                            Logger.Output(LogTypeName.ERROR, "短期封号操作失败");

                        }

                    } else {
                        // 执行解封操作
                        d.findElementClick("xpath", "//*[@id=\"changeStatus\"]");
                        d.setTimeOut();
                        d.findElementClick("css", ".btn-determine");
                        Thread.sleep(3000);
                        String status = d.findElement("xpath", "//*[@id=\"changeStatus\"]").getText();
                        if (status.equals("封号")) {
                            Logger.Output(LogTypeName.INFO, "解封操作成功");

                        } else {
                            Logger.Output(LogTypeName.ERROR, "解封操作失败");

                        }

                    }
                    driver.navigate().refresh();

                } else {
                    Logger.Output(LogType.LogTypeName.ERROR, "司机信息查看失败");
                }

            } else {
                Logger.Output(LogType.LogTypeName.ERROR, "司机新增失败");
            }
        }

        if (businessType.contains("专车")) {
            Thread.sleep(2000);
            d.findElementClick("link", "司机管理");
            Thread.sleep(2000);
            d.findElementClick("link", MyWebdriver.bussinessType);
            Thread.sleep(2000);
            d.findElementClick("link", "新增");
            Thread.sleep(2000);
            // 上传头像
            WebElement fileUpload = driver.findElement(By.id("faceFile"));
            String filePath = "D:\\picture\\driver\\tt.png";
            fileUpload.sendKeys(filePath);
            d.findElementSendKeys("name", "name", ownerName);
            Select sexSel = new Select(d.findElement("id", "sex"));
            sexSel.selectByVisibleText("女");
            d.findElementSendKeys("id", "idCard", "350521199002076026");
            d.findElementSendKeys("name", "mobile", ownerNameMobile);
            Thread.sleep(3000);
            // 上传正面身份证
            WebElement idCardBackImg = driver.findElement(By.id("idCardBackImgFile"));
            filePath = "D:\\picture\\driver\\tt.png";
            idCardBackImg.sendKeys(filePath);
            Thread.sleep(3000);
            // 上传反面身份证
            WebElement idCardFaceImg = driver.findElement(By.id("idCardFaceImgFile"));
            filePath = "D:\\picture\\driver\\tt.png";
            idCardFaceImg.sendKeys(filePath);
            Thread.sleep(3000);
            // 上传手持身份证
            WebElement driverIdCardImg = driver.findElement(By.id("driverIdCardImgFile"));
            filePath = "D:\\picture\\driver\\tt.png";
            driverIdCardImg.sendKeys(filePath);
            Thread.sleep(3000);
            Select agentSel = new Select(d.findElement("id", "agentUuid"));
            agentSel.selectByVisibleText(agent);
            Thread.sleep(3000);
            Select companySel = new Select(d.findElement("id", "companyUuid"));
            companySel.selectByVisibleText(shortName);
            Thread.sleep(3000);
            Select citySel = new Select(d.findElement("id", "cityUuid"));
            citySel.selectByVisibleText(city);
            Thread.sleep(3000);
            Actions action = new Actions(driver);
            // 鼠标的滑动
            WebElement xia = driver.findElement(By.name("driverNo"));
            action.moveToElement(xia).build().perform();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"driverForm\"]/div/div/div[1]/div[3]/input")).click();
            Thread.sleep(3000);
            // 退出后再重新进行车辆信息录入
            driver.navigate().refresh();
            Thread.sleep(2000);

            d.findElementClick("link", "营运管理中心");
            Thread.sleep(3000);
            d.findElementClick("link", "司机管理");
            Thread.sleep(2000);
            d.findElementClick("link", MyWebdriver.bussinessType);
            Thread.sleep(2000);
            d.findElementSendKeys("xpath", "//*[@id=\"specDriver\"]/form/div[4]/div/input", ownerNameMobile);
            Thread.sleep(2000);
            d.findElementClick("xpath", "//*[@id=\"specDriver\"]/form/div[6]/a");
            Thread.sleep(3000);
            d.findElementClick("xpath", "//*[@id=\"specDriver_table\"]/tbody/tr[1]/td[12]/a[2]");
            Thread.sleep(3000);
            d.findElementClick("xpath", "//*[@id=\"page-wrapper\"]/div/div[2]/div[8]/a");
            d.findElementSendKeys("name", "plateNum", plateNum);
            Thread.sleep(3000);
            d.findElementClick("xpath", "//*[@id=\"driverForm\"]/div/div/div[8]/div[3]/div[3]/label[1]");
            Thread.sleep(3000);
            d.findElementClick("xpath", "//*[@id=\"driverForm\"]/div/div/div[8]/div[3]/input[2]");
            Thread.sleep(3000);
            Logger.Output(LogType.LogTypeName.INFO, "司机的车辆信息录入" + d.findElement("class", "toast-message").getText());

            // 新增车辆信息
            Thread.sleep(1000);
            d.setTimeOut();
            d.findElementClick("link", "营运管理中心");
            Thread.sleep(3000);
            d.findElementClick("link", "司机管理");
            Thread.sleep(2000);
            d.findElementClick("link", MyWebdriver.bussinessType);
            Thread.sleep(2000);
            d.findElementSendKeys("xpath", "//*[@id=\"specDriver\"]/form/div[4]/div/input", ownerNameMobile);
            Thread.sleep(2000);
            d.findElementClick("xpath", "//*[@id=\"specDriver\"]/form/div[6]/a");
            Thread.sleep(3000);
            boolean flag = d.findElement("xpath", "//*[@id=\"specDriver_table\"]/tbody/tr[1]/td[2]").getText()
                    .contains(ownerNameMobile);
            if (flag) {
                Logger.Output(LogType.LogTypeName.INFO, "司机新增成功,司机名称：" + ownerName + "，手机号：" + ownerNameMobile);
                // 司机信息修改
                Thread.sleep(3000);
                d.findElementClick("xpath", "//*[@id=\"specDriver_table\"]/tbody/tr[1]/td[12]/a[2]");
                Thread.sleep(3000);
                d.findElementClear("name", "name");
                d.findElementSendKeys("name", "name", name);
                d.findElementClick("xpath", "//*[@id=\"driverForm\"]/div/div/div[1]/div[3]/input");
                d.setTimeOut();
                Logger.Output(LogType.LogTypeName.INFO,
                        d.findElement("class", "toast-message").getText() + "原司机名称：" + ownerName + "，修改为：" + name);
                Thread.sleep(3000);
                d.setTimeOut();
                d.findElementClick("link", "营运管理中心");
                Thread.sleep(3000);
                d.findElementClick("link", "司机管理");
                Thread.sleep(2000);
                d.findElementClick("link", MyWebdriver.bussinessType);
                Thread.sleep(2000);
                d.findElementSendKeys("xpath", "//*[@id=\"specDriver\"]/form/div[4]/div/input", ownerNameMobile);
                Thread.sleep(2000);
                d.findElementClick("xpath", "//*[@id=\"specDriver\"]/form/div[6]/a");
                Thread.sleep(3000);
                // 司机信息查看
                d.findElementClick("xpath", "//*[@id=\"specDriver_table\"]/tbody/tr[1]/td[12]/a[1]");
                Thread.sleep(3000);

                boolean detail = d
                        .findElement("xpath", "//*[@id=\"page-wrapper\"]/div/div[2]/div[1]/div[1]/div[1]/div/div/h4")
                        .getText().contains(name);
                if (detail) {
                    Logger.Output(LogType.LogTypeName.INFO, "司机信息查看成功");
                    // 封号操作
                    d.findElementClick("link", "营运管理中心");
                    Thread.sleep(3000);
                    d.findElementClick("link", "司机管理");
                    Thread.sleep(2000);
                    d.findElementClick("link", MyWebdriver.bussinessType);
                    Thread.sleep(2000);
                    d.findElementSendKeys("xpath", "//*[@id=\"specDriver\"]/form/div[4]/div/input", ownerNameMobile);
                    Thread.sleep(2000);
                    d.findElementClick("xpath", "//*[@id=\"specDriver\"]/form/div[6]/a");
                    Thread.sleep(3000);
                    d.findElementClick("link", "封号");
                    Thread.sleep(3000);
                    d.findElementSendKeys("name", "abortTime", "2019-02-09 20:00:00");
                    Thread.sleep(3000);
                    d.findElementSendKeys("name", "abortRemark", "短期封号的封号测试备注");
                    d.setTimeOut();
                    d.findElementClick("css", ".btn-determine");
                    Logger.Output(LogTypeName.INFO, d.findElement("class", "toast-message").getText());

                    driver.navigate().refresh();

                } else {
                    Logger.Output(LogType.LogTypeName.ERROR, "司机信息查看失败");
                }

            } else {
                Logger.Output(LogType.LogTypeName.ERROR, "司机新增失败");
            }

        }


        if (businessType.contains("快车")) {
            Thread.sleep(2000);
            d.findElementClick("link", "司机管理");
            Thread.sleep(2000);
            d.findElementClick("link", MyWebdriver.bussinessType);
            Thread.sleep(2000);
            d.findElementClick("link", "新增");
            Thread.sleep(2000);
            // 上传头像
            WebElement fileUpload = driver.findElement(By.id("faceFile"));
            String filePath = "D:\\picture\\driver\\tt.png";
            fileUpload.sendKeys(filePath);
            d.findElementSendKeys("name", "name", ownerName);
            Select sexSel = new Select(d.findElement("id", "sex"));
            sexSel.selectByVisibleText("女");
            d.findElementSendKeys("id", "idCard", "350521199002076026");
            d.findElementSendKeys("name", "mobile", ownerNameMobile);
            Thread.sleep(3000);
            // 上传正面身份证
            WebElement idCardBackImg = driver.findElement(By.id("idCardBackImgFile"));
            filePath = "D:\\picture\\driver\\tt.png";
            idCardBackImg.sendKeys(filePath);
            Thread.sleep(3000);
            // 上传反面身份证
            WebElement idCardFaceImg = driver.findElement(By.id("idCardFaceImgFile"));
            filePath = "D:\\picture\\driver\\tt.png";
            idCardFaceImg.sendKeys(filePath);
            Thread.sleep(3000);
            // 上传手持身份证
            WebElement driverIdCardImg = driver.findElement(By.id("driverIdCardImgFile"));
            filePath = "D:\\picture\\driver\\tt.png";
            driverIdCardImg.sendKeys(filePath);
            Thread.sleep(3000);
            Select agentSel = new Select(d.findElement("id", "agentUuid"));
            agentSel.selectByVisibleText(agent);
            Thread.sleep(3000);
            Select companySel = new Select(d.findElement("id", "companyUuid"));
            companySel.selectByVisibleText(shortName);
            Thread.sleep(3000);
            Select citySel = new Select(d.findElement("id", "cityUuid"));
            citySel.selectByVisibleText(city);
            Thread.sleep(3000);
            Actions action = new Actions(driver);
            // 鼠标的滑动
            WebElement xia = driver.findElement(By.name("driverNo"));
            action.moveToElement(xia).build().perform();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"driverForm\"]/div/div/div[1]/div[3]/input")).click();
            Thread.sleep(3000);
            // 退出后再重新进行车辆信息录入
            driver.navigate().refresh();
            Thread.sleep(2000);

            d.findElementClick("link", "营运管理中心");
            Thread.sleep(3000);
            d.findElementClick("link", "司机管理");
            Thread.sleep(2000);
            d.findElementClick("link", MyWebdriver.bussinessType);
            Thread.sleep(2000);
            d.findElementSendKeys("xpath", "//*[@id=\"expressDriver\"]/form/div[4]/div/input", ownerNameMobile);
            Thread.sleep(2000);
            d.findElementClick("xpath", "//*[@id=\"expressDriver\"]/form/div[6]/a");
            Thread.sleep(3000);
            d.findElementClick("xpath", "//*[@id=\"expressDriver_table\"]/tbody/tr[1]/td[12]/a[2]");
            Thread.sleep(3000);
            d.findElementClick("xpath", "//*[@id=\"page-wrapper\"]/div/div[2]/div[8]/a");
            d.findElementSendKeys("name", "plateNum", plateNum);
            Thread.sleep(3000);
            d.findElementClick("xpath", "//*[@id=\"driverForm\"]/div/div/div[8]/div[3]/div[3]/label[1]");
            Thread.sleep(3000);
            d.findElementClick("xpath", "//*[@id=\"driverForm\"]/div/div/div[8]/div[3]/input[2]");
            Thread.sleep(3000);
            Logger.Output(LogType.LogTypeName.INFO, "司机的车辆信息录入" + d.findElement("class", "toast-message").getText());

            // 新增车辆信息
            Thread.sleep(1000);
            d.setTimeOut();
            d.findElementClick("link", "营运管理中心");
            Thread.sleep(3000);
            d.findElementClick("link", "司机管理");
            Thread.sleep(2000);
            d.findElementClick("link", MyWebdriver.bussinessType);
            Thread.sleep(2000);
            d.findElementSendKeys("xpath", "//*[@id=\"expressDriver\"]/form/div[4]/div/input", ownerNameMobile);
            Thread.sleep(2000);
            d.findElementClick("xpath", "//*[@id=\"expressDriver\"]/form/div[6]/a");
            Thread.sleep(3000);
            boolean flag = d.findElement("xpath", "//*[@id=\"expressDriver_table\"]/tbody/tr[1]/td[2]").getText()
                    .contains(ownerNameMobile);
            if (flag) {
                Logger.Output(LogType.LogTypeName.INFO, "司机新增成功,司机名称：" + ownerName + "，手机号：" + ownerNameMobile);
                // 司机信息修改
                Thread.sleep(3000);
                d.findElementClick("xpath", "//*[@id=\"expressDriver_table\"]/tbody/tr[1]/td[12]/a[2]");
                Thread.sleep(3000);
                d.findElementClear("name", "name");
                d.findElementSendKeys("name", "name", name);
                d.findElementClick("xpath", "//*[@id=\"driverForm\"]/div/div/div[1]/div[3]/input");
                d.setTimeOut();
                Logger.Output(LogType.LogTypeName.INFO,
                        d.findElement("class", "toast-message").getText() + "原司机名称：" + ownerName + "，修改为：" + name);
                Thread.sleep(3000);
                d.setTimeOut();
                d.findElementClick("link", "营运管理中心");
                Thread.sleep(3000);
                d.findElementClick("link", "司机管理");
                Thread.sleep(2000);
                d.findElementClick("link", MyWebdriver.bussinessType);
                Thread.sleep(2000);
                d.findElementSendKeys("xpath", "//*[@id=\"expressDriver\"]/form/div[4]/div/input", ownerNameMobile);
                Thread.sleep(2000);
                d.findElementClick("xpath", "//*[@id=\"expressDriver\"]/form/div[6]/a");
                Thread.sleep(3000);
                // 司机信息查看
                d.findElementClick("xpath", "//*[@id=\"expressDriver_table\"]/tbody/tr[1]/td[12]/a[1]");
                Thread.sleep(3000);

                boolean detail = d
                        .findElement("xpath", "//*[@id=\"page-wrapper\"]/div/div[2]/div[1]/div[1]/div[1]/div/div/h4")
                        .getText().contains(name);
                if (detail) {
                    Logger.Output(LogType.LogTypeName.INFO, "司机信息查看成功");
                    // 封号操作
                    d.findElementClick("link", "营运管理中心");
                    Thread.sleep(3000);
                    d.findElementClick("link", "司机管理");
                    Thread.sleep(2000);
                    d.findElementClick("link", MyWebdriver.bussinessType);
                    Thread.sleep(2000);
                    d.findElementSendKeys("xpath", "//*[@id=\"expressDriver\"]/form/div[4]/div/input", ownerNameMobile);
                    Thread.sleep(2000);
                    d.findElementClick("xpath", "//*[@id=\"expressDriver\"]/form/div[6]/a");
                    Thread.sleep(3000);
                    d.findElementClick("link", "封号");
                    Thread.sleep(3000);
                    d.findElementSendKeys("name", "abortTime", "2019-02-09 20:00:00");
                    Thread.sleep(3000);
                    d.findElementSendKeys("name", "abortRemark", "短期封号的封号测试备注");
                    d.setTimeOut();
                    d.findElementClick("css", ".btn-determine");
                    Logger.Output(LogTypeName.INFO, d.findElement("class", "toast-message").getText());

                    driver.navigate().refresh();

                } else {
                    Logger.Output(LogType.LogTypeName.ERROR, "司机信息查看失败");
                }

            } else {
                Logger.Output(LogType.LogTypeName.ERROR, "司机新增失败");
            }

        }

    }

    @Parameters({"agent", "shortName", "city"})
    public static void specialDriver(String agent, String shortName, String city)
            throws InterruptedException, IOException {

    }

    @Test
    @Parameters({"agent", "shortName", "city", "carType"})
    public static void driverMessage(String agent, String shortName, String city, String carType)
            throws InterruptedException {
        //司机消息发送给全部
        Thread.sleep(2000);
        d.findElementClick("link", "营运管理中心");
        Thread.sleep(2000);
        d.findElementClick("link", "司机消息管理");
        Thread.sleep(2000);
        d.findElementClick("link", "新增");
        Thread.sleep(3000);
        Select agentSel = new Select(d.findElement("name", "agentUuid"));
        agentSel.selectByVisibleText(agent);
        Thread.sleep(3000);
        Select companySel = new Select(d.findElement("name", "companyUuid"));
        companySel.selectByVisibleText(shortName);
        Thread.sleep(3000);
        Select citySel = new Select(d.findElement("name", "cityUuid"));
        citySel.selectByVisibleText(city);

        Select carTypeSel = new Select(d.findElement("name", "businessType"));
        carTypeSel.selectByVisibleText(carType);
        Thread.sleep(2000);
        String content = "司机消息发送测试内容";
        d.findElementSendKeys("id", "content", content);

        d.findElementClick("xpath", "//*[@id=\"save-form\"]/div[9]/div/a[1]");
        Thread.sleep(2000);
        boolean flag = d.findElement("xpath", "//*[@id=\"driver_message_table\"]/tbody/tr[1]/td[6]").getText()
                .contains(content);
        if (flag) {
            Logger.Output(LogType.LogTypeName.INFO, "司机消息管理新增成功");
            Thread.sleep(1000);
            d.findElementClick("xpath", "//*[@id=\"driver_message_table\"]/tbody/tr[1]/td[8]/a[1]");
            Thread.sleep(3000);
            boolean detail = d.findElement("xpath", "//*[@id=\"save-form\"]/div[9]/div/a").getText().contains("取消");
            if (detail) {
                Logger.Output(LogType.LogTypeName.INFO, "司机消息管理详情查看成功");

            } else {
                Logger.Output(LogType.LogTypeName.ERROR, "司机消息管理详情查看失败");

            }

        } else {
            Logger.Output(LogType.LogTypeName.ERROR, "司机消息新增失败");

        }

        //司机消息发送给部分司机

        Thread.sleep(2000);
        d.findElementClick("link", "营运管理中心");
        Thread.sleep(2000);
        d.findElementClick("link", "司机消息管理");
        Thread.sleep(2000);
        d.findElementClick("link", "新增");
        Thread.sleep(3000);
        agentSel = new Select(d.findElement("name", "agentUuid"));
        agentSel.selectByVisibleText(agent);
        Thread.sleep(3000);
        companySel = new Select(d.findElement("name", "companyUuid"));
        companySel.selectByVisibleText(shortName);
        Thread.sleep(3000);
        citySel = new Select(d.findElement("name", "cityUuid"));
        citySel.selectByVisibleText(city);
        Thread.sleep(3000);
        carTypeSel = new Select(d.findElement("name", "businessType"));
        carTypeSel.selectByVisibleText(carType);


        d.findElementClick("xpath", "//*[@id=\"send-target\"]");
        d.findElementClick("xpath", "//*[@id=\"sendType-link\"]");

        Thread.sleep(2000);
        d.findElementSendKeys("id", "targetDriverMobile", ownerNameMobile);
        Thread.sleep(2000);
        d.findElementSendKeys("id", "title", "个别司机消息发送测试");
        d.findElementSendKeys("name", "linkUrl", "http://www.baidu.com");

        Thread.sleep(2000);

        d.findElementClick("xpath", "//*[@id=\"save-form\"]/div[9]/div/a[1]");


        Thread.sleep(2000);
        flag = d.findElement("xpath", "//*[@id=\"driver_message_table\"]/tbody/tr[1]/td[4]").getText()
                .contains("个别司机消息发送测试");
        if (flag) {
            Logger.Output(LogType.LogTypeName.INFO, "司机个别消息管理新增成功");
            Thread.sleep(1000);
            d.findElementClick("xpath", "//*[@id=\"driver_message_table\"]/tbody/tr[1]/td[8]/a[1]");
            Thread.sleep(3000);
            boolean detail = d.findElement("xpath", "//*[@id=\"save-form\"]/div[9]/div/a").getText().contains("取消");
            if (detail) {
                Logger.Output(LogType.LogTypeName.INFO, "司机个别消息管理详情查看成功");

            } else {
                Logger.Output(LogType.LogTypeName.ERROR, "司机个别消息管理详情查看失败");

            }

        } else {
            Logger.Output(LogType.LogTypeName.ERROR, "司机个别消息新增失败");

        }


    }

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        Thread.sleep(3000);
        d.findElementClick("link", "营运管理中心");
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
