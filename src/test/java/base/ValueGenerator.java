package base;

import org.apache.commons.lang3.RandomStringUtils;

public final class ValueGenerator {

    private ValueGenerator() {
    }

    public static String generate(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public static String generateAlphabetic(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String generateNumeric(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public static String generateEmail(int length, String hostPart) {
        return RandomStringUtils.randomAlphabetic(length) + hostPart;

    }
}
