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

public class random extends PApplet {
  public void setup() {
float xstep = 10;
float ystep = 10;
float lastx = 20;
float lasty = 50;
float y = 50;
for(int x = 20; x <= 480; x += xstep){
  ystep = random(20) - 10; //range -10 to 10
  y += ystep;
  line(x, y, lastx, lasty);
  lastx = x;
  lasty = y; }
ellipse(10,10,40,40);
    noLoop();
  }

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "random" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
