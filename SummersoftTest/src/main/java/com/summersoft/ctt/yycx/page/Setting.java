package com.summersoft.ctt.yycx.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Setting {
    //城市
    @FindBy(id = "cityUuid")
    private WebElement city;
    //派单半径设置
    @FindBy(id="fixedRadius")
    private  WebElement fixedRadius;
    //起步价
    @FindBy(name="startFare")
    private  WebElement startFare;
    //提交按钮
    @FindBy(id = "btnSubmit")
    private  WebElement submitBtn;
    //编辑按钮
    @FindBy(xpath = "//*[@id=\"carModelsLevelTableDiv\"]/table/tbody/tr[1]/td[2]/a[1]")
    private  WebElement updateBtn;
    //取得列表第一个值
    @FindBy(xpath = "//*[@id=\"carModelsLevelTableDiv\"]/table/tbody/tr[2]/td[2]")
    private  WebElement labelStartFare;

    //出租车免费等待时间
    @FindBy(name = "freeWaitTime")
    private  WebElement freeWaitTime;

    //选择派单城市
    public  void  selectCity(String str)
    {
        Select sel =new Select(city);
        sel.selectByVisibleText(str);
    }
    //输入派单半径
    public void inputFixedRadius(String str)
    {
        fixedRadius.clear();
        fixedRadius.sendKeys(str);
    }
    //点击编辑按钮
    public void clickUpdateBtn()
    {
        updateBtn.click();
    }
    //修改起步价
    public void inputStartFare(String str)
    {
        startFare.clear();
        startFare.sendKeys(str);
    }
    //点击提交按钮
    public void clickSubmitBtn()
    {
        submitBtn.click();
    }
    //修改出租车免费等待时长
    public void inputFreeWaitTime(String str)
    {
        freeWaitTime.clear();
        freeWaitTime.sendKeys(str);
    }
    //取得列表第一个值
    public  String getLabelFirstValue()
    {
        return labelStartFare.getText();
    }

}
