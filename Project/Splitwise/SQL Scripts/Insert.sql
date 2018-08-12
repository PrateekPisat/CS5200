use Splitwise;

INSERT INTO `Splitwise`.`Users` 
(`Users_id`, `Name`, `Email`, `Password`, `Budget`, `Phone`) 
VALUES 
(1, 'Alice', 'alice@example.com', 'Password', -1, NULL),
(2, 'Bob', 'bob@example.com', 'Password', -1, NULL),
(3, 'Carol', 'carol@example.com', 'Password', -1, NULL),
(4, 'David', 'david@example.com', 'Password', -1, NULL),
(5, 'Eric', 'eric@example.com', 'Password', -1, NULL),
(6, 'Frank', 'frank@example.com', 'Password', -1, NULL);

select * from Users;

/*

INSERT INTO `Splitwise`.`Bills` 
(`Bills_id`, `Name`, `Date`, `Description`, `Paid_By`)
VALUES 
(1, 'Stop-n-Shop Groceries', '2018-07-01 03:36:00', 'Groceries I brought at Stop n Shop', 1),
(2, 'Target Groceries', '2018-07-10 03:36:00', 'Groceries I brought at Target', 3);

select * from Bills;

delete from bills where 1=1;

INSERT INTO `Splitwise`.`Bill_Items` 
(`Item_id`, `Bills_id`, `Name`, `Cost`) 
VALUES 
(1, 1, 'Bread', 5.83),
(2, 1, 'Milk', 4.89),
(3, 1, 'Cheese', 5.49),
(4, 1, 'Eggs', 5.29),
(5, 1, 'Pita Bread', 5.83),
(6, 1, 'Chicken Patty', 10.00),
(7, 1, 'Chicken Thighs', 4.78),
(8, 1, 'Ground Chicken', 3.99),
(9, 1, 'Bell Peppers', 8.66),
(10, 1, 'Mushrooms', 2.99),
(11, 1, 'Tomato', 6.27),
(12, 1, 'Lettuce', 1.69),
(1, 2, 'Bread', 8.07),
(2, 2, 'Peas', 4.77),
(3, 2, 'Rat Traps', 9.98),
(4, 2, 'Tomatoes', 3.36);

select * 
from Bill_Items
order by Bills_id;

INSERT INTO `Splitwise`.`Bill_Requests` 
(`To_id`, `Bills_id`) 
VALUES 
(3, 2),
(4, 2),
(6, 2),
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1);

select * 
from Bill_Requests
order by Bills_id;

INSERT INTO `Splitwise`.`Share` 
(`Bills_id`, `Item_id`, `Users_id`, `Is_Paid`) 
VALUES 
(2, 1, 4, 0),
(2, 1, 6, 0),
(2, 2, 4, 0),
(2, 3, 4, 0),
(2, 3, 6, 0),
(2, 4, 3, 0),
(2, 4, 4, 0),
(2, 4, 6, 0),
(1, 1, 1, 0),
(1, 1, 2, 0),
(1, 2, 1, 0),
(1, 2, 2, 0),
(1, 3, 1, 0),
(1, 3, 2, 0),
(1, 4, 1, 0),
(1, 5, 1, 0),
(1, 6, 1, 0),
(1, 6, 2, 0),
(1, 7, 1, 0),
(1, 8, 1, 0),
(1, 9, 1, 0),
(1, 9, 2, 0),
(1, 10, 1, 0),
(1, 11, 1, 0),
(1, 12, 1, 0);

select *
from share
order by Users_id;

INSERT INTO `Splitwise`.`Ledger` 
(`Bills_id`, `Item_id`, `Amount`) 
VALUES 
(1, 1, 1.94),
(1, 4, 2.64),
(1, 5, 1.00),
(1, 6, 3.33),
(1, 7, 2.39),
(1, 8, 2.00),
(1, 9, 2.88),
(1, 10, 1.94),
(1, 11, 3.13),
(1, 12, 8.84);


select *
from ledger
order by Bills_id, Amount;
*/

select count(Bills_id)
from
(
	select distinct(Bills_id)
	from bills join share using(bills_id) join bill_requests using(bills_id)
	where (Users_id = 2 and Paid_By = 1) OR (Paid_By = 1 and To_id = 2)
) as t1 join bill_requests using(Bills_id);

select * from bills;
select * from bill_requests;