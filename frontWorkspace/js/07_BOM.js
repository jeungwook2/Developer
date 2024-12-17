function f01(){
    window.open("https://www.naver.com", "naver", "width=300, height=300, left=100, top=100");
}

function f02(){
    const timer = window.setTimeout( () => {
       console.log("hello~~~");
    }, 2000);

    clearTimeout(timer);
}

function f03(){
    let tab;
    setTimeout(function(){
       tab = window.open();
    }, 3000);

    window.setTimeout( ()=>{
       tab.close();
    }, 6000)
}

function f04(){
    const timer = window.setInterval( ()=>{
        console.log("3초 지남 ~~~");
    } , 3000 )

    window.setTimeout( () => {
        clearInterval(timer);
    } , 10000);

}

// function f05(){
//     // location.reload()
//     location.href = "https://www.naver.com";
// }

function f05(){
    // location.reload()
    location.assign("https://www.naver.com");
}

function f06(){
    // history.back();
    // history.forward();
    // history.go(-1);
    history.go(1);
}

function f07(){
    console.log(navigator);
    

}
function f08(){
    console.log(screen);
    
}