
package bowling;

public enum NextRollNumber {
    
    NEXTROLL(1),
    NEXTTWOROLLS(2);
    private final int rollNumber;
    
    NextRollNumber(int rollNumber){
        this.rollNumber = rollNumber;
    }

    public int getRollNumber() {
        return rollNumber;
    }

}
