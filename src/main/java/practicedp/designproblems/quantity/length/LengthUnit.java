package practicedp.designproblems.quantity.length;

import practicedp.designproblems.quantity.core.Unit;

public enum LengthUnit implements Unit {

    CENTIMETER("cm", 0.01), METER("m", 1.0), KILOMETER("km", 1000.0);

    private final String symbol;
    private final double metersPerUnit;

    LengthUnit(String symbol, double metersPerUnit) {
        this.symbol = symbol;
        this.metersPerUnit = metersPerUnit;
    }

    public LengthQuantity of(double value) {
        return LengthQuantity.of(value, this);
    }

    @Override
    public double baseUnitFactor() {
        return metersPerUnit;
    }

    @Override
    public String symbol() {
        return symbol;
    }
}