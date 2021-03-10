/******************************************************************************
 *
 * Original Author: Esteban Valderrama
 * Description: This class contains the methods to upload files.
 *
 *****************************************************************************/

package Procedures;

import Classes.PHModel;
import Classes.Results;
import Classes.Utilities;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LoadFiles {
    
    String workingDir;
    static JFileChooser fileChooser;
    FileNameExtensionFilter filter;
    static int returnVal;
    static File file;

/******************************************************************************
 *
 * Procedure Name: LoadFiles
 * Original Author: Esteban Valderrama
 * Description: Load Files constructor
 * 
 * Calling Arguments:
 *     Name         -> workingDir       
 *     Type         -> String
 *     Description  -> Contains the path for the working directory.
 * 
 *     Name         -> fileChooser      
 *     Type         -> JFileChooser
 *     Description  -> File chooser dialog window.
 * 
 *     Name         -> filter      
 *     Type         -> FileNameExtensionFilter
 *     Description  -> File filter.
 * 
 *     Name         -> returnVal     
 *     Type         -> Integer
 *     Description  -> it contains 1 if the user chooses a file, otherwise 0.
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
 *     Name         -> attachment
 *     Type         -> String
 *     Origin       -> Utilities
     Description  -> Path of the selected file.
 * 
 * Modification History:
 *     Date         ->     
 *     Developer    ->
 *     Description  ->
 * 
     * @param workingDir
     * @param fileChooser
     * @param filter
     * @param returnVal
     * @param file
 *****************************************************************************/
    public LoadFiles(String workingDir, JFileChooser fileChooser, 
                    FileNameExtensionFilter filter, int returnVal, File file) {
        this.workingDir = workingDir;
        LoadFiles.fileChooser = fileChooser;
        this.filter = filter;
        LoadFiles.returnVal = returnVal;
        LoadFiles.file = file;
        
        LoadFiles.fileChooser.setFileFilter(filter);
        LoadFiles.returnVal = fileChooser.showOpenDialog(null);
    }

 /******************************************************************************
 *
 * Procedure Name: LoadFiles
 * Original Author: Esteban Valderrama
 * Description: Load Files constructor
 * 
 *     Name         -> workingDir       
 *     Type         -> String
 *     Description  -> Contains the path for the working directory.
 * 
 *     Name         -> fileChooser      
 *     Type         -> JFileChooser
 *     Description  -> File chooser dialog window.
 * 
 *     Name         -> returnVal     
 *     Type         -> Integer
 *     Description  -> it contains 1 if the user chooses a file, otherwise 0.
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
 *     Name         -> attachment
 *     Type         -> String
 *     Origin       -> Utilities
     Description  -> Path of the selected file.
 * 
 * Modification History:
 *     Date         ->     
 *     Developer    ->
 *     Description  ->
 * 
     * @param workingDir
     * @param fileChooser
     * @param returnVal
     * @param file
 *****************************************************************************/
    public LoadFiles(String workingDir, JFileChooser fileChooser, int returnVal, 
                    File file) {
        this.workingDir = workingDir;
        LoadFiles.fileChooser = fileChooser;
        LoadFiles.returnVal = returnVal;
        LoadFiles.file = file;
        
        LoadFiles.returnVal = LoadFiles.fileChooser.showOpenDialog(null);
    }
   
/******************************************************************************
 *
 * Procedure Name: load_pdb_file
 * Original Author: Esteban Valderrama
 * Description: This method loads the pdb file.
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
 *     Name         -> pathPDB
 *     Type         -> String
 *     Origin       -> PHModel
     Description  -> Path of the PDB file.
 * 
 *     Name         -> pathPDB2PQR
 *     Type         -> String
 *     Origin       -> PHModel
     Description  -> Path of the PDB2PQR solver.
 * 
 * Modification History:
 *     Date         ->     
 *     Developer    ->
 *     Description  ->
 * 
 *****************************************************************************/
    public static void load_pdb_file() {
         String workingdir = System.getProperty("user.dir");
         String dir3 = workingdir+"/pdbfiles";
         LoadFiles new_file = new LoadFiles(System.getProperty("user.dir"),
                new JFileChooser(dir3), new FileNameExtensionFilter(".pdb","pdb"), 
                1, null);

        if (LoadFiles.returnVal == JFileChooser.APPROVE_OPTION) {
            LoadFiles.file = LoadFiles.fileChooser.getSelectedFile();
            PHModel.setPathPDB(String.valueOf(LoadFiles.file));
            PHModel.setPathPDB2PQR(String.valueOf(LoadFiles.file));
//            String todayAsString = 
//                    new SimpleDateFormat("MM-dd-yyyy__HH-mm-ss").
//                    format(new Date());
//            PHModel.setUserTime(todayAsString);
        }else{
            PHModel.setPathPDB2PQR("");
            PHModel.setPathPDB("");
            JOptionPane.showMessageDialog(null, "No File Selected.", 
                                         "INFORMATION", JOptionPane.OK_OPTION);
        }     
    }
 
/******************************************************************************
 *
 * Procedure Name: load_attachment
 * Original Author: Esteban Valderrama
 * Description: This method loads the attachment for the email.
 * 
 * Calling Arguments:
 *     Name         -> N/A
 *     Input/Output -> N/A
 *     Type         -> N/A
 *     Description  -> N/A
 * 
 * Return Value:
 *     Name         -> file       
 *     Type         -> File
 *     Description  -> Contains the selected file.
 * 
 * Local Variables:
 *     Name         -> N/A       
 *     Type         -> N/A
 *     Description  -> N/A
 *
 * Global Variables:
 *     Name         -> attachment
 *     Type         -> String
 *     Origin       -> Utilities
     Description  -> Path of the selected file.
 * 
 * Modification History:
 *     Date         ->     
 *     Developer    ->
 *     Description  ->
 * 
     * @return 
 *****************************************************************************/
    public static File load_attachment() {
//        String zipDir = Utilities.getAnalysisPath();
//        )+
//                File.separatorChar + "simulationresults.zip"
//        LoadFiles new_file = new LoadFiles(System.getProperty("user.dir"),
        LoadFiles new_file = new LoadFiles(Utilities.getAnalysisPath(),
                new JFileChooser(), 1, null);
        if (LoadFiles.returnVal == JFileChooser.APPROVE_OPTION) {
//            LoadFiles.file = LoadFiles.fileChooser.getSelectedFile();
         File dir = new File("simulationresults.zip");
            LoadFiles.file = dir;
//            Utilities.setAttachment(LoadFiles.fileChooser.getSelectedFile().getName());
            Utilities.setAttachment("simulationresults.zip");
        }else{
            JOptionPane.showMessageDialog(null, "No File Selected.", 
                                         "INFORMATION", JOptionPane.OK_OPTION);
        }
        return LoadFiles.file;
    }
    
/******************************************************************************
 *
 * Procedure Name: load_output_file
 * Original Author: Esteban Valderrama
 * Description: This method loads the output file.
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
 * 
 *     Name         -> analysisPath
 *     Type         -> String
 *     Origin       -> Utilities
     Description  -> Path of the output file.
 * 
 * Modification History:
 *     Date         ->     
 *     Developer    ->
 *     Description  ->
 * 
 *****************************************************************************/
    public static void load_output_file() {
        
        LoadFiles new_file = new LoadFiles(System.getProperty("user.dir"),
                new JFileChooser(), new FileNameExtensionFilter(".dat","dat"), 
                1, null);

        if (LoadFiles.returnVal == JFileChooser.APPROVE_OPTION) {
            LoadFiles.file = LoadFiles.fileChooser.getSelectedFile();
            Utilities.setAnalysisPath(String.valueOf(LoadFiles.file));
        }else{
            Results.setOpeningOutput(false);
            Utilities.setAnalysisPath("");
            JOptionPane.showMessageDialog(null, "No File Selected.", 
                                         "INFORMATION", JOptionPane.OK_OPTION);
        }     
    }
}