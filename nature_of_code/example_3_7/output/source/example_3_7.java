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

public class example_3_7 extends PApplet {

Oscillator[] oscillators = new Oscillator[5];
PVector amplitude;
PVector velocity;
float ampX;
float ampY;

public void setup() {
  frameRate(120);
  background(80);
  size(800, 494);
  smooth();
  ampX = width/1.8f;
  ampY = height/2;

  for(int i = 0; i < oscillators.length; i++) {

    velocity = new PVector(-0.025f,0.1f);
    amplitude = new PVector(ampX,ampY);

    oscillators[i] = new Oscillator(velocity, amplitude);
    ampX /= 1.61803398875f;
    ampY /= 1.61803398875f;
  }

}

public void draw() {

  for(int i = 0; i < oscillators.length; i++) {
    oscillators[i].oscillate();
    oscillators[i].display();
  }
}
class Oscillator {
  PVector angle;
  PVector velocity;
  PVector amplitude;
  float fillR;
  float fillG;
  float fillB;

  Oscillator(PVector vel, PVector amp) {

    angle = new PVector();
    velocity = vel;
    amplitude = amp;
    fillB = random(200,250);
    fillG = random(100,250);
    fillR = random(100,200);
  }

  public void oscillate() {
    angle.add(velocity);
  }

  public void display() {
    float x = sin(angle.x)*amplitude.x;
    float y = sin(angle.y)*amplitude.y;

    pushMatrix();
    translate(width/2,height/2);
    stroke(fillR * 0.75f,fillG * 0.75f,fillB * 0.75f);
    fill(fillR,fillG,fillB);
    ellipse(x,y,16,16);
    popMatrix();

  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "example_3_7" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
