-- MY_COMMENT
ALTER TABLE MY_COMMENT
	DROP CONSTRAINT FK_MY_COMMENT_MB_NUM_MY_BOARD_;

ALTER TABLE MY_COMMENT
    ADD CONSTRAINT FK_MY_COMMENT_MB_NUM_MY_BOARD_ FOREIGN KEY (MB_NUM)
        REFERENCES MY_BOARD (MB_NUM) ON DELETE CASCADE;
        
-- MY_PHOTO
ALTER TABLE MY_PHOTO
	DROP CONSTRAINT FK_MY_PHOTO_MB_NUM_MY_BOARD_MB;

ALTER TABLE MY_PHOTO
    ADD CONSTRAINT FK_MY_PHOTO_MB_NUM_MY_BOARD_MB FOREIGN KEY (MB_NUM)
        REFERENCES MY_BOARD (MB_NUM) ON DELETE CASCADE;
        
-- MY_VIDEO
ALTER TABLE MY_VIDEO
	DROP CONSTRAINT FK_MY_VIDEO_MB_NUM_MY_BOARD_MB;

ALTER TABLE MY_VIDEO
    ADD CONSTRAINT FK_MY_VIDEO_MB_NUM_MY_BOARD_MB FOREIGN KEY (MB_NUM)
        REFERENCES MY_BOARD (MB_NUM) ON DELETE CASCADE;
        
-- MY_COMMENT_LIKE
ALTER TABLE MY_COMMENT_LIKE
	DROP CONSTRAINT FK_MY_COMMENT_LIKE_MYC_NUM_MY_;

ALTER TABLE MY_COMMENT_LIKE
    ADD CONSTRAINT FK_MY_COMMENT_LIKE_MYC_NUM_MY_ FOREIGN KEY (MYC_NUM)
        REFERENCES MY_COMMENT (MYC_NUM) ON DELETE CASCADE;
        
-- MY_BOARD_LIKE
ALTER TABLE MY_BOARD_LIKE
	DROP CONSTRAINT FK_MY_BOARD_LIKE_MB_NUM_MY_BOA;

ALTER TABLE MY_BOARD_LIKE
    ADD CONSTRAINT FK_MY_BOARD_LIKE_MB_NUM_MY_BOA FOREIGN KEY (MB_NUM)
        REFERENCES MY_BOARD (MB_NUM) ON DELETE CASCADE;
        
-- COMM_COMMENT
ALTER TABLE COMM_COMMENT
	DROP CONSTRAINT FK_COMM_COMMENT_CB_NUM_COMM_BO;

ALTER TABLE COMM_COMMENT
    ADD CONSTRAINT FK_COMM_COMMENT_CB_NUM_COMM_BO FOREIGN KEY (CB_NUM)
        REFERENCES COMM_BOARD (CB_NUM) ON DELETE CASCADE;
        
-- COMM_PHOTO
ALTER TABLE COMM_PHOTO
	DROP CONSTRAINT FK_COMM_PHOTO_CB_NUM_COMM_BOAR;

ALTER TABLE COMM_PHOTO
    ADD CONSTRAINT FK_COMM_PHOTO_CB_NUM_COMM_BOAR FOREIGN KEY (CB_NUM)
        REFERENCES COMM_BOARD (CB_NUM) ON DELETE CASCADE;
        
-- COMM_VIDEO
ALTER TABLE COMM_VIDEO
	DROP CONSTRAINT FK_COMM_VIDEO_CB_NUM_COMM_BOAR;

ALTER TABLE COMM_VIDEO
    ADD CONSTRAINT FK_COMM_VIDEO_CB_NUM_COMM_BOAR FOREIGN KEY (CB_NUM)
        REFERENCES COMM_BOARD (CB_NUM) ON DELETE CASCADE;
        
-- COMM_COMMENT_LIKE
ALTER TABLE MY_COMMENT_LIKE
	DROP CONSTRAINT FK_MY_COMMENT_LIKE_MYC_NUM_MY_;

ALTER TABLE MY_COMMENT_LIKE
    ADD CONSTRAINT FK_MY_COMMENT_LIKE_MYC_NUM_MY_ FOREIGN KEY (MYC_NUM)
        REFERENCES MY_COMMENT (MYC_NUM) ON DELETE CASCADE;
        
-- COMM_BOARD_LIKE
ALTER TABLE COMM_COMMENT_LIKE
	DROP CONSTRAINT FK_COMM_COMMENT_LIKE_COMMC_NUM;

ALTER TABLE COMM_COMMENT_LIKE
    DROP CONSTRAINT FK_COMM_COMMENT_LIKE_COMMC_NUM FOREIGN KEY (COMMC_NUM)
        REFERENCES COMM_COMMENT (COMMC_NUM) ON DELETE CASCADE;

-- COMM_VOTE
ALTER TABLE COMM_VOTE
	DROP CONSTRAINT FK_COMM_VOTE_COMM_NUM_COMMUNIT;
	
ALTER TABLE COMM_VOTE
    ADD CONSTRAINT FK_COMM_VOTE_COMM_NUM_COMMUNIT FOREIGN KEY (COMM_NUM)
        REFERENCES COMMUNITY (COMM_NUM)	ON DELETE CASCADE;
	
ALTER TABLE COMM_VOTE
	DROP CONSTRAINT FK_COMM_VOTE_USER_NUM_MEMBERS_;

ALTER TABLE COMM_VOTE
    ADD CONSTRAINT FK_COMM_VOTE_USER_NUM_MEMBERS_ FOREIGN KEY (USER_NUM)
        REFERENCES MEMBERS (USER_NUM) ON DELETE CASCADE;
        
-- VOTING_OPTION
ALTER TABLE VOTING_OPTION
	DROP CONSTRAINT FK_VOTING_OPTION_VOTE_NUM_COMM;

ALTER TABLE VOTING_OPTION
    ADD CONSTRAINT FK_VOTING_OPTION_VOTE_NUM_COMM FOREIGN KEY (VOTE_NUM)
        REFERENCES COMM_VOTE (VOTE_NUM) ON DELETE CASCADE;
        
-- VOTING_USERLIST
ALTER TABLE VOTING_USERLIST
	DROP CONSTRAINT FK_VOTING_USERLIST_VO_NUM_VOTI;
	
ALTER TABLE VOTING_USERLIST
    ADD CONSTRAINT FK_VOTING_USERLIST_VO_NUM_VOTI FOREIGN KEY (VO_NUM)
        REFERENCES VOTING_OPTION (VO_NUM) ON DELETE CASCADE;	
        
ALTER TABLE VOTING_USERLIST
	DROP CONSTRAINT FK_VOTING_USERLIST_USER_NUM_ME;
	
ALTER TABLE VOTING_USERLIST
    ADD CONSTRAINT FK_VOTING_USERLIST_USER_NUM_ME FOREIGN KEY (USER_NUM)
        REFERENCES MEMBERS (USER_NUM) ON DELETE CASCADE;	
     
-- MY_TAG
ALTER TABLE MY_TAG
	DROP CONSTRAINT FK_MY_TAG_MB_NUM_MY_BOARD_MB_N;
        
ALTER TABLE MY_TAG
    ADD CONSTRAINT FK_MY_TAG_MB_NUM_MY_BOARD_MB_N FOREIGN KEY (MB_NUM)
        REFERENCES MY_BOARD (MB_NUM) ON DELETE CASCADE;	
        
-- COMM_TAG
ALTER TABLE COMM_TAG
	DROP CONSTRAINT FK_COMM_TAG_CB_NUM_COMM_BOARD_;
        
ALTER TABLE COMM_TAG
    ADD CONSTRAINT FK_COMM_TAG_CB_NUM_COMM_BOARD_ FOREIGN KEY (CB_NUM)
        REFERENCES COMM_BOARD (CB_NUM) ON DELETE CASCADE;	

        
        
        
        