package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.MythologyPageObjects;

public class wikiMythologyTests extends BaseTest {

	/**
	 * TESTCASE_a - the headings listed in the `Contents` box are used as headings on the page
	 */
	@Test
	public void  testContentNamesAreHeaders() 
	{
		driver.get("https://en.wikipedia.org/wiki/Metis_(mythology)");
		MythologyPageObjects m = new MythologyPageObjects(driver);
		// m.validateContentsHeaders();
		System.out.println("TestCase_a");
		m.validateContentNamesAreHeaders();
	}

	/**
	 * TESTCASE_b - the headings listed in the `Contents` box have functioning hyperlinks
	 */
	@Test
	public void testContentHyperLinks()
	{
		driver.get("https://en.wikipedia.org/wiki/Metis_(mythology)");
		MythologyPageObjects m = new MythologyPageObjects(driver);
		System.out.println("TestCase_b");
		m.verifyContentHyperLinksFunctional();
	}

	/**
	 * TESTCASE_c - in the _Personified concepts_, `Nike` has a popup that contains the following text:
	 * In ancient Greek religion, Nike was a goddess who personified victory. Her Roman equivalent was Victoria.
	 */
	@Test
	public void testNikeLinkPopupTextInPersonifiedConcepts()
	{
		driver.get("https://en.wikipedia.org/wiki/Metis_(mythology)");
		MythologyPageObjects m = new MythologyPageObjects(driver);
		String expectedNikePopUpText="In ancient Greek religion, Nike was a goddess who personified victory. Her Roman equivalent was Victoria.";
		m.verifyNikePopupTextInPersonifiedConcepts(expectedNikePopUpText);
	}

	/**
	 * TESTCASE_d - in the _Personified concepts_, if you click on `Nike`, it takes you to a page that displays a family tree
	 */
	@Test
	public void testNikeLinkDisplayFamilyTree() {
		driver.get("https://en.wikipedia.org/wiki/Metis_(mythology)");
		MythologyPageObjects m = new MythologyPageObjects(driver);
		
		m.clickOnNikeInPersonifiedConcepts();

	}
}