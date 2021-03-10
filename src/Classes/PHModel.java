/**
 * PHModelDefinition is the class for all the pH data definition which allow the
 * software to use pH Model.
 * This class contains the following methods:
 * <ul>
 * <li>get_force_field
 * </ul>
 * 
 * @author Esteban Valderrama and Marcelo Marucho
 */

package Classes;

public class PHModel {

    public static String analysisType;
    public static String pKA;
    public static String pKB;
    public static String ntotal;
    public static String ntotal_Units;
    public static String path;
    public static String pathPDB;
    public static String pathPDB2PQR;
    public static String forceField;
    public static String pH;
    public static String usepH;
    public static String pathPQR;
    public static String pathXYZR;
    public static String pathPDB2XYZR;
    public static String usertime;
    public static String[] coordX;
    public static String[] coordY;
    public static String[] coordZ;
    public double xc;
    public double yc;
    public double zc;

    /**
     * Saves the value of the force field.
     * <p>
     * 
     * <p>
     * Global Variables:
     * <ul>
     * <li>PHModel.forceField as String, Contains the selected force 
     * field.
     * </ul>
     * 
     * @param item selected forcefield.
     * @since     January-01th-2015 
     */
     
    public static void get_force_field(String item){
        if(null != item)switch (item) {
            case "AMBER":
                PHModel.setForceField("amber");
                break;
            case "PARSE":
                PHModel.setForceField("parse");
                break;
            case "SWANSON":
                PHModel.setForceField("swanson");
                break;
            case "CHARMM":
                PHModel.setForceField("charmm");
                break;
            case "PEOEPB":
                PHModel.setForceField("peoepb");
                break;
            case "TYL06":
                PHModel.setForceField("tyl06");
                break;
        }
    }
/**
     * @return the analysisType
     */
    public static String getUserTime() {
        return usertime;
    }

    /**
     * @param aAnalysisType the analysisType to set
     */
    public static void setUserTime(String aUserTime) {
        usertime = aUserTime;
    }
    /**
     * @return the analysisType
     */
    public static String getAnalysisType() {
        return analysisType;
    }

    /**
     * @param aAnalysisType the analysisType to set
     */
    public static void setAnalysisType(String aAnalysisType) {
        analysisType = aAnalysisType;
    }

    /**
     * @return the pKA
     */
    public static String getpKA() {
        return pKA;
    }

    /**
     * @param apKA the pKA to set
     */
    public static void setpKA(String apKA) {
        pKA = apKA;
    }

    /**
     * @return the pKB
     */
    public static String getpKB() {
        return pKB;
    }

    /**
     * @param apKB the pKB to set
     */
    public static void setpKB(String apKB) {
        pKB = apKB;
    }

    /**
     * @return the ntotal
     */
    public static String getNtotal() {
        return ntotal;
    }

    /**
     * @param aNtotal the ntotal to set
     */
    public static void setNtotal(String aNtotal) {
        ntotal = aNtotal;
    }

    /**
     * @return the ntotal_Units
     */
    public static String getNtotal_Units() {
        return ntotal_Units;
    }

    /**
     * @param aNtotal_Units the ntotal_Units to set
     */
    public static void setNtotal_Units(String aNtotal_Units) {
        ntotal_Units = aNtotal_Units;
    }

    /**
     * @return the path
     */
    public static String getPath() {
        return path;
    }

    /**
     * @param aPath the path to set
     */
    public static void setPath(String aPath) {
        path = aPath;
    }

    /**
     * @return the pathPDB
     */
    public static String getPathPDB() {
        return pathPDB;
    }

    /**
     * @param aPathPDB the pathPDB to set
     */
    public static void setPathPDB(String aPathPDB) {
        pathPDB = aPathPDB;
    }

    /**
     * @return the pathPDB2PQR
     */
    public static String getPathPDB2PQR() {
        return pathPDB2PQR;
    }

    /**
     * @param aPathPDB2PQR the pathPDB2PQR to set
     */
    public static void setPathPDB2PQR(String aPathPDB2PQR) {
        pathPDB2PQR = aPathPDB2PQR;
    }

    /**
     * @return the forceField
     */
    public static String getForceField() {
        return forceField;
    }

    /**
     * @param aForceField the forceField to set
     */
    public static void setForceField(String aForceField) {
        forceField = aForceField;
    }

    /**
     * @return the pH
     */
    public static String getpH() {
        return pH;
    }

    /**
     * @param apH the pH to set
     */
    public static void setpH(String apH) {
        pH = apH;
    }
    
        /**
     * @return the usepH
     */
    public static String getusepH() {
        return usepH;
    }

    /**
     * @param ausepH the usepH to set
     */
    public static void setusepH(String ausepH) {
        usepH = ausepH;
    }

    /**
     * @return the pathPQR
     */
    public static String getPathPQR() {
        return pathPQR;
    }

    /**
     * @param aPathPQR the pathPQR to set
     */
    public static void setPathPQR(String aPathPQR) {
        pathPQR = aPathPQR;
    }

    /**
     * @return the pathPDB
     */
    public static String getPathXYZR() {
        return pathXYZR;
    }

    /**
     * @param aPathXYZR the pathPDB to set
     */
    public static void setPathXYZR(String aPathXYZR) {
        pathXYZR = aPathXYZR;
    }

    /**
     * @return the pathPDB2PQR
     */
    public static String getPathPDB2XYZR() {
        return pathPDB2XYZR;
    }

    /**
     * @param aPathPDB2XYZR the pathPDB2PQR to set
     */
    public static void setPathPDB2XYZR(String aPathPDB2XYZR) {
        pathPDB2XYZR = aPathPDB2XYZR;
    }
 
    /**
     * @return the xc
     */
    public double getXc() {
        return xc;
    }

    /**
     * @param xc the xc to set
     */
    public void setXc(double xc) {
        this.xc = xc;
    }

    /**
     * @return the yc
     */
    public double getYc() {
        return yc;
    }

    /**
     * @param yc the yc to set
     */
    public void setYc(double yc) {
        this.yc = yc;
    }

    /**
     * @return the zc
     */
    public double getZc() {
        return zc;
    }

    /**
     * @param zc the zc to set
     */
    public void setZc(double zc) {
        this.zc = zc;
    }
}