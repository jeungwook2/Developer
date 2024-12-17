-- 사용자 계정 생성
/*
    [문법]
    
    * 계정 생성
    CREATE USER 계정명 IDENTIFIED BY 비밀번호;
    
    * 계정 삭제
    DROP USER 계정명
    
    * 권한 부여
    GRANT 권한1, 권한2, ... TO 계정명;
    
    * 권한 제거
    REVOKE
*/

-- 삭제
DROP USER C##KH;

-- 생성
CREATE USER C##KH IDENTIFIED BY 1234;

-- 권한부여
GRANT CONNECT, RESOURCE, CREATE VIEW TO C##KH;

-- 테이블 스페이스 수정(INSERT를 위한 설정)
ALTER USER C##KH DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
