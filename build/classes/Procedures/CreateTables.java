/******************************************************************************
 *
 * Procedure Name: CreateTables
 * Original Author: Esteban Valderrama
 * File Creation Date: Feb 10, 2015
 * Development Group: Computational Physics Laboratory at UTSA
 * Description: This class contains the methods to create the tables.
 *
 *****************************************************************************/

package Procedures;

import Classes.Ions;
//import Classes.PHModel;
import Classes.Results;
import Classes.Utilities;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import Forms.ResultsUI;
import org.jdesktop.swingx.JXTable;

public class CreateTables {
    
    static JFrame frame = new JFrame();
    String columnNames[];
    String dataValues[][];

/******************************************************************************
 *
 * Procedure Name: CreateTables
 * Original Author: Esteban Valderrama
 * Description: Constructor to create tables
 * 
 * Calling Arguments:
 *     Name         -> rows
 *     Input/Output -> I
 *     Type         -> Integer
 *     Description  -> This is the number of rows in the table.
 *
 *     Name         -> cols
 *     Input/Output -> I
 *     Type         -> Integer
 *     Description  -> This is the number of columns in the table.
 * 
 * Return Value:
 *     Name         -> N/A          
 *     Type         -> N/A
 *     Description  -> N/A
 * 
 * Local Variables:
 *     Name         -> N/A      
 *     Type         -> N/A
 *     Description  -> N/A
 * 
 * Global Variables:
 *     Name         -> columnNames       
 *     Type         -> String[]
 *     Origin       -> CreateTables
 *     Description  -> Contains the titles of the table.
 * 
 *     Name         -> dataValues       
 *     Type         -> String[][]
 *     Origin       -> CreateTables
 *     Description  -> Contains the values for the table.
 * 
 * Modification History:
 *     Date         ->     
 *     Developer    ->
 *     Description  ->
 * 
     * @param rows
     * @param cols
 *****************************************************************************/
    public CreateTables(int rows, int cols) {
        this.columnNames = new String[cols];
        this.dataValues = new String[rows][cols + 1];
    }

/******************************************************************************
 *
 * Procedure Name: set_table_item_list
 * Original Author: Esteban Valderrama
 * Description: This method saves the titles and data for the table in arrays.
 * 
 * Calling Arguments:
 *     Name         -> data
 *     Input/Output -> I
 *     Type         -> String[][]
 *     Description  -> This array contains the result data to be copied in the 
 *                     table.
 * 
 * Return Value:
 *     Name         -> N/A          
 *     Type         -> N/A
 *     Description  -> N/A
 * 
 * Local Variables:
 *     Name         -> table       
 *     Type         -> JXTable
 *     Description  -> Table.
 * 
 *     Name         -> count       
 *     Type         -> Integer
 *     Description  -> Count the number of columns to create the table.
 *
 *     Name         -> i, j       
 *     Type         -> Integer
 *     Description  -> Loop control.
 * 
 * Global Variables:
 *     Name         -> numLines
 *     Type         -> Integer
 *     Origin       -> Results
 *     Description  -> Contains the number of lines of the data.
 * 
 *     Name         -> numCols
 *     Type         -> Integer
 *     Origin       -> Results
 *     Description  -> Contains the number of columns of the data.
 *
 *     Name         -> columnNames       
 *     Type         -> String[]
 *     Origin       -> CreateTables
 *     Description  -> Contains the titles of the table.
 * 
 *     Name         -> dataValues       
 *     Type         -> String[][]
 *     Origin       -> CreateTables
 *     Description  -> Contains the values for the table.
 * 
 * Modification History:
 *     Date         ->     
 *     Developer    ->
 *     Description  ->
 * 
     * @param data
 *****************************************************************************/
    public static void set_table_item_list(String[][] data) {
        
        CreateTables new_table = new CreateTables(Results.getNumLines(), Results.getNumCols());
        if (Results.isOpeningOutput()){
            new_table.columnNames = create_titles_for_outputfile();
        }else{
            new_table.columnNames = create_titles();
        }
        
        for (int i = 0; i < Results.getNumLines(); i++){
            new_table.dataValues[i][0] = String.valueOf(i + 1);
            for (int j = 1; j < Results.getNumCols() + 1; j++){   
                new_table.dataValues[i][j] = data[i][j-1];
            }
        }
        
        // Create table layout
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        JXTable table = new JXTable(new_table.dataValues, new_table.columnNames);
        table.setEditable(false);
        table.setFillsViewportHeight(true);
        table.getColumn(new_table.columnNames[1]).setMaxWidth(70);
        table.getColumn(new_table.columnNames[0]).setMaxWidth(50);
        int count = 1;
        for (int j = 2; j < Results.getNumCols() + 1; j++){
            table.getColumn(new_table.columnNames[j]).setMinWidth(100);
            count++;
        }
        JScrollPane tableContainer = new JScrollPane(table);
        frame.getContentPane().add(tableContainer);
        if(count <= 4){
            frame.setSize(125+(count*100), 310);
        }else{
            frame.setSize(525, 310);
            table.setHorizontalScrollEnabled(true);
        }
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

/******************************************************************************
 *
 * Procedure Name: create_titles
 * Original Author: Esteban Valderrama
 * Description: This method saves the titles for the table in an array.
 * 
 * Calling Arguments:
 *     Name         -> N/A
 *     Input/Output -> N/A
 *     Type         -> N/A
 *     Description  -> N/A
 * 
 * Return Value:
 *     Name         -> N/A          
 *     Type         -> N/A
 *     Description  -> N/A
 * 
 * Local Variables:
 *     Name         -> columnNames       
 *     Type         -> String[]
 *     Description  -> Contains the titles of the table.
 *
 *     Name         -> i, j, k, l       
 *     Type         -> Integer
 *     Description  -> Loop control.
 * 
 * Global Variables:
 *     Name         -> counter
 *     Type         -> Integer
 *     Origin       -> IonsDefinition
 *     Description  -> Contains the number of ions.
 * 
 *     Name         -> numCols
 *     Type         -> Integer
 *     Origin       -> Results
 *     Description  -> Contains the number of columns of the data.
 * 
 *     Name         -> symbol
 *     Type         -> String
 *     Origin       -> IonsDefinition
 *     Description  -> Contains the names of columns of the data.
 * 
 * Modification History:
 *     Date         ->     
 *     Developer    ->
 *     Description  ->
 * 
     * @return 
 *****************************************************************************/
    public static String[] create_titles(){
        
        String columnNames[] = new String[Results.getNumCols() + 1];
      if (ResultsUI.rbnDensityProfile.isSelected()){
            columnNames[0] = "Points";
            columnNames[1] = "Radius [A]";
            
            if (Ions.symbol == null){
                Ions.symbol = new String[Ions.getCounter()];
            }
            int k = 0;
            for (int j = 2; j < Results.getNumCols()+1; j++){
                if (Ions.symbol[k] != null){
                    columnNames[j] = "ρ (r) - " + Ions.symbol[k];
                }else{
                    columnNames[j] = "ρ (r) - " + "Ion " + (k+1);        
                }
            k++;  
            }
        }else if (ResultsUI.rbnElectrostaticPotential.isSelected()){
            columnNames[0] = "Points";
            columnNames[1] = "Radius [A]";
            columnNames[2] = "ψ (r ;{ ρ (r) } )";
        }else if (ResultsUI.rbnIntegratedCharge.isSelected()){
            columnNames[0] = "Points";
            columnNames[1] = "Radius [A]";
            columnNames[2] = "P(r)";
        }else if (ResultsUI.rbnIonContributions.isSelected()){
            columnNames[0] = "Points";
            columnNames[1] = "Radius [A]";
            Ions.setCounter((Results.getNumCols() - 1) / 4);
            int k = 2;
            int l = 0;
            for (int j = 0; j < Ions.getCounter(); j++){
                if (Ions.symbol[l] != null){
                    columnNames[k] = "ψ (r ;{ ρ (r) } ) - " + 
                            Ions.symbol[l];
                }else{
                    columnNames[k] = "ψ (r ;{ ρ (r) } ) - " + "Ion " + (l+1);        
                } 
                l++;
                k++;
            }
            l = 0;
            for (int j = 0; j < Ions.getCounter(); j++){
                if (Ions.symbol[l] != null){
                    columnNames[k] = "C1hs (r ;{ ρ (r) } ) - " + 
                            Ions.symbol[l];
                }else{
                    columnNames[k] = "C1hs (r ;{ ρ (r) } ) - " + "Ion " + (l+1);        
                }  
                k++;
                l++;
            }
            l = 0;
            for (int j = 0; j < Ions.getCounter(); j++){
                if (Ions.symbol[l] != null){
                    columnNames[k] = "c1res (r ;{ ρ (r) } ) - " + 
                            Ions.symbol[l];
                }else{
                    columnNames[k] = "c1res (r ;{ ρ (r) } ) - " + "Ion " + (l+1);        
                }  
                k++;
                l++;
            }
            l = 0;
            for (int j = 0; j < Ions.getCounter(); j++){
                if (Ions.symbol[j] != null){
                    columnNames[k] = "T.C (r ;{ ρ (r) } ) - " + 
                            Ions.symbol[l];
                }else{
                    columnNames[k] = "T.C (r ;{ ρ (r) } ) - " + "Ion " + (l+1);        
                }  
                k++;
                l++;
            }
        }
        return columnNames;
    }

/******************************************************************************
 *
 * Procedure Name: create_titles_for_outputfile
 * Original Author: Esteban Valderrama
 * Description: This method saves the titles for the table in an array, when the
 *              user opens an output file.
 * 
 * Calling Arguments:
 *     Name         -> N/A
 *     Input/Output -> N/A
 *     Type         -> N/A
 *     Description  -> N/A
 * 
 * Return Value:
 *     Name         -> N/A          
 *     Type         -> N/A
 *     Description  -> N/A
 * 
 * Local Variables:
 *     Name         -> columnNames       
 *     Type         -> String[]
 *     Description  -> Contains the titles of the table.
 *
 *     Name         -> i, j, k     
 *     Type         -> Integer
 *     Description  -> Loop control.
 * 
 * Global Variables:
 *     Name         -> counter
 *     Type         -> Integer
 *     Origin       -> IonsDefinition
 *     Description  -> Contains the number of ions.
 * 
 *     Name         -> numCols
 *     Type         -> Integer
 *     Origin       -> Results
 *     Description  -> Contains the number of columns of the data.
 * 
 *     Name         -> analysisPath
 *     Type         -> String
 *     Origin       -> Utilities
     Description  -> Contains the filename.
 * 
 * Modification History:
 *     Date         ->     
 *     Developer    ->
 *     Description  ->
 * 
     * @return 
 *****************************************************************************/
    public static String[] create_titles_for_outputfile(){
        
        String columnNames[] = new String[Results.getNumCols() + 1];
        if (Utilities.getAnalysisPath().contains("pH")){
            columnNames[0] = "Points";
            columnNames[1] = "pH";
            columnNames[2] = "Surface Charge";
        }else if (Utilities.getAnalysisPath().contains("DensityProfile")){
            columnNames[0] = "Points";
            columnNames[1] = "Radius [A]";
            Ions.setCounter(Results.getNumCols() - 1);
            int k = 0;
            for (int j = 2; j < Results.getNumCols()+1; j++){
                columnNames[j] = "ρ (r) - " + "Ion " + (k+1);        
                k++;  
            }
        }else if (Utilities.getAnalysisPath().contains("ElectrostaticPotential")){
            columnNames[0] = "Points";
            columnNames[1] = "Radius [A]";
            columnNames[2] = "ψ (r ;{ ρ (r) } )";
        }else if (Utilities.getAnalysisPath().contains("IntegratedCharge")){
            columnNames[0] = "Points";
            columnNames[1] = "Radius [A]";
            columnNames[2] = "P(r)";
        }else if (Utilities.getAnalysisPath().contains("Pressure")){
            columnNames[0] = "Points";
            columnNames[1] = "Radius [A]";
            columnNames[2] = "P(r)";
        }else if (Utilities.getAnalysisPath().contains("IonContributions")){
            columnNames[0] = "Points";
            columnNames[1] = "Radius [A]";
            Ions.setCounter((Results.getNumCols() - 1) / 4);
            int k = 2;
            for (int j = 0; j < Ions.getCounter(); j++){
                columnNames[k] = "ψ (r ;{ ρ (r) } ) - " + "Ion " + (j+1);         
                k++;
            }
            for (int j = 0; j < Ions.getCounter(); j++){
                columnNames[k] = "C1hs (r ;{ ρ (r) } ) - " + "Ion " + (j+1);        
                k++;
            }
            for (int j = 0; j < Ions.getCounter(); j++){
                columnNames[k] = "c1res (r ;{ ρ (r) } ) - " + "Ion " + (j+1);        
                k++;
            }
            for (int j = 0; j < Ions.getCounter(); j++){
                columnNames[k] = "T.C (r ;{ ρ (r) } ) - " + "Ion " + (j+1);        
                k++;
            }
        }
        return columnNames;
    }
    
/******************************************************************************
 *
 * Procedure Name: dispose_data
 * Original Author: Esteban Valderrama
 * Description: This method disposes the table frame.
 * 
 * Calling Arguments:
 *     Name         -> N/A
 *     Input/Output -> N/A
 *     Type         -> N/A
 *     Description  -> N/A
 * 
 * Return Value:
 *     Name         -> N/A          
 *     Type         -> N/A
 *     Description  -> N/A
 * 
 * Local Variables:
 *     Name         -> N/A      
 *     Type         -> N/A
 *     Description  -> N/A
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
 *****************************************************************************/
    public static void dispose_data(){
        frame.dispose();
        frame = new JFrame();
    }
}