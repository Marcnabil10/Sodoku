package BackEnd;

import java.util.*;

public class SudokuValidatorUtils {
    static List<FailureDetail> checkRow(int rowIndex, int[][] board){
        Map<Integer,List<Integer>> positions= new HashMap<>();
        for(int i=0;i<9;i++){
            int valeur=board[rowIndex][i];
            positions.computeIfAbsent(valeur,k -> new ArrayList<>());
            positions.get(valeur).add(i);
        }
        List<FailureDetail> failureDetails=new ArrayList<>();;
        for (Integer valeur : positions.keySet()) {
            List<Integer> columns = positions.get(valeur);
            int size = columns.size();
            if (size > 1) {
                FailureDetail failureDetail = new FailureDetail("ROW", rowIndex, valeur);
                for (int column : columns)
                    failureDetail.addPosition(column);
                failureDetails.add(failureDetail);
            }
        }
        return failureDetails;

    }
    static List<FailureDetail> checkCol(int colIndex, int[][] board){
        Map<Integer,List<Integer>> positions= new HashMap<>();
        for(int i=0;i<9;i++){
            int valeur=board[i][colIndex];
            positions.computeIfAbsent(valeur,k -> new ArrayList<>());
            positions.get(valeur).add(i);
        }
        List<FailureDetail> failureDetails=new ArrayList<>();;
        for (Integer valeur : positions.keySet()) {
            List<Integer> rows = positions.get(valeur);
            int size = rows.size();
            if (size > 1) {
                FailureDetail failureDetail = new FailureDetail("COL", colIndex, valeur);
                for (int row : rows)
                    failureDetail.addPosition(row);
                failureDetails.add(failureDetail);
            }
        }
        return failureDetails;

    }
    static int findStartColumn(int boxIndex){
        if(boxIndex==0 || boxIndex==3 || boxIndex==6)
            return 0;
        else if(boxIndex==1 || boxIndex==4 || boxIndex==7)
            return 3;
        else return 6;
    }
    static int findStartRow(int boxIndex){
        if(boxIndex<=2)
            return 0 ;
        else if(boxIndex<=5)
            return 3;
        else return 6;
    }

    static List<FailureDetail> checkBox(int boxIndex, int[][] board){
        int startRow=findStartRow(boxIndex);
        int startColumns=findStartColumn(boxIndex);
        Map<Integer,List<Integer>> positions= new HashMap<>();
        int start=0;
        for(int i=startRow;i<startRow+3;i++){
            for(int j=startColumns;j<startColumns+3;j++){
            int valeur=board[i][j];
            positions.computeIfAbsent(valeur,k -> new ArrayList<>());
            positions.get(valeur).add(start);
            start++;}
        }
        List<FailureDetail> failureDetails=new ArrayList<>();;
        for (Integer valeur : positions.keySet()) {
            List<Integer> rows = positions.get(valeur);
            int size = rows.size();
            if (size > 1) {
                FailureDetail failureDetail = new FailureDetail("BOX", boxIndex, valeur);
                for (int index : rows)
                    failureDetail.addPosition(index);
                failureDetails.add(failureDetail);
            }
        }
        return failureDetails;
    }

}
