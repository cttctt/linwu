package com.summersoft.ctt.yycx.page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
public class RegionalManager{
    //新增按钮
    @FindBy(id="agent-add")
    private WebElement addBtn;
    //输入代理名称
    @FindBy(id = "add-name")
    private WebElement agent;
    //负责人
    @FindBy(name = "responsibleName")
    private  WebElement responsibleName;
    //联系电话
    @FindBy(name="responsibleMobile")
    private  WebElement responsibleMobile;
    //身份证
    @FindBy(name="responsibleIdCard")
    private  WebElement idCard;
    //确定按钮
    @FindBy(className = "btn-determine")
    private  WebElement submitBtn;
    //查看详情按钮
    @FindBy(xpath ="//*[@id=\"regional_agent_table\"]/tbody/tr[1]/td[9]/a[2]")
    private  WebElement detailBtn;
    //业务新增+按钮
    @FindBy(xpath = "//*[@id=\"page-wrapper\"]/div/div[2]/div[2]/div/h3/a/strong")

    private  WebElement addicon;
    //业务名称下拉选择
    @FindBy(id = "businessUuid")
    private  WebElement businessType;
    //  编辑城市按钮
    @FindBy(id ="add-resource-btn")
    private  WebElement updateCity;
    //城市下拉选择
    @FindBy(id = "edit-resources")
    private  WebElement city;
    //获取新增成功后类表中城市值
    @FindBy(xpath ="//*[@id=\"page-wrapper\"]/div/div[2]/div[2]/div/span/span[1]/span/ul")
    private  WebElement labelCtiy;
    //编辑抽成按钮
    @FindBy(linkText = "编辑抽成")
    private  WebElement changeCommission;
    //抽成多少
    @FindBy(id = "edit-commission-amonut")
    private  WebElement comissionAmount;
    //列表中显示抽成比例
    @FindBy(css = "#page-wrapper > div > div:nth-child(2) > div.col-md-8.col-sm-12.col-xs-12 > div > h5:nth-child(3)")
    private  WebElement labelComissionAmount;
    //关闭业务
    @FindBy(linkText = "关闭业务")
    private  WebElement linkCloseBussiness;




    //点击新增按钮
    public void clickAddBtn()
    {
        addBtn.click();
    }
    //输入代理名称
    public void inputAgentName(String name)
    {
        agent.sendKeys(name);
    }
    //输入负责人
    public void inputResponsibleName(String name)
    {
        responsibleName.sendKeys(name);
    }
    //输入联系电话
    public  void inputResponsibleMobile(String mobile)
    {
        responsibleMobile.sendKeys(mobile);
    }
    //输入身份证
    public  void inputIDCard(String card)
    {
        idCard.sendKeys(card);
    }
    //点击确定按钮
    public  void clickSubmitBtn()
    {
        submitBtn.click();
    }
    //点击查看详情按钮
    public void clickDetailBtn()
    {
        detailBtn.click();
    }
    //点击新增业务icon
    public  void clickAddBussinessIcon()
    {
        addicon.click();
    }
    //业务名称下拉选择
    public void selectBusinessType(String type)
    {
        Select sel= new Select(businessType);
        sel.selectByVisibleText(type);
    }
    // 点击编辑城市按钮
    public  void clickUpdateCityBtn()
    {
        updateCity.click();
    }
    //下拉选择城市
    public  void selectCity(String  cityName)
    {
        Select sel=new Select(city);
        sel.selectByVisibleText(cityName);
    }
    //取得类表城市名称
    public String  getLabelCityName()
    {
        return  labelCtiy.getText();
    }
    //点击编辑抽成
    public  void clickChangeComission()
    {
        changeCommission.click();
    }
    //输入抽成多少
    public  void inputComissionAmount(String str)
    {
        comissionAmount.clear();
        comissionAmount.sendKeys(str);
    }
    //获取列表比例
    public String getLabelComissionAmount()
    {

        return  labelComissionAmount.getText();
    }
    //点击关闭业务
    public  void linkCloseBussiness()
    {
        linkCloseBussiness.click();

    }





}

