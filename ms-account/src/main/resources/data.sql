/* ========== Insert scripts for MS account database ========== */

/* Address */

INSERT INTO public.address (id_address,city,number,postal_code,street) VALUES (1,'BX',1,33000,'rue du paradis');
INSERT INTO public.address (id_address,city,number,postal_code,street) VALUES (2,'BX',2,33000,'rue du paradis');
INSERT INTO public.address (id_address,city,number,postal_code,street) VALUES (3,'BX',3,33000,'rue du paradis');

/* Clients */

INSERT INTO public.client (id_account,birth_date,date_of_creation,date_of_update,email,first_name,gender,last_name,phone_number,role,client_number,id_address)
VALUES (1,'1987-05-03 23:00:00.000','2020-01-20 23:00:00.000','2020-01-20 23:00:00.000','arnaudlaval33@gmail.com','Arnaud','MALE','Laval','0655065506','CLIENT',13365,1);
INSERT INTO public.client (id_account,birth_date,date_of_creation,date_of_update,email,first_name,gender,last_name,phone_number,role,client_number,id_address)
VALUES (2,'1987-05-03 23:00:00.000','2020-01-20 23:00:00.000','2020-01-20 23:00:00.000','admin@mail.fr','Jean','MALE','Laval','0655065506','ADMIN',13366,2);
INSERT INTO public.client (id_account,birth_date,date_of_creation,date_of_update,email,first_name,gender,last_name,phone_number,role,client_number,id_address)
VALUES (3,'1987-05-03 23:00:00.000','2020-01-20 23:00:00.000','2020-01-20 23:00:00.000','employee@mail.fr','Marc','MALE','Laval','0655065506','EMPLOYEE',13367,3);