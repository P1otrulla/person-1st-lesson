package dev.piotrulla.person_showcase;

public class Person {

    private String name;
    private String surName;
    private int age;

    Person(String name, String surName, int age) {
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name.isBlank()) {
            throw new PersonException("Imie nie moze byc puste!");
        }

        this.name = name;
    }

    public String getSurName() {
        return this.surName;
    }

    public void setSurName(String surName) {
        if (surName.isBlank()) {
            throw new PersonException("Nazwisko nie moze byc puste!");
        }

        this.surName = surName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static Person create(String name, String surName, int age) {
        return new Person(name, surName, age);
    }
}
