float period = 120;
float amplitude = 100;

void setup() {
  size(640,360);
}

void draw() {
  background(255);

  float period = 120;
  float amplituce = 100;

  float x = amplitude * cos(TWO_PI * frameCount/period);

  stroke(0);
  fill(175);
  translate(width/2,height/2);


  ellipse(x,0,20,20);
}
