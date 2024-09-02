package br.com.bruno.math;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math Operations in SimpleMath Class")
public class SimpleMathTest {

    private static final double EPSILON = 0.00001;

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

    @Test
    @DisplayName("Test 6.2 + 2 = 8.2")
    void testSum_When_SixDotTwoIsAddedByTwo_ShouldReturn_EightDotTwo() {
        // Given / Arrange
        double firstValue = 6.2d;
        double secondValue = 2d;
        double expected = 8.2d;

        // When / Act
        double actual = math.sum(firstValue, secondValue);

        // Then / Assert
        assertEquals(expected, actual, "The testSum() did not produce expected result");
    }

    @Test
    @DisplayName("Test 6.2 - 10 = -3.8")
    void testSubtraction_When_SixDotTwoIsSubtractedByTen_ShouldReturn_NegativeTreeDotEight() {
        // Given / Arrange
        double firstValue = 6.2d;
        double secondValue = 10d;
        double expected = -3.8;

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
    void testMultiplication_When_AnyNumberIsMultipliedByZero_ShouldReturn_Zero(){
        // Given / Arrange
        double firstValue = Math.random();
        double secondValue = 0d;
        double expected = 0d;

        // When / Act
        double actual = math.multiplication(firstValue, secondValue);

        // Then / Assert
        assertEquals(expected, actual, EPSILON, "The testMultiplication() did not produce expected result");
    }

    @Test
    @DisplayName("Test 2 / 6 = 0.333...")
    void testDivision_When_TwoDividedBySix_ShouldReturn_ZeroDotThreeThreeThreeAndSoOn() {
        // Given / Arrange
        double firstValue = 2d;
        double secondValue = 6d;
        double expected = 1d / 3d;

        // When / Act
        double actual = math.division(firstValue, secondValue);

        // Then / Assert
        assertEquals(expected, actual, EPSILON, "The testDivision() did not produce expected result");
    }

    @Test
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

    @Test
    @DisplayName("Test (2 + 6) / 2 = 4")
    void testMean_When_TwoAndSix_ShouldReturn_Four() {
        // Given / Arrange
        double firstValue = 2d;
        double secondValue = 6d;
        double expected = 4;

        // When / Act
        double actual = math.mean(firstValue, secondValue);

        // Then / Assert
        assertEquals(expected, actual, "The testMean() did not produce expected result");
    }

    @Test
    @DisplayName("Test (2 + 6 - 2) / 3 = 2")
    void testMean_When_TwoSixAndNegativeTwo_ShouldReturnTwo() {
        // Given / Arrange
        double firstValue = 2d;
        double secondValue = 6d;
        double thirdValue = -2d;
        double expected = 2d;

        // When / Act
        double actual = math.mean(firstValue, secondValue, thirdValue);

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

    @Test
    @DisplayName("Test sqrt of -1 = NaN")
    void testSquareRoot_When_NegativeNumber_ShouldReturn_NaN() {
        // Given / Arrange
        double value = -1d;

        // When / Act
        double actual = math.squareRoot(value);

        // Then / Assert
        assertTrue(Double.isNaN(actual), "The testSquareRoot() did not produce NaN when number is negative");
    }

}
