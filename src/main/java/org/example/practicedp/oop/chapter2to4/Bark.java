package org.example.practicedp.oop.chapter2to4;

public class Bark {
    private String sound;

    public Bark(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }

    public boolean equals(Object bark) {
        if (bark instanceof Bark) {
            Bark otherBark = (Bark) bark;
            if (this.sound.equalsIgnoreCase(otherBark.getSound())) { // compares with current calling object with the parameter passed object.
                return true;
            }
        }
        return false;
    }
}
