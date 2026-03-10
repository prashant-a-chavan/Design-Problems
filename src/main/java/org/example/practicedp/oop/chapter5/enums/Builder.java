package org.example.practicedp.oop.chapter5.enums;

public enum Builder {
        FENDER, MARTIN, GIBSON, OLSON, RYAN, PRS, ANY, COLLINGS;

        public String toString() {
            switch (this) {
                case FENDER: return "Fender";
                case MARTIN: return "Martin";
                case GIBSON: return "Gibson";
                case OLSON: return "Olson";
                case RYAN: return "Ryan";
                case PRS: return "PRS";
                case ANY: return "Any";
                case COLLINGS: return "Collings";
                default: return "Unspecified";
            }
        }
}
