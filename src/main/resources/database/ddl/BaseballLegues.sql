CREATE TABLE Users
(
  userName VARCHAR(25) NOT NULL,
  passw VARCHAR(25) NOT NULL,
  email VARCHAR(25) NOT NULL,
  userID INT NOT NULL,
  userRole INT NOT NULL,
  PRIMARY KEY (userID)
);

CREATE TABLE Address
(
  addressID INT NOT NULL,
  line1 VARCHAR(25) NOT NULL,
  line2 VARCHAR(25),
  city VARCHAR(25) NOT NULL,
  state VARCHAR(2) NOT NULL,
  zip INT NOT NULL,
  addressType CHAR(1) NOT NULL,
  PRIMARY KEY (addressID)
);

CREATE TABLE Phone
(
  phoneID INT NOT NULL,
  phoneNumber INT NOT NULL,
  phneType CHAR(1) NOT NULL,
  PRIMARY KEY (phoneID)
);

CREATE TABLE Payment
(
  paymentID INT NOT NULL,
  paymentType CHAR(1) NOT NULL,
  nameOnCard VARCHAR(50) NOT NULL,
  cardNumber INT NOT NULL,
  expDate DATE NOT NULL,
  crvCode INT NOT NULL,
  PRIMARY KEY (paymentID)
);

CREATE TABLE League
(
  leagueID INT NOT NULL,
  leagueName VARCHAR(50) NOT NULL,
  leagueLocation VARCHAR(50) NOT NULL,
  userID INT NOT NULL,
  PRIMARY KEY (leagueID),
  FOREIGN KEY (userID) REFERENCES Users(userID)
);

CREATE TABLE Season
(
  seasonID INT NOT NULL,
  seasonTitle VARCHAR(50) NOT NULL,
  seasonStartDt DATE NOT NULL,
  seasonEndDt DATE NOT NULL,
  seasonNumberOfPlayers INT NOT NULL,
  leagueID INT NOT NULL,
  PRIMARY KEY (seasonID, leagueID),
  FOREIGN KEY (leagueID) REFERENCES League(leagueID)
);

CREATE TABLE Division
(
  divisionID INT NOT NULL,
  divisionTitle VARCHAR(50) NOT NULL,
  divisionMinAge INT NOT NULL,
  divisionMaxAge INT NOT NULL,
  divisionNumberOfPlayer INT NOT NULL,
  seasonID INT NOT NULL,
  leagueID INT NOT NULL,
  PRIMARY KEY (divisionID, seasonID, leagueID),
  FOREIGN KEY (seasonID, leagueID) REFERENCES Season(seasonID, leagueID)
);

CREATE TABLE Field
(
  fieldID INT NOT NULL,
  fieldName VARCHAR(50) NOT NULL,
  fieldLocation VARCHAR(25) NOT NULL,
  PRIMARY KEY (fieldID)
);

CREATE TABLE AddressType
(
  addressTypeID CHAR(1) NOT NULL,
  addressType VARCHAR(25) NOT NULL,
  PRIMARY KEY (addressTypeID)
);

CREATE TABLE PhoneType
(
  phoneTypeID VARCHAR(1) NOT NULL,
  phoneType VARCHAR(25) NOT NULL,
  PRIMARY KEY (phoneTypeID)
);

CREATE TABLE PaymentType
(
  paymentTypeID VARCHAR(1) NOT NULL,
  paymentType VARCHAR(25) NOT NULL,
  PRIMARY KEY (paymentTypeID)
);

CREATE TABLE UserRole
(
  roleID CHAR(1) NOT NULL,
  userRole VARCHAR(25) NOT NULL,
  PRIMARY KEY (roleID)
);

CREATE TABLE StateLookUp
(
  stateID CHAR(2) NOT NULL,
  state VARCHAR(25) NOT NULL,
  PRIMARY KEY (stateID)
);

CREATE TABLE Person
(
  firstName VARCHAR(25) NOT NULL,
  lastName VARCHAR(25) NOT NULL,
  middleName VARCHAR(25),
  dob DATE NOT NULL,
  personID INT NOT NULL,
  userID INT,
  addressID INT,
  phoneID INT,
  paymentID INT,
  PRIMARY KEY (personID),
  FOREIGN KEY (userID) REFERENCES Users(userID),
  FOREIGN KEY (addressID) REFERENCES Address(addressID),
  FOREIGN KEY (phoneID) REFERENCES Phone(phoneID),
  FOREIGN KEY (paymentID) REFERENCES Payment(paymentID)
);

CREATE TABLE RefereePlayer
(
  refereeID INT NOT NULL,
  personID INT NOT NULL,
  PRIMARY KEY (refereeID, personID),
  FOREIGN KEY (personID) REFERENCES Person(personID)
);

CREATE TABLE Team
(
  teamID INT NOT NULL,
  teamTitle VARCHAR(50) NOT NULL,
  teamNumberOfPlayers INT NOT NULL,
  divisionID INT NOT NULL,
  seasonID INT NOT NULL,
  leagueID INT NOT NULL,
  fieldID INT,
  refereeID INT,
  personID INT,
  PRIMARY KEY (teamID, divisionID, seasonID, leagueID),
  FOREIGN KEY (divisionID, seasonID, leagueID) REFERENCES Division(divisionID, seasonID, leagueID),
  FOREIGN KEY (fieldID) REFERENCES Field(fieldID),
  FOREIGN KEY (refereeID, personID) REFERENCES RefereePlayer(refereeID, personID)
);