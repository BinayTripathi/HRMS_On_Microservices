insert into user(id, name, password) values (1,'binay','password');
insert into user(id, name,  password) values (2,'aarna','password');
insert into user(id, name,  password) values (3,'TimesheetAndLeaveService','9999');

insert into role(id, name) values (1,'ROLE_USER');
insert into role(id, name) values (2,'ROLE_ADMIN');
insert into role(id, name) values (3,'ROLE_APP');

insert into user_role(user_id, role_id) values (1,1);
insert into user_role(user_id, role_id) values (2,1);
insert into user_role(user_id, role_id) values (2,2);
insert into user_role(user_id, role_id) values (3,3);

