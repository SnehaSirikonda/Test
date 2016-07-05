package test.sneha;

import java.io.IOException;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before("@web")
	public void setUp() throws IOException {
		new DriverManager().openBrowser();
	}

	@After("@web")
	public void tearDown() {
		new DriverManager().closeBrowser();
	}

}
