Mover mover;

void setup() {
  size(640,360);
  mover = new Mover();
}

void draw() {
  background(255);
  mover.update();
  mover.checkEdges();
  mover.display();
}

void keyPressed() {
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
    acceleration = new PVector(0,0); //Keep numbers small. WIll accumulate in velocity 30 times per second
    topspeed = 10;
  }

  void update() {
    velocity.add(acceleration);
    velocity.limit(topspeed);
    location.add(velocity);
  }

  void display() {
    stroke(0);
    fill(175);
    ellipse(location.x,location.y,16,16);
  }

  void go() {
    acceleration.mult(0.25);
  }

  void stop() {
    acceleration.setMag(0);
  }

  void checkEdges() {
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
