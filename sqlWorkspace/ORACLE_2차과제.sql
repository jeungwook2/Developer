-- # "SEQ_BOARD" , "SEQ_CATEGORY" 시퀀스 삭제
DROP SEQUENCE SEQ_BOARD;
DROP SEQUENCE SEQ_CATEGORY;

-- # "SEQ_BOARD" , "SEQ_CATEGORY" 시퀀스 생성 (캐싱 하지 않도록. 최대값에 도달 후 처음으로 돌아오지 않도록.)
CREATE SEQUENCE SEQ_BOARD NOCYCLE NOCACHE;
CREATE SEQUENCE SEQ_CATEGORY NOCYCLE NOCACHE;

-- # BOARD 테이블 삭제 (외래키 제약조건도 함께 삭제)
DROP TABLE BOARD CASCADE CONSTRAINTS;

-- # BOARD 테이블 생성 (아래 조건 참고)
/*
    NO              숫자타입                    기본키
    , TITLE         가변 문자열 최대 100글자     NULL값 허용하지 않음
    , CONTENT       가변 문자열 최대 4000글자    NULL값 허용하지 않음
    , ENROLL_DATE   시간타입                    기본값은 현재시각
    , DEL_YN        고정 문자열 최대 1글자       Y또는N 둘 중 하나만 입력 가능 , 기본값은 N
    , CATEGORY_NO   숫자타입          
*/
CREATE TABLE BOARD(
    NO              NUMBER                    PRIMARY KEY
    , TITLE         VARCHAR2(100)             NOT NULL
    , CONTENT       VARCHAR2(4000)            NOT NULL
    , ENROLL_DATE   TIMESTAMP                 DEFAULT SYSDATE
    , DEL_YN        CHAR(1)                   DEFAULT 'N' CHECK(DEL_YN IN('Y','N'))
    , CATEGORY_NO   NUMBER          
)
;

-- # BOARD 테이블의 각 컬럼별로 COMMENT 작성 (문구는 자유롭게 작성)
COMMENT ON COLUMN BOARD.NO IS '번호';
COMMENT ON COLUMN BOARD.TITLE IS '제목';
COMMENT ON COLUMN BOARD.CONTENT IS '내용';
COMMENT ON COLUMN BOARD.ENROLL_DATE IS '등록일시';
COMMENT ON COLUMN BOARD.DEL_YN IS '삭제여부';
COMMENT ON COLUMN BOARD.CATEGORY_NO IS '카테고리 번호';

-- # CATEGORY 테이블 삭제 (외래키 제약조건도 함께 삭제)
DROP TABLE CATEGORY CASCADE CONSTRAINTS;

-- # CATEGORY 테이블 생성 (아래 조건 참고)
/*
    NO          숫자타입                  기본키
    , NAME      가변 문자열 최대 100글자     중복불허, NULL불허
*/
CREATE TABLE CATEGORY(
    NO          NUMBER          PRIMARY KEY
    , NAME      VARCHAR2(100)   UNIQUE NOT NULL
)
;

-- # CATEGORY 테이블의 각 컬럼별로 COMMENT 작성 (문구는 자유롭게 작성)
COMMENT ON COLUMN CATEGORY.NO IS '카테고리 번호';
COMMENT ON COLUMN CATEGORY.NAME IS '카테고리 이름';

-- # 테이블에 외래키 추가 (BOARD 테이블의 CATEGORY_NO 컬럼이 CATEGORY 테이블의 기본키를 참조하도록)
ALTER TABLE BOARD ADD CONSTRAINT FK_BOARD_CATEGORY FOREIGN KEY(CATEGORY_NO) REFERENCES CATEGORY;

-- # 카테고리 5개 등록하기 ("NO"컬럼은 시퀀스 사용)
/*
    1 : JAVA
    2 : ORACLE
    3 : HTML
    4 : CSS
    5 : JavaScript
*/
INSERT INTO CATEGORY (NO, NAME) VALUES (SEQ_CATEGORY.NEXTVAL, 'JAVA');
INSERT INTO CATEGORY (NO, NAME) VALUES (SEQ_CATEGORY.NEXTVAL, 'ORACLE');
INSERT INTO CATEGORY (NO, NAME) VALUES (SEQ_CATEGORY.NEXTVAL, 'HTML');
INSERT INTO CATEGORY (NO, NAME) VALUES (SEQ_CATEGORY.NEXTVAL, 'CSS');
INSERT INTO CATEGORY (NO, NAME) VALUES (SEQ_CATEGORY.NEXTVAL, 'JavaScript');


-- # 트랜잭션 처리(변경사항 저장)
COMMIT;

-- # 작성하기(NO컬럼은 시퀀스 사용 , 외래키 주의)
INSERT INTO BOARD (NO, TITLE, CONTENT, CATEGORY_NO) 
VALUES (SEQ_BOARD.NEXTVAL, '자바 함수', '많이쓰는거 뭐있음', '1');

INSERT INTO BOARD (NO, TITLE, CONTENT, CATEGORY_NO) 
VALUES (SEQ_BOARD.NEXTVAL, '오라클 함수', '많이쓰는거 뭐있음', '2');

INSERT INTO BOARD (NO, TITLE, CONTENT, CATEGORY_NO) 
VALUES (SEQ_BOARD.NEXTVAL, '함수', '많이쓰는거 뭐있음', NULL);

-- # 수정하기(제목수정 , NO칼럼 이용하여 행 식별하기)
UPDATE BOARD
    SET
        TITLE = '자바 컬렉션'
WHERE NO = '1';

-- # 수정하기(내용)
UPDATE BOARD
    SET
        CONTENT = 'LIST, SET, MAP 등등'
WHERE NO = '1';

-- # NO칼럼 이용하여 삭제하기(UPDATE 쿼리로 DEL_YN 컬럼 이용하여 처리할 것)
UPDATE BOARD
    SET
        DEL_YN = 'Y'
WHERE NO = '1';

-- # 목록조회 (결과집합 출력헤더에 "카테고리이름" 나오도록),(카테고리가 없는 글도 나오도록),(최신글 먼저)
SELECT B.*, NVL(C.NAME, '카테고리 없음') AS 카테고리이름
FROM BOARD B
LEFT JOIN CATEGORY C ON (B.CATEGORY_NO = C.NO)
ORDER BY ENROLL_DATE DESC
;

-- # 검색하기(제목+내용) //제목이나 내용에 해당 글자가 포함되면 조회
SELECT *
FROM BOARD
WHERE (TITLE LIKE '%함수%'
OR CONTENT LIKE '%함수%')
AND DEL_YN = 'N'
;

-- # 트랜잭션 처리(변경사항 되돌리기)
ROLLBACK;