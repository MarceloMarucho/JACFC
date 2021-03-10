/*
@author Marcelo Marucho
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedures;
 

import java.io.File;

public class MoveFiles {

    public static void move_Files(String input, String output)
    {

    	try{

    	   File afile =new File(input);

                boolean moved = afile.renameTo(new File(output));

    	}catch(Exception e){
    	}
    }
}