let result = document.getElementById("result");

function buttonClick(button){
    if(button == 'AC'){
        result.innerHTML = 0;
    }else if(button == '='){
        result.innerHTML = eval(result.innerHTML);
    }else{
        let str = button;
        
        if(result.innerHTML == '0'){
            result.innerHTML = str;
        }else{
            result.innerHTML += str;
        }
    }

}

