/* ========== Insert scripts for MS book database ========== */

/* Address */

INSERT INTO public.address(id_address, city, "number", postal_code, street) VALUES (1,'BX',1,33000,'rue du paradis');
INSERT INTO public.address(id_address, city, "number", postal_code, street) VALUES (2,'BX',1,33000,'rue de l''enfer');
INSERT INTO public.address(id_address, city, "number", postal_code, street) VALUES (3,'BX',1,33000,'rue du purgatoire');
INSERT INTO public.address(id_address, city, "number", postal_code, street) VALUES (4,'BX',85,33000,'Cours Maréchal Juin');
INSERT INTO public.address(id_address, city, "number", postal_code, street) VALUES (5,'BX',145,33000,'Rue de Saint- Genès');
INSERT INTO public.address(id_address, city, "number", postal_code, street) VALUES (6,'BX',10,33000,'Place des Capucins');

/* Cover */

INSERT INTO public.cover(id_cover, path, title) VALUES (1,'/image/cover-1.jpg','test');
INSERT INTO public.cover(id_cover, path, title) VALUES (2,'/image/cover-2.jpg','test');
INSERT INTO public.cover(id_cover, path, title) VALUES (3,'/image/cover-3.jpg','test');
INSERT INTO public.cover(id_cover, path, title) VALUES (4,'/image/covers/germinal.jpg','germinal');
INSERT INTO public.cover(id_cover, path, title) VALUES (5,'/image/covers/jaccuse.jpg','j''accuse');
INSERT INTO public.cover(id_cover, path, title) VALUES (6,'/image/covers/lassommoir.jpg','l''assommoir');
INSERT INTO public.cover(id_cover, path, title) VALUES (7,'/image/covers/lesfleursdumal.jpg','les fleurs du mal');
INSERT INTO public.cover(id_cover, path, title) VALUES (8,'/image/covers/lesmiserables.jpg','les miserables');
INSERT INTO public.cover(id_cover, path, title) VALUES (9,'/image/covers/lesparadisartificiels.jpg','les paradis artificiels');
INSERT INTO public.cover(id_cover, path, title) VALUES (10,'/image/covers/lhommmequirit.jpeg','l''hommme qui rit');
INSERT INTO public.cover(id_cover, path, title) VALUES (11,'/image/covers/loeuvre.jpg','l''oeuvre');
INSERT INTO public.cover(id_cover, path, title) VALUES (12,'/image/covers/nana.jpg','nana');
INSERT INTO public.cover(id_cover, path, title) VALUES (13,'/image/covers/notredamedeparis.jpg','notre dame de paris');

/* Library */

INSERT INTO public.library(id_library, name, phone_number, id_address) VALUES (1,'Bibliothèque Mériadeck','0556103000',4);
INSERT INTO public.library(id_library, name, phone_number, id_address) VALUES (2,'Bibliothèque diocésienne','0547502102',5);
INSERT INTO public.library(id_library, name, phone_number, id_address) VALUES (3,'Bibliothèque Capucins','0556911879',6);

/* Authors */

INSERT INTO public.author(id_author, first_name, last_name) VALUES (1,'Victor','Hugo');
INSERT INTO public.author(id_author, first_name, last_name) VALUES (2,'Emile','Zola');
INSERT INTO public.author(id_author, first_name, last_name) VALUES (3,'Charles','Baudelaire');

/* Books */

INSERT INTO public.book(id_book, category, registration, summary, title, id_author, id_cover) VALUES (1,'NOVEL',now(),'Le forçat Jean Valjean est libéré d''une prison française après avoir purgé une peine de dix-neuf ans pour le vol d''une miche de pain et plusieurs tentatives d''évasion. Lorsqu''il arrive dans la ville de Digne, personne n''est disposé à lui donner refuge parce qu''il est un ex-condamné. Désespéré, Valjean frappe à la porte de M.Myriel, l''évêque de Digne, qui le traite avec gentillesse.','Les misérables',1,8);
INSERT INTO public.book(id_book, category, registration, summary, title, id_author, id_cover) VALUES (2,'NOVEL',now(),'Dans le Paris du XVe siècle, une jeune et superbe gitane appelée Esméralda danse sur le parvis de Notre Dame. Sa beauté bouleverse l''archidiacre de Notre-Dame, Claude Frollo, qui veut la faire enlever par son sonneur de cloches, le mal-formé Quasimodo. Esméralda est sauvée par une escouade d''archers, commandée par le capitaine de la garde Phoebus de Châteaupers.','Notre-Dame de Paris',1,13);
INSERT INTO public.book(id_book, category, registration, summary, title, id_author, id_cover) VALUES (3,'NOVEL',now(),'« J''accuse… ! » est une lettre écrite par Émile Zola à l''intention du président français de l''époque Félix Faure parue dans le quotidien parisien L''Aurore le 13 janvier 1898 concernant l''Affaire Dreyfus. Cette très longue lettre reproche à Félix Faure, d''avoir fait condamner à tort un innocent (Alfred Dreyfus) mais de laisser libre le coupable (Esterhazy).','J''accuse',2,5);
INSERT INTO public.book(id_book, category, registration, summary, title, id_author, id_cover) VALUES (4,'NOVEL',now(),'Claude est un artiste-peintre parisien renommé et reconnu qui vit dans le luxe et la volupté. Son mouvement avant-gardiste dit "du plein air" connaît un franc succès tant public que critique. Il vit heureux mais bien seul car il n''a aucun ami. Il s''attire d''ailleurs la jalousie des compagnons de son enfance à Plassans (où il naquit et où il revint faire ses études).','L''oeuvre',2,11);
INSERT INTO public.book(id_book, category, registration, summary, title, id_author, id_cover) VALUES (5,'NOVEL',now(),'Gervaise, la fille d''Antoine Macquart, a, à vingt-deux ans, fui Plassans avec son amant, Auguste Lantier, un ouvrier chapelier, et leurs deux enfants, Claude et Étienne . À Paris, ils habitent un hôtel meublé misérable dans le quartier populaire de la Goutte-d’Or. Lantier abandonne vite la jeune femme, emportant tout ce qui reste de leurs maigres économies.','L''assommoir',2,6);
INSERT INTO public.book(id_book, category, registration, summary, title, id_author, id_cover) VALUES (6,'NOVEL',now(),'Faut-il partir ? Rester ? Le voyage intérieur n''est-il pas le seul qui enfante des beautés inconnues ? Vastes cieux enchantés, eaux fuyantes, gouffres amers, splendeurs océans... Le Paradis est là et ses noirs artifices, fruits de l''herbe et du pavot... Le haschich s''étend sur la vie comme un vernis magique, verte confiture de chanvre qui nous laisse aériens. ','Les paradis artificiels',3,9);
INSERT INTO public.book(id_book, category, registration, summary, title, id_author, id_cover) VALUES (7,'NOVEL',now(),'Les Fleurs du mal, Œuvre majeure de Charles Baudelaire, le recueil de poèmes Les Fleurs du Mal, intégrant la quasi-totalité de la production poétique de l’auteur depuis 1840, est publié le 23juin 1857 et a été réédité en 1861. C’est l’une des œuvres les plus importantes de la poésie moderne, empreinte d’une nouvelle esthétique où la beauté et le sublime surgissent, grâce au langage poétique...','Les fleurs du mal',3,7);
INSERT INTO public.book(id_book, category, registration, summary, title, id_author, id_cover) VALUES (8,'NOVEL',now(),'Un jour, le jeune homme est arrêté, enlevé ; on lui apprend qu''il est le baron Clancharlie, pair d''Angleterre. Il est réintégré dans ses titres et installé à la Chambre des lords. Là, il se pose en avocat des malheureux, des déshérités, et, dans une harangue désordonnée et puissante, fait le procès des grands qui l''entourent.','L''homme qui rit',1,10);
INSERT INTO public.book(id_book, category, registration, summary, title, id_author, id_cover) VALUES (9,'NOVEL',now(),'Fils de Gervaise Macquart et de son amant Lantier, le jeune Etienne Lantier s''est fait renvoyer de son travail pour avoir donné une gifle à son employeur. Chômeur, il part, en pleine crise industrielle, dans le Nord de la France, à la recherche d’un nouveau emploi. Il se fait embaucher aux mines de Montsou et connaît des conditions de travail effroyables','Germinal',2,4);
INSERT INTO public.book(id_book, category, registration, summary, title, id_author, id_cover) VALUES (10,'NOVEL',now(),'Nana est une courtisane dont le Tout-Paris applaudit les débuts comme actrice au théâtre des Variétés. Les habitués, journalistes, aristocrates et lycéens dévergondés discutent de cette nouvelle recrue de Bordenave , le directeur du théâtre. On trouve là le journaliste Fauchery, le banquier Steiner, amant de l’actrice Rose Mignon, Mignon lui-même et le comte et la comtesse Muffat.','Nana',2,12);

/* CopyBooks */

INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (1,true,'NEW',1,1);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (2,false,'GOOD',1,1);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (3,true,'GOOD',1,2);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (4,true,'NEW',1,3);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (5,true,'GOOD',1,3);

INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (6,true,'NEW',2,1);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (7,true,'GOOD',2,2);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (8,true,'GOOD',2,2);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (9,true,'GOOD',2,3);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (10,true,'GOOD',2,3);

INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (11,true,'GOOD',3,1);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (12,true,'GOOD',3,2);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (13,true,'WORN',3,2);

INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (14,true,'WORN',4,1);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (15,true,'GOOD',4,1);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (16,true,'NEW',4,3);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (17,true,'NEW',4,3);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (18,true,'GOOD',4,3);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (19,true,'GOOD',4,3);

INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (20,true,'WORN',5,1);

INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (21,true,'WORN',6,1);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (22,true,'GOOD',6,1);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (23,true,'NEW',6,2);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (24,true,'NEW',6,3);

INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (25,true,'WORN',7,1);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (26,false,'GOOD',7,1);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (27,true,'NEW',7,2);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (28,true,'NEW',7,2);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (29,true,'GOOD',7,3);

INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (30,true,'WORN',8,2);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (31,true,'GOOD',8,2);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (32,true,'NEW',8,3);

INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (33,true,'WORN',9,1);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (34,true,'GOOD',9,1);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (35,true,'NEW',9,2);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (36,true,'NEW',9,2);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (37,true,'GOOD',9,3);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (38,true,'WORN',9,3);

INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (39,true,'WORN',10,1);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (40,true,'GOOD',10,2);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (41,true,'NEW',10,3);
INSERT INTO public.copy_book(id_copy_book, available, condition, id_book, id_library) VALUES (42,true,'GOOD',10,3);
