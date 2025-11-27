/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

/**
 *
 * @author abramehab
 */
public class VerifierFactory {
    
    public static Verifier creatingVerifier(int modeNumber) {
        switch (modeNumber) {
            case 0:
                return new SequentialVerifier();
                
            case 3:
                return new Mode3Verifier();
                
            case 27:
                return new Mode27Verifier();
            default:
               throw new IllegalArgumentException("invalid mode : "+modeNumber);
        }
    
    }
}
