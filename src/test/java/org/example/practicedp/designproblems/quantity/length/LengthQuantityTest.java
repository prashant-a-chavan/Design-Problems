package org.example.practicedp.designproblems.quantity.length;

import org.junit.jupiter.api.Test;

import static org.example.practicedp.designproblems.quantity.length.LengthUnit.CENTIMETER;
import static org.example.practicedp.designproblems.quantity.length.LengthUnit.KILOMETER;
import static org.example.practicedp.designproblems.quantity.length.LengthUnit.METER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LengthQuantityTest {

    private static final double DELTA = 1e-9;

    @Test
    void shouldConvertHundredCentimetersToOneMeter() {
        LengthQuantity result = CENTIMETER.of(100)
                .to(METER);

        assertEquals(1.0, result.value(), DELTA);
        assertEquals(METER, result.unit());
    }

    @Test
    void shouldConvertHundredMetersToPointOneKilometer() {
        LengthQuantity result = METER.of(100)
                .to(KILOMETER);

        assertEquals(0.1, result.value(), DELTA);
        assertEquals(KILOMETER, result.unit());
    }

    @Test
    void shouldConvertOneKilometerToHundredThousandCentimeters() {
        LengthQuantity result = KILOMETER.of(1)
                .to(CENTIMETER);

        assertEquals(100_000.0, result.value(), DELTA);
        assertEquals(CENTIMETER, result.unit());
    }

    @Test
    void shouldConvertDecimalKilometersToCentimeters() {
        LengthQuantity result = KILOMETER.of(1.5)
                .to(CENTIMETER);

        assertEquals(150_000.0, result.value(), DELTA);
        assertEquals(CENTIMETER, result.unit());
    }

    @Test
    void shouldAddMeterToKilometerAndPreserveLeftOperandUnit() {
        LengthQuantity result = KILOMETER.of(1)
                .plus(METER.of(1));

        assertEquals(1.001, result.value(), DELTA);
        assertEquals(KILOMETER, result.unit());
    }

    @Test
    void shouldSubtractMeterFromKilometerAndPreserveLeftOperandUnit() {
        LengthQuantity result = KILOMETER.of(1)
                .minus(METER.of(1));

        assertEquals(0.999, result.value(), DELTA);
        assertEquals(KILOMETER, result.unit());
    }

    @Test
    void shouldAddCentimeterToKilometer() {
        LengthQuantity result = KILOMETER.of(1)
                .plus(CENTIMETER.of(1));

        assertEquals(1.00001, result.value(), DELTA);
        assertEquals(KILOMETER, result.unit());
    }

    @Test
    void shouldAddQuantitiesHavingSameUnit() {
        LengthQuantity result = KILOMETER.of(1)
                .plus(KILOMETER.of(2));

        assertEquals(3.0, result.value(), DELTA);
        assertEquals(KILOMETER, result.unit());
    }

    @Test
    void shouldAddDecimalQuantitiesHavingSameUnit() {
        LengthQuantity result = KILOMETER.of(1.5)
                .plus(KILOMETER.of(2.2));

        assertEquals(3.7, result.value(), DELTA);
        assertEquals(KILOMETER, result.unit());
    }

    @Test
    void shouldPreserveCentimeterWhenCentimeterIsLeftOperand() {
        LengthQuantity result = CENTIMETER.of(1.2)
                .plus(KILOMETER.of(1));

        assertEquals(100_001.2, result.value(), DELTA);
        assertEquals(CENTIMETER, result.unit());
    }

    @Test
    void shouldPreserveMeterWhenMeterIsLeftOperand() {
        LengthQuantity result = METER.of(1)
                .plus(KILOMETER.of(1));

        assertEquals(1001.0, result.value(), DELTA);
        assertEquals(METER, result.unit());
    }

    @Test
    void shouldAllowNegativeResultAfterSubtraction() {
        LengthQuantity result = METER.of(1)
                .minus(METER.of(2));

        assertEquals(-1.0, result.value(), DELTA);
        assertEquals(METER, result.unit());
    }

    @Test
    void shouldHandleZeroValue() {
        LengthQuantity result = KILOMETER.of(0)
                .plus(METER.of(500));

        assertEquals(0.5, result.value(), DELTA);
        assertEquals(KILOMETER, result.unit());
    }

    @Test
    void shouldRejectNaN() {
        assertThrows(
                IllegalArgumentException.class,
                () -> KILOMETER.of(Double.NaN)
        );
    }

    @Test
    void shouldRejectPositiveInfinity() {
        assertThrows(
                IllegalArgumentException.class,
                () -> KILOMETER.of(Double.POSITIVE_INFINITY)
        );
    }

    @Test
    void shouldRejectNegativeInfinity() {
        assertThrows(
                IllegalArgumentException.class,
                () -> KILOMETER.of(Double.NEGATIVE_INFINITY)
        );
    }

    @Test
    void shouldRejectNullTargetUnit() {
        LengthQuantity quantity = KILOMETER.of(1);

        assertThrows(
                NullPointerException.class,
                () -> quantity.to(null)
        );
    }

    @Test
    void shouldRejectNullQuantityDuringAddition() {
        LengthQuantity quantity = KILOMETER.of(1);

        assertThrows(
                NullPointerException.class,
                () -> quantity.plus(null)
        );
    }

    @Test
    void shouldRejectNullQuantityDuringSubtraction() {
        LengthQuantity quantity = KILOMETER.of(1);

        assertThrows(
                NullPointerException.class,
                () -> quantity.minus(null)
        );
    }

    @Test
    void shouldReturnReadableStringRepresentation() {
        LengthQuantity quantity = KILOMETER.of(1.5);

        assertEquals("1.5 km", quantity.toString());
    }

    @Test
    void shouldMultiplyQuantityByScalar() {
        LengthQuantity result = METER.of(2.5)
                .multiplyBy(3);

        assertEquals(7.5, result.value(), DELTA);
        assertEquals(METER, result.unit());
    }

    @Test
    void shouldDivideQuantityByDivisor() {
        LengthQuantity result = KILOMETER.of(2)
                .divideBy(4);

        assertEquals(0.5, result.value(), DELTA);
        assertEquals(KILOMETER, result.unit());
    }

    @Test
    void shouldRejectDivisionByZero() {
        LengthQuantity quantity = METER.of(10);

        assertThrows(
                IllegalArgumentException.class,
                () -> quantity.divideBy(0.0)
        );
    }

    @Test
    void shouldRejectNaNScalarInMultiplyBy() {
        LengthQuantity quantity = METER.of(10);

        assertThrows(
                IllegalArgumentException.class,
                () -> quantity.multiplyBy(Double.NaN)
        );
    }

    @Test
    void shouldRejectInfinityDivisorInDivideBy() {
        LengthQuantity quantity = METER.of(10);

        assertThrows(
                IllegalArgumentException.class,
                () -> quantity.divideBy(Double.POSITIVE_INFINITY)
        );
    }

    @Test
    void shouldConsiderEquivalentQuantitiesEqualAcrossUnits() {
        LengthQuantity kilometer = KILOMETER.of(1);
        LengthQuantity meters = METER.of(1000);

        assertEquals(kilometer, meters);
    }

    @Test
    void shouldHaveSameHashCodeForEquivalentQuantitiesAcrossUnits() {
        LengthQuantity kilometer = KILOMETER.of(1);
        LengthQuantity meters = METER.of(1000);

        assertEquals(kilometer.hashCode(), meters.hashCode());
    }

    @Test
    void shouldNotConsiderDifferentValuesEqual() {
        LengthQuantity first = METER.of(1000);
        LengthQuantity second = METER.of(1001);

        assertEquals(false, first.equals(second));
    }

    @Test
    void shouldNotEqualNull() {
        LengthQuantity quantity = METER.of(1);

        assertEquals(false, quantity.equals(null));
    }

    @Test
    void shouldNotEqualDifferentType() {
        LengthQuantity quantity = METER.of(1);

        assertEquals(false, quantity.equals("1 m"));
    }
}