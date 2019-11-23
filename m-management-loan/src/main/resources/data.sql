/* ========== Insert scripts for MS loan database ========== */

/* Library */

INSERT INTO public.library(id, name) VALUES (1,'Bibliothèque 1');
INSERT INTO public.library(id, name) VALUES (2,'Bibliothèque 2');
INSERT INTO public.library(id, name) VALUES (3,'Bibliothèque 3');

/* Account */

INSERT INTO public.account(id, email, first_name, last_name, phone_number) VALUES (1,'arnaud@mail.fr','Arnaud','Laval','0655065506');
INSERT INTO public.account(id, email, first_name, last_name, phone_number) VALUES (2,'jean@mail.fr','Jean','Laval','0655065506');
INSERT INTO public.account(id, email, first_name, last_name, phone_number) VALUES (3,'marc@mail.fr','Marc','Laval','0655065506');

/* Book */

INSERT INTO public.book(id, condition, title, library_id) VALUES (1,'GOOD','Les misérables',1);
INSERT INTO public.book(id, condition, title, library_id) VALUES (2,'NEW','Notre-Dame de Paris',1);
INSERT INTO public.book(id, condition, title, library_id) VALUES (3,'DAMAGING','J''accuse',1);
INSERT INTO public.book(id, condition, title, library_id) VALUES (4,'WORN','L''oeuvre',2);
INSERT INTO public.book(id, condition, title, library_id) VALUES (5,'GOOD','L''assommoir',2);
INSERT INTO public.book(id, condition, title, library_id) VALUES (6,'WORN','Les paradis artificiels',2);
INSERT INTO public.book(id, condition, title, library_id) VALUES (7,'NEW','Les fleurs du mal',3);
INSERT INTO public.book(id, condition, title, library_id) VALUES (8,'NEW','L''homme qui rit',3);
INSERT INTO public.book(id, condition, title, library_id) VALUES (9,'WORN','Germinal',3);
INSERT INTO public.book(id, condition, title, library_id) VALUES (10,'DAMAGING','Nana',3);

/* Loan */

INSERT INTO public.loan(id, expected_return_date, extended, loan_date, status, account_id, book_id) VALUES (1,'2019-05-03 23:00:00.000',true,'2019-05-03 23:00:00.000','FINISH',1,5);
INSERT INTO public.loan(id, expected_return_date, extended, loan_date, status, account_id, book_id) VALUES (2,'2019-05-03 23:00:00.000',false,'2019-05-03 23:00:00.000','ONGOING',2,9);
INSERT INTO public.loan(id, expected_return_date, extended, loan_date, status, account_id, book_id) VALUES (3,'2019-05-03 23:00:00.000',false,'2019-05-03 23:00:00.000','OUTDATED',3,1);