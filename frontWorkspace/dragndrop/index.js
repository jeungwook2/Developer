const itemArr = document.querySelectorAll(".item");
const item01 = itemArr[0];

item01.addEventListener("dragstart",function(evt){
    // console.log("dragStart~~~");
    evt.dataTransfer.setData("x",evt.target.innerText);
    
})
item01.addEventListener("dragend",function(evt){
    // console.log("dragend~~~");
    evt.target.remove()
    
})
item01.addEventListener("drag",function(){
    // console.log("darg~~~");
    
})

const box = document.querySelector(".box");

box.addEventListener("dragleave",function(){
    console.log("dragleave ~~~~~~~~~~~");
    
})
box.addEventListener("dragover",function(evt){
    evt.preventDefault();
    console.log("dragover ~~~~~~~~~~~");
    
})
box.addEventListener("dragenter",function(){
    console.log("dragenter ~~~~~~~~~~~");
    
})
box.addEventListener("drop",function(evt){
    evt.preventDefault();
    console.log("drop ~~~~~~~~~~~");
    box.innerHTML ="";
    const divTag =document.createElement("div");
    divTag.setAttribute("class","item");
    // divTag.classList.add("item");
    divTag.innerText=evt.dataTransfer.getData("x");
    box.appendChild(divTag);


    
})