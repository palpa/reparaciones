package com.amp.commons.properties;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PropertiFileTest {
	
	PropertiFile properiFile;
	
	@Before
	public void setUp(){
		properiFile = new PropertiFile(PropertiFile.SEARCH_FILE_PROPERTI);
	}
	
	@Test
	public void test() {
		
		String myProperti = properiFile.getProperti("asd");
		
		System.out.println(myProperti);
		assertNotNull(myProperti);
		
	}

}
