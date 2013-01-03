Circle[] circles = new Circle[1000];
int idx = 0;

void setup() {
  size(400, 400);
  background(255);
  smooth();
  for(int i = 0; i < circles.length - 1; i++){
    circles[i] = new Circle();
  }
}

void draw() {
  int cSize = (int) random(1,50);
  Circle c = circles[idx];
  c.display((int) random(1,400), (int) random(1,400), cSize, cSize );
  idx++;
}

class Circle {
  float bgred;
  float bggreen;
  float bgblue;

  Circle() {
    bgred = random(1,255);
    bggreen = random(1,255);
    bgblue = random(1,255);
  }

  void display(int xpos, int ypos, int width, int height) {
    fill(bgred,bggreen,bgblue);
    ellipse(xpos, ypos, width, height);
  }
}
