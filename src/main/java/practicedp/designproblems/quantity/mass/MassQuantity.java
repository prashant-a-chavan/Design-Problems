package practicedp.designproblems.quantity.mass;

import practicedp.designproblems.quantity.core.Quantity;

public final class MassQuantity extends Quantity<MassUnit, MassQuantity> {

    private MassQuantity(double value, MassUnit unit) {
        super(value, unit);
    }

    public static MassQuantity of(double value, MassUnit unit) {
        return new MassQuantity(value, unit);
    }

    @Override
    protected MassQuantity create(double value, MassUnit unit) {
        return new MassQuantity(value, unit);
    }
}
