/* ========== Insert scripts for MS loan database ========== */

/* Books */

INSERT INTO public.book(id_book, cover, title) VALUES (1,'/image/covers/lesmiserables.jpg','Les misérables');
INSERT INTO public.book(id_book, cover, title) VALUES (2,'/image/covers/notredamedeparis.jpg','Notre-Dame de Paris');
INSERT INTO public.book(id_book, cover, title) VALUES (3,'/image/covers/jaccuse.jpg','J''accuse');
INSERT INTO public.book(id_book, cover, title) VALUES (5,'/image/covers/lassommoir.jpg','L''assommoir');
INSERT INTO public.book(id_book, cover, title) VALUES (7,'/image/covers/lesfleursdumal.jpg','Les fleurs du mal');
INSERT INTO public.book(id_book, cover, title) VALUES (9,'/image/covers/germinal.jpg','Germinal');

/* Clients */

INSERT INTO public.client(id_client, client_number, email, first_name, last_name) VALUES (1,13365,'arnaudlaval33@gmail.com','Arnaud','Laval');

/* CopyBook */

INSERT INTO public.copy_book(id_copy_book, condition, id_book) VALUES (22,'GOOD',5);
INSERT INTO public.copy_book(id_copy_book, condition, id_book) VALUES (34,'GOOD',9);
INSERT INTO public.copy_book(id_copy_book, condition, id_book) VALUES (11,'GOOD',3);
INSERT INTO public.copy_book(id_copy_book, condition, id_book) VALUES (6,'NEW',2);
INSERT INTO public.copy_book(id_copy_book, condition, id_book) VALUES (26,'GOOD',7);
INSERT INTO public.copy_book(id_copy_book, condition, id_book) VALUES (2,'GOOD',1);

/* Loan */

INSERT INTO public.loan(id_loan, effective_return_date, expected_return_date, extended, loan_date, status, id_account, id_copy_book) VALUES (1,'2019-09-01 23:00:00.000','2019-09-03 23:00:00.000',false,'2019-08-20 23:00:00.000','FINISH',1,22);
INSERT INTO public.loan(id_loan, effective_return_date, expected_return_date, extended, loan_date, status, id_account, id_copy_book) VALUES (2,'2019-10-20 23:00:00.000','2019-10-29 23:00:00.000',false,'2019-10-15 23:00:00.000','FINISH',1,34);
INSERT INTO public.loan(id_loan, effective_return_date, expected_return_date, extended, loan_date, status, id_account, id_copy_book) VALUES (3,'2019-11-04 23:00:00.000','2019-11-03 23:00:00.000',false,'2019-10-30 23:00:00.000','FINISH',1,11);
INSERT INTO public.loan(id_loan, effective_return_date, expected_return_date, extended, loan_date, status, id_account, id_copy_book) VALUES (4,'2019-12-01 23:00:00.000','2019-12-03 23:00:00.000',false,'2019-11-05 23:00:00.000','FINISH',1,6);
INSERT INTO public.loan(id_loan, effective_return_date, expected_return_date, extended, loan_date, status, id_account, id_copy_book) VALUES (5,null,'2020-02-19 23:00:00.000',false,'2020-01-22 23:00:00.000','OUTDATED',1,26);
INSERT INTO public.loan(id_loan, effective_return_date, expected_return_date, extended, loan_date, status, id_account, id_copy_book) VALUES (6,null,'2020-02-25 23:00:00.000',false,'2020-01-28 23:00:00.000','ONGOING',1,2);

