insert into court(id,name,capacity) values (1,'Court1',1000);
insert into court(id,name,capacity) values (2,'Court2',2000);
insert into court(id,name,capacity) values (3,'Court3',3000);
insert into court(id,name,capacity) values (4,'Court4',4000);
insert into court(id,name,capacity) values (5,'Court5',5000);
insert into court(id,name,capacity) values (6,'Court6',6000);
insert into court(id,name,capacity) values (7,'Court7',7000);

insert into users(id,email,password,first_name,last_name)
values (1,'email1','password1','fname1','lname1');
insert into users(id,email,password,first_name,last_name)
values (2,'email2','password2','fname2','lname2');
insert into users(id,email,password,first_name,last_name)
values (3,'email3','password3','fname3','lname3');

insert into player(player_id,age,career_earnings,nationality,ranking)
values(1,25,30000,'Spaniard',13);

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');