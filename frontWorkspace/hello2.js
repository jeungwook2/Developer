// 모달 요소 가져오기
const overmodal1 = document.getElementById('overmodal1');
const testDiv1 = document.querySelector('.test1');
const closeOverModal1 = document.querySelector('.overmodal1-close');

// "TEST" div 클릭 시 모달 열기
testDiv1.addEventListener('click', () => {
    console.log(overmodal1);
    overmodal1.style.display = 'block'; // 모달 표시
});

// "X" 버튼 클릭 시 모달 닫기
closeOverModal1.addEventListener('click', () => {
    overmodal1.style.display = 'none'; // 모달 숨기기
});

// 모달 요소 가져오기
const overmodal2 = document.getElementById('overmodal2');
const testDiv2 = document.querySelector('.test2');
const closeOverModal2 = document.querySelector('.overmodal2-close');

// "TEST" div 클릭 시 모달 열기
testDiv2.addEventListener('click', () => {
    console.log(overmodal2);
    overmodal2.style.display = 'block'; // 모달 표시
});

// "X" 버튼 클릭 시 모달 닫기
closeOverModal2.addEventListener('click', () => {
    overmodal2.style.display = 'none'; // 모달 숨기기
});


// 모달 요소 가져오기
const vacationmodal = document.getElementById('vacationmodal');
const testDiv3 = document.querySelector('.test3');
const closeVacationmodal = document.querySelector('.vacationmodal-close');

// "TEST" div 클릭 시 모달 열기
testDiv3.addEventListener('click', () => {
    console.log(vacationmodal);
    vacationmodal.style.display = 'block'; // 모달 표시
});

// "X" 버튼 클릭 시 모달 닫기
closeVacationmodal.addEventListener('click', () => {
    vacationmodal.style.display = 'none'; // 모달 숨기기
});

// 모달 요소 가져오기
const salarymodal = document.getElementById('salarymodal');
const testDiv = document.querySelector('.test4');
const closeSalarymodal = document.querySelector('.salarymodal-close');

// "TEST" div 클릭 시 모달 열기
testDiv.addEventListener('click', () => {
    salarymodal.style.display = 'block'; // 모달 표시
});

// "X" 버튼 클릭 시 모달 닫기
closeSalarymodal.addEventListener('click', () => {
    salarymodal.style.display = 'none'; // 모달 숨기기
});

const btnmodal = document.getElementById('btnmodal');
const closeBtnmodal = document.querySelector('.btnmodal-close');
const btns = document.querySelectorAll('.employee-select-btn'); // 모든 버튼 선택

// 각 버튼에 이벤트 리스너 추가
btns.forEach((btn) => {
  btn.addEventListener('click', () => {
    btnmodal.style.display = 'block'; // 모달 표시
  });
});

// "X" 버튼 클릭 시 모달 닫기
closeBtnmodal.addEventListener('click', () => {
  btnmodal.style.display = 'none'; // 모달 숨기기
});
