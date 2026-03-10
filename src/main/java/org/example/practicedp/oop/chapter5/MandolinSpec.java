package org.example.practicedp.oop.chapter5;

import lombok.Data;
import org.example.practicedp.oop.chapter5.enums.Builder;
import org.example.practicedp.oop.chapter5.enums.Style;
import org.example.practicedp.oop.chapter5.enums.Type;
import org.example.practicedp.oop.chapter5.enums.Wood;

@Data
public class MandolinSpec extends InstrumentSpec{
    private Style style;

    public MandolinSpec(Builder builder, String model, Type type, Style style, Wood backWood, Wood topWood) {
        super(builder, model, type, backWood, topWood);

        this.style = style;
    }

    @Override
    public boolean matches(InstrumentSpec otherSpec) {
        if (!super.matches(otherSpec))
            return false;
        if (!(otherSpec instanceof MandolinSpec))
            return false;
        MandolinSpec spec = (MandolinSpec) otherSpec;
        if (!style.equals(spec.style))
            return false;

        return true;
    }
}
