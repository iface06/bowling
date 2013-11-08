package bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int MAX_PINS = 10;

    private List<Integer> rolls = new ArrayList<>();

    public void roll(int pins) {
        this.rolls.add(pins);
        if (isStrike(pins)) {
            this.rolls.add(0);
        }
    }

    public Integer score() {
        Integer sum = 0;
        for (int i = 0; i < rolls.size(); i += 2) {
            Integer score = rolls.get(i);
            Integer frameScore = score +  getRoll(i + 1);
            
            if (isStrike(score)) {
                Integer nextScore = getRoll(i + 2);
                sum += frameScore + nextScore + getOverNextScore(i);
            } else if (isSpare(frameScore)) {
                sum += frameScore + getRoll(i + 2);
            } else {
                sum += frameScore;
            }
        }
        return sum;
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
}
