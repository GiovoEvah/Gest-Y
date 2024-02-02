--
-- Create schema azeinda
--

CREATE DATABASE IF NOT EXISTS azienda_PA;
USE azienda_PA;

CREATE TABLE utente (
  matricola int auto_increment NOT NULL,
  cf varchar(16) NOT NULL,
  nome varchar(75) NOT NULL,
  cognome varchar(75) NOT NULL,
  sesso varchar(1),
  email varchar(75) NOT NULL,
  passw varchar(30) NOT NULL,
  iban varchar(30) NOT NULL,
  telefono varchar(30) NOT NULL,
  via varchar(20),
  n_civ varchar(6),
  cap varchar(6),
  isAdmin boolean NOT NULL,
  isDDL boolean NOT NULL,
  ruolo int NOT NULL,
  newAssunzione boolean NOT NULL,
  isLicenziato boolean NOT NULL,
  dataAssunzione date,
  dataLicenziamento date,
  PRIMARY KEY (matricola),
  UNIQUE(cf),
  UNIQUE(email)
);

CREATE TABLE indisponibilita (
  ref_imp int NOT NULL,
  dataIndisp date NOT NULL,
  PRIMARY KEY (ref_imp, dataIndisp),
  FOREIGN KEY (ref_imp) REFERENCES utente(matricola)
);

CREATE TABLE richiesta (
  id_richiesta int auto_increment NOT NULL,
  ref_impiegato int NOT NULL,
  tipologia varchar(75) NOT NULL,
  motivazione varchar(200) NOT NULL,
  link_certificato varchar(30),
  dataInizio date NOT NULL,
  dataFine date NOT NULL,
  esito boolean NOT NULL,
  PRIMARY KEY (id_richiesta),
  FOREIGN KEY (ref_impiegato) references utente(matricola)
);

CREATE TABLE bustaPaga (
  ref_impiegato int NOT NULL,
  mese_competenza int NOT NULL,
  anno_competenza int NOT NULL,
  stipendioBase int,
  ore_servizio_1 int,
  ore_servizio_2 int,
  ore_servizio_3 int,
  ore_servizio_4 int,
  ore_straordinario int,
  num_ritardi int,
  num_assenze int,
  importoTotale int,
  isPagato boolean,
  PRIMARY KEY (ref_impiegato, mese_competenza, anno_competenza),
  FOREIGN KEY (ref_impiegato) references utente(matricola)
);

CREATE TABLE notifica (
  id_notifica int NOT NULL,
  tipologia varchar(30) NOT NULL,
  PRIMARY KEY (id_notifica)
);

CREATE TABLE utente_notifica (
  id_utente_notifica int NOT NULL auto_increment,
  ref_notifica int NOT NULL,
  ref_impiegato int NOT NULL,
  dataNotifica date,
  descrizione varchar(100) NOT NULL,
  PRIMARY KEY (id_utente_notifica, ref_notifica, ref_impiegato),
  FOREIGN KEY (ref_notifica) references notifica(id_notifica),
  FOREIGN KEY (ref_impiegato) references utente(matricola)
);

CREATE TABLE servizio (
  id_servizio int NOT NULL,
  nome varchar(30) NOT NULL,
  gratifica int NOT NULL,
  PRIMARY KEY (id_servizio)
);

CREATE TABLE turno (
  id_turno int auto_increment NOT NULL,
  ref_impiegato int NOT NULL,
  ref_servizio int NOT NULL,
  dataTurno date NOT NULL,
  oraInizio time NOT NULL,
  oraFine time NOT NULL,
  firmaIngresso boolean NOT NULL,
  firmaUscita boolean NOT NULL,
  isClosed boolean NOT NULL,
  PRIMARY KEY (id_turno),
  FOREIGN KEY (ref_servizio) references servizio(id_servizio),
  FOREIGN KEY (ref_impiegato) references utente(matricola)
);

CREATE TABLE turno_ritardo (
  ref_turno int not null,
  motivazione varchar(100) NOT NULL,
  PRIMARY KEY (ref_turno),
  FOREIGN KEY (ref_turno) references turno(id_turno)
);
