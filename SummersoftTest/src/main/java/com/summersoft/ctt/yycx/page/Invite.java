package com.summersoft.ctt.yycx.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Invite {
    //乘客邀请tab下编辑按钮

    @FindBy(xpath = "//*[@id=\"containerDiv\"]/div/div[2]/p[3]/a[2]")
    private WebElement updateBtn;
    public void clickUpdate()
    {
        updateBtn.click();
    }
    //礼包库存量
    @FindBy(name = "remainNumber")
    private  WebElement remainNumber;
    public void inputRemainNum(String str)
    {
        remainNumber.clear();
        remainNumber.sendKeys(str);
    }
    public String getRemainNum()
    {
        return remainNumber.getAttribute("value");
    }
    //点击添加按钮
    @FindBy(className = "add-icon")
   private  WebElement addIcon;
    public void clickAddIcon()
    {
        addIcon.click();
    }
    //添加之前新增的优惠券
    @FindBy(className="checkbox-label")
    private List<WebElement> coupons;
    //选择一张优惠券
    public void selectCoupon() {

        try {
            boolean isChecked=coupons.get(0).isSelected();
            if(isChecked)
            {
                System.out.println("已选中");
            }
            else
            {
                System.out.println("未选中");
                coupons.get(0).click();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }






    //下一步按钮
    @FindBy(id="doNext")
    private WebElement nextBtn;
    //点击下一步按钮
    public void next()

    {
        nextBtn.click();
    }

    //张数
    @FindBy(name="marketingCouponDtoList[0].sendCount")
    private WebElement count;
    //使用张数
    public void inputCount(String couponCount)
    {
        count.clear();
        count.sendKeys(couponCount);
    }
    //使用城市
    @FindBy(id="marketingCouponDtoList0")
    private WebElement city;
    //选择使用城市
    public void selectCity(String cityName)

    {
        Select sel=new Select(city);
        sel.selectByVisibleText(cityName);



    }
    //有效期
    @FindBy(name="marketingCouponDtoList[0].termType")
    private WebElement date;
    @FindBy(name="marketingCouponDtoList[0].useExpireTime")
    private WebElement useTime;
    //提交生成按钮
    @FindBy(id="submitAndSend")
    private WebElement submitBtn;
    //选择有效期
    public void selectDate(String  day)
    {
        Select sel=new Select(date);
        sel.selectByVisibleText("固定时长");
        useTime.clear();
        useTime.sendKeys(day);

    }
    //点击提交
    public void clickSubmitBtn()
    {
        submitBtn.click();
    }

    //发送规则
    @FindBy(name = "driverCashback")
    private  WebElement driverCashback;
    public  void inputDriverCashback(String str)
    {
        driverCashback.clear();
        driverCashback.sendKeys(str);
    }

    //司机邀请乘客下编辑按钮
    @FindBy(xpath = "//*[@id=\"driverInviteGiftContainer\"]/div/div[2]/p[3]/a[2]")
    private  WebElement driverInvitePassengerUpdateBtn;
    public  void clickDriverInvitePassengerUpdateBtn()
    {
        driverInvitePassengerUpdateBtn.click();
    }


    //司机邀请司机下编辑按钮
    @FindBy(xpath = "//*[@id=\"driverInviteGiftContainer\"]/div/div[2]/div[2]/a[2]")
    private  WebElement driverInviteDriverUpdateBtn;
    public  void clickDriverInviteDriverUpdateBtn()
    {
        driverInviteDriverUpdateBtn.click();
    }


}
