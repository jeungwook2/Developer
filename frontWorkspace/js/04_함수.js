// function f01(){
//     console.log("선언적 함수 실행됨 ~~~");
// }
// f01();

// x = function(){
//     console.log("익명 함수 실행됨 ~~~");
// }
// x();

// const x = () => {
//     console.log("화살표 함수 실행됨 ~~~");
// }
// x();

// const x = (a,b) => a+b;
// const result = x(3,4,5,6,7);
// console.log(result);

// function f01(a,b){
//     console.log(a);
//     console.log(b);
//     console.log(arguments);
    
// }
// f01(10,20,30,40,50);

// function f01(){
//     return () => {
//         console.log("f02 함수 실행됨 ~");
        
//     };   
// }

// const x = () => {
//     console.log("f02 함수 실행됨 ~");
    
// }

// const result = f01();
// console.log(result);
// result();

// function f01(){
//     const str = "hello";
//     return function(){
//         console.log(str);
        
//     }
// }

// const result = f01();
// result();

// const str = "1+2+3+4+5";

// const result = eval(str);
// console.log(result);

const result = 10/"a";
console.log(result);
console.log( isFinite(result) );
console.log( isNaN(result) );
