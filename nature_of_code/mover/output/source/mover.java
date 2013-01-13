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

public class mover extends PApplet {

Mover mover;

public void setup() {
  size(640,360);
  mover = new Mover();
}

public void draw() {
  background(255);
  mover.update();
  mover.checkEdges();
  mover.display();
}

public void keyPressed() {
  if (key == CODED) {
    if (keyCode == UP) {
      mover.go();
    } else if (keyCode == DOWN) {
      mover.stop();
    }
  }
}

class Mover {

  PVector location;
  PVector velocity;
  PVector acceleration;

  float topspeed;

  Mover() {

    location = new PVector(width/2,height/2);
    velocity = new PVector(0,0);
    acceleration = new PVector(-0.001f,0.01f); //Keep numbers small. WIll accumulate in velocity 30 times per second
    topspeed = 10;
  }

  public void update() {
    PVector mouse = new PVector(mouseX,mouseY);
    PVector dir = PVector.sub(mouse,location);


    dir.normalize();
    dir.mult(0.5f);

    acceleration = dir;

    velocity.add(acceleration);
    velocity.limit(topspeed);
    location.add(velocity);
  }

  public void display() {
    stroke(0);
    fill(175);
    ellipse(location.x,location.y,16,16);
  }

  public void go() {
    acceleration.mult(0.25f);
  }

  public void stop() {
    acceleration.setMag(0);
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
    String[] appletArgs = new String[] { "mover" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
