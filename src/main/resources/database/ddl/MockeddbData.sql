INSERT INTO USERROLE ( USERROLE) values ('Manager');
INSERT INTO USERROLE ( USERROLE) values ('Player');
INSERT INTO USERROLE ( USERROLE) values ('Referee');
/
INSERT INTO PaymentType ( PaymentType) values ('Visa');
INSERT INTO PaymentType ( PaymentType) values ('Discover');
INSERT INTO PaymentType ( PaymentType) values ('Amex');
INSERT INTO PaymentType ( PaymentType) values ('Mastercard');
/
INSERT INTO PhoneType ( PhoneType) values ('Mobile');
INSERT INTO PhoneType ( PhoneType) values ('Work');
INSERT INTO PhoneType ( PhoneType) values ('Home');
/
INSERT INTO PERSON(FIRSTNAME,LASTNAME,MIDDLENAME,DOB) VALUES('Bill','Bob','Ray',TO_DATE('1970/01/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO PERSON(FIRSTNAME,LASTNAME,MIDDLENAME,DOB) VALUES('Todd','Al','Bob',TO_DATE('1974/01/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO PERSON(FIRSTNAME,LASTNAME,MIDDLENAME,DOB) VALUES('Harry','Tack','Phil',TO_DATE('1980/01/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO PERSON(FIRSTNAME,LASTNAME,MIDDLENAME,DOB) VALUES('Jane','Flack','Jill',TO_DATE('2004/01/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO PERSON(FIRSTNAME,LASTNAME,MIDDLENAME,DOB) VALUES('Brian','Wheel','Jay',TO_DATE('2009/01/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO PERSON(FIRSTNAME,LASTNAME,MIDDLENAME,DOB) VALUES('Artem','Simpson','Carl',TO_DATE('2009/01/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO PERSON(FIRSTNAME,LASTNAME,MIDDLENAME,DOB) VALUES('Abhijit','Griffin','Al',TO_DATE('2009/01/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO PERSON(FIRSTNAME,LASTNAME,MIDDLENAME,DOB) VALUES('Chrissy','Lila','Sara',TO_DATE('2009/01/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO PERSON(FIRSTNAME,LASTNAME,MIDDLENAME,DOB) VALUES('Jim','Lik','Tom',TO_DATE('2009/01/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO PERSON(FIRSTNAME,LASTNAME,MIDDLENAME,DOB) VALUES('John','Bob','Ray',TO_DATE('2009/02/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO PERSON(FIRSTNAME,LASTNAME,MIDDLENAME,DOB) VALUES('Sally','Rike','Mary',TO_DATE('2009/03/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO PERSON(FIRSTNAME,LASTNAME,MIDDLENAME,DOB) VALUES('JJ','Campbell','Will',TO_DATE('2009/04/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO PERSON(FIRSTNAME,LASTNAME,MIDDLENAME,DOB) VALUES('Sarah','Lock','Todd',TO_DATE('2004/05/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO PERSON(FIRSTNAME,LASTNAME,MIDDLENAME,DOB) VALUES('TJ','Ryme','',TO_DATE('2004/06/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO PERSON(FIRSTNAME,LASTNAME,MIDDLENAME,DOB) VALUES('Sara','Ryme','',TO_DATE('2011/07/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO PERSON(FIRSTNAME,LASTNAME,MIDDLENAME,DOB) VALUES('Jack','Time','Phil',TO_DATE('2004/08/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO PERSON(FIRSTNAME,LASTNAME,MIDDLENAME,DOB) VALUES('Phil','Jordan','John',TO_DATE('2004/09/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO PERSON(FIRSTNAME,LASTNAME,MIDDLENAME,DOB) VALUES('Miles','Palace','Pat',TO_DATE('2004/10/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO PERSON(FIRSTNAME,LASTNAME,MIDDLENAME,DOB) VALUES('Rick','Fletcher','Steve',TO_DATE('2004/11/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO PERSON(FIRSTNAME,LASTNAME,MIDDLENAME,DOB) VALUES('Carl','Smith','Alan',TO_DATE('2004/12/01 12:00:00', 'yyyy/mm/dd hh24:mi:ss'));
INSERT INTO PERSON(FIRSTNAME,LASTNAME,MIDDLENAME,DOB) VALUES('Lilly','Brown','Marie',TO_DATE('2004/01/30 12:00:00', 'yyyy/mm/dd hh24:mi:ss'));
/
Insert Into Users (Username, Passw, EMAIL,  personID) Select 'Bill','Password' ,'Email@Gmail.com',(select PersonID From Person where FirstName = 'Bill') from dual;
Insert Into Users (Username, Passw, EMAIL,  personID) Select 'Todd','Password' ,'Tmail@Gmail.com',(select PersonID From Person where FirstName = 'Todd')from dual;
Insert Into Users (Username, Passw, EMAIL,  personID) Select 'Harry','Password' ,'Hmail@Gmail.com',(select PersonID From Person where FirstName = 'Harry') from dual;
Insert Into Users (Username, Passw, EMAIL,  personID) Select 'Jane','Password' ,'Jmail@Gmail.com',(select PersonID From Person where FirstName = 'Jane') from dual;
Insert Into Users (Username, Passw, EMAIL,  personID) Select 'Brian','Password' ,'Pmail@Gmail.com',(select PersonID From Person where FirstName = 'Brian') from dual;
Insert Into Users (Username, Passw, EMAIL,  personID) Select 'Artem','Password' ,'Amail@Gmail.com',(select PersonID From Person where FirstName = 'Artem') from dual;
Insert Into Users (Username, Passw, EMAIL,  personID) Select 'Abhijit','Password' ,'Imail@Gmail.com',(select PersonID From Person where FirstName = 'Abhijit') from dual;
Insert Into Users (Username, Passw, EMAIL,  personID) Select 'Chrissy','Password' ,'Cmail@Gmail.com',(select PersonID From Person where FirstName = 'Chrissy') from dual;
Insert Into Users (Username, Passw, EMAIL,  personID) Select 'Jim','Password' ,'a@Gmail.com',(select PersonID From Person where FirstName = 'Jim') from dual;
Insert Into Users (Username, Passw, EMAIL,  personID) Select 'John','Password' ,'b@Gmail.com',(select PersonID From Person where FirstName = 'John') from dual;
Insert Into Users (Username, Passw, EMAIL,  personID) Select 'Sally','Password' ,'c@Gmail.com',(select PersonID From Person where FirstName = 'Sally') from dual;
Insert Into Users (Username, Passw, EMAIL,  personID) Select 'JJ','Password' ,'d@Gmail.com',(select PersonID From Person where FirstName = 'JJ') from dual;
Insert Into Users (Username, Passw, EMAIL,  personID) Select 'Sarah','Password' ,'e@Gmail.com',(select PersonID From Person where FirstName = 'Sarah') from dual;
Insert Into Users (Username, Passw, EMAIL,  personID) Select 'Sara','Password' ,'f@Gmail.com',(select PersonID From Person where FirstName = 'Sara') from dual;
Insert Into Users (Username, Passw, EMAIL,  personID) Select 'TJ','Password' ,'g@Gmail.com',(select PersonID From Person where FirstName = 'TJ') from dual;
Insert Into Users (Username, Passw, EMAIL,  personID) Select 'Jack','Password' ,'h@Gmail.com',(select PersonID From Person where FirstName = 'Jack') from dual;
Insert Into Users (Username, Passw, EMAIL,  personID) Select 'Phil','Password' ,'i@Gmail.com',(select PersonID From Person where FirstName = 'Phil') from dual;
Insert Into Users (Username, Passw, EMAIL,  personID) Select 'Miles','Password' ,'j@Gmail.com',(select PersonID From Person where FirstName = 'Miles') from dual;
Insert Into Users (Username, Passw, EMAIL,  personID) Select 'Rick','Password' ,'k@Gmail.com',(select PersonID From Person where FirstName = 'Rick') from dual;
Insert Into Users (Username, Passw, EMAIL,  personID) Select 'Carl','Password' ,'l@Gmail.com',(select PersonID From Person where FirstName = 'Carl') from dual;
Insert Into Users (Username, Passw, EMAIL,  personID) Select 'Lilly','Password' ,'m@Gmail.com',(select PersonID From Person where FirstName = 'Lilly') from dual;
/
INSERT INTO ADDRESS (     Address,        CITY,    STATE,    ZIP,    personID  ) Select '2535 Fox Hill Rd APT 1','State College', 'PA','16803',(select PersonID From Person where FirstName = 'Bill') From dual;
INSERT INTO ADDRESS (     Address,        CITY,    STATE,    ZIP,    personID  ) Select '2535 Fox Hill Rd APT 1','State College', 'PA','16803',(select PersonID From Person where FirstName = 'Todd') From dual;
INSERT INTO ADDRESS (     Address,        CITY,    STATE,    ZIP,    personID  ) Select '2535 Fox Hill Rd APT 1','State College', 'PA','16803',(select PersonID From Person where FirstName = 'Harry') From dual;
INSERT INTO ADDRESS (     Address,        CITY,    STATE,    ZIP,    personID  ) Select '679 Waupelani Dr APT 1','State College', 'PA','16801',(select PersonID From Person where FirstName = 'Jane') From dual;
INSERT INTO ADDRESS (     Address,        CITY,    STATE,    ZIP,    personID  ) Select '679 Waupelani Dr APT 2','State College', 'PA','16801',(select PersonID From Person where FirstName = 'Brian') From dual;
INSERT INTO ADDRESS (     Address,        CITY,    STATE,    ZIP,    personID ) Select '679 Waupelani Dr APT 3','State College', 'PA','16801',(select PersonID From Person where FirstName = 'Artem') From dual;
INSERT INTO ADDRESS (     Address,        CITY,    STATE,    ZIP,    personID  ) Select '679 Waupelani Dr APT 4','State College', 'PA','16801',(select PersonID From Person where FirstName = 'Artem') From dual;
INSERT INTO ADDRESS (     Address,        CITY,    STATE,    ZIP,    personID  ) Select '24 Waupelani Dr APT 1','State College', 'PA','16801',(select PersonID From Person where FirstName = 'Abhijit') From dual;
INSERT INTO ADDRESS (     Address,        CITY,    STATE,    ZIP,    personID  ) Select '24 Waupelani Dr APT 2','State College', 'PA','16801',(select PersonID From Person where FirstName = 'Chrissy') From dual;
INSERT INTO ADDRESS (     Address,        CITY,    STATE,    ZIP,    personID ) Select '24 Waupelani Dr APT 3','State College', 'PA','16801',(select PersonID From Person where FirstName = 'Jim') From dual;
INSERT INTO ADDRESS (     Address,        CITY,    STATE,    ZIP,    personID  ) Select '24 Waupelani Dr APT 4','State College', 'PA','16801',(select PersonID From Person where FirstName = 'John') From dual;
INSERT INTO ADDRESS (     Address,        CITY,    STATE,    ZIP,    personID  ) Select '348 Blue Course Dr APT 1','State College', 'PA','16803',(select PersonID From Person where FirstName = 'Sally') From dual;
INSERT INTO ADDRESS (     Address,        CITY,    STATE,    ZIP,    personID ) Select '348 Blue Course Dr APT 2','State College', 'PA','16803',(select PersonID From Person where FirstName = 'JJ') From dual;
INSERT INTO ADDRESS (     Address,        CITY,    STATE,    ZIP,    personID  ) Select '348 Blue Course Dr APT 2','State College', 'PA','16803',(select PersonID From Person where FirstName = 'JJ') From dual;
INSERT INTO ADDRESS (     Address,        CITY,    STATE,    ZIP,    personID  ) Select '348 Blue Course Dr APT 3','State College', 'PA','16803',(select PersonID From Person where FirstName = 'Sarah') From dual;
INSERT INTO ADDRESS (     Address,        CITY,    STATE,    ZIP,    personID  ) Select '348 Blue Course Dr APT 4','State College', 'PA','16803',(select PersonID From Person where FirstName = 'Sara') From dual;
INSERT INTO ADDRESS (     Address,        CITY,    STATE,    ZIP,    personID  ) Select '348 Blue Course Dr APT 5','State College', 'PA','16803',(select PersonID From Person where FirstName = 'Sara') From dual;
INSERT INTO ADDRESS (     Address,        CITY,    STATE,    ZIP,    personID  ) Select '1013 S Allen St APT 1','State College', 'PA','16803',(select PersonID From Person where FirstName = 'TJ') From dual;
INSERT INTO ADDRESS (     Address,        CITY,    STATE,    ZIP,    personID  ) Select '1013 S Allen St APT 2','State College', 'PA','16803',(select PersonID From Person where FirstName = 'Jack') From dual;
INSERT INTO ADDRESS (     Address,        CITY,    STATE,    ZIP,    personID  ) Select '1013 S Allen St APT 3','State College', 'PA','16803',(select PersonID From Person where FirstName = 'Phil') From dual;
INSERT INTO ADDRESS (     Address,        CITY,    STATE,    ZIP,    personID  ) Select '1013 S Allen St APT 4','State College', 'PA','16803',(select PersonID From Person where FirstName = 'Miles') From dual;
INSERT INTO ADDRESS (     Address,        CITY,    STATE,    ZIP,    personID  ) Select '1013 S Allen St APT 5','State College', 'PA','16803',(select PersonID From Person where FirstName = 'Rick') From dual;
INSERT INTO ADDRESS (     Address,        CITY,    STATE,    ZIP,    personID  ) Select '1013 S Allen St APT 6','State College', 'PA','16803',(select PersonID From Person where FirstName = 'Carl') From dual;
INSERT INTO ADDRESS (     Address,        CITY,    STATE,    ZIP,    personID  ) Select '1013 S Allen St APT 7','State College', 'PA','16803',(select PersonID From Person where FirstName = 'Lilly') From dual;
/

INSERT INTO PAYMENT(PERSONID,PAYMENTTYPE,NAMEONCARD,CARDNUMBER,EXPDATE,CRVCODE) Select (select PersonID From Person where FirstName = 'Jane'),(SELECT PAYMENTTYPEID FROM PAYMENTTYPE where PAYMENTTYPE='Visa'),(select (FirstName||' '|| LastName) From Person where FirstName = 'Jane'),1234567890,(to_date(add_months(sysdate,24), 'yyyy/mm/dd:hh:mi:ssam')),123 From dual;
INSERT INTO PAYMENT(PERSONID,PAYMENTTYPE,NAMEONCARD,CARDNUMBER,EXPDATE,CRVCODE) Select (select PersonID From Person where FirstName = 'Brian'),(SELECT PAYMENTTYPEID FROM PAYMENTTYPE where PAYMENTTYPE='Discover'),(select (FirstName||' '|| LastName) From Person where FirstName = 'Brian'),1234567890,(to_date(add_months(sysdate,24), 'yyyy/mm/dd:hh:mi:ssam')),123 From dual;
INSERT INTO PAYMENT(PERSONID,PAYMENTTYPE,NAMEONCARD,CARDNUMBER,EXPDATE,CRVCODE) Select (select PersonID From Person where FirstName = 'Artem'),(SELECT PAYMENTTYPEID FROM PAYMENTTYPE where PAYMENTTYPE='Discover'),(select (FirstName||' '|| LastName) From Person where FirstName = 'Artem'),1234567890,(to_date(add_months(sysdate,24), 'yyyy/mm/dd:hh:mi:ssam')),123 From dual;
INSERT INTO PAYMENT(PERSONID,PAYMENTTYPE,NAMEONCARD,CARDNUMBER,EXPDATE,CRVCODE) Select (select PersonID From Person where FirstName = 'Abhijit'),(SELECT PAYMENTTYPEID FROM PAYMENTTYPE where PAYMENTTYPE='Visa'),(select (FirstName||' '|| LastName) From Person where FirstName = 'Abhijit'),1234567890,(to_date(add_months(sysdate,24), 'yyyy/mm/dd:hh:mi:ssam')),123 From dual;
INSERT INTO PAYMENT(PERSONID,PAYMENTTYPE,NAMEONCARD,CARDNUMBER,EXPDATE,CRVCODE) Select (select PersonID From Person where FirstName = 'Chrissy'),(SELECT PAYMENTTYPEID FROM PAYMENTTYPE where PAYMENTTYPE='Visa'),(select (FirstName||' '|| LastName) From Person where FirstName = 'Chrissy'),1234567890,(to_date(add_months(sysdate,24), 'yyyy/mm/dd:hh:mi:ssam')),123 From dual;
INSERT INTO PAYMENT(PERSONID,PAYMENTTYPE,NAMEONCARD,CARDNUMBER,EXPDATE,CRVCODE) Select (select PersonID From Person where FirstName = 'Jim'),(SELECT PAYMENTTYPEID FROM PAYMENTTYPE where PAYMENTTYPE='Discover'),(select (FirstName||' '|| LastName) From Person where FirstName = 'Jim'),1234567890,(to_date(add_months(sysdate,24), 'yyyy/mm/dd:hh:mi:ssam')),123 From dual;
INSERT INTO PAYMENT(PERSONID,PAYMENTTYPE,NAMEONCARD,CARDNUMBER,EXPDATE,CRVCODE) Select (select PersonID From Person where FirstName = 'John'),(SELECT PAYMENTTYPEID FROM PAYMENTTYPE where PAYMENTTYPE='Visa'),(select (FirstName||' '|| LastName) From Person where FirstName = 'John'),1234567890,(to_date(add_months(sysdate,24), 'yyyy/mm/dd:hh:mi:ssam')),123 From dual;
INSERT INTO PAYMENT(PERSONID,PAYMENTTYPE,NAMEONCARD,CARDNUMBER,EXPDATE,CRVCODE) Select (select PersonID From Person where FirstName = 'Sally'),(SELECT PAYMENTTYPEID FROM PAYMENTTYPE where PAYMENTTYPE='Discover'),(select (FirstName||' '|| LastName) From Person where FirstName = 'Sally'),1234567890,(to_date(add_months(sysdate,24), 'yyyy/mm/dd:hh:mi:ssam')),123 From dual;
INSERT INTO PAYMENT(PERSONID,PAYMENTTYPE,NAMEONCARD,CARDNUMBER,EXPDATE,CRVCODE) Select (select PersonID From Person where FirstName = 'JJ'),(SELECT PAYMENTTYPEID FROM PAYMENTTYPE where PAYMENTTYPE='Visa'),(select (FirstName||' '|| LastName) From Person where FirstName = 'JJ'),1234567890,(to_date(add_months(sysdate,24), 'yyyy/mm/dd:hh:mi:ssam')),123 From dual;
INSERT INTO PAYMENT(PERSONID,PAYMENTTYPE,NAMEONCARD,CARDNUMBER,EXPDATE,CRVCODE) Select (select PersonID From Person where FirstName = 'Sarah'),(SELECT PAYMENTTYPEID FROM PAYMENTTYPE where PAYMENTTYPE='Discover'),(select (FirstName||' '|| LastName) From Person where FirstName = 'Sarah'),1234567890,(to_date(add_months(sysdate,24), 'yyyy/mm/dd:hh:mi:ssam')),123 From dual;
INSERT INTO PAYMENT(PERSONID,PAYMENTTYPE,NAMEONCARD,CARDNUMBER,EXPDATE,CRVCODE) Select (select PersonID From Person where FirstName = 'Sara'),(SELECT PAYMENTTYPEID FROM PAYMENTTYPE where PAYMENTTYPE='Visa'),(select (FirstName||' '|| LastName) From Person where FirstName = 'Sara'),1234567890,(to_date(add_months(sysdate,24), 'yyyy/mm/dd:hh:mi:ssam')),123 From dual;
INSERT INTO PAYMENT(PERSONID,PAYMENTTYPE,NAMEONCARD,CARDNUMBER,EXPDATE,CRVCODE) Select (select PersonID From Person where FirstName = 'TJ'),(SELECT PAYMENTTYPEID FROM PAYMENTTYPE where PAYMENTTYPE='Discover'),(select (FirstName||' '|| LastName) From Person where FirstName = 'TJ'),1234567890,(to_date(add_months(sysdate,24), 'yyyy/mm/dd:hh:mi:ssam')),123 From dual;
INSERT INTO PAYMENT(PERSONID,PAYMENTTYPE,NAMEONCARD,CARDNUMBER,EXPDATE,CRVCODE) Select (select PersonID From Person where FirstName = 'Jack'),(SELECT PAYMENTTYPEID FROM PAYMENTTYPE where PAYMENTTYPE='Visa'),(select (FirstName||' '|| LastName) From Person where FirstName = 'Jack'),1234567890,(to_date(add_months(sysdate,24), 'yyyy/mm/dd:hh:mi:ssam')),123 From dual;
INSERT INTO PAYMENT(PERSONID,PAYMENTTYPE,NAMEONCARD,CARDNUMBER,EXPDATE,CRVCODE) Select (select PersonID From Person where FirstName = 'Phil'),(SELECT PAYMENTTYPEID FROM PAYMENTTYPE where PAYMENTTYPE='Discover'),(select (FirstName||' '|| LastName) From Person where FirstName = 'Phil'),1234567890,(to_date(add_months(sysdate,24), 'yyyy/mm/dd:hh:mi:ssam')),123 From dual;
INSERT INTO PAYMENT(PERSONID,PAYMENTTYPE,NAMEONCARD,CARDNUMBER,EXPDATE,CRVCODE) Select (select PersonID From Person where FirstName = 'Miles'),(SELECT PAYMENTTYPEID FROM PAYMENTTYPE where PAYMENTTYPE='Visa'),(select (FirstName||' '|| LastName) From Person where FirstName = 'Miles'),1234567890,(to_date(add_months(sysdate,24), 'yyyy/mm/dd:hh:mi:ssam')),123 From dual;
INSERT INTO PAYMENT(PERSONID,PAYMENTTYPE,NAMEONCARD,CARDNUMBER,EXPDATE,CRVCODE) Select (select PersonID From Person where FirstName = 'Rick'),(SELECT PAYMENTTYPEID FROM PAYMENTTYPE where PAYMENTTYPE='Discover'),(select (FirstName||' '|| LastName) From Person where FirstName = 'Rick'),1234567890,(to_date(add_months(sysdate,24), 'yyyy/mm/dd:hh:mi:ssam')),123 From dual;
INSERT INTO PAYMENT(PERSONID,PAYMENTTYPE,NAMEONCARD,CARDNUMBER,EXPDATE,CRVCODE) Select (select PersonID From Person where FirstName = 'Carl'),(SELECT PAYMENTTYPEID FROM PAYMENTTYPE where PAYMENTTYPE='Visa'),(select (FirstName||' '|| LastName) From Person where FirstName = 'Carl'),1234567890,(to_date(add_months(sysdate,24), 'yyyy/mm/dd:hh:mi:ssam')),123 From dual;
INSERT INTO PAYMENT(PERSONID,PAYMENTTYPE,NAMEONCARD,CARDNUMBER,EXPDATE,CRVCODE) Select (select PersonID From Person where FirstName = 'Lilly'),(SELECT PAYMENTTYPEID FROM PAYMENTTYPE where PAYMENTTYPE='Discover'),(select (FirstName||' '|| LastName) From Person where FirstName = 'Lilly'),1234567890,(to_date(add_months(sysdate,24), 'yyyy/mm/dd:hh:mi:ssam')),123 From dual;
/
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Bill'),123456789,(Select PhoneTypeID from PhoneType Where PhoneType = 'Mobile')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Todd'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Mobile')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Harry'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Mobile')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Jane'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Mobile')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Brian'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Mobile')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Artem'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Mobile')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Abhijit'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Mobile')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Chrissy'),123456789,(Select PhoneTypeID from PhoneType Where PhoneType = 'Mobile')   From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Jim'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Mobile')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'John'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Mobile')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Sally'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Mobile')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'JJ'),123456789,(Select PhoneTypeID from PhoneType Where PhoneType = 'Mobile')   From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Sarah'),123456789,(Select PhoneTypeID from PhoneType Where PhoneType = 'Mobile')   From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Sara'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Mobile')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'TJ'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Mobile')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Jack'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Mobile')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Phil'),123456789,(Select PhoneTypeID from PhoneType Where PhoneType = 'Mobile')   From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Miles'),123456789,(Select PhoneTypeID from PhoneType Where PhoneType = 'Mobile')   From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Rick'),123456789,(Select PhoneTypeID from PhoneType Where PhoneType = 'Mobile')   From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Carl'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Mobile')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Lilly'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Mobile')  From dual;

INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Bill'),123456789,(Select PhoneTypeID from PhoneType Where PhoneType = 'Home')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Todd'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Home')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Harry'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Home')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Jane'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Home')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Brian'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Home')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Artem'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Home')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Abhijit'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Home')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Chrissy'),123456789,(Select PhoneTypeID from PhoneType Where PhoneType = 'Home')   From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Jim'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Home')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'John'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Home')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Sally'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Home')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'JJ'),123456789,(Select PhoneTypeID from PhoneType Where PhoneType = 'Home')   From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Sarah'),123456789,(Select PhoneTypeID from PhoneType Where PhoneType = 'Home')   From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Sara'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Home')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'TJ'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Home')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Jack'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Home')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Phil'),123456789,(Select PhoneTypeID from PhoneType Where PhoneType = 'Home')   From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Miles'),123456789,(Select PhoneTypeID from PhoneType Where PhoneType = 'Home')   From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Rick'),123456789,(Select PhoneTypeID from PhoneType Where PhoneType = 'Home')   From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Carl'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Home')  From dual;
INSERT INTO PHONE  (    PERSONID,        PHONENUMBER,    PHNETYPE  )  Select  (select PersonID From Person where FirstName = 'Lilly'),123456789, (Select PhoneTypeID from PhoneType Where PhoneType = 'Home')  From dual;
/
INSERT INTO LEAGUE  (    LEAGUENAME,    LEAGUELOCATION,   PERSONID)  Select  'State College League',       'Nittany Lion Softball Park', 10018 From dual;
INSERT INTO LEAGUE  (    LEAGUENAME,    LEAGUELOCATION,   PERSONID)  Select  'Tussey View Park League',    'Tussey View Park', 10019 From dual;
INSERT INTO LEAGUE  (    LEAGUENAME,    LEAGUELOCATION,   PERSONID)  Select  'Tudek Memorial Park League', 'Tudek Memorial Park', 10020 From dual;

INSERT INTO SEASON  (    SEASONTITLE,    SEASONSTARTDT,    SEASONENDDT,    SEASONNUMBEROFPLAYERS,    LEAGUEID  )  Select    'Summer',    (to_date(add_months(sysdate,1), 'yyyy/mm/dd:hh:mi:ssam')),    (to_date(add_months(sysdate,4), 'yyyy/mm/dd:hh:mi:ssam')),    18,    (Select LEAGUEID from LEAGUE where LEAGUENAME ='State College League') from dual;
/
INSERT INTO FIELD ( FIELDNAME, FIELDLOCATION ) VALUES  ( 'Main Field', 'Nittany Lion Softball Park'  );
/
INSERT INTO REFEREEPLAYER  ( PERSONID) Select PersonID From PERSON where FirstName = 'Harry';
/
Insert into Division(DIVISIONTITLE,DIVISIONMINAGE,DIVISIONMAXAGE,DIVISIONNUMBEROFPLAYER,SEASONID) Select 'Pony',10,14,18,(Select SEASONID from Season Where SEASONTITLE='Summer') from dual;
/
INSERT INTO StateLookup(STATE, STATEID) VALUES ('Alabama', 'AL');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Alaska', 'AK');
INSERT INTO StateLookup(STATE, STATEID) VALUES       ('Arizona', 'AZ');
INSERT INTO StateLookup(STATE, STATEID) VALUES      ('Arkansas', 'AR');
INSERT INTO StateLookup(STATE, STATEID) VALUES       ('California', 'CA');
INSERT INTO StateLookup(STATE, STATEID) VALUES      ('Colorado', 'CO');
INSERT INTO StateLookup(STATE, STATEID) VALUES       ('Connecticut', 'CT');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Delaware', 'DE');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('District of Columbia', 'DC');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Florida', 'FL');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Georgia', 'GA');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Hawaii', 'HI');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Idaho', 'ID');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Illinois', 'IL');
INSERT INTO StateLookup(STATE, STATEID) VALUES       ('Indiana', 'IN');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Iowa', 'IA');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Kansas', 'KS');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Kentucky', 'KY');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Louisiana', 'LA');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Maine', 'ME');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Maryland', 'MD');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Massachusetts', 'MA');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Michigan', 'MI');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Minnesota', 'MN');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Mississippi', 'MS');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Missouri', 'MO');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Montana', 'MT');
INSERT INTO StateLookup(STATE, STATEID) VALUES       ('Nebraska', 'NE');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Nevada', 'NV');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('New Hampshire', 'NH');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('New Jersey', 'NJ');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('New Mexico', 'NM');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('New York', 'NY');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('North Carolina', 'NC');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('North Dakota', 'ND');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Ohio', 'OH');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Oklahoma', 'OK');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Oregon', 'OR');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Pennsylvania', 'PA');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Rhode Island', 'RI');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('South Carolina', 'SC');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('South Dakota', 'SD');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Tennessee', 'TN');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Texas', 'TX');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Utah', 'UT');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Vermont', 'VT');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Virginia', 'VA');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Washington', 'WA');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('West Virginia', 'WV');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Wisconsin', 'WI');
INSERT INTO StateLookup(STATE, STATEID) VALUES        ('Wyoming', 'WY');
/
INSERT INTO PERSONROLEASSIGNMENT(PERSONID,ROLEID) SELECT 10000, 10001 FROM DUAL;
INSERT INTO PERSONROLEASSIGNMENT(PERSONID,ROLEID) SELECT 10001, 10002 FROM DUAL;
INSERT INTO PERSONROLEASSIGNMENT(PERSONID,ROLEID) SELECT 10002, 10001 FROM DUAL;
INSERT INTO PERSONROLEASSIGNMENT(PERSONID,ROLEID) SELECT 10003, 10001 FROM DUAL;
INSERT INTO PERSONROLEASSIGNMENT(PERSONID,ROLEID) SELECT 10004, 10001 FROM DUAL;
INSERT INTO PERSONROLEASSIGNMENT(PERSONID,ROLEID) SELECT 10005, 10001 FROM DUAL;
INSERT INTO PERSONROLEASSIGNMENT(PERSONID,ROLEID) SELECT 10006, 10001 FROM DUAL;
INSERT INTO PERSONROLEASSIGNMENT(PERSONID,ROLEID) SELECT 10007, 10001 FROM DUAL;
INSERT INTO PERSONROLEASSIGNMENT(PERSONID,ROLEID) SELECT 10008, 10001 FROM DUAL;
INSERT INTO PERSONROLEASSIGNMENT(PERSONID,ROLEID) SELECT 10009, 10001 FROM DUAL;
INSERT INTO PERSONROLEASSIGNMENT(PERSONID,ROLEID) SELECT 10010, 10001 FROM DUAL;
INSERT INTO PERSONROLEASSIGNMENT(PERSONID,ROLEID) SELECT 10011, 10001 FROM DUAL;
INSERT INTO PERSONROLEASSIGNMENT(PERSONID,ROLEID) SELECT 10012, 10001 FROM DUAL;
INSERT INTO PERSONROLEASSIGNMENT(PERSONID,ROLEID) SELECT 10013, 10001 FROM DUAL;
INSERT INTO PERSONROLEASSIGNMENT(PERSONID,ROLEID) SELECT 10014, 10001 FROM DUAL;
INSERT INTO PERSONROLEASSIGNMENT(PERSONID,ROLEID) SELECT 10015, 10001 FROM DUAL;
INSERT INTO PERSONROLEASSIGNMENT(PERSONID,ROLEID) SELECT 10016, 10001 FROM DUAL;
INSERT INTO PERSONROLEASSIGNMENT(PERSONID,ROLEID) SELECT 10017, 10001 FROM DUAL;
INSERT INTO PERSONROLEASSIGNMENT(PERSONID,ROLEID) SELECT 10018, 10000 FROM DUAL;
INSERT INTO PERSONROLEASSIGNMENT(PERSONID,ROLEID) SELECT 10019, 10000 FROM DUAL;
INSERT INTO PERSONROLEASSIGNMENT(PERSONID,ROLEID) SELECT 10020, 10000 FROM DUAL;
/
INSERT INTO TEAM  (TEAMTITLE, TEAMNUMBEROFPLAYERS, DIVISIONID  )  Select  'TEAM1', 10, (Select DIVISIONID from DIVISION where DIVISIONTITLE ='Pony') From dual;
INSERT INTO TEAM  (TEAMTITLE, TEAMNUMBEROFPLAYERS, DIVISIONID  )  Select  'TEAM2', 10, (Select DIVISIONID from DIVISION where DIVISIONTITLE ='Pony') From dual;
INSERT INTO TEAM  (TEAMTITLE, TEAMNUMBEROFPLAYERS, DIVISIONID  )  Select  'TEAM3', 10, (Select DIVISIONID from DIVISION where DIVISIONTITLE ='Pony') From dual;
/
Insert into Game(TEAM1ID,TEAM2ID,Team1Score, Team2score ,REFEREEID,FIELDID,GAMETIME) Select (Select TeamID from Team where TEAMTITLE = 'TEAM1'),(Select TeamID from Team where TEAMTITLE = 'TEAM2'),0,0,10002,10000,sysdate from dual;
Insert into Game(TEAM1ID,TEAM2ID,Team1Score, Team2score ,REFEREEID,FIELDID,GAMETIME) Select (Select TeamID from Team where TEAMTITLE = 'TEAM2'),(Select TeamID from Team where TEAMTITLE = 'TEAM3'),0,0,10002,10000,sysdate+1 from dual;
Insert into Game(TEAM1ID,TEAM2ID,Team1Score, Team2score ,REFEREEID,FIELDID,GAMETIME) Select (Select TeamID from Team where TEAMTITLE = 'TEAM3'),(Select TeamID from Team where TEAMTITLE = 'TEAM1'),0,0,10002,10000,sysdate+2 from dual;

/
INSERT INTO PersonLeague(PERSONID,LEAGUEID) SELECT 10002, 10000 FROM DUAL;
INSERT INTO PersonLeague(PERSONID,LEAGUEID) SELECT 10003, 10000 FROM DUAL;
INSERT INTO PersonLeague(PERSONID,LEAGUEID) SELECT 10004, 10001 FROM DUAL;
INSERT INTO PersonLeague(PERSONID,LEAGUEID) SELECT 10005, 10001 FROM DUAL;
INSERT INTO PersonLeague(PERSONID,LEAGUEID) SELECT 10006, 10002 FROM DUAL;
INSERT INTO PersonLeague(PERSONID,LEAGUEID) SELECT 10007, 10002 FROM DUAL;

Commit;