package utils;

import org.junit.jupiter.params.provider.Arguments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ResolutionsProvider {

    private static final String DESKTOP_RESOLUTIONS_FILE = "C:/Users/Admin/IdeaProjects/web-site_mtsbank.ru/src/test/resources/desktop_resolutions.csv";
    private static final String MOBILE_RESOLUTIONS_FILE = "C:/Users/Admin/IdeaProjects/web-site_mtsbank.ru/src/test/resources/mobile_resolutions.csv";

    /**
     * Метод читает CSV-файл (desktop_resolutions.csv) и возвращает разрешения экрана
     * в формате (width, height) для десктопных устройств.
     */
    public static Stream<Arguments> desktopScreenResolutions() throws IOException {
        return readResolutionsFromFile(DESKTOP_RESOLUTIONS_FILE);
    }

    /**
     * Метод читает CSV-файл (mobile_resolutions.csv) и возвращает разрешения экрана
     * в формате (width, height) для мобильных устройств.
     */
    public static Stream<Arguments> mobileScreenResolutions() throws IOException {
        return readResolutionsFromFile(MOBILE_RESOLUTIONS_FILE);
    }

    /**
     * Общий метод для чтения разрешений экрана из указанного CSV-файла.
     *
     * @param filePath путь к CSV-файлу
     * @return поток аргументов (width, height)
     * @throws IOException если файл не найден или недоступен
     */
    private static Stream<Arguments> readResolutionsFromFile(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath))
                .stream()
                .map(line -> line.split(","))
                .map(parts -> Arguments.of(parts[0].trim(), parts[1].trim()));
    }
}
