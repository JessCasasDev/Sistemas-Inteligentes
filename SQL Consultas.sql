alter table role modify permissions VARCHAR(150);

insert into role (role_id, name, permissions) values(1, 'Administrator', '(CR,RE,DE,UP)_EM;(CR,RE,DE,UP)_PU;(CR,DE,RE,UP)_DI;(CR,DE,RE,UP)_ST;(CR,DE,RE,UP)_VE;(CR,DE,RE,UP)_CL');
insert into role (role_id, name, permissions) values(2, 'Client', '(CR,RE,UP)_OR; (DE,RE,UP)_CL;(RE)_ST; (RE)_DI' );
insert into role (role_id, name, permissions) values(3, 'Employee', '(CR,RE,UP)_EM; (RE)_MO');
SELECT * FROM `role`;

alter table authentication
  modify auth_id int not null auto_increment;