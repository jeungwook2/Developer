//댓글 작성하기 버튼 클릭 시
function writeReply(refNo){
    //댓글 내용 가져오기
    const replyContent = document.querySelector("#reply-write-area input[name=content]").value;
    //비동기 통신하기
    $.ajax({
        url:"/notice/reply/write",
        method:"POST",
        data:{
            "content" :replyContent,
            "refNo": refNo,
        },
        success:function(data){
            console.log("통신성공");
            if(data==1){

                alert("댓글작성완료");
                loadReply();
            }else{
                alert("댓글작성실패");
            }
            
        },
        error:function(){console.log("통신실패");}
    })
}

//댓글을 불러오기

function loadReply(){
//현재 공지사항 번호 가져오기
    const noticeNo =document.querySelector("#reply-list-area").getAttribute("noticeNo");

    $.ajax({
        url:"/notice/reply/list",
        method:"GET",
        data:{
            noticeNo :noticeNo,
        },
        success:function(data){
            console.log("성공입니다~ㅋㅋㅋ");
            console.log("댓글리스트 :" , data);
            paintReplyList(data);

            
        },
        error:function(){
            console.log("실패입니다 ㅋㅋㅋㅋ");
            
        }
    })
}

//댓글 리스트 그리기

function paintReplyList(voList){

    const replyWriteArea =document.querySelector("#reply-write-area input[name=content]");

    const replyListArea=document.querySelector("#reply-list-area");
    replyListArea.innerHTML="";
    replyWriteArea.removeAttribute("value");
    for(const vo of voList){

   
    const div01 = document.createElement("div");
    div01.innerText=vo.content;

    const div02 = document.createElement("div");
    div02.innerText=vo.writerNick;

    const div03 = document.createElement("div");
    div03.innerText=vo.createDate;

    replyListArea.appendChild(div01);
    replyListArea.appendChild(div02);
    replyListArea.appendChild(div03);

}
   
  
}

loadReply();