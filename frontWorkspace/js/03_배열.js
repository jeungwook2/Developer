function f01(){
    console.log("선언, 초기화 테스트 ~~~");

    // let x = new Array();
    let x = [];
    x[0] = "하나";
    x[1] = "둘";
    x[2] = 3.14;
    x[3] = true;
    console.log(x);
    
}

function test01(){
    console.log("indexOf 테스트 ~~~");

    let x = ["사과", "자두", "망고"];
    let result = x.indexOf("망고");
    console.log(result);
    
}

function test02(){
    console.log("concat test ~~~");

    let a = [1,2,3,4,5];
    let b = ["하나", "둘", "셋"];

    let result = a.concat(b);
    console.log(result);

}

function test03(){
    console.log("join test ~~~");

    let x = ["치킨", "피자", "햄버거"];
    let result = x.join();
    console.log(result);
    
}

function test04(){
    console.log("reverse ~~~");
    
    let x = [10,20,"hi","bye", true];
    x.reverse();

    console.log(x);
    
}

function test05(){
    console.log("sort ~~~");
    
    let x = [10, 20, 30, 999, 77, 4321];
    x.sort();
    console.log(x);
    
}

function test06(){
    console.log("push, pop ~~~");

    let x = [];
    x.push("a");
    x.push("b");
    x.push("c");
    
    console.log(x);

    console.log(x.pop());
    console.log(x);
    
}

function test07(){
    console.log("shift, unshift ~~~");

    let x = ["하나", "둘", "셋"];

    let result = x.shift();
    console.log(result);
    console.log(x);
    
    x.unshift("zzz");
    console.log(x);
}

function test08(){
    console.log("slice, splice ~~~");
    
    let x = [1,2,3,4,5];

    // let result = x.slice(2);
    // console.log(result);
    // console.log(x);

    let result = x.splice(2, 2, 'hello', 'world', 'java'); 
    // 2번 인덱스부터 시작해서 2개요소를 꺼내옴, 그리고 그 위치에 요소 추가
    console.log(result);
    console.log(x);
    
}