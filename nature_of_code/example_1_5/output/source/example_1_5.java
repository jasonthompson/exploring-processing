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

public class example_1_5 extends PApplet {

public void setup() {
  size(640,360);
}

public void draw() {
  background(255);

  PVector mouse = new PVector(mouseX,mouseY);
  PVector center = new PVector(width/2,height/2);

  mouse.sub(center);

  float m = mouse.mag();
  fill(0);
  rect(0,0,m,10);

  float mr = mouse.mag() * -1;
  fill(200);
  stroke(0);
  rect(width,height-10,mr,10);

  translate(center.x,center.y);
  line(0,0,mouse.x,mouse.y);
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "example_1_5" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
