package org.example.practicedp.oop.chapter9.unit;

import lombok.Data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Data
public class Unit {
    private String type;
    private int id;
    private String name;
    private List<Weapon> weapons;
    private Map<String, Object> properties;

    public Unit(int id) {
        this.id = id;
    }

    public void addWeapon(Weapon weapon) {
        if (weapons == null) {
            weapons = new LinkedList<>(); // The reason why we aren't setting this in constructor is, We wait until there's a need for a weapons list to instantiate a new List. That saves a little bit of memory.
        }
        weapons.add(weapon);
    }

    public void setProperty(String property, Object value) {
        if (properties == null) {
            properties = new HashMap<>();
        }
        properties.put(property, value);
    }

    public Object getProperty(String property){
        if (properties == null) {
            throw new RuntimeException("No properties for this Unit.");
        }
        Object value = properties.get(property);
        if (value == null) {
            throw new RuntimeException("Request for non-existing property.");
        } else {
            return value;
        }
    }
}
