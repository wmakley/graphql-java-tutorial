create table user
(
    id                integer primary key,
    full_name         varchar(255),
    email             varchar(255),
    gender            varchar(100),
    dob               varchar(20),
    present_address   varchar(255),
    permanent_address varchar(255)
);

create table post (
    id integer primary key,
    title varchar(255),
    description varchar(255),
    published_date varchar(20),
    user_id integer not null
);
