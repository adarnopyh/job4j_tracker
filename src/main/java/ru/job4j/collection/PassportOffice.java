package ru.job4j.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean result = true;
        for (String key : citizens.keySet()) {
            if (citizens.containsKey(key)) {
                result = false;
                break;
            }
        }
        citizens.put(citizen.getPassport(), citizen);
        return result;
    }

    public Citizen get(String passport) {
        return citizens.get(passport);
    }
}