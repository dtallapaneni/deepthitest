package locators;

public class wikiMythologyLocators {

	
	//Testcase_a[the headings listed in the `Contents` box are used as headings on the page] - Related Locators 
	protected static final String CONTENTS_NAMES = "//span[@class='toctext']";
	protected static final String CONTENTS_HEADERS="//h2[span[contains(text(),'%1$s')]]";
	
	//Testcase_b - Related Locators
	protected static final String CONTENTS_LINKS = "//li[starts-with(@class,'toclevel-1 tocsection-%1$d')]/a";
	
	//Testcase_c[in the _Personified concepts_, `Nike` has a popup that contains the following text:]
	protected static final String NIKEPERSONIFIEDCONCEPTS = "//table[contains(@class,'vertical-navbox')]//a[text()='Nike']";
	protected static final String NIKEPOPUP = "//div[@class='mwe-popups-container']";
	
//	Testcase_d - Related Locators
	protected static final String FAMILYTREE_HEADER="//h2/span[text()='Family tree']";
}
