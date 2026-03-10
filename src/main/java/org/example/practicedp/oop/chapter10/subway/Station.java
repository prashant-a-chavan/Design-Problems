package org.example.practicedp.oop.chapter10.subway;

import lombok.Getter;

@Getter
public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Station) {
            Station otherStation = (Station) obj;
            if (otherStation.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }
}
