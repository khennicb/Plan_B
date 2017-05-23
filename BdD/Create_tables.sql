begin;
--
CREATE TABLE Theme(
	id int primary key auto_increment,
	nomTheme varchar(100) not null unique 
)

CREATE TABLE Cirque(
	id int primary key auto_increment,
	nom varchar(100) not null unique
)

CREATE TABLE Artiste(
	id int primary key auto_increment,
	nom varchar(100) not null,
	prenom varchar(100) not null,
	dateNaissance date not null,
	adresse varchar(255) not null,
	idCirque foreign key references Cirque(id) 
)

CREATE TABLE Artiste_Pseudo(
	idArtiste int foreign key references Artiste(id),
	pseudo varchar(100) not null
	primary key (idArtiste, pseudo)
)

CREATE TABLE Artiste_Telephone(
	idArtiste int primary key foreign key references Artiste(id),
	numTel char(10) not null
)


-- TODO : add table Numero

CREATE TABLE Artiste_Participe(
	idArtiste int foreign key references Artiste(id),
	codeNumero int foreign key references Numero(code),
	primary key (idArtiste, codeNumero)
)

CREATE TABLE Festival(
	id int primary key auto_increment,
	dateDebut date not null,
	dateFin date not null
)

CREATE TABLE Spectacle(
	id int primary key auto_increment,
	idFestival int foreign key references Festival(id)
	theme varchar(100) foreign key references Theme(nomTheme),
	numJour smallint not null,
	heureDebut time not null,
	heureFin time not null,
	prix int not null,
	idArtistePresentateur int foreign key references Artiste(id)
)

rollback;