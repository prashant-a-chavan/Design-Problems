package org.example.practicedp.designproblems.bgmi.player;

public final class Player {
    private final Long playerId;
    private final String userName;
    private final int level;
    private final PlayerStatistics statistics;

    public Player(Long playerId, String userName, int level, PlayerStatistics statistics) {
        this.playerId = playerId;
        this.userName = userName;
        this.level = level;
        this.statistics = statistics;
    }

    @Override
    public String toString() {
        return "Player[" +
                "playerId=" + playerId + ", " +
                "userName=" + userName + ", " +
                "level=" + level + ", " +
                "statistics=" + statistics + ']';
    }
}
