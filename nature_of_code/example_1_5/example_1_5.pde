void setup() {
  size(640,360);
}

void draw() {
  background(255);

  PVector mouse = new PVector(mouseX,mouseY);
  PVector center = new PVector(width/2,height/2);

  mouse.sub(center);

  float m = mouse.mag();
  fill(0);
  rect(0,0,m,10);

  float mr = mouse.mag() * -1;
  fill(200);
  rect(width,height-10,mr,10);

  translate(center.x,center.y);
  line(0,0,mouse.x,mouse.y);
}
