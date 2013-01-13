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

public class example_3_2 extends PApplet {

// The Nature of Code
// Daniel Shiffman
// http://natureofcode.com

Mover[] movers = new Mover[20];

Attractor a;

public void setup() {
  size(800,200);
  background(255);
  for (int i = 0; i < movers.length; i++) {
    movers[i] = new Mover(random(0.1f,2),random(width),random(height));
  }
  a = new Attractor();
}

public void draw() {
  background(255);

  a.display();

  for (int i = 0; i < movers.length; i++) {
    PVector force = a.attract(movers[i]);
    movers[i].applyForce(force);

    movers[i].update();
    movers[i].display();
  }

}
// The Nature of Code
// Daniel Shiffman
// http://natureofcode.com

// Attraction

// A class for a draggable attractive body in our world

class Attractor {
  float mass;         // Mass, tied to size
  PVector location;   // Location
  float g;

  Attractor() {
    location = new PVector(width/2, height/2);
    mass = 20;
    g = 0.4f;
  }


  public PVector attract(Mover m) {
    PVector force = PVector.sub(location, m.location);             // Calculate direction of force
    float distance = force.mag();                                 // Distance between objects
    distance = constrain(distance, 5.0f, 25.0f);                    // Limiting the distance to eliminate "extreme" results for very close or very far objects
    force.normalize();                                            // Normalize vector (distance doesn't matter here, we just want this vector for direction)
    float strength = (g * mass * m.mass) / (distance * distance); // Calculate gravitional force magnitude
    force.mult(strength);                                         // Get force vector --> magnitude * direction
    return force;
  }

  // Method to display
  public void display() {
    stroke(0);
    strokeWeight(2);
    fill(127);
    ellipse(location.x, location.y, 48, 48);
  }
}
// The Nature of Code
// Daniel Shiffman
// http://natureofcode.com

class Mover {

  PVector location;
  PVector velocity;
  PVector acceleration;
  float mass;

  float angle = 0;
  float aVelocity = 0;
  float aAcceleration = 0;

  Mover(float m, float x, float y) {
    mass = m;
    location = new PVector(x,y);
    velocity = new PVector(random(-1,1),random(-1,1));
    acceleration = new PVector(0,0);
  }

  public void applyForce(PVector force) {
    PVector f = PVector.div(force,mass);
    acceleration.add(f);
  }

  public void update() {

    velocity.add(acceleration);
    location.add(velocity);

    aAcceleration = acceleration.x / 10.0f;
    aVelocity += aAcceleration;
    aVelocity = constrain(aVelocity,-0.1f,0.1f);

    acceleration.mult(0);
  }

  public void display() {
    float angle = velocity.heading();       // returns 2d direction angle for any vector

    stroke(0);
    fill(175,200);
    rectMode(CENTER);
    pushMatrix();
    translate(location.x,location.y);
    rotate(angle);
    rect(0,0,mass*16,mass*16);
    popMatrix();
  }

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "example_3_2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
