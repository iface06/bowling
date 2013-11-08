package bowling;

import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    public static final int PERFECT_GAME_ROLE_COUNT = 12;
    public static final int STRIKE = 10;

    @Test
    public void testFirstMiss() {
        Game bowling = new Game();
        bowling.roll(0);

        int score = bowling.score();
        assertEquals(0, score);
    }

    @Test
    public void testFirstScore() {
        Game bowling = new Game();
        bowling.roll(5);

        int score = bowling.score();
        assertEquals(5, score);
    }

    @Test
    public void testSecondScore() {
        Game bowling = new Game();
        bowling.roll(5);
        bowling.roll(3);

        int score = bowling.score();
        assertEquals(8, score);
    }

    @Test
    public void testFirstScoreAfterSpare() {
        Game bowling = new Game();
        bowling.roll(5);
        bowling.roll(5);
        bowling.roll(3);

        int score = bowling.score();
        assertEquals(16, score);
    }

    @Test
    public void testFirstScoreAfterStrike() {
        Game bowling = new Game();
        bowling.roll(10);
        bowling.roll(5);

        int score = bowling.score();
        assertEquals(20, score);
    }

    @Test
    public void testScoreAfterSpareAndStrike() {
        Game bowling = new Game();
        bowling.roll(5);
        bowling.roll(5);
        bowling.roll(10);

        int score = bowling.score();
        assertEquals(30, score);
    }

    @Test
    public void testScoreAfterTwoSpare() {
        Game bowling = new Game();
        bowling.roll(5);
        bowling.roll(5);
        bowling.roll(5);
        bowling.roll(5);
        bowling.roll(3);

        int score = bowling.score();
        assertEquals(31, score);
    }

    @Test
    public void testScoreAfterSecondRollAfterStrike() {
        Game bowling = new Game();

        bowling.roll(10);
        bowling.roll(4);
        bowling.roll(5);
        assertEquals(28, bowling.score().intValue());

    }

    @Test
    public void testSpareAfterStrike() {
        Game bowling = new Game();

        bowling.roll(10);
        bowling.roll(5);
        bowling.roll(5);
        bowling.roll(7);

        assertEquals(44, bowling.score().intValue());
    }
    
    @Test
    public void testTwoStrikes(){
        Game bowling = new Game();

        bowling.roll(10);
        bowling.roll(10);
        bowling.roll(5);

        assertEquals(25+15+5, bowling.score().intValue());
    }
    
//    @Test
//    public void testPerfectGame() {
//        Game bowling = new Game();
//
//        for (int rollCounter = 0; rollCounter < PERFECT_GAME_ROLE_COUNT; rollCounter++) {
//            bowling.roll(STRIKE);
//        }
//
//        assertEquals(300, bowling.score().intValue());
//    }
}