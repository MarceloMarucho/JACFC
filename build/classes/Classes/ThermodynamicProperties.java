/**
 * ThermodynamicProperties is the class for all the thermodynamic data which 
 * allow the software to define the input file.
 * 
 * @author Esteban Valderrama and Marcelo Marucho
 */

package Classes;

public class ThermodynamicProperties {
    
    public static String temperature;

    /**
     * @return the temperature
     */
    public static String getTemperature() {
        return temperature;
    }

    /**
     * @param aTemperature the temperature to set
     */
    public static void setTemperature(String aTemperature) {
        temperature = aTemperature;
    }
    
}