// Based on Oscillator class from Example 3.7 in Daniel Shiffman's Nature of Code
// http://natureofcode.com/book/chapter-3-oscillation/
// To make this class more general purpose, I would factor out the shape and random colour logic.

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

  void oscillate() {
    angle.add(velocity);
  }

  void display() {
    float x = sin(angle.x)*amplitude.x;
    float y = sin(angle.y)*amplitude.y;

    pushMatrix();
    translate(width/2,height/2);
    stroke(fillR * 0.75,fillG * 0.75,fillB * 0.75);
    fill(fillR,fillG,fillB);
    ellipse(x,y,16,16);
    popMatrix();
  }
}
