package utils;

import org.junit.jupiter.params.provider.Arguments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class ResolutionsProvider {

    private static final String DESKTOP_RESOLUTIONS_FILE = "desktop_resolutions.csv";
    private static final String MOBILE_RESOLUTIONS_FILE = "mobile_resolutions.csv";

    public static Stream<Arguments> desktopScreenResolutions() throws IOException {
        return readResolutionsFromFile(DESKTOP_RESOLUTIONS_FILE);
    }

    public static Stream<Arguments> mobileScreenResolutions() throws IOException {
        return readResolutionsFromFile(MOBILE_RESOLUTIONS_FILE);
    }

    private static Stream<Arguments> readResolutionsFromFile(String fileName) throws IOException {
        ClassLoader classLoader = ResolutionsProvider.class.getClassLoader();
        try (var inputStream = classLoader.getResourceAsStream(fileName)) {
            if (inputStream == null) {
                throw new IOException("File not found in resources: " + fileName);
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                return reader.lines()
                        .map(line -> line.split(","))
                        .map(parts -> Arguments.of(parts[0].trim(), parts[1].trim()));
            }
        }
    }
}
