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

public class example_3_4 extends PApplet {

float r = 5;                     // length of hypoteneus or vector
float theta = 0;                  // angle of vector

public void setup() {
  size(640,360);
  background(255);
}

public void draw() {
  float x = r * cos(theta);       // given the lenght and angle of Vector you can figure out x and y using cosine and sin functions
  float y = r * sin(theta);

  noStroke();
  fill(0);
  ellipse(x+width/2, y+height/2, 2, 2);

  theta += 0.01f;
  r += 0.01f;
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "example_3_4" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
