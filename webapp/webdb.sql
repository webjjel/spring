--drop table emaillist;
--drop table guestbook;
--drop table board;
--drop table user;

-- 이메일목록
CREATE TABLE `emaillist` (
	`no`         INTEGER UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '번호',   -- 번호
	`first_name` VARCHAR(50)      NOT NULL                COMMENT '성',     -- 성
	`last_name`  VARCHAR(50)      NOT NULL                COMMENT '이름',   -- 이름
	`email`      VARCHAR(200)     NOT NULL                COMMENT '이메일', -- 이메일
	PRIMARY KEY(no)
)ENGINE=INNODB COMMENT '이메일목록';



-- 방명록
CREATE TABLE `guestbook` (
	`no`       INTEGER UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '번호', -- 번호
	`name`     VARCHAR(100)     NOT NULL COMMENT '이름',                -- 이름
	`reg_date` DATETIME         NOT NULL COMMENT '등록일',              -- 등록일
	`message`  TEXT             NOT NULL COMMENT '메세지',              -- 메세지
	`password`   VARCHAR(64)    NOT NULL COMMENT '비밀번호',            -- 비밀번호
	PRIMARY KEY(no)
)ENGINE=INNODB COMMENT '방명록';


-- 회원
CREATE TABLE `user` (
	`no`     INTEGER UNSIGNED      NOT NULL AUTO_INCREMENT COMMENT '번호',     -- 번호
	`name`   VARCHAR(100)          NOT NULL                COMMENT '이름',     -- 이름
	`email`  VARCHAR(200)          NOT NULL                COMMENT '이메일',   -- 이메일
	`passwd` VARCHAR(80)           NOT NULL                COMMENT '비밀번호', -- 비밀번호
	`gender` ENUM('FEMALE','MALE') NOT NULL                COMMENT '성별',     -- 성별
	PRIMARY KEY(no)
)ENGINE=INNODB COMMENT '회원';

-- 게시판
CREATE TABLE `board` (
	`no`         INTEGER UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '번호',     -- 번호
	`title`      VARCHAR(200)     NOT NULL                COMMENT '제목',     -- 제목
	`content`    TEXT             NOT NULL                COMMENT '내용',     -- 내용
	`view_count` INTEGER UNSIGNED NOT NULL                COMMENT '조회수',   -- 조회수
	`reg_date`   DATETIME         NOT NULL                COMMENT '작성일',   -- 작성일
	`user_no`    INTEGER UNSIGNED NOT NULL                COMMENT '회원번호', -- 회원번호
        PRIMARY KEY(no),
        CONSTRAINT `FK_user_TO_board` FOREIGN KEY (`user_no`) REFERENCES `user` (`no`)
)ENGINE=INNODB COMMENT '게시판';


