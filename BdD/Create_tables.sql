begin;

CREATE TABLE Theme(
	id int primary key auto_increment,
	nomTheme varchar(100) not null unique 
);

CREATE TABLE Cirque(
	id int primary key auto_increment,
	nom varchar(100) not null unique
);

CREATE TABLE Artiste(
	id int primary key auto_increment,
	nom varchar(100) not null,
	prenom varchar(100) not null,
	dateNaissance date not null,
	adresse varchar(255) not null,
	idCirque foreign key references Cirque(id) 
);

CREATE TABLE Expert(
	idArtiste int primary key foreign key references Artiste(id),
	theme int foreign key references Theme(id)
);

CREATE TABLE Artiste_Pseudo(
	idArtiste int foreign key references Artiste(id),
	pseudo varchar(100) not null
	primary key (idArtiste, pseudo)
);

CREATE TABLE Artiste_Telephone(
	idArtiste int primary key foreign key references Artiste(id),
	numTel char(10) not null
);

CREATE TABLE Numero(
	code int primary key auto_increment,
	titre varchar(100) not null,
	theme int foreign key references Theme(id),
	resume varchar(500) not null,
	duree int not null check (duree >= 20 and duree <= 40)
);

CREATE TABLE Artiste_Participe(
	idArtiste int foreign key references Artiste(id),
	codeNumero int foreign key references Numero(code),
	primary key (idArtiste, codeNumero)
);

CREATE TABLE Artiste_Principal(
	codeNumero int primary key foreign key references Numero(code),
	idArtiste int foreign key references Artiste(id)
);

CREATE TABLE Expert_Evaluation(
	idExpert int foreign key references Expert(idArtiste),
	codeNumero int foreign key references Numero(code),
	commentaire varchar(500),
	note int check (note is null or (note >= 0 and note <=10)),
	primary key (idExpert, codeNumero)
);

CREATE TABLE Festival(
	id int primary key auto_increment,
	dateDebut date not null,
	dateFin date not null
);

CREATE TABLE Classement(
	idFestival int foreign key references Festival(id),
	codeNumero int foreign key references Numero(code),
	classement int not null default 0,
	primary key (idFestival, codeNumero)
);

CREATE TABLE Spectacle(
	id int primary key auto_increment,
	idFestival int foreign key references Festival(id),
	theme int foreign key references Theme(id),
	numJour smallint not null,
	heureDebut time not null,
	heureFin time not null,
	prix int not null,
	idArtistePresentateur int foreign key references Artiste(id)
);

CREATE TABLE Spectacle_Numeros(
	idSpectacle int foreign key references Spectacle(id),
	codeNumero int foreign key references Numero(code),
	heurePassage time not null,
	primary key (idSpectacle, codeNumero)
);

rollback;