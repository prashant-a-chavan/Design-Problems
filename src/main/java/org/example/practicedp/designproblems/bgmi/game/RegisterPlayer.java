package org.example.practicedp.designproblems.bgmi.game;

import org.example.practicedp.designproblems.bgmi.player.Player;
import org.example.practicedp.designproblems.bgmi.player.PlayerStatistics;

public class RegisterPlayer {
    private RegisterPlayer() {
    }

    public static Player createPlayer(Long playerId, String userName) {
        return new Player(playerId, userName, 0, new PlayerStatistics(0L, 0L, 0L));
    }
}
