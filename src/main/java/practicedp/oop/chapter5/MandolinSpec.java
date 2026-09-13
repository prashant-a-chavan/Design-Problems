package practicedp.oop.chapter5;

import practicedp.oop.chapter5.enums.Builder;
import practicedp.oop.chapter5.enums.Style;
import practicedp.oop.chapter5.enums.Type;
import practicedp.oop.chapter5.enums.Wood;

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

    public Style getStyle() {
        return style;
    }
}
