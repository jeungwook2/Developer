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





    function changeEmpNo(element) {

      const npercentage = 4.3;
      const hpercentage = 3.2;
      const epercentage = 0.7;
      const lpercentage = 0.32;
      const itpercentage = 1.4;
      const ltpercentage = 0.14;
      
      
      // 
// - [ ]  국민연금 : 월급의 4.3%
// - [ ]  건강보험: 월급의 3.2%
// - [ ]  고용보험 : 월급의 0.7%
// - [ ]  장기요양보험료 : 월급의 0.32%
// - [ ]  소득세 : 월급의 1.4%
// - [ ]  지방 소득세: 월급의 0.14%
      
    //사원 기본정보
      const empNo = document.querySelector("input[name=empNo]");
      const ename = document.querySelector("input[name=name]");
      const dname = document.querySelector("input[name=dname]");
      const panme = document.querySelector("input[name=pname]");
      const salary = document.querySelector("input[name=salary]");
      const basic = document.querySelector("input[name=basic]");

      //통신비 식대 고정 ~
      const communicationCost = document.querySelector("input[name=communicationCost]");
      const mealAllowance = document.querySelector("input[name=mealAllowance]");


      //계산에 의한 지급총액 
      const payment = document.querySelector("input[name=payment]");


      //계산 식에 의한 데이터 추가용
      const nationalPension = document.querySelector("input[name=nationalPension]");
      const healthInsurance = document.querySelector("input[name=healthInsurance]");
      const employmentInsurance = document.querySelector("input[name=employmentInsurance]");
      const longtermCareInsurance = document.querySelector("input[name=longtermCareInsurance]");
      const incomeTax = document.querySelector("input[name=incomeTax]");
      const localTaxes = document.querySelector("input[name=localTaxes]");
      const deductions = document.querySelector("input[name=deductions]");
      const netPayment = document.querySelector("input[name=netPayment]");
     
       
        



      var selectempNo = element.textContent || element.innerText;


      console.log("클릭된 사원 번호:", selectempNo);

      $.ajax({
        url: "/api/hr/vacation/getEmployeeData", // 서버 엔드포인트
        method : "POST", // 요청 방식
        data:({ empNo : selectempNo }), // 전송할 데이터
        success: function (data) {
            console.log("서버 응답 데이터:", data);
                        const basicSalary = Math.floor(data.salary / 12);
                        empNo.setAttribute("value",data.no);
                        ename.setAttribute("value",data.name);
                        dname.setAttribute("value",data.dname);
                        panme.setAttribute("value",data.pname);
                        salary.setAttribute("value",data.salary);
                        basic.value = Math.floor(data.salary / 12);
                        
                        const basicValue = parseInt(basic.value, 10) || 0; // 기본값 0 설정
                        const communicationCostValue = parseInt(communicationCost.getAttribute("value"), 10) || 0;
                        const mealAllowanceValue = parseInt(mealAllowance.getAttribute("value"), 10) || 0;

                        const total1 = basicValue + communicationCostValue + mealAllowanceValue;
                        payment.value=total1;

                        
                        nationalPension.value = Math.round((total1 * (npercentage / 100))/10)*10;
                        healthInsurance.value =  Math.round((total1 * (hpercentage / 100))/10)*10;
                        employmentInsurance.value =  Math.round((total1 * (epercentage / 100))/10)*10;
                        longtermCareInsurance.value =  Math.round((total1 * (lpercentage / 100))/10)*10;
                        incomeTax.value =  Math.round((total1 * (itpercentage / 100))/10)*10;
                        localTaxes.value =  Math.round((total1 * (ltpercentage / 100))/10)*10;


                        const nationalPensionValue = parseInt(nationalPension.value, 10) || 0;
                        const healthInsuranceValue = parseInt(healthInsurance.value, 10) || 0;
                        const employmentInsuranceValue = parseInt(employmentInsurance.value, 10) || 0;
                        const longtermCareInsuranceValue = parseInt(longtermCareInsurance.value, 10) || 0;
                        const incomeTaxValue = parseInt(incomeTax.value, 10) || 0;
                        const localTaxesValue = parseInt(localTaxes.value, 10) || 0;

                        const total2 =Math.round((nationalPensionValue+healthInsuranceValue+employmentInsuranceValue+longtermCareInsuranceValue+incomeTaxValue+localTaxesValue)/10)*10;
                        deductions.value=total2;

                        

                        netPayment.value = total1 - total2;

        },
        error: function (xhr, status, error) {
            console.error("AJAX 요청 중 오류 발생:", error);
        },
    });
    btnmodal.style.display = 'none';
      return false;
  }
