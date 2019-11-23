INSERT INTO address (id,city,number,postal_code,street) VALUES (1,'BX',1,33000,'rue du paradis');
INSERT INTO address (id,city,number,postal_code,street) VALUES (2,'BX',2,33000,'rue du paradis');
INSERT INTO address (id,city,number,postal_code,street) VALUES (3,'BX',3,33000,'rue du paradis');

INSERT INTO client (id,birth_date,email,first_name,gender,last_name,phone_number,role,client_number,address_id)
VALUES (1,'1987-05-03 23:00:00.000','arnaud@mail.fr','Arnaud','MALE','Laval','0655065506','CLIENT',13365,1);
INSERT INTO client (id,birth_date,email,first_name,gender,last_name,phone_number,role,client_number,address_id)
VALUES (2,'1987-05-03 23:00:00.000','jean@mail.fr','Jean','MALE','Laval','0655065506','CLIENT',13366,2);
INSERT INTO client (id,birth_date,email,first_name,gender,last_name,phone_number,role,client_number,address_id)
VALUES (3,'1987-05-03 23:00:00.000','marc@mail.fr','Marc','MALE','Laval','0655065506','CLIENT',13367,3);