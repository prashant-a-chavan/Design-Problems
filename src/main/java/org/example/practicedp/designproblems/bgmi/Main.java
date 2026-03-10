package org.example.practicedp.designproblems.bgmi;

import org.example.practicedp.designproblems.bgmi.lobby.Lobby;
import org.example.practicedp.designproblems.bgmi.lobby.LobbyMode;
import org.example.practicedp.designproblems.bgmi.player.Player;
import org.example.practicedp.designproblems.bgmi.player.PlayerStatistics;

import static org.example.practicedp.designproblems.bgmi.utils.Utils.printWithNewLine;

public class Main {
    public static void main(String[] args) {
        PlayerStatistics playerStatistics = new PlayerStatistics(100L, 10L, 500L);
        Player player = new Player(1L, "Prashant", 50, playerStatistics);

        Lobby lobby = new Lobby(LobbyMode.SOLO);

    }
}
