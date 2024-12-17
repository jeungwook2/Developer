-- DQL(SELECT)

/*
    [문법]
        SELECT 컬럼, 컬럼, ...
        FROM 테이블명;
        
        
    - SELECT 절에는 "컬럼명", "리터럴" 작성 가능
    - SELECT 절에서 연산자 사용 가능
    
    - 별칭 지정
*/

SELECT SALARY * 12  "직원연봉"
FROM EMPLOYEE;

/*
    DISTINCT
        중복 값을 한번씩만 표시
        
    SELECT 절에 한번만 작성 가능
    여러개 컬럼 작성 가능 (모든 컬럼이 동일해야 중복으로 판단)
*/
SELECT DISTINCT JOB_CODE, DEPT_CODE
FROM EMPLOYEE;


/*
    연결 연산자 : 컬럼 또는 리터럴을 연결
*/

SELECT EMP_NAME || '의 월급은' || SALARY || '원 입니다.'
FROM EMPLOYEE;

/*
    WHERE 절
        [문법]
            SELECT 컬럼, 컬럼...
            FROM 테이블명
            WHERE 조건식;
*/

SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = 'D1'
;

-- EMPLOYEE 테이블에서 부서 코드가 D9와 일치하는 사원들의 모든 컬럼 정보 조회
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9'
;

-- EMPLOYEE 테이블에서 부서 코드가 D9가 아닌 사원들의 사번, 사원명, 부서 코드 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE != 'D9'
;

-- EMPLOYEE 테이블에서 연봉이 5000만원 이상인 직원들의 직원명, 부서 코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY, SALARY * 12 AS 연봉
FROM EMPLOYEE
WHERE SALARY * 12 >= 50000000
;

-- EMPLOYEE 테이블에서 부서 코드가 D6이면서 직급코드가 J3인 사원의 모든컬럼 조회
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6' 
AND JOB_CODE = 'J3'
;

-- EMPLOYEE 테이블에서 급여가 350만원 이상 600만원 이하를 받는 직원의 모든컬럼 조회
SELECT *
FROM EMPLOYEE
WHERE SALARY >= 3500000
AND SALARY <= 6000000
;

/*
    <BETWEEN A AND B>
        [문법]
            WHERE 비교대상컬럼 BETWEEN 하한값 AND 상한값
*/

SELECT *
FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000
;

/*
    <LIKE>
        [문법]
            WHERE 비교대상칼럼 LIKE '특정 패턴';
            
        - 비교하려는 칼럼 값이 지정된 특정 패턴에 만족할 경우 TRUE를 리턴한다.
        - 특정 패턴에는 '%', '_'를 와일드카드로 사용할 수 있다.
          '%' : 0글자 이상
            ex) 비교대상칼럼 LIKE '문자%'  => 비교대상칼럼 값 중에 '문자'로 시작하는 모든 행을 조회한다.
                비교대상칼럼 LIKE '%문자'  => 비교대상칼럼 값 중에 '문자'로 끝나는 모든 행을 조회한다.
                비교대상칼럼 LIKE '%문자%' => 비교대상칼럼 값 중에 '문자'가 포함되어 있는 모든 행을 조회한다.
                
          '_' : 1글자
            ex) 비교대상칼럼 LIKE '_문자'  => 비교대상칼럼 값 중에 '문자'앞에 무조건 한 글자가 오는 모든 행을 조회한다.
                비교대상칼럼 LIKE '__문자' => 비교대상칼럼 값 중에 '문자'앞에 무조건 두 글자가 오는 모든 행을 조회한다.
*/

-- EMPLOYEE 테이블에서 성이 전 씨인 사원의 사원명, 급여 조회
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '전%'
;

-- EMPLOYEE 테이블에서 이름 중에 '하'가 포함된 사원의 모든컬럼 조회
SELECT *
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%'
;

-- EMPLOYEE 테이블에서 전화번호 4번째 자리가 9로 시작하는 사원의 모든컬럼 조회
SELECT *
FROM EMPLOYEE
WHERE PHONE LIKE '___9%'
;

-- EMPLOYEE 테이블에서 이메일 중 _ 앞 글자가 3자리인 이메일 주소를 가진 사원의 모든컬럼 조회
SELECT *
FROM EMPLOYEE
WHERE EMAIL LIKE '___\_%' ESCAPE '\'
;

-- EMPLOYEE 테이블에서 김씨 성이 아닌 사원의 모든컬럼 조회
SELECT *
FROM EMPLOYEE
WHERE EMP_NAME NOT LIKE '김%'
;

/*
    IS NULL / IS NOT NULL
*/

SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
;

/*
    IN
*/

SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D1', 'D2', 'D3')
--WHERE DEPT_CODE = 'D1'
--OR DEPT_CODE = 'D2'
--OR DEPT_CODE = 'D3'
;

/*
    <연산자 우선순위>
        0. ()
        1. 산술 연산자
        2. 연결 연산자
        3. 비교 연산자
        4. IS NULL, LIKE, IN
        5. BETWEEN AND
        6. 논리 연산자 - NOT
        7. 논리 연산자 - AND
        8. 논리 연산자 - OR
*/

/*
    ORDER BY
*/

SELECT *
FROM EMPLOYEE
ORDER BY SALARY ASC, EMP_ID DESC
--ORDER BY SALARY DESC
;

-- 1. EMPLOYEE 테이블에서 사번, 사원명, 급여를 연결해서 조회
SELECT EMP_ID || EMP_NAME || SALARY
FROM EMPLOYEE
;

-- 2. EMPLOYEE 테이블에서 사원명, 급여를 리터럴과 연결해서 조회
SELECT EMP_NAME || SALARY AS 사원급여
FROM EMPLOYEE
;

-- 3. EMPLOYEE 테이블에서 재직 중(ENT_YN 컬럼 값이 'N')인 직원들의 사번, 이름, 입사일 조회 
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE ENT_YN = 'N'
;

-- 4. EMPLOYEE 테이블에서 연봉이 5000이상인 직원의 직원명, 급여, 연봉, 입사일 조회
SELECT EMP_NAME, SALARY, SALARY * 12 AS 연봉, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY * 12 >= 50000000
;

-- 5. EMPLOYEE 테이블에서 전화번호 처음 3자리가 010이 아닌 사원의 이름, 전화번호 조회
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%'
;

-- 6. DEPARTMENT 테이블에서 해외영업부에 대한 모든 컬럼 조회
SELECT *
FROM DEPARTMENT
WHERE DEPT_TITLE LIKE '해외영업%'
;

-- 7. EMPLOYEE 테이블에서 BONUS로 오름차순 정렬
SELECT *
FROM EMPLOYEE
ORDER BY BONUS ASC
;

-- 8. EMPLOYEE 테이블에서 BONUS로 내림차순 정렬(단, BONUS 값이 일치할 경우 그때는 SALARY 가지고 오름차순정렬)
SELECT *
FROM EMPLOYEE
ORDER BY BONUS DESC, SALARY ASC
;

-- 9. EMPLOYEE 테이블에서 연봉별 내림차순으로 정렬된 사원의 사원명, 연봉 조회
SELECT EMP_NAME, SALARY * 12 AS 연봉
FROM EMPLOYEE
ORDER BY 연봉 DESC
;