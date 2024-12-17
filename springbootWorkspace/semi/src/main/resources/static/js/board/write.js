// function setCateOptions(){
//     const cateSelect = document.querySelector("#cate-select");
//     $.ajax ({
//         url:"http://127.0.0.1:8888/board/cate",
//         type:"GET",
//         success: function(data){
//             console.log("통신성공");
//             console.log(data);
//             const optionList= data;

//             for(const vo of optionList){
                
//                 const optionTag = document.createElement("option");
//                 optionTag.setAttribute("value",vo.no);
//                 optionTag.innerText=vo.name;
//                 cateSelect.appendChild(optionTag);
//             }
//         },
//         fail:function(){
//             console.log("통신실패");

//         }
//     })


// }



// window.onload = function(){
//     setCateOptions();
// }

const fileTag = document.querySelector("input[name=f]");
fileTag.addEventListener("change",preview);


function preview(evt){
       
    const previewArea = document.querySelector(".preview-area");
    previewArea.innerHTML="";

    for(let i = 0; i<evt.target.files.length; i++){
        const f =evt.target.files[i];
        // 파일안의 타겟속성안에 파일의 배열을 가져오고 
        const fr = new FileReader();
        // 파일을 일기위해서 Reader객체를 불러온다
         fr.onload = function(evt){
        // Reader객체에 온로드 속성으로 이벤트값을 받아오면 파일의 result값을 추출할수있다 
        // result 값이 파일의 url 이름이다
        console.log("다 읽었음")
        console.log(evt);
        console.log(evt.target.result);
        // result 값을 찍어봄 이게 파일의 URL

        const dataUrl=evt.target.result;
        // 파일의 URL을 가지고 

        const imgTag = document.createElement("img");
        imgTag.setAttribute("src",dataUrl);
        // 생성된 이미지 태그의 src 속성에 넣어준다.
        imgTag.setAttribute("width","100");
        imgTag.setAttribute("height","100");

        previewArea.appendChild(imgTag);
    } 
    fr.readAsDataURL(f);
    // f의 배열의 값을 URL로 바꿔주고 
    };
}