function delAttach(attachNo,fileName,imgTag){
    // 이미지에 onclick으로 함수를 호출하기 때문에 img태그에서 this를 작성하면 event 객체를 얻어올수있다.
//  이벤트를 추가하는 방식
// 표준 = addEventListner


    const result = confirm("해당사진을 삭제하시겠습니까 ? (복구 불가능)");

    if(result == false){return;}
   $.ajax({
    url:"/board/attachment/del",
    method:"post",
    data: {
        ano : attachNo,
        fileName : fileName,
        // 키값 : value 값 식으로 데이터가 넘어간다
    },
    // 키 - 벨류 형식의 객체로써 데이터를 저쪽으로 보내주는것이 data이다
    // 몇번 사진을 삭제해라 니까 매개변수로 data를 보내준다
    success:function(data){
        console.log(data);
        if(data =="1"){
            alert("첨부파일 삭제성공");
            imgTag.remove();
            // 이벤트 요소의 target을 받아와서 삭제한다.
        }else{
            alert("첨부파일 삭제실패");
        }
        
    },
    fail: function(){
        alert("통신실패");
    }
   })
}