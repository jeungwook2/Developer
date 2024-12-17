//프로필 사진 변경
document.querySelector("#change-pic").addEventListener("click", function() {
  const newPicUrl = prompt("새 프로필 사진 URL을 입력하세요:");
  if (newPicUrl) {
    document.querySelector(".profile-pic").innerHTML = `<img src="${newPicUrl}" alt="Profile Picture" style="width:150px;height:150px;border-radius:50%;">`;
  }
});

//다크모드

document.querySelector("#dark-mode-btn").addEventListener("click", function() {
  document.body.classList.toggle("dark-mode");

    // 다크 모드가 활성화되었는지 여부를 확인
    const isDarkMode = document.body.classList.contains("dark-mode");

    // 다크 모드일 때 이미지 변경
    if (isDarkMode) {
      document.querySelector('.instagram').src = "/resources/img/instar.png";
    } else {
      // 기본 모드로 돌아갈 때 이미지 복원
      document.querySelector('.instagram').src = "/resources/img/insta.jfif";
    }

});

//팝업
document.querySelector("#card1").addEventListener("click", function() {
    document.querySelector("#pop-up1").style.display = "block";
  });
document.querySelector("#card2").addEventListener("click", function() {
    document.querySelector("#pop-up2").style.display = "block";
  });
document.querySelector("#card3").addEventListener("click", function() {
    document.querySelector("#pop-up3").style.display = "block";
  });
document.querySelector("#card4").addEventListener("click", function() {
    document.querySelector("#pop-up4").style.display = "block";
  });


document.querySelector("#close-btn1").addEventListener("click", function() {
  document.querySelector("#pop-up1").style.display = "none";
});
document.querySelector("#close-btn2").addEventListener("click", function() {
  document.querySelector("#pop-up2").style.display = "none";
});
document.querySelector("#close-btn3").addEventListener("click", function() {
  document.querySelector("#pop-up3").style.display = "none";
});
document.querySelector("#close-btn4").addEventListener("click", function() {
  document.querySelector("#pop-up4").style.display = "none";
});