/**
 * Solvent is the class for all the solvent data which allow the software to 
 * define the input file.
 * 
 * @author Esteban Valderrama and Marcelo Marucho
 */

package Classes;

public class Solvent {
    
    public static String dielectric;
    public static String valence;
    public static String concentration;
    public static String diameter;
    public static String mobility;

    /**
     * @return the dielectric
     */
    public static String getDielectric() {
        return dielectric;
    }

    /**
     * @param aDielectric the dielectric to set
     */
    public static void setDielectric(String aDielectric) {
        dielectric = aDielectric;
    }

    /**
     * @return the valence
     */
    public static String getValence() {
        return valence;
    }

    /**
     * @param aValence the valence to set
     */
    public static void setValence(String aValence) {
        valence = aValence;
    }

    /**
     * @return the concentration
     */
    public static String getConcentration() {
        return concentration;
    }

    /**
     * @param aConcentration the concentration to set
     */
    public static void setConcentration(String aConcentration) {
        concentration = aConcentration;
    }

    /**
     * @return the diameter
     */
    public static String getDiameter() {
        return diameter;
    }

    /**
     * @param aDiameter the diameter to set
     */
    public static void setDiameter(String aDiameter) {
        diameter = aDiameter;
    }
    
    /**
     * @return the diameter
     */
    public static String getMobility() {
        return mobility;
    }

    /**
     * @param aDiameter the diameter to set
     */
    public static void setMobility(String aMobility) {
        mobility = aMobility;
    }
    
}
