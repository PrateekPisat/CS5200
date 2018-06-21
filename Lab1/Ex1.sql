use bank; -- to use the imported database

-- How many records are there in the table?
select count(*) AS 'TOTAL'
from bank;

-- Replicate your homework 1 program: find the min, max, avg, and number of records for
-- each marital status. Did your results agree with the output of your homework? Was
-- this easier than writing a custom program!?!
select marital, count(*) AS 'TOTAL', min(balance) AS 'MIN', max(balance) AS 'MAX', avg(balance) AS 'AVG'
from bank
group by marital;

-- Modify your query above and further break down the results by both marital status and education
select marital, education, count(*), min(balance), max(balance), avg(balance)
from bank
group by marital, education;

-- What is the average bank balance broken down by job? Sort results in descending order by balance.
select job, avg(balance)
from bank
group by job
order by balance desc;

-- What % of loan applications were approved?
select (count(*) / (select count(*) from bank)) * 100 AS 'APPROVED %'
from bank
where approved = 'yes';

-- Another way

SELECT
 SUM(CASE WHEN approved = 'yes' THEN 1 ELSE 0 END) AS approved,
 SUM(CASE WHEN approved = 'no' THEN 1 ELSE 0 END) AS not_approved
FROM bank;

-- Update
update bank
set bank.contact = null
where bank.contact = '';

-- IN clause
select * from bank
where marital not in('married', 'single'); -- only returns divored

-- distinct
select distinct(job)
from bank
group by job;

-- having -> must be used with an aggregation

select job, avg(age) as 'avga'
from bank
group by job
having avga>45 and job ='retired'
order by job;

-- subselect

select min(avga), max(avga), sum(avga) from
(
select job, avg(age) as 'avga'
from bank
group by job
order by avga desc
)t1;

