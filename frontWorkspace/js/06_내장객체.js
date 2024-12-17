function f01(){
    const x = new Date("2002/1/3/15:16:17");
    console.log(x);

    // const obj1 = {};
    // const obj2 = {"name" : "홍길동"};
    // const obj3 = new Object(0);
    // console.log( obj1 instanceof Object);
    // console.log( obj2 instanceof Object);
    // console.log( obj3 instanceof Object);
    
    // const num1 = 3.14;
    // const num2 = Number(3.14);
    // const num3 = Number("3.14");
    // const num4 = new Number(3.14);
    // console.log( num1 instanceof Number );
    // console.log( num2 instanceof Number );
    // console.log( num3 instanceof Number );
    // console.log( num4 instanceof Number );
    
    const str1 = "zzz";
    const str2 = new String("zzz");
    console.log( str1 instanceof String );
    console.log( str2 instanceof String );
    

}

f01();