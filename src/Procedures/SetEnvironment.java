/******************************************************************************
 *
 * Original Author: Esteban Valderrama
 * Description: Set environment variables
 *
 *****************************************************************************/

package Procedures;

import Classes.PHModel;
import Classes.Utilities;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;

public class SetEnvironment {
    
    static String workingDir;
    private static File directory;
    static File subDirectory;
    static File subDirectory2;
    
    /**
     * @return the directory
     */
    public static File getDirectory() {
        return directory;
    }

    /**
     * @param aDirectory the directory to set
     */
    public static void setDirectory(File aDirectory) {
        directory = aDirectory;
    }
     
    public static void set_directory(){
/******************************************************************************
 *
 * Procedure Name: set_directory
 * Original Author: Esteban Valderrama
 * Description: This method creates the workspace for CSDFTS projects.
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
    
    // This part of the creates the workspace the first time CSDFTS is used in a computer.    
//        workingDir = new JFileChooser().getFileSystemView()
//                .getDefaultDirectory().toString() + File.separatorChar 
//                + "JACFC_Workspace";
        workingDir = System.getProperty("user.dir") + File.separatorChar 
                + "JACFC_Workspace";
        setDirectory(new File(workingDir));
        if (!directory.isDirectory()) {
            getDirectory().mkdir();
        }
    }
 
    public static void create_subdirectories(){
/******************************************************************************
 *
 * Procedure Name: create_subdirectories
 * Original Author: Esteban Valderrama
 * Description: This method creates the subdirectories for CSDFTS analysis.
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
 *     Name         -> analysisPath
 *     Type         -> String   
 *     Origin       -> UtilitiesDefinition
 *     Description  -> Analysis path
 * 
 * Modification History:
 *     Date         ->     
 *     Developer    ->
 *     Description  ->
 * 
 *****************************************************************************/
        if (getDirectory().isDirectory()){
            String todayAsString = 
            new SimpleDateFormat("MM-dd-yyyy__HH-mm-ss").format(new Date());
//            String dir = workingDir + File.separatorChar + "Analysis_" 
//                    + PHModel.getAnalysisType() + "_"+ todayAsString;
            String dir = workingDir + File.separatorChar + todayAsString;            
            subDirectory = new File(dir); 
            subDirectory.mkdir();
            Utilities.setAnalysisPath(subDirectory.getAbsolutePath());
            PHModel.setUserTime(todayAsString);
        }
    }
}