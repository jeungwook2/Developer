function paintPageArea(pvo){
    const pageArea=document.querySelector(".page-area");

    pageArea.innerHTML="";
    //이전버튼
    if(pvo.startPage !=1){
        const aTag =document.createElement("a");
        aTag.setAttribute("href",`/board/list?pno=${pvo.startPage-1}`);
        aTag.innerText ="이전";
        pageArea.appendChild(aTag);
    }
    

    //페이지 버튼
    for(let i=pvo.startPage; i<=pvo.endPage;i++){
        const aTag =document.createElement("a");
        aTag.setAttribute("href","/board/list?pno="+i);
        aTag.innerText =i;
        pageArea.appendChild(aTag);
    }
    //다음버튼

    if(pvo.endPage != pvo.maxPage){
        const aTag =document.createElement("a");
        aTag.setAttribute("href",`/board/list?pno=${pvo.endPage+1}`);
        aTag.innerText ="다음";
        pageArea.appendChild(aTag);
    }
    

}

function loadBoardList(searchType,searchValue){


    const urlParams = new URLSearchParams(window.location.search);
    let pno = urlParams.get('pno'); 
    if(pno == null){
        pno =1;
    }
    $.ajax({
       
        url:"/board/list/data?pno="+pno,
        data:{
            searchType,
            searchValue,
        },

        success:function(m){

            const boardVoList = m.a;
            const pvo = m.b;
            paintPageArea(pvo);

        
       
            const tby = document.querySelector("tbody");
            tby.innerText="";
       
            for(const vo of boardVoList){
            
            const tr = document.createElement("tr");
            
            
            const td1 = document.createElement("td");
            const aTag = document.createElement("a");
            aTag.setAttribute("href",`http://127.0.0.1:8888/board/detail?bno=${vo.no}`);
            //                                                                생성된 vo 의 넘버값으로 이동한다 
            aTag.innerText =vo.title;
            td1.appendChild(aTag);  
            tr.appendChild(td1);

            const td2 = document.createElement("td");
            td2.innerText = vo.categoryName;
            tr.appendChild(td2);

            const td4 = document.createElement("td");
            td4.innerText= vo.writerNick;
            tr.appendChild(td4);

            const td3 = document.createElement("td");
            td3.innerText =vo.hit;
            tr.appendChild(td3);

            const td5 = document.createElement("td");
            td5.innerText =vo.createDate;
            tr.appendChild(td5);


            tby.appendChild(tr);
             }},
            
       


        
        fail:function(){
            alert("게시글 목록조회 실패 (관리자에게 문의하세요)")
        }
    })

}
loadBoardList();
function handleSearchType(x){
    const titleTag = document.querySelector("input[name=searchValue]");
    const categoryTag = document.querySelector("select[name=searchValue]");

    if(x.value == "title"){
        categoryTag.setAttribute("disabled" , true);
        titleTag.removeAttribute("disabled");
    }else{
        titleTag.setAttribute("disabled" , true);
        categoryTag.removeAttribute("disabled");
    }

}
function submitSearchForm(){
    
    const searchType = document.querySelector("select[name=searchType]").value;


        const titleTag = document.querySelector("input[name=searchValue]").value;
        const categoryTag = document.querySelector("select[name=searchValue]").value;

    let searchValue ="";

    if(searchType == "title"){
        
        searchValue = titleTag;
    }else{

        searchValue = categoryTag;
    }

    loadBoardList(searchType,searchValue);

    return false;

}


