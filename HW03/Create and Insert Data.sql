-- ---------------------------------------------------
-- Inserts into Users
-- ---------------------------------------------------

INSERT INTO `Twitter`.`Users` (`user_id`, `name`, `email`, `password`, `is_person`, `handle`, `discription`, `is_hidden`) 
VALUES 
(1, 'Prateek Pisat', 'prateekpisat@example.com', 'Password', 1, '@prateekpisat', NULL, 0),
(2, 'Tanvi Pisat', 'tanvipisat@example.com', 'Password', 1, '@tanvipisat', NULL, 0),
(3, 'Samir Pisat', 'samirpisat@example.com', 'Password', 1, '@samirpisat', NULL, 0),
(4, 'Pradnya Pisat', 'pradnyapisat@example.com', 'Password', 1, '@pradnyapisat', NULL, 0),
(5, 'Alice', 'alice@example.com', 'Passowrd', 1, '@alice', NULL, 0),
(6, 'Bob', 'bob@example.com', 'Password', 1, '@bob', NULL, 0),
(7, 'Carol', 'carol@example.com', 'Password', 1, '@carol', NULL, 0),
(8, 'David', 'david@example.com', 'Password', 1, '@david', NULL, 0),
(9, 'Eric', 'eric@example.com', 'Password', 0, '@eric', NULL, 1),
(10, 'Google', 'google@example.com', 'Password', 0, '@google', "We are google", 0),
(11, 'Apple', 'apple@example.com', 'Password', 0, '@apple', "We are apple", 0),
(12, 'Amazon', 'amazon@example.com', 'Password', 0, '@amazon', "We are amazon", 0),
(13, 'Microsoft', 'microsoft@example.com', 'Password', 0, '@microsoft', "We are microsof", 0),
(14, 'Salesforce', 'salesforce@example.com', 'Password', 0, '@salesforce', "We are salesforce", 0),
(15, 'CICCDA3301', 'ciccada@example.com', '!>@$$\/\/Or|>', 0, '@1231507051321', '- .... .. ... / .. ... / -.-. .. -.-. -.-. .- -.. .- ...-- ...-- ----- .----', 1),
(16, 'John Cena', 'jcena@example.com', 'Password', 0, '@JohnCena', 'You Can\'t see me', 1);

 select * from Users;
 
 delete from users where handle = "@bob";
 
-- ---------------------------------------------------
-- Inserts into Tweets
-- ---------------------------------------------------

INSERT INTO `Twitter`.`Tweets` (`tweet_id`, `post`, `user_id`, `timestamp`)
VALUES 
 (1, 'Hey, This is Prateek #iamnewhere', 1, now()),
(2, 'Hey, This is Tanvi #hello', 2, now()),
(3, 'Hey, This is Samir #hey', 3, now()),
(4, 'Hey, This is Pradnya #iamnewhere', 4, now()),
(5, 'Hey, This is Alice #iamnewhere', 5, now()),
(6, 'Hey, This is Bob #hello', 6, now()),
(7, 'Hey, This is Carol #hey', 7, now()),
(8, 'Hey, This is David #hello', 8, now()),
(9, 'Hey, This is Eric #hello', 9, now()),
(10, 'This is cool #wow', 1, now()),
(11, 'Wow #wow', 2, now()),
(12, 'Tacos! #tacotuesday', 3, now()),
(13, 'Still new #iamnewhere', 4, now()),
(14, 'Hello, Google #saynotosiri #saynotoalexa', 10, NOW() - INTERVAL 1 DAY),
(15, 'Apple!', 11, NOW() - INTERVAL 6 DAY),
(16, 'We killed toy\'s r us #sad', 12, NOW() - INTERVAL 23 DAY),
(17, 'Windows Phone, haven\'t heard that name in years #meme', 13, NOW() - INTERVAL 14 DAY),
(18, 'Were ranked higer than google, #wow #amaze', 14, NOW() - INTERVAL 29 DAY),
(19, 'There is a message hidden in this tweet, Find it and it will lead you on the road to finding us.', 15, NOW() - INTERVAL 13 DAY),
(20, 'Can you see me? #nope', 16, NOW() - INTERVAL 3 DAY),
(21, 'Look at this old picture of me my mom found, #tbt #nofilter', 5, NOW() ),
(22, '13 degrees(celcius) in June? #whyisitstillcold #whereissummer', 6, NOW()),
(23, 'All we need is #love', 7, NOW()),
(24, 'asjdbkadkasdjvasd #asd', 8, NOW()),
(25, 'I need to #travel', 9, NOW() - INTERVAL 8 DAY),
(26, 'I need to #amaze', 9, NOW() - INTERVAL 7 DAY),
(27, 'This shouild not appear', 10, '2018-05-01 16:04:47');

select * from tweets;

insert into `Twitter`.`Tweets` (`tweet_id`, `post`, `user_id`, `timestamp`)
values
(26, 'Hey, This is Tanvi #iamnewhere', 2, now());
-- ---------------------------------------------------
-- Inserts into Hashtags
-- ---------------------------------------------------

INSERT INTO `Twitter`.`Hashtag` (`hash_id`, `name`) 
VALUES 
(1, '#iamhewnere'),
(2, '#hello'),
(3, '#hey'),
(4, '#wow'),
(5, '#tacotuesday'),
(6, '#tbt'),
(7, '#sad'),
(8, '#whyisitstillcold'),
(9, '#whereissummer'),
(10, '#love'),
(11, '#nofilter'),
(12, '#travel'),
(13, '#asd'),
(14, '#saynotosiri'),
(15, '#saynotoalexa'),
(16, '#meme'),
(17, '#amaze'),
(18, '#nope');

select * from hashtag;


-- ---------------------------------------------------
-- Inserts into hashtags_in_tweets
-- ---------------------------------------------------

INSERT INTO `Twitter`.`Hashtags_in_tweets` (`hash_id`, `tweet_id`) 
VALUES 
(1, 1),
(2, 2),
(3, 3),
(1, 4),
(1, 5),
(2, 6),
(3, 7),
(2, 8),
(2, 9),
(4, 10),
(4, 11),
(5, 12),
(1,13),
(14,14),
(15,14),
(7,16),
(17,18),
(4,18),
(18,20),
(6,21),
(11,21),
(8,22),
(9,22),
(10,23),
(13,24),
(12,25),
(17,26),
(16,17);

select * from hashtags_in_tweets;

INSERT INTO `Twitter`.`Hashtags_in_tweets` (`hash_id`, `tweet_id`) 
VALUES
(1, 26);
-- ---------------------------------------------------
-- Inserts into follows
-- ---------------------------------------------------

INSERT INTO `Twitter`.`Follows` (`Follower_id`, `Followee_id`) 
VALUES 
(1, 2),
(1, 3),
(1, 4),
(2, 1),
(2, 3),
(2, 4),
(3, 1),
(3, 2),
(3, 4),
(4, 1),
(4, 2),
(4, 3),
(1, 10),
(1, 11),
(1, 12),
(1, 13),
(1, 14),
(1, 15),
(1, 16),
(15, 1);

select * from follows;

-- ---------------------------------------------------
-- Inserts into Interest
-- ---------------------------------------------------

INSERT INTO `Twitter`.`interests` (`user_id`, `hash_id`) 
VALUES 
(1, 6),
(1, 11),
(2, 1),
(2, 8),
(3, 11),
(3, 12),
(4, 2),
(4, 3),
(5, 7),
(5, 8),
(6, 10),
(1, 14),
(1, 15),
(1, 16),
(1, 17),
(1, 18),
(2, 14);

select * from `interests`;

-- ---------------------------------------------------
-- Inserts into Likes
-- ---------------------------------------------------

INSERT INTO `Twitter`.`Likes` (`user_id`, `tweet_id`) 
VALUES 
(1, 12),
(2, 11),
(3, 10),
(4, 9),
(5, 8),
(6, 7),
(7, 6),
(8, 5),
(9, 4),
(1, 3),
(2, 2);

delete from likes where tweet_id in(6, 22);
select * from Likes;

