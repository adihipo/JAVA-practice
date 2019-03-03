window.addEventListener('keyup', function(e){
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
   }
});

function changeImage(element, origin){
  let src = element.getAttribute("src");
  if(src == origin + ".png") {
    src = origin + "_up.png";
  }else {
    src = origin + ".png";
  }
  element.setAttribute("src", src);
}