package com.limethecoder;


public class PenaltyApp {
    public enum Team {
        HOME, AWAY
    }

    public final static int MAIN_ROUNDS_CNT = 5;

    private final static String DEFAULT_HOME_NAME = "Home";
    private final static String DEFAULT_AWAY_NAME = "Away";

    private boolean finished;
    private int homeScore;
    private int awayScore;
    private String homeTeamName;
    private String awayTeamName;

    private int homeTotalKicks = 0;
    private int awayTotalKicks = 0;

    public PenaltyApp() {
        homeTeamName = DEFAULT_HOME_NAME;
        awayTeamName = DEFAULT_AWAY_NAME;
    }

    public PenaltyApp(String homeTeamName, String awayTeamName) {
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
    }

    public boolean[] shoot(String player, Team team, boolean isScored) {
        shoot(team, isScored);
        return getHistory(player);
    }

    public void shoot(Team team, boolean isScored) {
        if(isFinished()) {
            throw new IllegalStateException();
        }

        switch (team) {
            case HOME:
                if(homeTotalKicks > awayTotalKicks) {
                    throw new IllegalStateException();
                }

                if(isScored) {
                    homeScore++;
                }

                homeTotalKicks++;
                break;
            case AWAY:
                if(homeTotalKicks < awayTotalKicks) {
                    throw new IllegalStateException();
                }

                if(isScored) {
                    awayScore++;
                }

                awayTotalKicks++;
                break;
        }

        finished = homeTotalKicks >= MAIN_ROUNDS_CNT &&
                (homeTotalKicks == awayTotalKicks) &&
                (homeScore != awayScore);
    }

    public String getCurrentScore() {
        return getDisplayResultForTeam(homeTeamName, homeScore) +
                " - " +
                getDisplayResultForTeam(awayTeamName, awayScore);
    }

    private String getDisplayResultForTeam(String teamName, int score) {
        String result =  teamName + "(" + score + ")";

        if(homeTotalKicks >= 7 && homeTotalKicks >= 7) {
            result += "[" + getTransferValue(getNonScoredPlayer(teamName)) + "]";
        }

        return result;
    }

    public boolean[] getHistory(String player) {
        return null;
    }

    public int getTransferValue(String ... players) {
        return 0;
    }

    public String[] getNonScoredPlayer(String team) {
        return null;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public boolean isFinished() {
        return finished;
    }
}
