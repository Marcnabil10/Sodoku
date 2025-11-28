package BackEnd;

import java.util.ArrayList;
import java.util.List;

public class SequentialVerifier implements Verifier {
    public List<FailureDetail> verify(int[][] board) {
        List<FailureDetail> allFailures = new ArrayList<>();
        for (int Index = 0; Index < 9; Index++) {
            List<FailureDetail> rowFailures = SudokuValidatorUtils.checkRow(Index, board);
            allFailures.addAll(rowFailures);
            List<FailureDetail> colFailures = SudokuValidatorUtils.checkCol(Index, board);
            allFailures.addAll(colFailures);
            List<FailureDetail> boxFailures = SudokuValidatorUtils.checkBox(Index, board);
            allFailures.addAll(boxFailures);
        }
        return allFailures;
    }

}
