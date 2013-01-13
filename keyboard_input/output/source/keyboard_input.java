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

public class keyboard_input extends PApplet {

Mover mover;

public void setup() {
  size(800,200);
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
    if (keyCode == DOWN) {
      mover.stop();
    }
    if (keyCode == UP) {
      mover.go();
    }
  }
}


class Mover {

  PVector location;
  PVector velocity;
  PVector acceleration;
  float topspeed;
  float speed;

  Mover() {
    location = new PVector(width/2, height/2);
    velocity = new PVector(0,0);
    acceleration = new PVector(0.001f,0.1f);
    topspeed = 10;
    speed = 1;
  }

  public void update() {
    velocity.add(acceleration);
    acceleration.limit(speed);
    velocity.limit(topspeed);
    location.add(velocity);
  }

  public void display() {
    stroke(0);
    strokeWeight(2);
    fill(127);
    ellipse(location.x, location.y, 48, 48);
  }

  public void stop() {
    speed = 0;
  }

  public void go() {
    speed *= 0.25f;
  }

  public void checkEdges() {

    if (location.x > width) {
      location.x = 0;
    }
    else if (location.x < 0) {
      location.x = width;
    }

    if (location.y > height) {
      location.y = 0;
    }
    else if (location.y < 0) {
      location.y = height;
    }
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "keyboard_input" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
