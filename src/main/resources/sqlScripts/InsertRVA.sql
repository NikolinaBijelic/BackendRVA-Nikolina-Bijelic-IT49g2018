INSERT INTO proizvodjac(id, naziv, adresa, kontakt)
VALUES (nextval('proizvodjac_seq'), 'Imlek', 'Cara Dusana 5, Beograd', '0635895412');
INSERT INTO proizvodjac(id, naziv, adresa, kontakt)
VALUES (nextval('proizvodjac_seq'), 'Nivea', 'Savska 56, Beograd', '0696896618');
INSERT INTO proizvodjac(id, naziv, adresa, kontakt)
VALUES (nextval('proizvodjac_seq'), 'CocaCola', 'Narodnog Fronta 66, Novi Sad', '0626895412');
INSERT INTO proizvodjac(id, naziv, adresa, kontakt)
VALUES (nextval('proizvodjac_seq'), 'Stark', 'Glavna 33, Subotica', '0656895418');
INSERT INTO proizvodjac(id, naziv, adresa, kontakt)
VALUES (nextval('proizvodjac_seq'), 'Jaffa', 'Cara Lazara 5, Nis', '0616895412');
INSERT INTO proizvodjac(id, naziv, adresa, kontakt)
VALUES (-100, 'TESTImlek', 'TESTCara Dusana 5, Beograd', 'TEST0635895412');

INSERT INTO proizvod(id, naziv, proizvodjac)
VALUES (nextval('proizvod_seq'), 'Mleko', 1);
INSERT INTO proizvod(id, naziv, proizvodjac)
VALUES (nextval('proizvod_seq'), 'Napolitanke', 5);
INSERT INTO proizvod(id, naziv, proizvodjac)
VALUES (nextval('proizvod_seq'), 'Medeno srce', 4);
INSERT INTO proizvod(id, naziv, proizvodjac)
VALUES (nextval('proizvod_seq'), 'Krema', 2);
INSERT INTO proizvod(id, naziv, proizvodjac)
VALUES (-100, 'TESTKrema', 2);

INSERT INTO racun(id, datum, nacin_placanja)
VALUES(nextval('racun_seq'), '10.3.2021.', 'Kes');
INSERT INTO racun(id, datum, nacin_placanja)
VALUES(nextval('racun_seq'), '11.4.2020.', 'Kartica');
INSERT INTO racun(id, datum, nacin_placanja)
VALUES(nextval('racun_seq'), '17.6.2021.', 'Kartica');
INSERT INTO racun(id, datum, nacin_placanja)
VALUES(nextval('racun_seq'), '31.7.2021.', 'Kes');
INSERT INTO racun(id, datum, nacin_placanja)
VALUES(-100, '31.7.2021.', 'TESTKes');

INSERT INTO stavka_racuna (id, redni_broj, kolicina, jedinica_mere, cena, racun, proizvod)
VALUES (nextval('stavka_racuna_seq'), '1', '10', 'l', '1500', 1, 1);
INSERT INTO stavka_racuna (id, redni_broj, kolicina, jedinica_mere, cena, racun, proizvod)
VALUES (nextval('stavka_racuna_seq'), '2', '2', 'g', '300', 2, 2);
INSERT INTO stavka_racuna (id, redni_broj, kolicina, jedinica_mere, cena, racun, proizvod)
VALUES (nextval('stavka_racuna_seq'), '3', '1', 'g', '150', 3, 3);
INSERT INTO stavka_racuna (id, redni_broj, kolicina, jedinica_mere, cena, racun, proizvod)
VALUES (nextval('stavka_racuna_seq'), '4', '1', 'ml', '550', 4, 4);
INSERT INTO stavka_racuna (id, redni_broj, kolicina, jedinica_mere, cena, racun, proizvod)
VALUES (-100, '1', '10', 'TESTl', '1500', 1, 1);
