package org.example.practicedp.oop.chapter2to4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BarkRecognizer {
    private DogDoor door;

    public BarkRecognizer(DogDoor door) {
        this.door = door;
    }

    public void recognize(Bark bark) {
        System.out.println("    BarkRecognizer: Heard a " + bark.getSound());

        List allowedBarks = door.getAllowedBarks();
        for(Iterator i = allowedBarks.iterator(); i.hasNext();) {
            Bark allowrdBark = (Bark) i.next();
            if (allowrdBark.equals(bark)) {
                door.open();
                return;
            }
        }

//        if(allowedBarks.stream().anyMatch(barkObj -> barkObj.equals(bark))) {
//            door.open();
//            return;
//        }
        System.out.println("This dog is not allowed.");
    }
}
