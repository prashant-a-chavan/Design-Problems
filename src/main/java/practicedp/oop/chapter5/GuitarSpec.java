package practicedp.oop.chapter5;

import practicedp.oop.chapter5.enums.Builder;
import practicedp.oop.chapter5.enums.Type;
import practicedp.oop.chapter5.enums.Wood;

public class GuitarSpec extends InstrumentSpec {
    private int numStrings;

    public GuitarSpec(Builder builder, String model, Type type, int numStrings, Wood backWood, Wood topWood) {
        super(builder, model, type, backWood, topWood);

        this.numStrings = numStrings;
    }

    @Override
    public boolean matches(InstrumentSpec otherSpec) {
        if (!super.matches(otherSpec))
            return false;
        if (!(otherSpec instanceof GuitarSpec))
            return false;
        GuitarSpec spec = (GuitarSpec) otherSpec;
        if (numStrings != spec.numStrings)
            return false;

        return true;
    }
}

