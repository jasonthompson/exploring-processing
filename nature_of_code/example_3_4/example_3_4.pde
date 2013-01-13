float r = 5;                     // length of hypoteneus or vector
float theta = 0;                  // angle of vector

void setup() {
  size(640,360);
  background(255);
}

void draw() {
  float x = r * cos(theta);       // given the lenght and angle of Vector you can figure out x and y using cosine and sin functions
  float y = r * sin(theta);

  noStroke();
  fill(0);
  ellipse(x+width/2, y+height/2, 2, 2);

  theta += 0.01;
  r += 0.01;
}
