package com.example.strengboot_lesson_1.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class Person {
    @NotBlank//есть хоть 1 символ не пробельный
    @Size(min = 2, max = 20)//размер имени
    private String name;
    @Min(0)
    @Max(150)
    private int age;

    public Person() {//конструктор без аргументоы нужен библиотеке джексон для сериализвции десериализации
    }

    public Person(String name, int afe) {
        this.name = name;
        this.age = afe;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", afe=" + age +
                '}';
    }
}
