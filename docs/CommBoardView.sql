--커뮤니티 해당 게시글의 게시글내용, 사진, 영상, 댓글, 추천 불러오기
--수정 필요


/*create or replace view comm_board_view
as
    select 
    cb.cb_num, cb.comm_num, cb.user_num, cb.cb_title, cb.cb_content, cb.cb_date, cb.cb_notice, cb.cb_views,
    cp.cp_num, cp.cp_orgimg, cp.cp_savimg,
    cv.cv_num, cv.cv_orgvid, cv.cv_savvid,
    cc.commc_num, cc.user_num commc_user_num, cc.commc_content, cc.commc_date,cc.commc_like,
    cbl.cbl_num, cbl.user_num cbl_user_num
    from comm_board cb, comm_photo cp, comm_video cv, comm_comment cc, comm_board_like cbl
    where cb.cb_num=cp.cb_num and cb.cb_num=cv.cb_num and cb.cb_num=cc.cb_num and cb.cb_num=cbl.cb_num;
      
commit;*/



create or replace view comm_board_view
as
    select 
    cb.cb_num, cb.comm_num, cb.user_num, cb.cb_title, cb.cb_content, cb.cb_date, cb.cb_notice, cb.cb_views,
    cp.cp_num, cp.cp_orgimg, cp.cp_savimg,
    cv.cv_num, cv.cv_orgvid, cv.cv_savvid,
    cc.commc_num, cc.user_num commc_user_num, cc.commc_content, cc.commc_date,cc.commc_like,
    cbl.cbl_num, cbl.user_num cbl_user_num,
    ct.tag_num
    from comm_board cb, comm_photo cp, comm_video cv, comm_comment cc, comm_board_like cbl, comm_tag ct
    where cb.cb_num=cp.cb_num(+) and cb.cb_num=cv.cb_num(+) and cb.cb_num=cc.cb_num(+) and cb.cb_num=cbl.cb_num(+) and cb.cb_num=ct.cb_num(+);
      
commit;