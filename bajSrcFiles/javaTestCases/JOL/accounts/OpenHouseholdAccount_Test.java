package javaTestCases.JOL.accounts;

import static Utilities.ReadData.RowCount;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Test;

import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.JOL.accounts.OpenHouseholdAccount;

public class OpenHouseholdAccount_Test extends TestBase {

	@Test
	public void JOL_ACCOUNTS_OPEN_HOUSEHOLD_ACCOUNT() {

		TCName = "JOL Account - Open Household Account";
		extentSetUp();

		if (isMasterClassRun) {

			for (scenarioCount = 1; scenarioCount <= RowCount(TCName); scenarioCount++) {

				try {
					Log.info("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has started." + "</mark>");
					OpenHouseholdAccount.OpenHouseholdAccount_functions(TCName, scenarioCount, dataset);
					Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has passed." + "</mark>");

				} catch (AssertionError | Exception e) {

					Utils.pressEscapeKey(4);
					Utils.refreshScreeen();
					Utils.logFailImage(TCName + " " + scenarioCount + "failed");
					Log.fail("<mark style='background-color: white; color: red;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has failed." + "</mark>" + System.lineSeparator() + ExceptionUtils.getStackTrace(e).trim());

				}
			}
		}

		else {

			for (scenarioCount = 1; scenarioCount <= dataset.length; scenarioCount++) {

				try {
					Log.info("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has started." + "</mark>");
					OpenHouseholdAccount.OpenHouseholdAccount_functions(TCName, scenarioCount, dataset);
					Log.pass("<mark style='background-color: white; color: green;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has passed." + "</mark>");

				} catch (AssertionError | Exception e) {

					Utils.pressEscapeKey(4);
					Utils.refreshScreeen();
					Utils.logFailImage(TCName + " " + scenarioCount + "failed");
					Log.fail("<mark style='background-color: white; color: red;font-weight:bold'>" + TCName + " : Scenario -> " + scenarioCount + " has failed." + "</mark>" + System.lineSeparator() + ExceptionUtils.getStackTrace(e).trim());

				}
			}
		}
	}

}
