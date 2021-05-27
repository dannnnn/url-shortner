package com.codeflow.shortner.conversion;

import com.codeflow.shortner.Conversion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Base62Conversion implements Conversion {

    private final Map<Character, Integer> charValueMap = new HashMap<>();
    private final List<Character> characters = new ArrayList<>();

    public Base62Conversion() {
        populateAlphabet('a', 'z', charValueMap.size());
        populateAlphabet('A', 'Z', charValueMap.size());
        populateAlphabet('0', '9', charValueMap.size());
    }

    private void populateAlphabet(char startChar, char endChar, int offset) {
        for (var nextChar = startChar; nextChar < endChar + 1; nextChar++) {
            int value = nextChar - startChar + offset;
            charValueMap.put(nextChar, value);
            characters.add(nextChar);
        }
    }

    @Override
    public String encode(Long id) {
        List<Integer> integers = encodeBase10ToBase62(id);
        var key = new StringBuilder();
        integers.forEach(i -> key.append(characters.get(i)));
        return key.toString();
    }

    @Override
    public Long decode(String key) {
        char[] charArray = key.toCharArray();
        return decodeBase62ToBase10(charArray);
    }

    private Long decodeBase62ToBase10(char[] characters) {
        long id = 0;
        int exponent = characters.length - 1;
        for (char character : characters) {
            int base10Value = charValueMap.get(character);
            id += base10Value * Math.pow(charValueMap.size(), exponent);
            exponent = exponent - 1;
        }
        return id;
    }

    private List<Integer> encodeBase10ToBase62(Long id) {
        LinkedList<Integer> remainders = new LinkedList<>();
        while (id > 0) {
            int remainder = id.intValue() % charValueMap.size();
            remainders.addFirst(remainder);
            id /= charValueMap.size();
        }
        return remainders;
    }
}
