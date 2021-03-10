/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author mdmlab5
 */
public class polyfunc {

   public static double evaluate (double x) {     
         double [] coeffs = new double [8];
         coeffs[0] = 31530.004393818763;
         coeffs[1] = -24213.440528279076;
         coeffs[2] =  7128.253611606405;
         coeffs[3] = -887.9491721268769;
         coeffs[4] = 7.425430875745777;
         coeffs[5] = 9.606589848548108;
         coeffs[6] = -0.9267357551425184;
         coeffs[7] = 0.02772816733854584;        
         double value1 = 0.0;
            // Use Horner's method to evaluate.
            for (int i = coeffs.length-1; i >= 0; --i) {
                value1 = coeffs[i] + (x*value1);
        }
            double value = 422.0/value1;
        return value;
}
}
