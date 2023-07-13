# BaseBallProject

### 더미데이터
```mysql
select * from stadium;
select * from team;
select * from player;
select * from out_player;

-- 구장 3개
create table `stadium`(
`id` int primary key auto_increment,
`name` varchar(10),
`created_at` timestamp
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 팀 3개
create table `team`(
`id` int primary key auto_increment,
`stadium_id` int,
foreign key (stadium_id) references stadium(id),
`name` varchar(10),
`created_at` timestamp
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 선수 9명
create table `player`(
`id` int primary key auto_increment,
`team_id` int, foreign key (team_id) references team(id),
`name` varchar(10),
`position` varchar(10),
`created_at` timestamp
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 퇴출 선수
create table `out_player`(
`id` int primary key auto_increment,
`player_id` int, foreign key (player_id) references player(id),
`reason` varchar(10),
`created_at` timestamp
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE player ADD CONSTRAINT unique_player UNIQUE (team_id, position);

-- 경기장 데이터
insert into stadium (name, created_at) values ('사직', now());
insert into stadium (name, created_at) values ('대구', now());
insert into stadium (name, created_at) values ('광주', now());

-- 팀 데이터
insert into team (stadium_id, name, created_at) values ('1', '롯데', now());
insert into team (stadium_id, name, created_at) values ('2', '삼성', now());
insert into team (stadium_id, name, created_at) values ('3', '기아', now());

-- 선수 데이터
insert into player (team_id, name, position, created_at) values(1, '나균안', '투수', now());
insert into player (team_id, name, position, created_at) values(1, '유강남', '포수', now());
insert into player (team_id, name, position, created_at) values(1, '고승민', '1루수', now());
insert into player (team_id, name, position, created_at) values(1, '안치홍', '2루수', now());
insert into player (team_id, name, position, created_at) values(1, '한동희', '3루수', now());
insert into player (team_id, name, position, created_at) values(1, '노진혁', '유격수', now());
insert into player (team_id, name, position, created_at) values(1, '황성빈', '좌익수', now());
insert into player (team_id, name, position, created_at) values(1, '안권수', '중견수', now());
insert into player (team_id, name, position, created_at) values(1, '잭렉스', '우익수', now());

-- 퇴출 선수 데이터
insert into out_player(player_id, reason, created_at) values(2, '도박', now());
insert into out_player(player_id, reason, created_at) values(3, '성매매', now());
```



