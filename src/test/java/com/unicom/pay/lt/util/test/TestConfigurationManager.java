package com.unicom.pay.lt.util.test;

import org.junit.Test;

import com.unicom.pay.lt.util.ConfigurationManager;

public class TestConfigurationManager {
	@Test
	public void testGetKey() {
		System.out.println(ConfigurationManager.getProperty("woBF.tokenUrl"));
		
	}
}
