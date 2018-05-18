package com.summersoft.ctt.yycx.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DriverManager {
    //司機管理新增按钮
    @FindBy(linkText = "新增")
    private WebElement addBtn;


    public  void clickAddBtn()
    {
        addBtn.click();
    }
   // 输入姓名
    @FindBy(name="name")
    private  WebElement name;
    public void inputName(String str)
    {
        name.sendKeys(str);
    }
    //输入身份证
    @FindBy(id="idCard")
    private  WebElement idCard;
    public  void inputIdCard(String str)
    {
        idCard.sendKeys(str);
    }
   // 输入联系电话
    @FindBy(name="mobile")
    private  WebElement mobile;
    public void inputMobile(String str)
    {
        mobile.sendKeys(str);
    }

    //上传头像
    @FindBy(id="faceFile")
    private  WebElement faceFile;
    public   void uploadFaceFile(String str)
    {
        faceFile.sendKeys(str);
    }
   // 选择所属代理
    @FindBy(id="agentUuid")
    private WebElement agent;
    public  void selectAgent(String str)
    {
        Select sel=new Select(agent);
        sel.selectByVisibleText(str);

    }
    //选择所属公司
    @FindBy(id="companyUuid")
    private  WebElement company;
    public void selectCompany(String str)
    {
        Select sel=new Select(company);
        sel.selectByVisibleText(str);
    }
   // 选择所属城市
    @FindBy(id="cityUuid")
    private  WebElement city;
    public void selectCity(String str)
    {
        Select sel=new Select(city);
        sel.selectByVisibleText(str);
    }
   // 选择所属业务
    @FindBy(id="businessUuid")
    private  WebElement business;
    public void selectBusiness(String str )
    {
        Select sel=new Select(business);
        sel.selectByVisibleText(str);
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
    //点击去绑定车辆
    @FindBy(className="btn-determine")
    private  WebElement bingding;
    public  void clickBingding()
    {
        bingding.click();
    }
   // 输入车辆车牌号
    @FindBy( id="plateNum")
    private  WebElement plateNum;
    public  void inputPlateNum(String str)
    {
        plateNum.sendKeys(str);
    }
    //点击获取车辆信息
    @FindBy(className = "btn-default")
    private  WebElement getCarInfoBtn;
    public  void clickCarInfoBtn()
    {
        getCarInfoBtn.click();

    }

    /**
     * 司机的其他非必录项
     */
//    选择性别	
@FindBy(id="sex")
private WebElement sex;
public  void selectSex(String str)
{
   Select sel=new Select(sex);
   sel.selectByVisibleText(str);
}
//    输入联系地址	
@FindBy(name="driverContactAddress")
private WebElement driverContactAddress;
    public  void inputDriverContactAddress(String str)
    {
        driverContactAddress.sendKeys(str);
    }
//    上传身份证正面	
@FindBy(id="idCardFaceImgFile")
private WebElement idCardFace;
    public void uploadIdCard(String str)
    {
        idCardFace.sendKeys(str);
    }
//    上传身份证背面	
@FindBy(id="idCardBackImgFile")
private WebElement idCardBack;
    public void uploadIdCardBack(String str)
    {
        idCardBack.sendKeys(str);
    }
//    上传手持身份证	
@FindBy(id="driverIdCardImgFile")
private WebElement idCardImg;
    public void uploadIdCardImg(String str)
    {
        idCardImg.sendKeys(str);
    }

//    输入分组信息	
@FindBy(name="driverNo")
private WebElement  driverNo;
    public void inputDriverNo(String str)
    {
        driverNo.sendKeys(str);
    }

//    输入驾驶证号	
@FindBy(id="licenseId")
private WebElement  licenseId;
    public void inputLicenseId(String str)
    {
        licenseId.sendKeys(str);
    }
//    上传驾驶证正面	
@FindBy(id="drivingLicenceHomeImgFile")
private WebElement drivingLicenceHomeImgFile;
    public void uploadDrivingLicenceHomeImgFile(String str)
    {
        drivingLicenceHomeImgFile.sendKeys(str);
    }

//    上传驾驶证反面	
@FindBy(id="drivingLicenceSubImgFile")
private WebElement drivingLicenceSubImgFile;
    public void uploadDrivingLicenceSubImgFile(String str)
    {
        drivingLicenceSubImgFile.sendKeys(str);
    }
//    上传驾驶证pdf	 
@FindBy(id="drivingLicencePDFFile")
private WebElement drivingLicencePDFFile;
    public void uploadDrivingLicencePDFFile(String str)
    {
        drivingLicencePDFFile.sendKeys(str);
    }
//    选择准驾车型	 
@FindBy(id="driverType")
private WebElement driverType;
    public  void selectDriverType(String str)
    {
        Select sel=new Select(driverType);
        sel.selectByVisibleText(str);
    }
//    选择初次领证日期	 
@FindBy(id="getDriverLicenseDate")
private WebElement driverLicenseDate;
    public  void selectDriverLicenseDate(String str)
    {
       driverLicenseDate.sendKeys(str);
    }
//    选择驾驶证有效期起	
@FindBy(id="driverLicenseOn")
private WebElement driverLicenseOn;
    public  void selectDriverLicenseOn(String str)
    {
      driverLicenseOn.sendKeys(str);
    }
//    选择驾驶证有效期止	
@FindBy(id="driverLicenseOff")
private WebElement driverLicenseOff;
    public  void selectDriverLicenseOff(String str)
    {
        driverLicenseOff.sendKeys(str);
    }
//    输入交通违章次数	 
@FindBy(name="trafficViolationsCount")
private WebElement  trafficViolationsCount;
    public void inputTrafficViolationsCount(String str)
    {
        trafficViolationsCount.sendKeys(str);
    }
//    输入交通事故次数
@FindBy(name="trafficAccidentCount")
private WebElement  trafficAccidentCount;
    public void inputTrafficAccidentCount(String str)
    {
        trafficAccidentCount.sendKeys(str);
    }
//    输入网络资格证号	 
@FindBy(name="certificateNo")
private WebElement certificateNo;
    public void inputCertificateNo(String str)
    {
        certificateNo.sendKeys(str);
    }

//    输入发证机构	 
@FindBy(name="networkCarIssueOrganization")
private WebElement networkCarIssueOrganization;
    public void inputNetworkCarIssueOrganization(String str)
    {
        networkCarIssueOrganization.sendKeys(str);
    }
//    选择发证日期	 
@FindBy(id="networkCarIssueDate")
private WebElement networkCarIssueDate;
    public  void selectNetworkCarIssueDate(String str)
    {
        networkCarIssueDate.sendKeys(str);
    }

//    选择初次领证日期	 
@FindBy(id="getNetworkCarProofDate")
private WebElement networkCaProofDate;
    public  void selectNetworkCarProofDate(String str)
    {
        networkCaProofDate.sendKeys(str);
    }

//    选择有效期起	 
@FindBy(id="networkCarProofOn")
private WebElement networkCarProofOn;
    public  void selectNetworkCarProofOn(String str)
    {
        networkCarProofOn.sendKeys(str);
    }
//    选择有效期止	 
@FindBy(id="networkCarProofOff")
private WebElement networkCarProofOff;
    public  void selectNetworkCarProofOff(String str)
    {
        networkCarProofOff.sendKeys(str);
    }
//    选择报备日期	 
@FindBy(id="registerDate")
private WebElement registerDate;
    public  void selectRegisterDate(String str)
    {
       registerDate.sendKeys(str);
    }
//    选择服务类型	 
@FindBy(id="commercialType")
private WebElement commercialType;
    public  void selectCommercialType(String str)
    {
        Select sel=new Select(commercialType);
        sel.selectByVisibleText(str);
    }
//    输入签署公司	 
@FindBy(name="contractCompany")
private WebElement contractCompany;
    public void inputContractCompany(String str)
    {
        contractCompany.sendKeys(str);
    }
//    选择合同签订日期	 
@FindBy(id="contractSign")
private WebElement contractSign;
    public  void selectContractSign(String str)
    {
        contractSign.sendKeys(str);
    }

//    选择合同有效期起	 
@FindBy(id="contractOn")
private WebElement contractOn;
    public  void selectContractOn(String str)
    {
        contractOn.sendKeys(str);
    }
//    选择合同有效期止	
@FindBy(id="contractOff")
private WebElement contractOff;
    public  void selectContractOff(String str)
    {
       contractOff.sendKeys(str);
    }
//    上传合同扫描	 
@FindBy(id="contractPhotoPDFFile")
private WebElement contractPhotoPDFFile;
    public  void uploadContractPhotoPDFFile(String str)
    {
        contractPhotoPDFFile.sendKeys(str);

    }
//    选择合同类型	 
@FindBy(id="contractType")
private WebElement contractType;
    public  void selectContractType(String str)
    {
        Select sel=new Select(contractType);
        sel.selectByVisibleText(str);
    }
//    选择培训类型	 
@FindBy(name="driverTrainDtoList[0].type")
private WebElement type;
    public  void selectType(String str)
    {
        Select sel=new Select(type);
        sel.selectByVisibleText(str);
    }
//    输入培训课程名称	 
@FindBy(name="driverTrainDtoList[0].courseName")
private WebElement courseName;
    public void inputCourseName(String str)
    {
        courseName.sendKeys(str);
    }
//选择培训课程日期
    @FindBy(name="driverTrainDtoList[0].courseDate")
    private  WebElement courseDate;
    public void  selectCourseDate(String str)
    {
        courseDate.sendKeys(str);
    }
   // 选择培训开始时间
 @FindBy(name="driverTrainDtoList[0].startTime")
 private  WebElement startTime;
    public void  selectStartTime(String str)
    {
        startTime.sendKeys(str);
    }

   // 选择培训结束时间
@FindBy(name="driverTrainDtoList[0].stopTime")
private  WebElement stopTime;
    public void  selectStopTime(String str)
    {
        stopTime.sendKeys(str);
    }
//    输入培训时长
@FindBy(name="driverTrainDtoList[0].duration")
private WebElement duration;
    public void inputDuration(String str)
    {
        duration.sendKeys(str);
    }
//    输入户名
@FindBy(name="bankAccountName")
private WebElement bankAccountName;
    public void inputBankAccountName(String str)
    {
        bankAccountName.sendKeys(str);
    }
//    输入账号
@FindBy(name="bankAccount")
private WebElement bankAccount;
    public void inputBankAccount(String str)
    {
        bankAccount.sendKeys(str);
    }
//    输入银行
@FindBy(name="bankName")
private WebElement bankName;
    public void inputBankName(String str)
    {
        bankName.sendKeys(str);
    }
//    输入银行地址
@FindBy(name="bankAddress")
private WebElement bankAddress;
    public void inputBankAddress(String str)
    {
        bankAddress.sendKeys(str);
    }
//    上传银行照片
 @FindBy(id="bankPhotoFile")
 private  WebElement bankPhotoFile;
    public void uploadBankPhotoFile(String str)
    {
        bankPhotoFile.sendKeys(str);
    }
//    上传体检报告
@FindBy(id="examinateReportPDFFile")
private  WebElement examinateReportPDFFile;
    public void uploadExaminateReportPDFFile(String str)
    {
        examinateReportPDFFile.sendKeys(str);
    }

//    选择民族
@FindBy(id="driverNation")
private WebElement driverNation;
    public  void selectDriverNation(String str)
    {
        Select sel=new Select(driverNation);
        sel.selectByVisibleText(str);
    }
//    选择婚姻状况
@FindBy(id="driverMaritalStatus")
private WebElement driverMaritalStatus;
    public  void selectDriverMaritalStatus(String str)
    {
        Select sel=new Select(driverMaritalStatus);
        sel.selectByVisibleText(str);
    }
//    选择外语能力
@FindBy(id="driverLanguageLevel")
private WebElement driverLanguageLevel;
    public  void selectDriverLanguageLevel(String str)
    {
        Select sel=new Select(driverLanguageLevel);
        sel.selectByVisibleText(str);
    }
//    选择学历
@FindBy(id="driverEducation")
private WebElement driverEducation;
    public  void selectDriverEducation(String str)
    {
        Select sel=new Select(driverEducation);
        sel.selectByVisibleText(str);
    }

//    输入户口登记机关
@FindBy(name="driverCensus")
private WebElement driverCensus;
    public void inputDriverCensus(String str)
    {
        driverCensus.sendKeys(str);
    }
//    输入户口住址
@FindBy(name="driverAddress")
private WebElement driverAddress;
    public void inputDriverAddress(String str)
    {
        driverAddress.sendKeys(str);
    }
//    输入紧急联系人
 @FindBy(name="emergencyContact")
 private WebElement emergencyContact;
    public void inputEmergencyContact(String str)
    {
        emergencyContact.sendKeys(str);
    }
//    输入联系电话
@FindBy(name="emergencyContactPhone")
private WebElement emergencyContactPhone;
    public void inputEmergencyContactPhone(String str)
    {
        emergencyContactPhone.sendKeys(str);
    }
//    输入地址
@FindBy(name="emergencyContactAddress")
private WebElement emergencyContactAddress;
    public void inputEmergencyContactAddress(String str)
    {
        emergencyContactAddress.sendKeys(str);
    }
    //出租车列表修改按钮
    @FindBy(xpath = "//*[@id=\"taxiDriver_table\"]/tbody/tr[1]/td[12]/a[2]")
    private  WebElement taxiUpdateBtn;
    public  void clickTaxiUpdateBtn()
    {
        taxiUpdateBtn.click();
    }
    //专车列表修改按钮
    @FindBy(xpath = "//*[@id=\"specDriver_table\"]/tbody/tr[1]/td[12]/a[2]")
    private  WebElement specUpdateBtn;
    public  void clickSpecUpdateBtn()
    {
        specUpdateBtn.click();
    }
    //快车列表修改按钮
    @FindBy(xpath = "//*[@id=\"expressDriver_table\"]/tbody/tr[1]/td[12]/a[2]")
    private  WebElement fastUpdateBtn;
    public  void clickFastdateBtn()
    {
        fastUpdateBtn.click();
    }
    //封号
    @FindBy(xpath = "//*[@id=\"changeStatus\"]")
    private  WebElement changeStatus;
    public  void clickChangeStatus()
    {
        changeStatus.click();
    }







}
