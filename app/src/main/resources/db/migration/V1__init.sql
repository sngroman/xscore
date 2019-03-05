create table xscore (
  SCORE_EMAIL varchar(255) not null,
  FR_EMAIL varchar(255),
  START_DATE date,
  END_DATE date,
  SCORE_STATUS varchar(20),
  primary key (SCORE_EMAIL)
) ENGINE=INNODB;


create table xscore_history (
  ID int auto_increment,
  SCORE_EMAIL varchar(255) not null,
  FR_EMAIL varchar(255),
  START_DATE date,
  END_DATE date,
  SCORE_STATUS varchar(20),
  PREVIOUS_ID int,
  primary key (ID),
  Foreign key (PREVIOUS_ID) references xscore_history(ID)
) ENGINE=INNODB;

