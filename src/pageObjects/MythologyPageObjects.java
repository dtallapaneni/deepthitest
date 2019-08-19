package pageObjects;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import locators.wikiMythologyLocators;

public class MythologyPageObjects extends wikiMythologyLocators {
	WebDriver driver;


	public MythologyPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	//TESTCASE_a - the headings listed in the `Contents` box are used as headings on the page
	public void validateContentNamesAreHeaders() {
		List<WebElement> contentNames=driver.findElements(By.xpath(CONTENTS_NAMES));
		for(WebElement contentNameElement:contentNames)
		{
			System.out.println("Validating "+contentNameElement.getText()+" content name is displayed as Header");
			Assert.assertTrue(driver.findElement(By.xpath(String.format(CONTENTS_HEADERS, contentNameElement.getText()))).isDisplayed());
			System.out.println("Content name "+contentNameElement.getText()+" is displayed as Header:"+"SUCCESS");
		}
	}
	//TESTCASE_b -  the headings listed in the `Contents` box have functioning hyperlinks
	public void verifyContentHyperLinksFunctional() 
	{
		List<WebElement> contentNames=driver.findElements(By.xpath(CONTENTS_NAMES));
		for(int i=1;i<=contentNames.size();i++)
		{
			System.out.println("Verifying Content Link is funational for ContentName:"+contentNames.get(i-1).getText());
			String contentLink=String.format(CONTENTS_LINKS,i);
			String expectedURL = driver.findElement(By.xpath(contentLink)).getAttribute("href");
			System.out.println("Expected URL:"+expectedURL);
			driver.findElement(By.xpath(contentLink)).click();
			String actualURL = driver.getCurrentUrl();
			System.out.println("Actual URL:"+expectedURL);
			Assert.assertEquals(actualURL, expectedURL,"Actual and Expected links are not equal");
		}
	}
	//TESTCASE_c - in the _Personified concepts_, `Nike` has a popup that contains the following text:
	public void verifyNikePopupTextInPersonifiedConcepts(String expectedPopupText)
	{
		Actions action=new Actions(driver);
		WebElement nikeLink = driver.findElement(By.xpath(NIKEPERSONIFIEDCONCEPTS));
		action.moveToElement(nikeLink).build().perform();
		WebElement nikePopup = driver.findElement(By.xpath(NIKEPOPUP));
		String actualPopupText=nikePopup.getText();
		Assert.assertEquals(actualPopupText, expectedPopupText, "Text on Nike Popup is not correct");
	}

	// TESTCASE_d - in the _Personified concepts_, if you click on `Nike`, it takes you to a page that displays a family tree
	public void clickOnNikeInPersonifiedConcepts() 
	{
		
		WebElement nikeLink=driver.findElement(By.xpath(NIKEPERSONIFIEDCONCEPTS));
		nikeLink.click();
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.invisibilityOf(nikeLink));
		Assert.assertTrue(driver.findElement(By.xpath(FAMILYTREE_HEADER)).isDisplayed());
	}
}

