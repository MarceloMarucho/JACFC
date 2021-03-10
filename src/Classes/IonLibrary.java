/**
 *  * @author Esteban Valderrama and Marcelo Marucho
 * IonLibrary is the class for all the ion library data
 * which allows the software to save the data read from and input file.
 * This class contains the following methods:
 * <ul>
 * <li>get_selected_ion
 * </ul>
 * 
 */

package Classes;

public class IonLibrary {
        
    public static String[] name;
    public static String[] symbol;
    public static String[] valN3; 
    public static String[] valN2;
    public static String[] valN1;
    public static String[] valP1;
    public static String[] valP2;
    public static String[] valP3;
    public static String[] valP4;
    public static String[] valP5;
    public static String[] valP6;
    public static String[] valP7;
    public static String[] valP8;
    public static String[] valP9;
    public static String[][] tableData;
    private static int valPosition;
    private static int numLines;
    public static String LibraryName;
      
   /**
     * Saves the position of the selected item in the ion 
     * library combobox.
     * <p>
     * The ion library combobox contains ion elements such as Na, Mg, Cl, Ag.
     * This method iterates through the items in the combobox until the condition
     * is satisfied.
     * <p>
     * Example:
     * Li -> First item   ------ position 1
     * B  -> Second item  ------ position 2
     * Na -> Eighth item  ------ position 8
     * Cl -> Twelfth item ------ position 12
     * Local Variables:
     * <ul>
     * <li>i as Integer, loop control.
     * </ul>
     * <p>
     * Global Variables:
     * <ul>
     * <li>IonLibrary.name as String[][], array that contains the name 
     * of ions.
     * <li>IonLibrary.valPosition as Integer, position of the selected
     * ion.
     * </ul>
     * 
     * @param selectedItem Item selected in the combobox.
     * @since     January-01th-2015 
     */
    public static void get_selected_ion(Object selectedItem){
        for (int i = 0; i < IonLibrary.symbol.length; i++){
            if (selectedItem.equals(IonLibrary.symbol[i])){
                IonLibrary.setValPosition(i);
                break;
            }
        }
    }

    /**
     * @return the valPosition
     */
    public static int getValPosition() {
        return valPosition;
    }

    /**
     * @param aValPosition the valPosition to set
     */
    public static void setValPosition(int aValPosition) {
        valPosition = aValPosition;
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
     * @return the ion library filename
     */
    public static String getLibraryName() {
        return LibraryName;
    }

    /**
     * @param aLibraryName the library filename to set
     */
    public static void setLibraryName(String aLibraryName) {
        LibraryName = aLibraryName;
    }
    
}