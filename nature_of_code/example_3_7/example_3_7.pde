// Based on code from Example 3.7 in Daniel Shiffman's Nature of Code
// http://natureofcode.com/book/chapter-3-oscillation/

Oscillator[] oscillators = new Oscillator[5];
PVector amplitude;
PVector velocity;
float ampX;
float ampY;

void setup() {
  frameRate(120);
  background(80);
  size(800, 494);
  smooth();
  ampX = width/1.8;
  ampY = height/2;

  for(int i = 0; i < oscillators.length; i++) {

    velocity = new PVector(-0.025,0.1);
    amplitude = new PVector(ampX,ampY);

    oscillators[i] = new Oscillator(velocity, amplitude);
    ampX /= 1.61803398875;
    ampY /= 1.61803398875;
  }
}

void draw() {
  for(int i = 0; i < oscillators.length; i++) {
    oscillators[i].oscillate();
    oscillators[i].display();
  }
}
