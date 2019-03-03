window.addEventListener('keyup', function(e){
   let code = e.which || e.keyCode;
   if (code == '38') {  // Up

   }else if (code == '40') { // Down

   }else if (code == '37') { // Left

   }else if (code == '39') { // Right
     const arms = document.getElementsByClassName('arms')[0];
     changeImage(arms, "arms");
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