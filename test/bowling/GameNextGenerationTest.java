
package bowling;

import org.junit.Test;
import static org.junit.Assert.*;

public class GameNextGenerationTest {

    @Test
    public void roll(){
        GameNextGeneration game=new GameNextGeneration();
        game.roll(0);
    }
}