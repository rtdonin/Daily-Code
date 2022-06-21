let side = 1000;

function setup() {
  createCanvas(side, side);
  background(220);
}

function draw() {
  drawCircles();
}

function drawCircles() {
  let border = 20;
  let colorChange = 30;
  let offset = 60;

  let xPosition = random(side - 2 * border) + border;
  let yPosition = random(side - 2 * border) + border;
  let radius = random(225) + colorChange;

  let rColor = random(255 - colorChange * (radius % 20) - offset) + offset;
  let gColor = random(255 - colorChange * (radius % 20) - offset) + offset;
  let bColor = random(255 - colorChange * (radius % 20) - offset) + offset;

  for (let i = 0; radius > 5; i++) {
    console.log(i + " " + rColor + " " + gColor + " " + bColor);
    fill(color(rColor, gColor, bColor));
    circle(xPosition, yPosition, radius);

    radius = radius - 20;
    rColor = rColor + colorChange;
    gColor = gColor + colorChange;
    bColor = bColor + colorChange;
  }
}
