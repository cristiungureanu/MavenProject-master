package curs17;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNgListener.class)
public class TestClass {
	
	
	@Test
	public void testLogin() {
		
	}
	
	@Test
	public void testProduct() {
		
		assertTrue(false);
		
	}
	

}
