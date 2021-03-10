/**
 * @author Esteban Valderrama and Marcelo Marucho
 * Ions is the class for all the ions data which allow the software to 
 * define the input file.
 * This class contains the following methods:
 * <ul>
 * <li>get_electroneutrality
 * </ul>
 * 
 */

package Classes;

public class Ions {

    public static int counter;
    public static String[] symbol = null;
    public static String[] valence;
    public static String[] concentration;
    public static double diameter;
    public static double mobility;
    public static String[] strDiameter;
    public static double neutrality;
    public static double tempNeutrality;
    public static String[] strMobility;

   /**
     * Calculates the electroneutrality in the electrolyte solution.
     * <p>
     * The electroneutrality is the tendency to keep any system electrically 
     * neutral, that is, if it contains electrically charged particles the total 
     * sum of negative charges will be equal to the total sum of positive 
     * charges. 
     * <p>
     * Applying this condition to a solution of electrolytes implies the equality 
     * of the total positive ionic charges to the total negative ionic charges. 
     * This equality should hold even as we subdivide the solution into smaller 
     * and smaller volume elements.
     * <p>
     * Global Variables:
     * <ul>
     * <li>Ions.tempNeutrality as String, temporal variable to accumulate the 
     * value of the electroneutrality.
     * <li>Ions.valence as String[], valence of the ions.
     * <li>Ions.counter as String[], number of ions in the analysis.
     * <li>Ions.concentration as String[], concentration of the ions.
     * </ul>
     *
     * @param prev previous value of electroneutrality.
     * @param z valence for ion 1.
     * @param rho concentration for ion 1.
     * @return Ions.getNeutrality()
     * @since     January-01th-2015 
     */
    public static double get_electroneutrality(double prev, double z, double rho){
        double temp;
        Ions.setNeutrality(0.0);
        
        temp = prev + (z*rho);
        if ((temp*temp) <= 1.0e-20){
            temp = 0.0;
        }
        Ions.setNeutrality(temp);
        
        return Ions.getNeutrality();
    } 

    /**
     * @return the counter
     */
    public static int getCounter() {
        return counter;
    }

    /**
     * @param aCounter the counter to set
     */
    public static void setCounter(int aCounter) {
        counter = aCounter;
    }

    /**
     * @return the diameter
     */
    public static double getDiameter() {
        return diameter;
    }

    /**
     * @param aDiameter the diameter to set
     */
    public static void setDiameter(double aDiameter) {
        diameter = aDiameter;
    }

     public static double getMobility() {
        return mobility;
    }

    /**
     * @param aDiameter the diameter to set
     */
    public static void setMobility(double aMobility) {
        mobility = aMobility;
    }
    /**
     * @return the neutrality
     */
    public static double getNeutrality() {
        return neutrality;
    }

    /**
     * @param aNeutrality the neutrality to set
     */
    public static void setNeutrality(double aNeutrality) {
        neutrality = aNeutrality;
    }
}