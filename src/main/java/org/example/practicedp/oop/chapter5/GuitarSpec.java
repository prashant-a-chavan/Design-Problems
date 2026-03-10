package org.example.practicedp.oop.chapter5;

import lombok.Getter;
import org.example.practicedp.oop.chapter5.enums.Builder;
import org.example.practicedp.oop.chapter5.enums.Type;
import org.example.practicedp.oop.chapter5.enums.Wood;

@Getter
public class GuitarSpec extends InstrumentSpec {
    private int numStrings;

    public GuitarSpec(Builder builder, String model, Type type, int numStrings, Wood backWood, Wood topWood) {
        super(builder, model, type, backWood, topWood);

        this.numStrings = numStrings;
    }

    @Override
    public boolean matches(InstrumentSpec otherSpec) {
        if (!super.matches(otherSpec))
            return false; // TODO: Why are we not comparing numStrings ?
        if (!(otherSpec instanceof GuitarSpec))
            return false;
        GuitarSpec spec = (GuitarSpec) otherSpec;
        if (numStrings != spec.numStrings)
            return false;

        return true;
    }
}

