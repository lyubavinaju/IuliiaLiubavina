package com.epam.tc.hw6.service.listeners;

import com.epam.tc.hw6.service.utils.AttachmentUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenShotListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        Object driver = result.getTestContext().getAttribute("driver");
        if (driver instanceof TakesScreenshot) {
            AttachmentUtils.makeScreenShotAttachment(
                ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES));
        }
    }
}
