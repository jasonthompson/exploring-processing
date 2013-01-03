void setup() {
  size(500,500);
  background(255);
  strokeWeight(5);
  smooth();
}

void draw() {
  float radius = 5;
  int centX = 250;
  int centY = 250;
  float lastX = -999;
  float lastY = -999;


  float x, y;
  for(float ang = 0; ang <= 1440; ang += 10
){
    radius += 1;
    float rad = radians(ang);
    x = centX + (radius * cos(rad));
    y = centY + (radius * sin(rad));
    if (lastX > -999){
      line(x, y, lastX, lastY);
    }
    lastX = x;
    lastY = y;
  }
}
