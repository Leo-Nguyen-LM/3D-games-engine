package game_engine.Matrix_Vector_Manipulation;

public class transposition {
    
    float[][] MatrixA;
    float[] VectorA;

    public void SetMatrix(float[][] MatrixA){
        this.MatrixA = MatrixA;
    }
    public void SetVector(float[] VectorA){
        this.VectorA = VectorA;
    }

    
    public float[][] transposeMatrix(){
        float temp;
        for(int i=0 ; i<(this.MatrixA.length/2 + 1); i++)
        {
            for(int j=i ; j<(this.MatrixA[0].length) ; j++)
            {
                temp = this.MatrixA[i][j];
                this.MatrixA[i][j] = this.MatrixA[j][i];
                this.MatrixA[j][i] = temp;
            }
        }
        return MatrixA;
    }


}
