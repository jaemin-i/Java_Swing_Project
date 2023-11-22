create table login(
    id varchar(20),
    pw varchar(384),
    identity char(1),
    constraint c_identity check ( identity in ('D', 'M')),
    constraint p_id primary key (id)
);

create table perInfo(
    id      varchar(20),
    email   varchar(30),
    HP      varchar(13),
    constraint f_id foreign key (id) references login (id),
    constraint p_id_per primary key (id)
);

create table memInfo(
    id      varchar(20),
    memCode varchar(4),
    name    varchar(20),
    sex     char(1),
    birth   date,
    constraint c_sex check ( sex in ('M', 'F') ),
    constraint f_id_Info foreign key (id) references login (id),
    constraint p_memCode_Info primary key (memCode)
);

create table questions(
    memCode     varchar(4),
    q_index     varchar(4),
    MD          varchar(20),
    title       varchar(50),
    questionsText  text,
    questionsDate datetime,
    status      int,
    finish      int,
    constraint p_memCode_questions primary key (memCode, q_index),
    constraint f_memCode_questions foreign key (memCode) references memInfo(memCode)
);

create table answer(
    memCode     varchar(4),
    q_index     varchar(4),
    a_index     varchar(4),
    answerText  text,
    answerDate  datetime,
    constraint p_memCode_answer primary key (memCode,q_index),
    constraint f_memCode_answer foreign key (memCode) references memInfo(memCode)
);

create table docInfo(
    memCode     varchar(4),
    name        varchar(20),
    hospital    varchar(50),
    MD          varchar(50),
    constraint p_memCode_docInfo primary key (memCode),
    constraint f_memCode_docInfo foreign key (memCode) references memInfo(memCode)
);

create table answerLog
(
    q_index char(4),
    a_index char(4),
    textlog text,
    datelog datetime
);

set global time_zone ='Asia/Seoul';
set time_zone ='+09:00';

insert into login (id, pw, identity) values ('docter', sha2('docter1234', 512), 'D');
insert into login (id, pw, identity) values ('user', sha2('user1234', 512), 'M');
insert into perInfo (id, email, HP) values ('docter', 'docker', '010-2222-2222');
insert into perInfo (id, email, HP) values ('user', 'user', '010-1111-1111');
insert into memInfo (id, memCode, name, sex, birth) values ('docter', 'D001', '의사', 'M', '2000-01-01');
insert into memInfo (id, memCode, name, sex, birth) values ('user', 'M001', '유저', 'M', '2000-01-01');
insert into docInfo (memCode, name, hospital, MD) values ('D001', '의사', '푸른내과', '내과');
insert into questions (memCode, q_index, MD, title, questionsText, questionsDate, status, finish) values ('M001', 'Q001', '내과', '뭔가어질어질하고', '어질어질하고매우짜증이나뮤ㅠ.
언제까지 이딴짓을 해야하는지', '2022-12-10 15:12:00', 2, 0);
insert into questions (memCode, q_index, MD, title, questionsText, questionsDate, status, finish) values ('M001', 'Q002', '내과', '비교적 날씨맑음', '모르겠다..', '2022-12-10 15:13:00', 0, 0);
insert into answer (memCode, q_index, a_index, answerText, answerDate) values ('D001', 'Q001', 'A001', '다시 한번 수정을 하자면..
그래도 곧종강..?', '2022-12-10 15:13:27');
insert into answerLog (q_index, a_index, textlog, datelog) values ('Q001', 'A001', '그래요..
안타깝죠
어쩔수없어요
잘버텨봐요', '2022-12-10 15:13:27');
insert into answerLog (q_index, a_index, textlog, datelog) values ('Q001', 'A001', '다시 한번 수정을 하자면..
그래도 곧종강..?', '2022-12-10 15:13:48');

