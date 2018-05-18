package com.summersoft.ctt.yycx.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PlatformInformation {
    //    基本信息
    //编辑按钮
    @FindBy(className= "info-title-edit")
    private List<WebElement> editBtnList;
    //输入公司标识
    @FindBy(name="companyId")
    private   WebElement companyId;
    // 输入公司名称
    @FindBy(name="companyName")
    private  WebElement companyName;
    // 输入联系电话
    @FindBy(name="contactPhone")
    private  WebElement phone;
    // 输入统一信用代码
    @FindBy( name="identifier")
    private  WebElement identify;
    // 选择省
    @FindBy(name="provinceID")
    private  WebElement province;
    //选择市
    @FindBy(name="address")
    private  WebElement city;
    //输入通讯地址
    @FindBy(name="contactAddress")
    private WebElement address;
    // 输入经营范围
    @FindBy(name="businessScope")
    private  WebElement scope;
    // 输入营业户经济类型
    @FindBy(name="economicType")
    private  WebElement type;
    // 输入注册资金
    @FindBy(name="regCapital")
    private  WebElement total;
    // 输入法人代表
    @FindBy(name="legalName")
    private  WebElement legalName;
    // 输入法人电话
    @FindBy(name="legalPhone")
    private  WebElement legalPhone;
    // 输入法人身份证
    @FindBy(name="legalId")
    private  WebElement legalId;
    // 上传法人身份证件扫描
    @FindBy(name="legalJpgPhotoFile")
    private  WebElement file;
    // 输入平台联系人姓名
    @FindBy(name="contact")
    private  WebElement contact;
    // 输入平台联系人电话
    @FindBy(name="contactWay")
    private  WebElement contanctWay;
    // 点击保存
    @FindBy(className="btn-save")
    private  List<WebElement> saveBtnList;
    //投资人信息
    @FindBy(name="investerName")
    private WebElement investerName;
    //投资人证件类型
    @FindBy(name="invIdType")
    private  WebElement invidType;
    //投资人证件号码
    @FindBy(name="invIdCode")
    private  WebElement invidCode;
    //投资多少钱
    @FindBy(name="money")
    private  WebElement money;
    //支付机构名称
    @FindBy(name="payName")
    private  WebElement payName;
    //支付证
    @FindBy(name="payId")
    private  WebElement payId;
    //支付类型
    @FindBy(name="payType")
    private  WebElement payType;
    //支付范围
    @FindBy(name="payScope")
    private  WebElement payScope;
    //备存金银行
    @FindBy(name="prepareBank")
    private  WebElement prepareBank;
    //结算周期
    @FindBy(name="countDate")
    private  WebElement countDate;

    //服务机构名称
    @FindBy(name="serviceName")
    private  WebElement serviceName;
    //服务机构代码
    @FindBy(name="serviceNo")
    private  WebElement serviceNo;
    //成立时间
    @FindBy(name="createDate")
    private  WebElement createDate;
    //联系电话
    @FindBy(name = "contactPhone")
    private  WebElement contactPhone;
    //联系地址
    @FindBy(name="detailAddress")
    private  WebElement detailAddress;
    //负责人
    @FindBy(name = "responsibleName")
    private  WebElement responsibleName;
    //负责人联系电话
    @FindBy(name = "responsiblePhone")
    private  WebElement responsiblePhone;
    //管理员姓名
    @FindBy(name="managerName")
    private  WebElement managerName;
    //管理员联系方式
    @FindBy(name = "managerPhone")
    private  WebElement managerPhone;
    //邮寄地址
    @FindBy(name ="mailAddress" )
    private  WebElement mailAddress;

    //网络经营许可证号：
    @FindBy(name="certificate")
    private  WebElement certificate;
    // 经营范围
    @FindBy(name="operationArea")
    private  WebElement operationArea;
    // 业务名称
    @FindBy(name = "ownerName")
    private WebElement ownerName;
    // 发证机构：
    @FindBy(name="organization")
    private  WebElement organization;







    //输入服务机构名称
    public void inputServiceName(String str)
    {
        serviceName.clear();
        serviceName.sendKeys(str);
    }
    public String getServiceName()
    {
        return   serviceName.getAttribute("value");
    }
    //输入服务机构代码
    public void inputServiceId(String str)
    {
        serviceNo.clear();
        serviceNo.sendKeys(str);
    }
    //选择成立时间
    public void selectCreateDate(String str)
    {
        createDate.sendKeys(str);
    }
    //输入联系方式
    public void inputContactPhone(String str)
    {
        contactPhone.sendKeys(str);
    }

    //输入联系地址
    public void inputDetailAddress(String str)
    {
        detailAddress.clear();
        detailAddress.sendKeys(str);
    }
    //输入负责人
    public void inputResponsibleName(String str)
    {
        responsibleName.clear();
        responsibleName.sendKeys(str);
    }
    //输入联系方式
    public void inputResponsiblePhone(String str)
    {
        responsiblePhone.clear();
        responsiblePhone.sendKeys(str);
    }














    //点击编辑按钮
    public void clickEditBtn(int i)
    {
        editBtnList.get(i).click();
        //  editBtn.click();
    }
    public String  getCompanyId()
    {
        return companyId.getAttribute("value");
    }
    //输入公司标识
    public  void inputCompanyId(String str)
    {
        companyId.clear();
        companyId.sendKeys(str);
    }
    // 输入公司名称
    public  void inputCompanyName(String str)
    {
        companyName.clear();
        companyName.sendKeys(str);
    }
    // 输入联系电话
    public  void inputPhone(String str)
    {
        phone.clear();
        phone.sendKeys(str);
    }
    // 输入统一信用代码
    public  void inputIdentity(String str)
    {
        identify.clear();
        identify.sendKeys(str);
    }
    // 选择省
    public void selectProvince(String str)
    {
        Select sel=new Select(province);
        sel.selectByVisibleText(str);
    }
    //选择市
    public void selectCity(String str)
    {
        Select sel=new Select(city);
        sel.selectByVisibleText(str);
    }
    //输入通讯地址
    public  void inputContactAddress(String str)
    {
        address.clear();
        address.sendKeys(str);
    }

    // 输入经营范围
    public  void inputScope(String str)
    {
        scope.clear();
        scope.sendKeys(str);
    }
    // 输入营业户经济类型
    public  void inputType(String str)
    {
        type.clear();
        type.sendKeys(str);
    }
    // 输入注册资金
    public  void inputTotal(String str)
    {
        total.clear();
        total.sendKeys(str);
    }
    // 输入法人代表
    public  void inputLegalName(String str)
    {
        legalName.clear();
        legalName.sendKeys(str);
    }
    // 输入法人电话
    public  void inputLegalPhone(String str)
    {
        legalPhone.clear();
        legalPhone.sendKeys(str);
    }
    // 输入法人身份证
    public  void inputLegalId(String str)
    {
        legalId.clear();
        legalId.sendKeys(str);
    }

    // 上传法人身份证件扫描

    public  void uploadFile(String str)
    {
        file.sendKeys(str);
    }
    // 输入平台联系人姓名
    public  void inputContact(String str)
    {
        contact.clear();
        contact.sendKeys(str);
    }
    // 输入平台联系人电话
    public  void inputContactWay(String str)
    {
        contanctWay.clear();
        contanctWay.sendKeys(str);
    }
    // 点击保存
    public void clickSaveBtn(int i)
    {
        saveBtnList.get(i).click();

    }
    public String getInvestorName()
    {
        return  investerName.getAttribute("value");
    }
    //输入投资人姓名
    public void inputInvestorName(String str)
    {
        investerName.clear();
        investerName.sendKeys(str);
    }
    //选择投资人证件类型
    public void selectInvildType()
    {
        Select sel=new Select(invidType);
        sel.selectByVisibleText("统一社会信用代码");
    }
    //输入投资人证件号码
    public void inputInvildCode(String str)
    {
        invidCode.clear();
        invidCode.sendKeys(str);
    }
    //
    public  void inputMoney(String str)
    {
        money.clear();
        money.sendKeys(str);
    }
    //输入机构名称
    public  void inputPayName(String str)
    {
        payName.clear();
        payName.sendKeys(str);
    }
    public String getPayName()
    {
        return payName.getAttribute("value");
    }
    //输入机构证
    public  void inputPayId(String str)
    {
        payId.clear();
        payId.sendKeys(str);
    }
    //输入机构类型
    public  void inputPayType(String str)
    {
        payType.clear();
        payType.sendKeys(str);
    }
    //输入机构范围
    public  void inputPayScope(String str)
    {
        payScope.clear();
        payScope.sendKeys(str);
    }
    //输入备存金银行
    public  void inputPrepareBank(String str)
    {
        prepareBank.clear();
        prepareBank.sendKeys(str);
    }
    //输入结算周期
    public  void inputcountDate(String str)
    {
        countDate.clear();
        countDate.sendKeys(str);
    }
    //输入管理员姓名
    public void inputManagerName(String str)
    {
        managerName.clear();
        managerName.sendKeys(str);
    }
    public void inputManagerPhone(String  str)
    {
        managerPhone.clear();
        managerPhone.sendKeys(str);
    }
    //输入邮寄地址
    public void inputMailAddress(String str)
    {
        mailAddress.clear();
        mailAddress.sendKeys(str);
    }
    public  String getCertificate()
    {
        return certificate.getAttribute("value");
    }
    public void inputCertificate(String str)
    {
        certificate.clear();
        certificate.sendKeys(str);
    }
    public void inputOperationArea(String str)
    {
        operationArea.clear();
        operationArea.sendKeys(str);
    }
    public void inputOwnerName(String str)
    {
        ownerName.clear();
        ownerName.sendKeys(str);
    }
    public void inputOrganization(String str)
    {
        organization.clear();
        organization.sendKeys(str);
    }







}
