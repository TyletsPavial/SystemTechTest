--1 - Получить количество неактивных (не было сессий) клиентов
select count(1) from Users where userId not in (select distinct userId from UserSessions);
--2 - Получить список уникальных UserId активных пользователей, которые не пользовались каналом 1
select distinct userId from UserSessions where userID not in (select distinct userId from UserSessions where channeltype = 1);
--3 - Получить максимальное UserId активного пользователя, статус которого также не равен 1
select max(userId) from UserSessions us join Users u on u.userId = us.userId where u.status != 1;
--4 - Получить список количества сессий с разделением на MobAppVersion. То есть список, сгруппированный по MobAppVersion,
-- в котором для каждой из MobAppVersion будет подсчитано количество сессий со "старой" mobosversion,
-- "старой" версией считается версия ниже 80 или неуказанная
select count(1), mobAppVersion from UserSessions where mobOSVersion < 80 or mobOSVersion is null group by mobAppVersion;