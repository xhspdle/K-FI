create or replace view createKey
as

select cm.cm_num, m.user_num, m.user_email, cm.cm_key
from members m, certi_members cm
where m.user_num = cm.user_num;