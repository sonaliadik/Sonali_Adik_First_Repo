package retailbanking.Po;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import core.utils.Utils;

public class Po_PayBills {
	WebDriver driver;
	//1 Parameterized Consructor
	public Po_PayBills(WebDriver driver) {
		this.driver = driver;
	}
	//2 Po objects
	/*@FindBy(how = How.ID,using="user_login")
	WebElement username;
	@FindBy(how = How.ID,using="user_password")
	WebElement password;
	@FindBy(how = How.XPATH,using="//input[@type='submit']")
	WebElement sign_in;*/


	/*@FindBy(how = How.XPATH,using="//*[@id='pay_bills_tab']/a")
	WebElement Pay_Bill;*/
	@FindBy(how = How.ID,using="Pay Bills")
	WebElement Pay_Bill;
	@FindBy(how = How.ID,using="sp_payee")
	private WebElement Payee;
	@FindBy(how = How.ID,using="sp_account")
	private WebElement Account;
	@FindBy(how = How.ID,using="sp_amount")
	private WebElement Amount;
	@FindBy(how = How.ID,using="sp_date")
	private WebElement Date;
	@FindBy(how = How.ID,using="sp_description")
	private WebElement Desc;
	@FindBy(how = How.XPATH,using="//button[@type='submit']")
	WebElement Pay;

	//Methods
	/*public void username()
	{
		username.sendKeys("username");
	}
	public void password_method()
	{
		password.sendKeys("password");
	}
	public void ClickOnSignin_Button() {
		try {
			sign_in.click();
			Utils.WriteLogs("info","Clickd on Sign_in Button");
		}catch(Exception e) {
			e.printStackTrace();
			Utils.WriteLogs("fail","Unable to click on  sign_in button due to exception: " + e.toString());
		}
	}*/
	public void Select_from_payee( String text)
	{
		try
		{
			Select list_from_payee= new  Select(Payee);
			list_from_payee.selectByVisibleText("text");	
			Utils.WriteLogs("info","Selected text as :" + text + " from FromDropDown");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Utils.WriteLogs("fail","Unable to Select text as: '"+ text +"' from FromDropDown: " + e.toString());
		}
	}
	public void Select_from_account(String value)
	{

		try {
			Select listFromAccount = new Select(Account);
			listFromAccount.selectByValue(value);
			Utils.WriteLogs("info","Selected value as :" + value + " from FromDropDown");
		}catch(Exception e) {
			e.printStackTrace();
			Utils.WriteLogs("fail","Unable to Select value as: '"+ value +"' from FromDropDown: " + e.toString());

		}
	}
	public void amount()
	{
		Amount.sendKeys("");
	}


	public void select_from_date(String text)
	{
		try {
			Select select_from_date = new Select(Date);
			select_from_date.selectByValue(text);
			Utils.WriteLogs("info","Selected date as :" + text + " from FromDropDown");
		}catch(Exception e) {
			e.printStackTrace();
			Utils.WriteLogs("fail","Unable to Select date as: '"+ text +"' from FromDropDown: " + e.toString());

		}	
	}
	public void description()
	{
		Desc.sendKeys(" ");
	}
	public void ClickOnPay() {
		try {

			Pay.click();
			Utils.WriteLogs("info","Clickd on Pay Button");
		}catch(Exception e) {
			e.printStackTrace();
			Utils.WriteLogs("fail","Unable to click on Pay button due to exception: " + e.toString());
		}
	}
	public void KW_Fill_Pay_BillsAndSubmit(String Payee,String Account,String Amount,String Date,String Desc)
	{
		try
		{
			Select_from_payee( Payee);
			Select_from_account(Account);
			amount();
			select_from_date(Date);
			description();	

			//Assertion Point
			Assert.assertEquals(Pay.isDisplayed(), true);
			Assert.assertEquals(Amount.isEmpty(), false);
			Utils.WriteLogs("info","Page Navigated to Pay_Bills Verify");
			ClickOnPay();
			Utils.WriteLogs("pass","Page Navigated to Pay_Bills Verify page");

			//Checkpoint to validate the Amount
			String expected = "driver.findElement(By.xpath(//input[@id='sp_amount']))";
			String actual = "Amount";
			Assert.assertEquals(actual, expected);

		}catch(Exception e) {
			e.printStackTrace();
			Utils.WriteLogs("fail","Unable to navigate Pay_Bills  and Submit page: " + e.toString());
		}
	}
}
