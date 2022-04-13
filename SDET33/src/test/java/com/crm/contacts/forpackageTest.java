package com.crm.contacts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class forpackageTest {
	
@Parameters({"key1", "key2"})	
@Test
public void pack(String key1, String key2) {
	System.out.println(key1);
	System.out.println(key2);
}
}
