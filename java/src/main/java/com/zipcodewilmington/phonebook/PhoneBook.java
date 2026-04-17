package com.zipcodewilmington.phonebook;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */


public class PhoneBook {

    public static void main(String[] args){
    PhoneBook pb = new PhoneBook();
    pb.add("John", "3026354125");
    pb.add("James", "123456789");
    pb.add("Kenneth", "987654321");

    System.out.println(pb.lookup("Michael"));       
    System.out.println(pb.hasEntry("Kenneth"));   
    System.out.println(pb.reverseLookup("3026354125")); 
    System.out.println(pb.getAllContactNames());
}

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        if(map == null){
            this.phonebook = new LinkedHashMap<>() ;
        } else {
            this.phonebook = new LinkedHashMap<>(map); 
        }
    }

    public PhoneBook() {
        this(null);
    }

    public void add(String name, String phoneNumber) {
        if(phonebook.containsKey(name)) {
            List<String> pNumber = phonebook.get(name);
            pNumber.add(phoneNumber);
        } else {
            List<String> newList = new ArrayList<>();
            newList.add(phoneNumber);
            phonebook.put(name, newList);
        }
    }

    public void addAll(String name, String... phoneNumbers) {
        for(int i = 0; i < phoneNumbers.length; i++) {
            add(name, phoneNumbers[i]);
        }
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        if(phonebook.containsKey(name)){
            List<String> result = phonebook.get(name);
            return result;
        } else {
            return new ArrayList<>();
        }
    }

    public String reverseLookup(String phoneNumber) {
    for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
        String name = entry.getKey();
        List<String> numbers = entry.getValue();

        if (numbers.contains(phoneNumber)) {
            return name;
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        return new ArrayList<>(phonebook.keySet());
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
