package org.example.practicedp.designproblems.quantity.length;

import org.example.practicedp.designproblems.quantity.core.Quantity;

public final class LengthQuantity extends Quantity<LengthUnit, LengthQuantity> {

    private LengthQuantity(double value, LengthUnit unit) {
        super(value, unit);
    }

    public static LengthQuantity of(double value, LengthUnit unit) {
        return new LengthQuantity(value, unit);
    }

    @Override
    protected LengthQuantity create(double value, LengthUnit unit) {
        return new LengthQuantity(value, unit);
    }
}