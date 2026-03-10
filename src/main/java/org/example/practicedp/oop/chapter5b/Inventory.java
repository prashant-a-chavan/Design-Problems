package org.example.practicedp.oop.chapter5b;

import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private final List<Instrument> instruments;

    public Inventory() {
        instruments = new LinkedList<>();
    }

    public void addInstrument(String serialNumber, double price, InstrumentSpec spec) {
        Instrument instrument = new Instrument(serialNumber, price, spec);
        instruments.add(instrument);
    }

    public Instrument get(String serialNumber) {
        for (Instrument instrument : instruments) {
            if (instrument.getSerialNumber().equals(serialNumber))
                return instrument;
        }
        return null;
    }

    public List<Instrument> search(InstrumentSpec searchSpec) {
        List<Instrument> matchingInstruments = new LinkedList<>();
        for (Instrument instrument : instruments) {
            if (instrument.getSpec().matches(searchSpec))
                matchingInstruments.add(instrument);
        }
        return matchingInstruments;
    }
}
