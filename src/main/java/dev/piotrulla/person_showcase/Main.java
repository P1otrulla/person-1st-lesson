package dev.piotrulla.person_showcase;

public class Main {

    public static void main(String[] args) {
        var personService = new PersonService();

        var person = Person.create("Piotr", "Zych", 21);

        personService.sendIntroduce(person);

        sendEmptyLines();

        personService.sendIntroduceListMessage(person);

        sendEmptyLines();

        sendDolarTree();
    }

    static void sendEmptyLines() {
        for (int i = 0; i < 2; i++) {
            System.out.println(" ");
        }
    }

    static void sendDolarTree() {
        String dolar = "$";

        for (int i = 0; i < 10; i++) {
            System.out.println(dolar.repeat(i));
        }
    }
}