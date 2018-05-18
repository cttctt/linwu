package com.summersoft.ctt.yycx.page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BusinessManager {

    // 企业全称
    @FindBy(name = "fullName")
    private WebElement fullName;
    //企业简称
    @FindBy(name = "shortName")
    private WebElement shortName;
    // 联系人
    @FindBy(name = "responsibleName")
    private WebElement responsibileName;
    // 联系人手机号
    @FindBy(name = "responsibleMobile")
    private WebElement responsibleMobile;
    // 客服电话
    @FindBy(name = "phone")
    private WebElement phone;
    //选择所属代理机构
    @FindBy(name = "regionalAgentUuid")
    private WebElement agent;
    //确定按钮
    @FindBy(className= "btn-determine")
    private  WebElement submitBtn;
    //详情按钮
    @FindBy(className = "details-btn")
    private  WebElement  detailBtn;
    //企业名称
    @FindBy(id ="company_full_name")
    private  WebElement companyName;


    public void inputFullName(String str) {
        fullName.sendKeys(str);
    }

    public void inputShortName(String str) {
        shortName.sendKeys(str);
    }

    public void inputResponsibleName(String str) {
        responsibileName.sendKeys(str);
    }

    public void inputResponsibleMobile(String str) {
        responsibleMobile.sendKeys(str);
    }
    public void inputPhone(String str)
    {
        phone.sendKeys(str);
    }
    public  void selectAgent(String str)
    {
        Select sel=new Select(agent);
        sel.selectByVisibleText(str);
    }
    public void clickSubmitBtn()
    {
        submitBtn.click();
    }
    public  void clickDetailBtn()
    {
        detailBtn.click();
    }
    public String getLabelCompanyName()
    {
        return companyName.getText();
    }


}
