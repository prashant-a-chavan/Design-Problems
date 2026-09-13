package practicedp.designproblems.bgmi;

import practicedp.designproblems.bgmi.lobby.Lobby;
import practicedp.designproblems.bgmi.lobby.LobbyMode;
import practicedp.designproblems.bgmi.player.Player;
import practicedp.designproblems.bgmi.player.PlayerStatistics;

import static practicedp.designproblems.bgmi.utils.Utils.printWithNewLine;

public class Main {
    public static void main(String[] args) {
        PlayerStatistics playerStatistics = new PlayerStatistics(100L, 10L, 500L);
        Player player = new Player(1L, "Prashant", 50, playerStatistics);

        Lobby lobby = new Lobby(LobbyMode.SOLO);

    }
}
