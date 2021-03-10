/******************************************************************************
 *
 * @author Esteban Valderrama and Marcelo Marucho
 * Description: This class contains the methods to open files.
 *
 *****************************************************************************/

package Procedures;

import Classes.PHModel;
import Classes.Solute;
import Classes.Utilities;
import static Classes.testenv.Linuxenv;
import java.io.BufferedReader;
import java.io.File;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
//import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.io.OutputStream;
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class RunAnalysis {
    
    String[] exe;

/******************************************************************************
 *
 * Procedure Name: RunAnalysis
 * Original Author: Esteban Valderrama
 * Description: This constructor allows to start the process.
 * 
 * Calling Arguments:
 *     Name         -> exe
 *     Input/Output -> I
 *     Type         -> String[]
 *     Description  -> Contains the commands to run the analysis.
 * 
 * Return Value:
 *     Name         -> N/A          
 *     Type         -> N/A
 *     Description  -> N/A
 *
 * Local Variables:
 *     Name         -> bufferedReader 
 *     Type         -> BufferedReader
 *     Description  -> Allows to read the runtime output from the software and 
 *                     print them on the screen.
 * 
 *     Name         -> strLine
 *     Type         -> String
 *     Description  -> Read the runtime output line by line..
 * 
 *     Name         -> r     
 *     Type         -> Runtime
 *     Description  -> Initiates the runtime interface.
 * 
 *     Name         -> p
 *     Type         -> Process
 *     Description  -> Starts the process to run the software.
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
     * @param exe
 *****************************************************************************/
    public RunAnalysis(String exe) {
////        this.exe = exe;
        
        // Create runtime parameters        
        BufferedReader is;
        String line;
        Runtime r = Runtime.getRuntime();
        Process p;
        try {
            p = r.exec(exe); // Start process
            // Define variable to read outputs
            is = new BufferedReader(new InputStreamReader(p.getInputStream()));
            // Read the fortran output executable
            while ((line = is.readLine()) != null){
                // Write in screen
                System.out.println(line);
            }
            // Wait while the program finish
            int waitFor;
            waitFor = p.waitFor();
        } catch (IOException | InterruptedException ex) {
        }
    }

/******************************************************************************
 *
 * Procedure Name: run_sphere
 * Original Author: Esteban Valderrama
 * Description: This method sets the executable to run the software using
 *              spherical macroion.
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
 *     Name         -> exe
 *     Type         -> String[]
 *     Description  -> Contains the commands to run the analysis.
 * 
 * Global Variables:
 *     Name         -> OS
 *     Type         -> String
 *     Origin       -> Utilities
     Description  -> Contains the operating system.
 * 
 *     Name         -> analysisPath
 *     Type         -> String
 *     Origin       -> Utilities
     Description  -> Contains the workspace path for CSDFTS.
 * 
 * Modification History:
 *     Date         ->     
 *     Developer    ->
 *     Description  ->
 * 
     * @throws java.io.FileNotFoundException
 *****************************************************************************/
    public static void run_sphere() throws FileNotFoundException, IOException{
        
        // Call executable
        if (Utilities.getOS().equals("windows")){
            String exe = "sphere_windows.exe " +
                    Utilities.getAnalysisPath() +
                    File.separatorChar + "inp.in";
            RunAnalysis executable = new RunAnalysis(exe);
        }
        
        if(Utilities.getOS().equals("mac")){
            String exe = "./sphere_mac.exe " +
                           Utilities.getAnalysisPath()
                           + File.separatorChar + "inp.in";
            RunAnalysis executable = new RunAnalysis(exe);
        }        
        
        if(Utilities.getOS().equals("linux")){

                    String exe3 =  System.getProperty("user.dir") +"/Linux/signalprop.sh "
                          + Utilities.getAnalysisPath()
                           + File.separatorChar + "inp.in";   
                System.out.println(exe3);
                System.out.println("WAIT...the solver is performing calculations in an external console");
                RunAnalysis executable3 = new RunAnalysis(exe3);

        }    
    }

/**********************System********************************************************
 *
 * Procedure Name: run_cylinder
 * Original Author: Esteban Valderrama
 * Description: This method sets the executable to run the software using 
 *              cylindrical macroion.
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
 *     Name         -> exe
 *     Type         -> String[]
 *     Description  -> Contains the commands to run the analysis.
 * 
 * Global Variables:
 *     Name         -> OS
 *     Type         -> String
 *     Origin       -> Utilities
     Description  -> Contains the operating system.
 * 
 *     Name         -> analysisPath
 *     Type         -> String
 *     Origin       -> Utilities
     Description  -> Contains the workspace path for CSDFTS.
 * 
 * Modification History:
 *     Date         ->     
 *     Developer    ->
 *     Description  ->
 * 
     * @throws java.io.FileNotFoundException
 *****************************************************************************/
    public static void run_cylinder() throws FileNotFoundException, IOException{

        if(Utilities.getOS().equals("windows")){
            String exe = "cylinder_windows.exe " +
                           Utilities.getAnalysisPath() + "\\inputfile.in";
            RunAnalysis executable = new RunAnalysis(exe);
        }
        
        if(Utilities.getOS().equals("mac")){
            String exe = "./cylinder_mac.exe " +
                           Utilities.getAnalysisPath() + "/inputfile.in";
            RunAnalysis executable = new RunAnalysis(exe);
        }        
        
        if(Utilities.getOS().equals("linux")){
                String src = Utilities.getAnalysisPath()
                                    +"/" + "inputfile.in";
                String dst = "inputfile_"+PHModel.getUserTime()+".in";
                CopyFiles.copy_Files(src, dst);   
                
                    String exe3 = System.getProperty("user.dir") +"/Linux/cylinderwrap.sh " 
                    +System.getProperty("user.dir") +" "+  Utilities.getAnalysisPath()
                            +" "+dst;
              System.out.println(exe3);
                System.out.println("WAIT...the solver is performing calculations in an external console");
                RunAnalysis executable3 = new RunAnalysis(exe3);

        }      
    }
    
    public static void run_pdb2pqr() throws IOException{
        
        
        String ext = ".pdb";
        String TargetExt = ".pqr";
        PHModel.setPathPQR(PHModel.getPathPDB().replace(ext, TargetExt));
        // Call executable
        if (Utilities.getOS().equals("windows")){
            PHModel.setPathPDB2PQR("pdb2pqr_win" + File.separatorChar);
            String exe = PHModel.getPathPDB2PQR()
                + "pdb2pqr.exe --with-ph="
                + PHModel.getpH()
                + " --ff=" + PHModel.getForceField()
                + " " + PHModel.getPathPDB() + " "
                + PHModel.getPathPQR();
                RunAnalysis executable = new RunAnalysis(exe);
        }
        
        if(Utilities.getOS().equals("mac")){
            PHModel.setPathPDB2PQR("pdb2pqr" + File.separatorChar);
            String exe = PHModel.getPathPDB2PQR()
                + "./pdb2pqr --with-ph="
                + PHModel.getpH()
                + " --ff=" + PHModel.getForceField()
                + " " + PHModel.getPathPDB() + " "
                + PHModel.getPathPQR();
            File file1 = new File(exe);
            System.out.println(file1.getAbsolutePath());
            RunAnalysis executable = new RunAnalysis(exe);
        }        
        
        if(Utilities.getOS().equals("linux")){
            String dst = "input_"+ PHModel.getUserTime()+".pqr";
            PHModel.setPathPDB2PQR("pdb2pqr" + File.separatorChar);

             String exe = PHModel.getPathPDB2PQR()
                + "./pdb2pqr"+ " --ph-calc-method=propka"+" --with-ph="+ PHModel.getpH()
                     +" --ff=" + PHModel.getForceField()
                + " " + PHModel.getPathPDB() + " " + dst;
             String exe2 = System.getProperty("user.dir") + 
                     "/Linux/molecularcharacterization.sh "+
                 System.getProperty("user.dir")+" "+Utilities.getAnalysisPath()+
                    " " + PHModel.getUserTime();  
              String exe21 = System.getProperty("user.dir") + 
                     "/Linux/bpchargeandradius.sh "+
                 System.getProperty("user.dir")+" "+Utilities.getAnalysisPath()+
                    " " + PHModel.getUserTime(); 
            // System.out.println(exe);
            
            // write outputfile with pdb2pqr command  line and args
            String pdbtmp = "pdb2pqrarg_"+PHModel.getUserTime()+".tmp";
            PrintWriter pw = new PrintWriter(new FileWriter(pdbtmp));
            pw.write(exe);
            pw.write(System.lineSeparator());
            pw.write(exe2);
            pw.write(System.lineSeparator());
            pw.write(exe21);
	    pw.close();
             File f2 = new File(pdbtmp);

            String exe3 = System.getProperty("user.dir") + "/Linux/runpdb2pqr.sh "+
                 System.getProperty("user.dir")+" "+Utilities.getAnalysisPath()+
                    " " + PHModel.getUserTime();
//            System.out.println(exe3);
            RunAnalysis executable3 = new RunAnalysis(exe3);
            
        }    
    }
    
    public static void run_pdb2xyzr() throws FileNotFoundException {
        // Call executable
    
        String ext = ".pdb";
        String TargetExt = "_noions.pdb";
        PHModel.setPathPQR(PHModel.getPathPDB().replace(ext, TargetExt));
        //CopyFiles.copy_Files(PHModel.getPathPDB(), PHModel.getPathPQR());
        ext = ".pdb";
        TargetExt = ".xyzr";
        PHModel.setPathXYZR(PHModel.getPathPDB().replace(ext, TargetExt));
        if (Utilities.getOS().equals("windows")){
            //ExecuteShellCommand.shellComm();
            PHModel.setPathPDB2XYZR("3v_win/xyzr" + File.separatorChar);
            String exe = PHModel.getPathPDB2XYZR()
                    + "pdb_to_xyzr.exe " + PHModel.getPathPDB() + " > " +
                    PHModel.getPathXYZR();
            System.out.println(exe);
            RunAnalysis executable = new RunAnalysis(exe);
        }
        
        if(Utilities.getOS().equals("mac")){
            //ExecuteShellCommand.shellComm();
            PHModel.setPathPDB2XYZR("3v/xyzr" + File.separatorChar);
            String exe = PHModel.getPathPDB2XYZR()
                    + "./pdb_to_xyzr " + PHModel.getPathPDB() + " > " +
                    PHModel.getPathXYZR();
            RunAnalysis executable = new RunAnalysis(exe);
        }        
        
        if(Utilities.getOS().equals("linux")){
        //copy loaded pdb file into the working directory and rename it
        CopyFiles.copy_Files(PHModel.getPathPDB(),"input.pdb");
        String openterm = Linuxenv();
        if (Solute.getType().equals("SPHERE")){
        String exe3 = openterm + "./Linux/gpwrap.sh ";
        System.out.println(exe3);
            RunAnalysis executable3 = new RunAnalysis(exe3);
        }    
        if(Solute.getType().equals("CYLINDER")){
        String exe3 = System.getProperty("user.dir") + "/Linux/bpwrap.sh "+
                 System.getProperty("user.dir")+" "+Utilities.getAnalysisPath()+
                    " " + PHModel.getUserTime();
        System.out.println(exe3);
            RunAnalysis executable3 = new RunAnalysis(exe3);
        } 
        }
    }
    
    public static void run_volume(){
        
        // Call executable'ls > waitfile.tmp'
                
     if (Utilities.getOS().equals("windows")){
            //ExecuteShellCommand.shellComm();
    String exe4 = "cmd " + "java -jar provol/.ProteinVolume.jar "
           + PHModel.getPathPDB()+ " > vol.txt";
                // System.out.println (exe4);
                RunAnalysis executable4 = new RunAnalysis(exe4);  
        String exe5 = "DEL OutputFile*";
                // System.out.println (exe4);
                RunAnalysis executable5 = new RunAnalysis(exe5);
        }
        
        if(Utilities.getOS().equals("mac")){
    String exe4 = "java -jar provol/.ProteinVolume.jar input.pdb > vol.txt";
                // System.out.println (exe4);
                RunAnalysis executable4 = new RunAnalysis(exe4);  
        String exe5 = "rm OutputFile*";
                // System.out.println (exe4);
                RunAnalysis executable5 = new RunAnalysis(exe5);
        }        
        
        if(Utilities.getOS().equals("linux")){
          String workpdb = "input_"+PHModel.getUserTime()+".pdb";
        CopyFiles.copy_Files(PHModel.getPathPDB(),workpdb);
        //copy loaded pdb file into the working directory and rename it
        String openterm = Linuxenv();
        if (Solute.getType().equals("SPHERE")){
        String exe3 = openterm + "./Linux/gpwrapprovol.sh ";
        System.out.println(exe3);
            RunAnalysis executable3 = new RunAnalysis(exe3);
        }    
        if(Solute.getType().equals("CYLINDER")){
          String exe3 = System.getProperty("user.dir") + "/Linux/bpwrapprovol.sh "+
                 System.getProperty("user.dir")+" "+Utilities.getAnalysisPath()+
                    " " + PHModel.getUserTime(); 
//        String exe3 = openterm + "./Linux/bpwrapprovol.sh ";
        System.out.println(exe3);
            RunAnalysis executable3 = new RunAnalysis(exe3);
        }
        }
    }
}
