package BackEnd;

import java.util.Collections;
import java.util.List;

public class ResultFormatter {

    public void formatAllFailures(List<FailureDetail> failures) {
        if (failures == null || failures.isEmpty()) {
            return;
        }

        for (FailureDetail failure : failures) {
            System.out.println(formatSingleFailure(failure));
        }
    }

    private String formatSingleFailure(FailureDetail failure) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(failure.getType().toUpperCase()).append(" ");
        sb.append(failure.getIndex() + 1);
        
        sb.append(", #").append(failure.getDuplicatedValue());
        
        sb.append(", [");
        List<Integer> positions = failure.getPositions();
        Collections.sort(positions);
        
        for (int i = 0; i < positions.size(); i++) {
            sb.append(positions.get(i) + 1);  
            if (i < positions.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        
        return sb.toString();
    }
}