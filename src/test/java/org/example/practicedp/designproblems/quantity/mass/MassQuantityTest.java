package org.example.practicedp.designproblems.quantity.mass;

import org.junit.jupiter.api.Test;

import static org.example.practicedp.designproblems.quantity.mass.MassUnit.GRAM;
import static org.example.practicedp.designproblems.quantity.mass.MassUnit.KILOGRAM;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MassQuantityTest {

    private static final double DELTA = 1e-9;

    @Test
    void shouldConvertHundredGramsToPointOneKilogram() {
        MassQuantity result = GRAM.of(100)
                .to(KILOGRAM);

        assertEquals(0.1, result.value(), DELTA);
        assertEquals(KILOGRAM, result.unit());
    }

    @Test
    void shouldConvertOneKilogramToThousandGrams() {
        MassQuantity result = KILOGRAM.of(1)
                .to(GRAM);

        assertEquals(1000.0, result.value(), DELTA);
        assertEquals(GRAM, result.unit());
    }

    @Test
    void shouldAddGramsToKilogramsAndPreserveKilogramUnit() {
        MassQuantity result = KILOGRAM.of(1)
                .plus(GRAM.of(500));

        assertEquals(1.5, result.value(), DELTA);
        assertEquals(KILOGRAM, result.unit());
    }

    @Test
    void shouldAddKilogramsToGramsAndPreserveGramUnit() {
        MassQuantity result = GRAM.of(500)
                .plus(KILOGRAM.of(0.5));

        assertEquals(1000.0, result.value(), DELTA);
        assertEquals(GRAM, result.unit());
    }

    @Test
    void shouldSubtractGramsFromKilograms() {
        MassQuantity result = KILOGRAM.of(1)
                .minus(GRAM.of(500));

        assertEquals(0.5, result.value(), DELTA);
        assertEquals(KILOGRAM, result.unit());
    }

    @Test
    void shouldAddQuantitiesHavingSameUnit() {
        MassQuantity result = KILOGRAM.of(1.5)
                .plus(KILOGRAM.of(2.5));

        assertEquals(4.0, result.value(), DELTA);
        assertEquals(KILOGRAM, result.unit());
    }

    @Test
    void shouldAllowNegativeResultAfterSubtraction() {
        MassQuantity result = GRAM.of(100)
                .minus(GRAM.of(200));

        assertEquals(-100.0, result.value(), DELTA);
        assertEquals(GRAM, result.unit());
    }

    @Test
    void shouldHandleZeroValue() {
        MassQuantity result = KILOGRAM.of(0)
                .plus(GRAM.of(500));

        assertEquals(0.5, result.value(), DELTA);
        assertEquals(KILOGRAM, result.unit());
    }

    @Test
    void shouldRejectNaN() {
        assertThrows(
                IllegalArgumentException.class,
                () -> GRAM.of(Double.NaN)
        );
    }

    @Test
    void shouldRejectPositiveInfinity() {
        assertThrows(
                IllegalArgumentException.class,
                () -> KILOGRAM.of(Double.POSITIVE_INFINITY)
        );
    }

    @Test
    void shouldRejectNullTargetUnit() {
        MassQuantity quantity = KILOGRAM.of(1);

        assertThrows(
                NullPointerException.class,
                () -> quantity.to(null)
        );
    }

    @Test
    void shouldRejectNullQuantityDuringAddition() {
        MassQuantity quantity = KILOGRAM.of(1);

        assertThrows(
                NullPointerException.class,
                () -> quantity.plus(null)
        );
    }

    @Test
    void shouldRejectNullQuantityDuringSubtraction() {
        MassQuantity quantity = KILOGRAM.of(1);

        assertThrows(
                NullPointerException.class,
                () -> quantity.minus(null)
        );
    }

    @Test
    void shouldReturnReadableStringRepresentation() {
        MassQuantity quantity = KILOGRAM.of(1.5);

        assertEquals("1.5 kg", quantity.toString());
    }

    @Test
    void shouldRejectNegativeInfinity() {
        assertThrows(
                IllegalArgumentException.class,
                () -> KILOGRAM.of(Double.NEGATIVE_INFINITY)
        );
    }

    @Test
    void shouldMultiplyQuantityByScalar() {
        MassQuantity result = GRAM.of(250)
                .multiplyBy(3);

        assertEquals(750.0, result.value(), DELTA);
        assertEquals(GRAM, result.unit());
    }

    @Test
    void shouldDivideQuantityByDivisor() {
        MassQuantity result = KILOGRAM.of(2)
                .divideBy(4);

        assertEquals(0.5, result.value(), DELTA);
        assertEquals(KILOGRAM, result.unit());
    }

    @Test
    void shouldRejectDivisionByZero() {
        MassQuantity quantity = GRAM.of(100);

        assertThrows(
                IllegalArgumentException.class,
                () -> quantity.divideBy(0.0)
        );
    }

    @Test
    void shouldRejectNaNScalarInMultiplyBy() {
        MassQuantity quantity = GRAM.of(10);

        assertThrows(
                IllegalArgumentException.class,
                () -> quantity.multiplyBy(Double.NaN)
        );
    }

    @Test
    void shouldRejectInfinityDivisorInDivideBy() {
        MassQuantity quantity = GRAM.of(10);

        assertThrows(
                IllegalArgumentException.class,
                () -> quantity.divideBy(Double.POSITIVE_INFINITY)
        );
    }

    @Test
    void shouldConsiderEquivalentQuantitiesEqualAcrossUnits() {
        MassQuantity kilogram = KILOGRAM.of(1);
        MassQuantity grams = GRAM.of(1000);

        assertEquals(kilogram, grams);
    }

    @Test
    void shouldHaveSameHashCodeForEquivalentQuantitiesAcrossUnits() {
        MassQuantity kilogram = KILOGRAM.of(1);
        MassQuantity grams = GRAM.of(1000);

        assertEquals(kilogram.hashCode(), grams.hashCode());
    }

    @Test
    void shouldNotConsiderDifferentValuesEqual() {
        MassQuantity first = GRAM.of(1000);
        MassQuantity second = GRAM.of(1001);

        assertEquals(false, first.equals(second));
    }

    @Test
    void shouldNotEqualNull() {
        MassQuantity quantity = GRAM.of(1);

        assertEquals(false, quantity.equals(null));
    }

    @Test
    void shouldNotEqualDifferentType() {
        MassQuantity quantity = GRAM.of(1);

        assertEquals(false, quantity.equals("1 g"));
    }
}