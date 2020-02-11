## Biblioteca Assignment
### ThoughtWorks University


### SQL Database Queries

> Who checked out the book 'The Hobbit'?

```sql
select member.name
from checkout_item
join book on book.id = checkout_item.book_id 
join member on member.id = checkout_item.member_id
where book.title = 'The Hobbit';
```

> How many people have not checked out anything?

```sql
select count(member.id)
from member 
where  member.id not in (
	select checkout_item.member_id
	from checkout_item
);
```
>> or

```sql
select count(member.id)
from member
left join checkout_item on member.id = checkout_item.member_id
where checkout_item.book_id is null and checkout_item.movie_id is null;
```

> What books and movies are not checked out?

```sql
select book.title
from book
left join checkout_item on checkout_item.book_id = book.id
where checkout_item.member_id is null

union 

select movie.title
from movie
left join checkout_item on checkout_item.movie_id = movie.id
where checkout_item.member_id is null;
```

> Add the book 'The Pragmatic Programmer', and add yourself as a member. Check out 'The Pragmatic Programmer'. Use your query from question 1 to verify that you have checked it out. Also, provide the SQL used to update the database.

```sql
insert into book (title) values ('The Pragmatic Programmer');
```

```sql
insert into member (name) values ('Tulio Assis');
```

```sql
insert into checkout_item (member_id, book_id) values (43, 11);
```

```sql
select member.name
from checkout_item
join book on checkout_item.book_id = book.id 
join member on member.id = checkout_item.member_id
where book.title = 'The Pragmatic Programmer';
```
