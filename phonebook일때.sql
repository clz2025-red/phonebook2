##########################################################
# phonebook 만들기
##########################################################

-- -------------------------------------------------------
# phonebook 계정에서 실행
-- -------------------------------------------------------
-- db선택
use phonebook_db;

-- 테이블삭제
drop table person;

-- 테이블생성
create table person(
	person_id	int				primary key	   auto_increment,
    name 		varchar(30)		not null,
    hp			varchar(20),
    company 	varchar(20)
);

-- 조회
select 	person_id,
		name,
        hp,
        company
from person
order by person_id desc
;

select 	person_id,
		name,
        hp,
        company
from person
where person_id = 1
;



-- 등록
insert into person
values(null, '정우성', '010-1111-1111', '02-1111-1111')
;

insert into person
values(null, '이효리', '010-2222-2222', '02-2222-2222')
;

insert into person
values(null, '강호동', '010-9999-9999', '02-9999-9999')
;

-- 수정
update person
set name = '서장훈',
	hp = '010-3333-33333',
	company = '02-3333-3333'
where person_id = 1
;

-- 삭제
delete from person
where person_id = 3
;
