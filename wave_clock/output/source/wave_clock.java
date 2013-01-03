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

public class wave_clock extends PApplet {

public void setup() {
  size(500,500);
  background(255);
  strokeWeight(5);
  smooth();
}

public void draw() {
  float radius = 5;
  int centX = 250;
  int centY = 250;
  float lastX = -999;
  float lastY = -999;


  float x, y;
  for(float ang = 0; ang <= 1440; ang += 10){
    radius += 1;
    float rad = radians(ang);
    x = centX + (radius * cos(rad));
    y = centY + (radius * sin(rad));
    if (lastX > -999){
      line(x, y, lastX, lastY);
    }
    lastX = x;
    lastY = y;
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "wave_clock" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
