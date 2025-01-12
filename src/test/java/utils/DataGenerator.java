package utils;

import java.util.Random;

public class DataGenerator {

    private static final Random random = new Random();

    public static String generatePhoneNumber() {
        return String.format("+7 %03d %03d-%02d-%02d",
                random.nextInt(1000),
                random.nextInt(1000),
                random.nextInt(100),
                random.nextInt(100));
    }

    public static String generateBirthDate() {
        int day = random.nextInt(28) + 1;
        int month = random.nextInt(12) + 1;
        int year = 1960 + random.nextInt(2023 - 1960 + 1);
        return String.format("%02d.%02d.%d", day, month, year);
    }

    public static String generateEmail() {
        String username = "user" + System.currentTimeMillis();
        String domain = "example";
        String tld = "ru";
        return username + "@" + domain + "." + tld;
    }

    public static String generateFullName() {
        String[] firstNames = {"Михаил", "Сергей", "Степан", "Ян"};
        String[] lastNames = {"Русских", "Петров", "Яичкин", "Арчибасова"};
        String[] middleNames = {"Иванович", "Петрович", "Акакиевич", "Федотович"};
        return lastNames[random.nextInt(lastNames.length)] + " " +
                firstNames[random.nextInt(firstNames.length)] + " " +
                middleNames[random.nextInt(middleNames.length)];
    }

    public static String rearrangeFullName(String fullName) {
        if (fullName == null || fullName.split(" ").length != 3) {
            throw new IllegalArgumentException("Invalid full name format. Expected format: 'Фамилия Имя Отчество'");
        }
        String[] parts = fullName.split(" ");
        return parts[1] + " " + parts[2] + " " + parts[0];
    }
}
