DROP TABLE users;
DROP TABLE authorities;


create table tbl_users(
    id          VARCHAR2(50) not null primary key,
    password    VARCHAR2(256) not null,
    height      NUMBER(5,0),
    address     VARCHAR(50) not null,
    position    VARCHAR(1),
    grade       NUMBER(1,1),
    nickName    VARCHAR2(40)not null,
    regDate     DATE,
    updateDate  DATE
);
--id,password,height,address,position,grade,nickName
create table tbl_auth(
	id			VARCHAR2(50) not null,
	authority	varchar2(200) not null,
	constraint fk_tbl_auth_tbl_users FOREIGN key(id)REFERENCES tbl_users(id)
);

insert into tbl_users (id, password, address, nickname)VALUES('user00', '1234', 'seoul', 'siamor');
insert into tbl_users (id, password, address, nickname)VALUES('member00', '1234','seoul', '3pointer' );
insert into tbl_users (id, password, address, nickname)VALUES('admin00', '1234', 'seoul', 'bob');

select * from tbl_users;

insert into authorities(id, authority) VALUES('user00', 'ROLE_MEMBER');
insert into authorities(id, authority) VALUES('member00', 'ROLE_MEMBER');
insert into authorities(id, authority) VALUES('admin00', 'ROLE_MEMBER');
insert into authorities(id, authority) VALUES('admin00', 'ROLE_ADMIN');

select * from authorities;