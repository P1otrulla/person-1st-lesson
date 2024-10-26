package dev.piotrulla.person_showcase;

import java.util.List;

public class PersonService {

    private static final String INTRODUCE_MESSAGE = "Nazywam sie %s %s, mam %s lat!";
    private static final List<String> INTRODUCE_LIST_MESSAGE = List.of(
            "Mam na imie: {NAME}",
            "Moje nazwisko rodowe: {SUR-NAME}",
            "Mam {AGE} lat!",
            "Urodzilem sie w {BIRTH-YEAR} roku!"
    );

    public void sendIntroduce(Person person) {
        String format = String.format(
                INTRODUCE_MESSAGE,
                person.getName(),
                person.getSurName(),
                person.getAge()
        );

        System.out.println(format);
    }

    public void sendIntroduceListMessage(Person person) {
        INTRODUCE_LIST_MESSAGE.forEach(line -> System.out.println(PersonUtil.format(person, line)));
    }
}
