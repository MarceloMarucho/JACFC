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

public class WriteFilesSignal {
    
    
    File file;
    FileOutputStream outputStream;
    static OutputStreamWriter outputWriter;

    public WriteFilesSignal(File file) {
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
    
// Monomer electric circuit characterization 
    
    public static void write_sphere() {
    
        try{
            // Create file.
            WriteFilesSignal new_file = new WriteFilesSignal(new File(Utilities.getAnalysisPath() 
                                                + File.separatorChar + "inp.in"));
            //write input file
            try (BufferedWriter w = new BufferedWriter(outputWriter)) {
                // Start writing input file.
                w.write("&NUMERICAL_SCHEME" + "\n");
                w.write("  RESOLUTION = " + ThermodynamicProperties.getTemperature() + "\n");
 //               w.write("  TOLERANCE = " + NumericalScheme.getTolerance() + "\n");
 //               w.write("  MIXING_PARAMETER = " + NumericalScheme.getMixing() + "\n");
                w.write("&DEFINE_MODEL" + "\n");
                w.write("  MODEL = "  + Utilities.getTheoryModel()  + "\n");
                w.write("  USE_MULTIGRID = "  + NumericalScheme.getMultigrid()  + "\n");
                w.write("  ANALYSIS = "  + PHModel.getAnalysisType()  + "\n");
                w.write("  SOLUTE_TYPE = "  + Solute.getType()  + "\n");
                w.write("  VOLTAGEINP = " +  Solute.getRadius() + "\n");
                w.write("  SURFACE_CHARGE = " + PHModel.getNtotal() + "d-10" + "\n");
                if ("NANOPARTICLE".equals(PHModel.getAnalysisType())){
                    w.write("  NSITES = " + PHModel.getpH() + "\n");
                    w.write("  LENGTH = " + PHModel.getpKA() + "d-10" + "\n");
                    w.write("  RADIUS = " + PHModel.getpKB() + "d-10" + "\n");
                }else if ("GLOBULAR_PROTEIN".equals(PHModel.getAnalysisType())){
                    w.write("  NSITES = 0.0 \n");
                    w.write("  PKA = 0.0 \n");
                    w.write("  PKB = 0.0 \n");
                }
                w.write("&ELECTROLYTE" + "\n");
                w.write("  NUMBER_OF_IONS = " + Ions.getCounter() + "\n");
                for (int i = 0; i < Ions.getCounter(); i++){
                   // w.write("&ION" + "\n"); //
                    w.write("  NAME = "  + Ions.symbol[i]  + "\n");
                    w.write("  CHARGE = " + Ions.valence[i] + "\n");
                    w.write("  DENSITY = " + Ions.concentration[i] + "d3\n");
                    w.write("  DIAMETER = " + Ions.strDiameter[i] + "d-10" + "\n");
                    w.write("  MOBILITY = " + Ions.strMobility[i] + "d0\n");
                }
                w.write("  DIELECTRIC = " + Solvent.getDielectric() + "d0\n");
//                w.write("&DEFINE_SOLUTE" + "\n");  
                w.write("&THERMODYNAMIC_CONDITION" + "\n");
                w.write("  TEMPERATURE = " + NumericalScheme.getResolution() + "\n");
                w.write("  PH = " + NumericalScheme.getCutoff() + "\n");
                w.write("  VISCOCITY = " + NumericalScheme.getMesh() + "\n");
                w.write("  PATH_ION_CORR_FILE = " + Utilities.getAnalysisPath() + File.separatorChar + "\n");
                w.write("&CAPACITANCE" + "\n");
                w.write("  PARAMETERB = " + NumericalScheme.getTolerance() + "\n");
                w.write("  PARAMETERCO = " + NumericalScheme.getMixing() + "\n");
            }
        } catch (IOException e) {
            Toolkit.getDefaultToolkit().beep(); 
            JOptionPane.showMessageDialog(null, ShowMessages.getWritingInput(),
                   null, JOptionPane.WARNING_MESSAGE);
        }  
    }
    
//  F-actin signal characterization  
    
    public static void write_cylinder(){
        try{
           WriteFilesSignal new_file = new WriteFilesSignal(new File(Utilities.getAnalysisPath() 
                                                + File.separatorChar + "inputfile.in"));
            // Create file.
            try (BufferedWriter w = new BufferedWriter(outputWriter)) {
                // Start writing input file.
                w.write("&system" + "\n");
//                System.out.println("&system" + "\n");
                w.write("  resolution = " 
                        + NumericalScheme.getMultigrid() + "d-8," + "\n");
                w.write("  temp  = " 
                        + NumericalScheme.getResolution() + "d0,\n");
                w.write("  diel = " + Solvent.getDielectric() + "d0,\n");
                w.write("  no_ions= " + Ions.getCounter() +"/\n");
                w.write("\n");
                w.write("&complexation" + "\n");
                w.write("  ph = " + "0.0" + ",\n");
                w.write("  NSITES = 0.0, \n");
                w.write("  PKA = 0.0, \n");
                w.write("  PKB = 0.0, \n");
                w.write("  mixvalue = " + "0.35" + "/\n");
                w.write("\n");
                w.write("&model" + "\n");
                w.write("  theory = " + "'" + Utilities.getTheoryModel() + "'" + "\n");
                w.write("  analysis = " + "'" + "CYLINDRICAL_PROTEIN" + "'" + "/\n");
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
                        + PHModel.getpKB() + "d-8" + ",\n");
                //if surface chemistry, the initial bjerrum value = 100, means uncharge filament
 //               if ("NANOPARTICLE".equals(SolverModel.getModel())){
 //                   Solute.setCharge("100.0");
 //               }
                w.write("  bjerrum_length = " 
                        + Solute.getCharge() + "d-8" + "/\n");
                w.write("\n");
                w.write("&simulation" + "\n");
                w.write("  mix_value = 1d-2," + "\n");
                w.write("  tolerance = " 
                        + "0.000001" + "/\n");
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