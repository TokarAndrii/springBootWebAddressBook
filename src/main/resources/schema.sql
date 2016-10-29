CREATE DATABASE addressbook;

USE addressbook;


CREATE TABLE users (
  id       BIGINT AUTO_INCREMENT NOT NULL UNIQUE,
  fullName VARCHAR(255)          NOT NULL,
  login    VARCHAR(255)          NOT NULL UNIQUE,
  pass     VARCHAR(10)           NOT NULL UNIQUE,
  PRIMARY KEY (id)

);

CREATE TABLE contacts (
  id                BIGINT AUTO_INCREMENT NOT NULL UNIQUE,
  firstName         VARCHAR(255)          NOT NULL,
  secondName        VARCHAR(255)          NOT NULL,
  fathersName       VARCHAR(255)          NOT NULL,
  mobilePhoneNumber VARCHAR(15),
  homePhoneNumber   VARCHAR(15),
  homeAddress       VARCHAR(255),
  email             VARCHAR(255),
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users (id)


);