--DECLARE @myid uniqueidentifier
--SET @myid = NEWID()

--insert into dbo.City values
--('8600', 'Silkeborg')

--insert into dbo.AD_USER values
--(newid(), 'Indy', '2021-05-25', 'test@test.dk', 'john', 'hoeg', '+45', '88888888', 'GAY!!!!!', '8600')

--insert into dbo.ADVERTISEMENT values
--(newid(), 'MC', '2021-05-25', 'Motor for Elcykel', 5000, 'SALG', 'Buy mother buy', (select ID from dbo.AD_USER where FIRST_NAME = 'john'))

select * from dbo.AD_USER
select * from dbo.ADVERTISEMENT
select * from dbo.City
select * from dbo.Category
select  category from dbo.ADVERTISEMENT
select category, count(*) as amount from dbo.Category where category is not null group by category
select count(category) as category from dbo.ADVERTISEMENT