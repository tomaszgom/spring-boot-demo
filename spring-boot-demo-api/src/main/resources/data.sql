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
(105, 'Chris','Tucker','Chris@cf.com','Developer',60, '333-444-88', 'Somethig about Chris'),
(106, 'Natalie','Portman','Natalie@cf.com','Developer',60, '333-444-88', 'Somethig about Natalie'),
(107, 'Joe','Jones','Joe@cf.com','Developer',60, '333-444-88', 'Somethig about Joe'),
(108, 'Robert','Whittaker','Robert.Whittaker@cf.com','Project Manager',50, '999-555-99', 'Somethig about Robert');


insert into PROJECT_TASK (ID, TEAM_MEMBER_ID, TITLE, DESCRIPTION, STATUS, PRIORITY, DEADLINE_DATE)
values
(1001, 101, 'Analysis 1',	 'Analysis Description 1',	'In progress',	'Medium', PARSEDATETIME('26-Jun-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(1002, 107, 'Analysis 2',	 'Analysis Description 2',	'In progress',	'High', PARSEDATETIME('26-Jun-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(1003, 101, 'Design 1',		 'Design Description 1',	'In progress',	'High', PARSEDATETIME('30-Jun-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(1004, 101, 'Design 2',		 'Design Description 2','Completed','High', PARSEDATETIME('30-Jul-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(1005, 102, 'Developemnt 1', 'Developemnt Description','In progress','Medium', PARSEDATETIME('15-Dec-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(1006, 103, 'Developemnt 2', 'Developemnt Description','Open','Medium', PARSEDATETIME('15-Dec-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(1007, 103, 'Developemnt 3', 'Dev Description','Not Started','High', PARSEDATETIME('30-Jan-2019, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(1008, 103, 'Developemnt 4', 'Dev Description','Not Started','Medium', PARSEDATETIME('30-Feb-2019, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(1009, 105, 'UAT 1',		 'UAT Description','Not Started','Low', PARSEDATETIME('30-Mar-2019, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(1010, 108, 'UAT 2',		 'UAT Description','Not Started','High', PARSEDATETIME('30-Apr-2019, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(1011, 108, 'UAT 3',		 'UAT Description','Not Started','Low', PARSEDATETIME('30-Jun-2019, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en'));


insert into PROJECT_SUB_TASK (ID, PROJECT_TASK_ID, TITLE, DESCRIPTION, STATUS, DEADLINE_DATE)
values
(10001, 1001,'Analysis Sub Task 1','Analysis Description','In progress',PARSEDATETIME('26-Jun-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(10002, 1001,'Analysis Sub Task 2','Analysing Use Case','Completed',PARSEDATETIME('04-Jun-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(10003, 1001,'Analysis Sub Task 3','Analysing Use Case 2','Completed',PARSEDATETIME('04-Jun-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(10004, 1003,'Dev 1 Sub-Task 1','Feature 1 development','Completed',PARSEDATETIME('30-Aug-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(10005, 1003,'Dev 1 Sub-Task 2','Feature 2 development','In progress',PARSEDATETIME('30-Aug-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(10006, 1004,'Dev 2 Sub-Task 1','Feature development 0','Open',PARSEDATETIME('26-Jun-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(10007, 1004,'Dev 2 Sub Task 2','Feature development 1','In progress',PARSEDATETIME('26-Jun-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(10008, 1004,'Dev 2 Sub Task 3','Feature development 2','Completed',PARSEDATETIME('26-Jun-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(10009, 1004,'Dev 2 Sub Task 4','Feature development 3','In progress',PARSEDATETIME('26-Jun-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(10010, 1002,'Design Sub Task-1','Designing stuff','In progress',PARSEDATETIME('26-Jun-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en'));


insert into PROJECT_BUG (ID, TITLE, DESCRIPTION, STATUS, PRIORITY, DEADLINE_DATE)
values
(101,'Bug 1','Bug 1 Description','In progress',	'High', 	PARSEDATETIME('26-Jun-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(102,'Bug 2','Bug 2 Description','Completed',	'High', 	PARSEDATETIME('26-Jun-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(103,'Bug 3','Bug 3 Description','Open',		'Low',		PARSEDATETIME('26-Jun-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(104,'Bug 4','Bug 4 Description','Open',		'Low',		PARSEDATETIME('26-Jun-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en')),
(105,'Bug 5','Bug 5 Description','In progress',	'Medium',	PARSEDATETIME('26-Jun-2018, 00:00:00 AM','dd-MMM-yyyy, hh:mm:ss a','en'));


