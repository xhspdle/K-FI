create or replace view my_skin_view
as 
    select ms.ms_num, ms.user_num, ms.ms_name, ms.ms_color, ms.ms_msg, ms.ms_using, msp.msp_num, msp.msp_orgimg, msp.msp_savimg, msc.msc_num, msc.msc_orgimg, msc.msc_savimg
    from my_skin ms, my_skin_profile msp, my_skin_cover msc
    where msp.ms_num = msc.ms_num and ms.ms_num=msp.ms_num;
