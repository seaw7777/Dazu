use dazu;

show tables;

DROP TABLE class_room;
DROP TABLE class_qna_board;
DROP TABLE class_review;
DROP TABLE class_notice_board;
DROP TABLE class_time_information;
DROP TABLE class_information;
DROP TABLE store_information;
DROP TABLE tip_board;
DROP TABLE recommended_restaurants_board;
DROP TABLE main_notice_board;
DROP TABLE member;

CREATE TABLE member (
usercode varchar(50) NOT NULL,
user_name varchar(10) not null,
create_date datetime DEFAULT current_timestamp(),
gun varchar(10) not null,
gu varchar(10) not null,
si varchar(10) not null,
usertype int(10) not null,
PRIMARY KEY (usercode)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE store_information (
storecode varchar(50) NOT NULL,
store_name varchar(10) NOT NULL,
store_describe varchar(128) NOT NULL,
store_location_si varchar(10) NOT NULL,
store_location_gun varchar(10) NOT NULL,
store_location_gu varchar(10) NOT NULL,
member_usercode varchar(50),
PRIMARY KEY (storecode), 
unique key (member_usercode),
foreign key (member_usercode)
references member (usercode)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE class_information (
classcode varchar(50) not null,
class_name varchar(10) not null,
class_startdate date,
class_enddate date,
class_describe varchar(128),
class_difficult varchar(5),
food_type varchar(5),
store_information_storecode varchar(50),
primary key (classcode),
foreign key (store_information_storecode)
references store_information (storecode)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE class_time_information (
class_timecode varchar(50) not null,
class_starttime time,
class_endtime time,
class_date date,
class_information_classcode varchar(50),
member_usercode varchar(50),
primary key (class_timecode),
foreign key (class_information_classcode)
references class_information (classcode)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE  class_room(
class_time_information_class_timecode varchar(50) not null,
member_usercode varchar(50) not null,
class_information_classcode varchar(50) not null,
primary key (class_time_information_class_timecode),
foreign key (class_time_information_class_timecode)
references class_time_information (class_timecode),
foreign key (member_usercode)
references member (usercode) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE  class_qna_board(
class_qna_board_code int auto_increment,
class_qna_baoard_write_date date,
class_qna_board_write_time time,
class_qna_board_title varchar(128),
class_qna_board_write_contents varchar(256),
class_qna_board_write_good int,
class_qna_board_write_visit int,
member_usercode varchar(50),
class_information_classcode varchar(50),
primary key (class_qna_board_code),
foreign key (class_information_classcode)
references class_information (classcode)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE class_review(
member_usercode varchar(50),
class_review_point int,
class_review_describe varchar(50),
class_information_classcode varchar(50),
primary key (member_usercode),
foreign key (class_information_classcode)
references class_information (classcode) 
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE class_notice_board (
class_notice_board_code int auto_increment,
class_notice_board_write_date date,
class_notice_board_write_time time,
class_notice_board_title varchar(128) not null,
class_notice_board_write_contents varchar(256),
class_notice_board_write_visit int,
class_information_classcode varchar(50),
primary key (class_notice_board_code),
foreign key (class_information_classcode)
references class_information (classcode) 
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tip_board (
tip_board_code int auto_increment,
tip_board_write_date date,
tip_board_time time,
tip_board_title varchar(128) not null,
tip_board_contents varchar(256),
tip_board_good int,
tip_board_visit int,
member_usercode varchar(50),
primary key (tip_board_code),
foreign key (member_usercode)
references member (usercode)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE recommended_restaurants_board (
restaurants_board_code int auto_increment,
restaurants_board_date date,
restaurants_board_time time,
restaurants_board_title varchar(128) not null,
restaurants_board_contents varchar(256) not null,
restaurants_board_good int,
restaurants_board_visit int,
member_usercode varchar(50),
primary key (restaurants_board_code),
foreign key (member_usercode)
references member (usercode)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE main_notice_board(
main_notice_board_code int auto_increment,
main_notice_board_write_date date,
main_notice_board_time time,
main_notice_board_visit int,
main_notice_board_title varchar(128) not null,
main_notice_board_contents varchar(256) not null,
member_usercode varchar(50),
primary key (main_notice_board_code),
foreign key (member_usercode)
references member (usercode)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

show tables;