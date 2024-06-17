

package JavaCodingProblems.DeepDiveFunctional;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReplaceTest {

    @Test
    void replace() {
        List<String> input = Arrays.asList("apple", "banana", "cherry");
        List<String> expected = Arrays.asList("APPLE", "BANANA", "CHERRY");

        List<String> actual = Replace.replace(input, s -> s.toUpperCase());

        assertEquals(expected, actual);
    }

    @Test
    void replaceWithEmptyList() {
        List<String> input = new ArrayList<>();
        List<String> expected = new ArrayList<>();

        List<String> actual = Replace.replace(input, s -> s.toUpperCase());

        assertEquals(expected, actual);
    }

    @Test
    void replaceWithNullReplacer() {
        List<String> input = Arrays.asList("apple", "banana", "cherry");

        assertThrows(NullPointerException.class, () -> Replace.replace(input, null));
    }
}
