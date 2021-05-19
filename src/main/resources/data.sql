insert into courts(id,name,capacity) values (1,'Court1',1000);
insert into courts(id,name,capacity) values (2,'Court2',2000);
insert into courts(id,name,capacity) values (3,'Court3',3000);
insert into courts(id,name,capacity) values (4,'Court4',4000);
insert into courts(id,name,capacity) values (5,'Court5',5000);
insert into courts(id,name,capacity) values (6,'Court6',6000);
insert into courts(id,name,capacity) values (7,'Court7',7000);

insert into users(id,email,password,first_name,last_name)
values (1,'email1','password1','fname1','lname1');
insert into users(id,email,password,first_name,last_name)
values (2,'email2','password2','fname2','lname2');
insert into users(id,email,password,first_name,last_name)
values (3,'email3','password3','fname3','lname3');

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_PLAYER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');


INSERT INTO TOURNAMENTS(id,city,name,surface,winner_points,start_date,end_date)
values (1,'Cluj-Napoca','CJ Open','CLAY',1024,null,null);
INSERT INTO TOURNAMENTS(id,city,name,surface,winner_points,start_date,end_date)
values (2,'Bucuresti','Bucharest Open','CLAY',512,null,null);
INSERT INTO TOURNAMENTS(id,city,name,surface,winner_points,start_date,end_date)
values (3,'Sibiu','Hermanndstadt Tour','HARD',1024,null,null);
INSERT INTO TOURNAMENTS(id,city,name,surface,winner_points,start_date,end_date)
values (4,'Oradea','Oradea Tennis Pro League','GRASS',512,null,null);


INSERT INTO PLAYERS(player_id, birth_date,career_points, gender, country, primary_hand, ranking)
values (1,CURRENT_TIMESTAMP-11050, 1000,'MALE', 'Romania','LEFT',1);
INSERT INTO PLAYERS(player_id, birth_date,career_points, gender, country, primary_hand, ranking)
values (2,CURRENT_TIMESTAMP-12000, 500,'MALE', 'Spain','LEFT',2);
INSERT INTO PLAYERS(player_id, birth_date,career_points, gender, country, primary_hand, ranking)
values (3,CURRENT_TIMESTAMP-10000, 200,'MALE', 'Romania','LEFT',3);

INSERT INTO MATCHES(id,phase,set1,set2,set3,start_time,court_id,first_player_id,second_player_id,tournament_id)
values(1, 'FIRST_ROUND','6-1','6-2',null,CURRENT_TIMESTAMP,1,1,2,1);
INSERT INTO MATCHES(id,phase,set1,set2,set3,start_time,court_id,first_player_id,second_player_id,tournament_id)
values(2, 'FINAL','6-4','6-4',null,CURRENT_TIMESTAMP,1,1,2,2);
INSERT INTO MATCHES(id,phase,set1,set2,set3,start_time,court_id,first_player_id,second_player_id,tournament_id)
values(3, 'SEMIFINAL','6-1','2-6','7-5',CURRENT_TIMESTAMP,1,3,2,1)