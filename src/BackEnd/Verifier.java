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
public interface Verifier {
    public List<FailureDetail> verify(int [][] board); //method return all the invalid values in sudokuboard
}
