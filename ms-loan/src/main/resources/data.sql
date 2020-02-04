/* ========== Insert scripts for MS loan database ========== */

/* Books */

INSERT INTO public.book(id,condition,summary,title,cover)
VALUES (1,'GOOD','Le forçat Jean Valjean est libéré d''une prison française après avoir purgé une peine de dix-neuf ans pour le vol d''une miche de pain et plusieurs tentatives d''évasion. Lorsqu''il arrive dans la ville de Digne, personne n''est disposé à lui donner refuge parce qu''il est un ex-condamné. Désespéré, Valjean frappe à la porte de M.Myriel, l''évêque de Digne, qui le traite avec gentillesse.','Les misérables','/image/covers/lesmiserables.jpg');
INSERT INTO public.book(id,condition,summary,title,cover)
VALUES (2,'NEW','Dans le Paris du XVe siècle, une jeune et superbe gitane appelée Esméralda danse sur le parvis de Notre Dame. Sa beauté bouleverse l''archidiacre de Notre-Dame, Claude Frollo, qui veut la faire enlever par son sonneur de cloches, le mal-formé Quasimodo. Esméralda est sauvée par une escouade d''archers, commandée par le capitaine de la garde Phoebus de Châteaupers.','Notre-Dame de Paris','/image/covers/notredamedeparis.jpg');
INSERT INTO public.book(id,condition,summary,title,cover)
VALUES (3,'DAMAGING','« J''accuse… ! » est une lettre écrite par Émile Zola à l''intention du président français de l''époque Félix Faure parue dans le quotidien parisien L''Aurore le 13 janvier 1898 concernant l''Affaire Dreyfus. Cette très longue lettre reproche à Félix Faure, d''avoir fait condamner à tort un innocent (Alfred Dreyfus) mais de laisser libre le coupable (Esterhazy).','J''accuse','/image/covers/jaccuse.jpg');
INSERT INTO public.book(id,condition,summary,title,cover)
VALUES (5,'GOOD','Gervaise, la fille d''Antoine Macquart, a, à vingt-deux ans, fui Plassans avec son amant, Auguste Lantier, un ouvrier chapelier, et leurs deux enfants, Claude et Étienne . À Paris, ils habitent un hôtel meublé misérable dans le quartier populaire de la Goutte-d’Or. Lantier abandonne vite la jeune femme, emportant tout ce qui reste de leurs maigres économies.','L''assommoir','/image/covers/lassommoir.jpg');
INSERT INTO public.book(id,condition,summary,title,cover)
VALUES (7,'NEW','Les Fleurs du mal, Œuvre majeure de Charles Baudelaire, le recueil de poèmes Les Fleurs du Mal, intégrant la quasi-totalité de la production poétique de l’auteur depuis 1840, est publié le 23juin 1857 et a été réédité en 1861. C’est l’une des œuvres les plus importantes de la poésie moderne, empreinte d’une nouvelle esthétique où la beauté et le sublime surgissent, grâce au langage poétique...','Les fleurs du mal','/image/covers/lesfleursdumal.jpg');
INSERT INTO public.book(id,condition,summary,title,cover)
VALUES (9,'WORN','Fils de Gervaise Macquart et de son amant Lantier, le jeune Etienne Lantier s''est fait renvoyer de son travail pour avoir donné une gifle à son employeur. Chômeur, il part, en pleine crise industrielle, dans le Nord de la France, à la recherche d’un nouveau emploi. Il se fait embaucher aux mines de Montsou et connaît des conditions de travail effroyables','Germinal','/image/covers/germinal.jpg');

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

