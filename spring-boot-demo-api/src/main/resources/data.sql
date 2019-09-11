insert into CLIENT_REQUEST (ID, FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, POSTAL_ADDRESS, PHONE, CONTACT_PURPOSE)
values
(101, 'Bill','Murray','Bill.Murray@cf.com','Address 1','333-444-55','Comment 1'),
(102, 'Julia','Roberts','Julia.Roberts@cf.com','Address 2','444-555-66','Comment 2'),
(103, 'Chuck','Norris','Chuck.Norris@cf.com','Address 3','333-444-88','Comment 3'),
(104, 'Robert','Whittaker','Robert.Whittaker@cf.com','Address 3','333-444-88','Comment 3'),
(105, 'Jane','Jones','jane@cf.com','Address 4','999-555-99','Comment 4');


insert into TEAM_MEMBER (ID, FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, POSITION, POINTS, PHONE, NOTE)
values
(101, 'Bill','Murray','Bill.Murray@cf.com','Project Manager',100, '333-444-55', 'Somethig about Bill'),
(102, 'Julia','Roberts','Julia.Roberts@cf.com','Business Analyst',100, '444-555-66', 'Somethig about Julia'),
(103, 'Chuck','Norris','Chuck.Norris@cf.com','Developer',500, '333-444-88', 'Somethig about Chuck'),
(104, 'Jane','Jones','jane@cf.com','Developer',60, '333-444-88', 'Somethig about Jane'),
(105, 'Robert','Whittaker','Robert.Whittaker@cf.com','Project Manager',50, '999-555-99', 'Somethig about Robert');


insert into PROJECT_TASK (ID, TITLE, DESCRIPTION, STATUS, PRIORITY, DEADLINE_DATE)
values
(1001,'Analysis 1','Analysis Description','In progress','Medium', PARSEDATETIME('26-Jun-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(1002,'Design 1','Design Description','Completed','Medium', PARSEDATETIME('30-Jul-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(1003,'Developemnt 1','Developemnt Description','In progress','Medium', PARSEDATETIME('15-Dec-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(1004,'Developemnt 2','Developemnt Description','Open','Medium', PARSEDATETIME('15-Dec-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(1005,'Testing 1','Testing Description','Not Started','Medium', PARSEDATETIME('30-Jan-2019, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en'));


insert into PROJECT_SUB_TASK (ID, PROJECT_TASK_ID, TITLE, DESCRIPTION, STATUS, DEADLINE_DATE)
values
(10001, 1001,'Analysis Sub Task 1','Analysis  Sub Task 1 Description','In progress',PARSEDATETIME('26-Jun-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(10002, 1001,'Analysis Sub Task 2','Analysis  Sub Task 2 Description','Completed',PARSEDATETIME('04-Jun-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(10003, 1003,'Developemnt 1 Sub Task 1','Developemnt 1  Sub Task 1 Description','Completed',PARSEDATETIME('30-Aug-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(10004, 1003,'Developemnt 1 Sub Task 2','Developemnt 1  Sub Task 1 Description','In progress',PARSEDATETIME('30-Aug-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(10005, 1004,'Analysis Sub Task 1','Analysis  Sub Task 1 Description','In progress',PARSEDATETIME('26-Jun-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(10006, 1004,'Analysis Sub Task 2','Analysis  Sub Task 2 Description','In progress',PARSEDATETIME('26-Jun-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en'));

insert into PROJECT_BUG (ID, TITLE, DESCRIPTION, STATUS, PRIORITY, DEADLINE_DATE)
values
(101,'Bug 1','Bug 1 Description','In progress',	'High', 	PARSEDATETIME('26-Jun-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(102,'Bug 2','Bug 2 Description','Completed',	'High', 	PARSEDATETIME('26-Jun-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(103,'Bug 3','Bug 3 Description','Open',		'Low',		PARSEDATETIME('26-Jun-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(104,'Bug 4','Bug 4 Description','Open',		'Low',		PARSEDATETIME('26-Jun-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(105,'Bug 5','Bug 5 Description','In progress',	'Medium',	PARSEDATETIME('26-Jun-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en'));


