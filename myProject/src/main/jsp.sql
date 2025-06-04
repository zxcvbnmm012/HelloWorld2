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