select *
from test1
where 1=1
-- and column_name = 'col11'
and column_name1 like 'col%'
and 1=1;

select * from user_info
where 1=1
and username = 'user';

select coalesce(id, 0) from user_info;

create table user_info
(
    id       numeric not null,
    username varchar not null,
    email    varchar not null,
    password varchar,
    constraint user_info_pk
        primary key (id, username)
);


insert into user_info (id, username, email, password)
values ((select coalesce(max(id), 0) + 1 from user_info),
        'user', 'test@tes.com', 'password');


select coalesce(max(id) + 1, 1) from user_info;

select coalesce(max(id), 0) + 1 from user_info;


