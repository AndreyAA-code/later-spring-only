drop table if exists items;
drop table if exists users;
drop table if exists tags;

     create table if not exists items (
         id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
         user_id BIGINT,
         url VARCHAR
     );

    create table if not exists users (
        id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
        email VARCHAR UNIQUE,
        first_name VARCHAR,
        last_name VARCHAR,
        registration_date BIGINT,
        user_state VARCHAR CHECK (user_state IN ('ACTIVE', 'BLOCKED', 'DELETED'))
    );

    create table if not exists tags (
        name VARCHAR,
        item_id BIGINT references items(id)
    );