import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class circles extends PApplet {

Circle[] circles = new Circle[1000];
int idx = 0;

public void setup() {
  size(400, 400);
  background(255);
  smooth();
  for(int i = 0; i < circles.length - 1; i++){
    circles[i] = new Circle();
  }
}

public void draw() {
  int cSize = (int) random(1,50);
  Circle c = circles[idx];
  c.display((int) random(1,400), (int) random(1,400), cSize, cSize );
  idx++;
}

class Circle {
  float bgred;
  float bggreen;
  float bgblue;

  Circle() {
    bgred = random(1,255);
    bggreen = random(1,255);
    bgblue = random(1,255);
  }

  public void display(int xpos, int ypos, int width, int height) {
    fill(bgred,bggreen,bgblue);
    ellipse(xpos, ypos, width, height);
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "circles" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
