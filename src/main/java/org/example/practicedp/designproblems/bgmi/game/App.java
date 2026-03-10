package org.example.practicedp.designproblems.bgmi.game;

import org.example.practicedp.designproblems.bgmi.lobby.Lobby;
import org.example.practicedp.designproblems.bgmi.lobby.LobbyMode;
import org.example.practicedp.designproblems.bgmi.player.Player;

import java.util.List;

import static org.example.practicedp.designproblems.bgmi.utils.Utils.printWithNewLine;

public class App {
    public static void start() {
        Lobby soloLobby = new Lobby(LobbyMode.SOLO);

        Player player1 = RegisterPlayer.createPlayer(1L, "Player 1");
        Player player2 = RegisterPlayer.createPlayer(2L, "Player 2");
        Player player3 = RegisterPlayer.createPlayer(3L, "Player 3");
        Player player4 = RegisterPlayer.createPlayer(4L, "Player 4");
        Player player5 = RegisterPlayer.createPlayer(5L, "Player 5");

        boolean addAllPlayers = soloLobby.addPlayers(List.of(player1, player2, player3, player4, player5));
        if (!addAllPlayers) {
            System.out.println("Lobby is full!");
        }

        printWithNewLine(LobbyMode.DUO);
        printWithNewLine(1);

        soloLobby.startMatch();
    }
}
