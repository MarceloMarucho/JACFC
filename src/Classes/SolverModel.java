/**
 * SolverModel is the class for all the solver related data
 * which allow the software to save the data read from and input file.
 * This class contains the following methods:
 * <ul>
 * <li>
 * </ul>
 * 
 * @author Esteban Valderrama and Marcelo Marucho
 */
package Classes;


public class SolverModel {
    
    public static String Model;
    
     /**
     * @return the valPosition
     */
    public static String getModel() {
        return Model;
    }
    
    /**
     * @param aModel the Model to set
     */
    public static void setModel(String aModel) {
        Model = aModel;
    }    
}
