const tbodyTag = document.querySelector("main .table-area tbody");

tbodyTag.addEventListener("click",(evt)=>{
 
    if(evt.target.tagName != "TD"){return;}
    const no = evt.target.parentNode.children[0].innerText;
    // 이벤트가 발생한 타겟의 1번째 요소의 텍스트
    location.href=`/notice/detail?no=${no}`;
    
})

function handleCheckBox(evt){
    console.log(evt);
    // evt 는 클릭이 눌린 요소를 가져온다.
    
    const CheckboxArr = document.querySelectorAll(".checkbox-td > input[type=checkbox]");
    // 체크박스 모든요소 가져오기 
    
    for(let i = 0; i <CheckboxArr.length;i++){
// 반복문 돌면서

            CheckboxArr[i].checked =evt.checked;
            //배열의 요소를 꺼내와서 체크가 되어있는 속성에 현재 이벤트 속성을 넣는다.
            //evt 요소는 부모의 요소인데 그행동을 따라하도록 만든것.
      
    }

}
function deleteNotice(){
    let delallData ={};
    const dataArr=[];
    // 빈 객체를 만들어주고 
    const CheckboxArr = document.querySelectorAll(".checkbox-td > input[type=checkbox]");
    for(let i = 0; i <CheckboxArr.length;i++){
        if(CheckboxArr[i].checked == true){

            console.log(CheckboxArr[i].value);
            
            delallData[CheckboxArr[i].value] = CheckboxArr[i].value;
            // [ 안 ] 안에는 선언이 되어있는 변수면 변수의 값을가져오고
            // 선언이 안되어있는 새로운 키값을 사용하려면 "" 문자열로써 사용하면된다.
            //객체 안에       키값에다가          벨류값을 집어넣는다
            // 이 변수명에 동적으로 키이름을 만들고 벨류값을 집어넣어서 객체로써 동작한다.
            dataArr.push(CheckboxArr[i].value);
        }
        
    }
   
        console.log(delallData);
        // 최종적으로 완성된 키:벨류 값의 배열  
        console.log(dataArr);
        
        $.ajax({
            url:"/notice/del",
            method:"delete",
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(dataArr),
            success:function(data){
                    console.log(data); 

                    location.href="/notice/list"
            },
            fail:function(){

            }


        })
        
    
}