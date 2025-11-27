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
 * @author abramehab
 */
public class Mode3Verifier implements Verifier{
    

    @Override
    public List<FailureDetail> verify(int[][] board) {
        
        List<FailureDetail> SharedFailureDetails = Collections.synchronizedList(new ArrayList<>());// synchronize the threads to store the failed details correctly
        
        Thread rowthread = new Thread(new ThreadsTask("ROW", board, SharedFailureDetails));
        Thread colthread = new Thread(new ThreadsTask("COL", board, SharedFailureDetails));
        Thread boxthread = new Thread(new ThreadsTask("BOX", board, SharedFailureDetails));
        
        rowthread.start();
        colthread.start();
        boxthread.start();
        
        try {
            rowthread.join();
            colthread.join();
            boxthread.join();
            System.out.println("3 threads are checking");
            
        } catch (InterruptedException interupptingthread) {
            throw new RuntimeException("thread is being interuppted",interupptingthread);
        }
        return SharedFailureDetails; // now the main collect all the failers from the 3 threads 
    }
    
}
