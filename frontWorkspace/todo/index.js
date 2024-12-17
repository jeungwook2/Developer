function addTodo(){
    const str = document.querySelector("#newTodo").value;

    const todoArrStr = localStorage.getItem("todo");
    let todoArr = JSON.parse(todoArrStr);

    if(todoArr === null){
        todoArr = [];
    }

    let seq_ = localStorage.getItem("seq");
    if(seq_ === null){
        seq_ = 1;
    }
    const seq = parseInt(seq_);
    const todoObj = {
        no : seq ,
        todoName : str ,
        done : false ,
    };
    localStorage.setItem("seq" , seq+1);
    todoArr.push(todoObj);

    localStorage.setItem("todo" , JSON.stringify(todoArr));
    showTodoList();
}

function showTodoList(){
    // 데이터 가져오기 - 아직까지는 문자열
    const str = localStorage.getItem("todo");
    // 데이터 변환하기 - 문자열=>객체배열
    const todoArr = JSON.parse(str);
    // 객체배열을 이용하여 tr 요소 만들기
    const tbodyTag = document.querySelector("tbody");
    tbodyTag.innerHTML = "";
    for(let i = 0 ; i < todoArr.length; ++i){
        const todoObj = todoArr[i];

        const trTag = document.createElement("tr");
        const tdTag1 = document.createElement("td");
        const tdTag2 = document.createElement("td");
        const tdTag3 = document.createElement("td");

        if(todoObj.done){
            tdTag1.classList.add("text-strike");
        }

        const textNode = document.createTextNode(todoObj.todoName);
        const inputTag = document.createElement("input");
        inputTag.setAttribute("onclick", `updateTodo(${todoObj.no}, this);`);
        inputTag.setAttribute("type" , "checkbox");
        if(todoObj.done){
            inputTag.setAttribute("checked" , "checked");
        }
        const btnTag = document.createElement("button");
        const btnTxtNode = document.createTextNode("삭제");
        btnTag.setAttribute("onclick" , `deleteTodo(${todoObj.no});`);
        btnTag.appendChild(btnTxtNode);

        tdTag1.appendChild(textNode);
        tdTag2.appendChild(inputTag);
        tdTag3.appendChild(btnTag);
        

        trTag.appendChild(tdTag1);
        trTag.appendChild(tdTag2);
        trTag.appendChild(tdTag3);
        
        // tr 요소를 table > tbody 에 넣기
        tbodyTag.appendChild(trTag);
    }//for

}//function



window.onload = function(){
    showTodoList();
    showDoneList();
}


function deleteTodo(num){
    const todoArrStr = localStorage.getItem("todo");
    const todoArr = JSON.parse(todoArrStr);
    const newTodoArr = [];
    for(let i = 0; i < todoArr.length; ++i){
        const todoObj = todoArr[i];
        if(todoObj.no == num){
            todoArr.splice(i,1);
            break;
        }
        // newTodoArr.push(todoObj);
    }
    localStorage.setItem("todo" , JSON.stringify(todoArr));
    showTodoList();
}

function updateTodo(num, checkboxTag){
    const todoArrStr = localStorage.getItem("todo");
    const todoArr = JSON.parse(todoArrStr);
    for(let i = 0; i < todoArr.length; ++i){
        const todoObj = todoArr[i];
        if(todoObj.no == num){
            todoObj.done = checkboxTag.checked   ;
            break;
        }
    }
    localStorage.setItem("todo", JSON.stringify(todoArr));

    console.log(checkboxTag.parentNode.parentNode.children[0]);
    const x = checkboxTag.parentNode.parentNode.children[0]
    x.classList.toggle("text-strike");

    createDoneList();
    window.onload();
}

function createDoneList(){
    const todoArrStr = localStorage.getItem("todo");
    const todoArr = JSON.parse(todoArrStr);
    const doneList = [];

    for(let i = 0; i < todoArr.length; ++i){
        const todoObj = todoArr[i];
        if(todoObj.done){
            doneList.push(todoObj);
        }
    }
    localStorage.setItem("doneList", JSON.stringify(doneList));
}

createDoneList();

function showDoneList(){
    // 데이터 가져오기 - 아직까지는 문자열
    const str = localStorage.getItem("doneList");
    // 데이터 변환하기 - 문자열=>객체배열
    const doneArr = JSON.parse(str);
    // 객체배열을 이용하여 tr 요소 만들기
    const tbodyTag = document.querySelectorAll("tbody")[1];
    tbodyTag.innerHTML = "";
    for(let i = 0 ; i < doneArr.length; ++i){
        const todoObj = doneArr[i];

        const trTag = document.createElement("tr");
        const tdTag1 = document.createElement("td");
        const tdTag2 = document.createElement("td");
        const tdTag3 = document.createElement("td");

        if(todoObj.done){
            tdTag1.classList.add("text-strike");
        }

        const textNode = document.createTextNode(todoObj.todoName);
        const inputTag = document.createElement("input");
        inputTag.setAttribute("onclick", `updateTodo(${todoObj.no}, this);`);
        inputTag.setAttribute("type" , "checkbox");
        if(todoObj.done){
            inputTag.setAttribute("checked" , "checked");
        }
        const btnTag = document.createElement("button");
        const btnTxtNode = document.createTextNode("삭제");
        btnTag.setAttribute("onclick" , `deleteTodo(${todoObj.no});`);
        btnTag.appendChild(btnTxtNode);

        tdTag1.appendChild(textNode);
        tdTag2.appendChild(inputTag);
        tdTag3.appendChild(btnTag);
        

        trTag.appendChild(tdTag1);
        trTag.appendChild(tdTag2);
        trTag.appendChild(tdTag3);
        
        // tr 요소를 table > tbody 에 넣기
        tbodyTag.appendChild(trTag);
    }//for

}//function

// window.onload = function(){
//     showDoneList();
// }