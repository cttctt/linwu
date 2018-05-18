package com.summersoft.ctt.yycx.po;

import com.summersoft.ctt.yycx.page.*;
import com.summersoft.ctt.yycx.util.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OperationManagerPo {
    private String excelPath = MyWebdriver.ProjectURL + "/excel/OperationManagerCase.xlsx";
    private static String agent = RandomValue.getChineseName();
    private static String responsibleName = RandomValue.getChineseName();
    private static String companyName = RandomValue.getChineseName();
    private static String taxiPlateNum = RandomValue.getCarNo();
    private static String specPlateNum = RandomValue.getCarNo();
    private static String fastPlateNum = RandomValue.getCarNo();
    private static String ownerName = RandomValue.getChineseName();
    private static String ownerNameMobile = RandomValue.getTel();
    private static String responsibleMobile = RandomValue.getTel();
    private static String cityName = MyWebdriver.city;
    private static String taxiDriverName = RandomValue.getChineseName();
    private static String taxiDriverMobile = RandomValue.getTel();
    private static String specDriverName = RandomValue.getChineseName();
    private static String specDriverMobile = RandomValue.getTel();
    private static String fastDriverName = RandomValue.getChineseName();
    private static String fastDriverMobile = RandomValue.getTel();
    public static WebDriver driver;
    public static MyWebdriver d;

    //此类功能：新增业务编辑城市|抽成，关闭业务等操作
    private void addBussinessType() throws Exception {
        RegionalManager region = PageFactory.initElements(driver, RegionalManager.class);
        ExcelUtil.setExcelFile(excelPath, "region");
        //ProjectTyp:约约（执行快车专车出租车）：易行通（出租车）；其他（快车、专车）
        String projectType = MyWebdriver.ProjectType;
        //开通出租车、专车、快车业务
        switch (projectType) {
            case "约约": {
                Thread.sleep(3000);
                //添加业务
                region.clickAddBussinessIcon();
                Thread.sleep(3000);
                region.selectBusinessType(ExcelUtil.getCellAsString(3, 4));
                Thread.sleep(3000);
                region.clickSubmitBtn();
                Thread.sleep(3000);
                //关闭业务
                Thread.sleep(3000);
                region.linkCloseBussiness();
                Thread.sleep(3000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                Logger.Output(LogType.LogTypeName.INFO, "关闭业务操作成功");
                //再次添加业务
                Thread.sleep(3000);
                region.clickAddBussinessIcon();
                Thread.sleep(3000);
                region.selectBusinessType(ExcelUtil.getCellAsString(3, 4));
                Thread.sleep(3000);
                region.clickSubmitBtn();
                Thread.sleep(3000);
                //点击编辑城市
                region.clickUpdateCityBtn();
                Thread.sleep(3000);
                region.selectCity(cityName);
                region.clickSubmitBtn();
                Thread.sleep(3000);
                if (region.getLabelCityName().equals(cityName)) {
                    Logger.Output(LogType.LogTypeName.INFO, "出租车业务下的城市编辑成功");

                } else {
                    Logger.Output(LogType.LogTypeName.ERROR, "出租车业务下的城市编辑成功");

                }
                //点击编辑抽成
                Thread.sleep(3000);
                region.clickChangeComission();
                Thread.sleep(3000);
                region.inputComissionAmount(ExcelUtil.getCellAsNumber(6, 4));
                region.clickSubmitBtn();
                Thread.sleep(3000);
                if (region.getLabelComissionAmount().contains(ExcelUtil.getCellAsNumber(6, 4))) {
                    Logger.Output(LogType.LogTypeName.INFO, "抽成编辑成功");
                } else {
                    Logger.Output(LogType.LogTypeName.ERROR, "抽成编辑失败");
                }
                //专车
                Thread.sleep(3000);
                region.clickAddBussinessIcon();
                Thread.sleep(3000);
                region.selectBusinessType(ExcelUtil.getCellAsString(5, 4));
                Thread.sleep(3000);
                region.clickSubmitBtn();
                Thread.sleep(3000);
                //点击编辑城市
                region.clickUpdateCityBtn();
                Thread.sleep(3000);
                region.selectCity(cityName);
                region.clickSubmitBtn();
                Thread.sleep(3000);
                if (region.getLabelCityName().equals(cityName)) {
                    Logger.Output(LogType.LogTypeName.INFO, "专车业务下的城市新增成功");

                } else {
                    Logger.Output(LogType.LogTypeName.ERROR, "专车业务下的城市新增失败");

                }
                //点击编辑抽成
                Thread.sleep(3000);
                region.clickChangeComission();
                Thread.sleep(3000);
                region.inputComissionAmount(ExcelUtil.getCellAsNumber(6, 4));
                Thread.sleep(3000);
                region.clickSubmitBtn();
                Thread.sleep(3000);
                if (region.getLabelComissionAmount().contains(ExcelUtil.getCellAsNumber(6, 4))) {
                    Logger.Output(LogType.LogTypeName.INFO, "抽成编辑成功");
                } else {
                    Logger.Output(LogType.LogTypeName.ERROR, "抽成编辑失败");
                }
                //快车
                Thread.sleep(3000);
                region.clickAddBussinessIcon();
                Thread.sleep(3000);
                region.selectBusinessType(ExcelUtil.getCellAsString(4, 4));
                Thread.sleep(3000);
                region.clickSubmitBtn();
                Thread.sleep(3000);
                //点击编辑城市
                region.clickUpdateCityBtn();
                Thread.sleep(3000);
                region.selectCity(cityName);
                region.clickSubmitBtn();
                Thread.sleep(3000);
                if (region.getLabelCityName().equals(cityName)) {
                    Logger.Output(LogType.LogTypeName.INFO, "快车业务下的城市新增成功");

                } else {
                    Logger.Output(LogType.LogTypeName.ERROR, "快车业务下的城市新增失败");
                }
                //点击编辑抽成
                Thread.sleep(3000);
                region.clickChangeComission();
                Thread.sleep(3000);
                region.inputComissionAmount(ExcelUtil.getCellAsNumber(6, 4));
                Thread.sleep(3000);
                region.clickSubmitBtn();
                Thread.sleep(3000);
                if (region.getLabelComissionAmount().contains(ExcelUtil.getCellAsNumber(6, 4))) {
                    Logger.Output(LogType.LogTypeName.INFO, "抽成编辑成功");
                } else {
                    Logger.Output(LogType.LogTypeName.ERROR, "抽成编辑失败");

                }

                break;
            }
            //只开通出租车
            case "易行通": {
                Thread.sleep(3000);
                //出租车

                //添加业务
                region.clickAddBussinessIcon();
                Thread.sleep(3000);
                region.selectBusinessType(ExcelUtil.getCellAsString(3, 4));
                Thread.sleep(3000);
                region.clickSubmitBtn();
                Thread.sleep(3000);
                //关闭业务
                Thread.sleep(3000);
                region.linkCloseBussiness();
                Thread.sleep(3000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                Logger.Output(LogType.LogTypeName.INFO, "关闭业务操作成功");
                //再次添加业务
                Thread.sleep(3000);
                region.clickAddBussinessIcon();
                Thread.sleep(3000);
                region.selectBusinessType(ExcelUtil.getCellAsString(3, 4));
                Thread.sleep(3000);
                region.clickSubmitBtn();
                Thread.sleep(5000);
                //点击编辑城市
                region.clickUpdateCityBtn();
                Thread.sleep(3000);
                region.selectCity(cityName);
                region.clickSubmitBtn();
                Thread.sleep(3000);
                if (region.getLabelCityName().equals(cityName)) {
                    Logger.Output(LogType.LogTypeName.INFO, "出租车业务下的城市编辑成功");

                } else {
                    Logger.Output(LogType.LogTypeName.ERROR, "出租车业务下的城市编辑成功");

                }
                //点击编辑抽成
                Thread.sleep(3000);
                region.clickChangeComission();
                Thread.sleep(3000);
                region.inputComissionAmount(ExcelUtil.getCellAsNumber(6, 4));
                region.clickSubmitBtn();
                Thread.sleep(3000);
                if (region.getLabelComissionAmount().contains(ExcelUtil.getCellAsNumber(6, 4))) {
                    Logger.Output(LogType.LogTypeName.INFO, "抽成编辑成功");
                } else {
                    Logger.Output(LogType.LogTypeName.ERROR, "抽成编辑失败");
                }
                break;
            }
            //开通快车和专车
            default:
                //快车
                Thread.sleep(3000);
                region.clickAddBussinessIcon();
                Thread.sleep(3000);
                region.selectBusinessType(ExcelUtil.getCellAsString(4, 4));
                Thread.sleep(3000);
                region.clickSubmitBtn();
                Thread.sleep(3000);
                //点击编辑城市
                region.clickUpdateCityBtn();
                Thread.sleep(3000);
                region.selectCity(cityName);
                region.clickSubmitBtn();
                Thread.sleep(3000);
                if (region.getLabelCityName().equals(cityName)) {
                    Logger.Output(LogType.LogTypeName.INFO, "快车业务下的城市新增成功");

                } else {
                    Logger.Output(LogType.LogTypeName.ERROR, "快车业务下的城市新增失败");
                }
                //点击编辑抽成
                Thread.sleep(3000);
                region.clickChangeComission();
                Thread.sleep(3000);
                region.inputComissionAmount(ExcelUtil.getCellAsNumber(6, 4));
                Thread.sleep(3000);
                region.clickSubmitBtn();
                Thread.sleep(3000);
                if (region.getLabelComissionAmount().contains(ExcelUtil.getCellAsNumber(6, 4))) {
                    Logger.Output(LogType.LogTypeName.INFO, "抽成编辑成功");
                } else {
                    Logger.Output(LogType.LogTypeName.ERROR, "抽成编辑失败");
                }
                //专车
                Thread.sleep(3000);
                region.clickAddBussinessIcon();
                Thread.sleep(3000);
                region.selectBusinessType(ExcelUtil.getCellAsString(5, 4));
                Thread.sleep(3000);
                region.clickSubmitBtn();
                Thread.sleep(3000);
                //点击编辑城市
                region.clickUpdateCityBtn();
                Thread.sleep(3000);
                region.selectCity(cityName);
                region.clickSubmitBtn();
                Thread.sleep(3000);
                if (region.getLabelCityName().equals(cityName)) {
                    Logger.Output(LogType.LogTypeName.INFO, "专车业务下的城市新增成功");

                } else {
                    Logger.Output(LogType.LogTypeName.ERROR, "专车业务下的城市新增失败");
                }
                //点击编辑抽成
                Thread.sleep(3000);
                region.clickChangeComission();
                Thread.sleep(3000);
                region.inputComissionAmount(ExcelUtil.getCellAsNumber(6, 4));
                Thread.sleep(3000);
                region.clickSubmitBtn();
                Thread.sleep(3000);
                if (region.getLabelComissionAmount().contains(ExcelUtil.getCellAsNumber(6, 4))) {
                    Logger.Output(LogType.LogTypeName.INFO, "抽成编辑成功");
                } else {
                    Logger.Output(LogType.LogTypeName.ERROR, "抽成编辑失败");
                }
                break;
        }
    }

    @BeforeClass
    @Parameters({"browser"})
    public void beforeClass(String browser) throws IOException {
        driver=MyWebdriver.before(browser,driver);
        d = new MyWebdriver(driver);
        d.openPage(MyWebdriver.baseURL);

    }


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

        d.findElementClick("link", "营运管理中心");

    }



    //区域代理管理
    @Test
    public void regionalManager() throws Exception {

        Thread.sleep(3000);
        d.findElementClick("link", "区域代理管理");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        ExcelUtil.setExcelFile(excelPath, "region");
        RegionalManager region = PageFactory.initElements(driver, RegionalManager.class);
        Thread.sleep(3000);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        region.clickAddBtn();
        Thread.sleep(3000);
        region.inputAgentName(agent);
        region.inputResponsibleName(responsibleName);
        region.inputResponsibleMobile(responsibleMobile);
        region.inputIDCard(ExcelUtil.getCellAsString(2, 4));
        Thread.sleep(3000);
        region.clickSubmitBtn();
        String message = d.findElement("class", "toast-message").getText();
        Logger.Output(LogType.LogTypeName.INFO, message);
        String errorMessage = "保存失败，错误信息：账户名：" + agent + "已经被注册了";
        if (errorMessage.equals(message)) {
            d.setTimeOut();
            d.findElementClick("class", "close");
            Thread.sleep(3000);
            d.findElementClick("link", "营运管理中心");
        } else {
            Thread.sleep(3000);
            //出租车
            region.clickDetailBtn();
            Thread.sleep(3000);
            Logger.Output(LogType.LogTypeName.INFO, "区域代理新增成功，查询详情也正常");
            addBussinessType();

        }
    }

    //企业管理
    @Test
    public void businessManager() throws Exception {
        Thread.sleep(3000);
        d.findElementClick("link", "企业管理");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        BusinessManager bussiness = PageFactory.initElements(driver, BusinessManager.class);
        Thread.sleep(3000);
        d.findElementClick("id", "company_add");
        Thread.sleep(3000);
        bussiness.inputFullName(companyName);
        bussiness.inputShortName(companyName);
        bussiness.inputResponsibleName(responsibleName);
        bussiness.inputResponsibleMobile(responsibleMobile);
        bussiness.inputPhone(responsibleMobile);
        bussiness.selectAgent(agent);
        bussiness.clickSubmitBtn();
        String message = d.findElement("class", "toast-message").getText();
        Logger.Output(LogType.LogTypeName.INFO, message);
        String errorMessage = "保存失败，错误信息：公司简称：" + agent + "已经被注册了";
        if (errorMessage.equals(message)) {
            d.setTimeOut();
            d.findElementClick("class", "close");
            Thread.sleep(3000);
            d.findElementClick("link", "营运管理中心");
        } else {
            Thread.sleep(2000);
            bussiness.clickDetailBtn();
            Thread.sleep(2000);
            bussiness.getLabelCompanyName();
            if (bussiness.getLabelCompanyName().equals(companyName)) {
                Logger.Output(LogType.LogTypeName.INFO, "企业新增成功，查询详情也正常");
                // 新增企业下的营业业务
                addBussinessType();
            }
        }
    }

    //修改车辆的信息（新增所有非必录项的信息录入）
    private void updateVehicle() throws Exception {
        VehicleManager vehicle = PageFactory.initElements(driver, VehicleManager.class);
        ExcelUtil.setExcelFile(excelPath, "vehicle");
        Thread.sleep(3000);
        vehicle.clickDownBtn();
        Thread.sleep(3000);
//        选择车辆颜色
        vehicle.selectPlateColor(ExcelUtil.getCellAsString(16, 4));
//        上传车辆照片
        vehicle.uploadCarImgFile(ExcelUtil.getCellAsString(17, 4));
//        上传车牌照片
        vehicle.uploadPlateImgFile(ExcelUtil.getCellAsString(18, 4));
//        行驶证下的车辆类型
        vehicle.inputVehicleType(ExcelUtil.getCellAsString(19, 4));
//        上传行驶证照片
        vehicle.uploadDrivingLicenseImgFile(ExcelUtil.getCellAsString(20, 4));
//        上传行驶证照片反面
        vehicle.uploadDrivingLicenseSubImgFile(ExcelUtil.getCellAsString(21, 4));
        //      发动机号
        vehicle.inputEngineId(ExcelUtil.getCellAsString(22, 4));
        // 车辆VIN码
        vehicle.inputVin(ExcelUtil.getCellAsString(23, 4));

        // 选择车辆注册日期
        vehicle.selectCertifyDateA(ExcelUtil.getCellAsDate(24, 4));

        //  选择车辆发证日期

        vehicle.selectDrivingLicenseDate(ExcelUtil.getCellAsDate(25, 4));
        Thread.sleep(3000);
        ///  运输证号
        vehicle.inputCertificate(ExcelUtil.getCellAsString(26, 4));
//        发证机构
        vehicle.inputTransAgency(ExcelUtil.getCellAsString(27, 4));
//        经营区域
        vehicle.inputTransArea(ExcelUtil.getCellAsString(28, 4));
//        选择有效日期起
        vehicle.selectTransDateStart(ExcelUtil.getCellAsDate(29, 4));
//        选择有效日期止
        vehicle.selectTransDateStop(ExcelUtil.getCellAsDate(30, 4));
        //选择登记日期
        vehicle.selectcertifyDateB(ExcelUtil.getCellAsDate(56, 4));
//        选择报备日期
        vehicle.selectRegisterDate(ExcelUtil.getCellAsDate(31, 4));
//        选择服务类型
        vehicle.selectCommercialType(ExcelUtil.getCellAsString(32, 4));
//        保险公司
        vehicle.selectInsurCom(ExcelUtil.getCellAsString(33, 4));

//        保险号
        vehicle.inputInsurNum(ExcelUtil.getCellAsString(34, 4));
//        保险类型
        vehicle.inputInsurType(ExcelUtil.getCellAsString(35, 4));
//        保险金额
        vehicle.inputInsurCount(ExcelUtil.getCellAsString(36, 4));
//        赔付额度
        vehicle.inputInsurLimit(ExcelUtil.getCellAsString(37, 4));

//        选择保险有效期起
        vehicle.selectInsurEff(ExcelUtil.getCellAsDate(38, 4));

//        选择保险有效期止
        vehicle.selectInsurExp(ExcelUtil.getCellAsDate(39, 4));
//        选择车辆燃料类型
        vehicle.selectFuelType(ExcelUtil.getCellAsString(40, 4));

//        发动机排量
        vehicle.inputEngineDisplace(ExcelUtil.getCellAsString(41, 4));
//        发动机功率
        vehicle.inputEnginePower(ExcelUtil.getCellAsString(42, 4));
//        车辆轴距
        vehicle.inputWheelbase(ExcelUtil.getCellAsString(43, 4));
//        选择车辆检修状态
        vehicle.selectFixState(ExcelUtil.getCellAsString(44, 4));
//        选择下年检时间
        vehicle.selectNextFixDate(ExcelUtil.getCellAsDate(45, 4));
//        选择年度审验状态
        vehicle.selectCheckState(ExcelUtil.getCellAsString(46, 4));
//        选择年审时间
        vehicle.selectCheckDate(ExcelUtil.getCellAsDate(47, 4));
//        选择下次年审时间
        vehicle.selectNextCheckDate(ExcelUtil.getCellAsDate(48, 4));
//        发票打印序列号
        vehicle.inputFeePrintId(ExcelUtil.getCellAsString(49, 4));
//        卫星定位装置品牌
        vehicle.inputGpsBrand(ExcelUtil.getCellAsString(50, 4));
//        卫星定位装置型号
        vehicle.inputGpsModel(ExcelUtil.getCellAsString(51, 4));
//        卫星定位装置IMEI号
        vehicle.inputGpsImei(ExcelUtil.getCellAsString(52, 4));
//        选择安装日期
        vehicle.selectInstallDate(ExcelUtil.getCellAsDate(53, 4));
//        车辆技术状况
        vehicle.inputVehicleTechnicalCondition(ExcelUtil.getCellAsString(54, 4));
//        安全性能情况
        vehicle.inputSafetyPerformance(ExcelUtil.getCellAsString(55, 4));
        Thread.sleep(3000);
        vehicle.clickSubmitBtn();
        d.getMessage();
        Thread.sleep(3000);

    }


    private void addVehicle(String carTypeName) throws Exception {
        VehicleManager vehicle = PageFactory.initElements(driver, VehicleManager.class);
        Thread.sleep(3000);
        vehicle.clickAddBtn();
        Thread.sleep(3000);
        if (carTypeName.equals("出租车")) {
            vehicle.inputPlateNum(taxiPlateNum);
            vehicle.inputModel("奔驰");
            vehicle.inputBrand("德国");
            vehicle.inputCarColor("白色");
            vehicle.inputSeats("4");
            vehicle.selectAgentUuid(agent);
            Thread.sleep(3000);
            vehicle.selectCompanyUuid(companyName);
            Thread.sleep(3000);
            vehicle.selectcBusinessUuid(carTypeName);
            Thread.sleep(3000);
            vehicle.selectCarLevelUuid("出租车");
            vehicle.inputOwnerName(ownerName);
            vehicle.inputOwnerNameMobile(ownerNameMobile);
            Thread.sleep(3000);
            vehicle.clickSubmitBtn();
            d.getMessage();
            Thread.sleep(3000);
            d.findElementClick("link", "出租车");
            Thread.sleep(3000);
            d.findElementSendKeys("name", "mix", taxiPlateNum);
            Thread.sleep(3000);
            vehicle.clickSearchBtn();
            Thread.sleep(3000);
            if (vehicle.getTaxiPlateNum().equals(taxiPlateNum)) {
                Logger.Output(LogType.LogTypeName.INFO, "出租车新增成功,车牌号：" + taxiPlateNum);
                Thread.sleep(3000);
                // 车辆详情查看
                d.findElementClick("xpath", "//*[@id=\"taxi_table\"]/tbody/tr[1]/td[6]/a[1]");
                Thread.sleep(2000);
                boolean flag = d.findElement("xpath", "//*[@id=\"page-wrapper\"]/div/div[2]/div[1]/div/h4").getText()
                        .contains(taxiPlateNum);
                if (flag) {
                    Logger.Output(LogType.LogTypeName.INFO, "出租车详情查看成功");
                    driver.navigate().back();
                    Thread.sleep(2000);
                    //车辆修改
                    vehicle.clickTaxiUpdateBtn();
                    Thread.sleep(3000);
                    updateVehicle();
                    Thread.sleep(3000);

                } else {
                    Logger.Output(LogType.LogTypeName.ERROR, "出租车详情查看失败");

                }
            } else {
                Logger.Output(LogType.LogTypeName.ERROR, "出租车新增失败");
            }
        }
        if (carTypeName.equals("快车")) {
            vehicle.inputPlateNum(fastPlateNum);
            vehicle.inputModel("奔驰");
            vehicle.inputBrand("德国");
            vehicle.inputCarColor("白色");
            vehicle.inputSeats("4");
            vehicle.selectAgentUuid(agent);
            Thread.sleep(3000);
            vehicle.selectCompanyUuid(companyName);
            Thread.sleep(3000);
            vehicle.selectcBusinessUuid(carTypeName);
            Thread.sleep(3000);
            vehicle.selectCarLevelUuid("快车");
            vehicle.inputOwnerName(ownerName);
            vehicle.inputOwnerNameMobile(ownerNameMobile);
            Thread.sleep(3000);
            vehicle.clickSubmitBtn();
            Thread.sleep(3000);
            d.findElementClick("link", "快车");
            Thread.sleep(3000);
            d.findElementSendKeys("xpath", "//*[@id=\"express\"]/form/div[3]/div/input", fastPlateNum);
            Thread.sleep(3000);
            vehicle.clickSearchBtn();
            Thread.sleep(3000);

            if (vehicle.getFastPlateNum().equals(fastPlateNum)) {
                Logger.Output(LogType.LogTypeName.INFO, "快车新增成功,车牌号：" + fastPlateNum);
                Thread.sleep(3000);
                // 车辆详情查看
                d.findElementClick("xpath", "//*[@id=\"express_table\"]/tbody/tr[1]/td[8]/a[1]");
                Thread.sleep(2000);
                boolean flag = d.findElement("xpath", "//*[@id=\"page-wrapper\"]/div/div[2]/div[1]/div/h4").getText()
                        .contains(fastPlateNum);
                if (flag) {
                    Logger.Output(LogType.LogTypeName.INFO, "快车详情查看成功");
                    driver.navigate().back();
                    Thread.sleep(2000);
                    d.findElementClick("link", "快车");
                    Thread.sleep(2000);
                    //车辆修改
                    vehicle.clickFastUpdateBtn();
                    Thread.sleep(3000);
                    updateVehicle();
                    Thread.sleep(3000);


                } else {
                    Logger.Output(LogType.LogTypeName.ERROR, "快车详情查看失败");

                }
            } else {
                Logger.Output(LogType.LogTypeName.ERROR, "快车新增失败");
            }
        }
        if (carTypeName.equals("专车")) {
            vehicle.inputPlateNum(specPlateNum);
            vehicle.inputModel("奔驰");
            vehicle.inputBrand("德国");
            vehicle.inputCarColor("白色");
            vehicle.inputSeats("4");
            vehicle.selectAgentUuid(agent);
            Thread.sleep(3000);
            vehicle.selectCompanyUuid(companyName);
            Thread.sleep(3000);
            vehicle.selectcBusinessUuid(carTypeName);
            Thread.sleep(3000);
            vehicle.selectCarLevelUuid("舒适型");
            vehicle.inputOwnerName(ownerName);
            vehicle.inputOwnerNameMobile(ownerNameMobile);
            Thread.sleep(3000);
            vehicle.clickSubmitBtn();
            Thread.sleep(3000);
            d.findElementClick("link", "专车");
            Thread.sleep(3000);
            d.findElementSendKeys("xpath", "//*[@id=\"spec\"]/form/div[4]/div/input", specPlateNum);
            Thread.sleep(3000);
            vehicle.clickSearchBtn();
            Thread.sleep(3000);

            if (vehicle.getSpecPlateNum().equals(specPlateNum)) {
                Logger.Output(LogType.LogTypeName.INFO, "专车新增成功,车牌号：" + specPlateNum);
                Thread.sleep(3000);
                // 车辆详情查看
                d.findElementClick("xpath", "//*[@id=\"spec_table\"]/tbody/tr[1]/td[9]/a[1]");
                Thread.sleep(2000);
                boolean flag = d.findElement("xpath", "//*[@id=\"page-wrapper\"]/div/div[2]/div[1]/div/h4").getText()
                        .contains(specPlateNum);
                if (flag) {
                    Logger.Output(LogType.LogTypeName.INFO, "专车详情查看成功");
                    driver.navigate().back();
                    Thread.sleep(3000);
                    d.findElementClick("link", "专车");

                    //车辆修改
                    vehicle.clickSpecUpdateBtn();
                    Thread.sleep(3000);
                    updateVehicle();
                    Thread.sleep(3000);

                } else {
                    Logger.Output(LogType.LogTypeName.ERROR, "专车详情查看失败");

                }
            } else {
                Logger.Output(LogType.LogTypeName.ERROR, "专车新增失败");
            }

        }

    }

    //添加司机
    private void addDriver(String carTypeName) throws Exception {
        DriverManager driverManager = PageFactory.initElements(driver, DriverManager.class);
        ExcelUtil.setExcelFile(excelPath, "driver");
        Thread.sleep(5000);
        driverManager.clickAddBtn();
        Thread.sleep(3000);
        if (carTypeName.equals("快车")) {
            driverManager.inputName(fastDriverName);
            driverManager.inputIdCard(ExcelUtil.getCellAsString(3, 4));
            driverManager.inputMobile(fastDriverMobile);
        }
        if (carTypeName.equals("专车")) {
            driverManager.inputName(specDriverName);
            driverManager.inputIdCard(ExcelUtil.getCellAsString(3, 4));
            driverManager.inputMobile(specDriverMobile);
        }
        if (carTypeName.equals("出租车")) {
            driverManager.inputName(taxiDriverName);
            driverManager.inputIdCard(ExcelUtil.getCellAsString(3, 4));
            driverManager.inputMobile(taxiDriverMobile);

        }
        driverManager.uploadFaceFile(ExcelUtil.getCellAsString(5, 4));
        driverManager.selectAgent(agent);
        driverManager.selectCompany(companyName);
        driverManager.selectCity(cityName);
        Thread.sleep(3000);
        driverManager.selectBusiness(carTypeName);
        Thread.sleep(3000);
        driverManager.clickSubmitBtn();
        Thread.sleep(5000);
        driverManager.clickBingding();
        Thread.sleep(3000);
        if (carTypeName.equals("快车")) {
            driverManager.inputPlateNum(fastPlateNum);

        }
        if (carTypeName.equals("专车")) {
            driverManager.inputPlateNum(specPlateNum);

        }
        if (carTypeName.equals("出租车")) {
            driverManager.inputPlateNum(taxiPlateNum);

        }
        driverManager.clickCarInfoBtn();
        Thread.sleep(3000);
        //点击绑定
        driverManager.clickSubmitBtn();
        d.getMessage();
    }

    //修改司机（新增非必录项）
    private void updateDriver(String type) throws Exception {
        DriverManager driverManager = PageFactory.initElements(driver, DriverManager.class);
        ExcelUtil.setExcelFile(excelPath, "driver");
        Thread.sleep(3000);
        int colNum = 4;
        if (type.equals("出租车")) {
            Thread.sleep(2000);
            driverManager.clickTaxiUpdateBtn();
            Thread.sleep(3000);
            driverManager.clickDownBtn();
        }
        if (type.equals("专车")) {
            driverManager.clickSpecUpdateBtn();
            Thread.sleep(3000);
            driverManager.clickDownBtn();
        }
        if (type.equals("快车")) {
            driverManager.clickFastdateBtn();
            Thread.sleep(3000);
            driverManager.clickDownBtn();
        }

        /**
         *     录入司机信息的非必录项
         */

//        选择性别
        driverManager.selectSex(ExcelUtil.getCellAsString(17, colNum));
//        输入联系地址
        driverManager.inputDriverContactAddress(ExcelUtil.getCellAsString(18, colNum));
//        上传身份证正面
        driverManager.uploadIdCard(ExcelUtil.getCellAsString(19, colNum));
//        上传身份证背面
        driverManager.uploadIdCardBack(ExcelUtil.getCellAsString(20, colNum));
//        上传手持身份证
        driverManager.uploadIdCardImg(ExcelUtil.getCellAsString(21, colNum));
//        输入分组信息
        driverManager.inputDriverNo(ExcelUtil.getCellAsNumber(22, colNum));
//        输入驾驶证号
        driverManager.inputLicenseId(ExcelUtil.getCellAsString(23, colNum));
//        上传驾驶证正面
        driverManager.uploadDrivingLicenceHomeImgFile(ExcelUtil.getCellAsString(24, colNum));
//        上传驾驶证反面
        driverManager.uploadDrivingLicenceSubImgFile(ExcelUtil.getCellAsString(25, colNum));
//        上传驾驶证pdf
        driverManager.uploadDrivingLicencePDFFile(ExcelUtil.getCellAsString(26, colNum));
//        选择准驾车型
        driverManager.selectDriverType(ExcelUtil.getCellAsString(27, colNum));
//        选择初次领证日期
        driverManager.selectDriverLicenseDate(ExcelUtil.getCellAsDate(28, colNum));
//        选择驾驶证有效期起
        driverManager.selectDriverLicenseOn(ExcelUtil.getCellAsDate(29, colNum));
//        选择驾驶证有效期止
        driverManager.selectDriverLicenseOff(ExcelUtil.getCellAsDate(30, colNum));
//        输入交通违章次数
        driverManager.inputTrafficViolationsCount(ExcelUtil.getCellAsNumber(31, colNum));
//        输入交通事故次数
        driverManager.inputTrafficAccidentCount(ExcelUtil.getCellAsNumber(32, colNum));
//        输入网络资格证号
        driverManager.inputCertificateNo(ExcelUtil.getCellAsString(33, colNum));
//        输入发证机构
        driverManager.inputNetworkCarIssueOrganization(ExcelUtil.getCellAsString(34, colNum));
//        选择发证日期
        driverManager.selectNetworkCarIssueDate(ExcelUtil.getCellAsDate(35, colNum));
//        选择初次领证日期
        driverManager.selectNetworkCarProofDate(ExcelUtil.getCellAsDate(36, colNum));
//        选择有效期起
        driverManager.selectNetworkCarProofOn(ExcelUtil.getCellAsDate(37, colNum));
//        选择有效期止
        driverManager.selectNetworkCarProofOff(ExcelUtil.getCellAsDate(38, colNum));
//        选择报备日期
        driverManager.selectRegisterDate(ExcelUtil.getCellAsDate(39, colNum));
//        选择服务类型
        driverManager.selectCommercialType(ExcelUtil.getCellAsString(40, colNum));
//        输入签署公司
        driverManager.inputContractCompany(ExcelUtil.getCellAsString(41, colNum));
//        选择合同签订日期
        driverManager.selectContractSign(ExcelUtil.getCellAsDate(42, colNum));
//        选择合同有效期起
        driverManager.selectContractOn(ExcelUtil.getCellAsDate(43, colNum));
//        选择合同有效期止
        driverManager.selectContractOff(ExcelUtil.getCellAsDate(44, colNum));
//        上传合同扫描
        driverManager.uploadContractPhotoPDFFile(ExcelUtil.getCellAsString(45, colNum));
//        选择合同类型
        driverManager.selectContractType(ExcelUtil.getCellAsString(46, colNum));
//        选择培训类型
        driverManager.selectType(ExcelUtil.getCellAsString(47, colNum));
//        输入培训课程名称
        driverManager.inputCourseName(ExcelUtil.getCellAsString(48, colNum));
//        选择培训课程日期
        driverManager.selectCourseDate(ExcelUtil.getCellAsDate(49, colNum));
//                选择培训开始时间
        driverManager.selectStartTime(ExcelUtil.getCellAsDate(50, colNum));
//                选择培训结束时间
        driverManager.selectStopTime(ExcelUtil.getCellAsDate(51, colNum));
//                输入培训时长
        driverManager.inputDuration(ExcelUtil.getCellAsNumber(52, colNum));
//                输入户名
        driverManager.inputBankAccountName(ExcelUtil.getCellAsString(53, colNum));
//                输入账号
        driverManager.inputBankAccount(ExcelUtil.getCellAsString(54, colNum));
//                输入银行
        driverManager.inputBankName(ExcelUtil.getCellAsString(55, colNum));
//                输入银行地址
        driverManager.inputBankAddress(ExcelUtil.getCellAsString(56, colNum));
//                上传银行照片
        driverManager.uploadBankPhotoFile(ExcelUtil.getCellAsString(57, colNum));
//                上传体检报告
        driverManager.uploadExaminateReportPDFFile(ExcelUtil.getCellAsString(58, colNum));
//                选择民族
        driverManager.selectDriverNation(ExcelUtil.getCellAsString(59, colNum));
//                选择婚姻状况
        driverManager.selectDriverMaritalStatus(ExcelUtil.getCellAsString(60, colNum));
//                选择外语能力
        driverManager.selectDriverLanguageLevel(ExcelUtil.getCellAsString(61, colNum));
//                选择学历
        driverManager.selectDriverEducation(ExcelUtil.getCellAsString(62, colNum));
//                输入户口登记机关
        driverManager.inputDriverCensus(ExcelUtil.getCellAsString(63, colNum));
//                输入户口住址
        driverManager.inputDriverAddress(ExcelUtil.getCellAsString(64, colNum));
//                输入紧急联系人
        driverManager.inputEmergencyContact(ExcelUtil.getCellAsString(65, colNum));

//                输入联系电话
        driverManager.inputEmergencyContactPhone(ExcelUtil.getCellAsString(66, colNum));
//                输入地址
        driverManager.inputEmergencyContactAddress(ExcelUtil.getCellAsString(67, colNum));
        Thread.sleep(3000);
        driverManager.clickSubmitBtn();
        d.getMessage();
        Thread.sleep(2000);
        driverManager.clickBingding();
//        //封号处理
//        if (type.equals("出租车")) {
//            Thread.sleep(2000);
//            d.findElementClick("link","出租车");
//            driverManager.clickChangeStatus();
//        }
//        if (type.equals("专车")) {
//            Thread.sleep(2000);
//            d.findElementClick("link","专车");
//            driverManager.clickChangeStatus();
//
//        }
//        if (type.equals("快车")) {
//            Thread.sleep(2000);
//            d.findElementClick("link","快车");
//            driverManager.clickChangeStatus();
//        }



    }

    @Test
    //司机管理
    public void driverManager() throws Exception {
        Thread.sleep(3000);
        d.findElementClick("link", "营运管理中心");
        Thread.sleep(3000);
        d.findElementClick("link", "司机管理");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //ProjectTyp:约约（执行快车专车出租车）：易行通（出租车）；其他（快车、专车）
        String projectType = MyWebdriver.ProjectType;
        //开通出租车、专车、快车业务下的司機
        switch (projectType) {
            case "约约":
                d.findElementClick("link", "出租车");
                addDriver("出租车");
                //修改司机操作（新增非必录项）
                updateDriver("出租车");
                Thread.sleep(3000);
                d.findElementClick("link", "快车");
                addDriver("快车");
                updateDriver("快车");
                Thread.sleep(3000);
                d.findElementClick("link", "专车");
                addDriver("专车");
                updateDriver("专车");
                break;
            case "易行通":
                d.findElementClick("link", "出租车");
                addDriver("出租车");
                //修改司机操作（新增非必录项）
                updateDriver("出租车");

                break;
            default:
                Thread.sleep(3000);
                d.findElementClick("link", "快车");
                addDriver("快车");
                updateDriver("快车");
                Thread.sleep(3000);
                d.findElementClick("link", "专车");
                addDriver("专车");
                updateDriver("专车");
                break;
        }
    }

    @Test
    //车辆管理
    public void vehicleManager() throws Exception {
        Thread.sleep(3000);
        d.findElementClick("link", "车辆管理");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //ProjectTyp:约约（执行快车专车出租车）：易行通（出租车）；其他（快车、专车）
        String projectType = MyWebdriver.ProjectType;
        //开通出租车、专车、快车业务
        switch (projectType) {
            case "约约":
                d.findElementClick("link", "出租车");
                addVehicle("出租车");
                Thread.sleep(3000);
                d.findElementClick("link", "快车");
                addVehicle("快车");
                Thread.sleep(3000);
                d.findElementClick("link", "专车");
                addVehicle("专车");
                break;
            case "易行通":
                d.findElementClick("link", "出租车");
                addVehicle("出租车");
                break;
            default:
                Thread.sleep(3000);
                d.findElementClick("link", "快车");
                addVehicle("快车");
                Thread.sleep(3000);
                d.findElementClick("link", "专车");
                addVehicle("专车");
                break;
        }
    }

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        Thread.sleep(3000);
        d.findElementClick("link", "营运管理中心");
        Logger.Output(LogType.LogTypeName.INFO, "===============================================");

    }
    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
