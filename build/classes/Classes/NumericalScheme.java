/**
 *  @author Esteban Valderrama and Marcelo Marucho
 * NumericalSchemeDefinition class contains the definition of the numerical 
 * scheme variables.
 * 
 */
package Classes;

public class NumericalScheme {

    public static String resolution;
    public static String tolerance;
    public static String cutoff;
    public static String mesh;
    public static String multigrid;
    public static String mixing;

    /**
     * @return the resolution
     */
    public static String getResolution() {
        return resolution;
    }

    /**
     * @param aResolution the resolution to set
     */
    public static void setResolution(String aResolution) {
        resolution = aResolution;
    }

    /**
     * @return the tolerance
     */
    public static String getTolerance() {
        return tolerance;
    }

    /**
     * @param aTolerance the tolerance to set
     */
    public static void setTolerance(String aTolerance) {
        tolerance = aTolerance;
    }

    /**
     * @return the cutoff
     */
    public static String getCutoff() {
        return cutoff;
    }

    /**
     * @param aCutoff the cutoff to set
     */
    public static void setCutoff(String aCutoff) {
        cutoff = aCutoff;
    }

    /**
     * @return the mesh
     */
    public static String getMesh() {
        return mesh;
    }

    /**
     * @param aMesh the mesh to set
     */
    public static void setMesh(String aMesh) {
        mesh = aMesh;
    }

    /**
     * @return the multigrid
     */
    public static String getMultigrid() {
        return multigrid;
    }

    /**
     * @param aMultigrid the multigrid to set
     */
    public static void setMultigrid(String aMultigrid) {
        multigrid = aMultigrid;
    }

    /**
     * @return the mixing
     */
    public static String getMixing() {
        return mixing;
    }

    /**
     * @param aMixing the mixing to set
     */
    public static void setMixing(String aMixing) {
        mixing = aMixing;
    }
    
}