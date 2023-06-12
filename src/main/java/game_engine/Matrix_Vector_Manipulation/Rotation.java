package game_engine.Matrix_Vector_Manipulation;

public class Rotation{

    /**
     * @author Leo Nguyen
     * 
     * All 3 Rotation matrixes for 3D.
     **/
    public Rotation(){
    }

    /**
     * Rotation matrix (3x3) through the X axis.
     * @param angle required to rotate by some angle.
     * @return the resulting matrix
     **/
    public float[][] rotationX(double angle){
        float sinX = (float)Math.sin(angle);
        float cosX = (float)Math.cos(angle);

        float[][] rotationX = {{1,0,0},{0,cosX,-sinX},{0,sinX,cosX}};
        return rotationX;
    }

    /**
     * Rotation matrix (3x3) through the Y axis.
     * @param angle required to rotate by some angle.
     * @return the resulting matrix
     **/
    public float[][] rotationY(double angle){
        float sinX = (float)Math.sin(angle);
        float cosX = (float)Math.cos(angle);

        float[][] rotationY = {{cosX,0,-sinX}, {0,1,0}, {sinX,0,cosX}};
        return rotationY;
    }
    
    /**
     * Rotation matrix (3x3) through the X axis.
     * @param angle required to rotate by some angle.
     * @return the resulting matrix
     **/
    public float[][] rotationZ(double angle){
        float sinX = (float)Math.sin(angle);
        float cosX = (float)Math.cos(angle);

        float[][] rotationZ = {{cosX,-sinX,0}, {sinX,cosX,0}, {0,0,1}};
        return rotationZ;
    }

}