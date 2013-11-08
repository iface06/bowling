package bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    
    private List<Integer> scores = new ArrayList<>();
    
    public void roll(int pins){
        scores.add(pins);
    }
}
