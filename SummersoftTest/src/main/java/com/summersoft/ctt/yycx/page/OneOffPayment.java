package com.summersoft.ctt.yycx.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OneOffPayment {
    //点击第一张优惠券
    @FindBy(className="checkbox-label")
    private List<WebElement> coupons;
    //下一步按钮
    @FindBy(id="doNext")
    private WebElement nextBtn;
    //活动名称
    @FindBy(name="name")
    private WebElement name;
    //发送城市
    @FindBy(id="sendCitySelect")
    private WebElement sendCity;
    //使用城市
    @FindBy(id="marketingCouponDtoList0")
    private WebElement userCity;
    //张数
    @FindBy(name="marketingCouponDtoList[0].sendCount")
    private WebElement count;
    //有效期
    @FindBy(name="marketingCouponDtoList[0].termType")
    private WebElement date;
    @FindBy(name="marketingCouponDtoList[0].useExpireTime")
    private WebElement useTime;
    //提交生成按钮
    @FindBy(id="submitAndSend")
    private WebElement submitBtn;
    //历史发送记录按钮
    @FindBy(id="sendHistoryBtn")
    private  WebElement historyBtn;
    //获取最新发送记录第一条的礼包名称
    @FindBy(xpath = "//*[@id=\"gift_table\"]/tbody/tr[1]/td[2]")
    private WebElement firstActivityName;

    //选择一张优惠券
    public void selectCoupon()
    {

        try {
            coupons.get(0).click();
        }
        catch(NullPointerException ex){
            System.out.println("暂无相应的优惠券");
        }

    }
    //点击下一步按钮
    public void next()

    {
        nextBtn.click();
    }
    //填写活动名称
    public void inputActivityName(String  activtiyName)
    {
        name.sendKeys(activtiyName);

    }
    //选择发送城市
    public void selectSendCity(String city)
    {
        Select sel=new Select(sendCity);
        sel.selectByVisibleText(city);
    }
    //选择使用城市
    public void selectUserCity(String city)
    {
        Select sel=new Select(userCity);
        sel.selectByVisibleText(city);
    }
    //使用张数
    public void inputCount(String couponCount)
    {
        count.sendKeys(couponCount);
    }
    //选择有效期
    public void selectDate(String  day)
    {
        Select sel=new Select(date);
        sel.selectByVisibleText("固定时长");
        useTime.sendKeys(day);

    }
    //点击提交
    public void clickSubmitBtn()
    {
        submitBtn.click();
    }
    //点击历史发送记录
    public  void clickSendHistoryBtn()
    {
        historyBtn.click();
    }
    //获取发送记录列表中第一条记录的活动名称
    public  String  getFirstActivityName()
    {
        return firstActivityName.getText();

    }




}
