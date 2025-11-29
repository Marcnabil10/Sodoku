/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author Ʈ Ꝺ Ɲ ƴ
 */
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
        sb.append(", ");
        List<Integer> positions = failure.getPositions();
        Collections.sort(positions);
        sb.append(positions.toString());
        return sb.toString();

    }
}
