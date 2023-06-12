package game_engine.Matrix_Vector_Manipulation;

import processing.core.PVector;

public class Matrix_Vector {
    public float[][] vecToMatrix(PVector v) {
        float[][] m = new float[3][1];
        m[0][0] = v.x;
        m[1][0] = v.y;
        m[2][0] = v.z;
        return m;
      }
      
    public PVector matrixToVec(float[][] m) {
        PVector v = new PVector();
        v.x = m[0][0];
        v.y = m[1][0];
        if (m.length > 2) {
          v.z = m[2][0];
        }
        return v;
    }
      
    public void logMatrix(float[][] m) {
        int cols = m[0].length;
        int rows = m.length;
        System.out.println(rows + "x" + cols);
        System.out.println("----------------");
        for (int i = 0; i < rows; i++) {
          for (int j = 0; j < cols; j++) {
            System.out.print(m[i][j] + " ");
          }
          System.out.println();
        }
        System.out.println();
      }
      
      
    public PVector matmul(float[][] a, PVector b) {
        float[][] m = vecToMatrix(b);
        return matrixToVec(matmul(a,m));
      }
      
    public float[][] matmul(float[][] a, float[][] b) {
        int colsA = a[0].length;
        int rowsA = a.length;
        int colsB = b[0].length;
        int rowsB = b.length;
      
        if (colsA != rowsB) {
            System.out.println("Columns of A must match rows of B");
          return null;
        }
      
        float result[][] = new float[rowsA][colsB];
      
        for (int i = 0; i < rowsA; i++) {
          for (int j = 0; j < colsB; j++) {
            float sum = 0;
            for (int k = 0; k < colsA; k++) {
              sum += a[i][k] * b[k][j];
            }
            result[i][j] = sum;
          }
        }
        return result;
      }
}
