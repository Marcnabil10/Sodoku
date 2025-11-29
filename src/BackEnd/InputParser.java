/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

/**
 *
 * @author Ʈ Ꝺ Ɲ ƴ
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class InputParser {
    public int[][] loodCsv (String filePath)
    {
        int [][] board = new int [9][9];
        BufferedReader br=null;
        
        try
        {
            br = new BufferedReader( new FileReader(filePath));
            String line;
            int rowIndex =0;
            while((line = br.readLine()) != null && rowIndex<9)
                    {
                        String[] values = line.split(",");
                        for(int colIndex = 0;colIndex< values.length&&colIndex<9; colIndex++){
                            board[rowIndex][colIndex]=Integer.parseInt(values[colIndex].trim());
                        }
                        rowIndex++;
                    }
            
        }catch (IOException e)
        {
            throw new RuntimeException("Error reading the file :" + filePath, e);
        }
        catch (NumberFormatException e)
        {
            throw new RuntimeException("Error parsing number from CSV. ",e);
        }finally
        {
            if(br!=null)
                try {br.close();}
            catch(IOException e){
                System.err.println("Error closing file : "+e.getMessage());
            }
        }
        return board;
    }
}
