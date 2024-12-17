function checkDupId(){
    //제출 버튼 가져오기
    const submitBtn = document.querySelector("form input[type=submit]");

    // 유저가 입력한 아이디 준비
    const id = document.querySelector("input[name=id]").value;
    
    //서버한테 아이디 넘기기
    $.ajax({
        url :"/member/id-dup",
        method :"POST",
        data : {
            id : id
        },
        success : function(x){
            // 성공한 데이터가 파라미터값으로 들어온다 (x) 
            console.log("통신성공");
            const o = JSON.parse(x);
            //x는 생문자열로 넘어오는데 제이슨 형식에 맞으면 JSON.parse 로 객체화 시킬수 있다.
            if(o.status === 'good'){
                
                alert(`${o.data}는 사용가능한 아이디입니다`)
                submitBtn.removeAttribute("disabled");
            }else{
                
                alert(`${o.data}는 사용 불가능한 아이디입니다`)
                submitBtn.setAttribute("disabled","true")
            }
            
            
            
        },
        fail :function(){
            console.log("통신실패");
            
        },

    });
    //결과 받아서, form 태그 submit 가능여부 결정
}
function disableSubmitBtn(){
    const submitBtn = document.querySelector("form input[type=submit] ");
    submitBtn.setAttribute("disabled","true");
}