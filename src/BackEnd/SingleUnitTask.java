/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.util.List;

/**
 *
 * @author marcn
 */
public class SingleUnitTask implements Runnable{
    private final String category; //3ashan ne3raf row column aw box
    private final int i;
    private final int[][] board;
    private final List<FailureDetail> SharedfailedDetails;

    public SingleUnitTask(String category, int i, int[][] board, List<FailureDetail> SharedfailedDetails) {
        this.category = category;
        this.i = i;
        this.board = board;
        this.SharedfailedDetails = SharedfailedDetails;
    }
    

    @Override
    public void run() {
        if(category.equalsIgnoreCase("Row")){
           List<FailureDetail> failures = SudokuValidatorUtils.checkRow(i,board);
                  if (failures != null && !failures.isEmpty()) {
                   SharedfailedDetails.addAll(failures);
                                      }
               }
       else if(category.equalsIgnoreCase("Col")){
             List<FailureDetail> failures = SudokuValidatorUtils.checkCol(i,board);
             if (failures != null && !failures.isEmpty()) {
                   SharedfailedDetails.addAll(failures);
                                      }
        }
       else if(category.equalsIgnoreCase("Box")){
            List<FailureDetail> failures = SudokuValidatorUtils.checkBox(i,board);
             if (failures != null && !failures.isEmpty()) {
                   SharedfailedDetails.addAll(failures);
                                      }
            
        }
       else  throw new IllegalArgumentException("Invalid category: " + category);
             
            
        
        
    }
    
}
