const allMusic = ["cold.mp3", "bonfire.mp3", "betty.mp3", "babylon.mp3", "bangarang.mp3",
                  "closer.mp3", "halloween.mp3", "internet.mp3", "motivation.mp3", "somebody.mp3"];
const background = document.getElementsByClassName('background')[0];

setInterval(() => changeBackground(), 3000);

window.addEventListener('keyup', function(e) {
   let code = e.which || e.keyCode;
   if (code == '38') {  // Up
     const base = document.getElementsByClassName('base')[0];
     changeImage(base, "base");
   }else if (code == '40') { // Down
     const tail = document.getElementsByClassName('tail')[0];
     changeImage(tail, "tail");
   }else if (code == '37') { // Left
     const left = document.getElementsByClassName('left')[0];
     changeImage(left, "left");
   }else if (code == '39') { // Right
     const right = document.getElementsByClassName('right')[0];
     changeImage(right, "right");
   }else if (code == '32') { // Space
     const music = document.getElementsByClassName('music')[0];
     changeMusic(music);
   }
});

function changeImage(element, origin) {
  let src = element.getAttribute("src");
  if(src == origin + ".png") {
    src = origin + "_up.png";
  }else if(src == origin + "_up.png"){
    src = origin + "_alt.png";
  }else if(src == origin + "_alt.png"){
    src = origin + ".png";
  }
  element.setAttribute("src", src);
}

function changeMusic(element) {
  let src = element.getAttribute("src");
  let random = Math.floor(Math.random() * allMusic.length);
  if(src == allMusic[random]) {
    changeMusic(element);
  }else {
    element.setAttribute("src", allMusic[random]);
  }
}

function changeBackground() {
  background.setAttribute("style", "background: linear-gradient(" + getRandomDegree() + "deg, " + getRandomColor() + ", " + getRandomColor() + ");")
}

function getRandomDegree() {
  return Math.floor(Math.random() * 360);
}

function getRandomColor() {
  var letters = '0123456789ABCDEF';
  var color = '#';
  for (let i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  return color;
}

