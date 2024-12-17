-- 세미플젝 주요기능 SQL

------------------------
-- MEMBER
------------------------

--회원가입
INSERT INTO MEMBER
(
    NO
    ,ID
    ,PWD
    ,NICK
)
VALUES
(
    SEQ_MEMBER.NEXTVAL
    , ?
    , ?
    , ?
)
;


--로그인
SELECT 
    NO
    ,ID
    ,PWD
    ,NICK
    ,DEL_YN
    ,ENROLL_DATE
    ,MODIFY_DATE
FROM MEMBER
WHERE ID = ?
AND PWD = ?
AND DEL_YN = 'N'
;

--회원정보 수정 (비밀번호,닉네임)
UPDATE MEMBER
    SET
        MODIFY_DATE = SYSDATE
        , PWD = ?
        , NICK = ?
    WHERE NO = ?
;

-- 회원 조회 (번호)
SELECT
    NO
    ,ID
    ,PWD
    ,NICK
    ,DEL_YN
    ,ENROLL_DATE
    ,MODIFY_DATE
FROM MEMBER
WHERE NO = ?
AND DEL_YN = 'N'
;


-- 회원탈퇴
UPDATE MEMBER
    SET 
        DEL_YN = 'Y'
    WHERE NO = ?
    AND PWD = ?
;

-- 아이디 중복 검사
SELECT *
FROM MEMBER
WHERE ID = ?
;

------------------------
-- BOARD
------------------------

-- 게시글 작성
INSERT INTO BOARD
(
    NO
    ,TITLE
    ,CONTENT
    ,CATEGORY_NO
    ,WRITER_NO
)
VALUES
(
    SEQ_BOARD.NEXTVAL
    , '222테스트 제목 ㅋㅋ'
    , '222테스트 내용 ㅎㅎ'
    , '1'
    , 1
)
;


-- 게시글 목록조회
SELECT 
    B.NO
    ,B.TITLE
    ,B.CONTENT
    ,B.CATEGORY_NO
    ,B.WRITER_NO
    ,B.HIT
    ,B.CREATE_DATE
    ,B.DEL_YN
    ,M.NICK AS WRITER_NICK
    ,C.NAME AS CATEGORY_NAME
FROM BOARD B
JOIN MEMBER M ON (B.WRITER_NO = M.NO)
JOIN CATEGORY C ON (B.CATEGORY_NO = C.NO)
WHERE B.DEL_YN = 'N'
ORDER BY B.NO DESC
;

-- 게시글 첨부파일 추가
INSERT ALL
INTO BOARD_ATTACHMENT (NO,REF_NO,CHANGE_NAME) VALUES((SELECT GET_BOARD_ATTACHMENT_NO FROM DUAL), SEQ_BOARD.CURRVAL, ?)
;

-- 첨부파일 시퀀스 값 얻기
SELECT GET_BOARD_ATTACHMENT_NO FROM DUAL
;



------------------------
-- NOTICE
------------------------

-- 공지사항 작성
INSERT INTO NOTICE
(
    NO
    ,TITLE
    ,CONTENT
    ,WRITER_NO
)
VALUES
(
    SEQ_NOTICE.NEXTVAL
    , '공지사항제목33333ㅋㅋㅋ'
    , '공지내용3333ㅋㅋㅋ'
    , 1
)
;


-- 공지사항 목록조회
SELECT 
    N.NO
    ,N.TITLE
    ,N.CONTENT
    ,N.WRITER_NO
    ,N.HIT
    ,N.CREATE_DATE
    ,N.DEL_YN
    ,A.NICK AS WRITER_NICK
FROM NOTICE N
JOIN ADMIN A ON (N.WRITER_NO = A.NO)
WHERE N.DEL_YN = 'N'
ORDER BY N.NO DESC
OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY
;


-- 공지사항 갯수
SELECT COUNT(*)
FROM NOTICE
WHERE DEL_YN = 'N'
;


--공지사항 조회
SELECT * FROM NOTICE WHERE DEL_YN='N';
-- 공지사항 상세조회 
SELECT 
    N.NO
    ,N.TITLE
    ,N.CONTENT
    ,N.WRITER_NO
    ,N.HIT
    ,N.CREATE_DATE
    ,N.DEL_YN
    ,A.NICK AS WRITER_NICK
FROM NOTICE N
JOIN ADMIN A ON (N.WRITER_NO = A.NO)
WHERE N.NO = #{no}
AND N.DEL_YN = 'N'
;

--공지사항 삭제

UPDATE NOTICE
SET DEL_YN = 'N';

ROLLBACK;
--공지사항 수정하기

UPDATE NOTICE
SET TITLE = '공지사항',
CONTENT = '실제상황'
WHERE NO = 
AND DEL_YN='N'
AND WRITER_NO = ?
;

---공지사항 댓글 작성하기
INSERT INTO NOTICE_REPLY(
        NO,
        CONTENT,
        REF_NO,
        WRITER_NO
)VALUES(
        SEQ_NOTICE_REPLY.NEXTVAL,
        ?,
        ?,
        ?
        );
----공지사항 댓글 조회

SELECT 
    N.NO,
    N.CONTENT,
    N.REF_NO,
    N.WRITER_NO,
    M.NICK,
    N.CREATE_DATE,
    N.DEL_YN
FROM NOTICE_REPLY N
JOIN MEMBER M ON(N.WRITER_NO = M.NO)
WHERE N.REF_NO = 66
AND N.DEL_YN ='N';

--- 공지사항 댓글 목록조회하기

