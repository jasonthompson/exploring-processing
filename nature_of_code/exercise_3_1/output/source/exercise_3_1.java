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

public class exercise_3_1 extends PApplet {

float angle = 0;
float aVelocity = 0;
float aAcceleration = 0.001f;

public void setup() {
  size(640,360);
}

public void draw () {
  background(255);

  fill(175);
  stroke(0);
  rectMode(CENTER);
  translate(width/2,height/2);
  rotate(angle);
  line(-50,0,50,0);
  ellipse(50,0,8,8);
  ellipse(-50,0,8,8);

  aVelocity += aAcceleration;
  angle += aVelocity;
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "exercise_3_1" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
