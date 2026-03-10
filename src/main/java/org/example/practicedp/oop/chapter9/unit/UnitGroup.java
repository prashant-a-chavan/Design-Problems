package org.example.practicedp.oop.chapter9.unit;

import java.util.*;

public class UnitGroup {
    private Map<Integer, Unit> units;

    public UnitGroup(List<Unit> unitList) {
        units = new HashMap<>();
        for (Unit unit : unitList) {
            units.put(unit.getId(), unit);
        }
    }

    public UnitGroup() {
        this(new LinkedList<>()); // Instead of initializing units in both constructors, the no-argument constructor delegates to the parameterized one.
    }

    public void addUnit(Unit unit) {
        units.put(unit.getId(), unit);
    }

    public void removeUnit(int id) {
        units.remove(id);
    }

    public Unit getUnit(int id) {
        return units.get(id);
    }

    public List<Unit> getUnits() {
        return units.values().stream().toList(); // Is it same ?
    }
}
