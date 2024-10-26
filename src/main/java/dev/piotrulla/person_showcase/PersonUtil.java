package dev.piotrulla.person_showcase;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.function.Function;

public final class PersonUtil {

    private static final Function<Person, Map<String, String>> PLACEHOLDERS = person -> Map.of(
            PersonConstants.PERSON_NAME_PLACEHOLDER, person.getName(),
            PersonConstants.PERSON_SURNAME_PLACEHOLDER, person.getSurName(),
            PersonConstants.PERSON_AGE_PLACEHOLDER, String.valueOf(person.getAge()),
            PersonConstants.PERSON_BIRTH_YEAR_PLACEHOLDER, getYearOfBirth(person.getAge())
    );

    private PersonUtil() {
    }

    public static String format(Person person, String message) {
        return replacePlaceholders(message, PLACEHOLDERS.apply(person));
    }

    static String getYearOfBirth(int age) {
        if (age <= 0) {
            throw new PersonException("Wiek nie moze byc mniejszy lub rowny 0!");
        }

        if (age > 115) {
            throw new PersonException("Kolego, nie przesadzaj z wiekiem!");
        }

        Instant now = Instant.now();

        ZonedDateTime zonedDateTime = now.atZone(ZoneId.systemDefault());
        int year = zonedDateTime.getYear();

        return String.valueOf(year - age);
    }

    static String replacePlaceholders(String message, Map<String, String> placeholders) {
        for (Map.Entry<String, String> entry : placeholders.entrySet()) {
            message = message.replace(entry.getKey(), entry.getValue());
        }
        return message;
    }
}
