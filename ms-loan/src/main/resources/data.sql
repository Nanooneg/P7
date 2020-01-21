/* ========== Insert scripts for MS loan database ========== */

/* Loan */

INSERT INTO public.loan(id, expected_return_date, extended, loan_date, status, account_id, book_id)
VALUES (1,'2019-05-03 23:00:00.000',true,'2019-09-03 23:00:00.000','FINISH',1,5);
INSERT INTO public.loan(id, expected_return_date, extended, loan_date, status, account_id, book_id)
VALUES (2,'2020-01-29 23:00:00.000',false,'2020-01-15 23:00:00.000','ONGOING',1,9);
INSERT INTO public.loan(id, expected_return_date, extended, loan_date, status, account_id, book_id)
VALUES (3,'2020-01-20 23:00:00.000',false,'2020-01-06 23:00:00.000','OUTDATED',1,1);
INSERT INTO public.loan(id, expected_return_date, extended, loan_date, status, account_id, book_id)
VALUES (4,'2019-05-03 23:00:00.000',false,'2019-06-03 23:00:00.000','FINISH',1,3);
INSERT INTO public.loan(id, expected_return_date, extended, loan_date, status, account_id, book_id)
VALUES (5,'2019-05-03 23:00:00.000',false,'2019-05-03 23:00:00.000','FINISH',1,2);
INSERT INTO public.loan(id, expected_return_date, extended, loan_date, status, account_id, book_id)
VALUES (6,'2019-05-03 23:00:00.000',false,'2019-04-03 23:00:00.000','FINISH',1,7);
