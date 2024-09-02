package br.com.bruno;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ArraysCompareTest {

    @Test
    void compareArrays() {
        // Given
        int[] numbers = {25, 8, 21, 32, 3};
        int[] expected = {3, 8, 21, 25, 32};

        // When
        Arrays.sort(numbers);

        // Then
        assertArrayEquals(expected, numbers);
    }

}
