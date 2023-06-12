package game_engine;

import java.util.List;

import processing.core.PVector;

public class FaceToLine {


    public List<String[]> faces;
    public List<PVector> points; 
    public List<PointData> PointData;
    public List<PVector> Normal; 

    public FaceToLine(){
        OBJ_importer importer = new OBJ_importer();
        this.faces = importer.Faces;
        this.points = importer.GetPoints();
        this.Normal = importer.GetNormals();


        for (int i=0; i < faces.size(); i++){

            String[] CurrentFace = faces.get(i);
            String Point1 = CurrentFace[1];
            String Point2 = CurrentFace[2];
            String Point3 = CurrentFace[3];

            String[] PointData1 = Point1.split("/");
            String[] PointData2 = Point2.split("/");
            String[] PointData3 = Point3.split("/");


            int PointCoord = Integer.valueOf(PointData1[0]);
            PVector LocationPoint = points.get(PointCoord);

            if (PointData1.length > 2){
            }

            int NormalLocation = Integer.valueOf(PointData1[1]);
            PVector NormalValue = Normal.get(NormalLocation);
            PointData PointData = new PointData(LocationPoint, NormalValue);
            
        }
    }

    public void PointRender(){
        
    }



}


