/**
 * Utilities is the class for all the variables used as decision making. 
 * Contains variables such as platform and OS for the operating system, emailSent
 * to check if the email has been sent successfully, etc.
 * 
 * @author Esteban Valderrama and Marcelo Marucho
 */

package Classes;

public class Utilities {
    
    public static String platform;
    public static String OS;
    public static Boolean emailSent;
    public static String attachment;
    public static String analysisPath;
    public static String theoryModel;

    /**
     * @return the platform
     */
    public static String getPlatform() {
        return platform;
    }

    /**
     * @param aPlatform the platform to set
     */
    public static void setPlatform(String aPlatform) {
        platform = aPlatform;
    }

    /**
     * @return the OS
     */
    public static String getOS() {
        return OS;
    }

    /**
     * @param aOS the OS to set
     */
    public static void setOS(String aOS) {
        OS = aOS;
    }

    /**
     * @return the emailSent
     */
    public static Boolean getEmailSent() {
        return emailSent;
    }

    /**
     * @param aEmailSent the emailSent to set
     */
    public static void setEmailSent(Boolean aEmailSent) {
        emailSent = aEmailSent;
    }

    /**
     * @return the attachment
     */
    public static String getAttachment() {
        return attachment;
    }

    /**
     * @param aAttachment the attachment to set
     */
    public static void setAttachment(String aAttachment) {
        attachment = aAttachment;
    }

    /**
     * @return the analysisPath
     */
    public static String getAnalysisPath() {
        return analysisPath;
    }

    /**
     * @param aAnalysisPath the analysisPath to set
     */
    public static void setAnalysisPath(String aAnalysisPath) {
        analysisPath = aAnalysisPath;
    }

    /**
     * @return the theoryModel
     */
    public static String getTheoryModel() {
        return theoryModel;
    }

    /**
     * @param aTheoryModel the theoryModel to set
     */
    public static void setTheoryModel(String aTheoryModel) {
        theoryModel = aTheoryModel;
    }
}
