package org.example.practicedp.oop.chapter2to4;

public class DogDoorSimulator {

  public static void main(String[] args) {
    DogDoor door = new DogDoor();
    door.addAllowedBark(new Bark("rowlf"));
    door.addAllowedBark(new Bark("rooowlf"));
    door.addAllowedBark(new Bark("rawlf"));
    door.addAllowedBark(new Bark("woof"));
    BarkRecognizer barkRecognizer = new BarkRecognizer(door);
    Remote remote = new Remote(door);

        System.out.println("Dog starts barking...");
        barkRecognizer.recognize(new Bark("Rowlf"));

        System.out.println("Dog has gone outside....");

        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) { }

    System.out.println("\nBruce all done...");
    System.out.println("...but he's stuck outside!");

    // Simulate the hardware hearing a bark (not Bruce!)
    Bark smallDogBark = new Bark("yip");
    System.out.println("A small dog starts barking.");
      barkRecognizer.recognize(smallDogBark);

    try {
      Thread.currentThread().sleep(5000);
    } catch (InterruptedException e) { }

    // Simulate the hardware hearing a bark again
    System.out.println("\nBruce starts barking.");
      barkRecognizer.recognize(new Bark("Rowlf"));

    System.out.println("\nBruce's back inside...");
  }
}
