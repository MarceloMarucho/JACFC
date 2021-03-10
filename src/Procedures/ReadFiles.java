/******************************************************************************
 *
 * Original Author: Esteban Valderrama
 * Description: This class contains the methods to read files.
 *
 *****************************************************************************/

package Procedures;

import Classes.IonLibrary;
import Classes.Ions;
import Classes.Results;
import Classes.Solute;
//import Classes.Utilities;
//import Forms.BiomoleculesUI;
//import Forms.NanomaterialsUI;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
//import java.math.BigDecimal;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ReadFiles {

    static File file;
    static FileInputStream fstream;
    static LineNumberReader lnr;
    static int numLines = 0;
  
/******************************************************************************
 *
 * Procedure Name: read_libraries
 * Original Author: Esteban Valderrama
 * Description: This method reads the Shannon library data.
 * 
 * Calling Arguments:
 *     Name         -> type
 *     Input/Output -> I
 *     Type         -> String
 *     Description  -> Contains the name of the library file.
 * 
 * Return Value:
 *     Name         -> N/A          
 *     Type         -> N/A
 *     Description  -> N/A
 *
 * Local Variables:
 *     Name         -> dstream      
 *     Type         -> DataInputStrem
 *     Description  -> Creates the data input instance to read the file.
 * 
 *     Name         -> br     
 *     Type         -> BufferedReader
 *     Description  -> Creates the buffered instance to read the file.
 * 
 *     Name         -> strLine   
 *     Type         -> String
 *     Description  -> Reads the entire line of the file.
 *
 *     Name         -> i, k   
 *     Type         -> Integer
 *     Description  -> Loop control.
 * 
 *     Name         -> tokens 
 *     Type         -> String[]
 *     Description  -> Array that contains the read data row-by-row.
 * 
 * Global Variables:
 *     Name         -> name      
 *     Type         -> String[]
 *     Origin       -> IonLibrary
     Description  -> Contains the names of the ion data.
 * 
 *     Name         -> symbol      
 *     Type         -> String[]
 *     Origin       -> IonLibrary
     Description  -> Contains the symbols of the ion data.
 * 
 *     Name         -> valN3     
 *     Type         -> String[]
 *     Origin       -> IonLibrary
     Description  -> Contains the diameter values for ions with valence -3.
 * 
 *     Name         -> valN2     
 *     Type         -> String[]
 *     Origin       -> IonLibrary
     Description  -> Contains the diameter values for ions with valence -2.
 * 
 *     Name         -> valN1     
 *     Type         -> String[]
 *     Origin       -> IonLibrary
     Description  -> Contains the diameter values for ions with valence -1.
 * 
 *     Name         -> valP1
 *     Type         -> String[]
 *     Origin       -> IonLibrary
     Description  -> Contains the diameter values for ions with valence 1+.
 * 
 *     Name         -> valP2     
 *     Type         -> String[]
 *     Origin       -> IonLibrary
     Description  -> Contains the diameter values for ions with valence 2+. 
 * 
 *     Name         -> valP3     
 *     Type         -> String[]
 *     Origin       -> IonLibrary
     Description  -> Contains the diameter values for ions with valence 3+.
 * 
 *     Name         -> valP4     
 *     Type         -> String[]
 *     Origin       -> IonLibrary
     Description  -> Contains the diameter values for ions with valence 4+.
 *
 *     Name         -> valP5     
 *     Type         -> String[]
 *     Origin       -> IonLibrary
     Description  -> Contains the diameter values for ions with valence 5+.
 * 
 *     Name         -> valP6     
 *     Type         -> String[]
 *     Origin       -> IonLibrary
     Description  -> Contains the diameter values for ions with valence 6+.
 * 
 *     Name         -> valP7     
 *     Type         -> String[]
 *     Origin       -> IonLibrary
     Description  -> Contains the diameter values for ions with valence 7+.
 * 
 *     Name         -> valP8     
 *     Type         -> String[]
 *     Origin       -> IonLibrary
     Description  -> Contains the diameter values for ions with valence 8+.
 *
 *     Name         -> numLines    
 *     Type         -> Integer
 *     Origin       -> IonLibrary
     Description  -> Contains the number of lines in the ion library.
 * 
 * Modification History:
 *     Date         ->     
 *     Developer    ->
 *     Description  ->
 * 
     * @param type
 *****************************************************************************/
    public static void read_libraries(String type) {

        try{
            fstream = new FileInputStream(type);		
            lnr = new LineNumberReader(new FileReader(new File(type)));
            lnr.skip(Long.MAX_VALUE);
            numLines = lnr.getLineNumber();
            IonLibrary.name = new String[numLines];
            IonLibrary.symbol = new String[numLines];
            IonLibrary.valN3 = new String[numLines];
            IonLibrary.valN2 = new String[numLines];
            IonLibrary.valN1 = new String[numLines];
            IonLibrary.valP1 = new String[numLines];
            IonLibrary.valP2 = new String[numLines];
            IonLibrary.valP3 = new String[numLines];
            IonLibrary.valP4 = new String[numLines];
            IonLibrary.valP5 = new String[numLines];
            IonLibrary.valP6 = new String[numLines];
            IonLibrary.valP7 = new String[numLines];
            IonLibrary.valP8 = new String[numLines];
            IonLibrary.tableData = new String[numLines][13];
            IonLibrary.setNumLines(numLines);
            
            try (DataInputStream dstream = new DataInputStream(fstream)) {
                BufferedReader br;
                br = new BufferedReader(new InputStreamReader(dstream));
                String strLine = null;
                //Read File Line By Line
                int i = 0;
                String[] tokens;
                while ((strLine = br.readLine()) != null){
                    // Print the content on the console
                    tokens = strLine.split("\\s+");
                    IonLibrary.name[i] = tokens[0];
                    IonLibrary.symbol[i] = tokens[1];
                    IonLibrary.valN3[i] = tokens[2];
                    IonLibrary.valN2[i] = tokens[3];
                    IonLibrary.valN1[i] = tokens[4];
                    IonLibrary.valP1[i] = tokens[5];
                    IonLibrary.valP2[i] = tokens[6];
                    IonLibrary.valP3[i] = tokens[7];
                    IonLibrary.valP4[i] = tokens[8];
                    IonLibrary.valP5[i] = tokens[9];
                    IonLibrary.valP6[i] = tokens[10];
                    IonLibrary.valP7[i] = tokens[11];
                    IonLibrary.valP8[i] = tokens[12];
                    IonLibrary.tableData[i][0] = tokens[0];
                    IonLibrary.tableData[i][1] = tokens[1];
                    IonLibrary.tableData[i][2] = tokens[2];
                    IonLibrary.tableData[i][3] = tokens[3];
                    IonLibrary.tableData[i][4] = tokens[4];
                    IonLibrary.tableData[i][5] = tokens[5];
                    IonLibrary.tableData[i][6] = tokens[6];
                    IonLibrary.tableData[i][7] = tokens[7];
                    IonLibrary.tableData[i][8] = tokens[8];
                    IonLibrary.tableData[i][9] = tokens[9];
                    IonLibrary.tableData[i][10] = tokens[10];
                    IonLibrary.tableData[i][11] = tokens[11];
                    IonLibrary.tableData[i][12] = tokens[12];
                    i++;
                }
            }
        }catch (IOException e){
            Toolkit.getDefaultToolkit().beep(); 
            JOptionPane.showMessageDialog(null, ShowMessages.getNotFile(),
                   "ERROR", JOptionPane.ERROR_MESSAGE);
	}
        Ions.valence = new String[10];
        Ions.concentration = new String[10];
        Ions.symbol = new String[10];
        Ions.strDiameter = new String[10];
    }    

    public static void read_libraries_sign(String type) {

        try{
            fstream = new FileInputStream(type);		
            lnr = new LineNumberReader(new FileReader(new File(type)));
            lnr.skip(Long.MAX_VALUE);
            numLines = lnr.getLineNumber();
            IonLibrary.name = new String[numLines];
            IonLibrary.symbol = new String[numLines];
            IonLibrary.valN3 = new String[numLines];
            IonLibrary.valN2 = new String[numLines];
            IonLibrary.valN1 = new String[numLines];
            IonLibrary.valP1 = new String[numLines];
            IonLibrary.valP2 = new String[numLines];
            IonLibrary.valP3 = new String[numLines];
            IonLibrary.valP4 = new String[numLines];
            IonLibrary.valP5 = new String[numLines];
            IonLibrary.valP6 = new String[numLines];
            IonLibrary.valP7 = new String[numLines];
            IonLibrary.valP8 = new String[numLines];
            IonLibrary.valP9 = new String[numLines];
            IonLibrary.tableData = new String[numLines][14];
            IonLibrary.setNumLines(numLines);
            
            try (DataInputStream dstream = new DataInputStream(fstream)) {
                BufferedReader br;
                br = new BufferedReader(new InputStreamReader(dstream));
                String strLine = null;
                //Read File Line By Line
                int i = 0;
                String[] tokens;
                while ((strLine = br.readLine()) != null){
                    // Print the content on the console
                    tokens = strLine.split("\\s+");
                    IonLibrary.name[i] = tokens[0];
                    IonLibrary.symbol[i] = tokens[1];
                    IonLibrary.valN3[i] = tokens[2];
                    IonLibrary.valN2[i] = tokens[3];
                    IonLibrary.valN1[i] = tokens[4];
                    IonLibrary.valP1[i] = tokens[5];
                    IonLibrary.valP2[i] = tokens[6];
                    IonLibrary.valP3[i] = tokens[7];
                    IonLibrary.valP4[i] = tokens[8];
                    IonLibrary.valP5[i] = tokens[9];
                    IonLibrary.valP6[i] = tokens[10];
                    IonLibrary.valP7[i] = tokens[11];
                    IonLibrary.valP8[i] = tokens[12];
                    IonLibrary.valP9[i] = tokens[13];
                    IonLibrary.tableData[i][0] = tokens[0];
                    IonLibrary.tableData[i][1] = tokens[1];
                    IonLibrary.tableData[i][2] = tokens[2];
                    IonLibrary.tableData[i][3] = tokens[3];
                    IonLibrary.tableData[i][4] = tokens[4];
                    IonLibrary.tableData[i][5] = tokens[5];
                    IonLibrary.tableData[i][6] = tokens[6];
                    IonLibrary.tableData[i][7] = tokens[7];
                    IonLibrary.tableData[i][8] = tokens[8];
                    IonLibrary.tableData[i][9] = tokens[9];
                    IonLibrary.tableData[i][10] = tokens[10];
                    IonLibrary.tableData[i][11] = tokens[11];
                    IonLibrary.tableData[i][12] = tokens[12];
                    IonLibrary.tableData[i][13] = tokens[13];
                    i++;
                }
            }
        }catch (IOException e){
            Toolkit.getDefaultToolkit().beep(); 
            JOptionPane.showMessageDialog(null, ShowMessages.getNotFile(),
                   "ERROR", JOptionPane.ERROR_MESSAGE);
	}
        Ions.valence = new String[10];
        Ions.concentration = new String[10];
        Ions.symbol = new String[10];
        Ions.strDiameter = new String[10];
        Ions.strMobility = new String[10];
    }    

/******************************************************************************
 *
 * Procedure Name: read_results
 * Original Author: Esteban Valderrama
 * Description: This method reads the output files.
 * 
 * Calling Arguments:
 *     Name         -> type
 *     Input/Output -> I
 *     Type         -> String
 *     Description  -> Contains the name of the output file.
 * 
 * Return Value:
 *     Name         -> N/A          
 *     Type         -> N/A
 *     Description  -> N/A
 *
 * Local Variables:
 *     Name         -> dstream      
 *     Type         -> DataInputStrem
 *     Description  -> Creates the data input instance to read the file.
 * 
 *     Name         -> br     
 *     Type         -> BufferedReader
 *     Description  -> Creates the buffered instance to read the file.
 * 
 *     Name         -> strLine   
 *     Type         -> String
 *     Description  -> Reads the entire line of the file.
 *
 *     Name         -> i, k   
 *     Type         -> Integer
 *     Description  -> Loop control.
 * 
 *     Name         -> tokens 
 *     Type         -> String[]
 *     Description  -> Array that contains the read data row-by-row.
 * 
 * Global Variables:
 *     Name         -> reader 
 *     Type         -> String[][]
 *     Origin       -> Results
 *     Description  -> Contains the output data.
 * 
 *     Name         -> numCols
 *     Type         -> Integer
 *     Origin       -> Results
 *     Description  -> Contains the number of columns in the output file.
 *
 *     Name         -> numLines    
 *     Type         -> Integer
 *     Origin       -> Results
 *     Description  -> Contains the number of lines in the output file.
 * 
 * Modification History:
 *     Date         ->     
 *     Developer    ->
 *     Description  ->
 * 
     * @param type
 *****************************************************************************/
    public static void read_results(String type){

        try{
            fstream = new FileInputStream(type);		
            lnr = new LineNumberReader(new FileReader(new File(type)));
            lnr.skip(Long.MAX_VALUE);
            Results.setNumLines(lnr.getLineNumber());
            get_number_of_columns(type);
            Results.reader = new String[Results.getNumLines()][Results.getNumCols()];
            try (DataInputStream dstream = new DataInputStream(fstream)){
                BufferedReader br;
                br = new BufferedReader(new InputStreamReader(dstream));
                String strLine = null;
                //Read File Line By Line
                int i = 0;
                int k = 1;
                while ((strLine = br.readLine()) != null){
                    String [] tokens = strLine.split("\\s+");
                    for (int j = 0; j < Results.getNumCols(); j++){
                        Results.reader[i][j] = tokens[k];
                        k++;
                    }
                    i++;
                    k = 1;
                }
            }
        }catch (IOException | NumberFormatException e){
            Toolkit.getDefaultToolkit().beep(); 
            JOptionPane.showMessageDialog(null, ShowMessages.getNotFile(),
                   "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

/******************************************************************************
 *
 * Procedure Name: read_ph
 * Original Author: Esteban Valderrama
 * Description: This method reads the pH output files.
 * 
 * Calling Arguments:
 *     Name         -> type
 *     Input/Output -> I
 *     Type         -> String
 *     Description  -> Contains the name of the pH file.
 * 
 * Return Value:
 *     Name         -> N/A          
 *     Type         -> N/A
 *     Description  -> N/A
 *
 * Local Variables:
 *     Name         -> dstream      
 *     Type         -> DataInputStrem
 *     Description  -> Creates the data input instance to read the file.
 * 
 *     Name         -> br     
 *     Type         -> BufferedReader
 *     Description  -> Creates the buffered instance to read the file.
 * 
 *     Name         -> strLine   
 *     Type         -> String
 *     Description  -> Reads the entire line of the file.
 *
 *     Name         -> i, k   
 *     Type         -> Integer
 *     Description  -> Loop control.
 * 
 *     Name         -> tokens 
 *     Type         -> String[]
 *     Description  -> Array that contains the read data row-by-row.
 * 
 * Global Variables:
 *     Name         -> strPH
 *     Type         -> String[][]
 *     Origin       -> Results
 *     Description  -> Contains the pH output data in string.
 * 
 *     Name         -> ph
 *     Type         -> double[][]
 *     Origin       -> Results
 *     Description  -> Contains the pH output data in double.
 * 
 *     Name         -> numCols
 *     Type         -> Integer
 *     Origin       -> Results
 *     Description  -> Contains the number of columns in the output file.
 *
 *     Name         -> numLines    
 *     Type         -> Integer
 *     Origin       -> Results
 *     Description  -> Contains the number of lines in the output file.
 * 
 * Modification History:
 *     Date         ->     
 *     Developer    ->
 *     Description  ->
 * 
     * @param type
 *****************************************************************************/
    public static void read_ph(String type){
        try{
            fstream = new FileInputStream(type);
            lnr = new LineNumberReader(new FileReader(new File(type)));
            lnr.skip(Long.MAX_VALUE);
            Results.setNumLines(lnr.getLineNumber());
            get_number_of_columns(type);
            Results.strPH = new String[Results.getNumLines()][Results.getNumCols()];
            Results.ph  = new double[Results.getNumLines()][Results.getNumCols()];
            try (DataInputStream dstream = new DataInputStream(fstream)) {
                BufferedReader br;
                br = new BufferedReader(new InputStreamReader(dstream));
                String strLine = null;
                //Read File Line By Line
                int i = 0;
                int k = 1;
                while ((strLine = br.readLine()) != null){
                    // Print the content on the console
                    String [] tokens = strLine.split("\\s+");
                    for (int j = 0; j < Results.getNumCols(); j++){
                        Results.strPH[i][j] = tokens[k];
                        Results.ph[i][j]= Double.valueOf(Results.strPH[i][j]);
                        k++;
                    }
                    i++;
                    if(i < 9){
                        k = 1;
                    } else if(i >= 9){
                        k = 0;
                    }
                }
            }
        }
        catch (IOException | NumberFormatException e){
            Toolkit.getDefaultToolkit().beep(); 
            JOptionPane.showMessageDialog(null, ShowMessages.getNotFile(),
                   "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

/******************************************************************************
 *
 * Procedure Name: read_pqr
 * Original Author: Esteban Valderrama
 * Description: This method reads the pqr output files.
 * 
 * Calling Arguments:
 *     Name         -> type
 *     Input/Output -> I
 *     Type         -> String
 *     Description  -> Contains the name of the pH file.
 * 
 * Return Value:
 *     Name         -> N/A          
 *     Type         -> N/A
 *     Description  -> N/A
 *
 * Local Variables:
 *     Name         -> dstream      
 *     Type         -> DataInputStrem
 *     Description  -> Creates the data input instance to read the file.
 * 
 *     Name         -> br     
 *     Type         -> BufferedReader
 *     Description  -> Creates the buffered instance to read the file.
 * 
 *     Name         -> strLine   
 *     Type         -> String
 *     Description  -> Reads the entire line of the file.
 *
 *     Name         -> i, k   
 *     Type         -> Integer
 *     Description  -> Loop control.
 * 
 *     Name         -> tokens 
 *     Type         -> String[]
 *     Description  -> Array that contains the read data row-by-row.
 * 
 * Global Variables:
 *     Name         -> strPH
 *     Type         -> String[][]
 *     Origin       -> Results
 *     Description  -> Contains the pH output data in string.
 * 
 *     Name         -> ph
 *     Type         -> double[][]
 *     Origin       -> Results
 *     Description  -> Contains the pH output data in double.
 * 
 *     Name         -> numCols
 *     Type         -> Integer
 *     Origin       -> Results
 *     Description  -> Contains the number of columns in the output file.
 *
 *     Name         -> numLines    
 *     Type         -> Integer
 *     Origin       -> Results
 *     Description  -> Contains the number of lines in the output file.
 * 
 * Modification History:
 *     Date         ->     
 *     Developer    ->
 *     Description  ->
 * 
     * @param pdb
 *****************************************************************************/
    public static void read_pdb(String pdb){
        try{
            fstream = new FileInputStream(pdb);
            try (DataInputStream dstream = new DataInputStream(fstream)) {
                BufferedReader br;
                br = new BufferedReader(new InputStreamReader(dstream));
                String strLine = null;
                Solute.setCharge(null);
                int i = 0;
                // Read File until the information needed is found
                while ((strLine = br.readLine()) != null) {
                    // Print the content on the console
                    String[] tokens = strLine.split("\\s+");
                    String temp1 = tokens[0];
                    if (temp1.equals("REMARK") && Solute.getCharge() == null){
                        String temp2 = tokens[1];
                        if (temp2.equals("6")){
                            String temp3 = tokens[2];
                            if (temp3.equals("Total") ) {
                                Solute.setCharge(tokens[7]);
                            }
                        }
                    }
                    if (temp1.equals("ATOM")){
                        i++;
                    }
                }
                /*fstream = new FileInputStream(type);
                DataInputStream dstream = new DataInputStream(fstream);
                BufferedReader br;
                br = new BufferedReader(new InputStreamReader(dstream));
                String strLine = null;
                Solute.setCharge(null);
                int i = 0;
                // Read File until the information needed is found
                while ((strLine = br.readLine()) != null){
                // Print the content on the console
                String[] tokens = strLine.split("\\s+");
                String temp1 = tokens[0];
                if (temp1.equals("REMARK") && Solute.getCharge() == null){
                String temp2 = tokens[1];
                if (temp2.equals("6")){
                String temp3 = tokens[2];
                if (temp3.equals("Total") ) {
                Solute.setCharge(tokens[7]);
                }
                }
                }
                if (temp1.equals("ATOM")){
                i++;
                }
                }
                dstream.close();
                numLines = i;
                // define variables of the input file
                String[] fieldName = new String[numLines];
                String[] atomNumber = new String[numLines];
                String[] atomName = new String[numLines];
                String[] residueName = new String[numLines];
                String[] chainId = new String[numLines];
                String[] residueNumber = new String[numLines];
                String[] coordX = new String[numLines];
                String[] coordY = new String[numLines];
                String[] coordZ = new String[numLines];
                String[] charge = new String[numLines];
                String[] radius = new String[numLines];
                // Read the rest of the file
                FileInputStream fstream1 = new FileInputStream(type);
                // Get the object of DataInputStream
                dstream = new DataInputStream(fstream1);
                br = new BufferedReader(new InputStreamReader(dstream));
                strLine = null;
                //Read File Line By Line
                i = 0;
                while ((strLine = br.readLine()) != null){
                // Print the content on the console
                String [] tokens = strLine.split("\\s+");
                if (tokens[0].equals("ATOM")){
                fieldName[i] = tokens[0];
                atomNumber[i] = tokens[1];
                atomName[i] = tokens[2];
                residueName[i] = tokens[3];
                //chainId[i] = tokens[4];
                residueNumber[i] = tokens[4];
                coordX[i] = tokens[5];
                coordY[i] = tokens[6];
                coordZ[i] = tokens[7];
                charge[i] = tokens[8];
                radius[i] = tokens[9];
                i ++;
                }
                }*/
                // Calculate radius and surface charge
                /*double xc = 0;
                double yc = 0;
                double zc = 0;
                for (int j = 0 ; j < numLines; j++) {
                xc = xc + Double.valueOf(coordX[j]);
                yc = yc + Double.valueOf(coordY[j]);
                zc = zc + Double.valueOf(coordZ[j]);
                }
                xc = xc / numLines;
                yc = yc / numLines;
                zc = zc / numLines;
                double x, y, z, r, sfc;
                x = 0.0; y = 0.0; z = 0.0; r = 0.0; sfc = 0.0;
                for (int j = 0 ; j < numLines; j++) {
                x = Math.pow(Double.valueOf(coordX[j]) - xc, 2);
                y = Math.pow(Double.valueOf(coordY[j]) - yc, 2);
                z = Math.pow(Double.valueOf(coordZ[j]) - zc, 2);
                if ("SPHERE".equals(Solute.getType())){
                r = r + Math.sqrt(x + y + z);
                }
                else if ("CYLINDER".equals(Solute.getType())){
                r = r + Math.sqrt(x + y);
                }
                }
                r = r / numLines;
                r = Math.round(r);
                Solute.setRadius(String.valueOf(r));
                if (null != Solute.getType())switch (Solute.getType()) {
                case "SPHERE":{
                sfc = (Double.valueOf(Solute.getCharge()) *
                1.60217646e-19) / (4*Math.PI*Math.pow(r*1.0e-10,2));
                int digitsAfterDecimal = 4;
                BigDecimal bigDecimal = BigDecimal.valueOf(sfc);
                // BigDecimal.ROUND_FLOOR is Rounding Mode..denote how your value is rounded off
                // Other ways are:- "ROUND_CEILING", "ROUND_DOWN", etc..
                bigDecimal = bigDecimal.setScale(digitsAfterDecimal,
                BigDecimal.ROUND_FLOOR);
                Solute.setCharge(String.valueOf(bigDecimal));
                break;
                }
                case "CYLINDER":{
                sfc = (Double.valueOf(Solute.getCharge())) / z;
                int digitsAfterDecimal = 4;
                BigDecimal bigDecimal = BigDecimal.valueOf(sfc);
                // BigDecimal.ROUND_FLOOR is Rounding Mode..denote how your value is rounded off
                // Other ways are:- "ROUND_CEILING", "ROUND_DOWN", etc..
                bigDecimal = bigDecimal.setScale(digitsAfterDecimal,
                BigDecimal.ROUND_FLOOR);
                Solute.setCharge(String.valueOf(bigDecimal));
                break;
                }
                }
                if(null != Utilities.getTheoryModel())switch (Utilities.getTheoryModel()) {
                case "SPM":
                BiomoleculesUI.txtSoluteCharge.setText(Solute.getCharge());
                BiomoleculesUI.txtSoluteRadius.setText(Solute.getRadius());
                break;
                case "PB":
                BiomoleculesUI.txtSoluteCharge.setText(Solute.getCharge());
                BiomoleculesUI.txtSoluteRadius.setText(Solute.getRadius());
                break;
                }*/
            }
        }catch (IOException e){//Catch exception if any
            Toolkit.getDefaultToolkit().beep(); 
            JOptionPane.showMessageDialog(null, ShowMessages.getNotFile(),
                   "ERROR", JOptionPane.ERROR_MESSAGE);
        } 
    }    
      
/******************************************************************************
 *
 * Procedure Name: get_number_of_columns
 * Original Author: Esteban Valderrama
 * Description: This method reads the number of columns in a file.
 * 
 * Calling Arguments:
 *     Name         -> Filename
 *     Input/Output -> I
 *     Type         -> String
 *     Description  -> Contains the name of the output file.
 * 
 * Return Value:
 *     Name         -> N/A          
 *     Type         -> N/A
 *     Description  -> N/A
 *
 * Local Variables:
 *     Name         -> strLine 
 *     Type         -> String
 *     Description  -> Reads the first line of the file.
 * 
 *     Name         -> scan
 *     Type         -> Scanner
 *     Description  -> Scans the first line of the file.
 * 
 *     Name         -> delimits     
 *     Type         -> String
 *     Description  -> Contains the characters to delimit the data.
 * 
 *     Name         -> tokens 
 *     Type         -> String[]
 *     Description  -> Array that contains the read data row-by-row.
 * 
 * Global Variables:
 *     Name         -> numCols
 *     Type         -> Integer
 *     Origin       -> Results
 *     Description  -> Contains the number of columns in the output file.
 * 
 * Modification History:
 *     Date         ->     
 *     Developer    ->
 *     Description  ->
 * 
     * @param Filename
 *****************************************************************************/
    public static void get_number_of_columns(String Filename){
        String strLine = null;
        file = new File(Filename);
        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                strLine = scan.nextLine();
            }
        } catch (Exception e) {
        }
        String delims = "[ ]+";
        String[] tokens = strLine.split(delims);
        if(Filename.contains("pH")){
            Results.setNumCols(tokens.length);
        }else{
            Results.setNumCols(tokens.length - 1);
        }
    }

 /******************************************************************************
 *
 * Procedure Name: convert_astring2adouble
 * Original Author: Esteban Valderrama
 * Description: This method converts an string array into double array.
 * 
 * Calling Arguments:
 *     Name         -> strArray
 *     Input/Output -> I
 *     Type         -> String[][]
 *     Description  -> Contains the data in string.
 * 
 *     Name         -> rows
 *     Input/Output -> I
 *     Type         -> Integer
 *     Description  -> Contains the number of rows of the array.
 * 
 *     Name         -> cols
 *     Input/Output -> I
 *     Type         -> Integer
 *     Description  -> Contains the number of columns of the array.
 * 
 * Return Value:
 *     Name         -> nums         
 *     Type         -> double[][]
 *     Description  -> Contains the data in double.
 *
 * Local Variables:
 *     Name         -> i, j
 *     Type         -> Integer
 *     Description  -> Loop control.
 * 
 * Global Variables:
 *     Name         -> N/A
 *     Type         -> N/A
 *     Origin       -> N/A
 *     Description  -> N/A
 * 
 * Modification History:
 *     Date         ->     
 *     Developer    ->
 *     Description  ->
 * 
     * @param strArray
     * @param rows
     * @param cols
     * @return 
 *****************************************************************************/
    public static double[][] convert_astring2adouble(String[][] strArray, 
                                                    int rows, int cols){
        double[][] nums = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                nums[i][j] = Double.parseDouble(strArray[i][j]);
            }
        }
        return nums;
    }  
}