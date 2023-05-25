package org.tsegelnikova.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.tsegelnikova.dto.Config;
import org.tsegelnikova.dto.TestData;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class ParsingUtil {
    private ParsingUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static Config getConfig() {
        ObjectMapper mapper = new ObjectMapper();
        URL resource = Config.class.getClassLoader().getResource("Config.json");
        assert resource != null;
        File file;
        try {
            file = new File(resource.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        try {
            return mapper.readValue(file, Config.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static TestData getTestData() {
        ObjectMapper mapper = new ObjectMapper();
        URL resource = TestData.class.getClassLoader().getResource("TestData.json");
        assert resource != null;
        File file;
        try {
            file = new File(resource.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        try {
            return mapper.readValue(file, TestData.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
