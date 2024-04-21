systemshi - 1,2,3,12,13,14,15
user-4,5,6,7,8,9,10,11

1##
create role iovashvili_role;

grant create session, create any table, create any view, create any index, create any sequence,
create any synonym, alter any table, alter any index, alter any sequence, drop any table,
drop any view, drop any index, drop any sequence, drop any synonym to iovashvili_role;

grant select on hr.employees to iovashvili_role;

grant dba to iovashvili_role;


//2
create user btu_iovashvili IDENTIFIED by btu
default tablespace users QUOTA UNLIMITED on users
TEMPORARY TABLESPACE temp
profile default;

select * from dba_users where username = 'BTU_IOVASHVILI';

grant iovashvili_role to btu_iovashvili;


//3

show user;

select * from dba_objects where owner = 'BTU_IOVASHVILI';


//4

create table test_iovashvili(id number,salary number(5,2),
status generated always as (
case when salary <= 500 then 'low'
when salary > 500 then 'good' end),comm varchar2(30) invisible);

create index sal_idx on test_iovashvili(salary);


//5
create SEQUENCE seq_iovashvili start with 10 INCREMENT BY 5
NOCACHE NOCYCLE ORDER MAXVALUE 1000 MINVALUE 10;

//6

CREATE or replace trigger test_tr
before insert on test_iovashvili
for each row
begin 
select seq_iovashvili.nextval into :new.id from dual;
end;


//7

insert into test_iovashvili(salary,comm) values (450,'btu is the best');
insert into test_iovashvili(salary,comm) values (120,'cool exam');
insert into test_iovashvili(salary,comm) values (150,'this day');
insert into test_iovashvili(salary,comm) values  ( 580,'perfect thing');
insert into test_iovashvili(salary,comm) values (890,'good idea');
insert into test_iovashvili(salary,comm) values (900,'great option');
commit;

//8

create table emp as
select * from hr.employees
where length(last_name)>7;


create table emp2 as
select * from emp
where 2 = 1;


//9
create view my_exam_view as
select * from emp where rownum <=5;

//10
create synonym t_iov for test_iovashvili;
create synonym vu for my_exam_view;


//11

//a)

insert into test_iovashvili(salary,comm) values(300,'gtu forever');

//b)

update test_iovashvili set comm = comm|| trunc(sysdate)
where id = 20;
commit;

//c)
delete from test_iovashvili where mod(length(comm),2) = 0;
commit;


//d)

alter table test_iovashvili add manager number;

//e)
alter table test_iovashvili MODIFY manager varchar2(50);

//f)

alter table test_iovashvili rename column manager to man;

//g)
alter table test_iovashvili drop column man;

//h)

alter table test_iovashvili set UNUSED(comm);

//i)
alter table test_iovashvili RENAME to iova_tab;

//j)
alter table iova_tab read only;


//12
create profile exam_prof_iovashvili LIMIT
COMPOSITE_LIMIT default
SESSIONS_PER_USER 30
CPU_PER_SESSION unlimited
CPU_PER_CALL unlimited
LOGICAL_READS_PER_SESSION 400000
LOGICAL_READS_PER_CALL 10000
IDLE_TIME 8
CONNECT_TIME 200
PRIVATE_SGA default
FAILED_LOGIN_ATTEMPTS 20
PASSWORD_LIFE_TIME 100
PASSWORD_REUSE_TIME 140
PASSWORD_REUSE_MAX 15
PASSWORD_VERIFY_FUNCTION null
PASSWORD_LOCK_TIME 3
PASSWORD_GRACE_TIME 18;

//13
alter user btu_iovashvili IDENTIFIED by btu23 profile exam_prof_iovashvili;


//14
audit all statements by btu_iovashvili;
select * from dba_audit_trail;
select * from DBA_STMT_AUDIT_OPTS;
select * from SYS.AUD$;
noaudit all statements by btu_iovashvili;

//15

drop user btu_iovashvili cascade;
drop role iovashvili_role;
drop profile exam_prof_iovashvili  cascade;
select *  from dba_users where username= 'BTU_IOVASHVILI';

