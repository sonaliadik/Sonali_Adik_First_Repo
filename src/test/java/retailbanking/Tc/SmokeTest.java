package retailbanking.Tc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import core.utils.Utils;
import retailbanking.Po.Po_Common;
import retailbanking.Po.Po_Login;
import retailbanking.Po.Po_PayBills;
import retailbanking.Po.Po_TransferFunds;

public class SmokeTest {
	
	@Parameters({"url","browser"})
	@Test
	public void t_01_check_login(String url,String browserType) {
		try {
			url = "http://zero.webappsecurity.com/login.html";
			WebDriver driver = Utils.InvokeBrowser(browserType, url);

			//Init Page Object
			Po_Login Po_Login = PageFactory.initElements(driver, Po_Login.class);
			Po_Login.KW_LoginInToApplication("username", "password");
			
			Utils.WriteLogs("pass","Test Case completed");
		}catch(Exception e) {
			Utils.WriteLogs("fail","Test failed");
			Assert.assertFalse(false);
		}

	}
	
	@Parameters({"url","browser"})
	@Test
	public void t_02_check_transfer_funds(String url,String browserType)  {
		WebDriver driver = Utils.InvokeBrowser(browserType, url);
		//Init Page Object
		Po_Login Po_Login = PageFactory.initElements(driver, Po_Login.class);
		Po_Login.KW_LoginInToApplication("username", "password");
		
		//Click on Transfer Funds
		Po_Common PoCommon = PageFactory.initElements(driver, Po_Common.class);
		PoCommon.ClickOnTransferFunds();
		
		//Transfer Funds
		Po_TransferFunds Po_TransferFunds = PageFactory.initElements(driver, Po_TransferFunds.class);
		String from = "1";
		String to = "2";
		String ammount = "10";
		String descp = "test";
		
		Po_TransferFunds.KW_FillTransferFundsPageAndSubmit(from, to, ammount, descp);
		Utils.WriteLogs("pass","Test Case completed");
		
	}
	
	//<parameter name="url_parabank" value="http://parabank.parasoft.com/parabank/index.htm" />/
	//@Parameters({"url_icici"})
	//@Test(groups="smoke",description="Smoke Test For Search funtionality",enabled=true)
	@Parameters({"url","browser"})
	@Test
	public void Tc03_validate_PayBills(String url,String browserType)  {
		//url = "http://zero.webappsecurity.com/login.html";
		WebDriver driver = Utils.InvokeBrowser(browserType, url);
		//Init Page Object
		Po_Login Po_Login = PageFactory.initElements(driver, Po_Login.class);
		Po_Login.KW_LoginInToApplication("username", "password");
		//Pay_Bills
		Po_PayBills Po_paybills= PageFactory.initElements(driver, Po_PayBills.class);
		String Payee = " Bank of America";
		String Account = "2";
		String Amount = "2000";
		String Date = "2018-10-04";
		String Desc="Selenium Script";
		Po_paybills.KW_Fill_Pay_BillsAndSubmit(Payee, Account, Amount, Date,Desc);
		Utils.WriteLogs("pass","Test Case completed");
		
	}
	}
	




