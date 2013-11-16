
package bowling;

import java.util.*;

class Frame {

    private List<Integer> rolls=new ArrayList<>();
    private static final Integer MAX_FALLEN_PINS=10;
    private Frame nextFrame;
    
    void roll(int fallenPins) {
        rolls.add(fallenPins);
    }

    boolean isStrike() {
        return rolls.size() == 1 && allPinsFallen();
    }

    boolean isSpare() {
        return rolls.size() == 2 && allPinsFallen();
    }
    
    int score(){
        int score=fallenPinsSum();
        if (isSpare()){
            score+=nextFrame.getFallenPinsOfNextRolls(NextRollNumber.NEXTROLL);
        } else if (isStrike()){
            score+=nextFrame.getFallenPinsOfNextRolls(NextRollNumber.NEXTTWOROLLS);
        }
        return score;
    }
    
    int getFallenPinsOfNextRolls(NextRollNumber nextRollNumber){
        switch (nextRollNumber){
            case NEXTROLL:
                return rolls.get(0);
            case NEXTTWOROLLS:
                return getNextTwoRolls();
        }
        return 0;
    }

    private boolean allPinsFallen() {
        return fallenPinsSum()==MAX_FALLEN_PINS;
    }

    private Integer fallenPinsSum() {
        int sum=0;
        for (Integer pins : rolls) {
            sum+=pins;
        }
        return sum;
    }

    void setNextFrame(Frame nextFrame) {
        this.nextFrame=nextFrame;
    }

    private int getNextTwoRolls() {
        if (isStrike()){
            return fallenPinsSum()+nextFrame.getFallenPinsOfNextRolls(NextRollNumber.NEXTROLL);
        } else {
            return fallenPinsSum();
        }
    }

}
