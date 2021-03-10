/******************************************************************************
 *
 * Original Author: Esteban Valderrama
 * Description: This class contains the method to show warning/message errors.
 *
 *****************************************************************************/

package Procedures;

public class ShowMessages {

    static String openingProgress = "CSDFTS cannot be opened. Please contact software "
            + "administrator";
    static String exitProgram = "Are you sure you want to exit the program?";
    static String OpenUserManual = "User Manual not found.";
    static String noPDFSoftware = "No software installed to open pdf files.";
    static String webPDB ="RCSB PDB webpage cannot be opened.";
    static String webMarucho ="www.marucho.com.ar/marcelo/ cannot be opened.";
    static String strTextbox = "Only characters are allowed in this field.";
    //static String numTextbox = "Only numbers are allowed in this field.";
    static String missingInfo = "Missing important information.";
    static String emailSent = "Your Email has been succesfully sent. Thanks for "
            + "contacting our CSDFTS Team. We will review your email, and will "
            + "contact you.";
    static String emailNotSent = "Email cannot be sent, error in the connection with"
            + "the server.";
    static String notFile = "The file does not exist.";
    static String invalidFile = "Invalid CSDFTS file.";
    static String zeroIonValence = "The ion valence cannot be equal to "
            + "zero.";
    static String zeroIonConcentration = "The ion concentration cannot be equal to "
            + "zero or empty.";
    static String zeroIonDiameter = "The ion diameter cannot be equal to zero.";
    static String electroneutralityNotSatisfied = "Electroneutrality condition "
            + "is not satisfied. Please select the ion data again.";
    static String zeroRadius = "The solute radius cannot be equal to zero.";
    static String zeroResolution = "The numerical resolution cannot be equal to zero.";
    static String zeroTolerance = "The numerical tolerance cannot be equal to zero.";
    static String zeroMixing = "The mixing parameter cannot be equal to zero.";
    static String usePH = "To use pH approach in Proteins a PDB file is needed. "
            + "Do you want to upload a PDB file?\n"
            + "NOTE: To download PDB files go to: Tools > Browse PDB Files, "
            + "in the main menu.";
    static String NotUsePH = "pH approach in Proteins cannot be used.";
    static String pHRange = "pH value should be between 1.0 and 14.0.";
    static String validPQR = "The PDB file has been succesfully converted into "
            + "PQR file.\n The PQR file is located at: ";
    static String invalidPQR = "PDB file cannot be converted to PQR file.";
    static String notJmol = "Jmol software cannot be opened.";
    static String zeroSolventDiameter = "The solvent diameter cannot be equal to zero.";
    static String zeroSolventConcentration = "The solvent concentration cannot be equal to "
            + "zero.";
    static String writingInput = "Problem writing the inputfile.";
    static String savingFile = "Problem saving the library file.";
    static String librarySuccess = "Library file has been successfuly updated.";
    static String addPH = "Sorry. The value should be in the range [4.0 ≤ pH ≤ 10.0].The pH value is set equal to 7.0";

    public static String getOpeningProgress() {
        return openingProgress;
    }

    public static String getExitProgram() {
        return exitProgram;
    }

    public static String getOpenUserManual() {
        return OpenUserManual;
    }

    public static String getNoPDFSoftware() {
        return noPDFSoftware;
    }

    public static String getWebPDB() {
        return webPDB;
    }
    
    public static String getWebMarucho() {
        return webMarucho;
    }

    public static String getStrTextbox() {
        return strTextbox;
    }

//    public static String getNumTextbox() {
//        return numTextbox;
//    }

    public static String getMissingInfo() {
        return missingInfo;
    }

    public static String getEmailSent() {
        return emailSent;
    }

    public static String getEmailNotSent() {
        return emailNotSent;
    }

    public static String getNotFile() {
        return notFile;
    }

    public static String getInvalidFile() {
        return invalidFile;
    }

    public static String getZeroIonValence() {
        return zeroIonValence;
    }
        
    public static String getZeroIonConcentration() {
        return zeroIonConcentration;
    }
    
    public static String getZeroIonDiameter() {
        return zeroIonDiameter;
    }

    public static String getElectroneutralityNotSatisfied() {
        return electroneutralityNotSatisfied;
    }

    public static String getZeroRadius() {
        return zeroRadius;
    }

    public static String getZeroResolution() {
        return zeroResolution;
    }

    public static String getZeroTolerance() {
        return zeroTolerance;
    }

    public static String getZeroMixing() {
        return zeroMixing;
    }

    public static String getUsePH() {
        return usePH;
    }

    public static String getNotUsePH() {
        return NotUsePH;
    }

    public static String getValidPQR() {
        return validPQR;
    }

    public static String getInvalidPQR() {
        return invalidPQR;
    }

    public static String getNotJmol() {
        return notJmol;
    }

    public static String getZeroSolventDiameter() {
        return zeroSolventDiameter;
    }

    public static String getZeroSolventConcentration() {
        return zeroSolventConcentration;
    }

    public static String getWritingInput() {
        return writingInput;
    }

    public static String getSavingFile() {
        return savingFile;
    }

    public static String getLibrarySuccess() {
        return librarySuccess;
    }

    public static String getpHRange() {
        return pHRange;
    }
    
    public static String getaddPH() {
        return addPH;
    }

}