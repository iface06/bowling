package bowling;

import java.util.ArrayList;
import java.util.List;


public class Game {

    private static final int MAX_PINS = 10;
    private List<Integer> rolls = new ArrayList<>();

    public void roll(int pins) {
        if(pins < 0){
            throw new InvalidScoreException(pins);
        }
        this.rolls.add(pins);
        if (isStrike(pins)) {
            this.rolls.add(0);
        }
    }

    public Integer score() {
        Integer sum = 0;
        for (int i = 0; i < rolls.size(); i += 2) {
            if (isLastFrame(i)) {
                sum += calculateLastFrame(i);
            } else {
                sum += calculateNormalFrame(i);
            }
        }
        return sum;
    }
    
        private Integer calculateLastFrame(Integer i) {
            Integer firstThrow = rolls.get(i);
            Integer frameScore = firstThrow + getRoll(i + 1);

            if (isSpare(frameScore) || isStrike(firstThrow)) {
                return frameScore;
            } else {
                return frameScore;
            }

        }

        private Integer calculateNormalFrame(int i) {
            Integer firstThrow = rolls.get(i);
            Integer frameScore = firstThrow + getRoll(i + 1);
            if (isStrike(firstThrow)) {
                Integer nextScore = getRoll(i + 2);
                return frameScore + nextScore + getOverNextScore(i);
            } else if (isSpare(frameScore)) {
                return frameScore + getRoll(i + 2);
            } else {
                return frameScore;
            } 
        }

    private boolean isSpare(Integer frameScore) {
        return frameScore == MAX_PINS;
    }

    private Integer getRoll(int i) {
        Integer nextScore = 0;
        if (rolls.size() > i) {
            nextScore = rolls.get(i);
        }
        return nextScore;
    }

    private boolean isStrike(Integer score) {
        return score == MAX_PINS;
    }

    private Integer getOverNextScore(int i) {
        return isStrike(getRoll(i + 2)) ? getRoll(i + 4) : getRoll(i + 3);
    }

    private boolean isLastFrame(int i) {
        return i >= 18;
    }

    public static class InvalidScoreException extends RuntimeException {

        public InvalidScoreException(int pins) {
            super("Invalid Score: " + pins);
        }
    }

    
}
