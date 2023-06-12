package game_engine;

import processing.core.PVector;

public class PointData {
    

    private PVector Point;
    private PVector VertexTexture;
    private PVector VertexNormal;

    public PointData(PVector Point, PVector VertexTexture, PVector VertexNormal){
        this.Point = Point;
        this.VertexTexture = VertexTexture;
        this.VertexNormal = VertexNormal;
    }

    public PointData(PVector Point, PVector VertexNormal){
        this.Point = Point;
        this.VertexNormal = VertexNormal;
    }



    public PVector getPoint(){
        return this.Point;
    }
    public PVector getVertexTexture(){
        return this.VertexTexture;
    }
    public PVector getVertexNormal(){
        return this.VertexNormal;
    }




}
