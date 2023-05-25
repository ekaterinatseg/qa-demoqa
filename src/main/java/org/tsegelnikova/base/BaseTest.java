package org.tsegelnikova.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import org.tsegelnikova.config.BrowsersFactory;
import org.tsegelnikova.util.ParsingUtil;

public abstract class BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    @BeforeMethod
    public void setUp() {
        LOGGER.info("Starting setUp method");
        BrowsersFactory.getDriver().get(ParsingUtil.getTestData().getUrl());
    }

    @AfterMethod
    public static void tearDown() {
        BrowsersFactory.quit();
    }
}
