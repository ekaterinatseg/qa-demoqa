package org.tsegelnikova.dto;

public class TestData {
    private String url;
    private String textFromChildFrame;
    private String textFromParentFrame;

    public TestData() {
    }

    public TestData(String steamUrl) {
        this.url = steamUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTextFromChildFrame() {
        return textFromChildFrame;
    }

    public void setTextFromChildFrame(String textFromChildFrame) {
        this.textFromChildFrame = textFromChildFrame;
    }

    public String getTextFromParentFrame() {
        return textFromParentFrame;
    }

    public void setTextFromParentFrame(String textFromParentFrame) {
        this.textFromParentFrame = textFromParentFrame;
    }
}
