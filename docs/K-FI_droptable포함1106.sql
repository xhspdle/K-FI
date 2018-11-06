--------------------------------------------------------
--  ������ ������ - ȭ����-11��-06-2018   
--------------------------------------------------------
DROP TABLE "KFI"."AB_PHOTO" cascade constraints;
DROP TABLE "KFI"."ACCUSE" cascade constraints;
DROP TABLE "KFI"."ADMIN" cascade constraints;
DROP TABLE "KFI"."ADMIN_BOARD" cascade constraints;
DROP TABLE "KFI"."CERTI_MEMBERS" cascade constraints;
DROP TABLE "KFI"."COMM_BOARD" cascade constraints;
DROP TABLE "KFI"."COMM_BOARD_LIKE" cascade constraints;
DROP TABLE "KFI"."COMM_CALENDAR" cascade constraints;
DROP TABLE "KFI"."COMM_CHAT" cascade constraints;
DROP TABLE "KFI"."COMM_COMMENT" cascade constraints;
DROP TABLE "KFI"."COMM_COMMENT_LIKE" cascade constraints;
DROP TABLE "KFI"."COMM_GATHERING" cascade constraints;
DROP TABLE "KFI"."COMM_PHOTO" cascade constraints;
DROP TABLE "KFI"."COMM_REFUSE" cascade constraints;
DROP TABLE "KFI"."COMM_SKIN" cascade constraints;
DROP TABLE "KFI"."COMM_SKIN_COVER" cascade constraints;
DROP TABLE "KFI"."COMM_SKIN_PROFILE" cascade constraints;
DROP TABLE "KFI"."COMM_TAG" cascade constraints;
DROP TABLE "KFI"."COMM_USER_LIST" cascade constraints;
DROP TABLE "KFI"."COMM_VIDEO" cascade constraints;
DROP TABLE "KFI"."COMM_VOTE" cascade constraints;
DROP TABLE "KFI"."COMMUNITY" cascade constraints;
DROP TABLE "KFI"."FAQ" cascade constraints;
DROP TABLE "KFI"."FRIENDS" cascade constraints;
DROP TABLE "KFI"."MEMBERS" cascade constraints;
DROP TABLE "KFI"."MY_BOARD" cascade constraints;
DROP TABLE "KFI"."MY_BOARD_LIKE" cascade constraints;
DROP TABLE "KFI"."MY_CHAT" cascade constraints;
DROP TABLE "KFI"."MY_COMMENT" cascade constraints;
DROP TABLE "KFI"."MY_COMMENT_LIKE" cascade constraints;
DROP TABLE "KFI"."MY_PHOTO" cascade constraints;
DROP TABLE "KFI"."MY_SKIN" cascade constraints;
DROP TABLE "KFI"."MY_SKIN_COVER" cascade constraints;
DROP TABLE "KFI"."MY_SKIN_PROFILE" cascade constraints;
DROP TABLE "KFI"."MY_TAG" cascade constraints;
DROP TABLE "KFI"."MY_VIDEO" cascade constraints;
DROP TABLE "KFI"."TAG" cascade constraints;
DROP TABLE "KFI"."VOTEING_USERLIST" cascade constraints;
DROP TABLE "KFI"."VOTING_OPTION" cascade constraints;
--------------------------------------------------------
--  DDL for Table AB_PHOTO
--------------------------------------------------------

  CREATE TABLE "KFI"."AB_PHOTO" ("AP_NUM" NUMBER, "AB_NUM" NUMBER, "AB_ORGIMG" VARCHAR2(200), "AB_SAVIMG" VARCHAR2(200)) 

   COMMENT ON COLUMN "KFI"."AB_PHOTO"."AP_NUM" IS '������ȣ'
   COMMENT ON COLUMN "KFI"."AB_PHOTO"."AB_NUM" IS '�����۹�ȣ'
   COMMENT ON COLUMN "KFI"."AB_PHOTO"."AB_ORGIMG" IS '��������'
   COMMENT ON COLUMN "KFI"."AB_PHOTO"."AB_SAVIMG" IS '�������'
   COMMENT ON TABLE "KFI"."AB_PHOTO"  IS '�����ۻ���'
--------------------------------------------------------
--  DDL for Table ACCUSE
--------------------------------------------------------

  CREATE TABLE "KFI"."ACCUSE" ("AC_NUM" NUMBER, "USER1_NUM" NUMBER, "USER2_NUM" NUMBER, "AC_REASON" VARCHAR2(200), "CB_NUM" NUMBER, "BOARD_NUM" NUMBER, "AC_DATE" DATE, "AC_STATUS" NUMBER) 

   COMMENT ON COLUMN "KFI"."ACCUSE"."AC_NUM" IS '�Ű��ȣ'
   COMMENT ON COLUMN "KFI"."ACCUSE"."USER1_NUM" IS '�Ű���'
   COMMENT ON COLUMN "KFI"."ACCUSE"."USER2_NUM" IS '�ǽŰ���'
   COMMENT ON COLUMN "KFI"."ACCUSE"."AC_REASON" IS '�Ű����'
   COMMENT ON COLUMN "KFI"."ACCUSE"."CB_NUM" IS '���ӱ۹�ȣ'
   COMMENT ON COLUMN "KFI"."ACCUSE"."BOARD_NUM" IS '���α۹�ȣ'
   COMMENT ON COLUMN "KFI"."ACCUSE"."AC_DATE" IS '�Ű�ð�'
   COMMENT ON COLUMN "KFI"."ACCUSE"."AC_STATUS" IS 'ó������'
   COMMENT ON TABLE "KFI"."ACCUSE"  IS '�Ű�'
--------------------------------------------------------
--  DDL for Table ADMIN
--------------------------------------------------------

  CREATE TABLE "KFI"."ADMIN" ("ADMIN_NUM" NUMBER, "ADMIN_ID" VARCHAR2(50), "ADMIN_PWD" VARCHAR2(50), "ADMIN_NICK" VARCHAR2(50), "ADMIN_EMAIL" VARCHAR2(50), "ADMIN_REGDATE" DATE) 

   COMMENT ON COLUMN "KFI"."ADMIN"."ADMIN_NUM" IS '�����ڹ�ȣ'
   COMMENT ON COLUMN "KFI"."ADMIN"."ADMIN_ID" IS '���̵�'
   COMMENT ON COLUMN "KFI"."ADMIN"."ADMIN_PWD" IS '��й�ȣ'
   COMMENT ON COLUMN "KFI"."ADMIN"."ADMIN_NICK" IS '�����ڴг���'
   COMMENT ON COLUMN "KFI"."ADMIN"."ADMIN_EMAIL" IS '�̸���'
   COMMENT ON COLUMN "KFI"."ADMIN"."ADMIN_REGDATE" IS '�����'
   COMMENT ON TABLE "KFI"."ADMIN"  IS '������'
--------------------------------------------------------
--  DDL for Table ADMIN_BOARD
--------------------------------------------------------

  CREATE TABLE "KFI"."ADMIN_BOARD" ("AB_NUM" NUMBER, "ADMIN_NUM" NUMBER, "AB_NOTICE" NUMBER, "AB_CONTENT" VARCHAR2(1000), "AB_TITLE" VARCHAR2(50), "AB_DATE" DATE) 

   COMMENT ON COLUMN "KFI"."ADMIN_BOARD"."AB_NUM" IS '�����۹�ȣ'
   COMMENT ON COLUMN "KFI"."ADMIN_BOARD"."ADMIN_NUM" IS '�����ڹ�ȣ'
   COMMENT ON COLUMN "KFI"."ADMIN_BOARD"."AB_NOTICE" IS '����'
   COMMENT ON COLUMN "KFI"."ADMIN_BOARD"."AB_CONTENT" IS '�۳���'
   COMMENT ON COLUMN "KFI"."ADMIN_BOARD"."AB_TITLE" IS '������'
   COMMENT ON COLUMN "KFI"."ADMIN_BOARD"."AB_DATE" IS '�ۼ���'
   COMMENT ON TABLE "KFI"."ADMIN_BOARD"  IS '�����ڰԽ���'
--------------------------------------------------------
--  DDL for Table CERTI_MEMBERS
--------------------------------------------------------

  CREATE TABLE "KFI"."CERTI_MEMBERS" ("CM_NUM" NUMBER, "USER_NUM" NUMBER, "CM_KEY" VARCHAR2(100)) 

   COMMENT ON COLUMN "KFI"."CERTI_MEMBERS"."CM_NUM" IS '������ȣ'
   COMMENT ON COLUMN "KFI"."CERTI_MEMBERS"."USER_NUM" IS '������ȣ'
   COMMENT ON COLUMN "KFI"."CERTI_MEMBERS"."CM_KEY" IS '����Ű'
   COMMENT ON TABLE "KFI"."CERTI_MEMBERS"  IS '���������'
--------------------------------------------------------
--  DDL for Table COMM_BOARD
--------------------------------------------------------

  CREATE TABLE "KFI"."COMM_BOARD" ("CB_NUM" NUMBER, "COMM_NUM" NUMBER, "CB_TITLE" VARCHAR2(50), "CB_CONTENT" VARCHAR2(1000), "CB_DATE" DATE, "CB_NOTICE" NUMBER, "CB_VIEWS" NUMBER) 

   COMMENT ON COLUMN "KFI"."COMM_BOARD"."CB_NUM" IS '���ӱ۹�ȣ'
   COMMENT ON COLUMN "KFI"."COMM_BOARD"."COMM_NUM" IS '���ӹ�ȣ'
   COMMENT ON COLUMN "KFI"."COMM_BOARD"."CB_TITLE" IS '���ӱ�����'
   COMMENT ON COLUMN "KFI"."COMM_BOARD"."CB_CONTENT" IS '���ӱ۳���'
   COMMENT ON COLUMN "KFI"."COMM_BOARD"."CB_DATE" IS '���ӱ��ۼ���'
   COMMENT ON COLUMN "KFI"."COMM_BOARD"."CB_NOTICE" IS '��������'
   COMMENT ON COLUMN "KFI"."COMM_BOARD"."CB_VIEWS" IS '��ȸ��'
   COMMENT ON TABLE "KFI"."COMM_BOARD"  IS '���ӰԽ���'
--------------------------------------------------------
--  DDL for Table COMM_BOARD_LIKE
--------------------------------------------------------

  CREATE TABLE "KFI"."COMM_BOARD_LIKE" ("CBL_NUM" NUMBER, "CB_NUM" NUMBER, "USER_NUM" NUMBER) 

   COMMENT ON COLUMN "KFI"."COMM_BOARD_LIKE"."CBL_NUM" IS '��õ��ȣ'
   COMMENT ON COLUMN "KFI"."COMM_BOARD_LIKE"."CB_NUM" IS '���ӱ۹�ȣ'
   COMMENT ON COLUMN "KFI"."COMM_BOARD_LIKE"."USER_NUM" IS '��õ����'
   COMMENT ON TABLE "KFI"."COMM_BOARD_LIKE"  IS '���ӰԽñ���õ'
--------------------------------------------------------
--  DDL for Table COMM_CALENDAR
--------------------------------------------------------

  CREATE TABLE "KFI"."COMM_CALENDAR" ("CC_NUM" NUMBER, "COMM_NUM" NUMBER, "CC_NAME" VARCHAR2(50), "CC_INFO" VARCHAR2(500), "CC_BEGIN" DATE, "CC_END" DATE) 

   COMMENT ON COLUMN "KFI"."COMM_CALENDAR"."CC_NUM" IS '����������ȣ'
   COMMENT ON COLUMN "KFI"."COMM_CALENDAR"."COMM_NUM" IS '���ӹ�ȣ'
   COMMENT ON COLUMN "KFI"."COMM_CALENDAR"."CC_NAME" IS '�����̸�'
   COMMENT ON COLUMN "KFI"."COMM_CALENDAR"."CC_INFO" IS '��������'
   COMMENT ON COLUMN "KFI"."COMM_CALENDAR"."CC_BEGIN" IS '���ӽ�����'
   COMMENT ON COLUMN "KFI"."COMM_CALENDAR"."CC_END" IS '����������'
   COMMENT ON TABLE "KFI"."COMM_CALENDAR"  IS '��������'
--------------------------------------------------------
--  DDL for Table COMM_CHAT
--------------------------------------------------------

  CREATE TABLE "KFI"."COMM_CHAT" ("CCHAT_NUM" NUMBER, "COMM_NUM" NUMBER, "CCHAT_FROMNUM" NUMBER, "CCHAT_CONTENT" VARCHAR2(200), "CCHAT_DATE" DATE) 

   COMMENT ON COLUMN "KFI"."COMM_CHAT"."CCHAT_NUM" IS 'ä�ù�ȣ'
   COMMENT ON COLUMN "KFI"."COMM_CHAT"."COMM_NUM" IS '���ӹ�ȣ'
   COMMENT ON COLUMN "KFI"."COMM_CHAT"."CCHAT_FROMNUM" IS '�߽���'
   COMMENT ON COLUMN "KFI"."COMM_CHAT"."CCHAT_CONTENT" IS '�۳���'
   COMMENT ON COLUMN "KFI"."COMM_CHAT"."CCHAT_DATE" IS '�����ð�'
   COMMENT ON TABLE "KFI"."COMM_CHAT"  IS '����ä��'
--------------------------------------------------------
--  DDL for Table COMM_COMMENT
--------------------------------------------------------

  CREATE TABLE "KFI"."COMM_COMMENT" ("COMMC_NUM" NUMBER, "CB_NUM" NUMBER, "USER_NUM" NUMBER, "COMMC_CONTENT" VARCHAR2(500), "COMMC_DATE" DATE, "COMMC_LIKE" NUMBER) 

   COMMENT ON COLUMN "KFI"."COMM_COMMENT"."COMMC_NUM" IS '���Ӵ�۹�ȣ'
   COMMENT ON COLUMN "KFI"."COMM_COMMENT"."CB_NUM" IS '���ӱ۹�ȣ'
   COMMENT ON COLUMN "KFI"."COMM_COMMENT"."USER_NUM" IS '������ȣ'
   COMMENT ON COLUMN "KFI"."COMM_COMMENT"."COMMC_CONTENT" IS '��۳���'
   COMMENT ON COLUMN "KFI"."COMM_COMMENT"."COMMC_DATE" IS '����ۼ���'
   COMMENT ON COLUMN "KFI"."COMM_COMMENT"."COMMC_LIKE" IS '��õ��'
   COMMENT ON TABLE "KFI"."COMM_COMMENT"  IS '���Ӵ��'
--------------------------------------------------------
--  DDL for Table COMM_COMMENT_LIKE
--------------------------------------------------------

  CREATE TABLE "KFI"."COMM_COMMENT_LIKE" ("CCL_NUM" NUMBER, "COMMC_NUM" NUMBER, "USER_NUM" NUMBER) 

   COMMENT ON COLUMN "KFI"."COMM_COMMENT_LIKE"."CCL_NUM" IS '��õ��ȣ'
   COMMENT ON COLUMN "KFI"."COMM_COMMENT_LIKE"."COMMC_NUM" IS '���Ӵ�۹�ȣ'
   COMMENT ON COLUMN "KFI"."COMM_COMMENT_LIKE"."USER_NUM" IS '��õ����'
   COMMENT ON TABLE "KFI"."COMM_COMMENT_LIKE"  IS '���Ӵ����õ'
--------------------------------------------------------
--  DDL for Table COMM_GATHERING
--------------------------------------------------------

  CREATE TABLE "KFI"."COMM_GATHERING" ("CG_NUM" NUMBER, "CC_NUM" NUMBER, "USER_NUM" NUMBER) 

   COMMENT ON COLUMN "KFI"."COMM_GATHERING"."CG_NUM" IS '������ȣ'
   COMMENT ON COLUMN "KFI"."COMM_GATHERING"."CC_NUM" IS '����������ȣ'
   COMMENT ON COLUMN "KFI"."COMM_GATHERING"."USER_NUM" IS '����������ȣ'
   COMMENT ON TABLE "KFI"."COMM_GATHERING"  IS '�����������'
--------------------------------------------------------
--  DDL for Table COMM_PHOTO
--------------------------------------------------------

  CREATE TABLE "KFI"."COMM_PHOTO" ("CP_NUM" NUMBER, "CB_NUM" NUMBER, "CP_ORGIMG" VARCHAR2(150), "CP_SAVIMG" VARCHAR2(150)) 

   COMMENT ON COLUMN "KFI"."COMM_PHOTO"."CP_NUM" IS '������ȣ'
   COMMENT ON COLUMN "KFI"."COMM_PHOTO"."CB_NUM" IS '���ӱ۹�ȣ'
   COMMENT ON COLUMN "KFI"."COMM_PHOTO"."CP_ORGIMG" IS '��������'
   COMMENT ON COLUMN "KFI"."COMM_PHOTO"."CP_SAVIMG" IS '�������'
   COMMENT ON TABLE "KFI"."COMM_PHOTO"  IS '���ӻ���'
--------------------------------------------------------
--  DDL for Table COMM_REFUSE
--------------------------------------------------------

  CREATE TABLE "KFI"."COMM_REFUSE" ("CR_NUM" NUMBER, "CUL_NUM" NUMBER, "CR_REFUSE" VARCHAR2(200)) 

   COMMENT ON COLUMN "KFI"."COMM_REFUSE"."CR_NUM" IS '��ҹ�ȣ'
   COMMENT ON COLUMN "KFI"."COMM_REFUSE"."CUL_NUM" IS '����������ȣ'
   COMMENT ON COLUMN "KFI"."COMM_REFUSE"."CR_REFUSE" IS '������һ���'
   COMMENT ON TABLE "KFI"."COMM_REFUSE"  IS '��һ���'
--------------------------------------------------------
--  DDL for Table COMM_SKIN
--------------------------------------------------------

  CREATE TABLE "KFI"."COMM_SKIN" ("CS_NUM" NUMBER, "COMM_NUM" NUMBER, "CS_NAME" VARCHAR2(50), "CS_COLOR" VARCHAR2(50), "CS_USING" NUMBER) 

   COMMENT ON COLUMN "KFI"."COMM_SKIN"."CS_NUM" IS '��Ų��ȣ'
   COMMENT ON COLUMN "KFI"."COMM_SKIN"."COMM_NUM" IS '���ӹ�ȣ'
   COMMENT ON COLUMN "KFI"."COMM_SKIN"."CS_NAME" IS '��Ų�̸�'
   COMMENT ON COLUMN "KFI"."COMM_SKIN"."CS_COLOR" IS '�÷��ڵ�'
   COMMENT ON COLUMN "KFI"."COMM_SKIN"."CS_USING" IS '������(1/0)'
   COMMENT ON TABLE "KFI"."COMM_SKIN"  IS '���ӽ�Ų'
--------------------------------------------------------
--  DDL for Table COMM_SKIN_COVER
--------------------------------------------------------

  CREATE TABLE "KFI"."COMM_SKIN_COVER" ("CSC_NUM" NUMBER, "CS_NUM" NUMBER, "CSC_ORGIMG" VARCHAR2(150), "CSC_SAVIMG" VARCHAR2(150)) 

   COMMENT ON COLUMN "KFI"."COMM_SKIN_COVER"."CSC_NUM" IS 'Ŀ����ȣ'
   COMMENT ON COLUMN "KFI"."COMM_SKIN_COVER"."CS_NUM" IS '��Ų��ȣ'
   COMMENT ON COLUMN "KFI"."COMM_SKIN_COVER"."CSC_ORGIMG" IS '��������'
   COMMENT ON COLUMN "KFI"."COMM_SKIN_COVER"."CSC_SAVIMG" IS '�������'
   COMMENT ON TABLE "KFI"."COMM_SKIN_COVER"  IS '���ӽ�ŲĿ��'
--------------------------------------------------------
--  DDL for Table COMM_SKIN_PROFILE
--------------------------------------------------------

  CREATE TABLE "KFI"."COMM_SKIN_PROFILE" ("CSP_NUM" NUMBER, "CS_NUM" NUMBER, "CSP_ORGIMG" VARCHAR2(150), "CSP_SAVIMG" VARCHAR2(150)) 

   COMMENT ON COLUMN "KFI"."COMM_SKIN_PROFILE"."CSP_NUM" IS '�����ʹ�ȣ'
   COMMENT ON COLUMN "KFI"."COMM_SKIN_PROFILE"."CS_NUM" IS '��Ų��ȣ'
   COMMENT ON COLUMN "KFI"."COMM_SKIN_PROFILE"."CSP_ORGIMG" IS '��������'
   COMMENT ON COLUMN "KFI"."COMM_SKIN_PROFILE"."CSP_SAVIMG" IS '�������'
   COMMENT ON TABLE "KFI"."COMM_SKIN_PROFILE"  IS '���ӽ�Ų������'
--------------------------------------------------------
--  DDL for Table COMM_TAG
--------------------------------------------------------

  CREATE TABLE "KFI"."COMM_TAG" ("CTAG_NUM" NUMBER, "TAG_NUM" NUMBER, "CB_NUM" NUMBER) 

   COMMENT ON COLUMN "KFI"."COMM_TAG"."CTAG_NUM" IS '�����±׹�ȣ'
   COMMENT ON COLUMN "KFI"."COMM_TAG"."TAG_NUM" IS '�±׹�ȣ'
   COMMENT ON COLUMN "KFI"."COMM_TAG"."CB_NUM" IS '���ӱ۹�ȣ'
   COMMENT ON TABLE "KFI"."COMM_TAG"  IS '�����±�'
--------------------------------------------------------
--  DDL for Table COMM_USER_LIST
--------------------------------------------------------

  CREATE TABLE "KFI"."COMM_USER_LIST" ("CUL_NUM" NUMBER, "COMM_NUM" NUMBER, "USER_NUM" NUMBER, "CUL_STATUS" NUMBER) 

   COMMENT ON COLUMN "KFI"."COMM_USER_LIST"."CUL_NUM" IS '����������ȣ'
   COMMENT ON COLUMN "KFI"."COMM_USER_LIST"."COMM_NUM" IS '���ӹ�ȣ'
   COMMENT ON COLUMN "KFI"."COMM_USER_LIST"."USER_NUM" IS '������ȣ'
   COMMENT ON COLUMN "KFI"."COMM_USER_LIST"."CUL_STATUS" IS 'ó������'
   COMMENT ON TABLE "KFI"."COMM_USER_LIST"  IS '�����������'
--------------------------------------------------------
--  DDL for Table COMM_VIDEO
--------------------------------------------------------

  CREATE TABLE "KFI"."COMM_VIDEO" ("CV_NUM" NUMBER, "CB_NUM" NUMBER, "CV_ORGVID" VARCHAR2(150), "CV_SAVVID" VARCHAR2(150)) 

   COMMENT ON COLUMN "KFI"."COMM_VIDEO"."CV_NUM" IS '�����ȣ'
   COMMENT ON COLUMN "KFI"."COMM_VIDEO"."CB_NUM" IS '���ӱ۹�ȣ'
   COMMENT ON COLUMN "KFI"."COMM_VIDEO"."CV_ORGVID" IS '��������'
   COMMENT ON COLUMN "KFI"."COMM_VIDEO"."CV_SAVVID" IS '���念��'
   COMMENT ON TABLE "KFI"."COMM_VIDEO"  IS '���ӿ���'
--------------------------------------------------------
--  DDL for Table COMM_VOTE
--------------------------------------------------------

  CREATE TABLE "KFI"."COMM_VOTE" ("VOTE_NUM" NUMBER, "CB_NUM" NUMBER, "VOTE_TITLE" VARCHAR2(50), "VOTE_INFO" VARCHAR2(500), "VOTE_BEGIN" DATE, "VOTE_END" DATE) 

   COMMENT ON COLUMN "KFI"."COMM_VOTE"."VOTE_NUM" IS '��ǥ��ȣ'
   COMMENT ON COLUMN "KFI"."COMM_VOTE"."CB_NUM" IS '���ӱ۹�ȣ'
   COMMENT ON COLUMN "KFI"."COMM_VOTE"."VOTE_TITLE" IS '��ǥ����'
   COMMENT ON COLUMN "KFI"."COMM_VOTE"."VOTE_INFO" IS '��ǥ����'
   COMMENT ON COLUMN "KFI"."COMM_VOTE"."VOTE_BEGIN" IS '������'
   COMMENT ON COLUMN "KFI"."COMM_VOTE"."VOTE_END" IS '������'
   COMMENT ON TABLE "KFI"."COMM_VOTE"  IS '������ǥ'
--------------------------------------------------------
--  DDL for Table COMMUNITY
--------------------------------------------------------

  CREATE TABLE "KFI"."COMMUNITY" ("COMM_NUM" NUMBER, "USER_NUM" NUMBER, "COMM_NAME" VARCHAR2(50), "COMM_CONTENT" VARCHAR2(50), "COMM_REGDATE" DATE) 

   COMMENT ON COLUMN "KFI"."COMMUNITY"."COMM_NUM" IS '���ӹ�ȣ'
   COMMENT ON COLUMN "KFI"."COMMUNITY"."USER_NUM" IS '�����ڹ�ȣ'
   COMMENT ON COLUMN "KFI"."COMMUNITY"."COMM_NAME" IS '���Ӹ�'
   COMMENT ON COLUMN "KFI"."COMMUNITY"."COMM_CONTENT" IS '���ӼҰ�'
   COMMENT ON COLUMN "KFI"."COMMUNITY"."COMM_REGDATE" IS '������'
   COMMENT ON TABLE "KFI"."COMMUNITY"  IS '��������'
--------------------------------------------------------
--  DDL for Table FAQ
--------------------------------------------------------

  CREATE TABLE "KFI"."FAQ" ("QA_NUM" NUMBER, "USER_NUM" NUMBER, "QA_TITLE" VARCHAR2(50), "QA_CONTENT" VARCHAR2(1000), "QA_DATE" DATE, "REF" NUMBER, "LEV" NUMBER, "STEP" NUMBER, "ADMIN_NUM" NUMBER) 

   COMMENT ON COLUMN "KFI"."FAQ"."QA_NUM" IS '�۹�ȣ'
   COMMENT ON COLUMN "KFI"."FAQ"."USER_NUM" IS '������'
   COMMENT ON COLUMN "KFI"."FAQ"."QA_TITLE" IS '������'
   COMMENT ON COLUMN "KFI"."FAQ"."QA_CONTENT" IS '�۳���'
   COMMENT ON COLUMN "KFI"."FAQ"."QA_DATE" IS '�ۼ���'
   COMMENT ON COLUMN "KFI"."FAQ"."REF" IS '�θ�۹�ȣ'
   COMMENT ON COLUMN "KFI"."FAQ"."LEV" IS '�׷�'
   COMMENT ON COLUMN "KFI"."FAQ"."STEP" IS '��ϼ���'
   COMMENT ON COLUMN "KFI"."FAQ"."ADMIN_NUM" IS '�亯��'
   COMMENT ON TABLE "KFI"."FAQ"  IS '������'
--------------------------------------------------------
--  DDL for Table FRIENDS
--------------------------------------------------------

  CREATE TABLE "KFI"."FRIENDS" ("FRDS_NUM" NUMBER, "USER1_NUM" NUMBER, "USER2_NUM" NUMBER, "FRDS_DATE" DATE) 

   COMMENT ON COLUMN "KFI"."FRIENDS"."FRDS_NUM" IS 'ģ����ȣ'
   COMMENT ON COLUMN "KFI"."FRIENDS"."USER1_NUM" IS '������ȣ1'
   COMMENT ON COLUMN "KFI"."FRIENDS"."USER2_NUM" IS '������ȣ2'
   COMMENT ON COLUMN "KFI"."FRIENDS"."FRDS_DATE" IS 'ģ����¥'
   COMMENT ON TABLE "KFI"."FRIENDS"  IS 'ģ��'
--------------------------------------------------------
--  DDL for Table MEMBERS
--------------------------------------------------------

  CREATE TABLE "KFI"."MEMBERS" ("USER_NUM" NUMBER, "USER_ID" VARCHAR2(50), "USER_PWD" VARCHAR2(50), "USER_NICKNAME" VARCHAR2(50), "USER_EMAIL" VARCHAR2(50), "USER_REGDATE" DATE, "USER_STATUS" NUMBER, "USER_CERTI" NUMBER) 

   COMMENT ON COLUMN "KFI"."MEMBERS"."USER_NUM" IS '������ȣ'
   COMMENT ON COLUMN "KFI"."MEMBERS"."USER_ID" IS '���̵�'
   COMMENT ON COLUMN "KFI"."MEMBERS"."USER_PWD" IS '��й�ȣ'
   COMMENT ON COLUMN "KFI"."MEMBERS"."USER_NICKNAME" IS '�г���'
   COMMENT ON COLUMN "KFI"."MEMBERS"."USER_EMAIL" IS '�̸���'
   COMMENT ON COLUMN "KFI"."MEMBERS"."USER_REGDATE" IS '������'
   COMMENT ON COLUMN "KFI"."MEMBERS"."USER_STATUS" IS '���̵����'
   COMMENT ON COLUMN "KFI"."MEMBERS"."USER_CERTI" IS '��������'
   COMMENT ON TABLE "KFI"."MEMBERS"  IS '�����'
--------------------------------------------------------
--  DDL for Table MY_BOARD
--------------------------------------------------------

  CREATE TABLE "KFI"."MY_BOARD" ("MB_NUM" NUMBER, "USER_NUM" NUMBER, "MB_TITLE" VARCHAR2(50), "MB_CONTENT" VARCHAR2(1000), "MB_DATE" DATE, "MB_VIEWS" NUMBER) 

   COMMENT ON COLUMN "KFI"."MY_BOARD"."MB_NUM" IS '���α۹�ȣ'
   COMMENT ON COLUMN "KFI"."MY_BOARD"."USER_NUM" IS '������ȣ'
   COMMENT ON COLUMN "KFI"."MY_BOARD"."MB_TITLE" IS '������'
   COMMENT ON COLUMN "KFI"."MY_BOARD"."MB_CONTENT" IS '�۳���'
   COMMENT ON COLUMN "KFI"."MY_BOARD"."MB_DATE" IS '�ۼ���'
   COMMENT ON COLUMN "KFI"."MY_BOARD"."MB_VIEWS" IS '��ȸ��'
   COMMENT ON TABLE "KFI"."MY_BOARD"  IS '���ΰԽ���'
--------------------------------------------------------
--  DDL for Table MY_BOARD_LIKE
--------------------------------------------------------

  CREATE TABLE "KFI"."MY_BOARD_LIKE" ("MBL_NUM" NUMBER, "MB_NUM" NUMBER, "USER_NUM" NUMBER) 

   COMMENT ON COLUMN "KFI"."MY_BOARD_LIKE"."MBL_NUM" IS '��õ��ȣ'
   COMMENT ON COLUMN "KFI"."MY_BOARD_LIKE"."MB_NUM" IS '���α۹�ȣ'
   COMMENT ON COLUMN "KFI"."MY_BOARD_LIKE"."USER_NUM" IS '��õ����'
   COMMENT ON TABLE "KFI"."MY_BOARD_LIKE"  IS '���ΰԽñ���õ'
--------------------------------------------------------
--  DDL for Table MY_CHAT
--------------------------------------------------------

  CREATE TABLE "KFI"."MY_CHAT" ("MCHAT_NUM" NUMBER, "MCHAT_TO_NUM" NUMBER, "MCHAT_FROM_NUM" NUMBER, "MCHAT_CONTENT" VARCHAR2(300), "MCHAT_DATE" DATE) 

   COMMENT ON COLUMN "KFI"."MY_CHAT"."MCHAT_NUM" IS 'ä�ù�ȣ'
   COMMENT ON COLUMN "KFI"."MY_CHAT"."MCHAT_TO_NUM" IS '������'
   COMMENT ON COLUMN "KFI"."MY_CHAT"."MCHAT_FROM_NUM" IS '�߽���'
   COMMENT ON COLUMN "KFI"."MY_CHAT"."MCHAT_CONTENT" IS '�۳���'
   COMMENT ON COLUMN "KFI"."MY_CHAT"."MCHAT_DATE" IS '�����ð�'
   COMMENT ON TABLE "KFI"."MY_CHAT"  IS 'ä��'
--------------------------------------------------------
--  DDL for Table MY_COMMENT
--------------------------------------------------------

  CREATE TABLE "KFI"."MY_COMMENT" ("MYC_NUM" NUMBER, "MB_NUM" NUMBER, "USER_NUM" NUMBER, "MYC_CONTENT" VARCHAR2(500), "MYC_DATE" DATE) 

   COMMENT ON COLUMN "KFI"."MY_COMMENT"."MYC_NUM" IS '��۹�ȣ'
   COMMENT ON COLUMN "KFI"."MY_COMMENT"."MB_NUM" IS '���α۹�ȣ'
   COMMENT ON COLUMN "KFI"."MY_COMMENT"."USER_NUM" IS '������ȣ'
   COMMENT ON COLUMN "KFI"."MY_COMMENT"."MYC_CONTENT" IS '��۳���'
   COMMENT ON COLUMN "KFI"."MY_COMMENT"."MYC_DATE" IS '����ۼ���'
   COMMENT ON TABLE "KFI"."MY_COMMENT"  IS '���δ��'
--------------------------------------------------------
--  DDL for Table MY_COMMENT_LIKE
--------------------------------------------------------

  CREATE TABLE "KFI"."MY_COMMENT_LIKE" ("MCL_NUM" NUMBER, "MYC_NUM" NUMBER, "USER_NUM" NUMBER) 

   COMMENT ON COLUMN "KFI"."MY_COMMENT_LIKE"."MCL_NUM" IS '��õ��ȣ'
   COMMENT ON COLUMN "KFI"."MY_COMMENT_LIKE"."MYC_NUM" IS '���δ�۹�ȣ'
   COMMENT ON COLUMN "KFI"."MY_COMMENT_LIKE"."USER_NUM" IS '��õ����'
   COMMENT ON TABLE "KFI"."MY_COMMENT_LIKE"  IS '���δ����õ'
--------------------------------------------------------
--  DDL for Table MY_PHOTO
--------------------------------------------------------

  CREATE TABLE "KFI"."MY_PHOTO" ("MP_NUM" NUMBER, "MB_NUM" NUMBER, "MP_ORGIMG" VARCHAR2(150), "MP_SAVIMG" VARCHAR2(150)) 

   COMMENT ON COLUMN "KFI"."MY_PHOTO"."MP_NUM" IS '������ȣ'
   COMMENT ON COLUMN "KFI"."MY_PHOTO"."MB_NUM" IS '���α۹�ȣ'
   COMMENT ON COLUMN "KFI"."MY_PHOTO"."MP_ORGIMG" IS '��������'
   COMMENT ON COLUMN "KFI"."MY_PHOTO"."MP_SAVIMG" IS '�������'
   COMMENT ON TABLE "KFI"."MY_PHOTO"  IS '���λ���'
--------------------------------------------------------
--  DDL for Table MY_SKIN
--------------------------------------------------------

  CREATE TABLE "KFI"."MY_SKIN" ("MS_NUM" NUMBER, "USER_NUM" NUMBER, "MS_NAME" VARCHAR2(50), "MS_COLOR" VARCHAR2(50), "MS_MSG" VARCHAR2(100), "MS_USING" NUMBER) 

   COMMENT ON COLUMN "KFI"."MY_SKIN"."MS_NUM" IS '��Ų��ȣ'
   COMMENT ON COLUMN "KFI"."MY_SKIN"."USER_NUM" IS '������ȣ'
   COMMENT ON COLUMN "KFI"."MY_SKIN"."MS_NAME" IS '��Ų�̸�'
   COMMENT ON COLUMN "KFI"."MY_SKIN"."MS_COLOR" IS '�÷��ڵ�'
   COMMENT ON COLUMN "KFI"."MY_SKIN"."MS_MSG" IS '���¸޼���'
   COMMENT ON COLUMN "KFI"."MY_SKIN"."MS_USING" IS '������(1/0)'
   COMMENT ON TABLE "KFI"."MY_SKIN"  IS '���ν�Ų'
--------------------------------------------------------
--  DDL for Table MY_SKIN_COVER
--------------------------------------------------------

  CREATE TABLE "KFI"."MY_SKIN_COVER" ("MSC_NUM" NUMBER, "MS_NUM" NUMBER, "MSC_ORGIMG" VARCHAR2(150), "MSC_SAVIMG" VARCHAR2(150)) 

   COMMENT ON COLUMN "KFI"."MY_SKIN_COVER"."MSC_NUM" IS 'Ŀ����ȣ'
   COMMENT ON COLUMN "KFI"."MY_SKIN_COVER"."MS_NUM" IS '��Ų��ȣ'
   COMMENT ON COLUMN "KFI"."MY_SKIN_COVER"."MSC_ORGIMG" IS '��������'
   COMMENT ON COLUMN "KFI"."MY_SKIN_COVER"."MSC_SAVIMG" IS '�������'
   COMMENT ON TABLE "KFI"."MY_SKIN_COVER"  IS '���ν�ŲĿ��'
--------------------------------------------------------
--  DDL for Table MY_SKIN_PROFILE
--------------------------------------------------------

  CREATE TABLE "KFI"."MY_SKIN_PROFILE" ("MSP_NUM" NUMBER, "MS_NUM" NUMBER, "MSP_ORGIMG" VARCHAR2(150), "MSP_SAVIMG" VARCHAR2(150)) 

   COMMENT ON COLUMN "KFI"."MY_SKIN_PROFILE"."MSP_NUM" IS '�����ʹ�ȣ'
   COMMENT ON COLUMN "KFI"."MY_SKIN_PROFILE"."MS_NUM" IS '��Ų��ȣ'
   COMMENT ON COLUMN "KFI"."MY_SKIN_PROFILE"."MSP_ORGIMG" IS '��������'
   COMMENT ON COLUMN "KFI"."MY_SKIN_PROFILE"."MSP_SAVIMG" IS '�������'
   COMMENT ON TABLE "KFI"."MY_SKIN_PROFILE"  IS '���ν�Ų������'
--------------------------------------------------------
--  DDL for Table MY_TAG
--------------------------------------------------------

  CREATE TABLE "KFI"."MY_TAG" ("MTAG_NUM" NUMBER, "TAG_NUM" NUMBER, "MB_NUM" NUMBER) 

   COMMENT ON COLUMN "KFI"."MY_TAG"."MTAG_NUM" IS '�����±׹�ȣ'
   COMMENT ON COLUMN "KFI"."MY_TAG"."TAG_NUM" IS '�±׹�ȣ'
   COMMENT ON COLUMN "KFI"."MY_TAG"."MB_NUM" IS '���α۹�ȣ'
   COMMENT ON TABLE "KFI"."MY_TAG"  IS '�����±�'
--------------------------------------------------------
--  DDL for Table MY_VIDEO
--------------------------------------------------------

  CREATE TABLE "KFI"."MY_VIDEO" ("MV_NUM" NUMBER, "MB_NUM" NUMBER, "MV_ORGVID" VARCHAR2(150), "MV_SAVVID" VARCHAR2(150)) 

   COMMENT ON COLUMN "KFI"."MY_VIDEO"."MV_NUM" IS '�����ȣ'
   COMMENT ON COLUMN "KFI"."MY_VIDEO"."MB_NUM" IS '���α۹�ȣ'
   COMMENT ON COLUMN "KFI"."MY_VIDEO"."MV_ORGVID" IS '��������'
   COMMENT ON COLUMN "KFI"."MY_VIDEO"."MV_SAVVID" IS '���念��'
   COMMENT ON TABLE "KFI"."MY_VIDEO"  IS '���ο���'
--------------------------------------------------------
--  DDL for Table TAG
--------------------------------------------------------

  CREATE TABLE "KFI"."TAG" ("TAG_NUM" NUMBER, "TAG_NAME" VARCHAR2(50)) 

   COMMENT ON COLUMN "KFI"."TAG"."TAG_NUM" IS '�±׹�ȣ'
   COMMENT ON COLUMN "KFI"."TAG"."TAG_NAME" IS '�±׸�'
   COMMENT ON TABLE "KFI"."TAG"  IS '�±�'
--------------------------------------------------------
--  DDL for Table VOTEING_USERLIST
--------------------------------------------------------

  CREATE TABLE "KFI"."VOTEING_USERLIST" ("VU_NUM" NUMBER, "VO_NUM" NUMBER, "USER_NUM" NUMBER) 

   COMMENT ON COLUMN "KFI"."VOTEING_USERLIST"."VU_NUM" IS '����Ʈ��ȣ'
   COMMENT ON COLUMN "KFI"."VOTEING_USERLIST"."VO_NUM" IS '��ǥ���ù�ȣ'
   COMMENT ON COLUMN "KFI"."VOTEING_USERLIST"."USER_NUM" IS '������ȣ'
   COMMENT ON TABLE "KFI"."VOTEING_USERLIST"  IS '��ǥ��������Ʈ'
--------------------------------------------------------
--  DDL for Table VOTING_OPTION
--------------------------------------------------------

  CREATE TABLE "KFI"."VOTING_OPTION" ("VO_NUM" NUMBER, "VOTE_NUM" NUMBER, "OPTION_NUM" NUMBER, "VO_CONTENT" VARCHAR2(200)) 

   COMMENT ON COLUMN "KFI"."VOTING_OPTION"."VO_NUM" IS '��ǥ���ù�ȣ'
   COMMENT ON COLUMN "KFI"."VOTING_OPTION"."VOTE_NUM" IS '��ǥ��ȣ'
   COMMENT ON COLUMN "KFI"."VOTING_OPTION"."OPTION_NUM" IS '��������ȣ'
   COMMENT ON COLUMN "KFI"."VOTING_OPTION"."VO_CONTENT" IS '����������'
   COMMENT ON TABLE "KFI"."VOTING_OPTION"  IS '��ǥ������'
REM INSERTING into KFI.AB_PHOTO
SET DEFINE OFF;
REM INSERTING into KFI.ACCUSE
SET DEFINE OFF;
REM INSERTING into KFI.ADMIN
SET DEFINE OFF;
REM INSERTING into KFI.ADMIN_BOARD
SET DEFINE OFF;
REM INSERTING into KFI.CERTI_MEMBERS
SET DEFINE OFF;
REM INSERTING into KFI.COMM_BOARD
SET DEFINE OFF;
REM INSERTING into KFI.COMM_BOARD_LIKE
SET DEFINE OFF;
REM INSERTING into KFI.COMM_CALENDAR
SET DEFINE OFF;
REM INSERTING into KFI.COMM_CHAT
SET DEFINE OFF;
REM INSERTING into KFI.COMM_COMMENT
SET DEFINE OFF;
REM INSERTING into KFI.COMM_COMMENT_LIKE
SET DEFINE OFF;
REM INSERTING into KFI.COMM_GATHERING
SET DEFINE OFF;
REM INSERTING into KFI.COMM_PHOTO
SET DEFINE OFF;
REM INSERTING into KFI.COMM_REFUSE
SET DEFINE OFF;
REM INSERTING into KFI.COMM_SKIN
SET DEFINE OFF;
REM INSERTING into KFI.COMM_SKIN_COVER
SET DEFINE OFF;
REM INSERTING into KFI.COMM_SKIN_PROFILE
SET DEFINE OFF;
REM INSERTING into KFI.COMM_TAG
SET DEFINE OFF;
REM INSERTING into KFI.COMM_USER_LIST
SET DEFINE OFF;
REM INSERTING into KFI.COMM_VIDEO
SET DEFINE OFF;
REM INSERTING into KFI.COMM_VOTE
SET DEFINE OFF;
REM INSERTING into KFI.COMMUNITY
SET DEFINE OFF;
REM INSERTING into KFI.FAQ
SET DEFINE OFF;
REM INSERTING into KFI.FRIENDS
SET DEFINE OFF;
REM INSERTING into KFI.MEMBERS
SET DEFINE OFF;
REM INSERTING into KFI.MY_BOARD
SET DEFINE OFF;
REM INSERTING into KFI.MY_BOARD_LIKE
SET DEFINE OFF;
REM INSERTING into KFI.MY_CHAT
SET DEFINE OFF;
REM INSERTING into KFI.MY_COMMENT
SET DEFINE OFF;
REM INSERTING into KFI.MY_COMMENT_LIKE
SET DEFINE OFF;
REM INSERTING into KFI.MY_PHOTO
SET DEFINE OFF;
REM INSERTING into KFI.MY_SKIN
SET DEFINE OFF;
REM INSERTING into KFI.MY_SKIN_COVER
SET DEFINE OFF;
REM INSERTING into KFI.MY_SKIN_PROFILE
SET DEFINE OFF;
REM INSERTING into KFI.MY_TAG
SET DEFINE OFF;
REM INSERTING into KFI.MY_VIDEO
SET DEFINE OFF;
REM INSERTING into KFI.TAG
SET DEFINE OFF;
REM INSERTING into KFI.VOTEING_USERLIST
SET DEFINE OFF;
REM INSERTING into KFI.VOTING_OPTION
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index AB_PHOTO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."AB_PHOTO_PK" ON "KFI"."AB_PHOTO" ("AP_NUM")
--------------------------------------------------------
--  DDL for Index ACCUSE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."ACCUSE_PK" ON "KFI"."ACCUSE" ("AC_NUM")
--------------------------------------------------------
--  DDL for Index ADMIN_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."ADMIN_PK" ON "KFI"."ADMIN" ("ADMIN_NUM")
--------------------------------------------------------
--  DDL for Index ADMIN_BOARD_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."ADMIN_BOARD_PK" ON "KFI"."ADMIN_BOARD" ("AB_NUM")
--------------------------------------------------------
--  DDL for Index CERTI_MEMBERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."CERTI_MEMBERS_PK" ON "KFI"."CERTI_MEMBERS" ("CM_NUM")
--------------------------------------------------------
--  DDL for Index COMM_BOARD_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."COMM_BOARD_PK" ON "KFI"."COMM_BOARD" ("CB_NUM")
--------------------------------------------------------
--  DDL for Index COMM_BOARD_LIKE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."COMM_BOARD_LIKE_PK" ON "KFI"."COMM_BOARD_LIKE" ("CBL_NUM")
--------------------------------------------------------
--  DDL for Index COMM_CALENDAR_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."COMM_CALENDAR_PK" ON "KFI"."COMM_CALENDAR" ("CC_NUM")
--------------------------------------------------------
--  DDL for Index COMM_CHAT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."COMM_CHAT_PK" ON "KFI"."COMM_CHAT" ("CCHAT_NUM")
--------------------------------------------------------
--  DDL for Index COMM_COMMENT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."COMM_COMMENT_PK" ON "KFI"."COMM_COMMENT" ("COMMC_NUM")
--------------------------------------------------------
--  DDL for Index COMM_COMMENT_LIKE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."COMM_COMMENT_LIKE_PK" ON "KFI"."COMM_COMMENT_LIKE" ("CCL_NUM")
--------------------------------------------------------
--  DDL for Index COMM_GATHERING_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."COMM_GATHERING_PK" ON "KFI"."COMM_GATHERING" ("CG_NUM")
--------------------------------------------------------
--  DDL for Index COMM_PHOTO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."COMM_PHOTO_PK" ON "KFI"."COMM_PHOTO" ("CP_NUM")
--------------------------------------------------------
--  DDL for Index COMM_REFUSE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."COMM_REFUSE_PK" ON "KFI"."COMM_REFUSE" ("CR_NUM")
--------------------------------------------------------
--  DDL for Index COMM_SKIN_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."COMM_SKIN_PK" ON "KFI"."COMM_SKIN" ("CS_NUM")
--------------------------------------------------------
--  DDL for Index COMM_SKIN_COVER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."COMM_SKIN_COVER_PK" ON "KFI"."COMM_SKIN_COVER" ("CSC_NUM")
--------------------------------------------------------
--  DDL for Index COMM_SKIN_PROFILE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."COMM_SKIN_PROFILE_PK" ON "KFI"."COMM_SKIN_PROFILE" ("CSP_NUM")
--------------------------------------------------------
--  DDL for Index COMM_TAG_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."COMM_TAG_PK" ON "KFI"."COMM_TAG" ("CTAG_NUM")
--------------------------------------------------------
--  DDL for Index COMM_USER_LIST_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."COMM_USER_LIST_PK" ON "KFI"."COMM_USER_LIST" ("CUL_NUM")
--------------------------------------------------------
--  DDL for Index COMM_VIDEO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."COMM_VIDEO_PK" ON "KFI"."COMM_VIDEO" ("CV_NUM")
--------------------------------------------------------
--  DDL for Index COMM_VOTE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."COMM_VOTE_PK" ON "KFI"."COMM_VOTE" ("VOTE_NUM")
--------------------------------------------------------
--  DDL for Index COMMUNITY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."COMMUNITY_PK" ON "KFI"."COMMUNITY" ("COMM_NUM")
--------------------------------------------------------
--  DDL for Index FAQ_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."FAQ_PK" ON "KFI"."FAQ" ("QA_NUM")
--------------------------------------------------------
--  DDL for Index FRIENDS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."FRIENDS_PK" ON "KFI"."FRIENDS" ("FRDS_NUM")
--------------------------------------------------------
--  DDL for Index MEMBERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."MEMBERS_PK" ON "KFI"."MEMBERS" ("USER_NUM")
--------------------------------------------------------
--  DDL for Index MY_BOARD_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."MY_BOARD_PK" ON "KFI"."MY_BOARD" ("MB_NUM")
--------------------------------------------------------
--  DDL for Index MY_BOARD_LIKE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."MY_BOARD_LIKE_PK" ON "KFI"."MY_BOARD_LIKE" ("MBL_NUM")
--------------------------------------------------------
--  DDL for Index MY_CHAT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."MY_CHAT_PK" ON "KFI"."MY_CHAT" ("MCHAT_NUM")
--------------------------------------------------------
--  DDL for Index MY_COMMENT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."MY_COMMENT_PK" ON "KFI"."MY_COMMENT" ("MYC_NUM")
--------------------------------------------------------
--  DDL for Index MY_COMMENT_LIKE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."MY_COMMENT_LIKE_PK" ON "KFI"."MY_COMMENT_LIKE" ("MCL_NUM")
--------------------------------------------------------
--  DDL for Index MY_PHOTO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."MY_PHOTO_PK" ON "KFI"."MY_PHOTO" ("MP_NUM")
--------------------------------------------------------
--  DDL for Index MY_SKIN_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."MY_SKIN_PK" ON "KFI"."MY_SKIN" ("MS_NUM")
--------------------------------------------------------
--  DDL for Index MY_SKIN_COVER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."MY_SKIN_COVER_PK" ON "KFI"."MY_SKIN_COVER" ("MSC_NUM")
--------------------------------------------------------
--  DDL for Index MY_SKIN_PROFILE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."MY_SKIN_PROFILE_PK" ON "KFI"."MY_SKIN_PROFILE" ("MSP_NUM")
--------------------------------------------------------
--  DDL for Index MY_TAG_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."MY_TAG_PK" ON "KFI"."MY_TAG" ("MTAG_NUM")
--------------------------------------------------------
--  DDL for Index MY_VIDEO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."MY_VIDEO_PK" ON "KFI"."MY_VIDEO" ("MV_NUM")
--------------------------------------------------------
--  DDL for Index TAG_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."TAG_PK" ON "KFI"."TAG" ("TAG_NUM")
--------------------------------------------------------
--  DDL for Index VOTEING_USERLIST_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."VOTEING_USERLIST_PK" ON "KFI"."VOTEING_USERLIST" ("VU_NUM")
--------------------------------------------------------
--  DDL for Index VOTING_OPTION_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KFI"."VOTING_OPTION_PK" ON "KFI"."VOTING_OPTION" ("VO_NUM")
--------------------------------------------------------
--  Constraints for Table AB_PHOTO
--------------------------------------------------------

  ALTER TABLE "KFI"."AB_PHOTO" ADD CONSTRAINT "AB_PHOTO_PK" PRIMARY KEY ("AP_NUM") ENABLE
  ALTER TABLE "KFI"."AB_PHOTO" MODIFY ("AP_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table ACCUSE
--------------------------------------------------------

  ALTER TABLE "KFI"."ACCUSE" ADD CONSTRAINT "ACCUSE_PK" PRIMARY KEY ("AC_NUM") ENABLE
  ALTER TABLE "KFI"."ACCUSE" MODIFY ("AC_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table ADMIN
--------------------------------------------------------

  ALTER TABLE "KFI"."ADMIN" ADD CONSTRAINT "ADMIN_PK" PRIMARY KEY ("ADMIN_NUM") ENABLE
  ALTER TABLE "KFI"."ADMIN" MODIFY ("ADMIN_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table ADMIN_BOARD
--------------------------------------------------------

  ALTER TABLE "KFI"."ADMIN_BOARD" ADD CONSTRAINT "ADMIN_BOARD_PK" PRIMARY KEY ("AB_NUM") ENABLE
  ALTER TABLE "KFI"."ADMIN_BOARD" MODIFY ("AB_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table CERTI_MEMBERS
--------------------------------------------------------

  ALTER TABLE "KFI"."CERTI_MEMBERS" ADD CONSTRAINT "CERTI_MEMBERS_PK" PRIMARY KEY ("CM_NUM") ENABLE
  ALTER TABLE "KFI"."CERTI_MEMBERS" MODIFY ("CM_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table COMM_BOARD
--------------------------------------------------------

  ALTER TABLE "KFI"."COMM_BOARD" ADD CONSTRAINT "COMM_BOARD_PK" PRIMARY KEY ("CB_NUM") ENABLE
  ALTER TABLE "KFI"."COMM_BOARD" MODIFY ("CB_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table COMM_BOARD_LIKE
--------------------------------------------------------

  ALTER TABLE "KFI"."COMM_BOARD_LIKE" ADD CONSTRAINT "COMM_BOARD_LIKE_PK" PRIMARY KEY ("CBL_NUM") ENABLE
  ALTER TABLE "KFI"."COMM_BOARD_LIKE" MODIFY ("CBL_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table COMM_CALENDAR
--------------------------------------------------------

  ALTER TABLE "KFI"."COMM_CALENDAR" ADD CONSTRAINT "COMM_CALENDAR_PK" PRIMARY KEY ("CC_NUM") ENABLE
  ALTER TABLE "KFI"."COMM_CALENDAR" MODIFY ("CC_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table COMM_CHAT
--------------------------------------------------------

  ALTER TABLE "KFI"."COMM_CHAT" ADD CONSTRAINT "COMM_CHAT_PK" PRIMARY KEY ("CCHAT_NUM") ENABLE
  ALTER TABLE "KFI"."COMM_CHAT" MODIFY ("CCHAT_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table COMM_COMMENT
--------------------------------------------------------

  ALTER TABLE "KFI"."COMM_COMMENT" ADD CONSTRAINT "COMM_COMMENT_PK" PRIMARY KEY ("COMMC_NUM") ENABLE
  ALTER TABLE "KFI"."COMM_COMMENT" MODIFY ("COMMC_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table COMM_COMMENT_LIKE
--------------------------------------------------------

  ALTER TABLE "KFI"."COMM_COMMENT_LIKE" ADD CONSTRAINT "COMM_COMMENT_LIKE_PK" PRIMARY KEY ("CCL_NUM") ENABLE
  ALTER TABLE "KFI"."COMM_COMMENT_LIKE" MODIFY ("CCL_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table COMM_GATHERING
--------------------------------------------------------

  ALTER TABLE "KFI"."COMM_GATHERING" ADD CONSTRAINT "COMM_GATHERING_PK" PRIMARY KEY ("CG_NUM") ENABLE
  ALTER TABLE "KFI"."COMM_GATHERING" MODIFY ("CG_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table COMM_PHOTO
--------------------------------------------------------

  ALTER TABLE "KFI"."COMM_PHOTO" ADD CONSTRAINT "COMM_PHOTO_PK" PRIMARY KEY ("CP_NUM") ENABLE
  ALTER TABLE "KFI"."COMM_PHOTO" MODIFY ("CP_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table COMM_REFUSE
--------------------------------------------------------

  ALTER TABLE "KFI"."COMM_REFUSE" ADD CONSTRAINT "COMM_REFUSE_PK" PRIMARY KEY ("CR_NUM") ENABLE
  ALTER TABLE "KFI"."COMM_REFUSE" MODIFY ("CR_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table COMM_SKIN
--------------------------------------------------------

  ALTER TABLE "KFI"."COMM_SKIN" ADD CONSTRAINT "COMM_SKIN_PK" PRIMARY KEY ("CS_NUM") ENABLE
  ALTER TABLE "KFI"."COMM_SKIN" MODIFY ("CS_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table COMM_SKIN_COVER
--------------------------------------------------------

  ALTER TABLE "KFI"."COMM_SKIN_COVER" ADD CONSTRAINT "COMM_SKIN_COVER_PK" PRIMARY KEY ("CSC_NUM") ENABLE
  ALTER TABLE "KFI"."COMM_SKIN_COVER" MODIFY ("CSC_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table COMM_SKIN_PROFILE
--------------------------------------------------------

  ALTER TABLE "KFI"."COMM_SKIN_PROFILE" ADD CONSTRAINT "COMM_SKIN_PROFILE_PK" PRIMARY KEY ("CSP_NUM") ENABLE
  ALTER TABLE "KFI"."COMM_SKIN_PROFILE" MODIFY ("CSP_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table COMM_TAG
--------------------------------------------------------

  ALTER TABLE "KFI"."COMM_TAG" ADD CONSTRAINT "COMM_TAG_PK" PRIMARY KEY ("CTAG_NUM") ENABLE
  ALTER TABLE "KFI"."COMM_TAG" MODIFY ("CTAG_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table COMM_USER_LIST
--------------------------------------------------------

  ALTER TABLE "KFI"."COMM_USER_LIST" ADD CONSTRAINT "COMM_USER_LIST_PK" PRIMARY KEY ("CUL_NUM") ENABLE
  ALTER TABLE "KFI"."COMM_USER_LIST" MODIFY ("CUL_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table COMM_VIDEO
--------------------------------------------------------

  ALTER TABLE "KFI"."COMM_VIDEO" ADD CONSTRAINT "COMM_VIDEO_PK" PRIMARY KEY ("CV_NUM") ENABLE
  ALTER TABLE "KFI"."COMM_VIDEO" MODIFY ("CV_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table COMM_VOTE
--------------------------------------------------------

  ALTER TABLE "KFI"."COMM_VOTE" ADD CONSTRAINT "COMM_VOTE_PK" PRIMARY KEY ("VOTE_NUM") ENABLE
  ALTER TABLE "KFI"."COMM_VOTE" MODIFY ("VOTE_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table COMMUNITY
--------------------------------------------------------

  ALTER TABLE "KFI"."COMMUNITY" ADD CONSTRAINT "COMMUNITY_PK" PRIMARY KEY ("COMM_NUM") ENABLE
  ALTER TABLE "KFI"."COMMUNITY" MODIFY ("COMM_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table FAQ
--------------------------------------------------------

  ALTER TABLE "KFI"."FAQ" ADD CONSTRAINT "FAQ_PK" PRIMARY KEY ("QA_NUM") ENABLE
  ALTER TABLE "KFI"."FAQ" MODIFY ("QA_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table FRIENDS
--------------------------------------------------------

  ALTER TABLE "KFI"."FRIENDS" ADD CONSTRAINT "FRIENDS_PK" PRIMARY KEY ("FRDS_NUM") ENABLE
  ALTER TABLE "KFI"."FRIENDS" MODIFY ("FRDS_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table MEMBERS
--------------------------------------------------------

  ALTER TABLE "KFI"."MEMBERS" ADD CONSTRAINT "MEMBERS_PK" PRIMARY KEY ("USER_NUM") ENABLE
  ALTER TABLE "KFI"."MEMBERS" MODIFY ("USER_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table MY_BOARD
--------------------------------------------------------

  ALTER TABLE "KFI"."MY_BOARD" ADD CONSTRAINT "MY_BOARD_PK" PRIMARY KEY ("MB_NUM") ENABLE
  ALTER TABLE "KFI"."MY_BOARD" MODIFY ("MB_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table MY_BOARD_LIKE
--------------------------------------------------------

  ALTER TABLE "KFI"."MY_BOARD_LIKE" ADD CONSTRAINT "MY_BOARD_LIKE_PK" PRIMARY KEY ("MBL_NUM") ENABLE
  ALTER TABLE "KFI"."MY_BOARD_LIKE" MODIFY ("MBL_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table MY_CHAT
--------------------------------------------------------

  ALTER TABLE "KFI"."MY_CHAT" ADD CONSTRAINT "MY_CHAT_PK" PRIMARY KEY ("MCHAT_NUM") ENABLE
  ALTER TABLE "KFI"."MY_CHAT" MODIFY ("MCHAT_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table MY_COMMENT
--------------------------------------------------------

  ALTER TABLE "KFI"."MY_COMMENT" ADD CONSTRAINT "MY_COMMENT_PK" PRIMARY KEY ("MYC_NUM") ENABLE
  ALTER TABLE "KFI"."MY_COMMENT" MODIFY ("MYC_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table MY_COMMENT_LIKE
--------------------------------------------------------

  ALTER TABLE "KFI"."MY_COMMENT_LIKE" ADD CONSTRAINT "MY_COMMENT_LIKE_PK" PRIMARY KEY ("MCL_NUM") ENABLE
  ALTER TABLE "KFI"."MY_COMMENT_LIKE" MODIFY ("MCL_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table MY_PHOTO
--------------------------------------------------------

  ALTER TABLE "KFI"."MY_PHOTO" ADD CONSTRAINT "MY_PHOTO_PK" PRIMARY KEY ("MP_NUM") ENABLE
  ALTER TABLE "KFI"."MY_PHOTO" MODIFY ("MP_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table MY_SKIN
--------------------------------------------------------

  ALTER TABLE "KFI"."MY_SKIN" ADD CONSTRAINT "MY_SKIN_PK" PRIMARY KEY ("MS_NUM") ENABLE
  ALTER TABLE "KFI"."MY_SKIN" MODIFY ("MS_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table MY_SKIN_COVER
--------------------------------------------------------

  ALTER TABLE "KFI"."MY_SKIN_COVER" ADD CONSTRAINT "MY_SKIN_COVER_PK" PRIMARY KEY ("MSC_NUM") ENABLE
  ALTER TABLE "KFI"."MY_SKIN_COVER" MODIFY ("MSC_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table MY_SKIN_PROFILE
--------------------------------------------------------

  ALTER TABLE "KFI"."MY_SKIN_PROFILE" ADD CONSTRAINT "MY_SKIN_PROFILE_PK" PRIMARY KEY ("MSP_NUM") ENABLE
  ALTER TABLE "KFI"."MY_SKIN_PROFILE" MODIFY ("MSP_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table MY_TAG
--------------------------------------------------------

  ALTER TABLE "KFI"."MY_TAG" ADD CONSTRAINT "MY_TAG_PK" PRIMARY KEY ("MTAG_NUM") ENABLE
  ALTER TABLE "KFI"."MY_TAG" MODIFY ("MTAG_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table MY_VIDEO
--------------------------------------------------------

  ALTER TABLE "KFI"."MY_VIDEO" ADD CONSTRAINT "MY_VIDEO_PK" PRIMARY KEY ("MV_NUM") ENABLE
  ALTER TABLE "KFI"."MY_VIDEO" MODIFY ("MV_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table TAG
--------------------------------------------------------

  ALTER TABLE "KFI"."TAG" ADD CONSTRAINT "TAG_PK" PRIMARY KEY ("TAG_NUM") ENABLE
  ALTER TABLE "KFI"."TAG" MODIFY ("TAG_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table VOTEING_USERLIST
--------------------------------------------------------

  ALTER TABLE "KFI"."VOTEING_USERLIST" ADD CONSTRAINT "VOTEING_USERLIST_PK" PRIMARY KEY ("VU_NUM") ENABLE
  ALTER TABLE "KFI"."VOTEING_USERLIST" MODIFY ("VU_NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table VOTING_OPTION
--------------------------------------------------------

  ALTER TABLE "KFI"."VOTING_OPTION" ADD CONSTRAINT "VOTING_OPTION_PK" PRIMARY KEY ("VO_NUM") ENABLE
  ALTER TABLE "KFI"."VOTING_OPTION" MODIFY ("VO_NUM" NOT NULL ENABLE)
