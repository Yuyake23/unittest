package br.com.bruno;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

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

    @SuppressWarnings("MismatchedReadAndWriteOfArray")
    @Test
    @Timeout(value = 15, unit = TimeUnit.MILLISECONDS)
    void testSortPerformance() {
        int[] numbers = {25, 8, 21, 32, 3};

        // Just spending time
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            numbers[0] = i;
            Arrays.sort(numbers);
        }


    }

}
