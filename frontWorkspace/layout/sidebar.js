window.onload = function(){
    const asideTag = document.querySelector("aside");
    asideTag.addEventListener("mouseover", function(evt){
        evt.target.classList.toggle("active");
        // evt.target.classList.add("active");
        console.log(evt.target.classList);
        
    });

}
window.onload = function(){
    const asideTag = document.querySelector("aside");
    asideTag.addEventListener("mouseout", function(evt){
        evt.target.classList.toggle("active");
        // evt.target.classList.remove("active");
        console.log(evt.target.classList);
        
    });
}
