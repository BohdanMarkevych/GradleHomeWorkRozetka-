package test;

import Decorator.Button;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.logging.Logger;

public class CustomerTestLisener implements ITestListener {
    public static Logger logger = Logger.getLogger((Button.class).toString());

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test was started "+ result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Passed tests: "+ context.getPassedTests());
        logger.info("Failure tests: "+ context.getFailedTests());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult){
        logger.info("Result was success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("Result was failure");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
       logger.info("Result was skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }
}
