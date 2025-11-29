/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.util.List;

/**
 *
 * @author Ʈ Ꝺ Ɲ ƴ
 */
public class SudokuApp {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage : java -jar <app-name>.jar <csv_filepath> <mode>");
            System.err.println("Modes : 0 (Sequential), 3 (coarse-Grained), 27 (Fine-Grained)");
            return;
        }
        String filePath = args[0];
        int mode;
        try {
           mode = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Error : mode must be an integer (0,3 or 27)");
            return;
        }
        InputParser parser = new InputParser();
        int[][] board;
        try {
            board = parser.loadCsv(filePath);
        } catch (RuntimeException e) {
            System.err.println("Error loading file : " + e.getMessage());
            return;
        }
        Verifier verifier;
        try {
            verifier = VerifierFactory.creatingVerifier(mode);
        } catch (IllegalArgumentException e) {
            System.err.println("Error : " + e.getMessage());
            return;
        }
        List<FailureDetail> failures = verifier.verify(board);
        if (failures==null || failures.isEmpty()) {
            System.out.println("VALID");
        } else {
            System.out.println("INVALID");
            ResultFormatter formatter = new ResultFormatter();
            formatter.formatAllFailures(failures);
        }
    }
}
