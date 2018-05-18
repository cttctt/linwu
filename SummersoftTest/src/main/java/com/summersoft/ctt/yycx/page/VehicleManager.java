package com.summersoft.ctt.yycx.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class VehicleManager {
    //车辆管理新增按钮
    @FindBy(linkText = "新增")
    private WebElement addBtn;
    public  void clickAddBtn()
    {
        addBtn.click();
    }

    // 输入车牌号
    @FindBy(id="plateNum")
    private  WebElement plateNum;
    public void inputPlateNum(String  str)
    {
        plateNum.sendKeys(str);
    }
    // 车辆型号
    @FindBy(name="model")
    private  WebElement model;
    public void inputModel(String str)
    {
        model.sendKeys(str);
    }

    //车辆厂牌
    @FindBy(name="brand")
    private  WebElement brand;
    public  void inputBrand(String str)
    {
        brand.sendKeys(str);
    }

    //车身颜色
    @FindBy( name="carColor")
    private  WebElement carColor;
    public void inputCarColor(String str)
    {
        carColor.sendKeys(str);
    }

    // 核定载客位
    @FindBy(name="seats")
    private  WebElement seats;
    public  void inputSeats(String str)
    {
        seats.sendKeys(str);
    }

    //选择所属代理
    @FindBy( name="agentUuid")
    private  WebElement agentUuid;
    public   void selectAgentUuid(String str)
    {
        Select sel=new Select(agentUuid);
        sel.selectByVisibleText(str);
    }

    // 选择所属公司
    @FindBy( name="companyUuid")
    private  WebElement companyUuid;
    public   void selectCompanyUuid(String str)
    {
        Select sel=new Select(companyUuid);
        sel.selectByVisibleText(str);
    }

    // 选择所属业务
    @FindBy( id="businessUuid")
    private  WebElement businessUuid;
    public  void selectcBusinessUuid(String str)
    {
        Select sel=new Select(businessUuid);
        sel.selectByVisibleText(str);
    }


    //选择级别类型
    @FindBy(id="carLevelUuid")
    private  WebElement carLevelUuid;
    public   void selectCarLevelUuid(String str)
    {
        Select sel=new Select(carLevelUuid);
        sel.selectByVisibleText(str);
    }

    //输入所属人
    @FindBy( name="ownerName")
    private  WebElement ownerName;
    public void inputOwnerName(String str)
    {
        ownerName.sendKeys(str);
    }

    // 输入所属人电话
    @FindBy(name="ownerNameMobile")
    private  WebElement ownerNameMobile;
    public void inputOwnerNameMobile(String str)
    {
        ownerNameMobile.sendKeys(str);
    }

    //展开按钮
    @FindBy(className ="info-title-down" )
    private  WebElement downBtn;
    public void clickDownBtn()
    {
        downBtn.click();
    }

    //保存按钮
    @FindBy(className = "btn-save")
    private  WebElement submitBtn;
    public  void clickSubmitBtn()
    {
        submitBtn.click();
    }
    //点击搜索按钮
    @FindBy(linkText = "搜索")
    private WebElement searchBtn;
    public  void clickSearchBtn()
    {
        searchBtn.click();


    }


    //出租车获取搜索表格第一列车牌号
    @FindBy(xpath = "//*[@id=\"taxi_table\"]/tbody/tr/td[1]")
    private  WebElement getLabelPlateNum;
    public  String   getTaxiPlateNum()
    {
        return  getLabelPlateNum.getText();
    }

    //专车获取搜索表格第一列车牌号
    @FindBy(xpath = "//*[@id=\"spec_table\"]/tbody/tr/td[1]")
    private  WebElement getLabelSecPlateNum;
    public  String   getSpecPlateNum()
    {
        return  getLabelSecPlateNum.getText();
    }
    //快车获取搜索表格第一列车牌号
    @FindBy(xpath ="//*[@id=\"express_table\"]/tbody/tr[1]/td[1]")
    private  WebElement getLabelFastPlateNum;
    public  String   getFastPlateNum()
    {
        return  getLabelFastPlateNum.getText();
    }
    //出租车列表第一行的修改按钮
    @FindBy(xpath = "//*[@id=\"taxi_table\"]/tbody/tr[1]/td[6]/a[2]")
    private  WebElement taxiUpdateBtn;
    public  void clickTaxiUpdateBtn()
    {
        taxiUpdateBtn.click();
    }
    //专车列表第一行的修改按钮
    @FindBy(xpath = "//*[@id=\"spec_table\"]/tbody/tr[1]/td[9]/a[2]")
    private  WebElement specUpdateBtn;
    public  void clickSpecUpdateBtn()
    {
        specUpdateBtn.click();
    }
    //快车列表第一行的修改按钮
    @FindBy(xpath = "//*[@id=\"express_table\"]/tbody/tr[1]/td[8]/a[2]")
    private  WebElement fastUpdateBtn;
    public  void clickFastUpdateBtn()
    {
        fastUpdateBtn.click();
    }



    /*
    车辆其他的非笔录项
     */
    //选择车辆颜色
    @FindBy(name="plateColor")
    private  WebElement plateColor;
    public  void selectPlateColor(String str)
    {
        Select sel=new Select(plateColor);
        sel.selectByVisibleText(str);
    }
    //上传车辆照片
    @FindBy(id="carImageFile")
    private  WebElement carImgFile;
    public  void uploadCarImgFile(String str)
    {
        carImgFile.sendKeys(str);

    }
    //上传车牌照片
    @FindBy(id="plateImageFile")
    private  WebElement plateImgFile;
    public  void uploadPlateImgFile(String str)
    {
        plateImgFile.sendKeys(str);

    }
    //行驶证下的车辆类型
    @FindBy(name="vehicleType")
    private  WebElement vehicleType;
    public  void inputVehicleType(String str)
    {
        vehicleType.sendKeys(str);
    }

    //上传行驶证照片
    @FindBy(id="drivingLicenseImgFile")
    private  WebElement drivingLicenseImgFile;
    public  void uploadDrivingLicenseImgFile(String str)
    {
        drivingLicenseImgFile.sendKeys(str);

    }

    //上传行驶证照片反面
    @FindBy(id="drivingLicenseSubImgFile")
    private  WebElement drivingLicenseSubImgFile;
    public  void uploadDrivingLicenseSubImgFile(String str)
    {
        drivingLicenseSubImgFile.sendKeys(str);

    }
    //发动机号
    @FindBy(name="engineId")
    private  WebElement engineId;
    public  void inputEngineId(String str)
    {
        engineId.sendKeys(str);
    }
    //车辆VIN码
    @FindBy(name="vin")
    private  WebElement vin;
    public  void inputVin(String str)
    {
        vin.sendKeys(str);
    }
    //选择车辆注册日期
    @FindBy(id="certifyDateA")
    private  WebElement certifyDateA;
    public  void selectCertifyDateA(String str)
    {
        certifyDateA.sendKeys(str);

    }
    //选择车辆发证日期
    @FindBy(name="drivingLicenseDate")
    private  WebElement drivingLicenseDate;
    public  void selectDrivingLicenseDate(String str)
    {
        drivingLicenseDate.sendKeys(str);

    }
    //运输证号
    @FindBy(name="certificate")
    private  WebElement certificate;
    public  void inputCertificate(String str)
    {
        certificate.sendKeys(str);
    }
    //发证机构
    @FindBy(name="transAgency")
    private  WebElement transAgency;
    public  void inputTransAgency(String str)
    {
        transAgency.sendKeys(str);
    }
    //经营区域
    @FindBy(name="transArea")
    private  WebElement transArea;
    public  void inputTransArea(String str)
    {
        transArea.sendKeys(str);
    }
    //选择有效日期起
    @FindBy(name="transDateStart")
    private  WebElement transDateStart;
    public  void selectTransDateStart(String str)
    {
        transDateStart.sendKeys(str);

    }

    //选择有效日期止

    @FindBy(name="transDateStop")
    private  WebElement transDateStop;
    public  void selectTransDateStop(String str)
    {
        transDateStop.sendKeys(str);

    }
    //选择等级日期
    @FindBy(name = "certifyDateB")
    private WebElement certifyDateB;
    public  void selectcertifyDateB(String str)
    {
        certifyDateB.sendKeys(str);
    }

    //选择报备日期
    @FindBy(name="registerDate")
    private  WebElement registerDate;
    public  void selectRegisterDate(String str)
    {
        registerDate.sendKeys(str);

    }
    //选择服务类型
    @FindBy(name="commercialType")
    private  WebElement commercialType;
    public void selectCommercialType(String str)
    {
        Select sel=new Select(commercialType);
        sel.selectByVisibleText(str);
    }

    //    保险公司
    @FindBy(name="carInsuranceList[0].insurCom")
    private  WebElement insurCom;
    public  void selectInsurCom(String str)
    {
        insurCom.sendKeys(str);

    }
    //    保险号
    @FindBy(name="carInsuranceList[0].insurNum")
    private  WebElement insurNum;
    public  void inputInsurNum(String str)
    {
        insurNum.sendKeys(str);

    }
    //    保险类型
    @FindBy(name="carInsuranceList[0].insurType")
    private  WebElement insurType;
    public  void inputInsurType(String str)
    {
        insurType.sendKeys(str);

    }
    //    保险金额
    @FindBy(name="carInsuranceList[0].insurCount")
    private  WebElement insurCount;
    public  void inputInsurCount(String str)
    {
        insurCount.sendKeys(str);

    }
    //    赔付额度
    @FindBy(name="carInsuranceList[0].insurLimit")
    private  WebElement insurLimit;
    public  void inputInsurLimit(String str)
    {
        insurLimit.sendKeys(str);

    }

    //    选择保险有效期起
    @FindBy(name="carInsuranceList[0].insurEff")
    private  WebElement insurEff;
    public  void selectInsurEff(String str)
    {
        insurEff.sendKeys(str);

    }
    //    选择保险有效期止
    @FindBy(name="carInsuranceList[0].insurExp")
    private  WebElement insurExp;
    public  void selectInsurExp(String str)
    {
        insurExp.sendKeys(str);

    }
    //    选择车辆燃料类型
    @FindBy(id="fuelType")
    private  WebElement fuelType;
    public void selectFuelType(String str)
    {
        Select sel=new Select(fuelType);
        sel.selectByVisibleText(str);
    }
    //    发动机排量
    @FindBy(name="engineDisplace")
    private  WebElement engineDisplace;
    public  void inputEngineDisplace(String str)
    {
        engineDisplace.sendKeys(str);

    }
    //    发动机功率
    @FindBy(name="enginePower")
    private  WebElement enginePower;
    public  void inputEnginePower(String str)
    {
        enginePower.sendKeys(str);

    }
    //    车辆轴距
    @FindBy(name="wheelbase")
    private  WebElement wheelbase;
    public  void inputWheelbase(String str)
    {
        wheelbase.sendKeys(str);

    }
    //    选择车辆检修状态
    @FindBy(name="fixState")
    private  WebElement fixState;
    public void selectFixState(String str)
    {
        Select sel=new Select(fixState);
        sel.selectByVisibleText(str);
    }
    //    选择下年检时间
    @FindBy(name="nextFixDate")
    private  WebElement nextFixDate;
    public  void selectNextFixDate(String str)
    {
        nextFixDate.sendKeys(str);

    }

    //    选择年度审验状态
    @FindBy(name="checkState")
    private  WebElement checkState;
    public void selectCheckState(String str)
    {
        Select sel=new Select(checkState);
        sel.selectByVisibleText(str);
    }
    //    选择年审时间
    @FindBy(id="checkDate")
    private  WebElement checkDate;
    public  void selectCheckDate(String str)
    {
        checkDate.sendKeys(str);

    }
    //    选择下次年审时间
    @FindBy(id="nextCheckDate")
    private  WebElement nextCheckDate;
    public  void selectNextCheckDate(String str)
    {
        nextCheckDate.sendKeys(str);

    }
    //    发票打印序列号
    @FindBy(name="feePrintId")
    private  WebElement feePrintId;
    public  void inputFeePrintId(String str)
    {
        feePrintId.sendKeys(str);

    }
    //    卫星定位装置品牌
    @FindBy(name="gpsBrand")
    private  WebElement gpsBrand;
    public  void inputGpsBrand(String str)
    {
        gpsBrand.sendKeys(str);

    }
    //    卫星定位装置型号
    @FindBy(name="gpsModel")
    private  WebElement gpsModel;
    public  void inputGpsModel(String str)
    {
        gpsModel.sendKeys(str);

    }
    //    卫星定位装置IMEI号
    @FindBy(name="gpsImei")
    private  WebElement gpsImei;
    public  void inputGpsImei(String str)
    {
        gpsImei.sendKeys(str);

    }

    //    选择安装日期
    @FindBy(name="gpsInstallDate")
    private  WebElement installDate;
    public  void selectInstallDate(String str)
    {
        installDate.sendKeys(str);

    }
    //    车辆技术状况
    @FindBy(name="vehicleTechnicalCondition")
    private  WebElement vehicleTechnicalCondition;
    public  void inputVehicleTechnicalCondition(String str)
    {
        vehicleTechnicalCondition.sendKeys(str);

    }

    //    安全性能情况
    @FindBy(name="safetyPerformance")
    private  WebElement safetyPerformance;
    public  void inputSafetyPerformance(String str)
    {
        safetyPerformance.sendKeys(str);

    }







}
