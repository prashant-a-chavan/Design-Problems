package org.example.practicedp.designproblems.bgmi.lobby;

import lombok.Getter;

@Getter
public enum LobbyMode {
    SOLO("Solo", 1, 50,100, new SoloValidation()),
    DUO("Duo", 2, 40, 50, new DuoValidation()),
    SQUAD("Squad", 4, 40, 25, new SquadValidation());

    private final String mode;
    private final int teamSize;
    private final int minCapacity;
    private final int maxCapacity;
    private final LobbyModeValidation lobbyModeValidation;

    LobbyMode(String mode, int teamSize, int minCapacity, int maxCapacity, LobbyModeValidation lobbyModeValidation) {
        this.mode = mode;
        this.teamSize = teamSize;
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
        this.lobbyModeValidation = lobbyModeValidation;
    }

    public boolean validation() {
        return lobbyModeValidation.isValid(this);
    }
}
