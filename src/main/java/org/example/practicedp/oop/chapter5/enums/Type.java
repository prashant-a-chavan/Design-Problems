package org.example.practicedp.oop.chapter5.enums;

public enum Type {
    ACOUSTIC, ELECTRIC;

    public String toString() {
        switch (this) {
            case ACOUSTIC: return "Acoustic";
            case ELECTRIC: return "Electric";
            default: return "Unspecified";
        }
    }
}
