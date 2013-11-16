
package bowling;

import junit.framework.Assert;
import org.junit.*;
import static org.junit.Assert.*;

public class FrameTest {
    private Frame frame;

    @Test
    public void strike(){
        frame.roll(10);
        assertTrue(frame.isStrike());
    }
    
    @Test
    public void noStrike(){
        frame.roll(5);
        assertFalse(frame.isStrike());
    }
    
    @Test
    public void spare(){
        frame.roll(4);
        frame.roll(6);
        assertTrue(frame.isSpare());
    }

    @Test
    public void noSpare(){
        frame.roll(4);
        frame.roll(5);
        assertFalse(frame.isSpare());
    }
    
    @Test
    public void roll2And3_getScore5(){
        frame.roll(2);
        frame.roll(3);
        assertEquals(5, frame.score());
    }

    @Test
    public void roll2And1_getScore3(){
        frame.roll(2);
        frame.roll(1);
        assertEquals(3, frame.score());
    }

    @Test
    public void rollSparePlus5_getScore15(){
        frame.roll(4);
        frame.roll(6);
        Frame nextFrame=new Frame();
        nextFrame.roll(5);
        frame.setNextFrame(nextFrame);
        assertEquals(15, frame.score());
    }

    @Test
    public void rollStrikePlus5And4_getScore19(){
        frame.roll(10);
        Frame nextFrame=new Frame();
        nextFrame.roll(5);
        nextFrame.roll(4);
        frame.setNextFrame(nextFrame);
        assertEquals(19, frame.score());
    }

    @Test
    public void rollStrikePlus10And4_getScore24(){
        frame.roll(10);
        Frame nextFrame=new Frame();
        nextFrame.roll(10);
        Frame nextNextFrame=new Frame();
        nextNextFrame.roll(4);
        frame.setNextFrame(nextFrame);
        nextFrame.setNextFrame(nextNextFrame);
        assertEquals(24, frame.score());
    }

    @Test
    public void rollStrikePlus10And10_getScore30(){
        frame.roll(10);
        Frame nextFrame=new Frame();
        nextFrame.roll(10);
        Frame nextNextFrame=new Frame();
        nextNextFrame.roll(10);
        frame.setNextFrame(nextFrame);
        nextFrame.setNextFrame(nextNextFrame);
        assertEquals(30, frame.score());
    }


    @Before
    public void initFrame() {
        frame=new Frame();
    }
    
    
}