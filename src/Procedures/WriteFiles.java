/******************************************************************************
 *
 * @author Esteban Valderrama and Marcelo Marucho
 * Description: This class contains the methods to write the Fortran code 
 * input files.
 *
 *****************************************************************************/

package Procedures;

import Classes.Ions;
import Classes.NumericalScheme;
import Classes.Solute;
import Classes.Solvent;
import Classes.ThermodynamicProperties;
import Classes.Utilities;
import Classes.PHModel;
import Classes.SolverModel;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import javax.swing.JOptionPane;

public class WriteFiles {
    
    
    File file;
    FileOutputStream outputStream;
    static OutputStreamWriter outputWriter;

    public WriteFiles(File file) {
        try {
            this.file = file;
            outputStream = new FileOutputStream(this.file);
            outputWriter = new OutputStreamWriter(outputStream);
        } catch (FileNotFoundException ex) {
            Toolkit.getDefaultToolkit().beep(); 
            JOptionPane.showMessageDialog(null, ShowMessages.getNotFile(),
                   "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void write_sphere() {
    
        try{
            // Create file.
            WriteFiles new_file = new WriteFiles(new File(Utilities.getAnalysisPath() 
                                                + File.separatorChar + "inp.in"));
            //write input file
            try (BufferedWriter w = new BufferedWriter(outputWriter)) {
                // Start writing input file.
                w.write("&NUMERICAL_SCHEME" + "\n");
                w.write("  RESOLUTION = " + NumericalScheme.getResolution() + "d-8" + "\n");
                w.write("  TOLERANCE = " + NumericalScheme.getTolerance() + "\n");
                w.write("  MIXING_PARAMETER = " + NumericalScheme.getMixing() + "\n");
                w.write("&DEFINE_MODEL" + "\n");
                w.write("  MODEL = "  + Utilities.getTheoryModel()  + "\n");
                w.write("  USE_MULTIGRID = "  + NumericalScheme.getMultigrid()  + "\n");
                w.write("  ANALYSIS = "  + PHModel.getAnalysisType()  + "\n");
                w.write("  PH = " + PHModel.getpH() + "\n");
                if ("NANOPARTICLE".equals(PHModel.getAnalysisType())){
                    w.write("  NSITES = " + PHModel.getNtotal() + "\n");
                    w.write("  PKA = " + PHModel.getpKA() + "\n");
                    w.write("  PKB = " + PHModel.getpKB() + "\n");
                }else if ("GLOBULAR_PROTEIN".equals(PHModel.getAnalysisType())){
                    w.write("  NSITES = 0.0 \n");
                    w.write("  PKA = 0.0 \n");
                    w.write("  PKB = 0.0 \n");
                }
                w.write("&ION" + "\n");
                w.write("  NUMBER_OF_IONS = " + Ions.getCounter() + "\n");
                for (int i = 0; i < Ions.getCounter(); i++){
                   // w.write("&ION" + "\n"); //
                    w.write("  NAME = "  + Ions.symbol[i]  + "\n");
                    w.write("  CHARGE = " + Ions.valence[i] + "\n");
                    w.write("  DENSITY = " + Ions.concentration[i] + "d0\n");
                    w.write("  DIAMETER = " + Ions.strDiameter[i] + "d-8" + "\n");
                }
                w.write("  DIELECTRIC = " + Solvent.getDielectric() + "d0\n");
                w.write("&DEFINE_SOLUTE" + "\n");  
                w.write("  SOLUTE_TYPE = "  + Solute.getType()  + "\n");
                w.write("  RADIUS = " +  Solute.getRadius() + "d-8" + "\n");
                w.write("  SURFACE_CHARGE = " + Solute.getCharge() + "\n");
                w.write("&THERMODYNAMIC_PARAMETERS" + "\n");
                w.write("  TEMPERATURE = " + ThermodynamicProperties.getTemperature() + "\n");             
                w.write("  PATH_ION_CORR_FILE = " + Utilities.getAnalysisPath() + File.separatorChar + "\n");
            }
        } catch (IOException e) {
            Toolkit.getDefaultToolkit().beep(); 
            JOptionPane.showMessageDialog(null, ShowMessages.getWritingInput(),
                   null, JOptionPane.WARNING_MESSAGE);
        }  
    }
    
    public static void write_cylinder(){
    
        try{
            WriteFiles new_file = new WriteFiles(new File(Utilities.getAnalysisPath() 
                                                + File.separatorChar + "inputfile.in"));
            // Create file.
            try (BufferedWriter w = new BufferedWriter(outputWriter)) {
                // Start writing input file.
                w.write("&system" + "\n");
                w.write("  resolution = " 
                        + NumericalScheme.getResolution() + "d-8," + "\n");
                w.write("  temp  = " 
                        + ThermodynamicProperties.getTemperature() + "d0,\n");
                w.write("  diel = " + Solvent.getDielectric() + "d0,\n");
                w.write("  no_ions= " + Ions.getCounter() +"/\n");
                w.write("\n");
                w.write("&complexation" + "\n");
                w.write("  ph = " + PHModel.getpH() + ",\n");
                if ("NANOROD".equals(PHModel.getAnalysisType())){
                    w.write("  nsites = " + PHModel.getNtotal() + ",\n");
                    w.write("  pka = " + PHModel.getpKA() + ",\n");
                    w.write("  pkb = " + PHModel.getpKB() + ",\n");
                }else if ("CYLINDRICAL_PROTEIN".equals(PHModel.getAnalysisType())){
                    w.write("  NSITES = 0.0, \n");
                    w.write("  PKA = 0.0, \n");
                    w.write("  PKB = 0.0, \n");
                }
                w.write("  mixvalue = " + NumericalScheme.getMixing() + "/\n");
                w.write("\n");
                w.write("&model" + "\n");
                w.write("  theory = " + "'" + Utilities.getTheoryModel() + "'" + "\n");
                w.write("  analysis = " + "'" + PHModel.getAnalysisType() + "'" + "/\n");
                w.write("\n");
                for (int i = 0; i < Ions.getCounter(); i++){
                    w.write("&ion" + "\n");
                    w.write("  name = " + '"' 
                            + Ions.symbol[i] + '"' + ",\n");
                    w.write("  charge = " + Ions.valence[i] + ",\n");
                    w.write("  density = " 
                            + Ions.concentration[i] + ",\n");
                    w.write("  diameter = " 
                            + Ions.strDiameter[i] + "d-8" + "/\n");
                    w.write("\n");
                }
                w.write("&cylinder" + "\n");
                w.write("  radius = " 
                        + Solute.getRadius() + "d-8" + ",\n");
                //if surface chemistry, the initial bjerrum value = 100, means uncharge filament
                if ("NANOPARTICLE".equals(SolverModel.getModel())){
                    Solute.setCharge("100.0");
                }
                w.write("  bjerrum_length = " 
                        + Solute.getCharge() + "d-8" + "/\n");
                w.write("\n");
                w.write("&simulation" + "\n");
                w.write("  mix_value = 1d-2," + "\n");
                w.write("  tolerance = " 
                        + NumericalScheme.getTolerance() + "/\n");
                w.write("\n");
                w.write("&options" + "\n");
                w.write("  dist_dep_diel = .false.," + "\n");
                w.write("  use_roth = .true.," + "\n");
                w.write("  read_tbl = .false.," + "\n");
                w.write("  path_output = " + "'" + Utilities.getAnalysisPath() + File.separatorChar + "'" + "/\n");
                //if (".true.".equals(GlobalVariables.readTables)){
                //    w.write("  read_tbl = " + GlobalVariables.readTables + ",\n");
                //    w.write("  path = " + '"' + GlobalVariables.path + '"' + "/\n");
                //} else if (".false.".equals(GlobalVariables.readTables)){
                //    w.write("  read_tbl = " + GlobalVariables.readTables + "/\n");
                //}
            }
        } catch (IOException e) {
            Toolkit.getDefaultToolkit().beep(); 
            JOptionPane.showMessageDialog(null, ShowMessages.getWritingInput(),
                   null, JOptionPane.WARNING_MESSAGE);
        }  
    }
}