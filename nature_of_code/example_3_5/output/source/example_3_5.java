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

public class example_3_5 extends PApplet {

float period = 120;
float amplitude = 100;

public void setup() {
  size(640,360);
}

public void draw() {
  background(255);

  float period = 120;
  float amplituce = 100;

  float x = amplitude * cos(TWO_PI * frameCount/period);

  stroke(0);
  fill(175);
  translate(width/2,height/2);


  ellipse(x,0,20,20);
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "example_3_5" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
