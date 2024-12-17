<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>휴가등록</title>
    <link rel="stylesheet" href="/css/overtime/write.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script defer  src="/js/overtime/write.js"></script>

</head>
<body>
    <h1>초과 근무 등록</h1>
    <hr>
    <!-- 모달 구조  test-->
    <div class="test-area">
            <div class="test1">TEST1</div>
        </div>
<div>
        <form action="" method="post" id="overmodal1" class="overmodal1">
            <div class="overmodal1-content">
                <span class="overmodal1-close">&times;</span>
                <div class="overmodal1-title">초과근무 등록 </div>
                <div><span class="title-span" id="overtimespan">*는 필수입력 사항입니다</span></div>
                <div class="overmodal1-cont">
                    <label for="employeeId"><span class="title-span">*</span>사번</label>
                    <div><input type="text" id="employeeId" class="employeeId" name="empNo"> <input type="button" value="사번선택" class="employee-select-btn"></div>
                </div>
                <div class="overmodal1-cont">
                    <label for="name"><span class="title-span">*</span>사원명</label>
                    <input type="text" id="name" name="name" />
                </div>
                <div class="overmodal1-cont" id="department">
                    <label for="position"><span class="title-span">*</span>소속부서</label>
                    <input type="text" name="dname">
                </div>
                <div class="overmodal1-cont">
                    <label for="phone"><span class="title-span">*</span>직급</label>
                    <input type="text" name="pname" />
                </div>
                <div class="overmodal1-cont">
                    <label for="region"><span class="title-span">*</span>초과근무일자 ex)2024-11-26</label>
                    <input type="text" id="region" name="thisDate"/>
                </div>
                <div class="overmodal1-cont">
                    <label for="region"><span class="title-span">*</span>초과근무구분&nbsp;&nbsp;&nbsp;
                        <input type="radio" id="region" name="type" value="주말근무" />주말근무
                        <input type="radio" id="region" name="type" value="야간근무" />야간근무</label>
                </div>
                <div class="overmodal1-cont">
                    <label for="position"><span class="title-span">*</span>초과근무시간
                        <select name="hour" id="overtime-hour">
                            <option value="0">0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                        </select>시
                        <select name="minute" id="overtime-minute">
                            <option value="0">0</option>
                            <option value="30">30</option>
                        </select>분
                    </label>

                </div>
                <div class="overmodal-cont"></div>
                <div></div>
                <div class="btn-area">
                    <div class="button-container"><input type="submit" value="등록"></div>
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