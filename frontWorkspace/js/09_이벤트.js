const btn01 = document.querySelector("#btn01");

btn01.onclick = function(){
    console.log("버튼 클릭됨 ~~~");
};

function f02(){
    console.log("버튼 클릭됨 2222");
}

const btn03 = document.querySelector("#btn03");
btn03.addEventListener('click', function(){
    console.log("버튼 클릭됨 ~~~ 표준이벤트모델방식~~~");
    
});


// document.querySelector("#btn2-1").onclick = () => {
//     console.log("2-1클릭됨");
// }

// function f2_2(){
//     console.log("2-2클릭됨");
// }

// document.querySelector("#btn2-3").addEventListener('click', () => {
//     console.log("2-3클릭됨");
    
// });

document.querySelector("#btn2-1").onclick = function(x) {
    console.log("btn2-1 클릭됨");
    console.log(x.target);
    console.log(this);
};

function f2_2(x) {
    console.log("btn2-2 클릭됨");
    console.log(window.event.target);
    console.log(this);
}

document.querySelector("#btn2-3").addEventListener('click', function(x) {
    console.log("btn2-3 클릭됨");
    console.log(x.target);
    console.log(this);
});


//a태그
function fnaver(){
    return confirm("네이버 이동 ㄱㄱ?");
}

const gg = document.querySelector("#gg");
gg.addEventListener("click", function(x){
    x.preventDefault();
});

//form태그

const formArr = document.querySelectorAll("form");
const formTag = formArr[0];
formTag.addEventListener("submit", function(x){
    const searchValueTag = document.querySelector("input[name=searchValue]");
    const str = searchValueTag.value;
    if(str.length < 2){
        x.preventDefault();
        alert("검색어 2글자 이상");
    }
});