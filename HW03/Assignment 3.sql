-- ---------------------------------------------------
-- Part 3: Validation
-- ---------------------------------------------------

use twitter;

-- Q1. For each user, count the number of followers. Don’t include followers with a hidden 
--     profile. Rank in descending order by the number of followers.

select name, Followers
from
(
	select followee_id, count(follower_id) as 'Followers'
	from follows inner join users on (follower_id = users.user_id)
	where users.is_hidden = 0
	group by followee_id
) as t1 inner join users on (users.user_id = Followee_id)
order by Followers desc, name;


-- Q2. For one user, list the five most recent tweets by any other user that your chosen user
--     follows. (This is known as the user’s “home timeline.”)
select post as 'Tweets', handle
from
(
	select followee_id
	from follows
	where follower_id = 1
) as t1 join tweets on (tweets.user_id = t1.followee_id) join users on (users.user_id = tweets.user_id)
order by tweets.timestamp desc, name
limit 5;

-- Q3. What are the most popular “trending” hashtags by organizations over the last 30 days?
select name as 'Top_10_Trending_Hashtags_of_the_month'
from
(
	select hash_id, count(tweets.tweet_id) as 'Uses'
	from hashtags_in_tweets join tweets on (tweets.tweet_id = hashtags_in_tweets.tweet_id) 
							join users on (tweets.user_id = users.user_id)
	 where tweets.timestamp between date_sub(now(), interval 30 day) and now() 
		  and users.is_person = 0
	group by hash_id
	limit 10
) as t1, hashtag
where t1.hash_id = hashtag.hash_id
order by Uses desc,Top_10_Trending_Hashtags_of_the_month;

-- Q4. If I was trying to find recommendations of users that I should follow I might ask Twitter
--     to find me the following: Show me users that post tweets containing hashtags that
--     match my interests. Rank candidate users by the number of tweets they have posted
--     containing one or more of my interests
select name
from 
(
	select hashtags_in_tweets.tweet_id as 'T_id'
	from 
	(
		select hash_id
		from `interests`
		where user_id = 2
	) as t1, hashtags_in_tweets
	where t1.hash_id = hashtags_in_tweets.hash_id
) as t2, users, tweets
where tweets.tweet_id = T_id and tweets.user_id = users.user_id
group by tweets.user_id
order by count(tweets.tweet_id) desc, name;


-- Q5. Pick a user. Find all the people / organizations followed by that user. (We call these the
--     followees of that user – not to be confused with the followers of that user – the
--     followers of the user all have the user as a followee!) So if Ann follows Bob, Ann is Bob’s
--     follower and Bob is Ann’s followee. NOW that we have all the followees of a user, find
--     all of the people / organizations that the followees follow – i.e., the followees of the
--     followees. For full credit, count the number of times that each followee appears in the
--     list.
select name as 'Followers_of_Followers', count(*) as 'Occourences'
from
(
	select followee_id as 'Followees'
	from follows
	where follower_id = 1
)as t1, follows, users
where follows.Follower_id = Followees  and Followee_id = users.user_id
group by Followers_of_Followers;

