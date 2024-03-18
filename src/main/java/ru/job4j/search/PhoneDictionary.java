package ru.job4j.search;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> namePredicate = name -> Objects.equals(key, name.getName());
        Predicate<Person> surnamePredicate = surname -> Objects.equals(key, surname.getSurname());
        Predicate<Person> phonePredicate = phone -> Objects.equals(key, phone.getPhone());
        Predicate<Person> addressPredicate = address -> Objects.equals(key, address.getAddress());
        Predicate<Person> combine = namePredicate
                .or(surnamePredicate)
                .or(phonePredicate)
                .or(addressPredicate);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}