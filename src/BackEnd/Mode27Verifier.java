/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author marcn
 */
public class Mode27Verifier implements Verifier{

    @Override
    public List<FailureDetail> verify(int[][] board) {
         List<FailureDetail> SharedFailureDetails = Collections.synchronizedList(new ArrayList<>());//makes it synchronized
         List<Thread> Threads=new ArrayList<>();//3ashan nehot fihom el threads ba3d ma n3mel start we n3mel .join fe loop tanya 3ashan yeshtaghalo //
         for(int i=0;i<9;i++){
         SingleUnitTask rowTask=new SingleUnitTask("Row", i, board, SharedFailureDetails);//create el task bta3 el row
         Thread rowThread=new Thread(rowTask);//create thread bel task
         rowThread.start();
         Threads.add(rowThread);//nehotaha fel list bta3et el join
         
         SingleUnitTask colTask=new SingleUnitTask("Col", i, board, SharedFailureDetails);
         Thread colThread=new Thread(colTask);
         colThread.start();
         Threads.add(colThread);
         
         SingleUnitTask boxTask=new SingleUnitTask("Box", i, board, SharedFailureDetails);
         Thread boxThread=new Thread(boxTask);
         boxThread.start();
         Threads.add(boxThread);
         }
         
         try
         {
           for(Thread workingThread:Threads){
               workingThread.join();//el main testana el 27 thread to finish
           }
         }
           catch(InterruptedException e){//3ashan law el thread interrupted aw ay moshkela
                   Thread.currentThread().interrupt();
                   throw new RuntimeException("Error",e);
                   }
         return SharedFailureDetails;
             
         }
    
    
}
