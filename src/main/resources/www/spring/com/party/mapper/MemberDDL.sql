/*
 * 회원가입 테이블 생성 및 관리(CRUD) 목적 DDL
 * Edit by songam(K.T.LIM)
 * 2019.11.24.
 */

drop table tbl_user;

create index idx_user on tbl_user(id);

-- id, password, height, grade, address, nickname, position, gender, regdate, updatedate
create table tbl_user (
	id					varchar2(12) primary key,		-- id 12자리, 중복체크(반드시 입력)
	password		varchar2(256) not null,				-- pwd, 정규식 8~12자리(반드시 입력)
	height			number(3,0) not null,				-- 신장(반드시 입력)
	grade			number(2,1),								-- 평판점수(5점 만점 기준)로 가입초기는 '0'
	address			varchar2(100), 							-- 시/군(구)/동 주소까지만
	nickname		varchar2(50),							-- 별명
	position    		varchar2(1),								-- 포지션, 1:Point Guard, 2:Shooting Guard, 3:Small Forward, 4:Power Forward, 5:Center 
	gender			varchar2(1),								-- 성별, 1:남자, 2:여자
	regdate			date default sysdate,				-- 등록일자
	updatedate	date default sysdate				-- 변경일자
);

insert into tbl_member(id, password, height, grade, address, nickname, position, gender)
	values('songami', '1234', 172, 65, '서울시 마포구 이대입구역', '불광동휘발유', '1', '1');
	
select * from tbl_member;    

select id from tbl_member where id = 'songami';

create table tbl_party (
    id          			integer     primary key,		-- 자동부여, 
    descriminator   char(1) not null,   --T, M
    --for All
    nick_name   		varchar2(50),
    --for Member
    login_id    			varchar2(50),
    pwd         			varchar2(256),
    height      			integer,            --cm
    address     		varchar2(100),
    position    			char(1),            --F, G, C
    grade       			integer,
    --for Team
    intro       			varchar2(1000),
    win_cnt     		integer,
    loss_cnt    			integer
);

create table tbl_board_type (
    type        	char(1),				-- 1:자유게시판, 2:매칭게시판, 3:팀원찾아요
    name        varchar2(50),
    intro       	varchar2(1000)
);
    

create table tbl_posting(
     id          				integer 	primary key,									-- 자동채번, 게시글 번호
     descriminator   	char(1) not null,   											-- 1:게시글, 2:댓글
     board_type 			char(1) REFERENCES tbl_board_type(type), 	-- 1:자유게시판, 2:매칭게시판, 3:팀원찾아요												-- 
     party_id   			integer REFERENCES tbl_party(id),					-- 1:
     parent_id  			integer REFERENCES tbl_posting(id),
     title      				varchar2(100),
     content    			varchar2(2000)
);

