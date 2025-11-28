package BackEnd;

import java.util.ArrayList;
import java.util.List;

public class FailureDetail {
    private String type;
    private int index ;
    private int duplicatedValue;
    private List<Integer> positions;

    public FailureDetail(String type, int index, int duplicatedValue){
        this.duplicatedValue=duplicatedValue;
        this.index=index;
        this.type=type;
        this.positions = new ArrayList<>();
    }

    public FailureDetail() {

    }

    public void addPosition (int pos){
        positions.add(pos);
    }

    public String getType() {
        return type;
    }

    public List<Integer> getPositions() {
        return positions;
    }

    public int getDuplicatedValue() {
        return duplicatedValue;
    }

    public int getIndex() {
        return index;
    }
    @Override
    public String toString() {
        List<Integer> positionsPrint = new ArrayList<>();
        for (int pos : positions) {
            positionsPrint.add(pos + 1);
        }return type.toUpperCase() + " at index " + (index + 1)
                + " has duplicated value " + duplicatedValue
                + " at positions " + positionsPrint;
    }



}
