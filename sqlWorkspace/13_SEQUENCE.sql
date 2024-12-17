/*
    <SEQUENCE>
        정수값을 순차적으로 생성하는 역할을 하는 객체이다.
        
    <SEQUENCE 생성>
        [문법]
            CREATE SEQUNCE 시퀀스명
            [START WITH 숫자]
            [INCREMENT BY 숫자]
            [MAXVALUE 숫자]
            [MINVALUE 숫자]
            [CYCLE | NOCYCLE]
            [CACHE 바이트크기 | NOCACHE]; (기본값 20 바이트)
            
        [사용 구문]
            시퀀스명.CURRVAL : 현재 시퀀스의 값
            시퀀스명.NEXTVAL : 시퀀스 값을 증가시키고 증가된 시퀀스 값
                              (기존 시퀀스 값에서 INCREAMENT 값 만큼 증가된 값)
                              
        * 캐시메모리
          - 미리 다음 값들을 생성해서 저장해둔다.
          - 매번 호출할 때마다 시퀀스 값을 새로 생성을 하는 것이 아닌 캐시 메모리 공간에 미리 생성된 값들을 사용한다.
*/


CREATE SEQUENCE ABC NOCYCLE NOCACHE;

SELECT ABC.NEXTVAL FROM DUAL
;

SELECT ABC.CURRVAL
FROM DUAL
;

DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    NO      NUMBER
    , ID    VARCHAR2(100)
    , PWD   VARCHAR2(100)
);

INSERT INTO MEMBER
(
    NO
    , ID
    , PWD
) 
VALUES
(
    ABC.NEXTVAL
    , 'USER01'
    , '1234'
);

SELECT * FROM MEMBER;

DROP SEQUENCE ABC;
DROP TABLE OLD_EMP;
DROP TABLE NEW_EMP;
DROP TABLE MEMBER;
