package curs19;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ConditionalTestSkip.class)
public class TestClass {
	
	
	@Test
	public void testCase1() {
		System.out.println("Run test case 1");
	}
	
	@RuleazaDoarPeGermania
	@Test
	public void testCase2() {
		System.out.println("Run test case 2");
	}
	
	@Test
	public void testCase3() {
		System.out.println("Run test case 3");
	}

}
