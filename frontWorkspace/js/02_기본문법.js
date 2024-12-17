// 1. 변수와 자료형
// 선언

function f01(){     
    x = 10;

    console.log(this.x);
}

// f01();

// 자료형
function f02(){
    var x = f01();
    console.log(typeof x);
}

// f02();

// var, let, const(상수) 차이점

function f03(){
    const x = 10;
    x = 10;
}

// f03();

// 유효 범위(스코프)
//  - 함수 안에서 var 키워드로 선언된 변수는 함수 유효 범위를 갖는다.
function f04(){

    if(1>0) {
        var x = 123;
    }
    console.log(x);
}

f04();