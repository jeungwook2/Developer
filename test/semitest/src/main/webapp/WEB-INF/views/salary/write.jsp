<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>휴가등록</title>
    <link rel="stylesheet" href="/css/salary/write.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script defer  src="/js/salary/write.js"></script>

</head>
<body>
    <h1>급여 등록</h1>
    <hr>

   <!-- 모달 구조 -->
    <div>
           <div class="test4">TEST</div>
       </div>
       <div id="salarymodal" class="salarymodal">
           <form action="" method="post">
           <div class="salarymodal-content">
               <span class="salarymodal-close">&times;</span>
               <div class="salarymodal-first">
                   <div class="salarymodal-title">급여 등록</div>
                   <div class="salarymodal-subtitle">기본정보
                       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                       <span class="title-span">*는 필수입력 사항입니다</span></div>

                   <div class="salarymodal-cont">
                       <label class="salarylabel"><span class="title-span">*</span>사번</label>
                       <div><input type="text" id="employeeId" class="employeeId" name="empNo"> <input type="button" value="사번선택" class="employee-select-btn"></div>
                       </button>
                   </div>
                   <div class="salarymodal-cont">
                       <label class="salarylabel"><span class="title-span">*</span>사원명</label>
                       <input type="text" id="price" name ="name" />
                   </div>
                   <div class="salarymodal-cont">
                       <label class="salarylabel"><span class="title-span">*</span>소속부서</label>
                        <input type="text" id="price" name ="dname"/>
                   </div>
                   <div class="salarymodal-cont">
                       <label class="salarylabel"><span class="title-span">*</span>직급</label>
                       <input type="text" id="price" name="pname" />
                   </div>
                   <div class="salarymodal-cont">
                       <label class="salarylabel">연봉</label>
                       <input type="text" id="price" name="salary"/>
                   </div>




               </div>
               <div class="salarymodal-second">
                   <div class="salarymodal-subtitle">지급정보</div>
                   <div class="salarymodal-cont">
                       <label class="salarylabel"><span class="title-span">*</span>지급연월  ex)2024-06</label>
                       <input type="text" id="price" name="payYearmonth" />
                   </div>
                   <div class="salarymodal-cont">
                       <label class="salarylabel">기본급</label>
                       <input type="text" id="price" name="basic" />
                   </div>
                   <div class="salarymodal-cont">
                       <label class="salarylabel"><span class="title-span">*</span>식대</label>
                       <input type="text" id="price" name="mealAllowance" value="200000" />
                   </div>
                   <div class="salarymodal-cont">
                       <label class="salarylabel"><span class="title-span">*</span>통신비</label>
                       <input type="text" id="price" name ="communicationCost" value="50000"/>
                   </div>
                   <div class="salarymodal-cont">
                       <label class="salarylabel"><span class="title-span">*</span>지급총액</label>
                       <input type="text" id="price" name ="payment"/>
                   </div>
               </div>

               <div class="salarymodal-third">
                   <div class="salarymodal-subtitle">공제정보</div>
                   <div class="salarymodal-cont">
                       <label class="salarylabel"><span class="title-span">*</span>국민연금</label>
                       <input type="text" id="price" name ="nationalPension" />
                   </div>
                   <div class="salarymodal-cont">
                       <label class="salarylabel"><span class="title-span">*</span>건강보험</label>
                       <input type="text" id="price" name ="healthInsurance" />
                   </div>
                   <div class="salarymodal-cont">
                       <label class="salarylabel"><span class="title-span">*</span>고용보험</label>
                       <input type="text" id="price" name="employmentInsurance" />
                   </div>
                   <div class="salarymodal-cont">
                       <label class="salarylabel"><span class="title-span">*</span>장기요양보험료</label>
                       <input type="text" id="price" name ="longtermCareInsurance"/>
                   </div>
                   <div class="salarymodal-cont">
                       <label class="salarylabel"><span class="title-span">*</span>소득세</label>
                       <input type="text" id="price" name ="incomeTax"/>
                   </div>
                   <div class="salarymodal-cont">
                       <label class="salarylabel"><span class="title-span">*</span>지방소득세</label>
                       <input type="text" id="price" name="localTaxes" />
                   </div>
                   <div class="salarymodal-cont">
                       <label class="salarylabel">공제총액</label>
                       <input type="text" id="price" name="deductions" />
                   </div>

                   <div class="salarymodal-cont">
                       <label class="salarylabel">실지급액</label>
                       <input type="text" id="price" name="netPayment" />
                   </div>
                   <div></div>
                   <div class="salarymodal-cont">
                       <input type="submit" value="등록" />

                   </div>

               </div>
           </div>
       </form>
       </div>
        <div>
                <form action="" method="post" id="btnmodal" class="btnmodal">
                    <div class="btnmodal-content">
                        <span class="btnmodal-close">&times;</span>
                        <div class="btnmodal-title">사원번호 조회</div>


                        <div class="btnmodal-main">
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>사번</th>
                                        <th>사원명</th>
                                        <th>소속</th>
                                        <th>직급</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="vo" items="${empVoList}">
                                        <tr>
                                        <td><a href="#" id="empNo_${vo.no}" onclick="changeEmpNo(this);">${vo.no}</a></td>
                                        <td>${vo.name}</td>
                                        <td>${vo.dname}</td>
                                        <td>${vo.pname}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>



                        <div class="btnmodal-cont"></div>
                        <div class="btn-area">
                            <div class="button-container"><button>선택</button></div>
                        </div>
                    </div>
                </form>
            </div>


    </form>
</body>
</html>