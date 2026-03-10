package org.example.practicedp.oop.chapter5b;

import org.example.practicedp.oop.chapter5b.enums.Builder;
import org.example.practicedp.oop.chapter5b.enums.InstrumentType;
import org.example.practicedp.oop.chapter5b.enums.Type;
import org.example.practicedp.oop.chapter5b.enums.Wood;

import java.util.*;

public class FindInstrument {

    private static final String INSTRUMENT_TYPE = "instrumentType";
    private static final String BUILDER = "builder";
    private static final String MODEL = "model";
    private static final String TYPE = "type";
    private static final String NUM_STRINGS = "numStrings";
    private static final String TOP_WOOD = "topWood";
    private static final String BACK_WOOD = "backWood";

    private static void initializeInventory(Inventory inventory) {
        Map<String, Object> properties = new HashMap<>();

        properties.put(INSTRUMENT_TYPE, InstrumentType.GUITAR);
        properties.put(BUILDER, Builder.COLLINGS);
        properties.put(MODEL, "CJ");
        properties.put(TYPE, Type.ACOUSTIC);
        properties.put(NUM_STRINGS, 6);
        properties.put(TOP_WOOD, Wood.INDIAN_ROSEWOOD);
        properties.put(BACK_WOOD, Wood.SITKA);
        inventory.addInstrument("11277", 3999.95, new InstrumentSpec(properties));

        properties.put(BUILDER, Builder.MARTIN);
        properties.put(MODEL, "D-18");
        properties.put(TOP_WOOD, Wood.MAHOGANY);
        properties.put(BACK_WOOD, Wood.ADIRONDACK);
        inventory.addInstrument("122784", 5495.95, new InstrumentSpec(properties));

        properties.put(BUILDER, Builder.FENDER);
        properties.put(MODEL, "Stratocaster");
        properties.put(TYPE, Type.ELECTRIC);
        properties.put(TOP_WOOD, Wood.ALDER);
        properties.put(BACK_WOOD, Wood.ALDER);
        inventory.addInstrument("V95693", 1499.95, new InstrumentSpec(properties));

        inventory.addInstrument("V9512", 1549.95, new InstrumentSpec(properties));

        properties.put(BUILDER, Builder.GIBSON);
        properties.put(MODEL, "Les Paul");
        properties.put(TOP_WOOD, Wood.MAPLE);
        properties.put(BACK_WOOD, Wood.MAPLE);
        inventory.addInstrument("70108276", 2295.95, new InstrumentSpec(properties));

        properties.put(MODEL, "SG '61 Reissue");
        properties.put(TOP_WOOD, Wood.MAHOGANY);
        properties.put(BACK_WOOD, Wood.MAHOGANY);
        inventory.addInstrument("82765501", 1890.95, new InstrumentSpec(properties));

        properties.put(INSTRUMENT_TYPE, InstrumentType.MANDOLIN);
        properties.put(TYPE, Type.ACOUSTIC);
        properties.put(MODEL, "F-5G");
        properties.put(BACK_WOOD, Wood.MAPLE);
        properties.put(TOP_WOOD, Wood.MAPLE);
        properties.remove(NUM_STRINGS);
        inventory.addInstrument("9019920", 5495.99, new InstrumentSpec(properties));

        properties.put(INSTRUMENT_TYPE, InstrumentType.BANJO);
        properties.put(MODEL, "RB-3 Wreath");
        properties.remove(TOP_WOOD);
        properties.put(NUM_STRINGS, 5);
        inventory.addInstrument("8900231", 2945.95, new InstrumentSpec(properties));
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        initializeInventory(inventory);

        Map<String, Object> properties = new HashMap<>();
        properties.put(BUILDER, Builder.GIBSON);
        properties.put(BACK_WOOD, Wood.MAPLE);
        InstrumentSpec clientSpec = new InstrumentSpec(properties);

        List<Instrument> matchingInstruments = inventory.search(clientSpec);
        if (!matchingInstruments.isEmpty()) {
            System.out.println("You might like these instruments:");

            for (Instrument instrument : matchingInstruments) {
                InstrumentSpec spec = instrument.getSpec();
                System.out.println("We have a " + spec.getProperty(INSTRUMENT_TYPE) + " with the following properties:");

                for (String propertyName : spec.getProperties().keySet()) {
                    if (propertyName.equals(INSTRUMENT_TYPE)) continue;
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t" + propertyName + ": " + spec.getProperty(propertyName));
                }
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t# You can have this " + spec.getProperty(INSTRUMENT_TYPE) + " for $" + instrument.getPrice() + "!\n");
            }
        } else {
            System.out.println("Sorry, we have nothing for you.");
        }
    }
}