-- Database: library-book

CREATE DATABASE "library-book"
    WITH
    OWNER = nanoo
    ENCODING = 'UTF8'
    LC_COLLATE = 'fr_FR.UTF-8'
    LC_CTYPE = 'fr_FR.UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

--
-- PostgreSQL database dump
--

-- Dumped from database version 10.11 (Ubuntu 10.11-1.pgdg18.04+1)
-- Dumped by pg_dump version 12.1 (Ubuntu 12.1-1.pgdg18.04+1)

-- Started on 2020-02-13 20:19:17 CET

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

--
-- TOC entry 197 (class 1259 OID 143987)
-- Name: address; Type: TABLE; Schema: public; Owner: nanoo
--

CREATE TABLE public.address (
    id_address integer NOT NULL,
    city character varying(255) NOT NULL,
    number integer NOT NULL,
    postal_code integer NOT NULL,
    street character varying(50) NOT NULL
);


ALTER TABLE public.address OWNER TO nanoo;

--
-- TOC entry 198 (class 1259 OID 143992)
-- Name: author; Type: TABLE; Schema: public; Owner: nanoo
--

CREATE TABLE public.author (
    id_author integer NOT NULL,
    first_name character varying(255) NOT NULL,
    last_name character varying(255) NOT NULL
);


ALTER TABLE public.author OWNER TO nanoo;

--
-- TOC entry 199 (class 1259 OID 144000)
-- Name: book; Type: TABLE; Schema: public; Owner: nanoo
--

CREATE TABLE public.book (
    id_book integer NOT NULL,
    category character varying(20) NOT NULL,
    registration timestamp without time zone NOT NULL,
    summary character varying(400),
    title character varying(50) NOT NULL,
    id_author integer NOT NULL,
    id_cover integer
);


ALTER TABLE public.book OWNER TO nanoo;

--
-- TOC entry 200 (class 1259 OID 144005)
-- Name: copy_book; Type: TABLE; Schema: public; Owner: nanoo
--

CREATE TABLE public.copy_book (
    id_copy_book integer NOT NULL,
    available boolean NOT NULL,
    condition character varying(20) NOT NULL,
    id_book integer NOT NULL,
    id_library integer NOT NULL
);


ALTER TABLE public.copy_book OWNER TO nanoo;

--
-- TOC entry 201 (class 1259 OID 144010)
-- Name: cover; Type: TABLE; Schema: public; Owner: nanoo
--

CREATE TABLE public.cover (
    id_cover integer NOT NULL,
    path character varying(255) NOT NULL,
    title character varying(255) NOT NULL
);


ALTER TABLE public.cover OWNER TO nanoo;

--
-- TOC entry 196 (class 1259 OID 143985)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: nanoo
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO nanoo;

--
-- TOC entry 202 (class 1259 OID 144018)
-- Name: library; Type: TABLE; Schema: public; Owner: nanoo
--

CREATE TABLE public.library (
    id_library integer NOT NULL,
    name character varying(255) NOT NULL,
    phone_number character varying(10) NOT NULL,
    id_address integer
);


ALTER TABLE public.library OWNER TO nanoo;

--
-- TOC entry 2955 (class 0 OID 143987)
-- Dependencies: 197
-- Data for Name: address; Type: TABLE DATA; Schema: public; Owner: nanoo
--

INSERT INTO public.address (id_address, city, number, postal_code, street) VALUES (1, 'BX', 1, 33000, 'rue du paradis');
INSERT INTO public.address (id_address, city, number, postal_code, street) VALUES (2, 'BX', 1, 33000, 'rue de l''enfer');
INSERT INTO public.address (id_address, city, number, postal_code, street) VALUES (3, 'BX', 1, 33000, 'rue du purgatoire');
INSERT INTO public.address (id_address, city, number, postal_code, street) VALUES (4, 'BX', 85, 33000, 'Cours Maréchal Juin');
INSERT INTO public.address (id_address, city, number, postal_code, street) VALUES (5, 'BX', 145, 33000, 'Rue de Saint- Genès');
INSERT INTO public.address (id_address, city, number, postal_code, street) VALUES (6, 'BX', 10, 33000, 'Place des Capucins');


--
-- TOC entry 2956 (class 0 OID 143992)
-- Dependencies: 198
-- Data for Name: author; Type: TABLE DATA; Schema: public; Owner: nanoo
--

INSERT INTO public.author (id_author, first_name, last_name) VALUES (1, 'Victor', 'Hugo');
INSERT INTO public.author (id_author, first_name, last_name) VALUES (2, 'Emile', 'Zola');
INSERT INTO public.author (id_author, first_name, last_name) VALUES (3, 'Charles', 'Baudelaire');


--
-- TOC entry 2957 (class 0 OID 144000)
-- Dependencies: 199
-- Data for Name: book; Type: TABLE DATA; Schema: public; Owner: nanoo
--

INSERT INTO public.book (id_book, category, registration, summary, title, id_author, id_cover) VALUES (1, 'NOVEL', '2019-01-01 23:00:00', 'Le forçat Jean Valjean est libéré d''une prison française après avoir purgé une peine de dix-neuf ans pour le vol d''une miche de pain et plusieurs tentatives d''évasion. Lorsqu''il arrive dans la ville de Digne, personne n''est disposé à lui donner refuge parce qu''il est un ex-condamné. Désespéré, Valjean frappe à la porte de M.Myriel, l''évêque de Digne, qui le traite avec gentillesse.', 'Les misérables', 1, 8);
INSERT INTO public.book (id_book, category, registration, summary, title, id_author, id_cover) VALUES (2, 'NOVEL', '2019-01-02 23:00:00', 'Dans le Paris du XVe siècle, une jeune et superbe gitane appelée Esméralda danse sur le parvis de Notre Dame. Sa beauté bouleverse l''archidiacre de Notre-Dame, Claude Frollo, qui veut la faire enlever par son sonneur de cloches, le mal-formé Quasimodo. Esméralda est sauvée par une escouade d''archers, commandée par le capitaine de la garde Phoebus de Châteaupers.', 'Notre-Dame de Paris', 1, 13);
INSERT INTO public.book (id_book, category, registration, summary, title, id_author, id_cover) VALUES (3, 'NOVEL', '2019-01-03 23:00:00', '« J''accuse… ! » est une lettre écrite par Émile Zola à l''intention du président français de l''époque Félix Faure parue dans le quotidien parisien L''Aurore le 13 janvier 1898 concernant l''Affaire Dreyfus. Cette très longue lettre reproche à Félix Faure, d''avoir fait condamner à tort un innocent (Alfred Dreyfus) mais de laisser libre le coupable (Esterhazy).', 'J''accuse', 2, 5);
INSERT INTO public.book (id_book, category, registration, summary, title, id_author, id_cover) VALUES (4, 'NOVEL', '2019-01-04 23:00:00', 'Claude est un artiste-peintre parisien renommé et reconnu qui vit dans le luxe et la volupté. Son mouvement avant-gardiste dit "du plein air" connaît un franc succès tant public que critique. Il vit heureux mais bien seul car il n''a aucun ami. Il s''attire d''ailleurs la jalousie des compagnons de son enfance à Plassans (où il naquit et où il revint faire ses études).', 'L''oeuvre', 2, 11);
INSERT INTO public.book (id_book, category, registration, summary, title, id_author, id_cover) VALUES (5, 'NOVEL', '2019-01-05 23:00:00', 'Gervaise, la fille d''Antoine Macquart, a, à vingt-deux ans, fui Plassans avec son amant, Auguste Lantier, un ouvrier chapelier, et leurs deux enfants, Claude et Étienne . À Paris, ils habitent un hôtel meublé misérable dans le quartier populaire de la Goutte-d’Or. Lantier abandonne vite la jeune femme, emportant tout ce qui reste de leurs maigres économies.', 'L''assommoir', 2, 6);
INSERT INTO public.book (id_book, category, registration, summary, title, id_author, id_cover) VALUES (6, 'NOVEL', '2019-01-06 23:00:00', 'Faut-il partir ? Rester ? Le voyage intérieur n''est-il pas le seul qui enfante des beautés inconnues ? Vastes cieux enchantés, eaux fuyantes, gouffres amers, splendeurs océans... Le Paradis est là et ses noirs artifices, fruits de l''herbe et du pavot... Le haschich s''étend sur la vie comme un vernis magique, verte confiture de chanvre qui nous laisse aériens. ', 'Les paradis artificiels', 3, 9);
INSERT INTO public.book (id_book, category, registration, summary, title, id_author, id_cover) VALUES (7, 'NOVEL', '2019-01-07 23:00:00', 'Les Fleurs du mal, Œuvre majeure de Charles Baudelaire, le recueil de poèmes Les Fleurs du Mal, intégrant la quasi-totalité de la production poétique de l’auteur depuis 1840, est publié le 23juin 1857 et a été réédité en 1861. C’est l’une des œuvres les plus importantes de la poésie moderne, empreinte d’une nouvelle esthétique où la beauté et le sublime surgissent, grâce au langage poétique...', 'Les fleurs du mal', 3, 7);
INSERT INTO public.book (id_book, category, registration, summary, title, id_author, id_cover) VALUES (8, 'NOVEL', '2019-01-08 23:00:00', 'Un jour, le jeune homme est arrêté, enlevé ; on lui apprend qu''il est le baron Clancharlie, pair d''Angleterre. Il est réintégré dans ses titres et installé à la Chambre des lords. Là, il se pose en avocat des malheureux, des déshérités, et, dans une harangue désordonnée et puissante, fait le procès des grands qui l''entourent.', 'L''homme qui rit', 1, 10);
INSERT INTO public.book (id_book, category, registration, summary, title, id_author, id_cover) VALUES (9, 'NOVEL', '2019-01-09 23:00:00', 'Fils de Gervaise Macquart et de son amant Lantier, le jeune Etienne Lantier s''est fait renvoyer de son travail pour avoir donné une gifle à son employeur. Chômeur, il part, en pleine crise industrielle, dans le Nord de la France, à la recherche d’un nouveau emploi. Il se fait embaucher aux mines de Montsou et connaît des conditions de travail effroyables', 'Germinal', 2, 4);
INSERT INTO public.book (id_book, category, registration, summary, title, id_author, id_cover) VALUES (10, 'NOVEL', '2019-01-10 23:00:00', 'Nana est une courtisane dont le Tout-Paris applaudit les débuts comme actrice au théâtre des Variétés. Les habitués, journalistes, aristocrates et lycéens dévergondés discutent de cette nouvelle recrue de Bordenave , le directeur du théâtre. On trouve là le journaliste Fauchery, le banquier Steiner, amant de l’actrice Rose Mignon, Mignon lui-même et le comte et la comtesse Muffat.', 'Nana', 2, 12);


--
-- TOC entry 2958 (class 0 OID 144005)
-- Dependencies: 200
-- Data for Name: copy_book; Type: TABLE DATA; Schema: public; Owner: nanoo
--

INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (1, true, 'NEW', 1, 1);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (2, false, 'GOOD', 1, 1);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (3, true, 'GOOD', 1, 2);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (4, true, 'NEW', 1, 3);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (5, true, 'GOOD', 1, 3);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (6, true, 'NEW', 2, 1);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (7, true, 'GOOD', 2, 2);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (8, true, 'GOOD', 2, 2);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (9, true, 'GOOD', 2, 3);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (10, true, 'GOOD', 2, 3);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (11, true, 'GOOD', 3, 1);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (12, true, 'GOOD', 3, 2);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (13, true, 'WORN', 3, 2);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (14, true, 'WORN', 4, 1);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (15, true, 'GOOD', 4, 1);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (16, true, 'NEW', 4, 3);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (17, true, 'NEW', 4, 3);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (18, true, 'GOOD', 4, 3);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (19, true, 'GOOD', 4, 3);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (20, true, 'WORN', 5, 1);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (21, true, 'WORN', 6, 1);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (22, true, 'GOOD', 6, 1);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (23, true, 'NEW', 6, 2);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (24, true, 'NEW', 6, 3);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (25, true, 'WORN', 7, 1);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (26, false, 'GOOD', 7, 1);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (27, true, 'NEW', 7, 2);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (28, true, 'NEW', 7, 2);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (29, true, 'GOOD', 7, 3);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (30, true, 'WORN', 8, 2);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (31, true, 'GOOD', 8, 2);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (32, true, 'NEW', 8, 3);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (33, true, 'WORN', 9, 1);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (34, true, 'GOOD', 9, 1);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (35, true, 'NEW', 9, 2);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (36, true, 'NEW', 9, 2);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (37, true, 'GOOD', 9, 3);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (38, true, 'WORN', 9, 3);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (39, true, 'WORN', 10, 1);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (40, true, 'GOOD', 10, 2);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (41, true, 'NEW', 10, 3);
INSERT INTO public.copy_book (id_copy_book, available, condition, id_book, id_library) VALUES (42, true, 'GOOD', 10, 3);


--
-- TOC entry 2959 (class 0 OID 144010)
-- Dependencies: 201
-- Data for Name: cover; Type: TABLE DATA; Schema: public; Owner: nanoo
--

INSERT INTO public.cover (id_cover, path, title) VALUES (1, '/image/cover-1.jpg', 'test');
INSERT INTO public.cover (id_cover, path, title) VALUES (2, '/image/cover-2.jpg', 'test');
INSERT INTO public.cover (id_cover, path, title) VALUES (3, '/image/cover-3.jpg', 'test');
INSERT INTO public.cover (id_cover, path, title) VALUES (4, '/image/covers/germinal.jpg', 'germinal');
INSERT INTO public.cover (id_cover, path, title) VALUES (5, '/image/covers/jaccuse.jpg', 'j''accuse');
INSERT INTO public.cover (id_cover, path, title) VALUES (6, '/image/covers/lassommoir.jpg', 'l''assommoir');
INSERT INTO public.cover (id_cover, path, title) VALUES (7, '/image/covers/lesfleursdumal.jpg', 'les fleurs du mal');
INSERT INTO public.cover (id_cover, path, title) VALUES (8, '/image/covers/lesmiserables.jpg', 'les miserables');
INSERT INTO public.cover (id_cover, path, title) VALUES (9, '/image/covers/lesparadisartificiels.jpg', 'les paradis artificiels');
INSERT INTO public.cover (id_cover, path, title) VALUES (10, '/image/covers/lhommmequirit.jpeg', 'l''hommme qui rit');
INSERT INTO public.cover (id_cover, path, title) VALUES (11, '/image/covers/loeuvre.jpg', 'l''oeuvre');
INSERT INTO public.cover (id_cover, path, title) VALUES (12, '/image/covers/nana.jpg', 'nana');
INSERT INTO public.cover (id_cover, path, title) VALUES (13, '/image/covers/notredamedeparis.jpg', 'notre dame de paris');


--
-- TOC entry 2960 (class 0 OID 144018)
-- Dependencies: 202
-- Data for Name: library; Type: TABLE DATA; Schema: public; Owner: nanoo
--

INSERT INTO public.library (id_library, name, phone_number, id_address) VALUES (1, 'Bibliothèque Mériadeck', '0556103000', 4);
INSERT INTO public.library (id_library, name, phone_number, id_address) VALUES (2, 'Bibliothèque diocésienne', '0547502102', 5);
INSERT INTO public.library (id_library, name, phone_number, id_address) VALUES (3, 'Bibliothèque Capucins', '0556911879', 6);


--
-- TOC entry 2966 (class 0 OID 0)
-- Dependencies: 196
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: nanoo
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


--
-- TOC entry 2817 (class 2606 OID 143991)
-- Name: address address_pkey; Type: CONSTRAINT; Schema: public; Owner: nanoo
--

ALTER TABLE ONLY public.address
    ADD CONSTRAINT address_pkey PRIMARY KEY (id_address);


--
-- TOC entry 2819 (class 2606 OID 143999)
-- Name: author author_pkey; Type: CONSTRAINT; Schema: public; Owner: nanoo
--

ALTER TABLE ONLY public.author
    ADD CONSTRAINT author_pkey PRIMARY KEY (id_author);


--
-- TOC entry 2821 (class 2606 OID 144004)
-- Name: book book_pkey; Type: CONSTRAINT; Schema: public; Owner: nanoo
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (id_book);


--
-- TOC entry 2823 (class 2606 OID 144009)
-- Name: copy_book copy_book_pkey; Type: CONSTRAINT; Schema: public; Owner: nanoo
--

ALTER TABLE ONLY public.copy_book
    ADD CONSTRAINT copy_book_pkey PRIMARY KEY (id_copy_book);


--
-- TOC entry 2825 (class 2606 OID 144017)
-- Name: cover cover_pkey; Type: CONSTRAINT; Schema: public; Owner: nanoo
--

ALTER TABLE ONLY public.cover
    ADD CONSTRAINT cover_pkey PRIMARY KEY (id_cover);


--
-- TOC entry 2827 (class 2606 OID 144022)
-- Name: library library_pkey; Type: CONSTRAINT; Schema: public; Owner: nanoo
--

ALTER TABLE ONLY public.library
    ADD CONSTRAINT library_pkey PRIMARY KEY (id_library);


--
-- TOC entry 2830 (class 2606 OID 144033)
-- Name: copy_book FK5l5sqbgfghvbcrpvurq8mka96; Type: FK CONSTRAINT; Schema: public; Owner: nanoo
--

ALTER TABLE ONLY public.copy_book
    ADD CONSTRAINT "FK5l5sqbgfghvbcrpvurq8mka96" FOREIGN KEY (id_book) REFERENCES public.book(id_book);


--
-- TOC entry 2828 (class 2606 OID 144023)
-- Name: book FK926lt4kvk8u15ktfbcm5bq742; Type: FK CONSTRAINT; Schema: public; Owner: nanoo
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT "FK926lt4kvk8u15ktfbcm5bq742" FOREIGN KEY (id_author) REFERENCES public.author(id_author);


--
-- TOC entry 2829 (class 2606 OID 144028)
-- Name: book FKfrc6xqqsa7p25q8lwp9lx3j9v; Type: FK CONSTRAINT; Schema: public; Owner: nanoo
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT "FKfrc6xqqsa7p25q8lwp9lx3j9v" FOREIGN KEY (id_cover) REFERENCES public.cover(id_cover);


--
-- TOC entry 2832 (class 2606 OID 144043)
-- Name: library FKlvp2pwicporl1s0nfgs0o22ne; Type: FK CONSTRAINT; Schema: public; Owner: nanoo
--

ALTER TABLE ONLY public.library
    ADD CONSTRAINT "FKlvp2pwicporl1s0nfgs0o22ne" FOREIGN KEY (id_address) REFERENCES public.address(id_address);


--
-- TOC entry 2831 (class 2606 OID 144038)
-- Name: copy_book FKlytmuv0m9hxv1iylf00lm4eav; Type: FK CONSTRAINT; Schema: public; Owner: nanoo
--

ALTER TABLE ONLY public.copy_book
    ADD CONSTRAINT "FKlytmuv0m9hxv1iylf00lm4eav" FOREIGN KEY (id_library) REFERENCES public.library(id_library);


-- Completed on 2020-02-13 20:19:17 CET

--
-- PostgreSQL database dump complete
--

