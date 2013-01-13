Mover mover;

void setup() {
  size(800,200);
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

  Mover() {
    location = new PVector(width/2, height/2);
    velocity = new PVector(0, 0);

    topspeed = 10;
  }

  void update() {
    velocity.add(acceleration);
    velocity.limit(topspeed);
    location.add(velocity);
  }

  void display() {
    stroke(0);
    strokeWeight(2);
    fill(127);
    ellipse(location.x, location.y, 48, 48);
  }

  void stop() {
    topspeed = 0;
  }

  void go() {
    topspeed =+ 1;
  }

  void checkEdges() {

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
