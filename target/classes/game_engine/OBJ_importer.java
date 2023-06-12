package game_engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import processing.core.PVector;

/*
 *         List<float[]> list = new ArrayList<float[]>();
        float[] array1 = { 15, 20, 40 };
        list.add(array1);
        for (float[] tables : list)
        System.out.println(Arrays.toString(tables));
 */

public class OBJ_importer{
    private List<PVector> Normals = new ArrayList<PVector>();
    private List<PVector> points = new ArrayList<PVector>();
    List<String[]> Faces = new ArrayList<String[]>();
    float[][] Connections;
    
    public List<PVector> GetPoints(){
        return this.points;
    }

    public List<PVector> GetNormals(){
        return this.Normals;
    }

    public static float strToFloat(String str) {
        return Float.valueOf(str);
    }

    public void fileConversion(){
        File file = new File("src/main/resources/cube.obj");
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] result = data.split(" ");
                if (result.length == 0){
                    continue;
                }
                else if (result[0].equals("v")){
                    System.out.println(result[1] +" "+ result[2]+ " "+result[3]);
                    PVector point = new PVector((1+strToFloat(result[1]))*100, (1+strToFloat(result[2]))*100, (1+strToFloat(result[3]))*100);
                    this.points.add(point);
                }
                //else if (result[0].equals("vn")){
                                                                    //reflective purpose for faces
               // }
                else if (result[0].equals("f")){
                    System.out.println(result[1] +" "+ result[2]+ " "+result[3]);
                    String[] TriangleFace = {result[1], result[2], result[3]};
                    this.Faces.add(TriangleFace);
                    continue;
                }
                else if (result[0].equals("vt")){

                }
                else if (result[0].equals("vn")){
                    PVector normal = new PVector(strToFloat(result[1]), strToFloat(result[2]), strToFloat(result[3]));
                    this.Normals.add(normal);
                }
                else{
                    continue;
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}