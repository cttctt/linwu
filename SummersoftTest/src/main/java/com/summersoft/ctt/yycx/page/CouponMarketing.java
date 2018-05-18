package com.summersoft.ctt.yycx.page;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class CouponMarketing {
	//添加优惠券礼包按钮
	@FindBy(className="add-icon")
	private WebElement addCouponBtn;
	//礼包名称
	@FindBy(name="name")
	private WebElement name;
	//活动开始时间
	@FindBy(id="effectiveDate")
	private WebElement startDate;
	//活动结束时间
	@FindBy(id="expiryDate")
	private WebElement endDate;
	//库存量
	@FindBy(name="remainNumber")
	private WebElement remainNumber;
	//领取用户
	@FindBy(name="limitDrawType")
	private WebElement userType;
	//每个人限领次数
	@FindBy(name="limitDrawCount")
	private WebElement limitCount;
	//添加之前新增的优惠券
	@FindBy(className="checkbox-label")
	private List<WebElement> coupons;
	//下一步按钮
	@FindBy(id="doNext")
	private WebElement nextBtn;
	//使用城市
	@FindBy(id="marketingCouponDtoList0")
	private WebElement city;
	//有效期
	@FindBy(name="marketingCouponDtoList[0].termType")
	private WebElement date;
	@FindBy(name="marketingCouponDtoList[0].useExpireTime")
	private WebElement useTime;
	//上传底图
	@FindBy(name="backgroundImageFile")
	private WebElement backgroundImg;
	//上传领取按钮图片
	@FindBy(name="buttonImageFile")
	private WebElement btnImg;
	//规则说明
	@FindBy(name="ruleDescription")
	private WebElement ruleDescription;
	//提交生成二维码链接
	@FindBy(id="submitAndSend")
	private WebElement submitBtn;
	//搜索按钮
	@FindBy(id="searchGiftBtn")
	private WebElement searchGiftBtn;

	//查看列表中礼包名称
	@FindBy(css="#giftUnitDiv > div > div.gift-contrainer-unit-right > p.gift-name-title > span.name")
	private WebElement giftname;
	//点击新增二维码、微信优惠券礼包按钮
	public void clickAddCouponButton()
	{
		addCouponBtn.click();
	}
	//输入礼包名称
	public void inputName(String giftName)
	{
		name.sendKeys(giftName);

	}
	//选择活动时间
	public void selectDate(String start,String end)
	{
		startDate.sendKeys(start);
		endDate.sendKeys(end);
	}
	//输入库存量
	public void inputRemainNumber(String stock)
	{
		remainNumber.sendKeys(stock);
	}
	//选择领取对象
	public void selectUserType(int i)
	{
		Select sel=new Select(userType);
		sel.selectByIndex(i);
	}
	//选择限领次数
	public void selectLimitCount(int i)
	{
		Select sel=new Select(limitCount);
		sel.selectByIndex(i);;
	}
	//点击添加优惠券
	public void addCoupon()
	{
		addCouponBtn.click();
	}
	//选择一张优惠券
	public void selectCoupon()
	{
		try {
			coupons.get(0).click();
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
	//点击下一步按钮
	public void next()

	{
		nextBtn.click();
	}
	//选择使用城市
	public void selectCity(String cityName)

	{
		Select sel=new Select(city);
		sel.selectByVisibleText(cityName);



	}


	//选择上传底图
	public void selectBackgroundImg(String backgroundImgUrl)
	{
		backgroundImg.sendKeys(backgroundImgUrl);

	}
	//选择上传领取按钮图
	public void selectBtnImg(String bthImgUrl)
	{
		btnImg.sendKeys(bthImgUrl);
	}
	//输入规则说明
	public void inputRule(String rule)
	{
		ruleDescription.sendKeys(rule);

	}
	//选择有效期
	public void selectDate(String  day)
	{
		Select sel=new Select(date);
		sel.selectByVisibleText("固定时长");
		useTime.sendKeys(day);

	}
	//提交按钮
	public void clickSubmitBtn()
	{
		submitBtn.click();
	}
	//点击礼包名称搜索按钮
	public void clickSearchBtn()
	{
		searchGiftBtn.click();

	}

	//获取搜索中礼包列表第一个礼包名称
	public String getGiftName()
	{
		return giftname.getText();
	}





}
