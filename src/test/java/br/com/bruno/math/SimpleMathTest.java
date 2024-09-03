package br.com.bruno.math;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math Operations in SimpleMath Class")
public class SimpleMathTest {

    private static final double EPSILON = 0.001;

    private SimpleMath math;

    @BeforeAll
    static void setup() {
        // System.out.println("Running @BeforeAll method");
    }

    @AfterAll
    static void cleanup() {
        // System.out.println("Running @AfterAll method");
    }

    @BeforeEach
    void beforeEach() {
        // System.out.println("Running @BeforeEach method");
        this.math = new SimpleMath();
    }

    @AfterEach
    void afterEach() {
        // System.out.println("Running @AfterEach method");
    }

    @ParameterizedTest
    @CsvSource({
            "6.2, 2, 8.2",
            "5.1, -3.4, 1.7",
            "2, -5.2, -3.2"
    })
    @DisplayName("testSum [firstValue, secondValue, expected]")
    void testSum(double firstValue, double secondValue, double expected) {
        // When / Act
        double actual = math.sum(firstValue, secondValue);

        // Then / Assert
        assertEquals(expected, actual, EPSILON, "The testSum() did not produce expected result");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testFiles/testSubtraction.csv")
    @DisplayName("testSubtraction [firstValue, secondValue, expected]")
    void testSubtraction(double firstValue, double secondValue, double expected) {
        // When / Act
        double actual = math.subtraction(firstValue, secondValue);

        // Then / Assert
        assertEquals(expected, actual, EPSILON, "The testSubtraction() did not produce expected result");
    }

    @Test
    @DisplayName("Test 7.3 * 3 = 21.9")
    void testMultiplication_When_SevenDotThreeIsMultipliedByThree_ShouldReturn_TwentyOneDotNine() {
        // Given / Arrange
        double firstValue = 7.3d;
        double secondValue = 3d;
        double expected = 21.9;

        // When / Act
        double actual = math.multiplication(firstValue, secondValue);

        // Then / Assert
        assertEquals(expected, actual, EPSILON, "The testMultiplication() did not produce expected result");
    }

    @Test
    @DisplayName("Test X * 0 = 0")
    void testMultiplication_When_AnyNumberIsMultipliedByZero_ShouldReturn_Zero() {
        // Given / Arrange
        double firstValue = Math.random();
        double secondValue = 0d;
        double expected = 0d;

        // When / Act
        double actual = math.multiplication(firstValue, secondValue);

        // Then / Assert
        assertEquals(expected, actual, EPSILON, "The testMultiplication() did not produce expected result");
    }

//    static Stream<Arguments> testDivisionInputParameters() {
    static Stream<Arguments> testDivision() {
        // Given / Arrange
        return Stream.of(
                Arguments.of(6.2d, 2d, 3.1d),
                Arguments.of(71d, 14d, 5.071d),
                Arguments.of(18.3d, 3.1d, 5.903d)
        );
    }

    @ParameterizedTest
//    @MethodSource("testDivisionInputParameters")
    @MethodSource
    @DisplayName("testDivision [firstValue, secondValue, expect]")
    void testDivision(double firstValue, double secondValue, double expected) {
        // When / Act
        double actual = math.division(firstValue, secondValue);

        // Then / Assert
        assertEquals(expected, actual, EPSILON, "The testDivision() did not produce expected result");
    }

    @RepeatedTest(3)
    @DisplayName("Test X / 0 = Infinite")
    void testDivision_When_AnyNumberIsDividedByZero_ShouldReturn_Infinite() {
        // Given / Arrange
        double firstValue = Math.random() + 1;
        double secondValue = 0d;

        // When / Act
        double actual = math.division(firstValue, secondValue);

        // Then / Assert
        assertTrue(Double.isInfinite(actual), "The testDivision() did not produce infinity when dividing by zero");
    }

    static Stream<Arguments> testMean() {
        return Stream.of(
                Arguments.of(4, new double[]{2, 6}),
                Arguments.of(2, new double[]{2, 6, -2})
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("testMean [expected, values...]")
    void testMean(double expected, double ... values) {
        // When / Act
        double actual = math.mean(values);

        // Then / Assert
        assertEquals(expected, actual, "The testMean() did not produce expected result");
    }

    @Test
    @DisplayName("Test sqrt of 49 = 7")
    void testSquareRoot_When_FortyNine_ShouldReturn_Seven() {
        // Given / Arrange
        double value = 49d;
        double expected = 7d;

        // When / Act
        double actual = math.squareRoot(value);

        // Then / Assert
        assertEquals(expected, actual, EPSILON, "The testSquareRoot() did not produce expected result");
    }

    @RepeatedTest(3)
    @DisplayName("Test sqrt of negative number throw ArithmeticException")
    void testSquareRoot_When_NegativeNumber_ShouldThrow_ArithmeticException() {
        // Given
        double value = -(new Random().nextInt(100) + 1);
        String expectedMessage = "It's no possible to extract the square root of a negative number!";

        // When & Then
        Exception actualException = assertThrows(ArithmeticException.class,
                () -> math.squareRoot(value),
                "The testSquareRoot() did not threw ArithmeticException");
        assertEquals(expectedMessage, actualException.getMessage(),
                "The testSquareRoot() threw ArithmeticException with unexpect message");
    }

}
