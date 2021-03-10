/*
@author Esteban Valderrama and Marcelo Marucho
* package com.mkyong.file;
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedures;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFiles {

    public static void copy_Files(String input, String output)
    {

    	InputStream inStream = null;
	OutputStream outStream = null;

    	try{

    	    File afile =new File(input);
    	    File bfile =new File(output);

    	    inStream = new FileInputStream(afile);
    	    outStream = new FileOutputStream(bfile);

    	    byte[] buffer = new byte[1024];

    	    int length;
    	    //copy the file content in bytes
    	    while ((length = inStream.read(buffer)) > 0){

    	    	outStream.write(buffer, 0, length);

    	    }

    	    inStream.close();
    	    outStream.close();

    	    //System.out.println("File is copied successful!");

    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }
}