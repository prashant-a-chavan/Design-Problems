package org.example.practicedp.designproblems.quantity.mass;

import org.example.practicedp.designproblems.quantity.core.Unit;

public enum MassUnit implements Unit {

    GRAM("g", 1.0), KILOGRAM("kg", 1000.0);

    private final String symbol;

    private final double gramsPerUnit;

    MassUnit(String symbol, double gramsPerUnit) {
        this.symbol = symbol;
        this.gramsPerUnit = gramsPerUnit;
    }

    public MassQuantity of(double value) {
        return MassQuantity.of(value, this);
    }

    @Override
    public double baseUnitFactor() {
        return gramsPerUnit;
    }

    @Override
    public String symbol() {
        return symbol;
    }
}