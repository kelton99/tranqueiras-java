package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String input = "anagram";
        String input2 = "margana";

        if(input.length() != input2.length())
            System.out.println("Not Anagrams");

        Map<Character, Integer> counter1 = new HashMap<>();
        Map<Character, Integer> counter2 = new HashMap<>();

        for(int i = 0; i < input.length() - 1; i++) {
            char c = Character.toUpperCase(input.charAt(i));
            char c2 = Character.toUpperCase(input2.charAt(i));

            if(counter1.containsKey(c)) {
                counter1.put(c, counter1.get(c) + 1);
            } else {
                counter1.put(c, 1);
            }

            if(counter2.containsKey(c2)) {
                counter2.put(c2, counter1.get(c2) + 1);
            } else {
                counter2.put(c2, 1);
            }
        }

        for(Entry)

    }
}
