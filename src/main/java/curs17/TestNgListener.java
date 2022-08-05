package curs17;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class TestNgListener implements ITestListener{

	//defineste unde sa scrie
	@Override
	public void onTestStart(ITestResult result) {
		Log.info("+++++++++++++++++++++++++++++++++++++++++++++");
		Log.info("+ Strat test case : "+ result.getMethod().getMethodName()+ "++++++++++++");
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Log.info("Start time :" + timeStamp);
		Log.info("+++++++++++++++++++++++++++++++++++++++++++++");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Log.info("+++++++++++++++++++++++++++++++++++++++++++++");
		Log.info("+ PASSED test case : "+ result.getMethod().getMethodName()+ "++++++++++++");
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Log.info("PASSED time :" + timeStamp);
		Log.info("+++++++++++++++++++++++++++++++++++++++++++++");		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Log.error("+++++++++++++++++++++++++++++++++++++++++++++");
		Log.error("+ FAILED test case : "+ result.getMethod().getMethodName()+ "++++++++++++");
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Log.error("FAILED time :" + timeStamp);
		Log.error(result.getThrowable().toString());
		Log.error("+++++++++++++++++++++++++++++++++++++++++++++");
	}

	

}
