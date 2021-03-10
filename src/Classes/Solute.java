/**
 * Solute is the class for all the solute data which allow the software to 
 * define the input file.
 * 
 * @author Esteban Valderrama and Marcelo Marucho
 */

package Classes;

public class Solute {
    
    public static String type;
    public static String radius;
    public static String charge;

    /**
     * @return the type
     */
    public static String getType() {
        return type;
    }

    /**
     * @param aType the type to set
     */
    public static void setType(String aType) {
        type = aType;
    }

    /**
     * @return the radius
     */
    public static String getRadius() {
        return radius;
    }

    /**
     * @param aRadius the radius to set
     */
    public static void setRadius(String aRadius) {
        radius = aRadius;
    }

    /**
     * @return the charge
     */
    public static String getCharge() {
        return charge;
    }

    /**
     * @param aCharge the charge to set
     */
    public static void setCharge(String aCharge) {
        charge = aCharge;
    }

}
