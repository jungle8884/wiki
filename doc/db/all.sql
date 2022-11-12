drop table if exists test;
create table test (
    id bigint not null comment 'id',
    name varchar(20) comment '名字',
    password varchar(50) comment '密码',
    primary key (id)
) engine=innodb default charset=utf8mb4 comment='测试';
insert into test(id, name, password) values(1, 'jungle', '123');
select * from test;

drop table if exists demo;
create table demo (
                      id bigint not null comment 'id',
                      name varchar(20) comment '名字',
                      primary key (id)
) engine=innodb default charset=utf8mb4 comment='测试';
insert into demo(id, name) values(1, 'jungle');
select * from demo;
