package javaMain.eCorp.PointOfSales;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.Confirm;
import static javaMain.common_Functions.AppData.NewTxn;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.isNegative;
import static javaMain.common_Functions.AppData.otherActions;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.eCorpCommonFunctions;
/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class eCorp_POINTOFSALES_REQUESTNEWPOS_FUNC extends TestBase {

	public static Boolean REQUESTNEWPOS(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {
		
		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				otherActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "otherActions"));

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");

				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));
				NewTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				otherActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("otherActions"));
			}
			
			Utils.wait(2);
			Utils.click(By.xpath(getObj("Propval1", "PointOfSales", "eCorp_PointOfSales_RequestNewPOS")), "Point Of Sales");
			Utils.click(By.xpath(getObj("Propval1", "RequestNewPOS", "eCorp_PointOfSales_RequestNewPOS")), "RequestNewPOS");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "eCorp_PointOfSales_RequestNewPOS")));

			Log.pass("Page title is " + LandPage);

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropDwon", "eCorp_PointOfSales_RequestNewPOS")), By.xpath(getObj("Propval1", "AccountNumber", "eCorp_PointOfSales_RequestNewPOS")),
					ReadTestData(TCName, "AccountNumber"), "AccountNumber");
			Utils.wait(1);

			if (isNegative.equalsIgnoreCase("true")) {
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropDwon", "eCorp_PointOfSales_RequestNewPOS")), By.xpath(getObj("Propval1", "AccountNumber", "eCorp_PointOfSales_RequestNewPOS")),
						ReadTestData(TCName, "InvalidAccountNumber"), "AccountNumber");
			}
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "POSMachineNumberDropDown", "eCorp_PointOfSales_RequestNewPOS")), By.xpath(getObj("Propval1", "POSMachineNumber", "eCorp_PointOfSales_RequestNewPOS")),
					ReadTestData(TCName, "POSID"), "POSID");

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "POSTypeDropDown", "eCorp_PointOfSales_RequestNewPOS")), By.xpath(getObj("Propval1", "POSType", "eCorp_PointOfSales_RequestNewPOS")), ReadTestData(TCName, "POSType"), "POSType");

			Utils.wait(1);
			Utils.sendKeys(By.xpath(getObj("Propval1", "StreetName", "eCorp_PointOfSales_RequestNewPOS")), ReadTestData(TCName, "Street"), "Street");
			Utils.sendKeys(By.xpath(getObj("Propval1", "BuildingName", "eCorp_PointOfSales_RequestNewPOS")), ReadTestData(TCName, "Building"), "BuildingName");
			Utils.sendKeys(By.xpath(getObj("Propval1", "District", "eCorp_PointOfSales_RequestNewPOS")), ReadTestData(TCName, "District"), "District");

			Utils.sendKeys(By.xpath(getObj("Propval1", "POBOX", "eCorp_PointOfSales_RequestNewPOS")), ReadTestData(TCName, "POBox"), "POBox");
			Utils.sendKeys(By.xpath(getObj("Propval1", "City", "eCorp_PointOfSales_RequestNewPOS")), ReadTestData(TCName, "City"), "City");
			Utils.sendKeys(By.xpath(getObj("Propval1", "ZipCode", "eCorp_PointOfSales_RequestNewPOS")), ReadTestData(TCName, "ZipCode"), "ZipCode");
			Utils.sendKeys(By.xpath(getObj("Propval1", "ContactNumber", "eCorp_PointOfSales_RequestNewPOS")), ReadTestData(TCName, "Fullname"), "ContactNumber");
			Utils.sendKeys(By.xpath(getObj("Propval1", "Mobile", "eCorp_PointOfSales_RequestNewPOS")), ReadTestData(TCName, "MobileNumber"), "MobileNumber");

			if (otherActions.equalsIgnoreCase("Add another transaction")) {
				Utils.click(By.xpath(getObj("Propval1", "Addanothertransaction", "eCorp_PointOfSales_RequestNewPOS")), "Add another transaction");
				Utils.logPassImage("Add another transaction");
				Utils.click(By.xpath(getObj("Propval1", "AddanothertransactionDelete", "eCorp_PointOfSales_RequestNewPOS")), "Add another transaction Delete");
				Log.pass("Successfully able to click on Add another transaction and also able to Delete");
				Utils.logPassImage("Delete another transaction");
				return true;

			}

			if (Integer.parseInt(Proceed) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "eCorp_PointOfSales_RequestNewPOS")), "Proceed");

			} else {

				Utils.click(By.xpath(getObj("Propval1", "Cancel", "eCorp_PointOfSales_RequestNewPOS")), "Proceed Cancel");

				Utils.logPassImage(TCName);
				return runResult;

			}

			if (isNegative.equalsIgnoreCase("true")) {
				try {

					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "eCorp_PointOfSales_RequestNewPOS")), "Result Details."));
					Log.pass("User is not able to proceed without entering the mandatory field");
					Utils.logPassImage(TCName);
					return true;

				} catch (AssertionError | Exception e) {

					Log.fail("User is able to proceed with entering mandatory field. Please review the page or make isNegative tage false");
					Utils.logFailImage(TCName);
					return false;

				}

			}

			if (Integer.parseInt(Confirm) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Confirm", "eCorp_PointOfSales_RequestNewPOS")), "Confirm");

			} else if (Integer.parseInt(Confirm) == 2) {

				Utils.click(By.xpath(getObj("Propval1", "modify", "eCorp_PointOfSales_RequestNewPOS")), "Modify");

				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "eCorp_PointOfSales_RequestNewPOS")));
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "eCorp_PointOfSales_RequestNewPOS")), "Modify Proceed");

				Utils.click(By.xpath(getObj("Propval1", "Confirm", "eCorp_PointOfSales_RequestNewPOS")), "Modify Confirm");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "eCorp_PointOfSales_RequestNewPOS")), "Confirm Cancel");
				Utils.wait(6);
				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "eCorp_PointOfSales_RequestNewPOS")), "Confirm Cancel yes");
				Log.pass("Click on Confirm Return ......");
				Utils.logPassImage(TCName);
				return runResult;
			}

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMessage", "eCorp_PointOfSales_RequestNewPOS")), "Success Message"));
				Log.pass("AddCompany CR Details successfully." + Utils.getText(By.xpath(getObj("Propval1", "SuccessMessage", "eCorp_PointOfSales_RequestNewPOS"))));
				Utils.logPassImage("AddCompany CR Details-Pass");

			} catch (AssertionError | Exception e) {

				Log.fail("AddCompany CR Details failed...Message:" + Utils.getText(By.xpath(getObj("Propval1", "failMessage", "eCorp_PointOfSales_RequestNewPOS"))));
				Utils.logFailImage("AddCompany CR Details-Fail");
				throw e;
			}

			if (isNegative.equalsIgnoreCase("true")) {
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "error", "eCorp_PointOfSales_RequestNewPOS")), "Invalid data"));
					Log.pass("Not able to search with invalid data. Please review the page again");
					Utils.logPassImage(TCName);
					return true;
				}

				catch (AssertionError | Exception e) {
					Log.fail("Able to search with invalid data please mark isNegative true or review the page");
					Utils.logFailImage(TCName);
					throw e;
				}

			}

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.SendEmailDownloadPdfNprintFunc();
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");
			}

			if (Integer.parseInt(NewTxn) == 1) {
				Utils.scrollDownVertically();
				Utils.click(By.xpath(getObj("Propval1", "NewTransactionBtn", "eCorp_PointOfSales_RequestNewPOS")), "New Transaction");
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "proceed", "eCorp_PointOfSales_RequestNewPOS")), "Result Details."));
				Log.pass("New Transaction is landed successfully");
				Utils.logPassImage(TCName);

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Home", "eCorp_PointOfSales_RequestNewPOS")), "Home Button.");
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "HomepageSuccess", "eCorp_PointOfSales_RequestNewPOS")), "HomepageSuccess"));
				Log.pass("Home page is landed successfully");
				Utils.logPassImage(TCName);

			}

		} catch (

		Exception e) {
			runResult = false;
			throw e;

		}
		return runResult;
	}

	public static boolean addFavSendEmailDownloadPdfNprintFuncBeneficiary(String Nickname) throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_PointOfSales_RequestNewPOS")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_PointOfSales_RequestNewPOS")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_PointOfSales_RequestNewPOS")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_PointOfSales_RequestNewPOS")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_PointOfSales_RequestNewPOS")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_PointOfSales_RequestNewPOS")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.clickSafely(By.xpath(getObj("Propval1", "cancelemailBtnEle", "eCorp_PointOfSales_RequestNewPOS")), "Cancel Email Button");

			Utils.wait(5);
			Utils.pressEnter();
			Utils.refreshScreeen();
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_PointOfSales_RequestNewPOS")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_PointOfSales_RequestNewPOS")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_PointOfSales_RequestNewPOS")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_PointOfSales_RequestNewPOS")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_PointOfSales_RequestNewPOS")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_PointOfSales_RequestNewPOS")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "eCorp_PointOfSales_RequestNewPOS")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "eCorp_PointOfSales_RequestNewPOS")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "eCorp_PointOfSales_RequestNewPOS")), "pdf download");
			Utils.wait(3);
			Utils.closeOtherTabs();
			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();

			Utils.wait(3);
			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "eCorp_PointOfSales_RequestNewPOS")), "Print Button");
			// close all other tabs except the main one. i.e 1st page.
			Utils.closeOtherTabs();

		}

		catch (Exception e) {
			Log.error("Unable to send email semail, print and download pdf etc.");
			Utils.logFailImage("Error");
			runResult = false;
			throw e;

		}

		return runResult;
	}

}
