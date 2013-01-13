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

public class example_1_8 extends PApplet {

Mover[] movers = new Mover[1000];

public void setup() {
  size(800,600);
  background(0);
  for (int i = 0; i < movers.length; i++) {
    movers[i] = new Mover();
  }

}

public void draw() {
  for (int i = 0; i < movers.length; i++) {
    movers[i].update();
    movers[i].checkEdges();
    movers[i].display();
  }
}


class Mover {

  PVector location;
  PVector velocity;
  PVector acceleration;
  float topspeed;
  float strokeR;
  float strokeG;
  float strokeB;

  Mover () {

    location = new PVector(random(width),random(height));
    velocity = new PVector(0,0);
    acceleration = new PVector(0,0);
    topspeed = 5;
    strokeR = random(200,240);
    strokeG = random(100,100);
    strokeB = random(10,10);
   }

  public void update() {
    PVector centre = new PVector(height/2,width/2);
    PVector dir = PVector.sub(centre,location);

    dir.normalize();

    dir.mult(random(0.5f));

    acceleration = dir;

    velocity.add(acceleration);
    velocity.limit(topspeed);
    location.add(velocity);

  }

  public void display() {

    stroke(strokeR, strokeG, strokeB);
    ellipse(location.x,location.y,1,1);
  }

  public void checkEdges() {
    if (location.x > width) {
      location.x = 0;
    } else if (location.x < 0) {
      location.x = width;
    }

    if (location.y > height) {
      location.y = 0;
    } else if (location.y < 0) {
      location.y = height;
    }
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "example_1_8" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
