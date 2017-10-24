CREATE TABLE WritingGroup (
GroupName varchar(50) NOT NULL,
HeadWriter varchar(20) NOT NULL,
YearFormed varchar(5) NOT NULL,
Subject varchar(20) NOT NULL,
CONSTRAINT WritingGroup_PK PRIMARY KEY (GroupName)
);

CREATE TABLE Publisher (
PublisherName varchar(30) NOT NULL,
PublisherAddress varchar(50) NOT NULL,
PublisherPhone varchar(15) NOT NULL,
PublisherEmail varchar(30) NOT NULL,
CONSTRAINT Publisher_PK PRIMARY KEY(PublisherName)
);

CREATE TABLE Book (
BookTitle varchar(50) NOT NULL,
YearPublished varchar(5) NOT NULL,
NumberPages varchar(10) NOT NULL,
PublisherName varchar(30) NOT NULL,
GroupName varchar(50) NOT NULL,
CONSTRAINT Book_PK PRIMARY KEY (GroupName, BookTitle),
CONSTRAINT Book_FK_1 FOREIGN KEY (GroupName) REFERENCES WritingGroup (GroupName),
CONSTRAINT Book_FK_2 FOREIGN KEY (PublisherName) REFERENCES Publisher (PublisherName)
);


insert into WritingGroup(GroupName,HeadWriter,YearFormed,Subject) values 
	('Team Swag', 'Schoobert Doobert', '1996', 'Science Fiction'),
	('Team Rocket', 'Robert Ugly', '2001', 'Romance'),
	('Doge Think', 'Eustice Grand', '1500', 'Self Help');


insert into Publisher(PublisherName,PublisherAddress,PublisherPhone,PublisherEmail) values
	('Cool Guy Publisher', '3392 Fountain Head', '562-973-4072', 'elpresidente@cgpub.com'),
	('Rockstar Publishing', '5923 Arrow St', ' 714-253-9427', 'headhoncho@rpub.com'),
	('Kick Aff Publisher', '1832 Swag Blvd', '626-278-3736', 'iamking@kapub.com'),
	('QwertySwag Publishings', '9275 Sick Kick Ave', '213-727-8263', 'elchapo@qspub.com');


insert into Book(BookTitle,YearPublished,NumberPages,PublisherName,GroupName) values
	('The Great Horn Spoon', '2001', '200', 'Cool Guy Publisher', 'Team Swag'),
	('Dune', '1956', '600', 'Cool Guy Publisher', 'Team Rocket' ),
	('Ranian', '1937', '294', 'Kick Aff Publisher', 'Team Swag'),
	('Dinkleburg', '1989', '1000', 'Rockstar Publishing', 'Team Rocket'),
	('The Hypocracy of Fruit', '1999', '50', 'QwertySwag Publishings', 'Doge Think'),
	('The Irony of Pizza', '2015', '206', 'QwertySwag Publishings', 'Doge Think'),
	('The Duality of Man', '2014', '207', 'QwertySwag Publishings', 'Doge Think'),
	('Fifty Shades of Black', '2013', '295', 'Kick Aff Publisher', 'Team Rocket');

