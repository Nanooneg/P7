/* ========== Insert scripts for MS loan database ========== */

/* Books */

INSERT INTO public.book(id,condition,summary,title,cover)
VALUES (1,'GOOD','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum mattis semper luctus. Cras quis maximus justo. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec quis bibendum nisl. Phasellus sollicitudin, eros sit amet suscipit interdum, lectus ipsum fringilla est, sed pretium libero ipsum id elit. Aliquam interdum, ligula aliquet congue turpis duis.','Les misérables','/image/cover-1.jpg');
INSERT INTO public.book(id,condition,summary,title,cover)
VALUES (2,'NEW','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum mattis semper luctus. Cras quis maximus justo. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec quis bibendum nisl. Phasellus sollicitudin, eros sit amet suscipit interdum, lectus ipsum fringilla est, sed pretium libero ipsum id elit. Aliquam interdum, ligula aliquet congue turpis duis.','Notre-Dame de Paris','/image/cover-1.jpg');
INSERT INTO public.book(id,condition,summary,title,cover)
VALUES (3,'DAMAGING','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum mattis semper luctus. Cras quis maximus justo. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec quis bibendum nisl. Phasellus sollicitudin, eros sit amet suscipit interdum, lectus ipsum fringilla est, sed pretium libero ipsum id elit. Aliquam interdum, ligula aliquet congue turpis duis.','J''accuse','/image/cover-1.jpg');
INSERT INTO public.book(id,condition,summary,title,cover)
VALUES (5,'GOOD','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum mattis semper luctus. Cras quis maximus justo. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec quis bibendum nisl. Phasellus sollicitudin, eros sit amet suscipit interdum, lectus ipsum fringilla est, sed pretium libero ipsum id elit. Aliquam interdum, ligula aliquet congue turpis duis.','L''assommoir','/image/cover-2.jpg');
INSERT INTO public.book(id,condition,summary,title,cover)
VALUES (7,'NEW','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum mattis semper luctus. Cras quis maximus justo. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec quis bibendum nisl. Phasellus sollicitudin, eros sit amet suscipit interdum, lectus ipsum fringilla est, sed pretium libero ipsum id elit. Aliquam interdum, ligula aliquet congue turpis duis.','Les fleurs du mal','/image/cover-3.jpg');
INSERT INTO public.book(id,condition,summary,title,cover)
VALUES (9,'WORN','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum mattis semper luctus. Cras quis maximus justo. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec quis bibendum nisl. Phasellus sollicitudin, eros sit amet suscipit interdum, lectus ipsum fringilla est, sed pretium libero ipsum id elit. Aliquam interdum, ligula aliquet congue turpis duis.','Germinal','/image/cover-3.jpg');

/* Clients */

INSERT INTO public.client (id,email,first_name,last_name,client_number)
VALUES (1,'arnaudlaval33@gmail.com','Arnaud','Laval',13365);

/* Loan */

INSERT INTO public.loan(id, expected_return_date, extended, loan_date, status, account_id, book_id)
VALUES (1,'2019-05-03 23:00:00.000',false,'2019-09-03 23:00:00.000','FINISH',1,5);
INSERT INTO public.loan(id, expected_return_date, extended, loan_date, status, account_id, book_id)
VALUES (2,'2020-01-29 23:00:00.000',false,'2020-01-15 23:00:00.000','ONGOING',1,9);
INSERT INTO public.loan(id, expected_return_date, extended, loan_date, status, account_id, book_id)
VALUES (4,'2019-05-03 23:00:00.000',true,'2019-06-03 23:00:00.000','FINISH',1,3);
INSERT INTO public.loan(id, expected_return_date, extended, loan_date, status, account_id, book_id)
VALUES (5,'2019-05-03 23:00:00.000',true,'2019-05-03 23:00:00.000','FINISH',1,2);
INSERT INTO public.loan(id, expected_return_date, extended, loan_date, status, account_id, book_id)
VALUES (6,'2019-05-03 23:00:00.000',false,'2019-04-03 23:00:00.000','FINISH',1,7);
INSERT INTO public.loan(id, expected_return_date, extended, loan_date, status, account_id, book_id)
VALUES (7,'2020-01-26 23:00:00.000',false,'2020-01-12 23:00:00.000','OUTDATED',1,1);