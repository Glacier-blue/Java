```sql
create table user(
    id varchar(20) unique,
    name varchar(20),
    telenumber varchar(15),
    mail varchar(20),
    power varchar(20)
    );
create table book(
    id primary key auto_increment,
    name varchar(20) not null,
    author varchar(20) not null,
    price decimal(5,1),
    type varchar(20),
    state varchar(20) dafault '在馆'
    );
create table borrow(
    student_id varchar(20),
    book_id int unique
    );
```

