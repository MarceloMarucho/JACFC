/******************************************************************************
 *
 * Original Author: Esteban Valderrama
 * Description: This class contains the methods to validate the operating 
 *              system.
 *
 *****************************************************************************/

package Procedures;

import Classes.Utilities;
import javax.swing.JOptionPane;

public class ValidateOS {

/******************************************************************************
 *
 * Procedure Name: ValidateOS
 * Original Author: Esteban Valderrama
 * Description: This method implements if-statements to check for a valid operating system.
 * 
 * Calling Arguments:
 *     Name         -> N/A
 *     Input/Output -> N/A
 *     Type         -> N/A
 *     Description  -> N/A
 * 
 * Return Value:
 *     Name         -> N/A        
 *     Type         -> N/A
 *     Description  -> N/A
 *
 * Local Variables:
 *     Name         -> OS
 *     Type         -> String
 *     Description  -> Contains the name of the operating system in string.
 * 
 * Global Variables:
 *     Name         -> OS
 *     Type         -> String
 *     Origin       -> Utilities
     Description  -> Contains the operating system name.
 * 
 *     Name         -> platform
 *     Type         -> String
 *     Origin       -> Utilities
     Description  -> Contains the operating system information.
 * 
 * Modification History:
 *     Date         ->     
 *     Developer    ->
 *     Description  ->
 * 
 *****************************************************************************/
    public static void OSValidator(){
        
        String OS = System.getProperty("os.name").toLowerCase();
        Utilities.setPlatform(OS);
        if (is_windows()) {
            Utilities.setOS("windows");
	} else if (is_mac()) {
	    Utilities.setOS("mac");
	} else if (is_unix()) {
	    Utilities.setOS("linux");
	} else if (is_solaris()) {
	    Utilities.setOS("linux");
	} else {
            JOptionPane.showMessageDialog(null, "Your OS is not supported for "
                    + "CSDFTS, please contact the development team at "
                    + "csdfts.comphys@gmail.com.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
	}
    }
    
/******************************************************************************
 *
 * Procedure Name: is_windows
 * Original Author: Esteban Valderrama
 * Description: This constructor returns TRUE if the operating system is 
 *              windows.
 * 
 * Calling Arguments:
 *     Name         -> N/A
 *     Input/Output -> N/A
 *     Type         -> N/A
 *     Description  -> N/A
 * 
 * Return Value:
 *     Name         -> -         
 *     Type         -> Boolean
 *     Description  -> It is TRUE if the OS is windows, otherwise FALSE.
 *
 * Local Variables:
 *     Name         -> N/A
 *     Type         -> N/A
 *     Description  -> N/A
 * 
 * Global Variables:
 *     Name         -> platform
 *     Type         -> String
 *     Origin       -> Utilities
     Description  -> Contains the operating system information.
 * 
 * Modification History:
 *     Date         ->     
 *     Developer    ->
 *     Description  ->
 * 
     * @return 
 *****************************************************************************/
    public static boolean is_windows() {
        return (Utilities.getPlatform().contains("win"));
    }

/******************************************************************************
 *
 * Procedure Name: is_mac
 * Original Author: Esteban Valderrama
 * Description: This constructor returns TRUE if the operating system is 
 *              macintosh.
 * 
 * Calling Arguments:
 *     Name         -> N/A
 *     Input/Output -> N/A
 *     Type         -> N/A
 *     Description  -> N/A
 * 
 * Return Value:
 *     Name         -> -         
 *     Type         -> Boolean
 *     Description  -> It is TRUE if the OS is macintosh, otherwise FALSE.
 *
 * Local Variables:
 *     Name         -> N/A
 *     Type         -> N/A
 *     Description  -> N/A
 * 
 * Global Variables:
 *     Name         -> platform
 *     Type         -> String
 *     Origin       -> Utilities
     Description  -> Contains the operating system information.
 * 
 * Modification History:
 *     Date         ->     
 *     Developer    ->
 *     Description  ->
 * 
     * @return 
 *****************************************************************************/
    public static boolean is_mac() {
        return (Utilities.getPlatform().contains("mac"));
    }
 
/******************************************************************************
 *
 * Procedure Name: is_unix
 * Original Author: Esteban Valderrama
 * Description: This constructor returns TRUE if the operating system is 
 *              unix.
 * 
 * Calling Arguments:
 *     Name         -> N/A
 *     Input/Output -> N/A
 *     Type         -> N/A
 *     Description  -> N/A
 * 
 * Return Value:
 *     Name         -> -         
 *     Type         -> Boolean
 *     Description  -> It is TRUE if the OS is unix, otherwise FALSE.
 *
 * Local Variables:
 *     Name         -> N/A
 *     Type         -> N/A
 *     Description  -> N/A
 * 
 * Global Variables:
 *     Name         -> platform
 *     Type         -> String
 *     Origin       -> Utilities
     Description  -> Contains the operating system information.
 * 
 * Modification History:
 *     Date         ->     
 *     Developer    ->
 *     Description  ->
 * 
     * @return 
 *****************************************************************************/
    public static boolean is_unix() {
        return (Utilities.getPlatform().contains("nix") 
                || Utilities.getPlatform().contains("nux") 
                || Utilities.getPlatform().indexOf("aix") > 0 );
    }
   
/******************************************************************************
 *
 * Procedure Name: is_unix
 * Original Author: Esteban Valderrama
 * Description: This constructor returns TRUE if the operating system is 
 *              solaris.
 * 
 * Calling Arguments:
 *     Name         -> N/A
 *     Input/Output -> N/A
 *     Type         -> N/A
 *     Description  -> N/A
 * 
 * Return Value:
 *     Name         -> -         
 *     Type         -> Boolean
 *     Description  -> It is TRUE if the OS is solaris, otherwise FALSE.
 *
 * Local Variables:
 *     Name         -> N/A
 *     Type         -> N/A
 *     Description  -> N/A
 * 
 * Global Variables:
 *     Name         -> platform
 *     Type         -> String
 *     Origin       -> Utilities
     Description  -> Contains the operating system information.
 * 
 * Modification History:
 *     Date         ->     
 *     Developer    ->
 *     Description  ->
 * 
     * @return 
 *****************************************************************************/
    public static boolean is_solaris() {
        return (Utilities.getPlatform().contains("linux"));
    }
}
