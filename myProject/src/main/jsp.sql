create sequence board_seq;

create table tbl_board(
    board_no number primary key, -- 게시글번호
    title varchar2(100) not null, -- 제목
    content varchar2(1000) not null, -- 내용
    writer varchar2(30) not null, -- 작성자
    write_date date default sysdate, -- 작성일시
    read_cnt number default 0); -- 조회수
    
insert into tbl_board(board_no, title, content, writer)
values (board_seq.nextval, '게시글연습', '글등록연습중입니다', 'user01');

insert into tbl_board(board_no, title, content, writer)
values (board_seq.nextval, 'mybatis', 'mybatis는 프레임워크입니다', 'user02');

insert into tbl_board(board_no, title, content, writer)
values (board_seq.nextval, 'JSP는 어때요?', '조금 복잡하나 재밌어요', 'user03');

insert into tbl_board(board_no, title, content, writer)
values (board_seq.nextval, '에러가나요ㅜㅜ', '도와주세요...', 'user02');

select * from tbl_board;

select to_char(write_date, 'yyyy-mm-dd hh24:mi:ss') wdate
from tbl_board;



-- 페이징처리
-- board_no 기준정렬
select b.*
from (select rownum rn, a.*
      from (select *
            from tbl_board
           
            order by board_no desc) a) b
where b.rn >= (:page - 1)*5
and b.rn <= :page * 5 ;


insert into tbl_board (board_no, title, content, writer)
select board_seq.nextval, title, content, writer
from tbl_board;


select count(*)
from tbl_board;

select * from tbl_board
where title='JSP는 어때요?';

create table tbl_member( member_id varchar2(30) primary key,
                         member_name varchar2(100) not null,
                         password varchar2(50) not null,
                         responsibility varchar2(10) default 'User');
                         
Insert into tbl_member
values ('user01', '김해민', '1234', 'User');
                         
Insert into tbl_member
values ('user06', '조키티', '1234', 'User');

Insert into tbl_member
values ('user03', '손이영', '1234', 'User');

Insert into tbl_member
values ('user05', '박자바', '1234', 'User');

Insert into tbl_member
values ('user99', '김시욱', '1234', 'User');

Insert into tbl_member
values ('guest', '김관리', '1234', 'Admin');

select * from tbl_member;
