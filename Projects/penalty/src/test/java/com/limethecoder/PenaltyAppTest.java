package com.limethecoder;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class PenaltyAppTest {
    private PenaltyApp penaltyApp;

    @Spy
    private PenaltyApp spy = new PenaltyApp();

    @Before
    public void setUp() {
        penaltyApp = new PenaltyApp();
    }

    @Test
    public void testScoreAfterCreation() {
        assertEquals(penaltyApp.getCurrentScore(), "Home(0) - Away(0)");
    }

    @Test
    public void testGameStatusAfterCreation() {
        assertFalse(penaltyApp.isFinished());
    }

    @Test
    public void testScoreWithCustomNames() {
        penaltyApp.setHomeTeamName("Arsenal");
        penaltyApp.setAwayTeamName("Chelsey");

        assertEquals(penaltyApp.getCurrentScore(), "Arsenal(0) - Chelsey(0)");
    }

    @Test
    public void testScoreWhenScored() {
        performNextRound(penaltyApp, true, false);
        performNextRound(penaltyApp, true, true);

        assertEquals(penaltyApp.getCurrentScore(), "Home(2) - Away(1)");
    }

    @Test(expected = IllegalStateException.class)
    public void testExceptionWhenIncorrectKicksOrder() {
        penaltyApp.shoot("Messi", PenaltyApp.Team.HOME, true);
        penaltyApp.shoot("Ronaldo", PenaltyApp.Team.HOME, false);
    }

    @Test
    public void testStatusAfterTeamWin() {
        simulateGameFinishedCase();

        assertTrue(penaltyApp.isFinished());
    }

    @Test(expected = IllegalStateException.class)
    public void testExceptionWhenShootAfterFinish() {
        simulateGameFinishedCase();
        penaltyApp.shoot("Azar", PenaltyApp.Team.HOME, true);

    }

    @Test
    public void testGameStatusAfterMainRounds() {
        simulateEqualScoreAfterMainRounds();
        assertFalse(penaltyApp.isFinished());
    }

    @Test
    public void testPlayerScoreHistory() {
        boolean[] returnedResult = new boolean[] {true, true, false, false};
        when(spy.getHistory("Messi"))
                .thenReturn(returnedResult);

        assertArrayEquals(returnedResult, spy.shoot("Messi", PenaltyApp.Team.HOME, true));
    }

    @Test
    public void testNonScoredPlayersTransferValue() {
        String [] firstTeamLoosers = new String[] {"Messi", "Neymar"};
        String[] secondTeamLoosers = new String[] {"Ibra", "Rashford"};

        when(spy.getNonScoredPlayer("Home")).thenReturn(firstTeamLoosers);
        when(spy.getNonScoredPlayer("Away")).thenReturn(secondTeamLoosers);
        when(spy.getTransferValue(firstTeamLoosers)).thenReturn(15000000);
        when(spy.getTransferValue(secondTeamLoosers)).thenReturn(700000);

        simulateRoundsForSpy(6);
        assertEquals("Home(6) - Away(6)", spy.getCurrentScore());

        performNextRound(spy, true, true);
        assertEquals("Home(7)[15000000] - Away(7)[700000]", spy.getCurrentScore());
    }

    private void performNextRound(PenaltyApp app, boolean isHomeTeamScored, boolean isSecondTeamScored) {
        app.shoot("Ramos", PenaltyApp.Team.HOME, isHomeTeamScored);
        app.shoot("Falcao", PenaltyApp.Team.AWAY, isSecondTeamScored);
    }

    private void simulateGameFinishedCase() {
        performNextRound(penaltyApp, true, false);
        performNextRound(penaltyApp, true, true);
        performNextRound(penaltyApp, true, true);
        performNextRound(penaltyApp, true, true);
        performNextRound(penaltyApp, true, true);
    }

    private void simulateEqualScoreAfterMainRounds() {
        for(int i = 0; i < PenaltyApp.MAIN_ROUNDS_CNT; i++) {
            performNextRound(penaltyApp, true, true);
        }
    }

    private void simulateRoundsForSpy(int n) {
        for(int i = 0; i < n; i++) {
            performNextRound(spy, true, true);
        }
    }
}
