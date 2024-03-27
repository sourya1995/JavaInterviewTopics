package DesignPatterns.Iterator;

import java.util.Iterator;

public class AlphabetIterator implements Iterable<Character> {

    @Override
    public Iterator<Character> iterator() {
       return new Iterator<Character>() {
            char letter = 'a';

            @Override
            public boolean hasNext() {
                return letter <= 'z';
            }

            @Override
            public Character next() {
                return letter++;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };

       };

       public static void main(String[] args) {
            for (char letter : new AlphabetIterator()) {
                System.out.println(letter);
            }
       
       }
    }
    

