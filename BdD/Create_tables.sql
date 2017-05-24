
CREATE TABLE Theme(
	id NUMBER GENERATED by default on null as IDENTITY,
	nomTheme varchar(100) not null unique
);

ALTER TABLE Theme ADD(
	constraint Theme_pk primary key (id)
);


CREATE TABLE Cirque(
	id NUMBER GENERATED by default on null as IDENTITY,
	nom varchar(100) not null unique
);

ALTER TABLE Cirque ADD (
	constraint Cirque_pk primary key (id)
);


CREATE TABLE Artiste(
	id NUMBER GENERATED by default on null as IDENTITY,
	nom varchar(100) not null,
	prenom varchar(100) not null,
	dateNaissance date not null,
	adresse varchar(255) not null,
	idCirque NUMBER,
	constraint Artiste_fk foreign key (idCirque) references Cirque(id) 
);

ALTER TABLE Artiste ADD (
	constraint Artiste_pk primary key (id)
);

CREATE TABLE Expert(
	idArtiste NUMBER,
	idTheme NUMBER,
	constraint Expert_theme_fk foreign key (idTheme) references Theme(id),
	constraint Expert_artiste_fk foreign key (idArtiste) references Artiste(id)
);

ALTER TABLE Expert ADD (
	constraint Expert_pk primary key (idArtiste)
);


CREATE TABLE Artiste_Pseudo(
	idArtiste NUMBER,
	pseudo varchar(100) not null,
	constraint Artiste_Pseudo_fk foreign key (idArtiste) references Artiste(id)
);

ALTER TABLE Artiste_Pseudo ADD (
	constraint Artiste_Pseudo_pk primary key (idArtiste, pseudo)
);


CREATE TABLE Artiste_Telephone(
	idArtiste NUMBER,
	numTel char(10) not null,
	constraint Artiste_Telephone_fk foreign key (idArtiste) references Artiste(id)
);

ALTER TABLE Artiste_Telephone ADD (
	constraint Artiste_Telephone_pk primary key (idArtiste)
);


CREATE TABLE Numero(
	code NUMBER GENERATED by default on null as IDENTITY,
	titre varchar(100) not null,
	idTheme NUMBER,
	resume varchar(500) not null,
	duree int not null check (duree >= 20 and duree <= 40),
	constraint Numero_fk foreign key (idTheme) references Theme(id)
);

ALTER TABLE Numero ADD (
	constraint Numero_pk primary key (code)
);


CREATE TABLE Artiste_Participe(
	idArtiste NUMBER,
	codeNumero NUMBER,
	constraint Artiste_Participe_artiste_fk foreign key (idArtiste) references Artiste(id),
	constraint Artiste_Participe_numero_fk foreign key (codeNumero) references Numero(code)
);

ALTER TABLE Artiste_Participe ADD (
	constraint Artiste_Participe_pk primary key (idArtiste, codeNumero)
);


CREATE TABLE Artiste_Principal(
	codeNumero NUMBER,
	idArtiste NUMBER,
	constraint Artiste_Principal_numero_fk foreign key (codeNumero) references Numero(code),
	constraint Artiste_Principal_artiste_fk foreign key (idArtiste) references Artiste(id)
);

ALTER TABLE Artiste_Principal ADD (
	constraint Artiste_Principal_pk primary key (codeNumero)
);


CREATE TABLE Expert_Evaluation(
	idExpert NUMBER,
	codeNumero NUMBER,
	commentaire varchar(500),
	note int check (note is null or (note >= 0 and note <=10)),
	constraint Expert_Evaluation_expert_fk foreign key (idExpert) references Expert(idArtiste),
	constraint Expert_Evaluation_numero_fk foreign key (codeNumero) references Numero(code)
);

ALTER TABLE Expert_Evaluation ADD (
	constraint Expert_Evaluation_pk primary key (idExpert, codeNumero)
);


CREATE TABLE Festival(
	id NUMBER GENERATED by default on null as IDENTITY,
	dateDebut date not null,
	dateFin date not null
);

ALTER TABLE Festival ADD (
	constraint Festival_pk primary key (id)
);


CREATE TABLE Classement(
	idFestival NUMBER,
	codeNumero NUMBER,
	classement int default 0 not null,
	constraint Classement_festival_fk foreign key (idFestival) references Festival(id),
	constraint Classement_numero_fk foreign key (codeNumero) references Numero(code)
);

ALTER TABLE Classement ADD (
	constraint Classement_pk primary key (idFestival, codeNumero)
);


CREATE TABLE Spectacle(
	id NUMBER GENERATED by default on null as IDENTITY,
	idFestival NUMBER,
	idTheme NUMBER,
	numJour int not null,
	heureDebut TIMESTAMP not null,
	heureFin TIMESTAMP not null,
	prix float not null,
	idArtistePresentateur NUMBER,
	constraint Spectacle_festival_fk foreign key (idFestival) references Festival(id),
	constraint Spectacle_theme_fk foreign key (idTheme) references Theme(id),
	constraint Spectacle_artiste_fk foreign key (idArtistePresentateur) references Artiste(id)
);

ALTER TABLE Spectacle ADD (
	constraint Spectacle_pk primary key (id)
);


CREATE TABLE Spectacle_Numeros(
	idSpectacle NUMBER,
	codeNumero NUMBER,
	heurePassage TIMESTAMP not null,
	constraint Spectacle_Numeros_spectacle_fk foreign key (idSpectacle) references Spectacle(id),
	constraint Spectacle_Numeros_numero_fk foreign key (codeNumero) references Numero(code)
);

ALTER TABLE Spectacle_Numeros ADD (
	constraint Spectacle_Numeros_pk primary key (idSpectacle, codeNumero)
);