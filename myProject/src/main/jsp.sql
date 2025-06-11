create sequence board_seq;

create table tbl_board(
    board_no number primary key, -- �Խñ۹�ȣ
    title varchar2(100) not null, -- ����
    content varchar2(1000) not null, -- ����
    writer varchar2(30) not null, -- �ۼ���
    write_date date default sysdate, -- �ۼ��Ͻ�
    read_cnt number default 0); -- ��ȸ��
    
insert into tbl_board(board_no, title, content, writer)
values (board_seq.nextval, '�Խñۿ���', '�۵�Ͽ������Դϴ�', 'user01');

insert into tbl_board(board_no, title, content, writer)
values (board_seq.nextval, 'mybatis', 'mybatis�� �����ӿ�ũ�Դϴ�', 'user02');

insert into tbl_board(board_no, title, content, writer)
values (board_seq.nextval, 'JSP�� ���?', '���� �����ϳ� ��վ��', 'user03');

insert into tbl_board(board_no, title, content, writer)
values (board_seq.nextval, '����������̤�', '�����ּ���...', 'user02');

select * from tbl_board;

select to_char(write_date, 'yyyy-mm-dd hh24:mi:ss') wdate
from tbl_board;



-- ����¡ó��
-- board_no ��������
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
where title='JSP�� ���?';

create table tbl_member( member_id varchar2(30) primary key,
                         member_name varchar2(100) not null,
                         password varchar2(50) not null,
                         responsibility varchar2(10) default 'User');
                         
Insert into tbl_member
values ('user01', '���ع�', '1234', 'User');
                         
Insert into tbl_member
values ('user06', '��ŰƼ', '1234', 'User');

Insert into tbl_member
values ('user03', '���̿�', '1234', 'User');

Insert into tbl_member
values ('user05', '���ڹ�', '1234', 'User');

Insert into tbl_member
values ('user99', '��ÿ�', '1234', 'User');

Insert into tbl_member
values ('guest', '�����', '1234', 'Admin');

select * from tbl_member;
