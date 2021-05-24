CREATE TABLE CITY (
ZIP_CODE char(4) PRIMARY KEY,
CITY VARCHAR(40) NOT NULL
)

CREATE TABLE AD_USER (
ID varchar(40) PRIMARY KEY,
FIRST_NAME varchar(30) NOT NULL,
LAST_NAME varchar(30) NOT NULL,
 COMPANY_NAME varchar(40),
PHONE_NUMBER varchar(20) NOT NULL,
PHONE_CODE varchar(10) NOT NULL,
EMAIL varchar(100) NOT NULL UNIQUE,
CREATION_DATE date NOT NULL,
CITY_FK char(4) NOT NULL,
TYPE Varchar(10) NOT NULL,
CONSTRAINT CITY_FK foreign key(CITY_FK) references CITY(ZIP_CODE)
)

CREATE TABLE ADVERTISEMENT (
ID varchar(40) PRIMARY KEY,
CATEGORY varchar(40) NOT NULL, //Denne modelerer bil/mc/legetøj/etc
TYPE varchar(40) NOT NULL,// denne modelerer salg/køb/lease etc
HEADLINE varchar(40) NOT NULL, // overskrift
TEXT varchar(1000) NOT NULL, // text I annonce
PRICE int NOT NULL, // pris
USER_FK varchar(40) NOT NULL, user foreign key
CREATION_DATE date NOT NULL, //oprettelses dato
CONSTRAINT USER_FK foreign key(USER_FK) references AD_USER(ID),
CONSTRAINT PRICE CHECK(PRICE>=0)) // mulig constraint