insert into person (id, birth_date, house_no, pincode, road , name) values (107, sysdate() , 28, '600096' , 'Perungudi' , 'Lakshman')
insert into person (id, birth_date, house_no, pincode, road , name) values (106, sysdate() , 28, '600096' , 'Thoraipakkam' , 'Ram')
insert into person (id, birth_date, house_no, pincode, road , name) values (105, sysdate() , 4, '600096' , 'OMR' , 'SaiDeepak')
insert into person (id, birth_date, house_no, pincode, road , name) values (104, sysdate() , 27, '700021' , 'DB Street' , 'Binay')
insert into person (id, birth_date, house_no, pincode, road , name) values (103, sysdate() , 27, '700021' , 'DB Street' , 'Bina')
insert into person (id, birth_date, house_no, pincode, road , name) values (102, sysdate() , 27, '700021' , 'DB Street' , 'Bin')
insert into person (id, birth_date, house_no, pincode, road , name) values (101, sysdate() , 27, '700021' , 'DB Street' , 'Bi')


insert into iemployee (designation, employee_type, exit_date, joining_date, id, person_obj_id , manager_id, plant_location) values ('DELIVERY_HEAD', 'CONTRACT', NULL, sysdate(), 1007, 107,NULL, 3)
insert into contract_employee (contract_duration, hourly_rate, id) values (12,300, 1007)

insert into iemployee (designation, employee_type, exit_date, joining_date, id, person_obj_id , manager_id, plant_location) values ('GENERAL_MANAGER', 'PERMANENT', NULL, sysdate(), 1006, 106, 1007, 3)
insert into permanent_employee (annual_salary, id) values (3500000, 1006)

insert into iemployee (designation, employee_type, exit_date, joining_date, id, person_obj_id , manager_id, plant_location) values ('TECHNICAL_SPECIALIST', 'PERMANENT', NULL, sysdate(), 1005, 105, 1006, 3)
insert into permanent_employee (annual_salary, id) values (1700000, 1005)

insert into iemployee (designation, employee_type, exit_date, joining_date, id, person_obj_id , manager_id, plant_location) values ('TECHNICAL_SPECIALIST', 'PERMANENT', NULL, sysdate(), 1004, 104, 1006, 3)
insert into permanent_employee (annual_salary, id) values (1700000, 1004)

insert into iemployee (designation, employee_type, exit_date, joining_date, id, person_obj_id , manager_id, plant_location) values ('TECHNICAL_LEAD', 'PERMANENT', NULL, sysdate(), 1003, 103, 1004, 3)
insert into permanent_employee (annual_salary, id) values (1200000, 1003)

insert into iemployee (designation, employee_type, exit_date, joining_date, id, person_obj_id , manager_id, plant_location) values ('SENIOR_SOFTWARE_ENGINNER', 'PERMANENT', NULL, sysdate(), 1002, 102, 1003, 3)
insert into permanent_employee (annual_salary, id) values (1000000, 1002)

insert into iemployee (designation, employee_type, exit_date, joining_date, id, person_obj_id , manager_id, plant_location) values ('SOFTWARE_ENGINEER', 'PERMANENT', NULL, sysdate(), 1001, 101, 1002, 3)
insert into permanent_employee (annual_salary, id) values (600000, 1001)













