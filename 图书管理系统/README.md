```sql
create table user(
    id varchar(20) unique,
    password varchar(20),
    name varchar(20),
    telenumber varchar(15),
    mail varchar(20),
    power varchar(20) default '普通用户'
    );
create table book(
    id int primary key auto_increment,
    name varchar(20) not null,
    author varchar(20) not null,
    price decimal(5,1),

    state varchar(20) default '在馆'
    );
create table borrow(
    student_id varchar(20),
    book_id int
    );
```

