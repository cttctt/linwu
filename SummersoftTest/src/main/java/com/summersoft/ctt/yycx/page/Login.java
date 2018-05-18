package com.summersoft.ctt.yycx.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	//用户名
	@FindBy(id="userAccount")
	private WebElement userName;
	//密码
	@FindBy(name="password")
	private WebElement password;
	//验证码
	@FindBy(name="verificationCode")
	private WebElement veriCode;
	//登录按钮
	@FindBy(xpath="/html/body/section/div/div[2]/form/div[4]/div/button")
	private WebElement  loginBtn;
	//进入首页用户名
	@FindBy(xpath="//*[@id=\"wrapper\"]/nav/div/ul[2]/li/a/b")
	private WebElement name;

	//输入用户名
	public void inputUserName(String user)
	{
		password.clear();
		userName.sendKeys(user);
	}
	//输入密码
	public void inputUserPassword(String pwd)
	{
		password.clear();
		password.sendKeys(pwd);
	}
	//输入验证码
	public void inputVeriCode(String code)
	{
		veriCode.sendKeys(code);
	}
	//点击登录按钮
	public void clickLoginBtn()
	{
		loginBtn.click();
	}
	//取得登录名
	public String getUser()
	{
		return name.getText();

	}


}
