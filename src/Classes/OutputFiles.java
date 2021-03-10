/**
 * OutputFiles class contains the definition of the output files variables.
 * 
 @author Esteban Valderrama and Marcelo Marucho
 */

package Classes;

public class OutputFiles {
    
    public static boolean densityOutput;
    public static boolean electrostaticOutput;
    public static boolean pressureOutput;
    public static boolean pHOutput;
    public static boolean integratedOutput;
    public static boolean contributionsOutput;

    /**
     * @return the densityOutput
     */
    public static boolean isDensityOutput() {
        return densityOutput;
    }

    /**
     * @param aDensityOutput the densityOutput to set
     */
    public static void setDensityOutput(boolean aDensityOutput) {
        densityOutput = aDensityOutput;
    }

    /**
     * @return the electrostaticOutput
     */
    public static boolean isElectrostaticOutput() {
        return electrostaticOutput;
    }

    /**
     * @param aElectrostaticOutput the electrostaticOutput to set
     */
    public static void setElectrostaticOutput(boolean aElectrostaticOutput) {
        electrostaticOutput = aElectrostaticOutput;
    }

    /**
     * @return the pressureOutput
     */
    public static boolean isPressureOutput() {
        return pressureOutput;
    }

    /**
     * @param aPressureOutput the pressureOutput to set
     */
    public static void setPressureOutput(boolean aPressureOutput) {
        pressureOutput = aPressureOutput;
    }

    /**
     * @return the pHOutput
     */
    public static boolean ispHOutput() {
        return pHOutput;
    }

    /**
     * @param apHOutput the pHOutput to set
     */
    public static void setpHOutput(boolean apHOutput) {
        pHOutput = apHOutput;
    }

    /**
     * @return the integratedOutput
     */
    public static boolean isIntegratedOutput() {
        return integratedOutput;
    }

    /**
     * @param aIntegratedOutput the integratedOutput to set
     */
    public static void setIntegratedOutput(boolean aIntegratedOutput) {
        integratedOutput = aIntegratedOutput;
    }

    /**
     * @return the contributionsOutput
     */
    public static boolean isContributionsOutput() {
        return contributionsOutput;
    }

    /**
     * @param aContributionsOutput the contributionsOutput to set
     */
    public static void setContributionsOutput(boolean aContributionsOutput) {
        contributionsOutput = aContributionsOutput;
    }

}
