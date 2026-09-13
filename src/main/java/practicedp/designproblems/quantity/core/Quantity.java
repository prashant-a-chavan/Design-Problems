package practicedp.designproblems.quantity.core;

import java.util.Objects;

public abstract class Quantity<U extends Unit, Q extends Quantity<U, Q>> {

    private static final String NULL_QUANTITY_MESSAGE = "Quantity cannot be null";
    public static final String UNIT_CANNOT_BE_NULL = "Unit cannot be null";
    public static final String QUANTITY_VALUE_MUST_BE_FINITE = "Quantity value must be finite: ";

    private final double value;
    private final U unit;

    protected Quantity(double value, U unit) {
        validateValue(value);
        this.value = value;
        this.unit = Objects.requireNonNull(unit, UNIT_CANNOT_BE_NULL);
    }

    private static void validateValue(double value) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException(QUANTITY_VALUE_MUST_BE_FINITE + value);
        }
    }

    public final double value() {
        return value;
    }

    public final U unit() {
        return unit;
    }

    protected abstract Q create(double value, U unit);

    public final Q plus(Q other) {
        double otherInThisUnit = valueInCurrentUnit(other);
        return create(this.value + otherInThisUnit, this.unit);
    }

    public final Q minus(Q other) {
        double otherInThisUnit = valueInCurrentUnit(other);
        return create(this.value - otherInThisUnit, this.unit);
    }

    public final Q multiplyBy(double scalar) {
        validateValue(scalar);
        return create(this.value * scalar, this.unit);
    }

    public final Q divideBy(double divisor) {
        validateValue(divisor);
        if (divisor == 0.0) {
            throw new IllegalArgumentException("Divisor cannot be zero");
        }
        return create(this.value / divisor, this.unit);
    }

    public final Q to(U targetUnit) {
        Objects.requireNonNull(targetUnit, "Target unit cannot be null");
        double convertedValue = convertValue(this.value, this.unit, targetUnit);
        return create(convertedValue, targetUnit);
    }

    private double valueInCurrentUnit(Q other) {
        Objects.requireNonNull(other, NULL_QUANTITY_MESSAGE);
        return convertValue(other.value(), other.unit(), this.unit);
    }

    private double convertValue(double value, U sourceUnit, U targetUnit) {
        double baseValue = sourceUnit.toBaseUnit(value);
        return targetUnit.fromBaseUnit(baseValue);
    }

    @Override
    public final String toString() {
        return value + " " + unit.symbol();
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quantity<?, ?> other = (Quantity<?, ?>) o;

        double thisBaseValue = unit.toBaseUnit(value);
        double otherBaseValue = other.unit().toBaseUnit(other.value());

        return Double.compare(thisBaseValue, otherBaseValue) == 0;
    }

    @Override
    public final int hashCode() {
        double baseValue = unit.toBaseUnit(value);
        return Double.hashCode(baseValue);
    }
}