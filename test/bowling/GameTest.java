package bowling;

import org.junit.Test;
import static org.junit.Assert.*;


public class GameTest {
    public static final int NORMALIZED_PERFECT_GAME_ROLE_COUNT = 12;
    public static final int NORMAL_GAME_ROLE_COUNT = 22;
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
    
    @Test
    public void testPerfectGame() {
        Game bowling = new Game();

        for (int rollCounter = 0; rollCounter < NORMALIZED_PERFECT_GAME_ROLE_COUNT; rollCounter++) {
            bowling.roll(STRIKE);
        }

        assertEquals(300, bowling.score().intValue());
    }
    
    @Test
    public void testSpareFinish() {
        Game bowling = new Game();

        for (int rollCounter = 0; rollCounter < 18; rollCounter++) {
            bowling.roll(rollCounter % 10);
        }
        bowling.roll(5);
        bowling.roll(5);
        bowling.roll(3);
        

        assertEquals(86, bowling.score().intValue());
    }
    
    @Test
    public void testWeakFinish() {
        Game bowling = new Game();

        for (int rollCounter = 0; rollCounter < 18; rollCounter++) {
            bowling.roll(rollCounter % 10);
        }
        bowling.roll(5);
        bowling.roll(3);

        assertEquals(81, bowling.score().intValue());
    }
    
    @Test
    public void testRandomGame() {
        Game bowling = new Game();

        bowling.roll(5);
        bowling.roll(3); // 8
        
        bowling.roll(10); // 28
        
        bowling.roll(6); 
        bowling.roll(4); // 44
        
        bowling.roll(6);
        bowling.roll(2); // 52
        
        bowling.roll(7);
        bowling.roll(0); // 59
        
        bowling.roll(1);
        bowling.roll(4); // 64
        
        bowling.roll(4);
        bowling.roll(1); // 69
        
        bowling.roll(0);
        bowling.roll(0); // 69
        
        bowling.roll(7);
        bowling.roll(3); // 81
        
        bowling.roll(2);
        bowling.roll(2); // 85
        
        assertEquals(85, bowling.score().intValue());
    }
    
    @Test
    public void testWeakGame() {
        Game bowling = new Game();

        for (int rollCounter = 0; rollCounter < NORMAL_GAME_ROLE_COUNT; rollCounter++) {
            bowling.roll(0);
        }
        assertEquals(0, bowling.score().intValue());
    }
    
    @Test(expected = Game.InvalidScoreException.class)
    public void testInvalidScoreException(){
        Game bowling = new Game();
        bowling.roll(-1);
        fail();
    }
}