use Splitwise;

INSERT INTO `Splitwise`.`Users` 
(`Users_id`, `Name`, `Email`, `Password`, `Budget`, `Phone`, `Hide_Data`) 
VALUES 
(1, 'Prateek Pisat', 'prateekpisat@example.com', 'Password', -1, NULL, 0),
(2, 'Gaurav Bapat', 'gauravbapat@example.com', 'Password', -1, NULL, 0),
(3, 'Harshad Sathaye', 'harshadsathaye@example.com', 'Password', -1, NULL, 0),
(4, 'Rohan Chouthai', 'rohanchouthai@example.com', 'Password', -1, NULL, 0),
(5, 'Indrajeet Mahajan', 'indrajeetmahajan@example.com', 'Password', -1, NULL, 0),
(6, 'Rohan Phadke', 'rohanphadke@example.com', 'Password', -1, NULL, 0);

select * from Users;

update users
set budget = -1
where 1=1;

INSERT INTO `Splitwise`.`Bills` 
(`Bills_id`, `Name`, `Date`, `Description`, `Paid_By`)
VALUES 
(1, 'Stop-n-Shop Groceries', '2018-07-01 03:36:00', 'Groceries I brought at Stop n Shop', 1),
(2, 'Target Groceries', '2018-07-10 03:36:00', 'Groceries I brought at Target', 3);

select * from Bills;

delete from bills where Bills_id in (13);


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

delete from Bill_Items
where Bills_id = 13;

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

select count(Bills_id) as 'Pending Requests'
from Bill_Requests
where To_id=9;

select * 
from Bill_Requests
order by Bills_id;

INSERT INTO `Splitwise`.`Share` 
(`Bills_id`, `Item_id`, `Users_id`) 
VALUES 
(2, 1, 4),
(2, 1, 6),
(2, 2, 4),
(2, 3, 4),
(2, 3, 6),
(2, 4, 3),
(2, 4, 4),
(2, 4, 6),
(1, 1, 1),
(1, 1, 2),
(1, 2, 1),
(1, 2, 2),
(1, 3, 1),
(1, 3, 2),
(1, 4, 1),
(1, 5, 1),
(1, 6, 1),
(1, 6, 2),
(1, 7, 1),
(1, 8, 1),
(1, 9, 1),
(1, 9, 2),
(1, 10, 1),
(1, 11, 1),
(1, 12, 1);

select *
from share
order by Bills_id;

INSERT INTO `Splitwise`.`Ledger` 
(`Bill_id`, `Item_id`, `Amount`) 
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
order by Bill_id, Amount;

