package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

/**************************
 *  (C) L Somni            *
 ***************************/


public class PageObjectManager {

	private WebDriver driver;
	private CardsHomePage cardsHomePage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public CardsHomePage getCardsHomePage() {
		return (cardsHomePage == null )? cardsHomePage = new CardsHomePage(driver) : cardsHomePage;
	}
}