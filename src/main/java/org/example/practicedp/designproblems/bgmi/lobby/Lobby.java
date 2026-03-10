package org.example.practicedp.designproblems.bgmi.lobby;

import org.example.practicedp.designproblems.bgmi.player.Player;

import java.util.*;

import static org.example.practicedp.designproblems.bgmi.utils.Utils.printWithNewLine;

public class Lobby {
    private final Set<Player> players;
    private final LobbyMode mode;
    private MatchStatus matchStatus;

    public Lobby(LobbyMode mode) {
        this.mode = mode;
        this.players = new HashSet<>();
        this.matchStatus = MatchStatus.WAITING;
    }

    public boolean addPlayer(Player player) {
        if (players.size() < mode.getMaxCapacity()) {
            return players.add(player);
        }

        return false;
    }

    public boolean addPlayers(List<Player> players) {
        for(Player player : players) {
            if (!addPlayer(player)){
                return false;
            }
        }
        return true;
    }

    public boolean removePlayer(Player player) {
        return players.remove(player);
    }

    public List<Player> getPlayers() {
        return List.copyOf(players);
    }

    public void startMatch() {
        boolean isValidLobby = validateLobby();
        if (!isValidLobby) {
            printWithNewLine( "Unable to start match since lobby doesn't have enough players.");
            return;
        }

        startCountDown();
    }

    private void startCountDown() {
        this.matchStatus = MatchStatus.STARTING;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                printWithNewLine("Starting match in 10 seconds...");
            }
        }, 10000);
        this.matchStatus = MatchStatus.IN_PROGRESS;
    }

    private boolean validateLobby() {
        return players.size() < mode.getMinCapacity();
    }

}
