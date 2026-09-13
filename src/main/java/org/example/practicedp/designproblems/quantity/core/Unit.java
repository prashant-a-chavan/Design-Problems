package org.example.practicedp.designproblems.quantity.core;

public interface Unit {
    double baseUnitFactor();

    default double toBaseUnit(double value) {
        return value * baseUnitFactor();
    }

    default double fromBaseUnit(double baseValue) {
        return baseValue / baseUnitFactor();
    }

    String symbol();
}