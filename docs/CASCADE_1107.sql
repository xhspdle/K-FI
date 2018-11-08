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