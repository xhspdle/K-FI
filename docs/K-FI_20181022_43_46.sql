﻿-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

-- MEMBERS Table Create SQL
CREATE TABLE MEMBERS
(
    USER_NUM         NUMBER          NOT NULL, 
    USER_ID          VARCHAR2(20)    NULL, 
    USER_NICKNAME    VARCHAR2(20)    NULL, 
    USER_PWD         VARCHAR2(20)    NULL, 
    USER_EMAIL       VARCHAR2(30)    NULL, 
    USER_REGDATE     DATE            NULL, 
    USER_STATUS      NUMBER          NULL, 
    CONSTRAINT MEMBERS_PK PRIMARY KEY (USER_NUM)
)
/

COMMENT ON TABLE MEMBERS IS '사용자'
/

COMMENT ON COLUMN MEMBERS.USER_NUM IS '유저번호'
/

COMMENT ON COLUMN MEMBERS.USER_ID IS '아이디'
/

COMMENT ON COLUMN MEMBERS.USER_NICKNAME IS '닉네임'
/

COMMENT ON COLUMN MEMBERS.USER_PWD IS '비밀번호'
/

COMMENT ON COLUMN MEMBERS.USER_EMAIL IS '이메일'
/

COMMENT ON COLUMN MEMBERS.USER_REGDATE IS '가입일'
/

COMMENT ON COLUMN MEMBERS.USER_STATUS IS '아이디상태'
/


-- COMM_SKIN Table Create SQL
CREATE TABLE COMM_SKIN
(
    CS_NUM      NUMBER          NOT NULL, 
    COMM_NUM    NUMBER          NULL, 
    CS_NAME     VARCHAR2(20)    NULL, 
    CS_COLOR    VARCHAR2(20)    NULL, 
    CS_USING    NUMBER          NULL, 
    CONSTRAINT COMM_SKIN_PK PRIMARY KEY (CS_NUM)
)
/

COMMENT ON TABLE COMM_SKIN IS '모임스킨'
/

COMMENT ON COLUMN COMM_SKIN.CS_NUM IS '스킨번호'
/

COMMENT ON COLUMN COMM_SKIN.COMM_NUM IS '모임번호'
/

COMMENT ON COLUMN COMM_SKIN.CS_NAME IS '스킨이름'
/

COMMENT ON COLUMN COMM_SKIN.CS_COLOR IS '컬러코드'
/

COMMENT ON COLUMN COMM_SKIN.CS_USING IS '사용상태(1/0)'
/


-- COMMUNITY Table Create SQL
CREATE TABLE COMMUNITY
(
    COMM_NUM        NUMBER          NOT NULL, 
    USER_NUM        NUMBER          NULL, 
    COMM_NAME       VARCHAR2(20)    NULL, 
    COMM_CONTENT    VARCHAR2(30)    NULL, 
    COMM_REGDATE    DATE            NULL, 
    CONSTRAINT COMMUNITY_PK PRIMARY KEY (COMM_NUM)
)
/

COMMENT ON TABLE COMMUNITY IS '유저모임'
/

COMMENT ON COLUMN COMMUNITY.COMM_NUM IS '모임번호'
/

COMMENT ON COLUMN COMMUNITY.USER_NUM IS '관리자번호'
/

COMMENT ON COLUMN COMMUNITY.COMM_NAME IS '모임명'
/

COMMENT ON COLUMN COMMUNITY.COMM_CONTENT IS '모임소개'
/

COMMENT ON COLUMN COMMUNITY.COMM_REGDATE IS '개설일'
/

ALTER TABLE COMMUNITY
    ADD CONSTRAINT FK_COMMUNITY_USER_NUM_MEMBERS_ FOREIGN KEY (USER_NUM)
        REFERENCES MEMBERS (USER_NUM)
/

ALTER TABLE COMMUNITY
    ADD CONSTRAINT FK_COMMUNITY_COMM_NUM_COMM_SKI FOREIGN KEY (COMM_NUM)
        REFERENCES COMM_SKIN (COMM_NUM)
/


-- COMM_BOARD Table Create SQL
CREATE TABLE COMM_BOARD
(
    CB_NUM        NUMBER            NOT NULL, 
    COMM_NUM      NUMBER            NULL, 
    CB_TITLE      VARCHAR2(20)      NULL, 
    CB_CONTENT    VARCHAR2(1000)    NULL, 
    CB_DATE       DATE              NULL, 
    CB_NOTICE     NUMBER            NULL, 
    CB_VIEWS      NUMBER            NULL, 
    CONSTRAINT COMM_BOARD_PK PRIMARY KEY (CB_NUM)
)
/

COMMENT ON TABLE COMM_BOARD IS '모임게시판'
/

COMMENT ON COLUMN COMM_BOARD.CB_NUM IS '모임글번호'
/

COMMENT ON COLUMN COMM_BOARD.COMM_NUM IS '모임번호'
/

COMMENT ON COLUMN COMM_BOARD.CB_TITLE IS '모임글제목'
/

COMMENT ON COLUMN COMM_BOARD.CB_CONTENT IS '모임글내용'
/

COMMENT ON COLUMN COMM_BOARD.CB_DATE IS '모임글작성일'
/

COMMENT ON COLUMN COMM_BOARD.CB_NOTICE IS '공지사항'
/

COMMENT ON COLUMN COMM_BOARD.CB_VIEWS IS '조회수'
/

ALTER TABLE COMM_BOARD
    ADD CONSTRAINT FK_COMM_BOARD_COMM_NUM_COMMUNI FOREIGN KEY (COMM_NUM)
        REFERENCES COMMUNITY (COMM_NUM)
/


-- MY_BOARD Table Create SQL
CREATE TABLE MY_BOARD
(
    MB_NUM        NUMBER            NOT NULL, 
    USER_NUM      NUMBER            NULL, 
    MB_TITLE      VARCHAR2(20)      NULL, 
    MB_CONTENT    VARCHAR2(1000)    NULL, 
    MB_DATE       DATE              NULL, 
    MB_VIEWS      NUMBER            NULL, 
    CONSTRAINT MY_BOARD_PK PRIMARY KEY (MB_NUM)
)
/

COMMENT ON TABLE MY_BOARD IS '개인게시판'
/

COMMENT ON COLUMN MY_BOARD.MB_NUM IS '개인글번호'
/

COMMENT ON COLUMN MY_BOARD.USER_NUM IS '유저번호'
/

COMMENT ON COLUMN MY_BOARD.MB_TITLE IS '글제목'
/

COMMENT ON COLUMN MY_BOARD.MB_CONTENT IS '글내용'
/

COMMENT ON COLUMN MY_BOARD.MB_DATE IS '작성일'
/

COMMENT ON COLUMN MY_BOARD.MB_VIEWS IS '조회수'
/

ALTER TABLE MY_BOARD
    ADD CONSTRAINT FK_MY_BOARD_USER_NUM_MEMBERS_U FOREIGN KEY (USER_NUM)
        REFERENCES MEMBERS (USER_NUM)
/


-- TAG Table Create SQL
CREATE TABLE TAG
(
    TAG_NUM     NUMBER          NOT NULL, 
    TAG_NAME    VARCHAR2(20)    NULL, 
    CONSTRAINT TAG_PK PRIMARY KEY (TAG_NUM)
)
/

COMMENT ON TABLE TAG IS '태그'
/

COMMENT ON COLUMN TAG.TAG_NUM IS '태그번호'
/

COMMENT ON COLUMN TAG.TAG_NAME IS '태그명'
/


-- MY_SKIN Table Create SQL
CREATE TABLE MY_SKIN
(
    MS_NUM      NUMBER           NOT NULL, 
    USER_NUM    NUMBER           NULL, 
    MS_NAME     VARCHAR2(20)     NULL, 
    MS_COLOR    VARCHAR2(20)     NULL, 
    MS_MSG      VARCHAR2(100)    NULL, 
    MS_USING    NUMBER           NULL, 
    CONSTRAINT MY_SKIN_PK PRIMARY KEY (MS_NUM)
)
/

COMMENT ON TABLE MY_SKIN IS '개인스킨'
/

COMMENT ON COLUMN MY_SKIN.MS_NUM IS '스킨번호'
/

COMMENT ON COLUMN MY_SKIN.USER_NUM IS '유저번호'
/

COMMENT ON COLUMN MY_SKIN.MS_NAME IS '스킨이름'
/

COMMENT ON COLUMN MY_SKIN.MS_COLOR IS '컬러코드'
/

COMMENT ON COLUMN MY_SKIN.MS_MSG IS '상태메세지'
/

COMMENT ON COLUMN MY_SKIN.MS_USING IS '사용상태(1/0)'
/

ALTER TABLE MY_SKIN
    ADD CONSTRAINT FK_MY_SKIN_USER_NUM_MEMBERS_US FOREIGN KEY (USER_NUM)
        REFERENCES MEMBERS (USER_NUM)
/


-- ADMIN Table Create SQL
CREATE TABLE ADMIN
(
    ADMIN_NUM        NUMBER          NOT NULL, 
    ADMIN_ID         VARCHAR2(20)    NULL, 
    ADMIN_PWD        VARCHAR2(20)    NULL, 
    ADMIN_EMAIL      VARCHAR2(20)    NULL, 
    ADMIN_REGDATE    DATE            NULL, 
    CONSTRAINT ADMIN_PK PRIMARY KEY (ADMIN_NUM)
)
/

COMMENT ON TABLE ADMIN IS '관리자'
/

COMMENT ON COLUMN ADMIN.ADMIN_NUM IS '관리자번호'
/

COMMENT ON COLUMN ADMIN.ADMIN_ID IS '아이디'
/

COMMENT ON COLUMN ADMIN.ADMIN_PWD IS '비밀번호'
/

COMMENT ON COLUMN ADMIN.ADMIN_EMAIL IS '이메일'
/

COMMENT ON COLUMN ADMIN.ADMIN_REGDATE IS '등록일'
/


-- COMM_VOTE Table Create SQL
CREATE TABLE COMM_VOTE
(
    VOTE_NUM      NUMBER           NOT NULL, 
    CB_NUM        NUMBER           NULL, 
    VOTE_TITLE    VARCHAR2(20)     NULL, 
    VOTE_INFO     VARCHAR2(100)    NULL, 
    VOTE_BEGIN    DATE             NULL, 
    VOTE_END      DATE             NULL, 
    CONSTRAINT COMM_VOTE_PK PRIMARY KEY (VOTE_NUM)
)
/

COMMENT ON TABLE COMM_VOTE IS '모임투표'
/

COMMENT ON COLUMN COMM_VOTE.VOTE_NUM IS '투표번호'
/

COMMENT ON COLUMN COMM_VOTE.CB_NUM IS '모임글번호'
/

COMMENT ON COLUMN COMM_VOTE.VOTE_TITLE IS '투표제목'
/

COMMENT ON COLUMN COMM_VOTE.VOTE_INFO IS '투표설명'
/

COMMENT ON COLUMN COMM_VOTE.VOTE_BEGIN IS '시작일'
/

COMMENT ON COLUMN COMM_VOTE.VOTE_END IS '마감일'
/

ALTER TABLE COMM_VOTE
    ADD CONSTRAINT FK_COMM_VOTE_CB_NUM_COMM_BOARD FOREIGN KEY (CB_NUM)
        REFERENCES COMM_BOARD (CB_NUM)
/


-- COMM_CALENDAR Table Create SQL
CREATE TABLE COMM_CALENDAR
(
    CC_NUM      NUMBER           NOT NULL, 
    COMM_NUM    NUMBER           NULL, 
    CC_NAME     VARCHAR2(20)     NULL, 
    CC_INFO     VARCHAR2(500)    NULL, 
    CC_BEGIN    DATE             NULL, 
    CC_END      DATE             NULL, 
    CONSTRAINT COMM_CALENDAR_PK PRIMARY KEY (CC_NUM)
)
/

COMMENT ON TABLE COMM_CALENDAR IS '모임일정'
/

COMMENT ON COLUMN COMM_CALENDAR.CC_NUM IS '모임일정번호'
/

COMMENT ON COLUMN COMM_CALENDAR.COMM_NUM IS '모임번호'
/

COMMENT ON COLUMN COMM_CALENDAR.CC_NAME IS '일정이름'
/

COMMENT ON COLUMN COMM_CALENDAR.CC_INFO IS '일정설명'
/

COMMENT ON COLUMN COMM_CALENDAR.CC_BEGIN IS '모임시작일'
/

COMMENT ON COLUMN COMM_CALENDAR.CC_END IS '모임종료일'
/

ALTER TABLE COMM_CALENDAR
    ADD CONSTRAINT FK_COMM_CALENDAR_COMM_NUM_COMM FOREIGN KEY (COMM_NUM)
        REFERENCES COMMUNITY (COMM_NUM)
/


-- COMM_USER_LIST Table Create SQL
CREATE TABLE COMM_USER_LIST
(
    CUL_NUM       NUMBER    NOT NULL, 
    COMM_NUM      NUMBER    NULL, 
    USER_NUM      NUMBER    NULL, 
    CUL_STATUS    NUMBER    NULL, 
    CONSTRAINT COMM_USER_LIST_PK PRIMARY KEY (CUL_NUM)
)
/

COMMENT ON TABLE COMM_USER_LIST IS '모임유저목록'
/

COMMENT ON COLUMN COMM_USER_LIST.CUL_NUM IS '모임유저번호'
/

COMMENT ON COLUMN COMM_USER_LIST.COMM_NUM IS '모임번호'
/

COMMENT ON COLUMN COMM_USER_LIST.USER_NUM IS '유저번호'
/

COMMENT ON COLUMN COMM_USER_LIST.CUL_STATUS IS '처리상태'
/

ALTER TABLE COMM_USER_LIST
    ADD CONSTRAINT FK_COMM_USER_LIST_COMM_NUM_COM FOREIGN KEY (COMM_NUM)
        REFERENCES COMMUNITY (COMM_NUM)
/

ALTER TABLE COMM_USER_LIST
    ADD CONSTRAINT FK_COMM_USER_LIST_USER_NUM_MEM FOREIGN KEY (USER_NUM)
        REFERENCES MEMBERS (USER_NUM)
/


-- MY_COMMENT Table Create SQL
CREATE TABLE MY_COMMENT
(
    MYC_NUM        NUMBER           NOT NULL, 
    MB_NUM         NUMBER           NULL, 
    USER_NUM       NUMBER           NULL, 
    MYC_CONTENT    VARCHAR2(500)    NULL, 
    MYC_DATE       DATE             NULL, 
    CONSTRAINT MY_COMMENT_PK PRIMARY KEY (MYC_NUM)
)
/

COMMENT ON TABLE MY_COMMENT IS '개인댓글'
/

COMMENT ON COLUMN MY_COMMENT.MYC_NUM IS '댓글번호'
/

COMMENT ON COLUMN MY_COMMENT.MB_NUM IS '개인글번호'
/

COMMENT ON COLUMN MY_COMMENT.USER_NUM IS '유저번호'
/

COMMENT ON COLUMN MY_COMMENT.MYC_CONTENT IS '댓글내용'
/

COMMENT ON COLUMN MY_COMMENT.MYC_DATE IS '댓글작성일'
/

ALTER TABLE MY_COMMENT
    ADD CONSTRAINT FK_MY_COMMENT_MB_NUM_MY_BOARD_ FOREIGN KEY (MB_NUM)
        REFERENCES MY_BOARD (MB_NUM)
/

ALTER TABLE MY_COMMENT
    ADD CONSTRAINT FK_MY_COMMENT_USER_NUM_MEMBERS FOREIGN KEY (USER_NUM)
        REFERENCES MEMBERS (USER_NUM)
/


-- COMM_COMMENT Table Create SQL
CREATE TABLE COMM_COMMENT
(
    COMMC_NUM        NUMBER           NOT NULL, 
    CB_NUM           NUMBER           NULL, 
    USER_NUM         NUMBER           NULL, 
    COMMC_CONTENT    VARCHAR2(500)    NULL, 
    COMMC_DATE       DATE             NULL, 
    COMMC_LIKE       NUMBER           NULL, 
    CONSTRAINT COMM_COMMENT_PK PRIMARY KEY (COMMC_NUM)
)
/

COMMENT ON TABLE COMM_COMMENT IS '모임댓글'
/

COMMENT ON COLUMN COMM_COMMENT.COMMC_NUM IS '모임댓글번호'
/

COMMENT ON COLUMN COMM_COMMENT.CB_NUM IS '모임글번호'
/

COMMENT ON COLUMN COMM_COMMENT.USER_NUM IS '유저번호'
/

COMMENT ON COLUMN COMM_COMMENT.COMMC_CONTENT IS '댓글내용'
/

COMMENT ON COLUMN COMM_COMMENT.COMMC_DATE IS '댓글작성일'
/

COMMENT ON COLUMN COMM_COMMENT.COMMC_LIKE IS '추천수'
/

ALTER TABLE COMM_COMMENT
    ADD CONSTRAINT FK_COMM_COMMENT_USER_NUM_MEMBE FOREIGN KEY (USER_NUM)
        REFERENCES MEMBERS (USER_NUM)
/

ALTER TABLE COMM_COMMENT
    ADD CONSTRAINT FK_COMM_COMMENT_CB_NUM_COMM_BO FOREIGN KEY (CB_NUM)
        REFERENCES COMM_BOARD (CB_NUM)
/


-- ADMIN_BOARD Table Create SQL
CREATE TABLE ADMIN_BOARD
(
    AB_NUM        NUMBER            NOT NULL, 
    ADMIN_NUM     NUMBER            NULL, 
    AB_NOTICE     NUMBER            NULL, 
    AB_CONTENT    VARCHAR2(1000)    NULL, 
    AB_TITLE      VARCHAR2(20)      NULL, 
    AB_DATE       DATE              NULL, 
    CONSTRAINT ADMIN_BOARD_PK PRIMARY KEY (AB_NUM)
)
/

COMMENT ON TABLE ADMIN_BOARD IS '관리자게시판'
/

COMMENT ON COLUMN ADMIN_BOARD.AB_NUM IS '관리글번호'
/

COMMENT ON COLUMN ADMIN_BOARD.ADMIN_NUM IS '관리자번호'
/

COMMENT ON COLUMN ADMIN_BOARD.AB_NOTICE IS '공지'
/

COMMENT ON COLUMN ADMIN_BOARD.AB_CONTENT IS '글내용'
/

COMMENT ON COLUMN ADMIN_BOARD.AB_TITLE IS '글제목'
/

COMMENT ON COLUMN ADMIN_BOARD.AB_DATE IS '작성일'
/

ALTER TABLE ADMIN_BOARD
    ADD CONSTRAINT FK_ADMIN_BOARD_ADMIN_NUM_ADMIN FOREIGN KEY (ADMIN_NUM)
        REFERENCES ADMIN (ADMIN_NUM)
/


-- VOTING_OPTION Table Create SQL
CREATE TABLE VOTING_OPTION
(
    VO_NUM        NUMBER           NOT NULL, 
    VOTE_NUM      NUMBER           NULL, 
    OPTION_NUM    NUMBER           NULL, 
    VO_CONTENT    VARCHAR2(200)    NULL, 
    CONSTRAINT VOTING_OPTION_PK PRIMARY KEY (VO_NUM)
)
/

COMMENT ON TABLE VOTING_OPTION IS '투표선택지'
/

COMMENT ON COLUMN VOTING_OPTION.VO_NUM IS '투표선택번호'
/

COMMENT ON COLUMN VOTING_OPTION.VOTE_NUM IS '투표번호'
/

COMMENT ON COLUMN VOTING_OPTION.OPTION_NUM IS '선택지번호'
/

COMMENT ON COLUMN VOTING_OPTION.VO_CONTENT IS '선택지내용'
/

ALTER TABLE VOTING_OPTION
    ADD CONSTRAINT FK_VOTING_OPTION_VOTE_NUM_COMM FOREIGN KEY (VOTE_NUM)
        REFERENCES COMM_VOTE (VOTE_NUM)
/


-- FRIENDS Table Create SQL
CREATE TABLE FRIENDS
(
    FRDS_NUM     NUMBER    NOT NULL, 
    USER1_NUM    NUMBER    NULL, 
    USER2_NUM    NUMBER    NULL, 
    FRDS_DATE    DATE      NULL, 
    CONSTRAINT FRIENDS_PK PRIMARY KEY (FRDS_NUM)
)
/

COMMENT ON TABLE FRIENDS IS '친구'
/

COMMENT ON COLUMN FRIENDS.FRDS_NUM IS '친구번호'
/

COMMENT ON COLUMN FRIENDS.USER1_NUM IS '유저번호1'
/

COMMENT ON COLUMN FRIENDS.USER2_NUM IS '유저번호2'
/

COMMENT ON COLUMN FRIENDS.FRDS_DATE IS '친구날짜'
/

ALTER TABLE FRIENDS
    ADD CONSTRAINT FK_FRIENDS_USER1_NUM_MEMBERS_U FOREIGN KEY (USER1_NUM)
        REFERENCES MEMBERS (USER_NUM)
/

ALTER TABLE FRIENDS
    ADD CONSTRAINT FK_FRIENDS_USER2_NUM_MEMBERS_U FOREIGN KEY (USER2_NUM)
        REFERENCES MEMBERS (USER_NUM)
/


-- MY_CHAT Table Create SQL
CREATE TABLE MY_CHAT
(
    MCHAT_NUM         NUMBER           NOT NULL, 
    MCHAT_TO_NUM      NUMBER           NULL, 
    MCHAT_FROM_NUM    NUMBER           NULL, 
    MCHAT_CONTENT     VARCHAR2(200)    NULL, 
    MCHAT_DATE        DATE             NULL, 
    CONSTRAINT MY_CHAT_PK PRIMARY KEY (MCHAT_NUM)
)
/

COMMENT ON TABLE MY_CHAT IS '채팅'
/

COMMENT ON COLUMN MY_CHAT.MCHAT_NUM IS '채팅번호'
/

COMMENT ON COLUMN MY_CHAT.MCHAT_TO_NUM IS '수신인'
/

COMMENT ON COLUMN MY_CHAT.MCHAT_FROM_NUM IS '발신인'
/

COMMENT ON COLUMN MY_CHAT.MCHAT_CONTENT IS '글내용'
/

COMMENT ON COLUMN MY_CHAT.MCHAT_DATE IS '보낸시간'
/

ALTER TABLE MY_CHAT
    ADD CONSTRAINT FK_MY_CHAT_MCHAT_TO_NUM_MEMBER FOREIGN KEY (MCHAT_TO_NUM)
        REFERENCES MEMBERS (USER_NUM)
/

ALTER TABLE MY_CHAT
    ADD CONSTRAINT FK_MY_CHAT_MCHAT_FROM_NUM_MEMB FOREIGN KEY (MCHAT_FROM_NUM)
        REFERENCES MEMBERS (USER_NUM)
/


-- COMM_CHAT Table Create SQL
CREATE TABLE COMM_CHAT
(
    CCHAT_NUM        NUMBER           NOT NULL, 
    COMM_NUM         NUMBER           NULL, 
    CCHAT_FROMNUM    NUMBER           NULL, 
    CCHAT_CONTENT    VARCHAR2(200)    NULL, 
    CCHAT_DATE       DATE             NULL, 
    CONSTRAINT COMM_CHAT_PK PRIMARY KEY (CCHAT_NUM)
)
/

COMMENT ON TABLE COMM_CHAT IS '모임채팅'
/

COMMENT ON COLUMN COMM_CHAT.CCHAT_NUM IS '채팅번호'
/

COMMENT ON COLUMN COMM_CHAT.COMM_NUM IS '모임번호'
/

COMMENT ON COLUMN COMM_CHAT.CCHAT_FROMNUM IS '발신인'
/

COMMENT ON COLUMN COMM_CHAT.CCHAT_CONTENT IS '글내용'
/

COMMENT ON COLUMN COMM_CHAT.CCHAT_DATE IS '보낸시간'
/

ALTER TABLE COMM_CHAT
    ADD CONSTRAINT FK_COMM_CHAT_COMM_NUM_COMMUNIT FOREIGN KEY (COMM_NUM)
        REFERENCES COMMUNITY (COMM_NUM)
/

ALTER TABLE COMM_CHAT
    ADD CONSTRAINT FK_COMM_CHAT_CCHAT_FROMNUM_MEM FOREIGN KEY (CCHAT_FROMNUM)
        REFERENCES MEMBERS (USER_NUM)
/


-- MY_PHOTO Table Create SQL
CREATE TABLE MY_PHOTO
(
    MP_NUM       NUMBER           NOT NULL, 
    MB_NUM       NUMBER           NULL, 
    MP_ORGIMG    VARCHAR2(100)    NULL, 
    MP_SAVIMG    VARCHAR2(100)    NULL, 
    CONSTRAINT MY_PHOTO_PK PRIMARY KEY (MP_NUM)
)
/

COMMENT ON TABLE MY_PHOTO IS '개인사진'
/

COMMENT ON COLUMN MY_PHOTO.MP_NUM IS '사진번호'
/

COMMENT ON COLUMN MY_PHOTO.MB_NUM IS '개인글번호'
/

COMMENT ON COLUMN MY_PHOTO.MP_ORGIMG IS '원본사진'
/

COMMENT ON COLUMN MY_PHOTO.MP_SAVIMG IS '저장사진'
/

ALTER TABLE MY_PHOTO
    ADD CONSTRAINT FK_MY_PHOTO_MB_NUM_MY_BOARD_MB FOREIGN KEY (MB_NUM)
        REFERENCES MY_BOARD (MB_NUM)
/


-- MY_VIDEO Table Create SQL
CREATE TABLE MY_VIDEO
(
    MV_NUM       NUMBER           NOT NULL, 
    MB_NUM       NUMBER           NULL, 
    MV_ORGVID    VARCHAR2(100)    NULL, 
    MV_SAVVID    VARCHAR2(100)    NULL, 
    CONSTRAINT MY_VIDEO_PK PRIMARY KEY (MV_NUM)
)
/

COMMENT ON TABLE MY_VIDEO IS '개인영상'
/

COMMENT ON COLUMN MY_VIDEO.MV_NUM IS '영상번호'
/

COMMENT ON COLUMN MY_VIDEO.MB_NUM IS '개인글번호'
/

COMMENT ON COLUMN MY_VIDEO.MV_ORGVID IS '원본영상'
/

COMMENT ON COLUMN MY_VIDEO.MV_SAVVID IS '저장영상'
/

ALTER TABLE MY_VIDEO
    ADD CONSTRAINT FK_MY_VIDEO_MB_NUM_MY_BOARD_MB FOREIGN KEY (MB_NUM)
        REFERENCES MY_BOARD (MB_NUM)
/


-- COMM_GATHERING Table Create SQL
CREATE TABLE COMM_GATHERING
(
    CG_NUM      NUMBER    NOT NULL, 
    CC_NUM      NUMBER    NULL, 
    USER_NUM    NUMBER    NULL, 
    CONSTRAINT COMM_GATHERING_PK PRIMARY KEY (CG_NUM)
)
/

COMMENT ON TABLE COMM_GATHERING IS '모임참여목록'
/

COMMENT ON COLUMN COMM_GATHERING.CG_NUM IS '참여번호'
/

COMMENT ON COLUMN COMM_GATHERING.CC_NUM IS '모임일정번호'
/

COMMENT ON COLUMN COMM_GATHERING.USER_NUM IS '참여유저번호'
/

ALTER TABLE COMM_GATHERING
    ADD CONSTRAINT FK_COMM_GATHERING_CC_NUM_COMM_ FOREIGN KEY (CC_NUM)
        REFERENCES COMM_CALENDAR (CC_NUM)
/

ALTER TABLE COMM_GATHERING
    ADD CONSTRAINT FK_COMM_GATHERING_USER_NUM_MEM FOREIGN KEY (USER_NUM)
        REFERENCES MEMBERS (USER_NUM)
/


-- MY_SKIN_PROFILE Table Create SQL
CREATE TABLE MY_SKIN_PROFILE
(
    MSP_NUM       NUMBER           NOT NULL, 
    MS_NUM        NUMBER           NULL, 
    MSP_ORGIMG    VARCHAR2(100)    NULL, 
    MSP_SAVIMG    VARCHAR2(100)    NULL, 
    CONSTRAINT MY_SKIN_PROFILE_PK PRIMARY KEY (MSP_NUM)
)
/

COMMENT ON TABLE MY_SKIN_PROFILE IS '개인스킨프로필'
/

COMMENT ON COLUMN MY_SKIN_PROFILE.MSP_NUM IS '프로필번호'
/

COMMENT ON COLUMN MY_SKIN_PROFILE.MS_NUM IS '스킨번호'
/

COMMENT ON COLUMN MY_SKIN_PROFILE.MSP_ORGIMG IS '원본사진'
/

COMMENT ON COLUMN MY_SKIN_PROFILE.MSP_SAVIMG IS '저장사진'
/

ALTER TABLE MY_SKIN_PROFILE
    ADD CONSTRAINT FK_MY_SKIN_PROFILE_MS_NUM_MY_S FOREIGN KEY (MS_NUM)
        REFERENCES MY_SKIN (MS_NUM)
/


-- MY_SKIN_COVER Table Create SQL
CREATE TABLE MY_SKIN_COVER
(
    MSC_NUM       NUMBER           NOT NULL, 
    MS_NUM        NUMBER           NULL, 
    MSC_ORGIMG    VARCHAR2(100)    NULL, 
    MSC_SAVIMG    VARCHAR2(100)    NULL, 
    CONSTRAINT MY_SKIN_COVER_PK PRIMARY KEY (MSC_NUM)
)
/

COMMENT ON TABLE MY_SKIN_COVER IS '개인스킨커버'
/

COMMENT ON COLUMN MY_SKIN_COVER.MSC_NUM IS '커버번호'
/

COMMENT ON COLUMN MY_SKIN_COVER.MS_NUM IS '스킨번호'
/

COMMENT ON COLUMN MY_SKIN_COVER.MSC_ORGIMG IS '원본사진'
/

COMMENT ON COLUMN MY_SKIN_COVER.MSC_SAVIMG IS '저장사진'
/

ALTER TABLE MY_SKIN_COVER
    ADD CONSTRAINT FK_MY_SKIN_COVER_MS_NUM_MY_SKI FOREIGN KEY (MS_NUM)
        REFERENCES MY_SKIN (MS_NUM)
/


-- COMM_PHOTO Table Create SQL
CREATE TABLE COMM_PHOTO
(
    CP_NUM       NUMBER           NOT NULL, 
    CB_NUM       NUMBER           NULL, 
    CP_ORGIMG    VARCHAR2(100)    NULL, 
    CP_SAVIMG    VARCHAR2(100)    NULL, 
    CONSTRAINT COMM_PHOTO_PK PRIMARY KEY (CP_NUM)
)
/

COMMENT ON TABLE COMM_PHOTO IS '모임사진'
/

COMMENT ON COLUMN COMM_PHOTO.CP_NUM IS '사진번호'
/

COMMENT ON COLUMN COMM_PHOTO.CB_NUM IS '모임글번호'
/

COMMENT ON COLUMN COMM_PHOTO.CP_ORGIMG IS '원본사진'
/

COMMENT ON COLUMN COMM_PHOTO.CP_SAVIMG IS '저장사진'
/

ALTER TABLE COMM_PHOTO
    ADD CONSTRAINT FK_COMM_PHOTO_CB_NUM_COMM_BOAR FOREIGN KEY (CB_NUM)
        REFERENCES COMM_BOARD (CB_NUM)
/


-- COMM_VIDEO Table Create SQL
CREATE TABLE COMM_VIDEO
(
    CV_NUM       NUMBER           NOT NULL, 
    CB_NUM       NUMBER           NULL, 
    CV_ORGVID    VARCHAR2(100)    NULL, 
    CV_SAVVID    VARCHAR2(100)    NULL, 
    CONSTRAINT COMM_VIDEO_PK PRIMARY KEY (CV_NUM)
)
/

COMMENT ON TABLE COMM_VIDEO IS '모임영상'
/

COMMENT ON COLUMN COMM_VIDEO.CV_NUM IS '영상번호'
/

COMMENT ON COLUMN COMM_VIDEO.CB_NUM IS '모임글번호'
/

COMMENT ON COLUMN COMM_VIDEO.CV_ORGVID IS '원본영상'
/

COMMENT ON COLUMN COMM_VIDEO.CV_SAVVID IS '저장영상'
/

ALTER TABLE COMM_VIDEO
    ADD CONSTRAINT FK_COMM_VIDEO_CB_NUM_COMM_BOAR FOREIGN KEY (CB_NUM)
        REFERENCES COMM_BOARD (CB_NUM)
/


-- FAQ Table Create SQL
CREATE TABLE FAQ
(
    QA_NUM        NUMBER            NOT NULL, 
    USER_NUM      NUMBER            NULL, 
    QA_TITLE      VARCHAR2(20)      NULL, 
    QA_CONTENT    VARCHAR2(1000)    NULL, 
    QA_DATE       DATE              NULL, 
    REF           NUMBER            NULL, 
    LEV           NUMBER            NULL, 
    STEP          NUMBER            NULL, 
    ADMIN_NUM     NUMBER            NULL, 
    CONSTRAINT FAQ_PK PRIMARY KEY (QA_NUM)
)
/

COMMENT ON TABLE FAQ IS '고객센터'
/

COMMENT ON COLUMN FAQ.QA_NUM IS '글번호'
/

COMMENT ON COLUMN FAQ.USER_NUM IS '질문자'
/

COMMENT ON COLUMN FAQ.QA_TITLE IS '글제목'
/

COMMENT ON COLUMN FAQ.QA_CONTENT IS '글내용'
/

COMMENT ON COLUMN FAQ.QA_DATE IS '작성일'
/

COMMENT ON COLUMN FAQ.REF IS '부모글번호'
/

COMMENT ON COLUMN FAQ.LEV IS '그룹'
/

COMMENT ON COLUMN FAQ.STEP IS '등록순서'
/

COMMENT ON COLUMN FAQ.ADMIN_NUM IS '답변자'
/

ALTER TABLE FAQ
    ADD CONSTRAINT FK_FAQ_USER_NUM_MEMBERS_USER_N FOREIGN KEY (USER_NUM)
        REFERENCES MEMBERS (USER_NUM)
/

ALTER TABLE FAQ
    ADD CONSTRAINT FK_FAQ_ADMIN_NUM_ADMIN_ADMIN_N FOREIGN KEY (ADMIN_NUM)
        REFERENCES ADMIN (ADMIN_NUM)
/


-- ACCUSE Table Create SQL
CREATE TABLE ACCUSE
(
    AC_NUM       NUMBER           NOT NULL, 
    USER1_NUM    NUMBER           NULL, 
    USER2_NUM    NUMBER           NULL, 
    AC_REASON    VARCHAR2(100)    NULL, 
    CB_NUM       NUMBER           NULL, 
    BOARD_NUM    NUMBER           NULL, 
    CONSTRAINT ACCUSE_PK PRIMARY KEY (AC_NUM)
)
/

COMMENT ON TABLE ACCUSE IS '신고'
/

COMMENT ON COLUMN ACCUSE.AC_NUM IS '신고번호'
/

COMMENT ON COLUMN ACCUSE.USER1_NUM IS '신고자'
/

COMMENT ON COLUMN ACCUSE.USER2_NUM IS '피신고자'
/

COMMENT ON COLUMN ACCUSE.AC_REASON IS '신고사유'
/

COMMENT ON COLUMN ACCUSE.CB_NUM IS '모임글번호'
/

COMMENT ON COLUMN ACCUSE.BOARD_NUM IS '개인글번호'
/

ALTER TABLE ACCUSE
    ADD CONSTRAINT FK_ACCUSE_USER1_NUM_MEMBERS_US FOREIGN KEY (USER1_NUM)
        REFERENCES MEMBERS (USER_NUM)
/

ALTER TABLE ACCUSE
    ADD CONSTRAINT FK_ACCUSE_USER2_NUM_MEMBERS_US FOREIGN KEY (USER2_NUM)
        REFERENCES MEMBERS (USER_NUM)
/

ALTER TABLE ACCUSE
    ADD CONSTRAINT FK_ACCUSE_BOARD_NUM_MY_BOARD_M FOREIGN KEY (BOARD_NUM)
        REFERENCES MY_BOARD (MB_NUM)
/

ALTER TABLE ACCUSE
    ADD CONSTRAINT FK_ACCUSE_CB_NUM_COMM_BOARD_CB FOREIGN KEY (CB_NUM)
        REFERENCES COMM_BOARD (CB_NUM)
/


-- MY_TAG Table Create SQL
CREATE TABLE MY_TAG
(
    MTAG_NUM    NUMBER    NOT NULL, 
    TAG_NUM     NUMBER    NULL, 
    MB_NUM      NUMBER    NULL, 
    CONSTRAINT MY_TAG_PK PRIMARY KEY (MTAG_NUM)
)
/

COMMENT ON TABLE MY_TAG IS '개인태그'
/

COMMENT ON COLUMN MY_TAG.MTAG_NUM IS '유저태그번호'
/

COMMENT ON COLUMN MY_TAG.TAG_NUM IS '태그번호'
/

COMMENT ON COLUMN MY_TAG.MB_NUM IS '개인글번호'
/

ALTER TABLE MY_TAG
    ADD CONSTRAINT FK_MY_TAG_TAG_NUM_TAG_TAG_NUM FOREIGN KEY (TAG_NUM)
        REFERENCES TAG (TAG_NUM)
/

ALTER TABLE MY_TAG
    ADD CONSTRAINT FK_MY_TAG_MB_NUM_MY_BOARD_MB_N FOREIGN KEY (MB_NUM)
        REFERENCES MY_BOARD (MB_NUM)
/


-- COMM_TAG Table Create SQL
CREATE TABLE COMM_TAG
(
    CTAG_NUM    NUMBER    NOT NULL, 
    TAG_NUM     NUMBER    NULL, 
    CB_NUM      NUMBER    NULL, 
    CONSTRAINT COMM_TAG_PK PRIMARY KEY (CTAG_NUM)
)
/

COMMENT ON TABLE COMM_TAG IS '모임태그'
/

COMMENT ON COLUMN COMM_TAG.CTAG_NUM IS '모임태그번호'
/

COMMENT ON COLUMN COMM_TAG.TAG_NUM IS '태그번호'
/

COMMENT ON COLUMN COMM_TAG.CB_NUM IS '모임글번호'
/

ALTER TABLE COMM_TAG
    ADD CONSTRAINT FK_COMM_TAG_TAG_NUM_TAG_TAG_NU FOREIGN KEY (TAG_NUM)
        REFERENCES TAG (TAG_NUM)
/

ALTER TABLE COMM_TAG
    ADD CONSTRAINT FK_COMM_TAG_CB_NUM_COMM_BOARD_ FOREIGN KEY (CB_NUM)
        REFERENCES COMM_BOARD (CB_NUM)
/


-- VOTEING_USERLIST Table Create SQL
CREATE TABLE VOTEING_USERLIST
(
    VU_NUM      NUMBER    NOT NULL, 
    VO_NUM      NUMBER    NULL, 
    USER_NUM    NUMBER    NULL, 
    CONSTRAINT VOTEING_USERLIST_PK PRIMARY KEY (VU_NUM)
)
/

COMMENT ON TABLE VOTEING_USERLIST IS '투표유저리스트'
/

COMMENT ON COLUMN VOTEING_USERLIST.VU_NUM IS '리스트번호'
/

COMMENT ON COLUMN VOTEING_USERLIST.VO_NUM IS '투표선택번호'
/

COMMENT ON COLUMN VOTEING_USERLIST.USER_NUM IS '유저번호'
/

ALTER TABLE VOTEING_USERLIST
    ADD CONSTRAINT FK_VOTEING_USERLIST_VO_NUM_VOT FOREIGN KEY (VO_NUM)
        REFERENCES VOTING_OPTION (VO_NUM)
/

ALTER TABLE VOTEING_USERLIST
    ADD CONSTRAINT FK_VOTEING_USERLIST_USER_NUM_M FOREIGN KEY (USER_NUM)
        REFERENCES MEMBERS (USER_NUM)
/


-- MY_BOARD_LIKE Table Create SQL
CREATE TABLE MY_BOARD_LIKE
(
    MBL_NUM     NUMBER    NOT NULL, 
    MB_NUM      NUMBER    NULL, 
    USER_NUM    NUMBER    NULL, 
    CONSTRAINT MY_BOARD_LIKE_PK PRIMARY KEY (MBL_NUM)
)
/

COMMENT ON TABLE MY_BOARD_LIKE IS '개인게시글추천'
/

COMMENT ON COLUMN MY_BOARD_LIKE.MBL_NUM IS '추천번호'
/

COMMENT ON COLUMN MY_BOARD_LIKE.MB_NUM IS '개인글번호'
/

COMMENT ON COLUMN MY_BOARD_LIKE.USER_NUM IS '추천유저'
/

ALTER TABLE MY_BOARD_LIKE
    ADD CONSTRAINT FK_MY_BOARD_LIKE_MB_NUM_MY_BOA FOREIGN KEY (MB_NUM)
        REFERENCES MY_BOARD (MB_NUM)
/

ALTER TABLE MY_BOARD_LIKE
    ADD CONSTRAINT FK_MY_BOARD_LIKE_USER_NUM_MEMB FOREIGN KEY (USER_NUM)
        REFERENCES MEMBERS (USER_NUM)
/


-- MY_COMMENT_LIKE Table Create SQL
CREATE TABLE MY_COMMENT_LIKE
(
    MCL_NUM     NUMBER    NOT NULL, 
    MYC_NUM     NUMBER    NULL, 
    USER_NUM    NUMBER    NULL, 
    CONSTRAINT MY_COMMENT_LIKE_PK PRIMARY KEY (MCL_NUM)
)
/

COMMENT ON TABLE MY_COMMENT_LIKE IS '개인댓글추천'
/

COMMENT ON COLUMN MY_COMMENT_LIKE.MCL_NUM IS '추천번호'
/

COMMENT ON COLUMN MY_COMMENT_LIKE.MYC_NUM IS '개인댓글번호'
/

COMMENT ON COLUMN MY_COMMENT_LIKE.USER_NUM IS '추천유저'
/

ALTER TABLE MY_COMMENT_LIKE
    ADD CONSTRAINT FK_MY_COMMENT_LIKE_MYC_NUM_MY_ FOREIGN KEY (MYC_NUM)
        REFERENCES MY_COMMENT (MYC_NUM)
/

ALTER TABLE MY_COMMENT_LIKE
    ADD CONSTRAINT FK_MY_COMMENT_LIKE_USER_NUM_ME FOREIGN KEY (USER_NUM)
        REFERENCES MEMBERS (USER_NUM)
/


-- COMM_BOARD_LIKE Table Create SQL
CREATE TABLE COMM_BOARD_LIKE
(
    CBL_NUM     NUMBER    NOT NULL, 
    CB_NUM      NUMBER    NULL, 
    USER_NUM    NUMBER    NULL, 
    CONSTRAINT COMM_BOARD_LIKE_PK PRIMARY KEY (CBL_NUM)
)
/

COMMENT ON TABLE COMM_BOARD_LIKE IS '모임게시글추천'
/

COMMENT ON COLUMN COMM_BOARD_LIKE.CBL_NUM IS '추천번호'
/

COMMENT ON COLUMN COMM_BOARD_LIKE.CB_NUM IS '모임글번호'
/

COMMENT ON COLUMN COMM_BOARD_LIKE.USER_NUM IS '추천유저'
/

ALTER TABLE COMM_BOARD_LIKE
    ADD CONSTRAINT FK_COMM_BOARD_LIKE_CB_NUM_COMM FOREIGN KEY (CB_NUM)
        REFERENCES COMM_BOARD (CB_NUM)
/

ALTER TABLE COMM_BOARD_LIKE
    ADD CONSTRAINT FK_COMM_BOARD_LIKE_USER_NUM_ME FOREIGN KEY (USER_NUM)
        REFERENCES MEMBERS (USER_NUM)
/


-- COMM_COMMENT_LIKE Table Create SQL
CREATE TABLE COMM_COMMENT_LIKE
(
    CCL_NUM      NUMBER    NOT NULL, 
    COMMC_NUM    NUMBER    NULL, 
    USER_NUM     NUMBER    NULL, 
    CONSTRAINT COMM_COMMENT_LIKE_PK PRIMARY KEY (CCL_NUM)
)
/

COMMENT ON TABLE COMM_COMMENT_LIKE IS '모임댓글추천'
/

COMMENT ON COLUMN COMM_COMMENT_LIKE.CCL_NUM IS '추천번호'
/

COMMENT ON COLUMN COMM_COMMENT_LIKE.COMMC_NUM IS '모임댓글번호'
/

COMMENT ON COLUMN COMM_COMMENT_LIKE.USER_NUM IS '추천유저'
/

ALTER TABLE COMM_COMMENT_LIKE
    ADD CONSTRAINT FK_COMM_COMMENT_LIKE_COMMC_NUM FOREIGN KEY (COMMC_NUM)
        REFERENCES COMM_COMMENT (COMMC_NUM)
/

ALTER TABLE COMM_COMMENT_LIKE
    ADD CONSTRAINT FK_COMM_COMMENT_LIKE_USER_NUM_ FOREIGN KEY (USER_NUM)
        REFERENCES MEMBERS (USER_NUM)
/


-- COMM_SKIN_COVER Table Create SQL
CREATE TABLE COMM_SKIN_COVER
(
    CSC_NUM       NUMBER           NOT NULL, 
    CS_NUM        NUMBER           NULL, 
    CSC_ORGIMG    VARCHAR2(100)    NULL, 
    CSC_SAVIMG    VARCHAR2(100)    NULL, 
    CONSTRAINT COMM_SKIN_COVER_PK PRIMARY KEY (CSC_NUM)
)
/

COMMENT ON TABLE COMM_SKIN_COVER IS '모임스킨커버'
/

COMMENT ON COLUMN COMM_SKIN_COVER.CSC_NUM IS '커버번호'
/

COMMENT ON COLUMN COMM_SKIN_COVER.CS_NUM IS '스킨번호'
/

COMMENT ON COLUMN COMM_SKIN_COVER.CSC_ORGIMG IS '원본사진'
/

COMMENT ON COLUMN COMM_SKIN_COVER.CSC_SAVIMG IS '저장사진'
/

ALTER TABLE COMM_SKIN_COVER
    ADD CONSTRAINT FK_COMM_SKIN_COVER_CS_NUM_COMM FOREIGN KEY (CS_NUM)
        REFERENCES COMM_SKIN (CS_NUM)
/


-- COMM_SKIN_PROFILE Table Create SQL
CREATE TABLE COMM_SKIN_PROFILE
(
    CSP_NUM       NUMBER           NOT NULL, 
    CS_NUM        NUMBER           NULL, 
    CSP_ORGIMG    VARCHAR2(100)    NULL, 
    CSP_SAVIMG    VARCHAR2(100)    NULL, 
    CONSTRAINT COMM_SKIN_PROFILE_PK PRIMARY KEY (CSP_NUM)
)
/

COMMENT ON TABLE COMM_SKIN_PROFILE IS '모임스킨프로필'
/

COMMENT ON COLUMN COMM_SKIN_PROFILE.CSP_NUM IS '프로필번호'
/

COMMENT ON COLUMN COMM_SKIN_PROFILE.CS_NUM IS '스킨번호'
/

COMMENT ON COLUMN COMM_SKIN_PROFILE.CSP_ORGIMG IS '원본사진'
/

COMMENT ON COLUMN COMM_SKIN_PROFILE.CSP_SAVIMG IS '저장사진'
/

ALTER TABLE COMM_SKIN_PROFILE
    ADD CONSTRAINT FK_COMM_SKIN_PROFILE_CS_NUM_CO FOREIGN KEY (CS_NUM)
        REFERENCES COMM_SKIN (CS_NUM)
/


-- COMM_REFUSE Table Create SQL
CREATE TABLE COMM_REFUSE
(
    CR_NUM       NUMBER          NOT NULL, 
    CUL_NUM      NUMBER          NULL, 
    CR_REFUSE    VARCHAR2(20)    NULL, 
    CONSTRAINT COMM_REFUSE_PK PRIMARY KEY (CR_NUM)
)
/

COMMENT ON TABLE COMM_REFUSE IS '취소사유'
/

COMMENT ON COLUMN COMM_REFUSE.CR_NUM IS '취소번호'
/

COMMENT ON COLUMN COMM_REFUSE.CUL_NUM IS '모임유저번호'
/

COMMENT ON COLUMN COMM_REFUSE.CR_REFUSE IS '가입취소사유'
/

ALTER TABLE COMM_REFUSE
    ADD CONSTRAINT FK_COMM_REFUSE_CUL_NUM_COMM_US FOREIGN KEY (CUL_NUM)
        REFERENCES COMM_USER_LIST (CUL_NUM)
/


-- AB_PHOTO Table Create SQL
CREATE TABLE AB_PHOTO
(
    AP_NUM       NUMBER           NOT NULL, 
    AB_NUM       NUMBER           NULL, 
    AB_ORGIMG    VARCHAR2(100)    NULL, 
    AB_SAVIMG    VARCHAR2(100)    NULL, 
    CONSTRAINT AB_PHOTO_PK PRIMARY KEY (AP_NUM)
)
/

COMMENT ON TABLE AB_PHOTO IS '관리글사진'
/

COMMENT ON COLUMN AB_PHOTO.AP_NUM IS '사진번호'
/

COMMENT ON COLUMN AB_PHOTO.AB_NUM IS '관리글번호'
/

COMMENT ON COLUMN AB_PHOTO.AB_ORGIMG IS '원본사진'
/

COMMENT ON COLUMN AB_PHOTO.AB_SAVIMG IS '저장사진'
/

ALTER TABLE AB_PHOTO
    ADD CONSTRAINT FK_AB_PHOTO_AB_NUM_ADMIN_BOARD FOREIGN KEY (AB_NUM)
        REFERENCES ADMIN_BOARD (AB_NUM)
/


