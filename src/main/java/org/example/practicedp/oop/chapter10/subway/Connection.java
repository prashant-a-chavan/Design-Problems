package org.example.practicedp.oop.chapter10.subway;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Connection {
    private Station station1;
    private Station station2;
    private String lineName;

    // Getters and Constructor: Handled by annotations.
}
