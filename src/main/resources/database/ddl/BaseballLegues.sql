

BEGIN
   EXECUTE IMMEDIATE 'drop table ADDRESS cascade constraints';
   EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'Drop Table ADDRESSType cascade constraints';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/
Begin
EXECUTE IMMEDIATE 'Drop Table Users cascade constraints';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'Drop Table Division cascade constraints';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'Drop Table Field cascade constraints';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'Drop Table League cascade constraints';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'Drop Table Payment cascade constraints';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'Drop Table PAYMENTTYPE cascade constraints';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'Drop Table Person cascade constraints';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'Drop Table PHONE cascade constraints';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'Drop Table PHONETYPE cascade constraints';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'Drop Table REFEREEPLAYER cascade constraints';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'Drop Table Season cascade constraints';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'Drop Table  STATELOOKUP cascade constraints';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'Drop Table Team cascade constraints';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'Drop Table UserRole cascade constraints';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'Drop Table Game cascade constraints';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/
BEGIN
EXECUTE IMMEDIATE 'Drop Table TeamAssignment cascade constraints';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/
BEGIN
EXECUTE IMMEDIATE 'Drop Table PersonRoleAssignment cascade constraints';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/

Drop Sequence ADDRESSID_SEQ;

Drop Sequence DIVISIONID_SEQ;
Drop Sequence FIELDID_SEQ;
Drop Sequence PAYMENTID_SEQ;
Drop Sequence PAYMENTTYPEID_SEQ;
Drop Sequence PERSONID_SEQ;
Drop Sequence PHONEID_SEQ;
Drop Sequence PHONETYPEID_SEQ;
Drop Sequence REFEREEID_SEQ;
Drop Sequence ROLEID_SEQ;
Drop Sequence LEAGUEID_SEQ;
Drop Sequence GAME_SEQ; 
Drop Sequence TEAMID_SEQ;
Drop Sequence USERID_SEQ;
Drop Sequence seasonID_SEQ;

/
CREATE TABLE Person
(
  firstName VARCHAR(25) NOT NULL,
  lastName VARCHAR(25) NOT NULL,
  middleName VARCHAR(25),
  dob DATE NOT NULL,
  personID INT NOT NULL,
  PRIMARY KEY (personID)
);
/
CREATE SEQUENCE personID_SEQ START WITH 10000 INCREMENT BY 1 MINVALUE 10000;
/
CREATE OR REPLACE TRIGGER personID_SEQ_TRIGGER
BEFORE INSERT ON Person 
FOR EACH ROW
BEGIN
  SELECT personID_SEQ.NEXTVAL
  INTO   :new.personID
  FROM   dual;
END;
/
CREATE TABLE Users
(
  personID int Not Null,
  userName VARCHAR(25) NOT NULL,
  passw VARCHAR(25) NOT NULL,
  email VARCHAR(25) NOT NULL,
  userID INT NOT NULL,
  userRole INT NOT NULL,
  PRIMARY KEY (userID),
    FOREIGN KEY (personID) REFERENCES Person(personID)
);
/
CREATE SEQUENCE userID_SEQ START WITH 10000 INCREMENT BY 1 MINVALUE 10000;
/
CREATE OR REPLACE TRIGGER USERID_SEQ_TRIGGER
BEFORE INSERT ON USERS 
FOR EACH ROW
BEGIN
  SELECT userID_SEQ.NEXTVAL
  INTO   :new.userid
  FROM   dual;
END;
/
CREATE TABLE Address
(
  personID int Not Null,
  addressID INT NOT NULL,
  address VARCHAR(50) NOT NULL,
  city VARCHAR(25) NOT NULL,
  state VARCHAR(2) NOT NULL,
  zip INT NOT NULL,
  PRIMARY KEY (addressID),
  FOREIGN KEY (personID) REFERENCES Person(personID)
);
/
CREATE SEQUENCE addressID_SEQ START WITH 10000 INCREMENT BY 1 MINVALUE 10000;
/
CREATE OR REPLACE TRIGGER addressID_SEQ_TRIGGER
BEFORE INSERT ON Address 
FOR EACH ROW
BEGIN
  SELECT addressID_SEQ.NEXTVAL
  INTO   :new.addressID
  FROM   dual;
END;
/

CREATE TABLE Phone
(
  personID int Not Null,
  phoneID INT NOT NULL,
  phoneNumber INT NOT NULL,
  phneType INT NOT NULL,
  PRIMARY KEY (phoneID),
    FOREIGN KEY (personID) REFERENCES Person(personID)
);
/
CREATE SEQUENCE phoneID_SEQ START WITH 10000 INCREMENT BY 1 MINVALUE 10000;
/
CREATE OR REPLACE TRIGGER phoneID_SEQ_TRIGGER
BEFORE INSERT ON Phone 
FOR EACH ROW
BEGIN
  SELECT phoneID_SEQ.NEXTVAL
  INTO   :new.phoneID
  FROM   dual;
END;
/

CREATE TABLE Payment
(
  personID int Not Null,
  paymentID INT NOT NULL,
  paymentType INT NOT NULL,
  nameOnCard VARCHAR(50) NOT NULL,
  cardNumber INT NOT NULL,
  expDate DATE NOT NULL,
  crvCode INT NOT NULL,
  PRIMARY KEY (paymentID),
    FOREIGN KEY (personID) REFERENCES Person(personID)
);
/
CREATE SEQUENCE paymentID_SEQ START WITH 10000 INCREMENT BY 1 MINVALUE 10000;
/
CREATE OR REPLACE TRIGGER paymentID_SEQ_TRIGGER
BEFORE INSERT ON Payment 
FOR EACH ROW
BEGIN
  SELECT paymentID_SEQ.NEXTVAL
  INTO   :new.paymentID
  FROM   dual;
END;
/
CREATE TABLE League
(
  leagueID INT NOT NULL,
  leagueName VARCHAR(50) NOT NULL,
  leagueLocation VARCHAR(50) NOT NULL,
  PRIMARY KEY (leagueID)
);
/
CREATE SEQUENCE leagueID_SEQ START WITH 10000 INCREMENT BY 1 MINVALUE 10000;
/
CREATE OR REPLACE TRIGGER leagueID_SEQ_TRIGGER
BEFORE INSERT ON League 
FOR EACH ROW
BEGIN
  SELECT leagueID_SEQ.NEXTVAL
  INTO   :new.leagueID
  FROM   dual;
END;
/
CREATE TABLE Season
(
  seasonID INT NOT NULL,
  seasonTitle VARCHAR(50) NOT NULL,
  seasonStartDt DATE NOT NULL,
  seasonEndDt DATE NOT NULL,
  seasonNumberOfPlayers INT NOT NULL,
  leagueID INT NOT NULL,
  PRIMARY KEY (seasonID),
  FOREIGN KEY (leagueID) REFERENCES League(leagueID)
);
/
CREATE SEQUENCE seasonID_SEQ START WITH 10000 INCREMENT BY 1 MINVALUE 10000;
/
CREATE OR REPLACE TRIGGER seasonID_SEQ_TRIGGER
BEFORE INSERT ON Season 
FOR EACH ROW
BEGIN
  SELECT seasonID_SEQ.NEXTVAL
  INTO   :new.seasonID
  FROM   dual;
END;
/
CREATE TABLE Division
(
  divisionID INT NOT NULL,
  divisionTitle VARCHAR(50) NOT NULL,
  divisionMinAge INT NOT NULL,
  divisionMaxAge INT NOT NULL,
  divisionNumberOfPlayer INT NOT NULL,
  seasonID INT NOT NULL,
  PRIMARY KEY (divisionID),
  FOREIGN KEY (seasonID) REFERENCES Season(seasonID)
);
/
CREATE SEQUENCE divisionID_SEQ START WITH 10000 INCREMENT BY 1 MINVALUE 10000;
/
CREATE OR REPLACE TRIGGER divisionID_SEQ_TRIGGER
BEFORE INSERT ON Division 
FOR EACH ROW
BEGIN
  SELECT divisionID_SEQ.NEXTVAL
  INTO   :new.divisionID
  FROM   dual;
END;
/

CREATE TABLE Field
(
  fieldID INT NOT NULL,
  fieldName VARCHAR(50) NOT NULL,
  fieldLocation VARCHAR(200) NOT NULL,
  PRIMARY KEY (fieldID)
);
/
CREATE SEQUENCE fieldID_SEQ START WITH 10000 INCREMENT BY 1 MINVALUE 10000;
/
CREATE OR REPLACE TRIGGER fieldID_SEQ_TRIGGER
BEFORE INSERT ON Field 
FOR EACH ROW
BEGIN
  SELECT fieldID_SEQ.NEXTVAL
  INTO   :new.fieldID
  FROM   dual;
END;
/

CREATE TABLE PhoneType
(
  phoneTypeID int NOT NULL,
  phoneType VARCHAR(25) NOT NULL,
  PRIMARY KEY (phoneTypeID)
);
/
CREATE SEQUENCE phoneTypeID_SEQ START WITH 10000 INCREMENT BY 1 MINVALUE 10000;
/
CREATE OR REPLACE TRIGGER phoneTypeID_SEQ_TRIGGER
BEFORE INSERT ON PhoneType 
FOR EACH ROW
BEGIN
  SELECT phoneTypeID_SEQ.NEXTVAL
  INTO   :new.phoneTypeID
  FROM   dual;
END;
/
CREATE TABLE PaymentType
(
  paymentTypeID int NOT NULL,
  paymentType VARCHAR(25) NOT NULL,
  PRIMARY KEY (paymentTypeID)
);
/
CREATE SEQUENCE paymentTypeID_SEQ START WITH 10000 INCREMENT BY 1 MINVALUE 10000;
/
CREATE OR REPLACE TRIGGER paymentTypeID_SEQ_TRIGGER
BEFORE INSERT ON PaymentType 
FOR EACH ROW
BEGIN
  SELECT paymentTypeID_SEQ.NEXTVAL
  INTO   :new.paymentTypeID
  FROM   dual;
END;
/
CREATE TABLE UserRole
(
  roleID int NOT NULL,
  userRole VARCHAR(25) NOT NULL,
  PRIMARY KEY (roleID)
);
/
CREATE SEQUENCE roleID_SEQ START WITH 10000 INCREMENT BY 1 MINVALUE 10000;
/
CREATE OR REPLACE TRIGGER roleID_SEQ_TRIGGER
BEFORE INSERT ON UserRole 
FOR EACH ROW
BEGIN
  SELECT roleID_SEQ.NEXTVAL
  INTO   :new.roleID
  FROM   dual;
END;
/
CREATE TABLE StateLookUp
(
  stateID VarCHAR(10) NOT NULL,
  state VARCHAR(50) NOT NULL,
  PRIMARY KEY (stateID)
);
/

CREATE TABLE RefereePlayer
(
  refereeID INT NOT NULL,
  personID INT NOT NULL,
  PRIMARY KEY (refereeID, personID),
  FOREIGN KEY (personID) REFERENCES Person(personID)
);
/
CREATE SEQUENCE refereeID_SEQ START WITH 10000 INCREMENT BY 1 MINVALUE 10000;
/
CREATE OR REPLACE TRIGGER refereeID_SEQ_TRIGGER
BEFORE INSERT ON RefereePlayer 
FOR EACH ROW
BEGIN
  SELECT refereeID_SEQ.NEXTVAL
  INTO   :new.refereeID
  FROM   dual;
END;
/
CREATE TABLE Team
(
  teamID INT NOT NULL,
  teamTitle VARCHAR(50) NOT NULL,
  teamNumberOfPlayers INT NOT NULL,
  divisionID INT NOT NULL,
  fieldID INT,
  --refereeID INT,
  --personID INT,
  PRIMARY KEY (teamID),
  FOREIGN KEY (divisionID) REFERENCES Division(divisionID),
  FOREIGN KEY (fieldID) REFERENCES Field(fieldID)
  --FOREIGN KEY (refereeID, personID) REFERENCES RefereePlayer(refereeID, personID)
);
/

CREATE SEQUENCE teamID_SEQ START WITH 10000 INCREMENT BY 1 MINVALUE 10000;
/
CREATE OR REPLACE TRIGGER teamID_SEQ_TRIGGER
BEFORE INSERT ON Team 
FOR EACH ROW
BEGIN
  SELECT teamID_SEQ.NEXTVAL
  INTO   :new.teamID
  FROM   dual;
END;
/
CREATE TABLE TeamAssignment
(
  teamID INT NOT NULL,
  personID int NOT NULL,
  FOREIGN KEY (teamID) REFERENCES Team(teamID),
  FOREIGN KEY (personID) REFERENCES Person(personID)
);
/
CREATE TABLE PersonRoleAssignment
(
  personID int NOT NULL,
  roleID int NOT NULL,
  FOREIGN KEY (personID) REFERENCES Person(personID),
  FOREIGN KEY (roleID) REFERENCES UserRole(roleID)
);
/
CREATE TABLE GAME
(
  GameID int NOT NULL,
  Team1ID int,
  Team2ID int,
  gameScore varchar(25),
  RefereeID int,
  FieldID int not null,
  GameTime Date not null,
  PRIMARY KEY (GameID),
  FOREIGN KEY (Team1ID) REFERENCES Team(teamID),
  FOREIGN KEY (Team2ID) REFERENCES Team(teamID),
  FOREIGN KEY (RefereeID) REFERENCES Person(personID),
  FOREIGN KEY (FieldID) REFERENCES Field(FieldID));
/

CREATE SEQUENCE Game_SEQ START WITH 10000 INCREMENT BY 1 MINVALUE 10000;
/
CREATE OR REPLACE TRIGGER Game_SEQ_TRIGGER
BEFORE INSERT ON Game 
FOR EACH ROW
BEGIN
  SELECT GameID_SEQ.NEXTVAL
  INTO   :new.GameID
  FROM   dual;
END;
/