/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.util.List;

/**
 *
 * @author abramehab
 */
public class ThreadsTask implements Runnable {
    
    private final String Categorytype;
    private final int [][] sudukoBoard;
    private final List<FailureDetail> SharedfailedDetails; // list of failed detais from the threads (l2ena el problem)

    public ThreadsTask(String Categorytype, int[][] sudukoBoard, List<FailureDetail> SharedfailedDetails) {
        this.Categorytype = Categorytype;
        this.sudukoBoard = sudukoBoard;
        this.SharedfailedDetails = SharedfailedDetails;
    }
    
    

    @Override
    public void run() {
        if(Categorytype.equalsIgnoreCase("ROW")){
            CheckAllRows();
        }
        else if (Categorytype.equalsIgnoreCase("COL")){
            CheckAllCols();
        }
        else if (Categorytype.equalsIgnoreCase("BOX")){
            CheckAllBoxes();
        }
        else{
            System.out.println("error in determine the category...couldn't run");
        }
        
    }
    
        public  void CheckAllRows(){
            for(int RowIndex = 0;RowIndex < 9;RowIndex++){
                FailureDetail foundfailure = SudokuValidatorUtils.checkRow( RowIndex, sudukoBoard); //tol ma el method btraga3 null ednia zy el fol
                
                if(foundfailure != null){ //found invalid number
                    SharedfailedDetails.add(foundfailure); // store it in the list
                }
            }
        }
        
        public void CheckAllCols(){
            for(int ColIndex = 0;ColIndex < 9;ColIndex++){
                 FailureDetail foundfailure = SudokuValidatorUtils.checkCol(ColIndex, sudukoBoard);
                 
                 if(foundfailure != null){ 
                     SharedfailedDetails.add(foundfailure); 
                 }
            }
        }
        
        public void CheckAllBoxes(){
            for(int BoxIndex = 0;BoxIndex < 9;BoxIndex++){
                FailureDetail foundfailure = SudokuValidatorUtils.checkBox(BoxIndex, sudukoBoard);
                
                if(foundfailure != null){
                    SharedfailedDetails.add(foundfailure);
                 }
            }
        }
        
    
}
