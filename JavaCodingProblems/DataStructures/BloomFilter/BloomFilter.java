package JavaCodingProblems.DataStructures.BloomFilter;

import java.util.BitSet;

public class BloomFilter {
    private static final int DEFAULT_SIZE = 1 << 25;
    private BitSet bits = new BitSet(DEFAULT_SIZE);
    private int[] seeds = new int[]{5, 7, 11, 13, 31, 37, 61};

    public void add(String value) {
        for (int seed : seeds) {
            int hash = hash(value, seed);
            bits.set((hash & Integer.MAX_VALUE) % DEFAULT_SIZE);
        }
    }

    public boolean contains(String value) {
        if (value == null) {
            return false;
        }
        boolean result = true;
        for (int seed : seeds) {
            int hash = hash(value, seed);
            result = result && bits.get((hash & Integer.MAX_VALUE) % DEFAULT_SIZE);
        }
        return result;
    }

    private int hash(String string, int seed) {
        int result = 0;
        int len = string.length();
        for (int i = 0; i < len; i++) {
            result = seed * result + string.charAt(i);
        }
        return (result & Integer.MAX_VALUE);
    }
}

