package org.example.practicedp.oop.chapter9.board;

import org.example.practicedp.oop.chapter9.unit.Unit;

import java.util.LinkedList;
import java.util.List;

public class Tile {
    private List units;

    public Tile() {
        units = new LinkedList();
    }

    protected void addUnit(Unit unit) {
        units.add(unit);
    }

    protected void removeUnit(Unit unit) {
        units.remove(unit);
    }

    protected void removeUnits() {
        units.clear();
    }

    protected List getUnites() {
        return units;
    }
}
