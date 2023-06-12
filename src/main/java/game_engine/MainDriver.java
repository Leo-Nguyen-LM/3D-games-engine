package game_engine;

import processing.core.PApplet;
import processing.core.PVector;


import game_engine.Matrix_Vector_Manipulation.*;
/* 
public class MainDriver extends PApplet{
    float[][] projectionMatrix = {{1,0,0},{0,1,0}};
    double angle = 0;
    public void settings(){
        size(1000, 1000);
    }

    public void draw(){
        background(0);
        translate(width/2, height/2);
        stroke(255);
        strokeWeight(16);
        noFill();
        OBJ_importer cube = new OBJ_importer();
        cube.fileConversion();
        Rotation Rotation = new Rotation();
        for (int i = 0; i < cube.GetPoints().size(); i++ ){
            PVector rotated = matmul(Rotation.rotationY(angle), cube.GetPoints().get(i));
            rotated = matmul(rotationX, rotated);
            rotated = matmul(rotationZ, rotated);
        }
        angle +=0.01;

    }

    public void mousePressed(){
        background(64);
    }

    public static void main(String[] args){
        String[] processingArgs = {"MySketch"};
        MainDriver mySketch = new MainDriver();
        PApplet.runSketch(processingArgs, mySketch);

        // call whatever Java code you want
    }
}
*/


public class MainDriver extends PApplet{
float angle = 0;

PVector[] points = new PVector[8];

public void settings(){
    size(1000, 1000);
}
public void setup() {

  points[0] = new PVector((float)-0.5, (float)-0.5,(float) -0.5);
  points[1] = new PVector((float)0.5, (float)-0.5, (float)-0.5);
  points[2] = new PVector((float)0.5, (float)0.5, (float)-0.5);
  points[3] = new PVector((float)-0.5, (float)0.5, (float)-0.5);
  points[4] = new PVector((float)-0.5, (float)-0.5,(float) 0.5);
  points[5] = new PVector((float)0.5, (float)-0.5,(float) 0.5);
  points[6] = new PVector((float)0.5, (float)0.5,(float) 0.5);
  points[7] = new PVector((float)-0.5,(float) 0.5,(float) 0.5);
}

public void draw() {
  background(0);
  translate(width/2, height/2);


  float[][] rotationZ = {
    { cos(angle), -sin(angle), 0},
    { sin(angle), cos(angle), 0},
    { 0, 0, 1}
  };

  float[][] rotationX = {
    { 1, 0, 0},
    { 0, cos(angle), -sin(angle)},
    { 0, sin(angle), cos(angle)}
  };

  float[][] rotationY = {
    { cos(angle), 0, sin(angle)},
    { 0, 1, 0},
    { -sin(angle), 0, cos(angle)}
  };

  PVector[] projected = new PVector[8];

  int index = 0;
  for (PVector v : points) {
    Matrix_Vector Calculations = new Matrix_Vector();
    PVector rotated = Calculations.matmul(rotationY, v);
    rotated = Calculations.matmul(rotationX, rotated);
    rotated = Calculations.matmul(rotationZ, rotated);

    float distance = 2;
    float z = 1 / (distance - rotated.z);
    float[][] projection = {
      {z, 0, 0},
      {0, z, 0}
    };

    PVector projected2d = Calculations.matmul(projection, rotated);
    projected2d.mult(200);
    projected[index] = projected2d;
    //point(projected2d.x, projected2d.y);
    index++;
  }

  for (PVector v : projected) {
    stroke(255);
    strokeWeight(16);
    noFill();
    point(v.x, v.y);
  }

  // Connecting
  for (int i = 0; i < 4; i++) {
    connect(i, (i+1) % 4, projected);
    connect(i+4, ((i+1) % 4)+4, projected);
    connect(i, i+4, projected);
  }

  angle += 0.01;
}

void connect(int i, int j, PVector[] points) {
  PVector a = points[i];
  PVector b = points[j];
  strokeWeight(1);
  stroke(255);
  line(a.x, a.y, b.x, b.y);
}
public static void main(String[] args){
    String[] processingArgs = {"MySketch"};
    MainDriver mySketch = new MainDriver();
    PApplet.runSketch(processingArgs, mySketch);

    // call whatever Java code you want
}
}