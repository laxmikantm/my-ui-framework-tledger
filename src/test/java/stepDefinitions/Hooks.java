package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
/**************************
 *  (C) L Somni            *
 ***************************/

public class Hooks {
	TestContext testContext;
	
	public Hooks(TestContext context) {
		this.testContext = context;
	}
	
	@Before
	public void BeforeSteps() {
	}
 
	@After
	public void AfterSteps() {
		testContext.getWebDriverManager().closeDriver();
	}
}
