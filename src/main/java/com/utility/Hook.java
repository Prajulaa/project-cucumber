package com.utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {
	
	

	public void tearDown() {
		BaseClass base = new BaseClass();
		base.close();
	}

}
