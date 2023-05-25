package org.tsegelnikova.dto;

public class Config {
    private String browserArguments;
    private String browserName;
    private int implicitWaitTimeout;
    private int standardWaitTimeout;

    public Config() {
    }

    public String getBrowserArguments() {
        return browserArguments;
    }

    public void setBrowserArguments(String browserArguments) {
        this.browserArguments = browserArguments;
    }

    public int getImplicitWaitTimeout() {
        return implicitWaitTimeout;
    }

    public void setImplicitWaitTimeout(int implicitWaitTimeout) {
        this.implicitWaitTimeout = implicitWaitTimeout;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public int getStandardWaitTimeout() {
        return standardWaitTimeout;
    }

    public void setStandardWaitTimeout(int standardWaitTimeout) {
        this.standardWaitTimeout = standardWaitTimeout;
    }
}
