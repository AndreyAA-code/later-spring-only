drop table if exists items;
drop table if exists users;

     create table if not exists items (
         id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
         user_id BIGINT,
         url VARCHAR
     );

    create table if not exists users (
        id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
        email VARCHAR UNIQUE,
        name VARCHAR
    );