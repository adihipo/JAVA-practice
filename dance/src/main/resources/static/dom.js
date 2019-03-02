window.addEventListener('keyup', function(e){
  const arms = document.getElementsByClassName('arms')[0];
  changeImage(arms);
});

function changeImage(element){
  let src = element.getAttribute("src");
  if(src == "arms.png") {
    src = "arms_up.png";
  }else {
    src = "arms.png";
  }
  element.setAttribute("src", src);
}