package org.example.practicedp.oop.chapter10.Loader;

import org.example.practicedp.oop.chapter10.subway.Subway;

import java.io.File;
import java.io.IOException;

public class LoadTester {
    public static void main(String[] args) {
        try {
            SubwayLoader loader = new SubwayLoader();
            Subway objectville = loader.loadFromFile(new File("ObjectvilleSubway.txt"));
            System.out.println("Testing stations...");
            if (objectville.hasStation("DRY Driver") && objectville.hasStation("Weather-O-Rama")) {
                System.out.println("Stations loaded successfully!");
            } else {
                System.out.println("Error loading stations.");
            }

            System.out.println("\nTesting connections...");
            if (objectville.hasConnection("DRY Driver", "Weather-O-Rama", "Red Line")) {
                System.out.println("Connections loaded successfully!");
            } else {
                System.out.println("Error loading connections.");
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
