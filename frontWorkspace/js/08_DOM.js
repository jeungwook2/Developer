function f01(){
    const h1node = document.createElement('h1');
    
    const textNode = document.createTextNode("안녕");
    h1node.appendChild(textNode);

    console.log(h1node);

    const bodyTag = document.querySelector("body");
    bodyTag.appendChild(h1node);
}

function f02(){
    const imgTag = document.createElement("img");
    imgTag.setAttribute("src", "../resources/img/person.png");
    imgTag.setAttribute("width", "300px");
    imgTag.setAttribute("height", "300px");
    imgTag.setAttribute("nick", "honggildong");
    imgTag.setAttribute("age", "20");

    console.log(imgTag);
    
    const bodyTag = document.querySelector("body");
    bodyTag.appendChild(imgTag);
}

function f03(){
    const h1Arr = document.querySelectorAll("h1");
    const target = h1Arr[h1Arr.length-1]
    console.log(target);
    
    target.remove();

}

// setInterval(() => {
//    const btn02 = document.querySelector("#btn02");
//    btn02.click();
// }, 1000);