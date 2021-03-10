/**
 * Results is the class for all the output data which allow the software to 
 * make plots and generate tables.
 * 
 * @author Esteban Valderrama and Marcelo Marucho
 */

package Classes;

public class Results {
  
    public static boolean openingOutput = false;
    public static int numLines;
    public static int numCols;
    public static String[][] strDensityProfile;
    public static double[][] densityProfile;
    public static String[][] strIntegratedCharge;
    public static double[][] integratedCharge;
    public static String[][] strElectrostaticPotential;
    public static double[][] electrostaticPotential;
    public static String[][] strC1hs;
    public static double[][] c1hs;
    public static String[][] strC1el;
    public static double[][] c1el;
    public static String[][] strIonContributions;
    public static double[][] ionContributions;
    public static String[][] strPressure;
    public static double[][] pressure;
    public static String[][] strPH;
    public static double[][] ph;
    public static String[][] reader;

    /**
     * @return the openingOutput
     */
    public static boolean isOpeningOutput() {
        return openingOutput;
    }

    /**
     * @param aOpeningOutput the openingOutput to set
     */
    public static void setOpeningOutput(boolean aOpeningOutput) {
        openingOutput = aOpeningOutput;
    }

    /**
     * @return the numLines
     */
    public static int getNumLines() {
        return numLines;
    }

    /**
     * @param aNumLines the numLines to set
     */
    public static void setNumLines(int aNumLines) {
        numLines = aNumLines;
    }

    /**
     * @return the numCols
     */
    public static int getNumCols() {
        return numCols;
    }

    /**
     * @param aNumCols the numCols to set
     */
    public static void setNumCols(int aNumCols) {
        numCols = aNumCols;
    }
  
}