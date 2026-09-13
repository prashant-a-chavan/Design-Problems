package practicedp.designproblems.quantity;

import practicedp.designproblems.quantity.color.RgbColor;
import practicedp.designproblems.quantity.length.LengthQuantity;
import practicedp.designproblems.quantity.length.LengthUnit;

import static practicedp.designproblems.quantity.length.LengthUnit.*;
import static practicedp.designproblems.quantity.mass.MassUnit.GRAM;
import static practicedp.designproblems.quantity.mass.MassUnit.KILOGRAM;

public class Main {

    public static void main(String[] args) {

        var distance = KILOMETER.of(1.5).to(CENTIMETER).equals(CENTIMETER.of(150000));
        System.out.println(distance); // 1,50,000 cm


        var totalDistance = KILOMETER.of(1).plus(METER.of(1));
        System.out.println(totalDistance); // 1.001 km

        var totalDistance1 = KILOMETER.of(1).minus(METER.of(1));
        System.out.println(totalDistance1); // 0.999 km


        var totalWeight = KILOGRAM.of(1).plus(GRAM.of(500));
        System.out.println(totalWeight); // 1.5 kg


        var color = RgbColor.of("#00FF00").plus(RgbColor.of("#FF0000"));
        System.out.println(color); // #7F7F00
        System.out.println(RgbColor.of("#00FF00").plus(RgbColor.of("#FF0000")).equals(RgbColor.of("#7F7F00")));

        LengthQuantity plus = CENTIMETER.of(1.2).plus(KILOMETER.of(1));
        System.out.println(plus);

        System.out.println(CENTIMETER.of(1).equals(CENTIMETER.of(1)));

        System.out.println(GRAM.of(2500).multiplyBy(2).equals(KILOGRAM.of(5)));
        System.out.println(GRAM.of(5000).divideBy(2).equals(KILOGRAM.of(2.5)));

        System.out.println(LengthUnit.METER.of(1).equals(METER.of(1)));
        System.out.println(METER.of(1).equals(KILOGRAM.of(1)));
    }
}
