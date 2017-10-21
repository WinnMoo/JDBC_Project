CREATE TABLE WritingGroup (
GroupName varchar(50) NOT NULL,
HeadWriter varchar(20) NOT NULL,
YearFormed varchar(5) NOT NULL,
Subject varchar(20) NOT NULL,
CONSTRAINT WritingGroup_PK PRIMARY KEY (GroupName)
);

CREATE TABLE Publisher (
PublisherName varchar(20) NOT NULL,
PublisherAddress varchar(50) NOT NULL,
PublisherPhone varchar(10) NOT NULL,
PublisherEmail varchar(30) NOT NULL,
CONSTRAINT Publisher_PK PRIMARY KEY(PublisherName)
);

CREATE TABLE Book (
BookTitle varchar(50) NOT NULL,
YearPublished varchar(5) NOT NULL,
NumberPages varchar(10) NOT NULL,
PublisherName varchar(20) NOT NULL,
GroupName varchar(50) NOT NULL,
CONSTRAINT Book_PK PRIMARY KEY (GroupName, BookTitle),
CONSTRAINT Book_FK_1 FOREIGN KEY (GroupName) REFERENCES WritingGroup (GroupName),
CONSTRAINT Book_FK_2 FOREIGN KEY (PublisherName) REFERENCES Publisher (PublisherName)
);


