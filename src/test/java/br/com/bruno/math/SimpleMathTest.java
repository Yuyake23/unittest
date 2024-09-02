package br.com.bruno.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math Operations in SimpleMath Class")
public class SimpleMathTest {

    private static final double EPSILON = 0.00001;

    private SimpleMath math;

    @BeforeEach
    void setUp() {
        this.math = new SimpleMath();
    }

    @Test
    @DisplayName("Teste 6.2 + 2 = 8.2")
    void testSum_When_SixDotTwoIsAddedByTwo_ShouldReturn_EightDotTwo() {
        double actual = math.sum(6.2d, 2d);
        assertEquals(8.2d, actual, "The testSum() did not produce expected result");
    }

    @Test
    @DisplayName("Test 6.2 - 10 = -3.8")
    void testSubtraction_When_SixDotTwoIsSubtractedByTen_ShouldReturn_NegativeTreeDotEight() {
        double actual = math.subtraction(6.2d, 10d);
        assertEquals(-3.8d, actual, EPSILON, "The testSubtraction() did not produce expected result");
    }

    @Test
    @DisplayName("Test 7.3 * 3 = 21.9")
    void testMultiplication_When_SevenDotThreeIsMultipliedByThree_ShouldReturn_TwentyOneDotNine() {
        double actual = math.multiplication(7.3d, 3d);
        assertEquals(21.9d, actual, EPSILON, "The testMultiplication() did not produce expected result");
    }

    @Test
    @DisplayName("Test X * 0 = 0")
    void testMultiplication_When_AnyNumberIsMultipliedByZero_ShouldReturn_Zero(){
        double actual = math.multiplication(Math.random(), 0d);
        assertEquals(0d, actual, EPSILON, "The testMultiplication() did not produce expected result");
    }

    @Test
    @DisplayName("Test 2 / 6 = 0.333...")
    void testDivision_When_TwoDividedBySix_ShouldReturn_ZeroDotThreeThreeThreeAndSoOn() {
        double actual = math.division(2d, 6d);
        assertEquals(1d / 3d, actual, EPSILON, "The testDivision() did not produce expected result");
    }

    @Test
    @DisplayName("Test X / 0 = Infinite")
    void testDivision_When_AnyNumberIsDividedByZero_ShoulReturn_Infinite() {
        double actual = math.division(Math.random() + 1, 0d);
        assertTrue(Double.isInfinite(actual), "The testDivision() did not produce infinity when dividing by zero");
    }

    @Test
    @DisplayName("Test (2 + 6) / 2 = 4")
    void testMean_When_TwoAndSix_ShouldReturn_Four() {
        double actual = math.mean(2d, 6d);
        assertEquals(4d, actual, "The testMean() did not produce expected result");
    }

    @Test
    @DisplayName("Test (2 + 6 - 2) / 3 = 2")
    void testMean_When_TwoSixAndNegativeTwo_ShouldReturnTwo() {
        double actual = math.mean(2d, 6d, -2d);
        assertEquals(2d, actual, "The testMean() did not produce expected result");
    }

    @Test
    @DisplayName("Test sqrt of 49 = 7")
    void testSquareRoot_When_FortyNine_ShouldReturn_Seven() {
        double actual = math.squareRoot(49d);
        assertEquals(7d, actual, EPSILON, "The testSquareRoot() did not produce expected result");
    }

    @Test
    @DisplayName("Test sqrt of -1 = NaN")
    void testSquareRoot_When_NegativeNumber_ShouldReturn_NaN() {
        double actual = math.squareRoot(-1);
        assertTrue(Double.isNaN(actual), "The testSquareRoot() did not produce NaN when number is negative");
    }

}
