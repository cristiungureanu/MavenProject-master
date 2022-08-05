package curs19;

import java.lang.reflect.Method;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.SkipException;

public class ConditionalTestSkip implements IInvokedMethodListener{

	public static String country = "DE";
	
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		
		//tester obj = new tester() //implemetare de Generics
		// for (Method metod : obj.getClass().getDeclaredMethods())
		// metod.isAnnotationPresent(RuleazaDoarpeGermania.class)
		
		
		Method metoda = testResult.getMethod().getConstructorOrMethod().getMethod();
		
		if(metoda == null) {
			return;
		}
		if(metoda.isAnnotationPresent(RuleazaDoarPeGermania.class) && !country.equals("DE")) {
			throw new SkipException("Metoda asta trebuie sa ruleze doar pe Germania!");
			
		}
		return;
	}
	
	

}
