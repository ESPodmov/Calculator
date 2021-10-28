import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    protected Calculator calc;

    @BeforeEach
    void create() {
        calc = new Calculator();
    }

    @ParameterizedTest
    @ValueSource(doubles = {2.1, 20, 56, 203, -132, -464, -45446, 464846321})
    void additionTest(double number) {
        assertAll(
                () -> assertEquals(2 * number, calc.add(number, number), () -> "Doesn't add two positive numbers properly"),
                () -> assertEquals(0, calc.add(-number, number), () -> "Doesn't add a negative and a positive number properly"),
                () -> assertNotNull(calc, () -> "The calc variable should be initialized")
        );
    }

    @ParameterizedTest
    @ValueSource(doubles = {2, 6, 443543, 46546848, 1321, 453, 4, -14564, -46543, -28461})
    void divisionTest(double number) {
        assertAll(
                () -> assertEquals(calc.divide(number, 0.0), number < 0 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY),
                () -> assertEquals(calc.divide(number, number), 1.0),
                () -> assertEquals(calc.divide(0.0, number), number < 0 ? -0.0 : 0.0)
        );

    }


    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9, -15315, -461, -4546, 5226})
    void multiplicationTest(int number) {
        assertAll(
                () -> assertTrue(number < 0 ? number * (Math.random() * 10 + 1) < 0 : number * (Math.random() * 10 + 1) > 0, () -> "wrong multiplication result"),
                () -> assertTrue(number * number > 0),
                () -> assertEquals(0 * number, 0, () -> "wrong multiplication result")
        );
    }

//    @ParameterizedTest
//    @ValueSource(doubles = {45, 351, 34, 64, 334, 3, 4864, -54564, -546})
//    void testToFail(double number) {
//        assertSame(calc.divide(number, 2), number / 2.0, "This is different objects");
//    }
}


