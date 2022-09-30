package anhtester.com.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.apache.commons.lang3.StringUtils.repeat;

public class TestListener implements ITestListener {

    private void logMessage(final String message) {
        Log.info(repeat("=", 60));
        Log.info(message);
        Log.info(repeat("=", 60));
    }

    @Override
    public void onTestStart(final ITestResult result) {
        logMessage("Test Execution Started..." + result.getName());
    }

    @Override
    public void onTestSuccess(final ITestResult result) {
        logMessage("Test Passed Successfully. " + result.getName());

    }

    @Override
    public void onTestFailure(final ITestResult result) {
        logMessage("Test Failed!!!! " + result.getName());
    }

    @Override
    public void onFinish(final ITestContext context) {
        logMessage("Test Execution Completed Successfully for all tests!!" + context.getSuite()
                .getAllMethods());

    }

}